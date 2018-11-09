package cn.com.leadu.fms.prebiz.service.impl;/**
 * Created by yyq on 2018/6/30.
 */

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActContGenerationStatusEnums;
import cn.com.leadu.fms.business.common.util.activiti.ActContractGenerationUtils;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyStatusEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApproveAgreePersonEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.prebiz.entity.Apply;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.prebiz.vo.applymanageapprove.ApplyManageApproveVo;
import cn.com.leadu.fms.prebiz.service.ApplyManageApproveService;
import cn.com.leadu.fms.prebiz.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.APPROVAL;
import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.BACK_DIRECTOR;
import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SENDBACK;

/**
 * @program: fms
 * @description: 总经理审核
 * @author: yangyiquan
 * @create: 2018-06-30 15:29
 **/
@Service
public class ApplyManageApproveServiceImpl implements ApplyManageApproveService {
    /**
     * @Fields  : 日志业务层
     */
    @Autowired
    private WorkflowLogService workflowLogService;
    /**
     * @Fields  : 申请信息业务层
     */
    @Autowired
    private ApplyService applyService;

    /**
     * @param applyManageApproveVo
     * @Description: 总经理审核通过
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/30 15:36
     */
    @Override
    @Transactional
    public void approval(ApplyManageApproveVo applyManageApproveVo) {

        //根据订单编号取得订单信息
        Apply apply = applyService.findApplyByApplyNo(applyManageApproveVo.getApplyNo());
        if(apply == null){
            throw new FmsServiceException( "订单信息不存在");
        }
        apply.setApplyPassDate(new Date());//审批通过日期
        if(!(YesNoFlagEnums.YES.getType().equals(apply.getApproveFlag())
                && ApproveAgreePersonEnums.PRE_AGREE.getType().equals(apply.getApproveFlagPerson()))){//如果不是副总有条件同意
            apply.setFinalApprovalStatus(ApplyStatusEnums.AGREE.getType());//终审状态，同意
        }
        //更新订单信息
        applyService.modifyApply(apply);
        //流程引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalAgree(applyManageApproveVo.getTaskId());
        //审批共同操作
        applyApproveCommon(applyManageApproveVo, APPROVAL.getType(), actRuTaskVo);
    }

    /**
     * @param applyManageApproveVo
     * @Description: 总经理审核退回
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/30 15:51
     */
    @Override
    @Transactional
    public void sendBack(ApplyManageApproveVo applyManageApproveVo) {
        //流程引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalReturnSuperior(applyManageApproveVo.getTaskId());
        //审批共同操作
        applyApproveCommon(applyManageApproveVo, SENDBACK.getType(), actRuTaskVo);
    }

    /**
    * @Description: 退回风控经理
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/27 11:48
    */
    @Override
    @Transactional
    public void backToDiragree(ApplyManageApproveVo applyManageApproveVo) {
        //流程引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalWithState(applyManageApproveVo.getTaskId(), ActContGenerationStatusEnums.MANAGE_DIRECTOR.getStatus());
        //审批共同操作
        applyApproveCommon(applyManageApproveVo, BACK_DIRECTOR.getType(), actRuTaskVo);
    }

    /** 
    * @Description: 审批共同操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/30 15:56
    */ 
    private void applyApproveCommon(ApplyManageApproveVo applyManageApproveVo, String act, ActRuTaskVo actRuTaskVo) {

        //根据订单编号取得订单信息
        Apply apply = applyService.findApplyByApplyNo(applyManageApproveVo.getApplyNo());
        if(apply == null){
            throw new FmsServiceException( "订单信息不存在");
        }
        //更新订单状态
        String applyBizStatusUpd = actRuTaskVo.getTaskCode();
        if(StringUtils.isTrimBlank(applyBizStatusUpd)){
            throw new FmsServiceException( "订单状态取得失败");
        }
        Apply applyUpd = new Apply();
        applyUpd.setApplyId(apply.getApplyId());
        applyUpd.setBizStatus(applyBizStatusUpd);
        applyUpd.setPresentUser(actRuTaskVo.getNextAssignee());
        applyService.updateApplyBizStsByApplyId(applyUpd);

        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(applyManageApproveVo.getUser());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(applyManageApproveVo.getMemo());
        workflowLog.setWfLogType(BizTypeEnums.BEFORE_CREDIT.getType());
        workflowLog.setWfLogNo(applyManageApproveVo.getApplyNo());
        workflowLog.setStatus(applyBizStatusUpd);
        workflowLog.setActType(act);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }
}
