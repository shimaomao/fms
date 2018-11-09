package cn.com.leadu.fms.common.constant.enums.prebiz;/**
 * Created by ningyangyang on 2018/6/7.
 */

/**
 * @Title: fms
 * @Description: 是否家访
 * @author: ningyangyang
 * @date 2018/6/7 10:46
 */
public enum  VisitFlagEnums {

    CONFIRM_NOT_VISIT("2","确认否"),
    NOT_VISIT("0","不家访"),
    VISIT("1","家访");

    private String type;

    private String desc;

    VisitFlagEnums(String type, String desc) {
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
