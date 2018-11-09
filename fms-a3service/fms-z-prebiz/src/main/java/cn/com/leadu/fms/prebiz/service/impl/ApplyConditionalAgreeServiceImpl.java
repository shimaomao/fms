package cn.com.leadu.fms.prebiz.service.impl;/**
 * Created by yyq on 2018/6/22.
 */

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActContGenerationFlagEnums;
import cn.com.leadu.fms.business.common.constant.enums.activiti.ActContGenerationStatusEnums;
import cn.com.leadu.fms.business.common.util.activiti.ActContractGenerationUtils;
import cn.com.leadu.fms.business.service.CommonConstantService;
import cn.com.leadu.fms.business.service.CommonSysUserInfoService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.CommonParamConstants;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.CommonUserUnitsEnums;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.insurance.InfoCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyConditionalAgreeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyStatusEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApproveAgreeFlagEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApproveAgreePersonEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.BigDecimalUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.prebiz.entity.Apply;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyFinance;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.prebiz.vo.applyConditionalAgree.ApplyConditionalAgreeVo;
import cn.com.leadu.fms.pojo.prebiz.vo.quotationdevice.QuotationDeviceVo;
import cn.com.leadu.fms.prebiz.service.ApplyConditionalAgreeService;
import cn.com.leadu.fms.prebiz.service.ApplyFinanceService;
import cn.com.leadu.fms.prebiz.service.ApplyService;
import cn.com.leadu.fms.prebiz.service.QuotationDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: fms
 * @description: 申请有条件同意审批业务层
 * @author: yangyiquan
 * @create: 2018-06-22 11:54
 **/
@Service
public class ApplyConditionalAgreeServiceImpl implements ApplyConditionalAgreeService{
    /**
     * @Fields  : 日志业务层
     */
    @Autowired
    private WorkflowLogService workflowLogService;
    /**
     * @Fields  : 融资信息业务实现层
     */
    @Autowired
    private ApplyFinanceService applyFinanceService;
    /**
     * @Fields  : 申请信息业务层
     */
    @Autowired
    private ApplyService applyService;

    /**
     * 报价器信息业务层
     */
    @Autowired
    private QuotationDeviceService quotationDeviceService;

    /**
     * 系统常量Service
     */
    @Autowired
    private CommonConstantService commonConstantService;

    /**
     * @Fields  : 消息提示共通repository
     */
    @Autowired
    private CommonSysUserInfoService commonSysUserInfoService;

    /**
     * @param applyNo
     * @Description: 获取有条件同意申请融资信息，构造有条件同意默认定金，首付，尾付
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/22 12:03
     */
    @Override
    public ApplyFinance findApplyFinanceByApplyNo(String applyNo) {
        ApplyFinance applyFinance = applyFinanceService.findApplyFinanceByApplyNo(applyNo);
        if(applyFinance.getInitAmountAgree() == null){
            applyFinance.setInitPercAgree(applyFinance.getInitPerc());
            applyFinance.setInitAmountAgree(applyFinance.getInitAmount());
            applyFinance.setFinalPercAgree(applyFinance.getFinalPerc());
            applyFinance.setFinalAmountAgree(applyFinance.getFinalAmount());
            applyFinance.setDepositPercAgree(applyFinance.getDepositPerc());
            applyFinance.setDepositAgree(applyFinance.getDeposit());

            applyFinance.setRentAgree(applyFinance.getRent());
            applyFinance.setIrrAgree(applyFinance.getIrr());
            applyFinance.setTaxAgree(applyFinance.getTax());
            applyFinance.setFinTotalAgree(applyFinance.getFinTotal());
        }
        return applyFinance;
    }

    /**
     * @param applyNo
     * @Description: 获取有条件同意vo
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/4 11:55
     */
    @Override
    public ApplyConditionalAgreeVo findApplyConditionalAgreeVoByApplyNo(String applyNo) {
        Apply apply = applyService.findApplyByApplyNo(applyNo);
        ApplyConditionalAgreeVo applyConditionalAgreeVo = new ApplyConditionalAgreeVo();
        if(StringUtils.isNotTrimBlank(apply.getMortgageFlag())){
            applyConditionalAgreeVo.setMortgageFlag(apply.getMortgageFlag());
        }else{
            applyConditionalAgreeVo.setMortgageFlag(YesNoFlagEnums.YES.getType());//默认适合抵押
        }
        //风控经理操作建议
        if(apply != null){
            applyConditionalAgreeVo.setWindcontrManagerProposal(apply.getWindcontrManagerProposal());
        }
        applyConditionalAgreeVo.setApplyFinance(this.findApplyFinanceByApplyNo(applyNo));
        applyConditionalAgreeVo.setRiskAmount(applyService.riskAmountWithApply(applyNo));
        return applyConditionalAgreeVo;
    }

