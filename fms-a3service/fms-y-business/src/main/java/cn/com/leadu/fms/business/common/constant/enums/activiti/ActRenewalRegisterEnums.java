package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @author ningyangyang
 * @ClassName: ActRenewalRegisterEnums
 * @Description:
 * @date 2018/5/8 0008
 */
public enum ActRenewalRegisterEnums {

    MANAGEMENT_CONFIRM_USER("managementConfirmUser","资管确认标识"),
    FINANCE_RECEIPT_USER("financeReceiptUser","财务确认收款标识"),
    MANAGEMENT_WITHDRAW_USER("managementWithdrawUser","资管请款标识"),
    MANAGEMENT_REVIEW_USER("managementReviewUser","资管复核标识"),
    FINANCE_VOUCHER_USER("financeVoucherUser","财务制单标识"),
    FINANCE_PAYMENT_USER("financePaymentUser","财务付款标识"),
    NEXT_USER("nextUser","多个用户"),

    MANAGEMENT_CONFIRM("management_confirm", "资管确认任务key"),
    FINANCE_RECEIPT("finance_receipt", "财务确认收款任务key"),
    MANAGEMENT_WITHDRAW("management_withdraw", "资管请款任务key"),
    MANAGEMENT_REVIEW("management_review", "资管复核任务key"),
    FINANCE_VOUCHER("finance_voucher","财务制单任务key"),
    FINANCE_PAYMENT("finance_payment","财务付款任务key"),

    CONFIRM_STATUS("confirmStatus","资管确认状态"),
    RECEIPT_STATUS("receiptStatus","财务确认收款状态"),
    WITHDRAW_STATUS("withdrawStatus","资管请款状态"),
    REVIEW_STATUS("reviewStatus","资管复核状态"),
    VOUCHER_STATUS("voucherStatus","财务制单状态"),
    PAYMENT_STATUS("paymentStatus","财务付款状态"),



    MANAGEMENT_CONFIRM_USER_UNIT("managementConfirmUserUnit","资管确认单位标识"),
    MANAGEMENT_CONFIRM_USER_ID("managementConfirmUserId","资管确认单位id标识"),
    FINANCE_RECEIPT_USER_UNIT("financeReceiptUserUnit","财务确认收款单位标识"),
    FINANCE_RECEIPT_USER_ID("financeReceiptUserId","财务确认收款单位id标识"),
    MANAGEMENT_WITHDRAW_USER_UNIT("managementWithdrawUserUnit","资管请款单位标识"),
    MANAGEMENT_WITHDRAW_USER_ID("managementWithdrawUserId","资管请款单位id标识"),
    MANAGEMENT_REVIEW_USER_UNIT("managementReviewUserUnit","资管复核单位标识"),
    MANAGEMENT_REVIEW_USER_ID("managementReviewUserId","资管复核单位id标识"),
    FINANCE_VOUCHER_USER_UNIT("financeVoucherUserUnit","财务制单单位标识"),
    FINANCE_VOUCHER_USER_ID("financeVoucherUserId","财务制单单位id标识"),
    FINANCE_PAYMENT_USER_UNIT("financePaymentUserUnit","财务付款单位标识"),
    FINANCE_PAYMENT_USER_ID("financePaymentUserId","财务付款单位id标识");

    private String flag;

    private String desc;

    ActRenewalRegisterEnums(String flag, String desc){
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
