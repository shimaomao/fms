package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * @author qiaomengnan
 * @ClassName: InvoiceStatusEnums
 * @Description: 开票状态枚举
 * @date 2018/9/12
 */
public enum InvoiceStatusEnums {

    NO_INVOICE("0","未开票"),
    INVOICE("1","已开票"),
    NO_PRINT("2","已开票未打印");

    private String status;

    private String desc;

    InvoiceStatusEnums(String status,String desc){
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
