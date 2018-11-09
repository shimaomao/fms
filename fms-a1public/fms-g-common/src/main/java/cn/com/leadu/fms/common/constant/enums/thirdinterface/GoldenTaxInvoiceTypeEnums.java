package cn.com.leadu.fms.common.constant.enums.thirdinterface;

/**
 * @author qiaomengnan
 * @ClassName: GoldenTaxInvoiceTypeEnums
 * @Description: 金税发票类型
 * @date 2018/9/13 0013
 */
public enum GoldenTaxInvoiceTypeEnums {

    SPECIAL_TICKET("0","专票"),
    SCRAP_TICKET("1","废旧物资票"),
    UNIVERSAL_TICKET("2","普票");

    private String type;

    private String desc;

    GoldenTaxInvoiceTypeEnums(String type,String desc) {
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
