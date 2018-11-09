package cn.com.leadu.fms.common.constant.enums.finance;

/**
 * Created by yyq on 2018/6/13.
 */
public enum ChargeDetailFlagEnums {
    DETAIL("0","明细"),
    TOTAL("1","合计");

    private String type;

    private String desc;

    ChargeDetailFlagEnums(String type, String desc) {
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
