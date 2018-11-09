package cn.com.leadu.fms.cost.service.impl;/**
 * Created by yyq on 2018/5/30.
 */

import cn.com.leadu.fms.business.common.util.activiti.ActGpsMonthlyUtils;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.ApproveFlagEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.cost.service.MonthlySettlementApproveService;
import cn.com.leadu.fms.cost.service.MonthlySettlementService;
import cn.com.leadu.fms.cost.validator.monthlysettlement.vo.MonthlySettlementModifyVo;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.cost.entity.MonthlySettlement;
import cn.com.leadu.fms.pojo.cost.vo.monthlysettlementApprove.MonthlySettlementApproveVo;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @program: fms
 * @description:gps月结审批业务层
 * @author: yangyiquan
 * @create: 2018-05-30 16:36
 **/
@Service
public class MonthlySettlementApproveServiceImpl implements MonthlySettlementApproveService {

    /**
     * @Fields  : gps月结任务表service
     */
    @Autowired
    private MonthlySettlementService monthlySettlementService;

    /**
     * @Fields  : 审批日志录入service
     */
    @Autowired
    private WorkflowLogService workflowLogService;

    /**
     * @param monthlySettlementApproveVo
     * @Description: 审批操作
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/30 16:35
     */
    @Override
    @Transactional
    public void approval(MonthlySettlementApproveVo monthlySettlementApproveVo) {
        ActRuTaskVo actRuTaskVo = null;
        String act = "";
        //流程引擎
        if(ApproveFlagEnums.SUBMIT.getType().equals(monthlySettlementApproveVo.getApprovalFlag())){//通过
            act = ActTypeEnums.APPROVAL.getType();
            actRuTaskVo = ActGpsMonthlyUtils.approvalAgree(monthlySettlementApproveVo.getTaskId());
        }else if(ApproveFlagEnums.BACK.getType().equals(monthlySettlementApproveVo.getApprovalFlag())){//退回
            act = ActTypeEnums.SENDBACK.getType();
            actRuTaskVo = ActGpsMonthlyUtils.approvalReturnSuperior(monthlySettlementApproveVo.getTaskId());
        }else{
            throw new FmsServiceException("没有对应的操作");
        }
        this.approveCommon(monthlySettlementApproveVo,act,actRuTaskVo);
    }

    /** 
    * @Description: 审批共同操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/5 15:20
    */
    @Override
    @Transactional
    public void approveCommon(MonthlySettlementApproveVo monthlySettlementApproveVo, String act, ActRuTaskVo actRuTaskVo){
        //审批操作
        //根据任务号取得gps月结信息
        MonthlySettlement monthlySettlement = monthlySettlementService.findMonthlySettlementBySettlementNo(monthlySettlementApproveVo.getMonthlySettlementNo());
        if(monthlySettlement == null){
            throw new FmsServiceException( "gps月结信息不存在");
        }
        //更新状态
        String contractBizStatusUpd = actRuTaskVo.getTaskCode();
        MonthlySettlementModifyVo monthlySettlementModifyVo = new MonthlySettlementModifyVo();
        monthlySettlementModifyVo.setMonthlySts(contractBizStatusUpd);
        monthlySettlementModifyVo.setMonthlySettlementId(monthlySettlement.getMonthlySettlementId());
        //当前节点用户
        monthlySettlementModifyVo.setPresentUser(actRuTaskVo.getNextAssignee());
        monthlySettlementService.modifyMonthlySettlement(monthlySettlementModifyVo);

        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(monthlySettlementApproveVo.getUser());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(monthlySettlementApproveVo.getMemo());
        workflowLog.setWfLogType(BizTypeEnums.GPS_MONTHLY.getType());
        workflowLog.setWfLogNo(monthlySettlementApproveVo.getMonthlySettlementNo());
        workflowLog.setStatus(contractBizStatusUpd);
        workflowLog.setActType(act);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }


}
