package cn.com.leadu.fms.common.constant.enums.finance;
/**
 * @author yanfengbo
 * @ClassName: paymentTypeEnums
 * @Description: 付款类型
 * @date
 */
public enum PaymentTypeEnums {

    CONTREQUEST("1","合同请款");
    private String type;

    private String desc;

    PaymentTypeEnums(String type, String desc){
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
