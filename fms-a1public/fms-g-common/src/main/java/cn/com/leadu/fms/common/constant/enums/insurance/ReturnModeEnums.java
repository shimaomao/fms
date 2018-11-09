package cn.com.leadu.fms.common.constant.enums.insurance;

/**
 * Created by ningyangyang on 2018/6/9.
 * 收款状态
 */
public enum ReturnModeEnums {

    RETURN("0","退还客户"),
    DEDUCTION("1","抵扣租金");

    private String type;

    private String desc;

    ReturnModeEnums(String type, String desc) {
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
