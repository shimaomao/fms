package cn.com.leadu.fms.insurance.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActInsurClaimCheckUtils;
import cn.com.leadu.fms.business.service.BizActStatusService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.finance.*;
import cn.com.leadu.fms.common.constant.enums.insurance.ReturnModeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.VehMaintainEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.ContChargeRepository;
import cn.com.leadu.fms.data.finance.repository.ContReceiptExamRepository;
import cn.com.leadu.fms.data.finance.repository.ContReceiptRepository;
import cn.com.leadu.fms.data.insurance.repository.ContInsurClaimRepository;
import cn.com.leadu.fms.data.postbiz.repository.VehMaintainRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.insurance.service.InsurClaimCheckService;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.cost.entity.ContPrepayment;
import cn.com.leadu.fms.pojo.finance.entity.ContCharge;
import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import cn.com.leadu.fms.pojo.finance.entity.ContReceiptExam;
import cn.com.leadu.fms.pojo.insurance.entity.ContInsurClaim;
import cn.com.leadu.fms.pojo.insurance.vo.continsurclaim.ContInsurClaimVo;
import cn.com.leadu.fms.pojo.postbiz.entity.VehMaintain;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.APPROVAL;
import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SENDBACK;

/**
 * @description:    保险理赔审核
 * @author:ningyangyang
 * @since:2018/5/18
 */
@Service
public class InsurClaimCheckServiceImpl implements InsurClaimCheckService {

    @Autowired
    private ContInsurClaimRepository contInsurClaimRepository;

    /**
     * @Fields  : 审批日志录入service
     */
    @Autowired
    private WorkflowLogService workflowLogService;
    /**
     * @Fields  : 状态更新service
     */
    @Autowired
    private BizActStatusService bizActStatusService;

    /**
     * @Fields : 财务收款Repository
     */
    @Autowired
    private ContReceiptRepository contReceiptRepository;

    /**
     * @Fields  : 财务勾稽repository
     */
    @Autowired
    private ContReceiptExamRepository contReceiptExamRepository;

    /**
     * @Fields  : 财务待收款repository
     */
    @Autowired
    private ContChargeRepository contChargeRepository;

    /**
     * @Fields : 车辆维修记录Repository
     */
    @Autowired
    private VehMaintainRepository vehMaintainRepository;
    /**
     * @Title:
     * @Description: 审核通过
     * @param
     * @return void
     * @throws
     * @author yanfengbo
     */
    @Override
    @Transactional
    public void approval(ContInsurClaimVo contInsurClaimVo,SysUser sysUser) {
        auditPass(contInsurClaimVo,sysUser.getUser());
//        String claimStatus = contInsurClaimVo.getInsurClaimStatus();
//        if(claimStatus.equals(InsurClaimStatusEnums.TO_BE_APPROVAL.getType())||claimStatus.equals(InsurClaimStatusEnums.SEND_BACK_REVIEW.getType())){
//            auditPass(contInsurClaimVo,InsurClaimStatusEnums.TO_BE_REVIEW.getType());
//        }else if(claimStatus.equals(InsurClaimStatusEnums.SEND_BACK_APPROVAL.getType())){
//            auditPass(contInsurClaimVo,InsurClaimStatusEnums.TO_BE_APPROVAL.getType());
//        }
    }
    /**
     * @Title:
     * @Description: 退回上一级
     * @param
     * @return void
     * @throws
     * @author yanfengbo
     */
    @Override
    @Transactional
    public void sendBack(ContInsurClaimVo contInsurClaimVo,SysUser sysUser) {
        auditSendBack(contInsurClaimVo,sysUser.getUser());
//        String claimStatus = contInsurClaimVo.getInsurClaimStatus();
//          if(claimStatus.equals(InsurClaimStatusEnums.TO_BE_APPROVAL.getType())){
//              auditSendBack(contInsurClaimVo,InsurClaimStatusEnums.SEND_BACK_APPROVAL.getType());
//          }else if(claimStatus.equals(InsurClaimStatusEnums.SEND_BACK_REVIEW.getType())){
//              auditSendBack(contInsurClaimVo,InsurClaimStatusEnums.SEND_BACK_APPROVAL.getType());
//          }
    }

