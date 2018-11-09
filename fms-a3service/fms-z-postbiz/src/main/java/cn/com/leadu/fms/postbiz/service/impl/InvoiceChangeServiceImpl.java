package cn.com.leadu.fms.postbiz.service.impl;

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.REFUSE;
import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SENDBACK;
import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SUBMIT;

import cn.com.leadu.fms.business.common.util.activiti.ActInvoiceChangeUtils;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.cost.PaymentStsEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.SolveTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.InvoiceChangeRepository;
import cn.com.leadu.fms.data.postbiz.repository.InvoiceChangeTaskRepository;
import cn.com.leadu.fms.data.prebiz.repository.CrmCompanyRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceChange;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceChangeTask;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.InvoiceChangePostVo;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.InvoiceChangeSearchVo;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.InvoiceChangeVo;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.entity.CrmCompany;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.InvoiceChangeService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * @author lijunjun
 * @ClassName: InvoiceChangeService
 * @Description: 开票信息变更业务实现层
 * @date 2018-08-29
 */
@Service
@Slf4j
public class InvoiceChangeServiceImpl implements InvoiceChangeService {

    /**
     * @Fields  : 开票信息变更repository
     */
    @Autowired
    private InvoiceChangeRepository invoiceChangeRepository;
    @Autowired
    private CrmCompanyRepository crmCompanyRepository;
    @Autowired
    private NumGenerateService numGenerateService;
    @Autowired
    private InvoiceChangeTaskRepository invoiceChangeTaskRepository;
    @Autowired
    private BizFilesService bizFilesService;
    @Autowired
    private WorkflowLogService workflowLogService;

