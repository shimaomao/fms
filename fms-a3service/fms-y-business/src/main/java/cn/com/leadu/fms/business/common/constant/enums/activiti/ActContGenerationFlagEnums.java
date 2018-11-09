package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @author qiaomengnan
 * @ClassName: ActContGenerationFlagEnums
 * @Description: 合同生成元素属性标识
 * @date 2018/4/16 0016
 */
public enum ActContGenerationFlagEnums {

    PARAM_VARIABLES("paramVariables", "业务传递用参数"),

    APPROVAL_USER("approvalUser","区域经理审核人标识"),
    RISK_USER("riskUser","风控初审人标识"),
    DIRAGREE_USER("dirAgreeUser","主管复核人标识"),
    PREAGREE_USER("preAgreeUser","副总审核人标识"),
    SALES_USER("salesUser","业务员标识"),
    MANAGE_USER("manageUser","总经理标识"),
    CONFIRM_USER("confirmUser","合同生成前确认人标识"),

    PROCESS_GENERATE_USER("processGenerateUser","合同生成人标识"),
    PROCESS_QUALIFICATION_USER("processQualificationUser","资管审核人标识"),
    PROCESS_PRINT_USER("processPrintUser","合同打印人标识"),
    PROCESS_REQUES_FUNDS_USER("processRequesFundsUser","请款人标识"),
    PROCESS_APPROVAL_USER("processApprovalUser","子流程文件审核人标识"),
    PROCESS_CHARGE_USER("processChargeUser","子流程出纳收款人标识"),
    PROCESS_VOUCHER_USER("processVoucherUser","子流程出纳制单人标识"),
    PROCESS_LOAN_USER("processLoanUser","子流程财务打款人标识"),
    NEXT_USER("nextUser","保存list集合用户"),


    APPLY_STATUS("applyStatus","订单提交状态标识"),
    APPROVAL_STATUS("approvalStatus","区域经理审核状态标识"),
    RISK_STATUS("riskStatus","风控初审状态标识"),
    DIRAGREE_STATUS("diragreeStatus","主管复核状态标识"),
    PREAGREE_STATUS("preagreeStatus","副总审核状态标识"),
    SALES_STATUS("salesStatus","业务员确认状态标识"),
    MANAGE_STATUS("manageStatus","总经理审核状态标识"),
    CONFIRM_STATUS("confirmStatus","合同确认状态标识"),

    PROCESS_GENERATE_STATUS("processGenerateStatus","合同生成状态标识"),
    PROCESS_QUALIFICATION_STATUS("processQualificationStatus","资管审核状态标识"),
    PROCESS_PRINT_STATUS("processPrintStatus","合同打印状态标识"),
    PROCESS_REQUES_FUNDS_STATUS("processRequesFundsStatus","请款状态标识"),
    PROCESS_APPROVAL_STATUS("processApprovalStatus","文件审核状态标识"),
    PROCESS_CHARGE_STATUS("processChargeStatus","出纳收款状态标识"),
    PROCESS_VOUCHER_STATUS("processVoucherStatus","出纳制单状态标识"),
    PROCESS_LOAN_STATUS("processLoanStatus","财务打款状态标识"),

    APPLY_NO("applyNo","合同申请编号标识"),
    CONT_NO("contNo","合同编号标识"),
    CONTRACT_QUANTITYS("contractQuantitys","合同集合信息标识"),
    CONTRACT_QUANTITY("contractQuantity","单个合同信息标识"),
    VEHICLENAME_AND_CONTNO("vehicleNameAndContNo","车型名称与合同号对应关系信息标识"),

    CONTRACT_GENERATION_APPLY("contract_generation_apply","申请录入任务key"),
    CONTRACT_GENERATION_APPROVAL("contract_generation_approval","区域经理审核中任务key"),
    CONTRACT_GENERATION_RISK("contract_generation_risk","风控初审中任务key"),
    CONTRACT_GENERATION_DIRAGREE("contract_generation_diragree","主管复核中任务key"),
    CONTRACT_GENERATION_PREAGREE("contract_generation_preagree","副总审核中任务key"),
    CONTRACT_GENERATION_MANAGE("contract_generation_manage","总经理审核中任务key"),
    CONTRACT_GENERATION_SALES("contract_generation_sales","业务员确认中任务key"),

    CONTRACT_GENERATION_CONFIRM("contract_generation_confirm","合同生成前确认任务key"),
    CONTRACT_GENERATION_PROCESS_GENERATE("contract_generation_process_generate","合同生成任务key"),
    CONTRACT_GENERATION_PROCESS_QUALIFICATION("contract_generation_process_qualification","资管审核任务key"),
    CONTRACT_GENERATION_PROCESS_PRINT("contract_generation_process_print","合同打印任务key"),
    CONTRACT_GENERATION_PROCESS_REQUES_FUNDS("contract_generation_process_reques_funds","请款任务key"),
    CONTRACT_GENERATION_PROCESS_APPROVAL("contract_generation_process_approval","文件审核任务key"),
    CONTRACT_GENERATION_PROCESS_CHARGE("contract_generation_process_charge","出纳收款任务key"),
    CONTRACT_GENERATION_PROCESS_VOUCHER("contract_generation_process_voucher","出纳制单任务key"),
    CONTRACT_GENERATION_PROCESS_LOAN("contract_generation_process_loan","财务打款key"),


    APPROVAL_USER_UNIT("approvalUserUnit","区域经理审核用户单位标识"),
    APPROVAL_USER_ID("approvalUserId","区域经理审核用户单位id标识"),
    RISK_USER_UNIT("riskUserUnit","风控初审用户单位标识"),
    RISK_USER_ID("riskUserId","风控初审用户单位id标识"),
    DIR_AGREE_USER_UNIT("dirAgreeUserUnit","主管复核用户单位标识"),
    DIR_AGREE_USER_ID("dirAgreeUserId","主管复核用户单位id标识"),
    PRE_AGREE_USER_UNIT("preAgreeUserUnit","副总审核用户单位标识"),
    PRE_AGREE_USER_ID("preAgreeUserId","副总审核用户单位id标识"),
    MANAGE_USER_UNIT("manageUserUnit","总经理核用户单位标识"),
    MANAGE_USER_ID("manageUserId","总经理核用户单位id标识"),

    PROCESS_QUALIFICATION_USER_UNIT("processQualificationUserUnit","资管审核用户单位标识"),
    PROCESS_QUALIFICATION_USER_ID("processQualificationUserId","资管审核用户单位id标识"),
    PROCESS_APPROVAL_UNIT("processApprovalUnit","文件审核单位标识"),
    PROCESS_APPROVAL_ID("processApprovalId","文件审核单位id标识"),
    PROCESS_CHARGE_USER_UNIT("processChargeUserUnit","出纳收款单位标识"),
    PROCESS_CHARGE_USER_ID("processChargeUserId","出纳收款单位id标识"),
    PROCESS_VOUCHER_USER_UNIT("processVoucherUserUnit","出纳制单单位标识"),
    PROCESS_VOUCHER_USER_ID("processVoucherUserId","出纳制单单位id标识"),
    PROCESS_LOAN_UNIT("processLoanUnit","财务打款单位标识"),
    PROCESS_LOAN_ID("processLoanId","财务打款单位id标识");


    private String flag;

    private String desc;

    ActContGenerationFlagEnums(String flag,String desc){
        this.flag = flag;
        this.desc = desc;
    }

    public String getFlag(){
        return this.flag;
    }

    public String getDesc(){
        return this.desc;
    }

}
