package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * @description:
 * @author:ningyangyang
 * @since:2018/5/14
 */
public enum InsuranceStatusEnums {

    INSURANCE_VALID("1","有效"),
    INSURANCE_INVALID("2","失效");

    private String type;

    private String desc;

    InsuranceStatusEnums(String type, String desc) {
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
