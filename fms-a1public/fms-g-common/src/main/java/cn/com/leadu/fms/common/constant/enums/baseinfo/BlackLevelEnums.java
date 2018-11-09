package cn.com.leadu.fms.common.constant.enums.baseinfo;

/**
 * 黑名单级别类型
 * Created by wangxue on 2018/9/21.
 */
public enum BlackLevelEnums {

    LOW_LEVEL("0","低"),
    MEDIUM_LEVEL("1","中"),
    HIGH_LEVEL("2","高");

    private String type;

    private String desc;

    BlackLevelEnums(String type, String desc) {
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
