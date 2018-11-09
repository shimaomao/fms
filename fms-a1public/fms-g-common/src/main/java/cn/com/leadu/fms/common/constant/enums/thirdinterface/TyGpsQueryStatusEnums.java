package cn.com.leadu.fms.common.constant.enums.thirdinterface;

/**
 * @author qiaomengnan
 * @ClassName: GpsTyQueryStatusEnums
 * @Description: 天易查询接口返回状态枚举
 * @date 2018/7/5
 */
public enum TyGpsQueryStatusEnums {

    DISPATCH("1","已派单"),
    CATCH("2","已接单"),
    COMPLETE("3","已完成"),
    RETURN("4","退回客户");

    private String status;

    private String name;

    TyGpsQueryStatusEnums(String status, String name){
        this.status = status;
        this.name = name;
    }

    public String getStatus(){
        return status;
    }

    public String getName(){
        return name;
    }

}
