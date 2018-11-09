package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @author wangxue
 * @ClassName: ActTransferTaskEnums
 * @Description: 过户流程元素属性标识
 * @date 2018/9/6
 */
public enum ActTransferTaskEnums {

    //流程代理人
    APPLY_USER("applyUser","申请人标识"),
    APPROVAL_USER("approvalUser","初审人标识"),
    SETTLEMENT_USER("settlementUser","费用结算人标识"),
    REVIEW_USER("reviewUser","资管复核人标识"),
    RECEIPT_USER("receiptUser","财务收款人标识"),
    TOUCHING_USER("touchingUser","财务审核人标识"),
    CHECK_USER("checkUser","总经理审批人标识"),
    LOAN_USER("loanUser","财务确认付款人标识"),


    //流程状态
    APPLY_STATUS("applyStatus","提交申请状态标识"),
    APPROVAL_STATUS("approvalStatus","初审状态标识"),
    SETTLEMENT_STATUS("settlementStatus","费用结算状态标识"),
    REVIEW_STATUS("reviewStatus","资管复核审批状态标识"),
    RECEIPT_STATUS("receiptStatus","财务确认收款状态标识"),
    TOUCHING_STATUS("touchingStatus","财务审批状态标识"),
    CHECK_STATUS("checkStatus","总经理审状态标识"),
    LOAN_STATUS("loanStatus","财务确认付款状态标识"),

    //流程任务key
    TRANSFER_TASK_APPLY("transfer_task_apply","提交申请任务key"),
    TRANSFER_TASK_APPROVAL("transfer_task_approval","初审任务key"),
    TRANSFER_TASK_SETTLEMENT("transfer_task_settlement","费用结算任务key"),
    TRANSFER_TASK_REVIEW("transfer_task_review","资管复核任务key"),
    TRANSFER_TASK_RECEIPT("transfer_task_receipt","财务确认收款任务key"),
    TRANSFER_TASK_TOUCHING("transfer_task_touching","财务审核任务key"),
    TRANSFER_TASK_CHECK("transfer_task_check","总经理审批任务key"),
    TRANSFER_TASK_LOAN("transfer_task_loan","财务确认付款任务key"),

    //代理人单位和ID标识
    APPROVAL_USER_UNIT("approvalUserUnit","初审用户单位标识"),
    APPROVAL_USER_ID("approvalUserId","初审用户单位id标识"),
    SETTLEMENT_USER_UNIT("settlementUserUnit","费用结算人单位"),
    SETTLEMENT_USER_ID("settlementUserId","费用结算人id"),
    REVIEW_USER_UNIT("reviewUserUnit","资管复核人单位"),
    REVIEW_USER_ID("reviewUserId","资管复核人id"),
    RECEIPT_USER_UNIT("receiptUserUnit","财务确认收款单位标识"),
    RECEIPT_USER_ID("receiptUserId","财务确认收款单位id标识"),
    TOUCHING_USER_UNIT("touchingUserUnit","财务审核人单位"),
    TOUCHING_USER_ID("touchingUserId","财务审核人id"),
    CHECK_USER_UNIT("checkUserUnit","总经理审批单位标识"),
    CHECK_USER_ID("checkUserId","总经理审批单位id标识"),
    LOAN_USER_UNIT("loanUserUnit","财务付款人单位"),
    LOAN_USER_ID("loanUserId","财务付款人id");

    private String flag;

    private String desc;

    ActTransferTaskEnums(String flag, String desc){
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
