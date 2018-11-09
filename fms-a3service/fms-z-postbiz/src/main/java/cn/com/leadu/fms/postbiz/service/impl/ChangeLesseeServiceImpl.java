package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActChangeLesseeUtils;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.baseinfo.BankOrganizationTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.ChangeLesseeStatusEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasBankInfo;
import cn.com.leadu.fms.pojo.prebiz.entity.*;
import cn.com.leadu.fms.pojo.prebiz.vo.contcreate.ContCreateVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinDetailVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractfinance.ContractFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractvehicle.ContractVehicleVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.applyrisk.ApplyRiskVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.ChangeInfoOperateService;
import cn.com.leadu.fms.postbiz.service.ChangeLesseeService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.ChangeLesseeTaskRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.ChangeLesseeTask;
import cn.com.leadu.fms.pojo.postbiz.vo.changelesseetask.ChangeLesseeTaskVo;
import cn.com.leadu.fms.postbiz.validator.changelesseetask.vo.ChangeLesseeTaskSaveVo;
import cn.com.leadu.fms.postbiz.validator.changelesseetask.vo.ChangeLesseeTaskModifyVo;
import cn.com.leadu.fms.postbiz.validator.changelesseetask.vo.ChangeLesseeTaskDeleteVo;
import cn.com.leadu.fms.postbiz.validator.changelesseetask.vo.ChangeLesseeTaskDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: ChangeLesseeService
 * @Description: 承租人变更业务实现层
 */
@Service
public class ChangeLesseeServiceImpl implements ChangeLesseeService {

    /**
     * @Fields  : 承租人变更repository
     */
    @Autowired
    private ChangeLesseeTaskRepository changeLesseeTaskRepository;
    /**
     * @Fields  : 任务号获取service
     */
    @Autowired
    private NumGenerateService numGenerateService;
    /**
     * @Fields  : 变更信息操作service
     */
    @Autowired
    private ChangeInfoOperateService changeInfoOperateService;
    /**
     * @Fields  : 流程日志service
     */
    @Autowired
    private WorkflowLogService workflowLogService;

    /**
     * @Fields  : 附件信息service
     */
    @Autowired
    private BizFilesService bizFilesService;


