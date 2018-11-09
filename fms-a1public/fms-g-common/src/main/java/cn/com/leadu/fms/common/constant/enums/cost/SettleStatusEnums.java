package cn.com.leadu.fms.common.constant.enums.cost;

/**
 * @author qiaomengnan
 * @ClassName: SettleStatusEnums
 * @Description:  gps派单结算状态
 * @date 2018/6/28
 */
public enum  SettleStatusEnums {

    MID_MONTH_KNOT("1","月结中"),
    MONTHLY_KNOT("2","已月结");

    private String status;

    private String name;

    SettleStatusEnums(String status,String name){
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