    /**
     * @Title:
     * @Description: 保存开票信息变更
     * @param invoiceChangePostVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:21
     */
    @Override
    @Transactional
    public void saveInvoiceChange(InvoiceChangePostVo invoiceChangePostVo, SysUser sysUser){

        if (StringUtils.isNotTrimBlank(invoiceChangePostVo.getTaskId())){
            //退回重新发起
            //开启工作流
            ActRuTaskVo actRuTaskVo = ActInvoiceChangeUtils.approvalAgree(invoiceChangePostVo.getTaskId());
            //更新开票任务表
            updateInvoiceChangeTask(invoiceChangePostVo, actRuTaskVo);

            //更新开票信息变更表
            invoiceChangeRepository.updateByPrimaryKeySelectiveData(invoiceChangePostVo.getNewInvoiceChangeVo().getEntity());

            //保存附件信息
            bizFilesService.modifyBizFilesList(invoiceChangePostVo.getBizFilesList(),invoiceChangePostVo.getInvoiceTaskNo(),
                    BizCodeTypeEnums.INVOICE_CHANGE_FILE.getCodeType());

            //保存工作流日志
            saveWorkFlowLog(sysUser.getUser(), SUBMIT.getType(), invoiceChangePostVo.getInvoiceTaskNo()
                    , invoiceChangePostVo.getNewInvoiceChangeVo().getRemark(), actRuTaskVo.getTaskCode());
        } else {
            //首次发起
            checkInvoiceChange(invoiceChangePostVo.getNewInvoiceChangeVo());//校验是否存在进行中的任务
            //生成变更任务号
            String invoiceTaskNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.INVOICE_CHANGE.getType());

            Map<String, Object> paramVariables = new HashedMap();
            paramVariables.put("invoiceTaskNo", invoiceTaskNo);
            paramVariables.put("socialCertifNo", invoiceChangePostVo.getNewInvoiceChangeVo().getSocialCertifNo());
            //开启工作流
            ActRuTaskVo actRuTaskVo = ActInvoiceChangeUtils.startInvoiceChangeApply(invoiceTaskNo
                    , invoiceChangePostVo.getNewInvoiceChangeVo().getName(), paramVariables);

            // 登录开票变更任务表
            insertInvoiceChangeTask(invoiceChangePostVo, sysUser, invoiceTaskNo, actRuTaskVo);
            // 登录开票变更信息表
            insertInvoiceChange(invoiceChangePostVo, invoiceTaskNo);

            //保存附件信息
            bizFilesService.modifyBizFilesList(invoiceChangePostVo.getBizFilesList(),invoiceTaskNo,
                    BizCodeTypeEnums.INVOICE_CHANGE_FILE.getCodeType());

            //保存工作流日志
            saveWorkFlowLog(sysUser.getUser(), SUBMIT.getType(), invoiceTaskNo
                    , invoiceChangePostVo.getNewInvoiceChangeVo().getRemark(), actRuTaskVo.getTaskCode());
        }
    }

    /**
     * 登录开票信息变更表
     * @param invoiceChangePostVo
     * @param invoiceTaskNo
     */
    private void insertInvoiceChange(InvoiceChangePostVo invoiceChangePostVo, String invoiceTaskNo) {
        // 构造需要插入的开票信息变更List
        List<InvoiceChange> invoiceChangeList = new ArrayList<>();
        // 构造变更前开票信息
        InvoiceChange oldInvoiceChange = new InvoiceChange();
        // 构造变更后开票信息
        InvoiceChange newInvoiceChange = new InvoiceChange();
        BeanUtils.copyProperties(invoiceChangePostVo.getOldInvoiceChangeVo(), oldInvoiceChange);//变更前数据映射
        BeanUtils.copyProperties(invoiceChangePostVo.getNewInvoiceChangeVo(), newInvoiceChange);//变更后数据映射
        oldInvoiceChange.setSolveType(SolveTypeEnums.BEFORE_MODIFY.getType());//数据类型：变更前
        oldInvoiceChange.setInvoiceTaskNo(invoiceTaskNo);//变更任务号
        invoiceChangeList.add(oldInvoiceChange);

        newInvoiceChange.setSolveType(SolveTypeEnums.AFTER_MODIFY.getType());//数据类型：变更后
        newInvoiceChange.setInvoiceTaskNo(invoiceTaskNo);//变更任务号
        invoiceChangeList.add(newInvoiceChange);
        //登录开票信息变更表
        if (ArrayUtils.isNotNullAndLengthNotZero(invoiceChangeList)){
            invoiceChangeRepository.insertDataList(invoiceChangeList);
        }
    }

    /**
     * 登录开票任务表
     * @param invoiceChangePostVo
     * @param sysUser
     * @param invoiceTaskNo
     * @param actRuTaskVo
     */
    private void insertInvoiceChangeTask(InvoiceChangePostVo invoiceChangePostVo, SysUser sysUser, String invoiceTaskNo, ActRuTaskVo actRuTaskVo) {
        InvoiceChangeTask invoiceChangeTask = new InvoiceChangeTask();
        invoiceChangeTask.setInvoiceTaskNo(invoiceTaskNo);//任务号
        invoiceChangeTask.setInvoiceTaskStatus(actRuTaskVo.getTaskCode());//任务状态
        invoiceChangeTask.setSocialCertifNo(invoiceChangePostVo.getNewInvoiceChangeVo().getSocialCertifNo());//统一社会信用编号
        invoiceChangeTask.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点用户
        invoiceChangeTask.setSubmitUser(sysUser.getUser());//任务提交人
        invoiceChangeTask.setSubmitDate(DateUtils.getNowDate());//任务提交时间
        invoiceChangeTask.setRemark(invoiceChangePostVo.getRemark());//备注
        //登录开票任务表
        invoiceChangeTaskRepository.insertData(invoiceChangeTask);
    }

    /**
     * 更新开票信息变更任务表
     * @param invoiceChangePostVo
     * @param actRuTaskVo
     */
    private void updateInvoiceChangeTask(InvoiceChangePostVo invoiceChangePostVo, ActRuTaskVo actRuTaskVo) {
        // 初始化开票变更任务表Example
        Example example = SqlUtil.newExample(InvoiceChangeTask.class);
        example.createCriteria().andEqualTo("invoiceTaskNo", invoiceChangePostVo.getInvoiceTaskNo());
        InvoiceChangeTask invoiceChangeTask = invoiceChangeTaskRepository.selectOneByExample(example);
        if (invoiceChangeTask == null){
            throw new FmsServiceException("开票任务数据不存在");
        }
        invoiceChangeTask.setInvoiceTaskStatus(actRuTaskVo.getTaskCode());//设定开票任务状态
        invoiceChangeTask.setPresentUser(actRuTaskVo.getNextAssignee());//设定下一节点操作用户
        //更新开票信息变更任务表
        invoiceChangeTaskRepository.updateByPrimaryKeySelectiveData(invoiceChangeTask);
    }

    /**
     * @Title:
     * @Description: 根据applyNo查询开票基本信息
     * @param invoiceChangeVo
     * @return InvoiceChangeVo
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public InvoiceChangePostVo findApplyInvoiceVosBySocialCertifNo(InvoiceChangeVo invoiceChangeVo) {
        InvoiceChangePostVo invoiceChangePostVo = new InvoiceChangePostVo();
        if (StringUtils.isNotTrimBlank(invoiceChangeVo.getInvoiceTaskNo())){
            //审核退回
            invoiceChangePostVo = findInvoiceChangeVosByInvoiceTaskNo(invoiceChangeVo.getInvoiceTaskNo());
        } else {
            //初次提交
            if (StringUtils.isTrimBlank(invoiceChangeVo.getSocialCertifNo())){
                throw new FmsServiceException("参数不正确");
            }
            // 检索变更前开票信息
            InvoiceChangeVo invoiceChangeVoResult =  invoiceChangeRepository.selectApplyInvoiceVosBySocialCertifNo(invoiceChangeVo.getSocialCertifNo());
            //变更前与变更后一致
            invoiceChangePostVo.setOldInvoiceChangeVo(invoiceChangeVoResult);
            invoiceChangePostVo.setNewInvoiceChangeVo(invoiceChangeVoResult);
        }
        return invoiceChangePostVo;
    }

    /**
     * @Title:
     * @Description: 根据applyNo查询开票变更前后信息
     * @param invoiceTaskNo
     * @return InvoiceChangeVo
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public InvoiceChangePostVo findInvoiceChangeVosByInvoiceTaskNo(String invoiceTaskNo) {
        if (StringUtils.isTrimBlank(invoiceTaskNo)){
            throw new FmsServiceException("参数不正确");
        }
        // 初始化返回前台变更前后实体Vo
        InvoiceChangePostVo invoiceChangePostVo = new InvoiceChangePostVo();
        // 检索开票变更前后信息List
        List<InvoiceChangeVo> invoiceChangeVoList = invoiceChangeRepository.selectInvoiceChangeVosByInvoiceTaskNo(invoiceTaskNo);
        if (ArrayUtils.isNotNullAndLengthNotZero(invoiceChangeVoList)){
            for (InvoiceChangeVo invoiceChangeVo : invoiceChangeVoList){
                if (StringUtils.equals(invoiceChangeVo.getSolveType(), SolveTypeEnums.BEFORE_MODIFY.getType())){
                    invoiceChangePostVo.setOldInvoiceChangeVo(invoiceChangeVo);//设定变更前数据
                }
                if (StringUtils.equals(invoiceChangeVo.getSolveType(), SolveTypeEnums.AFTER_MODIFY.getType())){
                    invoiceChangePostVo.setNewInvoiceChangeVo(invoiceChangeVo);//设定变更后数据
                }
            }
        }

        //获取提交的附件
        List<BizFiles> bizFilesList = bizFilesService.findBizFilesList(invoiceTaskNo, BizCodeTypeEnums.INVOICE_CHANGE_FILE.getCodeType());
        invoiceChangePostVo.setBizFilesList(bizFilesList);
        return invoiceChangePostVo;
    }

    /**
     * @Title:
     * @Description: 开票信息变更审核通过
     * @param invoiceChangePostVo
     * @param sysUser
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:21
     */
    @Override
    @Transactional
    public void invoiceChangeApproval(InvoiceChangePostVo invoiceChangePostVo, SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = ActInvoiceChangeUtils.approvalAgree(invoiceChangePostVo.getTaskId());
        // 更新开票变更任务表
        updateInvoiceChangeTask(invoiceChangePostVo, actRuTaskVo);

        //更新客户基本信息表
        updateCstmCompany(invoiceChangePostVo, sysUser);

        // 更新Crm信息表
        updateCrmCompany(invoiceChangePostVo);
        //保存工作流日志
        saveWorkFlowLog(sysUser.getUser(), SUBMIT.getType(), invoiceChangePostVo.getInvoiceTaskNo()
                , invoiceChangePostVo.getNewInvoiceChangeVo().getRemark(), actRuTaskVo.getTaskCode());
    }

    /**
     * 更新企业基本信息
     * @param invoiceChangePostVo
     * @param sysUser
     */
    private void updateCstmCompany(InvoiceChangePostVo invoiceChangePostVo, SysUser sysUser) {
        // 初始化更新客户基本信息检索Vo
        InvoiceChangeSearchVo invoiceChangeSearchVo = new InvoiceChangeSearchVo();
        BeanUtils.copyProperties(invoiceChangePostVo.getNewInvoiceChangeVo(), invoiceChangeSearchVo);//检索项映射
        invoiceChangeSearchVo.setPaymentSts(PaymentStsEnums.UNCLEARED.getType());//付款状态：未结清
        invoiceChangeSearchVo.setUser(sysUser.getUser());//设定当前操作用户
        invoiceChangeSearchVo.setDate(DateUtils.getNowDate());//设定当前操作时间
        // 更新企业基本信息
        invoiceChangeRepository.updateCstmCompany(invoiceChangeSearchVo);
    }

    /**
     * 更新crm企业信息
     * @param invoiceChangePostVo
     */
    private void updateCrmCompany(InvoiceChangePostVo invoiceChangePostVo) {
        // 初始化Crm企业信息Example
        Example example = SqlUtil.newExample(CrmCompany.class);
        example.createCriteria().andEqualTo("socialCertifNo", invoiceChangePostVo.getNewInvoiceChangeVo().getSocialCertifNo());
        // 初始化Crm企业信息
        CrmCompany crmCompany = new CrmCompany();
        BeanUtils.copyProperties(invoiceChangePostVo.getNewInvoiceChangeVo(), crmCompany);//变更后数据映射
        //更新crm企业信息
        crmCompanyRepository.updateByExampleSelectiveData(crmCompany, example);
    }

    /**
     * @Title:
     * @Description: 开票信息变更审核退回
     * @param invoiceChangePostVo
     * @param sysUser
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:21
     */
    @Override
    @Transactional
    public void invoiceChangeBackApply(InvoiceChangePostVo invoiceChangePostVo, SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = ActInvoiceChangeUtils.approvalReturnSuperior(invoiceChangePostVo.getTaskId());
        // 更新开票变更任务表
        updateInvoiceChangeTask(invoiceChangePostVo, actRuTaskVo);

        //保存工作流日志
        saveWorkFlowLog(sysUser.getUser(), SENDBACK.getType(), invoiceChangePostVo.getInvoiceTaskNo()
                , invoiceChangePostVo.getNewInvoiceChangeVo().getRemark(), actRuTaskVo.getTaskCode());

    }

    /**
     * @Title:
     * @Description: 开票信息变更审核拒绝
     * @param invoiceChangePostVo
     * @param sysUser
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:21
     */
    @Override
    public void invoiceChangeRefuse(InvoiceChangePostVo invoiceChangePostVo, SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = ActInvoiceChangeUtils.approvalRefuse(invoiceChangePostVo.getTaskId());
        // 更新开票变更任务表
        updateInvoiceChangeTaskAtRefuse(invoiceChangePostVo, actRuTaskVo);

        //保存工作流日志
        saveWorkFlowLog(sysUser.getUser(), REFUSE.getType(), invoiceChangePostVo.getInvoiceTaskNo()
                , invoiceChangePostVo.getNewInvoiceChangeVo().getRemark(), actRuTaskVo.getTaskCode());
    }

    /**
     * 更新开票变更任务表
     * @param invoiceChangePostVo
     * @param actRuTaskVo
     */
    private void updateInvoiceChangeTaskAtRefuse(InvoiceChangePostVo invoiceChangePostVo, ActRuTaskVo actRuTaskVo) {
        // 初始化开票变更任务Example
        Example example = SqlUtil.newExample(InvoiceChangeTask.class);
        example.createCriteria().andEqualTo("invoiceTaskNo", invoiceChangePostVo.getInvoiceTaskNo());
        InvoiceChangeTask invoiceChangeTask = invoiceChangeTaskRepository.selectOneByExample(example);
        if (invoiceChangeTask == null){
            throw new FmsServiceException("变更任务数据不存在");
        }
        invoiceChangeTask.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点操作用户
        invoiceChangeTask.setInvoiceTaskStatus(BizStatusEnums.INVOICE_REFUSE.getType());//流程拒绝
        //更新开票变更任务表
        invoiceChangeTaskRepository.updateByPrimaryKeySelectiveData(invoiceChangeTask);
    }

    /**
     * @param invoiceChangeVo
     * @return java.lang.String
     * @throws
     * @Title:
     * @Description: 验证当前企业是否存在变更任务
     * @author lijunjun
     * @date 2018-8-29 9:45:21
     */
    @Override
    public void checkInvoiceChange(InvoiceChangeVo invoiceChangeVo) {
        if (StringUtils.isTrimBlank(invoiceChangeVo.getSocialCertifNo())){
            throw new FmsServiceException("参数不正确");
        }
        Example example = SqlUtil.newExample(InvoiceChangeTask.class);
        example.createCriteria().andEqualTo("socialCertifNo", invoiceChangeVo.getSocialCertifNo());
        List<InvoiceChangeTask> invoiceChangeTaskList = invoiceChangeTaskRepository.selectListByExample(example);
        if (ArrayUtils.isNotNullAndLengthNotZero(invoiceChangeTaskList)){
            for (InvoiceChangeTask invoiceChangeTask : invoiceChangeTaskList){
                if (!StringUtils.equals(BizStatusEnums.INVOICE_END.getType(), invoiceChangeTask.getInvoiceTaskStatus())
                        && !StringUtils.equals(BizStatusEnums.INVOICE_REFUSE.getType(), invoiceChangeTask.getInvoiceTaskStatus())){
                    throw new FmsServiceException("该企业存在未结束的开票变更任务，请先结束再重新申请");
                }
            }
        }
    }

    /**
     * 保存流程日志
     * @param user
     * @param actType
     * @param wfLogNo
     * @param remark
     * @param status
     */
    private void saveWorkFlowLog(String user, String actType, String wfLogNo, String remark, String status) {
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(user);
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setActType(actType);
        workflowLog.setWfLogType(BizTypeEnums.INVOICE_CHANGE.getType());
        workflowLog.setWfLogNo(wfLogNo);
        workflowLog.setRemark1(remark);
        workflowLog.setStatus(status);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

}
