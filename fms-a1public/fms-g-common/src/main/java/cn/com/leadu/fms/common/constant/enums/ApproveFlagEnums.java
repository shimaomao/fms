package cn.com.leadu.fms.common.constant.enums;

/**
 * Created by yyq on 2018/7/13.
 * 审批通用操作
 */
public enum ApproveFlagEnums {
    SUBMIT("1","提交"),
    BACK("2","退回");

    private String type;

    private String desc;

    ApproveFlagEnums(String type, String desc){
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
