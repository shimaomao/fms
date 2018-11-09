package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @author ningyangyang
 * @ClassName: ActReleasedMortgageEnums
 * @Description: activiti流程引擎key名称
 * @date 2018/4/8
 */
public enum ActReleasedMortgageEnums {

    APPLY_USER("applyUser","申请人标识"),
    REVIEW_USER("reviewUser","复审人标识"),
    RECEIPT_USER("receiptUser","财务确认收款人标识"),
    VOUCHER_USER("voucherUser","制单人标识"),
    FINANCE_USER("financeUser","财务标识"),
    CONFIRM_USER("confirmUser","确认解押标识"),
    NEXT_USER("nextUser","多个用户"),

    APPLY_STATUS("applyStatus","申请提交状态标识"),
    REVIEW_STATUS("reviewStatus","复审状态标识"),
    RECEIPT_STATUS("receiptStatus","财务确认收款状态标识"),
    VOUCHER_STATUS("voucherStatus","制单状态标识"),
    FINANCE_STATUS("financeStatus","财务状态标识"),
    CONFIRM_STATUS("confirmStatus","解押确认状态标识"),


    RELEASED_MORTGAGE_APPLY("released_mortgage_apply","提交申请任务key"),
    RELEASED_MORTGAGE_REVIEW("released_mortgage_review","复审任务key"),
    RELEASED_MORTGAGE_RECEIPT("released_mortgage_receipt","财务确认收款任务key"),
    RELEASED_MORTGAGE_VOUCHER("released_mortgage_voucher","制单任务key"),
    RELEASED_MORTGAGE_FINANCE("released_mortgage_finance","财务任务key"),
    RELEASED_MORTGAGE_CONFIRM("released_mortgage_confirm","确认解押任务key"),


    REVIEW_USER_UNIT("reviewUserUnit","复审用户单位标识"),
    REVIEW_USER_ID("reviewUserId","复审用户单位id标识"),
    VOUCHER_USER_UNIT("voucherUserUnit","制单用户单位标识"),
    VOUCHER_USER_ID("voucherUserId","制单用户单位id标识"),
    RECEIPT_USER_UNIT("receiptUserUnit","财务确认收款用户单位标识"),
    RECEIPT_USER_ID("receiptUserId","财务确认收款用户单位id标识"),
    FINANCE_USER_UNIT("financeUserUnit","财务用户单位标识"),
    FINANCE_USER_ID("financeUserId","财务用户单位标识"),
    CONFIRM_USER_UNIT("confirmUserUnit","解抵押确认用户单位标识"),
    CONFIRM_USER_ID("confirmUserId","解抵押确认用户单位id标识");

    private String flag;

    private String desc;

    ActReleasedMortgageEnums(String flag,String desc){
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
