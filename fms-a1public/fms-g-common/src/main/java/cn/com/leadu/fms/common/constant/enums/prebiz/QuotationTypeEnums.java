package cn.com.leadu.fms.common.constant.enums.prebiz;

/**
 * @author lijunjun
 * @ClassName: QuotationTypeEnums
 * @Description:报价器业务类型
 * @date 2018/3/24
 */
public enum QuotationTypeEnums {

    FINANCE_LEASE("0","融资租赁"),
    OPERATION_LEASE("1","经营租赁"),
    LEASE_BACK("2","回租赁");


    private String type;

    private String desc;

    QuotationTypeEnums(String type, String desc){
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
