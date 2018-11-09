package cn.com.leadu.fms.common.constant.enums.finance;

/**
 * @description:   还款逾期状态
 * @author:ningyangyang
 * @since:2018/5/8
 */
public enum OverDueStatusEnums {

    NOT_OVERDUE("0","正常"),
    ALREADY_OVERDUE("1","已逾期");

    private String type;

    private String desc;

    OverDueStatusEnums(String type, String desc) {
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
