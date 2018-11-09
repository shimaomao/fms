package cn.com.leadu.fms.common.constant.enums.cost;

/**
 * @author yanfengbo
 * @ClassName: PaymentStsEnums
 * @Description: 还款状态
 * @date
 */
public  enum PaymentStsEnums {
    UNCLEARED("0","未结清"),
    AUTOMATIC_CLEARING("1","自动结清"),
    NORMAL_EARLY_CLEARANCE("2","正常提前结清"),
    FORCIBLY_EARLY_CLEARANCE("3","强制提前结清");

    private String type;

    private String desc;

    PaymentStsEnums(String type, String desc) {
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