    /**
     * @param applyConditionalAgreeVo
     * @Description: 是否有条件同意审批通用操作
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/22 15:36
     */
    @Override
    @Transactional
    public void approve(ApplyConditionalAgreeVo applyConditionalAgreeVo) {
        //流程引擎
        ActRuTaskVo actRuTaskVo = null;

        if(ApplyConditionalAgreeEnums.AGREE.getType().equals(applyConditionalAgreeVo.getActType())){
            Apply apply = new Apply();
            //风控经理操作建议
            apply.setWindcontrManagerProposal(applyConditionalAgreeVo.getWindcontrManagerProposal());

            //主管审核
            if(ActContGenerationFlagEnums.CONTRACT_GENERATION_DIRAGREE.getFlag().equals(applyConditionalAgreeVo.getTaskDefinitionKey())){
                apply.setMortgageFlag(applyConditionalAgreeVo.getMortgageFlag());//保存是否适合抵押
                apply.setWindcontrApprovalStatus(ApplyStatusEnums.AGREE.getType());//风控审批同意
                apply.setFinalApprovalStatus(ApplyStatusEnums.APPROVAL.getType());//终审审批中
                //流程引擎，提交下一步
                actRuTaskVo = ActContractGenerationUtils.approvalAgree(applyConditionalAgreeVo.getTaskId());
            }else{//副总审核
                //当前融资额
                BigDecimal riskAmountNow = BigDecimal.ZERO;
                //当前申请信息（融资额-保证金-首期租金）
                ApplyFinance applyFinanceNow = applyConditionalAgreeVo.getApplyFinance();
                if(applyFinanceNow != null)
                    riskAmountNow = BigDecimalUtils.getNotNullBigDecimal(applyFinanceNow.getFinTotal()).subtract(BigDecimalUtils.getNotNullBigDecimal(applyFinanceNow.getDeposit()))
                        .subtract(BigDecimalUtils.getNotNullBigDecimal(applyFinanceNow.getRent()));

                String certifNo = applyService.findApplyCertifNoByApplyNo(applyConditionalAgreeVo.getApplyNo());//获取证件号码
                BigDecimal riskAmout = applyService.riskAmount(applyConditionalAgreeVo.getApplyNo(), applyConditionalAgreeVo.getApplyType(), certifNo);//计算风险融资额
                String singleFinAmount = commonConstantService.findSysParamValue(CommonParamConstants.SINGLE_FIN_AMOUNT);//单车融资额上限
                String cumulativeFinAmount = commonConstantService.findSysParamValue(CommonParamConstants.CUMULATIVE_FIN_AMOUNT);//累积融资额上限
                if(new BigDecimal(singleFinAmount).compareTo(riskAmountNow)<0 //单车融资额50W
                        || new BigDecimal(cumulativeFinAmount).compareTo(riskAmout.add(riskAmountNow))<0){//或累积80W
                    //流程引擎，走向总经理审核
                    actRuTaskVo = ActContractGenerationUtils.approvalWithState(applyConditionalAgreeVo.getTaskId(),ActContGenerationStatusEnums.MANAGE.getStatus());
                }else{
                    apply.setApplyPassDate(new Date());//审批通过日期
                    apply.setFinalApprovalStatus(ApplyStatusEnums.AGREE.getType());//终审状态
                    //流程引擎，提交下一步
                    actRuTaskVo = ActContractGenerationUtils.approvalAgree(applyConditionalAgreeVo.getTaskId());
                    //发消息给总经理
                    noticeManage(applyConditionalAgreeVo.getApplyNo());
                }
            }
            //更新订单信息
            applyService.updateApplyByApplyNo(apply, applyConditionalAgreeVo.getApplyNo());
            //同意日志记录
            applyApproveCommon(applyConditionalAgreeVo, ActTypeEnums.APPROVAL.getType(), actRuTaskVo);

        }else if(ApplyConditionalAgreeEnums.CONDITIONAL_AGREE.getType().equals(applyConditionalAgreeVo.getActType())){
            Apply apply = new Apply();
            //风控经理操作建议
            apply.setWindcontrManagerProposal(applyConditionalAgreeVo.getWindcontrManagerProposal());
            if(ActContGenerationFlagEnums.CONTRACT_GENERATION_DIRAGREE.getFlag().equals(applyConditionalAgreeVo.getTaskDefinitionKey())){//主管复核
                apply.setApproveFlagPerson(ApproveAgreePersonEnums.DIR_AGREE.getType());
                apply.setMortgageFlag(applyConditionalAgreeVo.getMortgageFlag());//保存是否适合抵押
                apply.setWindcontrApprovalStatus(ApplyStatusEnums.AGREE_CONDITIONAL.getType());//风控审批状态，有条件同意
            }else{//副总审核
                apply.setApproveFlagPerson(ApproveAgreePersonEnums.PRE_AGREE.getType());
            }
            applyService.updateApplyByApplyNo(apply, applyConditionalAgreeVo.getApplyNo());

            //万量报价器计算
            QuotationDeviceVo quotationDeviceVo= this.quotationCalculation(applyConditionalAgreeVo.getApplyFinance());
            if(BigDecimalUtils.notEqual(quotationDeviceVo.getIrr(),applyConditionalAgreeVo.getApplyFinance().getIrrAgree())){
                throw new FmsServiceException("IRR计算有误！");
            }
            if(BigDecimalUtils.notEqual(quotationDeviceVo.getMonthlySupply(),applyConditionalAgreeVo.getApplyFinance().getRentAgree())){
                throw new FmsServiceException("月供计算有误！");
            }
            if(BigDecimalUtils.notEqual(quotationDeviceVo.getTax(),applyConditionalAgreeVo.getApplyFinance().getTaxAgree())){
                throw new FmsServiceException("万量税费计算有误！");
            }

            //更新融资方案信息
            applyFinanceService.modifyApplyFinance(applyConditionalAgreeVo.getApplyFinance());
            //流程引擎
            actRuTaskVo = ActContractGenerationUtils.approvalWithState(applyConditionalAgreeVo.getTaskId(), ActContGenerationStatusEnums.CONDITIONAL_AGREE.getStatus());
            //有条件同意
            applyApproveCommon(applyConditionalAgreeVo, ActTypeEnums.CONDITIONAL_APPROVAL.getType(), actRuTaskVo);

        }else if(ApplyConditionalAgreeEnums.BACK.getType().equals(applyConditionalAgreeVo.getActType())){
            //流程引擎，退回上一级
            actRuTaskVo = ActContractGenerationUtils.approvalReturnSuperior(applyConditionalAgreeVo.getTaskId());
            //退回
            applyApproveCommon(applyConditionalAgreeVo, ActTypeEnums.SENDBACK.getType(), actRuTaskVo);

        }else if(ApplyConditionalAgreeEnums.REFUSE.getType().equals(applyConditionalAgreeVo.getActType())){
            Apply apply = new Apply();
            if(ActContGenerationFlagEnums.CONTRACT_GENERATION_DIRAGREE.getFlag().equals(applyConditionalAgreeVo.getTaskDefinitionKey())) {//主管复核
                //风控经理审批状态，拒绝
                apply.setWindcontrApprovalStatus(ApplyStatusEnums.REFUSE.getType());
            }else{
                //终审状态，拒绝
                apply.setFinalApprovalStatus(ApplyStatusEnums.REFUSE.getType());
            }
            applyService.updateApplyByApplyNo(apply, applyConditionalAgreeVo.getApplyNo());
            //流程引擎，结束
            actRuTaskVo = ActContractGenerationUtils.approvalRefuse(applyConditionalAgreeVo.getTaskId());
            //拒绝
            applyApproveCommon(applyConditionalAgreeVo, ActTypeEnums.REFUSE.getType(), actRuTaskVo);

        }else if(ApplyConditionalAgreeEnums.BACK_APPLY.getType().equals(applyConditionalAgreeVo.getActType())){
            //流程引擎，退回业务员
            actRuTaskVo = ActContractGenerationUtils.approvalWithState(applyConditionalAgreeVo.getTaskId(),ActContGenerationStatusEnums.DIRAGREE_BACK_APPLY.getStatus());
            //退回业务员
            applyApproveCommon(applyConditionalAgreeVo, ActTypeEnums.SENDBACKTOP.getType(), actRuTaskVo);

        }
    }

