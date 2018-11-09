package cn.com.leadu.fms.common.constant.enums.insurance;

/**
 * @description:  保险理赔状态
 * @author:ningyangyang
 * @since:2018/5/18
 */
public enum  InsurClaimStatusEnums {

//   0501：待初审
//   0502：待复审
//   0503：理赔通过
//    初审退回：
//    0504：退回待提交
//    复审退回：
//     0505：复审退回

    TO_BE_APPROVAL("0601","待资管复核"),
    TO_BE_REVIEW("0602","待财务制单"),
    SEND_BACK_APPROVAL("0604","资管复核退回待提交"),
    SEND_BACK_REVIEW("0605","财务制单退回待提交"),
    AUDIT_PASS("0603","待财务放款审核"),
    WAIT_LOAN("0606","财务放款审核通过"),
    RETURN_LOAN("0607","财务放款审核退回待提交"),

    INSUR_CLAIM_AUDIT("","保险理赔审核");
    private String type;

    private String desc;

    InsurClaimStatusEnums(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
