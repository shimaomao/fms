package cn.com.leadu.fms.common.constant.enums.system;

/**
 * @author wangxue
 * @ClassName: SysUserValidMenuTypeEnums
 * @Description:
 * @date 2018/3/92
 */
public enum SysUserValidMenuTypeEnums {

    ROLE_CONTROLLER("0","角色控制"),

    USER_CONTROLLER("1","用户控制");

    private String type;

    private String desc;

    SysUserValidMenuTypeEnums(String type, String desc){
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

