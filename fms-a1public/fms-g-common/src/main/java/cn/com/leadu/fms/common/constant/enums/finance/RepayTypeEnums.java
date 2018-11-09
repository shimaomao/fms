package cn.com.leadu.fms.common.constant.enums.finance;

public enum RepayTypeEnums {

    RENT("0","租金"),
    INIT_AMOUNT("1","首付"),
    FINAL_AMOUNT("2","尾付"),
    PREPAYMENT("3","提前还款"),
    CAPITAL_ASSETS("4","转固定资产");

    private String type;

    private String desc;

    RepayTypeEnums(String type, String desc) {
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