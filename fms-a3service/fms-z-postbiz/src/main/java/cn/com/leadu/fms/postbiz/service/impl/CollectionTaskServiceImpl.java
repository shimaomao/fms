package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActCollectionTaskUtils;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.CommonPdfService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.DataSourceTypeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.DispatchTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.common.vo.FileVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.CollectionTaskRepository;
import cn.com.leadu.fms.data.postbiz.repository.OverdueCstmRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasBankInfo;
import cn.com.leadu.fms.pojo.postbiz.entity.CollectionTask;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstm;
import cn.com.leadu.fms.pojo.postbiz.vo.collectiontask.CollectionTaskVo;
import cn.com.leadu.fms.pojo.postbiz.vo.collectiontask.CstmAddrInfoVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.CollectionLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.LawyerLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmPostVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmVo;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.CollectionTaskService;
import cn.com.leadu.fms.postbiz.service.OverdueCstmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: CollectionTaskService
 * @Description: 催收任务业务实现层
 */
@Service
public class CollectionTaskServiceImpl implements CollectionTaskService {

    /**
     * @Fields  : 催收任务repository
     */
    @Autowired
    private CollectionTaskRepository collectionTaskRepository;
    @Autowired
    private NumGenerateService numGenerateService;
    @Autowired
    private WorkflowLogService workflowLogService;
    @Autowired
    private OverdueCstmRepository overdueCstmRepository;
    @Autowired
    private BizFilesService bizFilesService;
    @Autowired
    private OverdueCstmService overdueCstmService;
    @Autowired
    private CommonPdfService commonPdfService;
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;

    /**
     * @Title:
     * @Description: 分页查询催收任务
     * @param collectionTaskVo
     * @return PageInfoExtend<CollectionTask>
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    public PageInfoExtend<CollectionTaskVo> findCollectionTasksByPage(CollectionTaskVo collectionTaskVo){
        // 查询参数处理
        collectionTaskVo = buildParams(collectionTaskVo);

        PageInfoExtend<CollectionTaskVo> pageInfo = collectionTaskRepository.selectListVoByPage("selectCollectionTasksByPage", collectionTaskVo,collectionTaskVo.getPageQuery());
        return pageInfo;
    }

    /**
     * 检索条件参数构造
     * @param collectionTaskVo
     * @return
     */
    private CollectionTaskVo buildParams(CollectionTaskVo collectionTaskVo) {
        // 承租人查询处理
        if (StringUtils.isNotTrimBlank(collectionTaskVo.getCstmName())){
            collectionTaskVo.setCstmName(SqlUtil.likePattern(collectionTaskVo.getCstmName()));
        } else {
            collectionTaskVo.setCstmName(null);
        }
        if (StringUtils.isNotTrimBlank(collectionTaskVo.getCollectionTaskNo())){
            collectionTaskVo.setCollectionTaskNo(SqlUtil.likePattern(collectionTaskVo.getCollectionTaskNo()));
        } else {
            collectionTaskVo.setCollectionTaskNo(null);
        }
        // 数据来源查询处理
        if (StringUtils.isTrimBlank(collectionTaskVo.getDataSource())){
            collectionTaskVo.setDataSource(null);
        }
        // 任务状态查询处理
        if (StringUtils.isTrimBlank(collectionTaskVo.getCollectionTaskStatus())){
            collectionTaskVo.setCollectionTaskStatus(null);
        }
        // 催收任务状态查询处理
        if (StringUtils.isTrimBlank(collectionTaskVo.getCollectionTaskStatus())){
            collectionTaskVo.setCollectionTaskStatus(null);
        }
        // 催收等级查询处理
        if (StringUtils.isTrimBlank(collectionTaskVo.getCollectionLevel())){
            collectionTaskVo.setCollectionLevel(null);
        }
        // 催收人员查询处理
        if (StringUtils.isNotTrimBlank(collectionTaskVo.getApplyUser())){
            collectionTaskVo.setApplyUser(SqlUtil.likePattern(collectionTaskVo.getApplyUser()));
        } else {
            collectionTaskVo.setApplyUser(null);
        }
        // 派单类型查询处理
        if (StringUtils.isTrimBlank(collectionTaskVo.getDispatchType())){
            collectionTaskVo.setDispatchType(null);
        }
        // 登记人查询处理
        if (StringUtils.isNotTrimBlank(collectionTaskVo.getRegisterUser())){
            collectionTaskVo.setRegisterUser(SqlUtil.likePattern(collectionTaskVo.getRegisterUser()));
        } else {
            collectionTaskVo.setRegisterUser(null);
        }
        return collectionTaskVo;
    }

