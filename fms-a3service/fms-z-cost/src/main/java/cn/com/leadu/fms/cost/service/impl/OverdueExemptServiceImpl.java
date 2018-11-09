package cn.com.leadu.fms.cost.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActOverdueExemptUtils;
import cn.com.leadu.fms.business.service.CommonConstantService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.CommonParamConstants;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.cost.OverdueContStatusEnums;
import cn.com.leadu.fms.common.constant.enums.cost.OverdueExemptStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.RepayStatusEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.cost.rpc.finance.ContOverdueRpc;
import cn.com.leadu.fms.cost.rpc.postbiz.OverdueContRpc;
import cn.com.leadu.fms.cost.service.OverdueExemptService;
import cn.com.leadu.fms.cost.validator.overdueexempt.vo.OverdueExemptDeleteListVo;
import cn.com.leadu.fms.cost.validator.overdueexempt.vo.OverdueExemptDeleteVo;
import cn.com.leadu.fms.cost.validator.overdueexempt.vo.OverdueExemptModifyVo;
import cn.com.leadu.fms.cost.validator.overdueexempt.vo.OverdueExemptSaveVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.cost.repository.OverdueExemptDetailRepository;
import cn.com.leadu.fms.data.cost.repository.OverdueExemptRepository;
import cn.com.leadu.fms.data.finance.repository.ContOverdueRepository;
import cn.com.leadu.fms.data.postbiz.repository.OverdueContRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.cost.entity.OverdueExempt;
import cn.com.leadu.fms.pojo.cost.entity.OverdueExemptDetail;
import cn.com.leadu.fms.pojo.cost.vo.overdueexempt.ContOverdueOneVo;
import cn.com.leadu.fms.pojo.cost.vo.overdueexempt.OverdueExemptVo;
import cn.com.leadu.fms.pojo.finance.entity.ContOverdue;
import cn.com.leadu.fms.pojo.finance.vo.contoverdue.ContOverdueVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecont.OverdueContVo;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.APPROVAL;
import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SENDBACK;
import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SUBMIT;

/**
 * @author yanfengbo
 * @ClassName: OverdueExemptService
 * @Description: 罚息免除任务表业务实现层
 * @date 2018-05-30
 */
@Slf4j
@Service
public class OverdueExemptServiceImpl implements OverdueExemptService {
    /**
     * @Fields : 逾期合同信息repository
     */
    @Autowired
    private OverdueContRpc overdueContRpc;

    /**
     * @Fields : 逾期罚息rpc
     */
    @Autowired
    private ContOverdueRpc contOverdueRpc;

    /**
     * @Fields : 罚息免除任务明细表Repository
     */
    @Autowired
    private OverdueExemptDetailRepository overdueExemptDetailRepository;

    /**
     * @Fields : 业务编号管理业务service
     */
    @Autowired
    private NumGenerateService numGenerateService;

    /**
     * @Fields : 还款逾期罚息Repository
     */
    @Autowired
    private ContOverdueRepository contOverdueRepository;

    /**
     * @Fields  : 罚息免除任务表repository
     */
    @Autowired
    private OverdueExemptRepository overdueExemptRepository;

    @Autowired
    private CommonConstantService commonConstantService;

    /**
     * @Fields : 日志service
     */
    @Autowired
    private WorkflowLogService workflowLogService;

