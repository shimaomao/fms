package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * Created by wangxue on 2018/9/6.
 */
public enum InsurancDealTypeEnums {


    NOT_DEAL("0","不处理"),
    TRANSFER("1","过户"),
    RETREATS("2","退保");

    private String type;

    private String desc;

    InsurancDealTypeEnums(String type, String desc) {
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
