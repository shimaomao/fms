package cn.com.leadu.fms.common.constant.enums.system;

/**
 * @author qiaomengnan
 * @ClassName: SysRoleEnum
 * @Description: 角色id枚举,此处程序硬编码超级管理员id，不允许该角色被删除
 * @date 2018/1/22
 */
public enum SysRoleEnums {

    ADMIN("1","超级管理员"),
    KJ("KJ101","会计"),
    Z("Z101","总经理"),
    CN("CN101","出纳"),
    CW("CW101","财务经理"),
    FK101("FK101","风控复审"),
    FK102("FK102","风控初审"),
    FZ("FZ101","业务副总"),
    IT("IT101","IT"),
    YW("YW101","业务经理"),
    QY("QY101","区域经理"),
    YW102("YW102","贷后账户"),
    ZG101("ZG101","资管复核"),
    ZG102("ZG102","资管-请款"),
    ZJ("ZJ101","资金经理"),
    ADMIN1("admin","管理员"),
    ZG103("ZG103","资管-保险"),
    ZG104("ZG104","资管-归档");

    private String id;
    private String desc;

    SysRoleEnums(String id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

}
