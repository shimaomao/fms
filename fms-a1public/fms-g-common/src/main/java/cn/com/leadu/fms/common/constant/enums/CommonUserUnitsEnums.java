package cn.com.leadu.fms.common.constant.enums;

/**
 * @author qiaomengnan
 * @ClassName: CommonUserUnitsEnums
 * @Description: 系统中用户单位
 * @date 2018/4/8
 */
public enum CommonUserUnitsEnums {

    GROUP("0","组织机构"),
    ROLE("1","角色"),
    USER("2","用户"),
    GROUP_SIGN("3","组织机构会签"),
    ROLE_SIGN("4","角色会签"),
    USER_SIGN("5","用户会签");

    private String unit;

    private String desc;

    CommonUserUnitsEnums(String unit,String desc){
        this.unit = unit;
        this.desc = desc;
    }

    public String getUnit(){
        return this.unit;
    }

    public String getDesc(){
        return this.desc;
    }

}
