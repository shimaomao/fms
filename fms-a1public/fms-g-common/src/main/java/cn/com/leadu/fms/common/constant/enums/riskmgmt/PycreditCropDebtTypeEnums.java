package cn.com.leadu.fms.common.constant.enums.riskmgmt;

/**
 * 企业债务信息类型
 */
public enum PycreditCropDebtTypeEnums {

    MORGUAL_INFO("morgualInfo","动产抵押"),
    MORDETAIL_INFO("morDetailInfo","动产抵押物"),
    SHARESFROST_INFO("sharesFrostInfo","股权冻结"),
    SHARESIMPAWN_INFO("sharesImpawnInfo","股权出质"),
    LIQUIDATION_INFO("liquidationInfo","清算信息")
    ;
    private String type;

    private String desc;

    PycreditCropDebtTypeEnums(String type, String desc){
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