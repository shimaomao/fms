package cn.com.leadu.fms.common.constant.enums.system;

/**
 * @author qiaomengnan
 * @ClassName: SysResourceEnum
 * @Description: 菜单类型枚举
 * @date 2018/1/7
 */
public enum SysResourceEnums {

    MENU(0, "菜单"),
    RES(1,"接口资源");

    private Integer type;
    private String desc;

    SysResourceEnums(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static SysResourceEnums getEnum(String code){
        if(code==null || "".equals(code)){
            return null;
        }
        for (SysResourceEnums e : SysResourceEnums.values()) {
            if (code.equals(e.getType())) {
                return e;
            }
        }
        return null;
    }

    public Integer getType() {
        return type;
    }


}