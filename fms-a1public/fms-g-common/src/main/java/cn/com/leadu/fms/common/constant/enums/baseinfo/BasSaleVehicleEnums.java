package cn.com.leadu.fms.common.constant.enums.baseinfo;


/**
 * @author qinmuqiao
 * @ClassName:  BasSaleVehicleEnums
 * @Description: 车辆类型
 * @date
 */

public enum BasSaleVehicleEnums {

    VEHICLE_NEW("1","新车"),
    VEHICLE_SEC("2","二手车");

    private String type;

    private String desc;

    BasSaleVehicleEnums(String type, String desc) {
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
