package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @author lijunjun
 * @ClassName: ActFileBorrowTaskEnums
 * @Description: activiti流程引擎key名称
 * @date 2018/4/8
 */
public enum ActFileBorrowBackTaskEnums {

    APPLY_USER("applyUser","申请人标识"),
    REVIEW_USER("reviewUser","资管复核人标识"),
    MAKE_VOUCHER("makeVoucher","财务制单人标识"),
    PAYER("payer","财务打款人标识"),
    CONFIRM_USER("confirmUser","复核确认"),
    NEXT_USER("nextUser","保存list集合用户"),

    BORROW_BACK_TASK_APPLY("borrow_back_task_apply","借阅归还申请任务key"),
    BORROW_BACK_TASK_REVIEW("borrow_back_task_review","资管复核任务key"),
    BORROW_BACK_TASK_MAKE_VOUCHER("borrow_back_task_make_voucher","财务制单任务key"),
    BORROW_BACK_TASK_PAYMENT("borrow_back_task_payment","财务打款任务key"),
    BORROW_BACK_TASK_CONFIRM("borrow_back_task_confirm","借阅归还确认"),

    APPLY_STATUS("applyStatus","归还申请状态标识"),
    REVIEW_STATUS("reviewStatus","资管复核状态标识"),
    MAKE_VOUCHER_STATUS("makeVoucherStatus","财务制单状态标识"),
    PAY_STATUS("payStatus","财务打款状态标识"),
    CONFIRM_STATUS("confirmStatus","借阅归还确认状态标识"),

    REVIEW_USER_UNIT("reviewUserUnit","资管复核用户单位标识"),
    REVIEW_USER_ID("reviewUserId","资管复核用户单位id标识"),
    MAKE_VOUCHER_UNIT("makeVoucherUnit","财务制单用户单位标识"),
    MAKE_VOUCHER_ID("makeVoucherId","财务制单用户单位id标识"),
    PAYER_UNIT("payerUnit","财务打款用户单位标识"),
    PAYER_ID("payerId","财务打款用户单位id标识"),
    CONFIRM_UNIT("confirmUnit","确认节点用户单位标识"),
    CONFIRM_ID("confirmId","确认节点用户单位id标识");

    private String flag;

    private String desc;

    ActFileBorrowBackTaskEnums(String flag, String desc){
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
