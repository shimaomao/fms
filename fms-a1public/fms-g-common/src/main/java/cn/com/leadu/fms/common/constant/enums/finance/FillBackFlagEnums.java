package cn.com.leadu.fms.common.constant.enums.finance;

/**
 * @author lijunjun
 * @ClassName: FillBackFlagEnums
 * @Description:
 * @date 2018/6/9
 */
public enum FillBackFlagEnums {

    NORMAL_PRODUCT("1", "常规产品");

    private String type;

    private String desc;

    FillBackFlagEnums(String type, String desc) {
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
