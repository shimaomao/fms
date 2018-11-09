package cn.com.leadu.fms.common.constant.enums.postbiz;

public enum VehMaintainEnums {

    MAINTAINEXCELL("0","导入"),
    MAINTAINIMPOR("1","录入"),
    MAINTAINCLAIM("2","理赔");

    private String type;

    private String desc;

    VehMaintainEnums(String type, String desc) {
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
