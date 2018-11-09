package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * 二手车库存车辆来源枚举类
 * Created by root on 2018/9/12.
 */
public enum SecHandSourceEnums {

    ADD("0","新增"),
    RECOVERY("1","收车");

    private String type;

    private String desc;

    SecHandSourceEnums(String type, String desc) {
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
