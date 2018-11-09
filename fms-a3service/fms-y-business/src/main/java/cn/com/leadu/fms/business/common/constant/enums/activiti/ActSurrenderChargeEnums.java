package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @author fangshaofeng
 * @ClassName: ActSurrenderChargeEnums
 * @Description: 退保费用结算工作流枚举
 * @date
 * Created by leadu on 2018/10/26.
 */
public enum ActSurrenderChargeEnums {

    //流程代理人
    APPLY_USER("applyUser","申请人标识"),
    APPROVAL_USER("approvalUser","资管复核人标识"),
    RECEIVABLES_USER("receivablesUser","财务收款人标识"),
    REVIEW_USER("reviewUser","财务制单人标识"),
    CONFIRM_USER("confirmUser","财务付款人标识"),
    NEXT_USER("nextUser","保存list集合用户"),

    //流程状态
    APPLY_STATUS("applyStatus","申请提交状态标识"),
    APPROVAL_STATUS("approvalStatus","资管复核状态标识"),
    RECEIVABLES_STATUS("receivablesStatus","财务收款状态标识"),
    REVIEW_STATUS("reviewStatus","财务制单状态标识"),
    LOAN_STATUS("loanStatus","财务付款状态标识"),

    //流程任务key
    SURRENDER_CHARGE_APPLY("surrender_charge_apply","提交申请任务key"),
    SURRENDER_CHARGE_APPROVE("surrender_charge_approve","资管复核任务key"),
    SURRENDER_CHARGE_RECEIVABLES("surrender_charge_receivables","财务收款任务key"),
    SURRENDER_CHARGE_REVIEW("surrender_charge_review","财务制单任务key"),
    SURRENDER_CHARGE_CONFIRM("surrender_charge_confirm","财务付款任务key"),

    //代理人单位和ID标识
    APPROVAL_USER_UNIT("approvalUserUnit","资管复核人单位"),
    APPROVAL_USER_ID("approvalUserId","资管复核人id"),
    RECEIVABLES_USER_UNIT("receivablesUserUnit","财务收款人单位"),
    RECEIVABLES_USER_ID("receivablesUserId","财务收款人id"),
    REVIEW_USER_UNIT("reviewUserUnit","财务制单人单位"),
    REVIEW_USER_ID("reviewUserId","财务制单人id"),
    CONFIRM_USER_UNIT("confirmUserUnit","财务审核人单位"),
    CONFIRM_USER_ID("confirmUserId","财务审核人id");

    private String flag;

    private String desc;

    ActSurrenderChargeEnums(String flag, String desc){
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
