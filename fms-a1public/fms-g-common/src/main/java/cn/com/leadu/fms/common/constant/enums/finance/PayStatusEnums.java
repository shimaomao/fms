package cn.com.leadu.fms.common.constant.enums.finance;

/**
 * @description: 付款状态
 * @author:lijunjun
 * @since:2018/5/8
 */
public enum PayStatusEnums {

    TO_BE_WITHHELD("0","待付款"),
    WITHDRAWING("1","已付款"),
    WITHDRAWING_SUCCESS("2","成功"),
    WITHDRAWING_FAILURE("3","失败"),
    REQUEST("9","待进入付款池"),
    CONFIRM("0","待付款");

    private String type;

    private String desc;

    PayStatusEnums(String type, String desc) {
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