    /**
     * @Title:
     * @Description:  根据contNo获取承租人变更
     * @param contNo
     * @return ChangeLesseeTask
     * @throws
     * @author ningyangyang
     * @date 2018-9-17 15:14:54
     */
    public ChangeLesseeTask findChangeLesseeTaskByContNo(String contNo){
        Example example = SqlUtil.newExample(ChangeLesseeTask.class);
        example.createCriteria().andEqualTo("contNo",contNo).andNotEqualTo("taskStatus",ChangeLesseeStatusEnums.COMPLETE.getType()).andNotEqualTo("taskStatus",ChangeLesseeStatusEnums.REFUSE.getType()).andNotEqualTo("taskStatus",ChangeLesseeStatusEnums.CANCEL.getType());
        return changeLesseeTaskRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description: 承租人变更风控复审
     * @param applyRiskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 15:14:54
     */
    @Override
    @Transactional
    public void submitRiskApprove(ApplyRiskVo applyRiskVo, SysUser sysUser) {
        ChangeLesseeTaskVo changeLesseeTaskVo = new ChangeLesseeTaskVo();
        //工作流
        ActRuTaskVo actRuTaskVo = ActChangeLesseeUtils.approvalAgree(applyRiskVo.getTaskId());
        //保存日志信息
        //this.saveWorkFlowLog(applyRiskVo,actRuTaskVo, ActTypeEnums.APPROVAL.getType(),sysUser);
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogNo(applyRiskVo.getTaskNo());
        workflowLog.setWfLogType(BizTypeEnums.CHANGE_LESSEE.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(applyRiskVo.getMemo());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLog.setActType(ActTypeEnums.APPROVAL.getType());
        workflowLogService.insertWorkFlowLog(workflowLog);
        //更新任务表
        changeLesseeTaskVo.setTaskStatus(actRuTaskVo.getTaskCode()); //任务状态
        changeLesseeTaskVo.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点人
        Example example = SqlUtil.newExample(ChangeLesseeTask.class);
        example.createCriteria().andEqualTo("taskNo",applyRiskVo.getTaskNo());
        changeLesseeTaskRepository.updateByExampleSelectiveData(changeLesseeTaskVo.getEntity(),example);
    }

    /**
     * @Title:
     * @Description: 承租人变更合同生成
     * @param changeLesseeTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 15:14:54
     */
    @Override
    @Transactional
    public void changeContGenerate(ChangeLesseeTaskVo changeLesseeTaskVo, SysUser sysUser) {
        //工作流
        ActRuTaskVo actRuTaskVo = ActChangeLesseeUtils.approvalAgree(changeLesseeTaskVo.getTaskId());
        //合同生成

        //保存审批日志信息
        saveWorkFlowLog(changeLesseeTaskVo,actRuTaskVo, ActTypeEnums.SUBMIT.getType(),sysUser);
        //更新任务表
        updateChangeLesseeTask(changeLesseeTaskVo,actRuTaskVo);
    }

    /**
     * @Title:
     * @Description: 承租人变更合同打印
     * @param changeLesseeTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 15:14:54
     */
    @Override
    @Transactional
    public void changeContPrint(ChangeLesseeTaskVo changeLesseeTaskVo, SysUser sysUser) {
        //工作流
        ActRuTaskVo actRuTaskVo = ActChangeLesseeUtils.approvalAgree(changeLesseeTaskVo.getTaskId());
        //保存打印合同
        bizFilesService.modifyBizFilesList(changeLesseeTaskVo.getContPrintFilesList(),changeLesseeTaskVo.getTaskNo(), BizCodeTypeEnums.CHANGE_CONTRACT_PRINT_FILE.getCodeType());
        //保存审批日志信息
        saveWorkFlowLog(changeLesseeTaskVo,actRuTaskVo, ActTypeEnums.SUBMIT.getType(),sysUser);
        //更新任务表
        updateChangeLesseeTask(changeLesseeTaskVo,actRuTaskVo);
    }

    /**
     * @Title:
     * @Description: 审批日志保存
     * @param
     * @return DeferTask
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @Transactional
    private void saveWorkFlowLog(ChangeLesseeTaskVo changeLesseeTaskVo, ActRuTaskVo actRuTaskVo, String actType, SysUser sysUser){
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogNo(changeLesseeTaskVo.getTaskNo());
        workflowLog.setWfLogType(BizTypeEnums.CHANGE_LESSEE.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(changeLesseeTaskVo.getMemo());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLog.setActType(actType);
        workflowLogService.insertWorkFlowLog(workflowLog);
        //updateChangeLesseeTask(changeLesseeTaskVo, actRuTaskVo);

    }
    /**
     * @Title:
     * @Description: 更新任务表信息
     * @param
     * @return DeferTask
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @Transactional
    private void updateChangeLesseeTask(ChangeLesseeTaskVo changeLesseeTaskVo, ActRuTaskVo actRuTaskVo) {
        //更新任务表
        changeLesseeTaskVo.setTaskStatus(actRuTaskVo.getTaskCode()); //任务状态
        changeLesseeTaskVo.setPresentUser(actRuTaskVo.getNextAssignee()); //当前节点人
        Example example = SqlUtil.newExample(ChangeLesseeTask.class);
        example.createCriteria().andEqualTo("taskNo",changeLesseeTaskVo.getTaskNo());
        changeLesseeTaskRepository.updateByExampleSelectiveData(changeLesseeTaskVo.getEntity(),example);
    }


    /**
     * @Title:
     * @Description: 承租人变更合同审核
     * @param changeLesseeTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 15:14:54
     */
    @Override
    @Transactional
    public void changeContApprove(ChangeLesseeTaskVo changeLesseeTaskVo, SysUser sysUser) {
        //工作流
        ActRuTaskVo actRuTaskVo = ActChangeLesseeUtils.approvalAgree(changeLesseeTaskVo.getTaskId());
        //保存审批日志信息
        saveWorkFlowLog(changeLesseeTaskVo,actRuTaskVo, ActTypeEnums.APPROVAL.getType(),sysUser);
        //更新任务表
        updateChangeLesseeTask(changeLesseeTaskVo,actRuTaskVo);
    }

    /**
     * @Title:
     * @Description: 承租人变更退回上一级
     * @param changeLesseeTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 15:14:54
     */
    @Override
    @Transactional
    public void sendBack(ChangeLesseeTaskVo changeLesseeTaskVo, SysUser sysUser) {
        //工作流
        ActRuTaskVo actRuTaskVo = ActChangeLesseeUtils.approvalReturnSuperior(changeLesseeTaskVo.getTaskId());
        //保存审批日志信息
        saveWorkFlowLog(changeLesseeTaskVo,actRuTaskVo, ActTypeEnums.SENDBACK.getType(),sysUser);
        //更新任务表
        updateChangeLesseeTask(changeLesseeTaskVo,actRuTaskVo);
    }

    /**
     * @Title:
     * @Description: 承租人变更拒绝
     * @param changeLesseeTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-9 15:14:54
     */
    @Override
    public void goRefuse(ChangeLesseeTaskVo changeLesseeTaskVo, SysUser sysUser) {
        //工作流
        ActRuTaskVo actRuTaskVo = ActChangeLesseeUtils.approvalToRefuse(changeLesseeTaskVo.getTaskId());
        actRuTaskVo.setTaskCode(ChangeLesseeStatusEnums.REFUSE.getType());
        actRuTaskVo.setNextAssignee("");
        //保存审批日志信息
        saveWorkFlowLog(changeLesseeTaskVo,actRuTaskVo, ActTypeEnums.REFUSE.getType(),sysUser);
        //更新任务表
        updateChangeLesseeTask(changeLesseeTaskVo,actRuTaskVo);
    }

    /**
     * @Title:
     * @Description: 承租人变更取消
     * @param deferTaskNo 展期任务号
     * @param memo 备注
     * @param sysUser 当前节点用户
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-11 15:14:54
     */
    @Override
    public void applyCacel(String deferTaskNo, String memo, SysUser sysUser) {
        //工作流
        ActRuTaskVo actRuTaskVo = ActChangeLesseeUtils.applyCancel(deferTaskNo);
        actRuTaskVo.setTaskCode(ChangeLesseeStatusEnums.CANCEL.getType());
        actRuTaskVo.setNextAssignee("");
        ChangeLesseeTaskVo changeLesseeTaskVo = new ChangeLesseeTaskVo();
        changeLesseeTaskVo.setTaskNo(deferTaskNo);
        changeLesseeTaskVo.setMemo(memo);
        //保存审批日志信息
        saveWorkFlowLog(changeLesseeTaskVo,actRuTaskVo, ActTypeEnums.CANCEL.getType(),sysUser);
        //更新任务表
        updateChangeLesseeTask(changeLesseeTaskVo,actRuTaskVo);
    }


}
