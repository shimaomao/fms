package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @description:  保险理赔状态
 * @author:ningyangyang
 * @since:2018/5/18
 */
public enum ActInsurClaimCheckEnums {

    APPLY_USER("applyUser","申请人标识"),
    APPROVAL_USER("approvalUser","资管复核人标识"),
    RECEIVABLES_USER("receivablesUser","财务收款人标识"),
    REVIEW_USER("reviewUser","财务制单人标识"),
    CONFIRM_USER("confirmUser","财务付款人标识"),
    NEXT_USER("nextUser","保存list集合用户"),

    APPLY_STATUS("applyStatus","申请提交状态标识"),
    APPROVAL_STATUS("approvalStatus","资管复核状态标识"),
    RECEIVABLES_STATUS("receivablesStatus","财务收款状态标识"),
    REVIEW_STATUS("reviewStatus","财务制单状态标识"),
    LOAN_STATUS("loanStatus","财务付款状态标识"),


    INSUR_CLAIM_CHECK_APPLY("insur_claim_check_apply","提交申请任务key"),
    INSUR_CLAIM_CHECK_APPROVE("insur_claim_check_approve","资管复核任务key"),
    INSUR_CLAIM_CHECK_RECEIVABLES("insur_claim_check_receivables","财务收款任务key"),
    INSUR_CLAIM_CHECK_REVIEW("insur_claim_check_review","财务制单任务key"),
    INSUR_CLAIM_CHECK_CONFIRM("insur_claim_check_confirm","财务付款任务key"),


    APPROVAL_USER_UNIT("approvalUserUnit","资管复核用户单位标识"),
    APPROVAL_USER_ID("approvalUserId","资管复核用户单位id标识"),
    RECEIVABLES_USER_UNIT("receivablesUserUnit","财务收款用户单位标识"),
    RECEIVABLES_USER_ID("receivablesUserId","财务收款用户单位id标识"),
    REVIEW_USER_UNIT("reviewUserUnit","财务制单用户单位标识"),
    REVIEW_USER_ID("reviewUserId","财务制单用户单位id标识"),
    CONFIRM_USER_UNIT("confirmUserUnit","财务付款用户单位标识"),
    CONFIRM_USER_ID("confirmUserId","财务付款用户单位id标识");

    private String flag;

    private String desc;

    ActInsurClaimCheckEnums(String flag, String desc){
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
