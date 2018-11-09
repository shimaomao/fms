package cn.com.leadu.fms.common.constant.enums.riskmgmt;

/**
 * 企业风险信息类型
 */
public enum PycreditCropRiskTypeEnums {

    AL_COUNT("alCount","司法案例信息条数"),
    ZX_COUNT("zxCount","司法执行信息条数"),
    SX_COUNT("sxCount","司法失信信息条数"),
    SW_COUNT("swCount","税务行政执法信息条数"),
    CQGG_COUNT("cqggCount","催欠公告信息条数"),
    WDYQ_COUNT("wdyqCount","网贷逾期信息条数"),
    KTGG_COUNT("ktggCount","开庭公告信息条数"),
    QTSFGG_COUNT("qtsfggCount","其他司法公告信息条数"),
    SPLC_COUNT("splcCount","审判流程信息条数")
    ;
    private String type;

    private String desc;

    PycreditCropRiskTypeEnums(String type, String desc){
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