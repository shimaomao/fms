package cn.com.leadu.fms.common.constant.enums.finance;

/**
 * @author lijunjun
 * @ClassName: LicenseAttrEnums
 * @Description:
 * @date 2018/6/9
 */
public enum LicenseAttrEnums {

    FINANCE_LEASE("0","融资租赁"),
    LEASE_DIRECT("1", "经营租赁"),
    LEASE_BACK("2", "回租赁");

    private String type;

    private String desc;

    LicenseAttrEnums(String type, String desc) {
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
