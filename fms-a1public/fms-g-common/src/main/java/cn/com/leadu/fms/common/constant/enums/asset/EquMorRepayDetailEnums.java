package cn.com.leadu.fms.common.constant.enums.asset;

/**
 * @author qinmuqiao
 * @ClassName: EquMorRepayDetailEnums
 * @Description:
 * @date 2018/10/30
 */
public enum EquMorRepayDetailEnums {


    UNPAY("0","未还款"),
    ALREADY_PAY("1","已还款");

    private String type;

    private String desc;

    EquMorRepayDetailEnums(String type, String desc){
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
