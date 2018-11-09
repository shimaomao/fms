package cn.com.leadu.fms.common.constant.enums.finance;

/**
 * @description: 地址类型
 * @author: wangxue
 * @since: 2018/9/15
 */
public enum AddressTypeEnums {

    COMPANY_ADDR("1","单位地址"),
    RESIDE_ADDR("2","居住地址"),
    CENSUS_ADDR("3","户籍地址"),
    PROPERTY_ADDR("4","房产地址");

    private String type;

    private String desc;

    AddressTypeEnums(String type, String desc){
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
