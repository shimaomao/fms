package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * 逾期类型
 * Created by wangxue on 2018/9/26.
 */
public enum OverdueTypeEnums {

    TOTAL("0","合计"),
    ONE_SEVEN("1","逾期1-7"),
    EIGHT_FIFTEEN("2","逾期8-15"),
    SIXTEEN_THIRTY("3","逾期16-30"),
    THIRTY_ONE_SIXTY("4","逾期31-60"),
    SIXTY_NINETY("5","逾期60-90"),
    NINETY_GREATER("6","逾期90+");

    private String type;

    private String desc;

    OverdueTypeEnums(String type, String desc) {
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