    /**
     * @Title:
     * @Description: 取得罚息免除一览展示页面
     * @param overdueExemptVo
     * @return PageInfoExtend<OverdueExempt>
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    public PageInfoExtend<OverdueExemptVo> findOverdueExemptsByPage(OverdueExemptVo overdueExemptVo){
        //承租人
        if(StringUtils.isNotTrimBlank(overdueExemptVo.getCstmName())){
            overdueExemptVo.setCstmName(SqlUtil.likePattern(overdueExemptVo.getCstmName()));
        }else {
            overdueExemptVo.setCstmName(null);
        }
        //合同编号
        if (StringUtils.isNotTrimBlank(overdueExemptVo.getContNo())){
            overdueExemptVo.setContNo(SqlUtil.likePattern(overdueExemptVo.getContNo()));
        }else {
            overdueExemptVo.setContNo(null);
        }

        //出租人区域
        if(StringUtils.isTrimBlank(overdueExemptVo.getGroupDistrict()))
            overdueExemptVo.setGroupDistrict(null);
        else
            overdueExemptVo.setGroupDistrict(SqlUtil.likePattern(overdueExemptVo.getGroupDistrict()));

        //车架号
        if(StringUtils.isTrimBlank(overdueExemptVo.getVinNo()))
            overdueExemptVo.setVinNo(null);
        else
            overdueExemptVo.setVinNo(SqlUtil.likePattern(overdueExemptVo.getVinNo()));
        return overdueExemptRepository.selectListVoByPage("selectOverdueExemptsByPage",overdueExemptVo,overdueExemptVo.getPageQuery());
    }

    /**
     * @Title:
     * @Description: 保存罚息免除任务表
     * @param overdueExemptSaveVo
     * @return java.lang.String
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    public void saveOverdueExempt(OverdueExemptSaveVo overdueExemptSaveVo){
        overdueExemptRepository.insertData(overdueExemptSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改罚息免除任务表
     * @param overdueExemptModifyVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    public void modifyOverdueExempt(OverdueExemptModifyVo overdueExemptModifyVo){
        overdueExemptRepository.updateByPrimaryKeySelectiveData(overdueExemptModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过overdueExemptId删除罚息免除任务表
     * @param overdueExemptDeleteVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    public void deleteOverdueExempt(OverdueExemptDeleteVo overdueExemptDeleteVo){
        overdueExemptRepository.deleteData(overdueExemptDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过overdueExemptId集合删除罚息免除任务表
     * @param overdueExemptDeleteListVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    public void deleteOverdueExemptsByOverdueExemptIds(OverdueExemptDeleteListVo overdueExemptDeleteListVo){
        overdueExemptRepository.deleteDataList(overdueExemptDeleteListVo.getOverdueExemptIds(),overdueExemptDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据overdueExemptId获取罚息免除任务表
     * @param overdueExemptId
     * @return OverdueExempt
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    public OverdueExempt findOverdueExemptByOverdueExemptId(String overdueExemptId){
        return overdueExemptRepository.selectByPrimaryKey(overdueExemptId);
    }


    /**
     * @Title:
     * @Description: 取得罚息免除一览(主表为逾期罚息表,关联合同信息等表)
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public PageInfoExtend<ContOverdueVo> findContOverdueVosByPage(ContOverdueVo contOverdueVo) {
        // 取得未还款期数
        contOverdueVo.setRepayStatus(RepayStatusEnums.TO_BE_WITHHELD.getType());
        //承租人
        if(StringUtils.isNotTrimBlank(contOverdueVo.getCstmName())){
            contOverdueVo.setCstmName(SqlUtil.likePattern(contOverdueVo.getCstmName()));
        }else {
            contOverdueVo.setCstmName(null);
        }
        //合同编号
        if (StringUtils.isNotTrimBlank(contOverdueVo.getContNo())){
            contOverdueVo.setContNo(SqlUtil.likePattern(contOverdueVo.getContNo()));
        }else {
            contOverdueVo.setContNo(null);
        }

        //出租人区域
        if(StringUtils.isTrimBlank(contOverdueVo.getGroupDistrict()))
            contOverdueVo.setGroupDistrict(null);
        else
            contOverdueVo.setGroupDistrict(SqlUtil.likePattern(contOverdueVo.getGroupDistrict()));

        //车架号
        if(StringUtils.isTrimBlank(contOverdueVo.getVinNo()))
            contOverdueVo.setVinNo(null);
        else
            contOverdueVo.setVinNo(SqlUtil.likePattern(contOverdueVo.getVinNo()));
        return overdueExemptRepository.selectListVoByPage("selectContOverdueVosByPage", contOverdueVo, contOverdueVo.getPageQuery());
    }



    /**
     * @param
     * @return
     * @throws
     * @Title:
     * @Description: 根据contNo获取逾期罚息信息和合同信息(初次提交页面回显)
     * @author yanfengbo
     * @date
     */
    public OverdueExemptVo findDetailBycontNo(String contNo) {
        OverdueExemptVo overdueExemptVo = new OverdueExemptVo();
       //根据合同号关联查询合同信息等表并去重取得一条明细(页面上半部分)
        ContOverdueOneVo contOverdueOneVo = overdueExemptRepository.selectOneContOverdueVo(contNo);
        overdueExemptVo.setContOverdueOneVo(contOverdueOneVo);

        //取得逾期罚息表信息一条或多条(页面下部回显)
        try {
            List<ContOverdueVo> contOverdueVoList = ResponseEntityUtils.getRestResponseData(contOverdueRpc.findContOverdueByCont(contNo));
            overdueExemptVo.setContOverdueVoList(contOverdueVoList);
        } catch (FmsRpcException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return overdueExemptVo;
    }

    /**
     * @param
     * @return
     * @throws
     * @Title:
     * @Description: 根据serviced获取逾期合同信息和逾期罚息信息(退回)(二次提交页面回显)
     * @author yanfengbo
     * @date
     */
    public OverdueExemptVo findDetailByServiceId(String serviceId) {
        OverdueExemptVo overdueExemptVo = new OverdueExemptVo();
        Example example = SqlUtil.newExample(OverdueExempt.class);
        example.createCriteria().andEqualTo("overdueExemptNo", serviceId);
        OverdueExempt overdueExempt = overdueExemptRepository.selectOneByExample(example);

        //根据合同号关联查询合同信息等表并去重取得一条明细(页面上半部分)
        ContOverdueOneVo contOverdueOneVo = overdueExemptRepository.selectOneContOverdueVo(overdueExempt.getContNo());
        overdueExemptVo.setContOverdueOneVo(contOverdueOneVo);
        //通过合同号关联查询逾期罚息表和罚息免除任务明细表信息(页面下部回显)
        List<ContOverdueVo> contOverdueVoList = overdueExemptRepository.selectContOverdueAndOverdueExemptDetailByContNo(overdueExempt.getContNo(),serviceId);
        overdueExemptVo.setContOverdueVoList(contOverdueVoList);
        //根据任务号取overdue_exempt_id，为了后面根据id更新罚息免除状态
        Example example1 = SqlUtil.newExample(OverdueExempt.class);
        Example.Criteria criteria = example1.createCriteria();
        criteria.andEqualTo("overdueExemptNo",serviceId);
        OverdueExempt overdueExempt1 = overdueExemptRepository.selectOneByExample(example1);
        overdueExemptVo.setOverdueExemptId(overdueExempt1.getOverdueExemptId());
        return overdueExemptVo;
    }


    /**
     * @param
     * @return
     * @throws
     * @Title:
     * @Description: 罚息免除
     * @author yanfengbo
     * @date
     */
    @Transactional
    public void entryOverdueCont(OverdueExemptVo overdueExemptVo,SysUser sysUser) {
        //移除前台传过来的申请免除金额不合法的明细
        List<ContOverdueVo> effectiveContOverdueVoList = new ArrayList<>();
        if (ArrayUtils.isNotNullAndLengthNotZero(overdueExemptVo.getContOverdueVoList())) {
            for (ContOverdueVo contOverdueVo : overdueExemptVo.getContOverdueVoList()) {
                if(contOverdueVo.getManualExemptAmount()!=null && contOverdueVo.getManualExemptAmount().compareTo(BigDecimal.ZERO)>0){
                    effectiveContOverdueVoList.add(contOverdueVo);
                }
            }
        }
        if(ArrayUtils.isNullOrLengthZero(effectiveContOverdueVoList))
            throw new FmsServiceException("请正确输入免除金额!");

        //取逾期天数集合
        List<Integer> overdueDaysList = new ArrayList<>();
        for (ContOverdueVo contOverdueVo : effectiveContOverdueVoList) {
            Integer overdueDays = new Integer(contOverdueVo.getOverdueDays());
            overdueDaysList.add(overdueDays);
        }
        //取最大逾期天数
        Integer maxOverdueDays = Collections.max(overdueDaysList);
        Integer status;
        //判断是否退回
        if(StringUtils.isNotTrimBlank(overdueExemptVo.getServiceId())){
            //根据合同号和任务号拿到本次流程第一次申请的所有不同期数的罚息免除明细
            if(StringUtils.isTrimBlank(overdueExemptVo.getContOverdueOneVo().getContNo())){
                throw new FmsServiceException("合同号为空!");
            }
            Example exampleA = SqlUtil.newExample(OverdueExemptDetail.class);
            exampleA.createCriteria().andEqualTo("contNo", overdueExemptVo.getContOverdueOneVo().getContNo()).andEqualTo("overdueExemptNo", overdueExemptVo.getServiceId());
            List<OverdueExemptDetail> overdueExemptDetails = overdueExemptDetailRepository.selectListByExample(exampleA);
            //取到本次流程第一次申请的所有不同期数的罚息免除明细id
            List<String> overdueExemptDetailIds = new ArrayList<>();
            if(ArrayUtils.isNotNullAndLengthNotZero(overdueExemptDetails)){
                for(OverdueExemptDetail overdueExemptDetail : overdueExemptDetails){
                    if(StringUtils.isNotTrimBlank(overdueExemptDetail.getOverdueExemptDetailId()))
                        overdueExemptDetailIds.add(overdueExemptDetail.getOverdueExemptDetailId());
                }
            }

            //遍历本次流程审核退回再提交的明细,明细中如果有第一次申请就提交的数据,则该条所对应的罚息免除明细表id已由初始化查询时带出
            //与本次流程第一次申请的数据对比,从而删掉第一次申请而退回再提交不再申请的那些数据
            if (ArrayUtils.isNotNullAndLengthNotZero(effectiveContOverdueVoList)) {
                for (ContOverdueVo contOverdueVo : effectiveContOverdueVoList) {
                    if(StringUtils.isNotTrimBlank(contOverdueVo.getOverdueExemptDetailId())){
                        if(overdueExemptDetailIds.contains(contOverdueVo.getOverdueExemptDetailId())){
                            overdueExemptDetailIds.remove(contOverdueVo.getOverdueExemptDetailId());
                        }
                    }
                }
            }
            overdueExemptDetailRepository.deleteDataList(overdueExemptDetailIds,new OverdueExemptDetail());
            ActRuTaskVo actRuTaskVo=null;
            //业务处理
            //最大逾期天数小于3天时
            if (maxOverdueDays < Integer.parseInt(commonConstantService.findSysParamValue(CommonParamConstants.OVERDUE_DAYS_CRITICAL))) {
                status = 0;
                //工作流引擎
                actRuTaskVo = ActOverdueExemptUtils.startOverdueExempt(overdueExemptVo.getServiceId(), "1", "罚息免除", status);

                /*更新逾期罚息表*/
                List<ContOverdue> contOverdueList = new ArrayList<>();
                if (ArrayUtils.isNotNullAndLengthNotZero(effectiveContOverdueVoList)) {
                    for (ContOverdueVo contOverdueVo : effectiveContOverdueVoList) {
                        if (contOverdueVo.getManualExemptAmount() != null) {
                            ContOverdue contOverdue = EntityUtils.getEntity(contOverdueVo, new ContOverdue());
                            //更新以免除金额
                            contOverdue.setExemptAmount((contOverdue.getExemptAmount()).add(contOverdueVo.getManualExemptAmount()));
                            BigDecimal restOverdueAmount = (contOverdue.getRestOverdueAmount()).subtract(contOverdueVo.getManualExemptAmount());
                            //更新罚息剩余金额
                            contOverdue.setRestOverdueAmount(restOverdueAmount);
                            //如果本次此次恰好把全部罚息金额免除完了(即剩余罚息金额为0),则更新扣款状态为成功
                            if(restOverdueAmount.compareTo(BigDecimal.ZERO)==0){
                                contOverdue.setRepayStatus(RepayStatusEnums.WITHDRAWING_SUCCESS.getType());
                            }
                            //封装contOverdueList
                            contOverdueList.add(contOverdue);
                        }
                    }
                }
                contOverdueRepository.updateByPrimaryKeySelectiveDataList(contOverdueList);
            }else {
                status = 1;
                //工作流引擎
                actRuTaskVo = ActOverdueExemptUtils.approvalAgree(overdueExemptVo.getTaskId());
            }

            /*更新罚息免除任务表*/
            OverdueExempt overdueExempt = new OverdueExempt();
            overdueExempt.setOverdueExemptId(overdueExemptVo.getOverdueExemptId());
            //罚息免除任务状态
            if (StringUtils.isNotTrimBlank(actRuTaskVo.getTaskCode())){
                overdueExempt.setOverdueExemptStatus(actRuTaskVo.getTaskCode());
            }else {
                throw new FmsServiceException("无法获得罚息免除状态");
            }
            //当前用户节点
            overdueExempt.setPresentUser(actRuTaskVo.getNextAssignee());
            overdueExemptRepository.updateByPrimaryKeySelectiveData(overdueExempt);

            /*更新罚息免除任务明细表-->第一次申请和退回再提交都同时存在的那些明细*/
            /*录入罚息免除任务明细表-->第一次申请不存在,退回再提交存在的那些明细*/
            List<OverdueExemptDetail> overdueExemptDetailUpdateList = new ArrayList<>();
            List<OverdueExemptDetail> overdueExemptDetailInsertList = new ArrayList<>();
            if (ArrayUtils.isNotNullAndLengthNotZero(effectiveContOverdueVoList)) {
                for (ContOverdueVo contOverdueVo : effectiveContOverdueVoList) {
                    if(StringUtils.isNotTrimBlank(contOverdueVo.getOverdueExemptDetailId())){
                        //罚息免除任务明细对象
                        OverdueExemptDetail overdueExemptDetailUpdate = new OverdueExemptDetail();
                        //免除金额
                        overdueExemptDetailUpdate.setManualExemptAmount(contOverdueVo.getManualExemptAmount());
                        //罚息免除任务明细状态
                        if (StringUtils.isNotTrimBlank(actRuTaskVo.getTaskCode())){
                            overdueExemptDetailUpdate.setOverdueExemptDetailStatus(actRuTaskVo.getTaskCode());
                        }else {
                            throw new FmsServiceException("无法获得罚息免除状态");
                        }
                        //罚息免除任务明细表id
                        overdueExemptDetailUpdate.setOverdueExemptDetailId(contOverdueVo.getOverdueExemptDetailId());
                        //封装
                        overdueExemptDetailUpdateList.add(overdueExemptDetailUpdate);
                    }else {
                        //罚息免除任务明细对象
                        OverdueExemptDetail overdueExemptDetailInsert = new OverdueExemptDetail();
                        //罚息免除任务号
                        overdueExemptDetailInsert.setOverdueExemptNo(overdueExemptVo.getServiceId());
                        //合同编号
                        overdueExemptDetailInsert.setContNo(overdueExemptVo.getContOverdueOneVo().getContNo());
                        //期数
                        if (StringUtils.isNotTrimBlank(contOverdueVo.getPeriod())) {
                            overdueExemptDetailInsert.setPeriods(contOverdueVo.getPeriod());
                        }
                        //罚息免除任务明细状态
                        if (StringUtils.isNotTrimBlank(actRuTaskVo.getTaskCode())){
                            overdueExemptDetailInsert.setOverdueExemptDetailStatus(actRuTaskVo.getTaskCode());
                        }else {
                            throw new FmsServiceException("无法获得罚息免除状态");
                        }
                        //免除金额
                        overdueExemptDetailInsert.setManualExemptAmount(contOverdueVo.getManualExemptAmount());
                        overdueExemptDetailInsertList.add(overdueExemptDetailInsert);
                    }
                }
            }
            overdueExemptDetailRepository.updateByPrimaryKeySelectiveDataList(overdueExemptDetailUpdateList);
            overdueExemptDetailRepository.insertDataList(overdueExemptDetailInsertList);
            //保存日志
            WorkflowLog workflowLog = new WorkflowLog();
            workflowLog.setUser(sysUser.getUser());
            workflowLog.setWfLogNo(overdueExemptVo.getServiceId());
            workflowLog.setWfLogType(BizTypeEnums.OVERDUE_EXEMPT.getType());
            workflowLog.setActWidgetId(RequestUtils.getRequestUri());
            workflowLog.setRemark1(overdueExemptVo.getRemark1());
            //workflowLog.setWfLogSubNo(overdueExemptVo.getContNo());
            workflowLog.setActType(SUBMIT.getType());
            workflowLog.setStatus(actRuTaskVo.getTaskCode());
            workflowLogService.insertWorkFlowLog(workflowLog);
        } else {
            //首先判断所选逾期罚息明细中是否含有已经在流程中并且还没有审核通过的明细，如果有则不能进行罚息免除，客户可避开该条明细或等待该条明细审批通过再进行罚息免除
            if (ArrayUtils.isNotNullAndLengthNotZero(effectiveContOverdueVoList)) {
                for (ContOverdueVo contOverdueVo : effectiveContOverdueVoList) {
                    //根据合同号和期数关联查询罚息免除任务明细表，可得到一条逾期罚息明细所对应的多条罚息免除任务明细，取其状态，如果这多条明细中有状态不是审核通过的，则此时不能继续做罚息免除操作
                    if (StringUtils.isNotTrimBlank(contOverdueVo.getContNo()) && contOverdueVo.getPeriod() != null) {
                        Example example = SqlUtil.newExample(OverdueExemptDetail.class);
                        example.createCriteria().andEqualTo("contNo", contOverdueVo.getContNo()).andEqualTo("periods", contOverdueVo.getPeriod());
                        List<OverdueExemptDetail> overdueExemptDetails = overdueExemptDetailRepository.selectListByExample(example);
                        for (OverdueExemptDetail overdueExemptDetail : overdueExemptDetails) {
                            if (!("1002".equals(overdueExemptDetail.getOverdueExemptDetailStatus()))) {
                                throw new FmsServiceException("所选逾期罚息明细中存在未审核通过的明细,申请失败!");
                            }
                        }
                    }
                }
            }
            //取任务号
            String overdueExemptNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.OVERDUE_EXEMPT_NUM_TYPE.getType());
            ActRuTaskVo actRuTaskVo=null;
            //业务处理
            //最大逾期天数小于3天时
            if (maxOverdueDays < Integer.parseInt(commonConstantService.findSysParamValue(CommonParamConstants.OVERDUE_DAYS_CRITICAL))) {
                status = 0;
                if (StringUtils.isNotTrimBlank(overdueExemptNo)) {
                    //工作流引擎
                    actRuTaskVo = ActOverdueExemptUtils.startOverdueExempt(overdueExemptNo, "1", "罚息免除", status);
                }
            /*更新逾期罚息表*/
                List<ContOverdue> contOverdueList = new ArrayList<>();
                if (ArrayUtils.isNotNullAndLengthNotZero(effectiveContOverdueVoList)) {
                    for (ContOverdueVo contOverdueVo : effectiveContOverdueVoList) {
                        if (contOverdueVo.getManualExemptAmount() != null) {
                            ContOverdue contOverdue = EntityUtils.getEntity(contOverdueVo, new ContOverdue());
                            //更新以免除金额
                            contOverdue.setExemptAmount((contOverdue.getExemptAmount()).add(contOverdueVo.getManualExemptAmount()));
                            BigDecimal restOverdueAmount = (contOverdue.getRestOverdueAmount()).subtract(contOverdueVo.getManualExemptAmount());
                            //更新罚息剩余金额
                            contOverdue.setRestOverdueAmount(restOverdueAmount);
                            //如果本次此次恰好把全部罚息金额免除完了(即剩余罚息金额为0),则更新扣款状态为成功
                            if(restOverdueAmount.compareTo(BigDecimal.ZERO)==0){
                                contOverdue.setRepayStatus(RepayStatusEnums.WITHDRAWING_SUCCESS.getType());
                            }
                            //封装contOverdueList
                            contOverdueList.add(contOverdue);
                        }
                    }
                }
                contOverdueRepository.updateByPrimaryKeySelectiveDataList(contOverdueList);
            }else {
                status = 1;
                if (StringUtils.isNotTrimBlank(overdueExemptNo)) {
                    //工作流引擎
                    actRuTaskVo = ActOverdueExemptUtils.startOverdueExempt(overdueExemptNo, "1", "罚息免除", status);
                }
            }

             /*录入罚息免除任务表*/
            OverdueExempt overdueExempt = new OverdueExempt();
            //罚息免除任务号
            if (StringUtils.isNotTrimBlank(overdueExemptNo)) {
                overdueExempt.setOverdueExemptNo(overdueExemptNo);
            }
            //合同编号
            if (StringUtils.isNotTrimBlank(overdueExemptVo.getContOverdueOneVo().getContNo())) {
                overdueExempt.setContNo(overdueExemptVo.getContOverdueOneVo().getContNo());
            }
            //罚息免除状态
            if (StringUtils.isNotTrimBlank(actRuTaskVo.getTaskCode())){
                overdueExempt.setOverdueExemptStatus(actRuTaskVo.getTaskCode());
            }else {
                throw new FmsServiceException("无法获得罚息免除状态");
            }
            //当前用户节点
            overdueExempt.setPresentUser(actRuTaskVo.getNextAssignee());
            //申请时间取第一次提交时的当前时间
            overdueExempt.setOverdueDate(DateUtils.getNowDate());
            overdueExemptRepository.insertData(overdueExempt);

            /*录入罚息免除任务明细表*/
            List<OverdueExemptDetail> overdueExemptDetailList = new ArrayList<>();
            if (ArrayUtils.isNotNullAndLengthNotZero(effectiveContOverdueVoList)) {
                for (ContOverdueVo contOverdueVo : effectiveContOverdueVoList) {
                    //罚息免除任务明细对象
                    OverdueExemptDetail overdueExemptDetail = new OverdueExemptDetail();
                    //罚息免除任务号
                    if (StringUtils.isNotTrimBlank(overdueExemptNo)) {
                        overdueExemptDetail.setOverdueExemptNo(overdueExemptNo);
                    }
                    //合同编号
                    if (StringUtils.isNotTrimBlank(contOverdueVo.getContNo())) {
                        overdueExemptDetail.setContNo(contOverdueVo.getContNo());
                    }
                    //期数
                    if (StringUtils.isNotTrimBlank(contOverdueVo.getPeriod())) {
                        overdueExemptDetail.setPeriods(contOverdueVo.getPeriod());
                    }
                    //罚息免除任务明细状态
                    if (StringUtils.isNotTrimBlank(actRuTaskVo.getTaskCode())){
                        overdueExemptDetail.setOverdueExemptDetailStatus(actRuTaskVo.getTaskCode());
                    }else {
                        throw new FmsServiceException("无法获得罚息免除状态");
                    }
                    //免除金额
                    overdueExemptDetail.setManualExemptAmount(contOverdueVo.getManualExemptAmount());
                    overdueExemptDetailList.add(overdueExemptDetail);
                }
            }
            overdueExemptDetailRepository.insertDataList(overdueExemptDetailList);
            //保存日志
            WorkflowLog workflowLog = new WorkflowLog();
            workflowLog.setUser(sysUser.getUser());
            workflowLog.setWfLogNo(overdueExemptNo);
            workflowLog.setWfLogType(BizTypeEnums.OVERDUE_EXEMPT.getType());
            workflowLog.setActWidgetId(RequestUtils.getRequestUri());
            workflowLog.setRemark1(overdueExemptVo.getRemark1());
            //workflowLog.setWfLogSubNo(overdueExemptVo.getContNo());
            workflowLog.setActType(SUBMIT.getType());
            workflowLog.setStatus(actRuTaskVo.getTaskCode());
            workflowLogService.insertWorkFlowLog(workflowLog);
        }
    }


