package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * 二手车库存状态
 * Created by root on 2018/9/12.
 */
public enum SecHandStatusEnums {

    IN("0","在库"),
    OUT("1","出库");

    private String type;

    private String desc;

    SecHandStatusEnums(String type, String desc) {
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
