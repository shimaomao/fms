package cn.com.leadu.fms.common.constant.enums.prebiz;

public enum InvoiceTypeEnums {

    RENT("01","租金"),
    INIT_AMOUNT("03","首付款"),
    FINAL_AMOUNT("04","尾款"),
    PREPAYMENT("05","提前结清"),
    OVERDUE("11","罚息"),
    CHARGE("21","手续费"),
    SALES_CHARGE("22","代收手续费"),
    INSURANCE_COST("23","客户打款开票");

    private String type;

    private String desc;

    InvoiceTypeEnums(String type, String desc) {
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