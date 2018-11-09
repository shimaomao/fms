package cn.com.leadu.fms.common.constant.enums.prebiz;

/**
 * @author wangxue
 * @ClassName: DepositRtnModeEnums
 * @Description:保证金返还方式
 * @date 2018/3/24
 */
public enum DepositRtnModeEnums {

    ONETIME_DEPOSIT("1","一次性"),
    INSTALMENT_DEPOSIT("2","分期");

    private String type;

    private String desc;

    DepositRtnModeEnums(String type, String desc){
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
