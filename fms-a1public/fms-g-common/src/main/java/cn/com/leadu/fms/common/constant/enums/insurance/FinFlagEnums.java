package cn.com.leadu.fms.common.constant.enums.insurance;

/**
 * Created by ningyangyang on 2018/6/8.
 * 是否融保险
 */
public enum FinFlagEnums {

    FIN_INSUR("1","融保险"),
    NOT_FIN_INSUR("0","不融保险");

    private String type;

    private String desc;

    FinFlagEnums(String type, String desc) {
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
