package cn.com.leadu.fms.common.constant.enums;

public enum YesNoFlagEnums {
    YES("1","是"),
    NO("0","否");

    private String type;

    private String desc;

    YesNoFlagEnums(String type, String desc){
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