    /**
     * @Title:
     * @Description: 保存催收任务
     * @param collectionTaskVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @Override
    @Transactional
    public void saveCollectionTask(CollectionTaskVo collectionTaskVo, SysUser sysUser){
        String status ;
        if (StringUtils.isNotTrimBlank(collectionTaskVo.getCollectionTaskNo())){
            if (StringUtils.isNotTrimBlank(collectionTaskVo.getTaskId())){
                // 如果taskId存在 则是退回重新提交的数据，继续工作流
                //退回重新提交的任务
                ActRuTaskVo actRuTaskVo = ActCollectionTaskUtils.approvalAgree(collectionTaskVo.getTaskId());
                status = actRuTaskVo.getTaskCode();// 任务状态设定
                collectionTaskVo.setCollectionTaskStatus(actRuTaskVo.getTaskCode());//任务状态设定
                collectionTaskVo.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点用户
                //更新上门催收任务表
                collectionTaskRepository.updateByPrimaryKeySelectiveData(collectionTaskVo.getEntity());
            } else {
                // 如果taskId不存在 则是自动生成的任务数据 开启工作流
                // 校验是否存在未结束的任务
                isCollectionTaskExit(collectionTaskVo.getOverdueCstmId());
                //生成任务号
                ActRuTaskVo actRuTaskVo = ActCollectionTaskUtils.startCollectionTaskApply(collectionTaskVo.getCollectionTaskNo(), collectionTaskVo.getCstmName());
                status = actRuTaskVo.getTaskCode(); // 任务状态设定
                collectionTaskVo.setCollectionTaskStatus(actRuTaskVo.getTaskCode());//任务状态设定
                collectionTaskVo.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点用户
                collectionTaskVo.setApplyUser(sysUser.getUser());//提交人
                collectionTaskVo.setApplyDate(DateUtils.getNowDate());//提交时间
                Example example = SqlUtil.newExample(CollectionTask.class);
                example.createCriteria().andEqualTo("collectionTaskNo", collectionTaskVo.getCollectionTaskNo());
                //更新上门催收任务表
                collectionTaskRepository.updateByExampleSelectiveData(collectionTaskVo.getEntity(), example);
            }
        } else {
            //首次开启任务
            // 校验是否存在未结束的任务
            String collectionTaskNo = isCollectionTaskExit(collectionTaskVo.getOverdueCstmId());
            if (StringUtils.isNotTrimBlank(collectionTaskNo)){
                ActRuTaskVo actRuTaskVo = ActCollectionTaskUtils.startCollectionTaskApply(collectionTaskNo, collectionTaskVo.getCstmName());
                status = actRuTaskVo.getTaskCode(); // 任务状态设定
                collectionTaskVo.setCollectionTaskStatus(actRuTaskVo.getTaskCode());//任务状态设定
                collectionTaskVo.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点用户
                collectionTaskVo.setApplyUser(sysUser.getUser());//提交人
                collectionTaskVo.setApplyDate(DateUtils.getNowDate());//提交时间
                Example example = SqlUtil.newExample(CollectionTask.class);
                example.createCriteria().andEqualTo("collectionTaskNo", collectionTaskNo);
                //更新上门催收任务表
                collectionTaskRepository.updateByExampleSelectiveData(collectionTaskVo.getEntity(), example);
            } else {
                //生成任务号
                String taskNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.COLLECTION_TASK_NUM_TYPE.getType());
                // 开启工作流
                ActRuTaskVo actRuTaskVo = ActCollectionTaskUtils.startCollectionTaskApply(taskNo, collectionTaskVo.getCstmName());
                status = actRuTaskVo.getTaskCode();// 任务状态设定
                // 登录上门催收任务表
                insertCollectionTask(collectionTaskVo, sysUser, taskNo, actRuTaskVo);
            }
        }

        //保存登录日志
        saveWorkFlowLog(sysUser.getUser(), ActTypeEnums.SUBMIT.getType(), collectionTaskVo, status);
    }

    private void insertCollectionTask(CollectionTaskVo collectionTaskVo, SysUser sysUser, String taskNo, ActRuTaskVo actRuTaskVo) {
        collectionTaskVo.setCollectionTaskNo(taskNo);//任务号设定
        collectionTaskVo.setCollectionTaskStatus(actRuTaskVo.getTaskCode());//任务状态设定
        collectionTaskVo.setDataSource(DataSourceTypeEnums.HAND.getType());//数据来源设定
        collectionTaskVo.setApplyUser(sysUser.getUser());//发起人
        collectionTaskVo.setApplyDate(DateUtils.getNowDate()); // 发起时间
        collectionTaskVo.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点用户

        //登录上门催收任务表
        collectionTaskRepository.insertData(collectionTaskVo.getEntity());
    }

    private void saveWorkFlowLog(String user, String actType, CollectionTaskVo collectionTaskVo, String status) {
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(user);
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setActType(actType);
        workflowLog.setWfLogType(BizTypeEnums.COLLECTION_TASK.getType());
        workflowLog.setWfLogNo(collectionTaskVo.getCollectionTaskNo());
        workflowLog.setRemark1(collectionTaskVo.getRemark());
        workflowLog.setStatus(status);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /**
     * 获取承租人逾期信息
     * @param overdueCstmVo
     * @return
     */
    @Override
    public PageInfoExtend<OverdueCstmVo> findCstmInfosByPage(OverdueCstmVo overdueCstmVo){
        // 承租人处理
        if (StringUtils.isNotTrimBlank(overdueCstmVo.getCstmName())){
            overdueCstmVo.setCstmName(SqlUtil.likePattern(overdueCstmVo.getCstmName()));
        } else {
            overdueCstmVo.setCstmName(null);
        }
        // 当前风险等级处理
        if (StringUtils.isTrimBlank(overdueCstmVo.getOverdueRisk())){
            overdueCstmVo.setOverdueRisk(null);
        }
        // 证件号处理
        if (StringUtils.isTrimBlank(overdueCstmVo.getCertifNo())){
            overdueCstmVo.setCertifNo(null);
        }
        // 当前是否逾期
        if (StringUtils.isTrimBlank(overdueCstmVo.getOverdueFlag())){
            overdueCstmVo.setOverdueFlag(null);
        }
        PageInfoExtend<OverdueCstmVo> overdueCstmVoPageInfoExtend = collectionTaskRepository.selectListVoByPage("selectCstmInfosByPage", overdueCstmVo, overdueCstmVo.getPageQuery());
        return overdueCstmVoPageInfoExtend;
    }

