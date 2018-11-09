package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * Created by root on 2018/8/29.
 */
public enum ActBasicChangeEnums {

    APPLY_USER("applyUser","申请人标识"),
    APPROVAL_USER("approvalUser","资管审核人标识"),
    REVIEW_USER("reviewUser","资管复核人标识"),

    BASIC_CHANGE_APPLY("basic_change_apply","开票信息变更申请key"),
    BASIC_CHANGE_APPROVAL("basic_change_approval","开票信息变更审核key"),
    BASIC_CHANGE_REVIEW("basic_change_review","开票信息变更复核key"),

    APPLY_STATUS("applyStatus","申请状态标识"),
    APPROVAL_STATUS("approvalStatus","审核状态标识"),
    REVIEW_STATUS("reviewStatus","复核状态标识"),

    APPROVAL_USER_UNIT("approvalUserUnit","审核用户单位标识"),
    APPROVAL_USER_ID("approvalUserId","审核用户单位id"),
    REVIEW_USER_UNIT("reviewUserUnit","审核用户单位标识"),
    REVIEW_USER_ID("reviewUserId","审核用户单位id");

    private String flag;

    private String desc;

    ActBasicChangeEnums(String flag, String desc){
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
