package cn.com.leadu.fms.common.constant.enums.prebiz;

/**
 * @author liujinge
 * @ClassName: RentPayModeEnums
 * @Description:租金支付方式
 * @date 2018/3/24
 */
public enum RentPayModeEnums {

    BEGIN_PAY("0","期末支付"),
    END_PAY("1","期初支付");

    private String type;

    private String desc;

    RentPayModeEnums(String type, String desc){
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
