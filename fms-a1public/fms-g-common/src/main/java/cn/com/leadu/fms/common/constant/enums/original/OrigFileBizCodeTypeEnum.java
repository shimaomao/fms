package cn.com.leadu.fms.common.constant.enums.original;

/**
 * Created by yyq on 2018/5/21.
 */
public enum OrigFileBizCodeTypeEnum {

    COMPLETE_CONTRACT("0","成交合同类"),
    INSURANCE_TYPE("2","续保业务类"),
    MORTGAGE_POST("1","抵押过户邮寄");

    private String type;

    private String desc;

    OrigFileBizCodeTypeEnum(String type, String desc) {
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
