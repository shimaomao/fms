package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * 月度到账模版key
 * Created by qinmuq on 2018/9/18.
 */
public enum MonthlyRentEnums {

    EXCELLKEY("monthlyRent","月度到账模版");

    private String type;

    private String desc;

    MonthlyRentEnums(String type, String desc) {
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