    /**
     * @param
     * @return
     * @throws
     * @Title:
     * @Description: 罚息免除审核通过
     * @author yanfengbo
     * @date
     */
    @Transactional
    public void approval(OverdueExemptVo overdueExemptVo,SysUser sysUser) {
        //流程引擎
        ActRuTaskVo actRuTaskVo = ActOverdueExemptUtils.approvalAgree(overdueExemptVo.getTaskId());
        //更新罚息免除任务表状态
        OverdueExempt overdueExempt = new OverdueExempt();
        overdueExempt.setOverdueExemptId(overdueExemptVo.getOverdueExemptId());
        overdueExempt.setOverdueExemptStatus(actRuTaskVo.getTaskCode());
        //当前用户节点
        overdueExempt.setPresentUser(actRuTaskVo.getNextAssignee());
        overdueExemptRepository.updateByPrimaryKeySelectiveData(overdueExempt);
        /*更新罚息免除任务明细状态*/
        List<OverdueExemptDetail> overdueExemptDetailList = new ArrayList<>();
        if (ArrayUtils.isNotNullAndLengthNotZero(overdueExemptVo.getContOverdueVoList())) {
            for (ContOverdueVo contOverdueVo : overdueExemptVo.getContOverdueVoList()) {
                //任务号,期数与合同编号确定唯一一条罚息免除任务明细
                //合同编号,期数
                if (StringUtils.isNotTrimBlank(contOverdueVo.getContNo()) && contOverdueVo.getPeriod()!=null) {
                    Example example = SqlUtil.newExample(OverdueExemptDetail.class);
                    example.createCriteria().andEqualTo("contNo", contOverdueVo.getContNo()).andEqualTo("periods",contOverdueVo.getPeriod()).andEqualTo("overdueExemptNo",overdueExemptVo.getServiceId());
                    OverdueExemptDetail overdueExemptDetailOne = overdueExemptDetailRepository.selectOneByExample(example);
                    if(overdueExemptDetailOne!=null){
                        if(StringUtils.isNotTrimBlank(overdueExemptDetailOne.getOverdueExemptDetailId())){
                            //罚息免除任务明细对象
                            OverdueExemptDetail overdueExemptDetail = new OverdueExemptDetail();
                            //罚息免除任务明细状态
                            if (StringUtils.isNotTrimBlank(actRuTaskVo.getTaskCode())){
                                overdueExemptDetail.setOverdueExemptDetailStatus(actRuTaskVo.getTaskCode());
                            }else {
                                throw new FmsServiceException("无法获得罚息免除状态");
                            }
                            //罚息免除任务明细表id
                            overdueExemptDetail.setOverdueExemptDetailId(overdueExemptDetailOne.getOverdueExemptDetailId());
                            //封装
                            overdueExemptDetailList.add(overdueExemptDetail);
                        }
                    }
                }
            }
        }
        overdueExemptDetailRepository.updateByPrimaryKeySelectiveDataList(overdueExemptDetailList);

         /*更新逾期罚息表*/
        List<ContOverdue> contOverdueList = new ArrayList<>();
        if (ArrayUtils.isNotNullAndLengthNotZero(overdueExemptVo.getContOverdueVoList())) {
            for (ContOverdueVo contOverdueVo : overdueExemptVo.getContOverdueVoList()) {
                if (contOverdueVo.getManualExemptAmount() != null) {
                    ContOverdue contOverdue = EntityUtils.getEntity(contOverdueVo,new ContOverdue());
                    //更新以免除金额
                    contOverdue.setExemptAmount((contOverdue.getExemptAmount()).add(contOverdueVo.getManualExemptAmount()));
                    BigDecimal restOverdueAmount = (contOverdue.getRestOverdueAmount()).subtract(contOverdueVo.getManualExemptAmount());
                    //更新罚息剩余金额
                    contOverdue.setRestOverdueAmount(restOverdueAmount);
                    //如果本次此次恰好把全部罚息金额免除完了(即剩余罚息金额为0),则更新扣款状态为成功
                    if(restOverdueAmount.compareTo(BigDecimal.ZERO)==0){
                        contOverdue.setRepayStatus(RepayStatusEnums.WITHDRAWING_SUCCESS.getType());
                    }
                    //封装contOverdueList
                    contOverdueList.add(contOverdue);
                }
            }
        }
        contOverdueRepository.updateByPrimaryKeySelectiveDataList(contOverdueList);
        auditPass(overdueExemptVo,actRuTaskVo,sysUser);
    }

