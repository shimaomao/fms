package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * 车辆处置方式
 * Created by wangxue on 2018/9/13.
 */
public enum  DisposalStatusEnums {

    REDEMPTION("1","赎回"),
    CAPITAL_ASSETS("2","转固定资产"),
    DEPOSIT_CHANGE("3","增加保证金");

    private String type;

    private String desc;

    DisposalStatusEnums(String type, String desc) {
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