    /**
     * @Title:
     * @Description: 审核通过共同操作
     * @param
     * @return void
     * @throws
     * @author yanfengbo
     */
    public void  auditPass(ContInsurClaimVo contInsurClaimVo,String sysUser){
        //退还方式为退还客户和退还租金时,继续走流程
        ActRuTaskVo actRuTaskVo = ActInsurClaimCheckUtils.approvalAgree(contInsurClaimVo.getTaskId());
        Example example  = SqlUtil.newExample(ContInsurClaim.class);
        example.createCriteria().andEqualTo("contInsurClaimId",contInsurClaimVo.getContInsurClaimId());
        ContInsurClaim contInsurClaim = new ContInsurClaim();
        contInsurClaim.setInsurClaimStatus(actRuTaskVo.getTaskCode());
        contInsurClaim.setPresentUser(actRuTaskVo.getNextAssignee());
        contInsurClaimRepository.updateByExampleSelectiveData(contInsurClaim,example);

        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser);
        workflowLog.setWfLogNo(contInsurClaimVo.getContInsurClaimNo());
        workflowLog.setWfLogType(BizTypeEnums.CONT_INSUR_CLAIM.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(contInsurClaimVo.getRemark1());
        //workflowLog.setWfLogSubNo("");
        workflowLog.setActType(APPROVAL.getType());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());

