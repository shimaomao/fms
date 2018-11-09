package cn.com.leadu.fms.common.constant.enums.cost;

/**
 * @author yanfengbo
 * @ClassName:  OverdueExemptStatusEnums
 * @Description: 罚息免除状态
 * @date
 */
public enum OverdueExemptStatusEnums {
    TO_BE_APPROVAL("1000","待审批"),
    RETURN("1001","以退回"),
    AGREE_APPROVAL("1002","审批通过");

    private String type;

    private String desc;

    OverdueExemptStatusEnums(String type, String desc) {
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
