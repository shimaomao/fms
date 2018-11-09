package cn.com.leadu.fms.common.constant.enums.finance;

/**
 * @author yebangqiang
 * @ClassName: ContPayEnums
 * @Description:
 * @date 2018-7-20
 */
public enum ContPayEnums {

    PAY_FUND("02","付款款项");

    private String type;

    private String desc;

    ContPayEnums(String type, String desc) {
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
