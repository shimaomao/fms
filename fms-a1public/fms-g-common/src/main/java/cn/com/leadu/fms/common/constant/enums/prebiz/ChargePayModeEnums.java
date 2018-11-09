package cn.com.leadu.fms.common.constant.enums.prebiz;

/**
 * @author wangxue
 * @ClassName: FinItemTypeEnums
 * @Description:手续费收取方式
 * @date 2018/3/24
 */
public enum ChargePayModeEnums {

    ONETIME_CHARGE("1","一次性"),
    INSTALMENT_CHARGE("2","分期");

    private String type;

    private String desc;

    ChargePayModeEnums(String type, String desc){
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
