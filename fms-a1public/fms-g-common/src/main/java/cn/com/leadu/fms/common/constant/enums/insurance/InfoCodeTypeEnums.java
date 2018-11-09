package cn.com.leadu.fms.common.constant.enums.insurance;

/**
 * Created by ningyangyang on 2018/7/13.
 * 消息业务类型
 */
public enum InfoCodeTypeEnums {

    INSUR_RENEWAL("insurance","续保任务"),
    APPLY_LIST("applyList","申请一览"),
    GPS_DISPATCH_LIST("gpsDispatchList","gps派单录入"),
    PILFER_INSURANCE_LIST("pilferInsuranceList","盗抢险录入"),
    ORIG_FILE_ARCHIVE("origFileArchive","原件归档"),
    EQU_MOR_DETAIL_LIST("equMorDetailList","资方解押");
    private String type;

    private String desc;

    InfoCodeTypeEnums(String type, String desc) {
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
