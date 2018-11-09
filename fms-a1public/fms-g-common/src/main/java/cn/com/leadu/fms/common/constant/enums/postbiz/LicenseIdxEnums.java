package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * @author fangshaofeng
 * @ClassName: InvoiceStatusEnums
 * @Description: 指标状态枚举
 * @date 2018/9/18
 */
public enum LicenseIdxEnums {
    ALREADYUSED("0","未使用"),
    APPOINTMENT("1","预约中"),
    NOTUSED("2","已使用");

    private String type;

    private String desc;

    LicenseIdxEnums(String type, String desc) {
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
