package cn.com.leadu.fms.common.constant.enums.baseinfo;

/**
 * 黑名单数据来源
 * Created by wangxue on 2018/9/21.
 */
public enum BlackSourceEnums {

    MANUAL_INPUT("0","手动输入");

    private String type;

    private String desc;

    BlackSourceEnums(String type, String desc) {
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
