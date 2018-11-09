package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * @author qiaomengnan
 * @ClassName: InvoiceTypeEnums
 * @Description: 发票类型枚举
 * @date 2018/9/13 0013
 */
public enum  InvoiceTypeEnums {

    SPECIAL_TICKET("0","专票"),
    UNIVERSAL_TICKET("1","普票");

    private String type;

    private String desc;

    InvoiceTypeEnums(String type,String desc) {
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
