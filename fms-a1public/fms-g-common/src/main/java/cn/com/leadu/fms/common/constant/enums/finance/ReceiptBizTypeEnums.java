package cn.com.leadu.fms.common.constant.enums.finance;

/**
 * Created by lijunjun on 2018/6/10.
 *  @Description: 款项类型
 */
public enum ReceiptBizTypeEnums {

    REPAYMENT_AMOUNT("0", "还款金额"),
    OVERDUE_AMOUNT("1", "逾期金额"),
    PREPAYMENT_AMOUNT("2", "提前还款"),
    TO_BE_FIN_RECEIPT("3","财务待收款");

    private String type;

    private String desc;

    ReceiptBizTypeEnums(String type, String desc) {
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
