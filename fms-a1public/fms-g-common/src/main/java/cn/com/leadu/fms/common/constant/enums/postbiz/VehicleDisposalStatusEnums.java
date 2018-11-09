package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * 车辆处置状态
 * Created by wangxue on 2018/9/13.
 */
public enum VehicleDisposalStatusEnums {

    TO_BE_DISPOSE("0","待处置"),
    OUT_STORAGE("1","已出库"),
    CAPITAL_ASSETS("2","转固定资产");

    private String type;

    private String desc;

    VehicleDisposalStatusEnums(String type, String desc) {
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
