package cn.com.leadu.fms.common.constant.enums.postbiz;

public enum AnnualInspectionEnums {


    UNINSPECTINO("0","未年检"),
    INSPECTINO("1","已年检");

    private String type;

    private String desc;

    AnnualInspectionEnums(String type, String desc) {
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
