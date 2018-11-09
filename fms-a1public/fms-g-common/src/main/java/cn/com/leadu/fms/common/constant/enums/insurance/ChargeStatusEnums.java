package cn.com.leadu.fms.common.constant.enums.insurance;

/**
 * Created by ningyangyang on 2018/6/9.
 * 收款状态
 */
public enum ChargeStatusEnums {

    TO_BE_RECEIVE("0","待收款");

    private String type;

    private String desc;

    ChargeStatusEnums(String type, String desc) {
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
