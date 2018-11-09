package cn.com.leadu.fms.common.constant.enums.finance;

/**
 * @author qiaomengnan
 * @ClassName: InputModeEnums
 * @Description:
 * @date 2018/6/9
 */
public enum  InputModeEnums {

    IMPORT("0","EXCEL导入"),
    INPUT("1","画面业务录入"),
    INTER("2","抵扣租金"),
    SHORTFALL("3","差额");
//    RELIEF_RECEIPT("1","解押收款"),
//    BORROW_RECEIPT_INPUT("1","借阅收款录入"),
//    BORROW_DEDUCTION_RENT("104","借阅抵扣租金"),
//    RENEWAL_RECEIPT("1","续保收款");

    private String type;

    private String desc;

    InputModeEnums(String type, String desc) {
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