    /**
     * 根据certifNo获取客户地址信息
     * @param overdueCstmId
     * @return
     */
    @Override
    public CollectionTaskVo findCstmAddrInfosByOverdueCstmId(String overdueCstmId){
        if (StringUtils.isTrimBlank(overdueCstmId)){
            throw new FmsServiceException("参数不正确");
        }
        CollectionTaskVo collectionTaskVo = collectionTaskRepository.selectCstmAddrPerInfosByOverdueCstmId(overdueCstmId);
        return collectionTaskVo;
    }

    /**
     * 根据collectionTaskNo获取上门催收任务信息
     * @param collectionTaskNo
     * @return
     */
    @Override
    public CollectionTaskVo findCollectionTasksByTaskNo(String collectionTaskNo){
        if (StringUtils.isTrimBlank(collectionTaskNo)){
            throw new FmsServiceException("参数不正确");
        }
        // 获取上门催收任务表信息
        CollectionTaskVo collectionTaskVo = collectionTaskRepository.selectCollectionTaskByCollectionTaskNo(collectionTaskNo);
        // 初始化地址信息List
        List<CstmAddrInfoVo> cstmAddrInfoVoList ;
        if (collectionTaskVo != null){
            if (StringUtils.isNotTrimBlank(collectionTaskVo.getOverdueCstmId())){
                Example example = SqlUtil.newExample(OverdueCstm.class);
                example.createCriteria().andEqualTo("overdueCstmId", collectionTaskVo.getOverdueCstmId());
                OverdueCstm overdueCstm = overdueCstmRepository.selectOneByExample(example);
                if (overdueCstm != null && StringUtils.isNotTrimBlank(overdueCstm.getCertifNo())){
                    collectionTaskVo.setCstmName(overdueCstm.getCstmName());//承租人赋值
                    cstmAddrInfoVoList = collectionTaskRepository.getCstmAddrInfoVoList(overdueCstm.getCertifNo());
                    if (ArrayUtils.isNotNullAndLengthNotZero(cstmAddrInfoVoList)){
                        collectionTaskVo.setCstmAddrInfoVoList(cstmAddrInfoVoList);
                    }
                }
            }
        }
        //获取提交的附件
        List<BizFiles> bizFilesList = bizFilesService.findBizFilesList(collectionTaskNo, BizCodeTypeEnums.COLLECTION_FILE.getCodeType());
        if (ArrayUtils.isNotNullAndLengthNotZero(bizFilesList)){
            collectionTaskVo.setBizFilesList(bizFilesList);
        }

        return collectionTaskVo;
    }

