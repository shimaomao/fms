package cn.com.leadu.fms.common.constant.enums.baseinfo;

/**
 * @author yanfengbo
 * @ClassName:
 * @Description: 银行账号维护机构类型
 * @date  
 */
public enum BankOrganizationTypeEnums {
    USER_GROUP("0","用户组"),
    BAS_SALES("1","实际销售方"),
    BAS_PARTNER("2","经销商"),
    CAR_COLLECT_COMP("3","收车机构"),
    GPS_MANUFACTURER("4","gps厂商"),
    MORTGAGES("5","抵押资方"),
    INSURANCE_COMPANY("6","保险公司"),
    INDIVIDUAL_ACCOUNT("7","个人账户");

    private String type;

    private String desc;

    BankOrganizationTypeEnums(String type, String desc) {
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
