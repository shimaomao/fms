package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * @author qiaomengnan
 * @ClassName: InvoiceStatusEnums
 * @Description: 开票区分枚举
 * @date 2018/9/12
 */
public enum InvoiceFlagEnums {

    MANUAL("0","手动开票"),
    AUTO("1","自动开票");

    private String status;

    private String desc;

    InvoiceFlagEnums(String status, String desc){
        this.status = status;
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }


}