    /**
     * 上门催收同意
     *
     * @param collectionTaskVo
     * @param sysUser
     * @return
     */
    @Override
    @Transactional
    public void collectionApprovalAgree(CollectionTaskVo collectionTaskVo, SysUser sysUser) {
        if (StringUtils.isTrimBlank(collectionTaskVo.getTaskId())){
            throw new FmsServiceException("参数不正确");
        }
        ActRuTaskVo actRuTaskVo = ActCollectionTaskUtils.approvalAgree(collectionTaskVo.getTaskId());
        collectionTaskVo.setCollectionTaskStatus(actRuTaskVo.getTaskCode());//任务状态
        collectionTaskVo.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点用户
        //更新催收任务表
        collectionTaskRepository.updateByPrimaryKeySelectiveData(collectionTaskVo.getEntity());
        if (ArrayUtils.isNotNullAndLengthNotZero(collectionTaskVo.getBizFilesList())){
            //保存附件信息
            bizFilesService.modifyBizFilesList(collectionTaskVo.getBizFilesList(),collectionTaskVo.getCollectionTaskNo(),
                    BizCodeTypeEnums.COLLECTION_FILE.getCodeType());
        }

        //保存登录日志
        saveWorkFlowLog(sysUser.getUser(), ActTypeEnums.SUBMIT.getType(), collectionTaskVo, actRuTaskVo.getTaskCode());
    }

    /**
     * 上门催收派单提交
     *
     * @param collectionTaskVo
     * @param sysUser
     * @return
     */
    @Override
    @Transactional
    public void collectionDispatchAgree(CollectionTaskVo collectionTaskVo, SysUser sysUser) {
        if (StringUtils.isTrimBlank(collectionTaskVo.getTaskId())){
            throw new FmsServiceException("参数不正确");
        }
        ActRuTaskVo actRuTaskVo = ActCollectionTaskUtils.dispatchApprovalAgree(collectionTaskVo.getTaskId(), collectionTaskVo);
        collectionTaskVo.setCollectionTaskStatus(actRuTaskVo.getTaskCode());//任务状态
        collectionTaskVo.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点用户
        if (StringUtils.equals(DispatchTypeEnums.COMPANY.getType(), collectionTaskVo.getDispatchType())){
            //如果是公司内部 登记人设定为派单人
            collectionTaskVo.setRegisterUser(collectionTaskVo.getDispatchUser());
        }
        //更新催收任务表
        collectionTaskRepository.updateByPrimaryKeySelectiveData(collectionTaskVo.getEntity());

        //保存登录日志
        saveWorkFlowLog(sysUser.getUser(), ActTypeEnums.SUBMIT.getType(), collectionTaskVo, actRuTaskVo.getTaskCode());
    }

    /**
     * 上门催收拒绝
     *
     * @param collectionTaskVo
     * @param sysUser
     * @return
     */
    @Override
    @Transactional
    public void collectionRefuse(CollectionTaskVo collectionTaskVo, SysUser sysUser) {
        if (StringUtils.isTrimBlank(collectionTaskVo.getTaskId())){
            throw new FmsServiceException("参数不正确");
        }
        ActRuTaskVo actRuTaskVo = ActCollectionTaskUtils.approvalRefuse(collectionTaskVo.getTaskId());
        collectionTaskVo.setCollectionTaskStatus(BizStatusEnums.COLLECTION_REFUSE.getType());//任务状态:取消状态
        collectionTaskVo.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点用户
        //更新催收任务表
        collectionTaskRepository.updateByPrimaryKeySelectiveData(collectionTaskVo.getEntity());

        //保存登录日志
        saveWorkFlowLog(sysUser.getUser(), ActTypeEnums.REFUSE.getType(), collectionTaskVo, actRuTaskVo.getTaskCode());
    }