    /**
     * @param applyConditionalAgreeVo
     * @Description: 录入员是否同意操作
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/22 17:49
     */
    @Override
    @Transactional
    public void agreeOrNot(ApplyConditionalAgreeVo applyConditionalAgreeVo) {
        //流程引擎
        ActRuTaskVo actRuTaskVo = null;
        Apply apply = applyService.findApplyByApplyNo(applyConditionalAgreeVo.getApplyNo());

        if(ApplyConditionalAgreeEnums.AGREE.getType().equals(applyConditionalAgreeVo.getActType())){
            //更新融资方案信息
            ApplyFinance applyFinance = new ApplyFinance();
            applyFinance.setApplyFinId(applyConditionalAgreeVo.getApplyFinance().getApplyFinId());
            applyFinance.setInitPerc(applyConditionalAgreeVo.getApplyFinance().getInitPercAgree());
            applyFinance.setInitAmount(applyConditionalAgreeVo.getApplyFinance().getInitAmountAgree());
            applyFinance.setFinalPerc(applyConditionalAgreeVo.getApplyFinance().getFinalPercAgree());
            applyFinance.setFinalAmount(applyConditionalAgreeVo.getApplyFinance().getFinalAmountAgree());
            applyFinance.setDepositPerc(applyConditionalAgreeVo.getApplyFinance().getDepositPercAgree());
            applyFinance.setDeposit(applyConditionalAgreeVo.getApplyFinance().getDepositAgree());
            applyFinance.setFinTotal(applyConditionalAgreeVo.getApplyFinance().getFinTotalAgree());
            //万量报价器相关
            applyFinance.setIrr(applyConditionalAgreeVo.getApplyFinance().getIrrAgree());
            applyFinance.setTax(applyConditionalAgreeVo.getApplyFinance().getTaxAgree());
            applyFinance.setRent(applyConditionalAgreeVo.getApplyFinance().getRentAgree());
            applyFinanceService.modifyApplyFinance(applyFinance);


            if(ApproveAgreePersonEnums.DIR_AGREE.getType().equals(apply.getApproveFlagPerson())){
                apply.setFinalApprovalStatus(ApplyStatusEnums.APPROVAL.getType());//终审审批中
                //流程引擎,如果是主管有条件同意，则走向副总
                actRuTaskVo = ActContractGenerationUtils.approvalWithState(applyConditionalAgreeVo.getTaskId(),
                    ActContGenerationStatusEnums.SALE_PRESIDENT.getStatus());
            }else{
                //终审状态，有条件同意
                apply.setFinalApprovalStatus(ApplyStatusEnums.AGREE_CONDITIONAL.getType());
                //当前融资额
                BigDecimal riskAmountNow = BigDecimal.ZERO;
                //当前申请信息（融资额-保证金-首期租金）
                ApplyFinance applyFinanceNow = applyConditionalAgreeVo.getApplyFinance();
                if(applyFinanceNow != null)
                    riskAmountNow = BigDecimalUtils.getNotNullBigDecimal(applyFinanceNow.getFinTotal()).subtract(BigDecimalUtils.getNotNullBigDecimal(applyFinanceNow.getDeposit()))
                            .subtract(BigDecimalUtils.getNotNullBigDecimal(applyFinanceNow.getRent()));

                String certifNo = applyService.findApplyCertifNoByApplyNo(applyConditionalAgreeVo.getApplyNo());//获取证件号码
                BigDecimal riskAmout = applyService.riskAmount(applyConditionalAgreeVo.getApplyNo(), applyConditionalAgreeVo.getApplyType(), certifNo);//计算风险融资额
                String singleFinAmount = commonConstantService.findSysParamValue(CommonParamConstants.SINGLE_FIN_AMOUNT);//单车融资额上限
                String cumulativeFinAmount = commonConstantService.findSysParamValue(CommonParamConstants.CUMULATIVE_FIN_AMOUNT);//累积融资额上限
                //流程引擎，如果是副总有条件同意
                if((new BigDecimal(singleFinAmount).compareTo(riskAmountNow)<0 //单车融资额50W
                        || new BigDecimal(cumulativeFinAmount).compareTo(riskAmout.add(riskAmountNow))<0)){//单车融资额50W或累积80W，走向总经理审核
                    actRuTaskVo = ActContractGenerationUtils.approvalWithState(applyConditionalAgreeVo.getTaskId(),ActContGenerationStatusEnums.MANAGE.getStatus());
                }else{//直接走向合同生成前确认
                    apply.setApplyPassDate(new Date());//审批通过日期
                    actRuTaskVo = ActContractGenerationUtils.approvalWithState(applyConditionalAgreeVo.getTaskId(),
                            ActContGenerationStatusEnums.SALE_CONFIRM.getStatus());
                    //发消息给总经理
                    noticeManage(applyConditionalAgreeVo.getApplyNo());
                }
            }
            apply.setApproveFlag(ApproveAgreeFlagEnums.CONDITIONAL_AGREE.getType());
            applyService.modifyApply(apply);

            //同意
            applyApproveCommon(applyConditionalAgreeVo, ActTypeEnums.APPROVAL.getType(), actRuTaskVo);

        }else if(ApplyConditionalAgreeEnums.NOT_AGREE.getType().equals(applyConditionalAgreeVo.getActType())){
            apply.setApproveFlag(ApproveAgreeFlagEnums.NOT_CONDITIONAL_AGREE.getType());
            applyService.modifyApply(apply);
            //流程引擎,退回经销商
            actRuTaskVo = ActContractGenerationUtils.approvalReturnDealer(applyConditionalAgreeVo.getTaskId());
            //不同意，退回发起人
            applyApproveCommon(applyConditionalAgreeVo, ActTypeEnums.SENDBACKTOP.getType(), actRuTaskVo);

        }
    }

