package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @author qiaomengnan
 * @ClassName: ActContPrepaymentEnums
 * @Description: 合同生成元素属性标识
 * @date 2018/4/16 0016
 */
public enum ActContPrepaymentEnums {

    APPLY_USER("applyUser","申请人标识"),
    APPROVAL_USER("approvalUser","初审人标识"),
    REVIEW_USER("reviewUser","复审人标识"),
    CONFIRM_USER("confirmUser","财务确认人标识"),
    PAYMENT_USER("paymentUser","财务审核人标识"),
    CHECK_USER("checkUser","总经理审批人标识"),
    EXPORT_USER("exportUser","车辆出库人标识"),

    APPLY_STATUS("applylStatus","提交申请状态标识"),
    APPROVAL_STATUS("approvalStatus","初审状态标识"),
    REVIEW_STATUS("reviewStatus","复审状态标识"),
    CONFIRM_STATUS("confirmStatus","财务确认状态标识"),
    PAYMENT_STATUS("paymentStatus","财务审核状态标识"),
    CHECK_STATUS("checkStatus","总经理审批状态标识"),
    EXPORT_STATUS("exportStatus","车辆出库状态标识"),


    CONT_PREPAYMENT_APPLY("cont_prepayment_apply","提交申请任务key"),
    CONT_PREPAYMENT_APPROVAL("cont_prepayment_approval","初审任务key"),
    CONT_PREPAYMENT_REVIEW("cont_prepayment_review","复审任务key"),
    CONT_PREPAYMENT_CONFIRM("cont_prepayment_confirm","财务确认任务key"),
    CONT_PREPAYMENT_PAYMENT("cont_prepayment_payment","财务审批任务key"),
    CONT_PREPAYMENT_CHECK("cont_prepayment_check","总经理审批任务key"),
    CONT_PREPAYMENT_EXPORT("cont_prepayment_export","车辆出库任务key"),


    APPROVAL_USER_UNIT("approvalUserUnit","初审用户单位标识"),
    APPROVAL_USER_ID("approvalUserId","初审用户单位id标识"),
    REVIEW_USER_UNIT("reviewUserUnit","复审用户单位标识"),
    REVIEW_USER_ID("reviewUserId","复审用户单位id标识"),
    CONFIRM_USER_UNIT("confirmUserUnit","财务确认单位标识"),
    CONFIRM_USER_ID("confirmUserId","财务确认单位id标识"),
    PAYMENT_USER_UNIT("paymentUserUnit","财务审核单位标识"),
    PAYMENT_USER_ID("paymentUserId","财务审核单位id标识"),
    CHECK_USER_UNIT("checkUserUnit","总经理审批单位标识"),
    CHECK_USER_ID("checkUserId","总经理审批单位id标识"),
    EXPORT_USER_UNIT("exportUserUnit","车辆出库用户单位标识"),
    EXPORT_USER_ID("exportUserId","车辆出库用户单位id标识");

    private String flag;

    private String desc;

    ActContPrepaymentEnums(String flag,String desc){
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