    /**
     * @param
     * @return
     * @throws
     * @Title:
     * @Description: 罚息免除审核退回
     * @author yanfengbo
     * @date
     */
    @Transactional
    public void sendBack(OverdueExemptVo overdueExemptVo,SysUser sysUser) {
        //流程引擎
        ActRuTaskVo actRuTaskVo = ActOverdueExemptUtils.approvalReturnSuperior(overdueExemptVo.getTaskId());
        //更新罚息免除状态
        OverdueExempt overdueExempt = new OverdueExempt();
        overdueExempt.setOverdueExemptId(overdueExemptVo.getOverdueExemptId());
        overdueExempt.setOverdueExemptStatus(actRuTaskVo.getTaskCode());
        //当前用户节点
        overdueExempt.setPresentUser(actRuTaskVo.getNextAssignee());
        overdueExemptRepository.updateByPrimaryKeySelectiveData(overdueExempt);

         /*更新罚息免除任务明细状态*/
        List<OverdueExemptDetail> overdueExemptDetailList = new ArrayList<>();
        if (ArrayUtils.isNotNullAndLengthNotZero(overdueExemptVo.getContOverdueVoList())) {
            for (ContOverdueVo contOverdueVo : overdueExemptVo.getContOverdueVoList()) {
                //任务号,期数与合同编号确定唯一一条罚息免除任务明细
                //合同编号,期数
                if (StringUtils.isNotTrimBlank(contOverdueVo.getContNo()) && contOverdueVo.getPeriod()!=null
                        && contOverdueVo.getManualExemptAmount()!=null && contOverdueVo.getManualExemptAmount().compareTo(BigDecimal.ZERO)>0) {
                    Example example = SqlUtil.newExample(OverdueExemptDetail.class);
                    example.createCriteria().andEqualTo("contNo", contOverdueVo.getContNo()).andEqualTo("periods",contOverdueVo.getPeriod()).andEqualTo("overdueExemptNo",overdueExemptVo.getServiceId());
                    OverdueExemptDetail overdueExemptDetailOne = overdueExemptDetailRepository.selectOneByExample(example);
                    //取得该条明细的id用于后续更新操作
                    String overdueExemptDetailId = overdueExemptDetailOne.getOverdueExemptDetailId();
                    //罚息免除任务明细对象
                    OverdueExemptDetail overdueExemptDetail = new OverdueExemptDetail();
                    //罚息免除任务明细状态
                    if (StringUtils.isNotTrimBlank(actRuTaskVo.getTaskCode())){
                        overdueExemptDetail.setOverdueExemptDetailStatus(actRuTaskVo.getTaskCode());
                    }else {
                        throw new FmsServiceException("无法获得罚息免除状态");
                    }
                    //罚息免除任务明细表id
                    overdueExemptDetail.setOverdueExemptDetailId(overdueExemptDetailId);
                    //封装
                    overdueExemptDetailList.add(overdueExemptDetail);
                }
            }
        }
        overdueExemptDetailRepository.updateByPrimaryKeySelectiveDataList(overdueExemptDetailList);
        auditSendBack(overdueExemptVo,actRuTaskVo,sysUser);
    }

