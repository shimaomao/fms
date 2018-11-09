package cn.com.leadu.fms.common.constant.enums.baseinfo;

/**
 * @author yanfengbo
 * @ClassName:  BasSalesStatusEnums
 * @Description: 实际销售方状态
 * @date
 */
public enum BasSalesStatusEnums {
    TO_BE_APPROVAL("1200","待审批"),
    RETURN("1201","以退回"),
    AGREE_APPROVAL("1202","审批通过");

    private String type;

    private String desc;

    BasSalesStatusEnums(String type, String desc) {
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