        workflowLogService.insertWorkFlowLog(workflowLog);
    }


    /**
     * @Title:
     * @Description: 审核退回共同操作
     * @param
     * @return void
     * @throws
     * @author yanfengbo
     */
    public void  auditSendBack(ContInsurClaimVo contInsurClaimVo,String sysUser){
        ActRuTaskVo actRuTaskVo =   ActInsurClaimCheckUtils.approvalReturnSuperior(contInsurClaimVo.getTaskId());
        Example example  = SqlUtil.newExample(ContInsurClaim.class);
        example.createCriteria().andEqualTo("contInsurClaimId",contInsurClaimVo.getContInsurClaimId());
        ContInsurClaim contInsurClaim = new ContInsurClaim();
        contInsurClaim.setInsurClaimStatus(actRuTaskVo.getTaskCode());
        contInsurClaim.setPresentUser(actRuTaskVo.getNextAssignee());
        contInsurClaimRepository.updateByExampleSelectiveData(contInsurClaim,example);

        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser);
        workflowLog.setWfLogNo(contInsurClaimVo.getContInsurClaimNo());
        workflowLog.setWfLogType(BizTypeEnums.CONT_INSUR_CLAIM.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(contInsurClaimVo.getRemark1());
        //workflowLog.setWfLogSubNo("");
        workflowLog.setActType(SENDBACK.getType());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());

        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /**
     * @Title:
     * @Description: 流程结束后录入一条车辆维修记录
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public void saveVehMaintainFromInsurClaim(ContInsurClaimVo contInsurClaimVo,String contInsurClaimNo){
        //录入车辆维修记录
        VehMaintain vehMaintain = new VehMaintain();
        //来源
        vehMaintain.setMaintainFlag(VehMaintainEnums.MAINTAINCLAIM.getType());
        //理赔号
        vehMaintain.setContInsurClaimNo(contInsurClaimNo);
        //车架号
        vehMaintain.setVinNo(contInsurClaimVo.getVinNo());
        //发动机号
        vehMaintain.setEngineNo(contInsurClaimVo.getEngineNo());
        //车牌号
        vehMaintain.setVehicleLicenseNo(contInsurClaimVo.getVehicleLicenseNo());
        //维修日期--->事故日期
        vehMaintain.setMaintainDate(contInsurClaimVo.getAccidentTime());
        //维修金额--->理赔金额
        vehMaintain.setMaintainAmount(contInsurClaimVo.getClaimAmount());
        //维修备注--->情况说明
        vehMaintain.setMaintainMemo(contInsurClaimVo.getDescription());
        vehMaintainRepository.insertData(vehMaintain);
    }

    /**
     * @Description: 保险理赔财务收款完成
     * @param:
     * @return:
     * @Author: fangshaofeng
     * @Date: 2018/10/19 17:23
     */
    @Override
    @Transactional
    public void Receivables(ContInsurClaimVo contInsurClaimVo,SysUser sysUser) {
        //插入财务应收金额数据
        ContCharge contCharge = new ContCharge();
        contCharge.setChargeBizType(BizTypeEnums.CONT_INSUR_CLAIM.getType());//业务类型为保险理赔
        contCharge.setChargeBizId(contInsurClaimVo.getContInsurClaimNo());//业务号为保险理赔任务号
        contCharge.setChargeFund(PayFundNameEnums.Insurance_AMOUNT.getType());//款项名称为保险理赔金
        contCharge.setChargeAmount(contInsurClaimVo.getClaimAmount());//应收款金额
        contCharge.setChargeActualAmount(contInsurClaimVo.getReceiptsAmount()); //实收款金额
        contCharge.setChargeStatus(ChargeStatusEnums.COLLECTION.getType());//收款状态为已收款
        contCharge.setChargeDetailFlag(ChargeDetailFlagEnums.TOTAL.getType());//明细区分
        contChargeRepository.insertData(contCharge);
        //保存财务收款数据
        for(ContReceipt contReceipt : contInsurClaimVo.getContReceiptList()){
            contReceipt.setInputMode(InputModeEnums.INPUT.getType());
            contReceiptRepository.insertData(contReceipt);
            //保存勾稽数据
            ContReceiptExam contReceiptExam = new ContReceiptExam();
            contReceiptExam.setReceiptBizType(ReceiptBizTypeEnums.TO_BE_FIN_RECEIPT.getType());
            contReceiptExam.setReceiptBizId(contCharge.getContChargeId());
            contReceiptExam.setContReceiptId(contReceipt.getContReceiptId());
            contReceiptExam.setExamType(ExamTypeEnums.FIN_RECEIPT.getType());
            contReceiptExam.setReceiptExamAmount(contReceipt.getReceiptAmount());
            contReceiptExam.setReceiptExamStatus(ReceiptExamStatusEnums.ALREADY_CHECKED.getType());
            contReceiptExamRepository.insertData(contReceiptExam);
        }
        ActRuTaskVo actRuTaskVo = null;
        //退还方式为退还客户时,继续走流程
        if (contInsurClaimVo.getReturnMode().equals(ReturnModeEnums.RETURN.getType())){
            actRuTaskVo =   ActInsurClaimCheckUtils.approvalAgree(contInsurClaimVo.getTaskId());
        }else if (contInsurClaimVo.getReturnMode().equals(ReturnModeEnums.DEDUCTION.getType())){//退还方式为抵扣押金时,并录入财务收款表结束流程
            actRuTaskVo =   ActInsurClaimCheckUtils.approvalAgreeToEnd(contInsurClaimVo.getTaskId());
            //录入财务收款表
            ContReceipt  contReceipt = new ContReceipt();
            //数据来源
            contReceipt.setInputMode(InputModeEnums.INTER.getType());
            //理赔金额--->到账金额
            contReceipt.setReceiptAmount(contInsurClaimVo.getClaimAmount());
            //理赔金额--->剩余金额
            contReceipt.setRestAmount(contInsurClaimVo.getClaimAmount());
            //合同号--->摘要
            String memo = "保险理赔款,任务号："+contInsurClaimVo.getContInsurClaimNo()+",合同号："+contInsurClaimVo.getContNo();
            contReceipt.setMemo(memo);
            //录入财务收款表
            contReceiptRepository.insertData(contReceipt);
            //录入车辆维修记录
            saveVehMaintainFromInsurClaim(contInsurClaimVo,contInsurClaimVo.getContInsurClaimNo());
        }else {
            throw new FmsServiceException("退还方式信息有误!");
        }
        Example example  = SqlUtil.newExample(ContInsurClaim.class);
        example.createCriteria().andEqualTo("contInsurClaimId",contInsurClaimVo.getContInsurClaimId());
        ContInsurClaim contInsurClaim = new ContInsurClaim();
        contInsurClaim.setInsurClaimStatus(actRuTaskVo.getTaskCode());
        contInsurClaim.setPresentUser(actRuTaskVo.getNextAssignee());
        contInsurClaimRepository.updateByExampleSelectiveData(contInsurClaim,example);

        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogNo(contInsurClaimVo.getContInsurClaimNo());
        workflowLog.setWfLogType(BizTypeEnums.CONT_INSUR_CLAIM.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(contInsurClaimVo.getRemark1());
        workflowLog.setActType(APPROVAL.getType());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());

        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /**
     * @Description: 保险理赔财务收款返回上一级
     * @param:
     * @return:
     * @Author: fangshaofeng
     * @Date: 2018/10/22 17:23
     */
    @Override
    @Transactional
    public void refunds(ContInsurClaimVo contInsurClaimVo,SysUser sysUser) {
        auditSendBack(contInsurClaimVo,sysUser.getUser());
    }
}
