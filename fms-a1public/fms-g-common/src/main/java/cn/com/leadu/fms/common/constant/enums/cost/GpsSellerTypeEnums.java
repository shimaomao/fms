package cn.com.leadu.fms.common.constant.enums.cost;

/**
 * @author qiaomengnan
 * @ClassName: GpsSellerEnums
 * @Description: gps厂商代码
 * @date 2018/7/5
 */
public enum GpsSellerTypeEnums {

    TY("0","天易");

    private String type;

    private String name;

    GpsSellerTypeEnums(String type,String name){
        this.type = type;
        this.name = name;
    }

    public String getType(){
        return type;
    }

    public String getName(){
        return name;
    }

}
