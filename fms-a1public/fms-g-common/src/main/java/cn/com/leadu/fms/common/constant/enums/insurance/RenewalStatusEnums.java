package cn.com.leadu.fms.common.constant.enums.insurance;

/**
 * @description:   续保任务状态
 * @author:ningyangyang
 * @since:2018/5/17
 */
public enum  RenewalStatusEnums {

    TO_BE_SUBMITTED("0500","待提交");

    private String type;

    private String desc;

    RenewalStatusEnums(String type, String desc) {
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
