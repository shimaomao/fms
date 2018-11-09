package cn.com.leadu.fms.common.constant.enums.postbiz;

public enum SecHandInventoryEnums {

    MANUALIMPORT("0","手动导入"),
    CARDISPOSE("1","车辆处置");


    private String type;

    private String desc;

    SecHandInventoryEnums(String type, String desc) {
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
