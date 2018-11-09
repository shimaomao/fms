package cn.com.leadu.fms.common.constant.enums.thirdinterface;

/**
 * @author qiaomengnan
 * @ClassName: GoldenTaxResultEnums
 * @Description: 金税返回结果
 * @date 2018/9/13 0013
 */
public enum GoldenTaxResultEnums {

    INVOICE_SUCCESS("4011","开票成功"),
    PRINTINV_SUCCESS("5011","打印成功");

    private String result;

    private String desc;

    GoldenTaxResultEnums(String result,String desc) {
        this.result = result;
        this.desc = desc;
    }

    public String getResult() {
        return result;
    }

    public String getDesc() {
        return desc;
    }

}
