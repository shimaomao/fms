package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * Created by root on 2018/9/14.
 */
public enum DispatchTypeEnums {

    COMPANY("1","公司内部"),
    THIRD_COM("2","第三方");

    private String type;

    private String desc;

    DispatchTypeEnums(String type, String desc) {
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
