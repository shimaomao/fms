package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @author qiaomengnan
 * @ClassName: ActEquMortgageFlagEnums
 * @Description:
 * @date 2018/6/7
 */
public enum ActEquMortgagePayFlagEnums {


    //流程任务key
    EQU_MORTGAGE_PAY_APPLY("equ_mortgage_pay_apply","资管申请任务key"),
    EQU_MORTGAGE_PAY_IMPORT("equ_mortgage_pay_import","导入费用任务key"),
    EQU_MORTGAGE_PAY_REVIEW("equ_mortgage_pay_review","资管复核任务key"),
    EQU_MORTGAGE_PAY_TOUCHING("equ_mortgage_pay_touching","财务制单任务key"),
    EQU_MORTGAGE_PAY_APPROVAL("equ_mortgage_pay_approval","总经理审批任务key"),
    EQU_MORTGAGE_PAY_PAY("equ_mortgage_pay_pay","财务付款任务key"),
    EQU_MORTGAGE_PAY_RECEIPT("equ_mortgage_pay_receipt","财务收款任务key"),
    EQU_MORTGAGE_PAY_UPLOAD("equ_mortgage_pay_upload","上传抵押资料任务key"),

    //流程状态
    APPLY_STATUS("applyStatus","申请审批状态"),
    IMPORT_STATUS("importStatus","导入费用审批状态"),
    REVIEW_STATUS("reviewStatus","资管复核审批状态"),
    TOUCHING_STATUS("touchingStatus","财务制单审批状态"),
    APPROVAL_STATUS("approvalStatus","总经理审批审批状态"),
    PAY_STATUS("payStatus","财务付款审批状态"),


    //流程代理人
    APPLY_USER("applyUser","资管申请人"),
    IMPORT_USER("importUser","导入费用人"),
    UPLOAD_USER("uploadUser","资料归档人"),
    REVIEW_USER("reviewUser","资管复核人"),
    TOUCHING_USER("touchingUser","财务制单人"),
    APPROVAL_USER("approvalUser","总经理"),
    PAY_USER("payUser","财务付款人"),
    RECEIPT_USER("receiptUser","财务收款人"),

    //代理人单位和ID标识
    REVIEW_USER_UNIT("reviewUserUnit","复核人单位"),
    REVIEW_USER_ID("reviewUserId","复核人id"),
    TOUCHING_USER_UNIT("touchingUserUnit","财务制单人单位"),
    TOUCHING_USER_ID("touchingUserId","财务制单人id"),
    APPROVAL_USER_UNIT("approvalUserUnit","总经理单位"),
    APPROVAL_USER_ID("approvalUserId","总经理id"),
    PAY_USER_UNIT("payUserUnit","财务付款人单位"),
    PAY_USER_ID("payUserId","财务付款人id");
    ;

    private String flag;

    private String desc;

    ActEquMortgagePayFlagEnums(String flag, String desc){
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