    /**
     * 上门催收审核通过
     *
     * @param collectionTaskVo
     * @param sysUser
     * @return
     */
    @Override
    @Transactional
    public void collectionAgree(CollectionTaskVo collectionTaskVo, SysUser sysUser) {
        if (StringUtils.isTrimBlank(collectionTaskVo.getTaskId())){
            throw new FmsServiceException("参数不正确");
        }
        ActRuTaskVo actRuTaskVo = ActCollectionTaskUtils.approvalAgree(collectionTaskVo.getTaskId());
        collectionTaskVo.setCollectionTaskStatus(actRuTaskVo.getTaskCode());//任务状态
        collectionTaskVo.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点用户
        //更新催收任务表
        collectionTaskRepository.updateByPrimaryKeySelectiveData(collectionTaskVo.getEntity());

        //保存登录日志
        saveWorkFlowLog(sysUser.getUser(), ActTypeEnums.APPROVAL.getType(), collectionTaskVo, actRuTaskVo.getTaskCode());
    }

    /**
     * 上门催收审核退回
     *
     * @param collectionTaskVo
     * @param sysUser
     * @return
     */
    @Override
    @Transactional
    public void collectionBack(CollectionTaskVo collectionTaskVo, SysUser sysUser) {
        if (StringUtils.isTrimBlank(collectionTaskVo.getTaskId())){
            throw new FmsServiceException("参数不正确");
        }
        ActRuTaskVo actRuTaskVo = ActCollectionTaskUtils.approvalReturnSuperior(collectionTaskVo.getTaskId());
        collectionTaskVo.setCollectionTaskStatus(actRuTaskVo.getTaskCode());//任务状态
        collectionTaskVo.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点用户
        //更新催收任务表
        collectionTaskRepository.updateByPrimaryKeySelectiveData(collectionTaskVo.getEntity());

        //保存登录日志
        saveWorkFlowLog(sysUser.getUser(), ActTypeEnums.SENDBACK.getType(), collectionTaskVo, actRuTaskVo.getTaskCode());
    }

    /**
     * 上门催收登记暂存
     *
     * @param collectionTaskVo
     * @param sysUser
     * @return
     */
    @Override
    @Transactional
    public void collectionRegisterTemporary(CollectionTaskVo collectionTaskVo, SysUser sysUser) {
        if (collectionTaskVo == null){
            throw new FmsServiceException("参数不正确");
        }
        if (ArrayUtils.isNotNullAndLengthNotZero(collectionTaskVo.getBizFilesList())){
            //保存附件信息
            bizFilesService.modifyBizFilesList(collectionTaskVo.getBizFilesList(),collectionTaskVo.getCollectionTaskNo(),
                    BizCodeTypeEnums.COLLECTION_FILE.getCodeType());
        }
        //更新上门催收任务表
        collectionTaskRepository.updateByPrimaryKeySelectiveData(collectionTaskVo.getEntity());
    }

    /**
     * 校验是否存在未完成的任务
     *
     * @param overdueCstmId
     * @return
     */
    @Override
    public String isCollectionTaskExit(String overdueCstmId) {
        if (StringUtils.isTrimBlank(overdueCstmId)){
            throw new FmsServiceException("参数不正确");
        }
        String collectionTaskNo = "";
        Example example = SqlUtil.newExample(CollectionTask.class);
        example.createCriteria().andEqualTo("overdueCstmId", overdueCstmId);
        List<CollectionTask> collectionTaskList = collectionTaskRepository.selectListByExample(example);
        if (ArrayUtils.isNotNullAndLengthNotZero(collectionTaskList)){
            for (CollectionTask collectionTask : collectionTaskList){
                // 同一个overduecstmId对应的自动程序生成数据至多只会出现一条
                if (StringUtils.equals(DataSourceTypeEnums.AUTO.getType(), collectionTask.getDataSource())){
                    collectionTaskNo = collectionTask.getCollectionTaskNo();
                }
                // 如果状态为空，则说明是自动程序产生的数据，还未开启工作流，不做check
                if (StringUtils.isNotTrimBlank(collectionTask.getCollectionTaskStatus())){
                    if (!StringUtils.equals(BizStatusEnums.COLLECTION_REFUSE.getType(), collectionTask.getCollectionTaskStatus())
                            && !StringUtils.equals(BizStatusEnums.COLLECTION_END.getType(), collectionTask.getCollectionTaskStatus())
                            && !StringUtils.equals(BizStatusEnums.COLLECTION_TOBE_APPLY.getType(), collectionTask.getCollectionTaskStatus())){
                        throw new FmsServiceException("当前合同存在未结束的任务，请先结束任务再发起");
                    }
                }
            }
        }
        return collectionTaskNo;
    }

