package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * Created by root on 2018/9/12.
 */
public enum DataSourceTypeEnums {

    AUTO("1","自动程序"),
    HAND("2","手动处理");

    private String type;

    private String desc;

    DataSourceTypeEnums(String type, String desc) {
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
