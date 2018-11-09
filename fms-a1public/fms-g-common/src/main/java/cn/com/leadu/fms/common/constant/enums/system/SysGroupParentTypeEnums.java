package cn.com.leadu.fms.common.constant.enums.system;

/**
 * @author wangxue
 * @ClassName: SysGroupParentTypeEnums
 * @Description:
 * @date 2018/3/12
 */
public enum SysGroupParentTypeEnums {

    ADMIN("1","行政组织"),
    FINANCE("2","财务组织"),
    SELL("3","销售组织"),
    OPERATION("4","运营组织");

    private String type;

    private String desc;

    SysGroupParentTypeEnums(String type, String desc){
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
