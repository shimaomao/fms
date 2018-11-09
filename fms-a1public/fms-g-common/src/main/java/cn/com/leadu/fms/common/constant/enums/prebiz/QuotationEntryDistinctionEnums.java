package cn.com.leadu.fms.common.constant.enums.prebiz;

/**
 * @author yanfengbo
 * @ClassName: QuotationEntryDistinctionEnums
 * @Description: 报价录入区分枚举
 * @date
 */
public enum QuotationEntryDistinctionEnums {
    BAO_JIA("0","报价"),
    TI_DAN("1","提单");

    private String type;

    private String desc;

    QuotationEntryDistinctionEnums(String type, String desc){
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
