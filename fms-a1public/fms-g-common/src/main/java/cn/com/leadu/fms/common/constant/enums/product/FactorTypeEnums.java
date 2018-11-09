package cn.com.leadu.fms.common.constant.enums.product;

/**
 * @author wangxue
 * @ClassName: FactorTypeEnums
 * @Description:
 * @date 2018/3/27
 */
public enum FactorTypeEnums {

    EQUAL("1","等于"),
    SECTION("2","区间");

    private String type;

    private String desc;

    FactorTypeEnums(String type, String desc){
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
