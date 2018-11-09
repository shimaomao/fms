package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActContractGenerationUtils;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyStatusEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.prebiz.entity.Apply;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.prebiz.vo.applyapprove.ApplyApproveVo;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.prebiz.service.ApplyApproveService;
import cn.com.leadu.fms.prebiz.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.*;

/**
 * @author liujinge
 * @ClassName: ApplyApproveServiceImpl
 * @Description: 区域经理审核
 * @date 2018-03-23
 */
@Service
public class ApplyApproveServiceImpl implements ApplyApproveService {
    /**
     * @Fields  :
     */
    @Autowired
    private ApplyService applyService;

    /**
     * @Fields  :
     */
    @Autowired
    private WorkflowLogService workflowLogService;

    /**
     * @Fields  : 附件操作service
     * @author qiaomengnan
     */
    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Title:
     * @Description: 区域经理审批通过
     * @param: applyApproveVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018/4/17  21:29
     */
    @Override
    @Transactional
    public void approval(ApplyApproveVo applyApproveVo){
        saveBizFilesListVos(applyApproveVo);
        //流程引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalAgree(applyApproveVo.getTaskId());
        applyApproveCommon(applyApproveVo, APPROVAL.getType(), actRuTaskVo);
    }

    /**
     * @Title:
     * @Description: 审批拒绝
     * @param:  applyApproveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/17  21:29
     */
    @Override
    @Transactional
    public void refuse(ApplyApproveVo applyApproveVo){
        //流程引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalRefuse(applyApproveVo.getTaskId());

        applyApproveCommon(applyApproveVo, REFUSE.getType(), actRuTaskVo);
    }

    /**
     * @Title:
     * @Description: 区域经理审批退回
     * @param:  applyApproveVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018/4/17  21:29
     */
    @Override
    @Transactional
    public void sendBack(ApplyApproveVo applyApproveVo){
        //流程引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalReturnSuperior(applyApproveVo.getTaskId());

        applyApproveCommon(applyApproveVo, SENDBACK.getType(), actRuTaskVo);
    }

    /**
     * @Title:
     * @Description: 退回经销商
     * @param:  applyApproveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/17  21:30
     */
    @Override
    @Transactional
    public void sendBackTop(ApplyApproveVo applyApproveVo){
        //流程引擎
        ActRuTaskVo actRuTaskVo = ActContractGenerationUtils.approvalReturnDealer(applyApproveVo.getTaskId());

        applyApproveCommon(applyApproveVo, SENDBACKTOP.getType(), actRuTaskVo);
    }

    /*
     *风控审核共通操作：更新订单状态、审批日志录入
     */
    public void applyApproveCommon(ApplyApproveVo applyApproveVo, String act, ActRuTaskVo actRuTaskVo) {
        //根据订单编号更新订单状态
        String applyNo = applyApproveVo.getApplyNo();

        //根据订单编号取得订单信息
        Apply apply = applyService.findApplyByApplyNo(applyNo);
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
        if(APPROVAL.getType().equals(act)){//设置审批状态为审批中
            applyUpd.setWindcontrApprovalStatus(ApplyStatusEnums.APPROVAL.getType());
//            applyUpd.setFinalApprovalStatus(ApplyStatusEnums.APPROVAL.getType());
        }
        applyService.updateApplyBizStsByApplyId(applyUpd);
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(applyApproveVo.getUser());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(applyApproveVo.getRemark1());
        workflowLog.setWfLogType(BizTypeEnums.BEFORE_CREDIT.getType());
        workflowLog.setWfLogNo(applyApproveVo.getApplyNo());
        workflowLog.setStatus(applyBizStatusUpd);
        workflowLog.setActType(act);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /**
     * @Title:
     * @Description: 审批保存附件
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/5/7  14:40
     */
    private void saveBizFilesListVos(ApplyApproveVo applyApproveVo){
        if(applyApproveVo != null) {
            //初审才可以上传附件
            if("1".equals(applyApproveVo.getDetailFlag()))
                bizFilesService.updateBizFiles(applyApproveVo.getBizFilesListVos(), applyApproveVo.getApplyNo(), BizCodeTypeEnums.APPLY_ARPPROVE.getCodeType());
        }
    }

    /**
     * @Title:
     * @Description: 获取审批附件
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/5/7  14:40
     */
    public CommonBizFilesVo findBizFileByApplyNo(String applyNo){
        CommonBizFilesVo bizFilesVo =  bizFilesService.findBizFilesByBizCode(applyNo,BizCodeTypeEnums.APPLY_ARPPROVE.getCodeType());
        return bizFilesVo;
    }

}