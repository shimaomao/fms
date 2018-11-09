package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * 客户费用款项
 * Created by wangxue on 2018/9/18.
 */
public enum CostItemEnums {

    DEPOSIT("deposit","保证金");

    private String type;

    private String desc;

    CostItemEnums(String type, String desc) {
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