    /**
     * @Title:
     * @Description: 催收函下载
     * @param collectionTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:35
     */
    @Override
    public FileVo collectionLetterDownload(String collectionTaskNo) {
        FileVo fileVoResult = new FileVo();
        if (StringUtils.isTrimBlank(collectionTaskNo)){
            throw new FmsServiceException("参数不正确");
        }
        String cstmName = "";
        List<CollectionLetterVo> collectionLetterVoList = new ArrayList<>();
        // 获取当前客户办理所有合同信息
        List<OverdueCstmPostVo> overdueCstmPostVoList = collectionTaskRepository.selectContNoListByCollectionTaskNo(collectionTaskNo);
        if (ArrayUtils.isNotNullAndLengthNotZero(overdueCstmPostVoList)){
            for(OverdueCstmPostVo overdueCstmPostVo : overdueCstmPostVoList){
                // 获取每个合同生成催收函需要的数据
                CollectionLetterVo collectionLetterVo = overdueCstmRepository.selectCollectionLetterInfo(overdueCstmPostVo.getContNo());
                if (StringUtils.isTrimBlank(cstmName)){
                    cstmName = collectionLetterVo.getCstmName();// 获取承租人名称
                }
                collectionLetterVo.setApplyType(overdueCstmPostVo.getApplyType());// 设定申请类型
                collectionLetterVo.setFlag("collectionTask");// 设定从上门催收任务进入
                collectionLetterVoList.add(collectionLetterVo);
            }
        }
        List<FileVo> files = new ArrayList<>();
        if (ArrayUtils.isNotNullAndLengthNotZero(collectionLetterVoList)){
            for (CollectionLetterVo collectionLetterVo : collectionLetterVoList){
                // 获取银行机构信息
                BasBankInfo basBankInfoGroup = overdueCstmService.getBasBankInfo(collectionLetterVo.getBelongGroup());
                //pdf的参数
                Map<String,String> pdfVariables = JsonUtils.objectToMap(collectionLetterVo);
                // 设定赋值项目
                overdueCstmService.buildMapParams(collectionLetterVo.getContRepaySkedVoList(), basBankInfoGroup, pdfVariables);
                String filePath;
                FileVo fileVo;
                if (StringUtils.equals(ApplyTypeEnums.PERSON.getType(), collectionLetterVo.getApplyType())){
                    // 获取催告函个人承租人下载路径
                    filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.COLLECTION_LETTER_TASK_PER_CSTM.getType());
                    fileVo = new FileVo();
                    fileVo.setFileCompletePath(filePath);
                    fileVo.setFileName("催收函-个人"+"（"+collectionLetterVo.getContNo()+"）.pdf");
                    files.add(fileVo);
                    // 生成担保个人与担保企业pdf
                    overdueCstmService.pdfCreateGuarantee(collectionLetterVo, pdfVariables, files);
                } else {
                    // 获取催告函企业承租人下载路径
                    filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.COLLECTION_LETTER_TASK_COM_CSTM.getType());
                    fileVo = new FileVo();
                    fileVo.setFileCompletePath(filePath);
                    fileVo.setFileName("催收函-企业"+"（"+collectionLetterVo.getContNo()+"）.pdf");
                    files.add(fileVo);
                    // 生成担保个人与担保企业pdf
                    overdueCstmService.pdfCreateGuarantee(collectionLetterVo, pdfVariables, files);
                }
            }
        }
        String fileZipPath = CommonFileUtils.filesToZip(files,null);
        fileVoResult.setFilePath(fileZipPath);
        fileVoResult.setFileName("催收函（"+ cstmName + "）.zip");
        return fileVoResult;
    }

    /**
     * @Title:
     * @Description: 委托书下载
     * @param collectionTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:35
     */
    @Override
    public FileVo proxyDownload(String collectionTaskNo) {
        if (StringUtils.isTrimBlank(collectionTaskNo)){
            throw new FmsServiceException("参数不正确");
        }
        // 获取当前客户所有合同生成委托书需要的数据
        List<CollectionLetterVo> collectionLetterVoList = collectionTaskRepository.selectProxyLetterInfo(collectionTaskNo);
        // 初始化文件List
        List<FileVo> files = new ArrayList<>();
        // 构建需要生成的文件List
        String cstmName = getFiles(collectionLetterVoList, files);
        FileVo fileVo = new FileVo();
        // 获取打包下载路径
        String fileZipPath = CommonFileUtils.filesToZip(files,null);
        fileVo.setFilePath(fileZipPath);
        fileVo.setFileName("上门催收委托书（"+ cstmName + "）.zip");
        return fileVo;
    }

    /**
     * 律师函下载
     */
    @Override
    public FileVo lawyerLetterDownload(String collectionTaskNo) {
        if (StringUtils.isTrimBlank(collectionTaskNo)){
            throw new FmsServiceException("参数不正确");
        }
        String cstmName = "";
        // 获取催收函生成需要数据
        List<LawyerLetterVo> lawyerLetterVoList = collectionTaskRepository.selectLawyerLetterVoList(collectionTaskNo);
        List<FileVo> fileVoList = new ArrayList<>();
        for (LawyerLetterVo lawyerLetterVo : lawyerLetterVoList){
            if (lawyerLetterVo == null){
                throw new FmsServiceException("当前合同没有符合条件的逾期数据");
            }
            cstmName = lawyerLetterVo.getCstmName();
            // 获取银行机构信息
            BasBankInfo basBankInfoGroup = overdueCstmService.getBasBankInfo(lawyerLetterVo.getBelongGroup());

            //pdf的参数
            Map<String,String> pdfVariables = JsonUtils.objectToMap(lawyerLetterVo);
            // 设定赋值项目
            overdueCstmService.buildMapParams(lawyerLetterVo.getContRepaySkedVoList(), basBankInfoGroup, pdfVariables);
            Example example = SqlUtil.newExample(ContRepaySked.class);
            example.createCriteria().andEqualTo("contNo", lawyerLetterVo.getContNo()).andEqualTo("period", "1");
            ContRepaySked contRepaySked = contRepaySkedRepository.selectOneByExample(example);
            if (contRepaySked != null){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
                // 设定首期支付日期
                pdfVariables.put("firstRepayDate", sdf.format(contRepaySked.getRepayDate()));
            }
            String filePath ;
            if (StringUtils.equals(ApplyTypeEnums.PERSON.getType(), lawyerLetterVo.getApplyType())){
                // 生成承租人个人律师函
                filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.LAWYER_LETTER_PER.getType());
            } else {
                // 生成承租人企业律师函
                filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.LAWYER_LETTER_COM.getType());
            }
            FileVo fileVo = new FileVo();
            fileVo.setFileCompletePath(filePath);
            fileVo.setFileName("律师函-"+"（"+lawyerLetterVo.getContNo()+"）.pdf");
            fileVoList.add(fileVo);
        }
        FileVo fileResult = new FileVo();
        String fileZipPath = CommonFileUtils.filesToZip(fileVoList,null);
        fileResult.setFilePath(fileZipPath);
        fileResult.setFileName("律师函（"+cstmName+"）.zip");
        return fileResult;
    }

    /**
     * 构建需要生成的文件List
     * @param collectionLetterVoList
     * @param files
     */
    @Override
    public String getFiles(List<CollectionLetterVo> collectionLetterVoList, List<FileVo> files) {
        String cstmName = "";
        if (ArrayUtils.isNotNullAndLengthNotZero(collectionLetterVoList)){
            String filePath;
            FileVo fileVo;
            for (CollectionLetterVo collectionLetterVo : collectionLetterVoList){
                cstmName = collectionLetterVo.getCstmName();
                //pdf的参数
                Map<String,String> pdfVariables = JsonUtils.objectToMap(collectionLetterVo);
                // 获取授权委托书下载路径
                filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.PROXY_LETTER.getType());
                fileVo = new FileVo();
                fileVo.setFileCompletePath(filePath);
                fileVo.setFileName("授权委托书"+"（"+collectionLetterVo.getContNo()+"）.pdf");
                files.add(fileVo);
            }
        }
        return cstmName;
    }

}
