package cn.com.leadu.fms.common.constant.enums.cost;

/**
 * @program: fms
 * @description: 提前还款类型
 * @author: yangyiquan
 * @create: 2018-08-10 10:21
 **/
public enum PrepaymentTypeEnums {
    NORMAL_PREPAYMENT("0","正常提前还款"),
    FORCIBLY_PREPAYMENT("1","强制提前还款");

    private String type;

    private String desc;

    PrepaymentTypeEnums(String type, String desc) {
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