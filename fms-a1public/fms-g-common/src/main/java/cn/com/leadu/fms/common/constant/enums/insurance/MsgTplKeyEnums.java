package cn.com.leadu.fms.common.constant.enums.insurance;

/**
 * @description:   模板key
 * @author:ningyangyang
 * @since:2018/5/14
 */
public enum MsgTplKeyEnums {

    CUSTOMER_NAME("${customerName}","客户姓名"),
    OVERDUE_DAYS("${overDueDays}","逾期天数"),
    INVALID_DAYS("${invalidDays}","失效天数");

    private String type;

    private String desc;

    MsgTplKeyEnums(String type, String desc) {
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
