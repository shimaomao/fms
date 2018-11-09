package cn.com.leadu.fms.common.constant.enums.thirdinterface;

/**
 * @author qiaomengnan
 * @ClassName: GpsTyTerminalModelTypeEnums
 * @Description: 天易派单接口设备类型
 * @date 2018/7/5
 */
public enum TyGpsTerminalModelTypeEnums {

    WIRED("1","有线"),
    WIRELESS("2","无线");

    private String type;

    private String name;

    TyGpsTerminalModelTypeEnums(String type, String name){
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