    /** 
    * @Description: 审批共通操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/22 16:19
    */ 
    private void applyApproveCommon(ApplyConditionalAgreeVo applyConditionalAgreeVo, String act, ActRuTaskVo actRuTaskVo) {
        String applyNo = applyConditionalAgreeVo.getApplyNo();
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
        applyService.updateApplyBizStsByApplyId(applyUpd);
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(applyConditionalAgreeVo.getUser());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(applyConditionalAgreeVo.getMemo());
        workflowLog.setWfLogType(BizTypeEnums.BEFORE_CREDIT.getType());
        workflowLog.setWfLogNo(applyConditionalAgreeVo.getApplyNo());
        workflowLog.setStatus(applyBizStatusUpd);
        workflowLog.setActType(act);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /** 
    * @Description: 万量报价器计算
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/27 18:09
    */
    @Override
    public QuotationDeviceVo quotationCalculation(ApplyFinance applyFinance){
        QuotationDeviceVo quotationDeviceVo = quotationDeviceService.findQuotationDeviceByQuotationDeviceId(applyFinance.getQuotationDeviceId());
        quotationDeviceVo.setDownPaymentRatio(applyFinance.getInitPercAgree());
        quotationDeviceVo.setFirstPayment(applyFinance.getInitAmountAgree());
        quotationDeviceVo.setTailProportion(applyFinance.getFinalPercAgree());
        quotationDeviceVo.setTailMoney(applyFinance.getFinalAmountAgree());
        quotationDeviceVo.setMarginLevel(applyFinance.getDepositPercAgree());
        quotationDeviceVo.setBond(applyFinance.getDepositAgree());
        quotationDeviceVo.setFinancingAmount(applyFinance.getFinTotalAgree());
        //万量报价器计算
        quotationDeviceVo = quotationDeviceService.saveQuotationDeviceInfo(quotationDeviceVo,"1");
        return quotationDeviceVo;
    }

    /** 
    * @Description: 没通过总经理发消息给总经理
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/14 18:13
    */ 
    private void noticeManage(String applyNo){
        Map<String,String> map = new HashMap<>();
        map.put("applyNo", applyNo);
        String defaultTpl = "您好，有一条新申请${applyNo}已通过风控审批";
        commonSysUserInfoService.infoPoint(CommonUserUnitsEnums.ROLE.getUnit(),"Z101", TplTypeKeyEnums.RISK_PASS_NOTICE_MANAGE.getType(),map, InfoCodeTypeEnums.APPLY_LIST.getType(),defaultTpl);
    }

}