    /**
     * @Title:
     * @Description: 审核通过共通操作
     * @param
     * @return void
     * @throws
     * @author yanfengbo
     */
    public void  auditPass(OverdueExemptVo overdueExemptVo,ActRuTaskVo actRuTaskVo,SysUser sysUser){
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogNo(overdueExemptVo.getServiceId());
        workflowLog.setWfLogType(BizTypeEnums.OVERDUE_EXEMPT.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(overdueExemptVo.getRemark1());
        //workflowLog.setWfLogSubNo(overdueExemptVo.getContNo());
        workflowLog.setActType(APPROVAL.getType());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLogService.insertWorkFlowLog(workflowLog);
    }


    /**
     * @Title:
     * @Description: 审核退回共通操作
     * @param
     * @return void
     * @throws
     * @author yanfengbo
     */
    public void  auditSendBack(OverdueExemptVo overdueExemptVo,ActRuTaskVo actRuTaskVo,SysUser sysUser){
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogNo(overdueExemptVo.getServiceId());
        workflowLog.setWfLogType(BizTypeEnums.OVERDUE_EXEMPT.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(overdueExemptVo.getRemark1());
        //workflowLog.setWfLogSubNo(overdueExemptVo.getContNo());
        workflowLog.setActType(SENDBACK.getType());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLogService.insertWorkFlowLog(workflowLog);
    }
}
