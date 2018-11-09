package cn.com.leadu.fms.common.constant.enums.cost;

/**
 * @author yanfengbo
 * @ClassName: gps安装状态
 * @Description:
 * @date  
 */
public enum GpsInstallStatusEnums {
    ALREADY_DISPATCHED("1","已派单"),
    ALREADY_RECEIPT("2","已接单"),
    COMPLETED("3","已完成"),
    RETURN_CUSTOMER("4","退回客户");

    private String type;

    private String name;

    GpsInstallStatusEnums(String type,String name){
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
