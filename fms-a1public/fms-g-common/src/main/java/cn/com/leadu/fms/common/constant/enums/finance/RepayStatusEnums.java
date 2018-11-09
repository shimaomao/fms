package cn.com.leadu.fms.common.constant.enums.finance;

/**
 * @description: 扣款状态
 * @author:ningyangyang
 * @since:2018/5/8
 */
public enum RepayStatusEnums {

    TO_BE_WITHHELD("0","待扣款"),
    WITHDRAWING("1","扣款中"),
    WITHDRAWING_SUCCESS("2","成功"),
    WITHDRAWING_FAILURE("3","失败"),
    PREPAYMENT("4","已提前结清");

    private String type;

    private String desc;

    RepayStatusEnums(String type, String desc) {
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
