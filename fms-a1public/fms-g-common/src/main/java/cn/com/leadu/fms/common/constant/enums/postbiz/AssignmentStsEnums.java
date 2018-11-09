package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * 任务处理状态
 * Created by wangxue on 2018/9/4.
 */
public enum AssignmentStsEnums {

    UNTREATED("0","未处理"),
    PROCESSED("1","已处理"),
    CANCEL("2","已还款");

    private String type;

    private String desc;

    AssignmentStsEnums(String type, String desc) {
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
