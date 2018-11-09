package cn.com.leadu.fms.common.constant.enums.finance;

/**
 * @description: 收款状态
 * @author:lijunjun
 * @since:2018/5/8
 */
public enum ChargeStatusEnums {

    TO_BE_COLLECTION("0","待收款"),
    COLLECTION("1","已收款");

    private String type;

    private String desc;

    ChargeStatusEnums(String type, String desc){
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
