package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * Created by root on 2018/8/29.
 */
public enum ActInvoiceChangeEnums {

    APPLY_USER("applyUser","申请人标识"),
    APPROVAL_USER("approvalUser","审核人标识"),

    INVOICE_CHANGE_APPLY("invoice_change_apply","开票信息变更申请key"),
    INVOICE_CHANGE_APPROVAL("invoice_change_approval","开票信息变更审核key"),

    APPROVAL_STATUS("approvalStatus","审核状态标识"),

    APPROVAL_USER_UNIT("approvalUserUnit","审核用户单位标识"),
    APPROVAL_USER_ID("approvalUserId","审核用户单位id");

    private String flag;

    private String desc;

    ActInvoiceChangeEnums(String flag,String desc){
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
