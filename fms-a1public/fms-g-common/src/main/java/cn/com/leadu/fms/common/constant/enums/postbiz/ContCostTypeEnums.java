package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * 客户费用类型
 * Created by wangxue on 2018/9/18.
 */
public enum ContCostTypeEnums {


    COLLECT("01","收取"),
    DEDUCTION("02","抵扣"),
    RETURN("03","退还");

    private String type;

    private String desc;

    ContCostTypeEnums(String type, String desc) {
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
