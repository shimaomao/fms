package cn.com.leadu.fms.common.constant.enums.asset;

/**
 * @author qiaomengnan
 * @ClassName: ManagementEnums
 * @Description:
 * @date 2018/6/11
 */
public enum  ManagementEnums {

    SEA_WING("0","海翼"),
    OTHER("1","其它");

    private String type;

    private String desc;

    ManagementEnums(String type, String desc){
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
