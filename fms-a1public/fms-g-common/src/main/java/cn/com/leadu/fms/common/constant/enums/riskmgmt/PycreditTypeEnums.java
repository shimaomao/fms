package cn.com.leadu.fms.common.constant.enums.riskmgmt;

/**
 * Created by liujinge on 2018/6/4
 * 鹏元接口类型
 */
public enum PycreditTypeEnums {
    ANTI("1","反欺诈分析"),
    ADDR("2","地址核验-居住地"),
    ADDR1("21","地址核验-居住地"),
    ADDR2("22","地址核验-单位地址"),
    CARD_CHECK("3","卡核查及交易"),  //不使用
    PERSON_BKCHECK("4","个人银行卡核查"),
    CORP_BKCHECK("5","企业银行卡核查"),
    DRIVER("6","驾驶证核查"),
    DRIVER1("61","个人驾驶证基本信息核查"),
    DRIVER2("62","个人驾驶证状态查询"),
    DRIVER3("63","个人驾驶证准驾车型核查"),
    DRIVER4("64","个人驾驶证初次领证日期核查"),
    DRIVER5("65","个人驾驶证档案编号核查"),
    CORP_RISK("7","企业风险"),
    CORP_DEBT("8","企业债务")
    ;
    private String type;

    private String desc;

    PycreditTypeEnums(String type, String desc){
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
