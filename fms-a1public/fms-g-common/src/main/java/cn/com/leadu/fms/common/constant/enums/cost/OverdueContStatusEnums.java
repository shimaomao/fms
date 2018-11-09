package cn.com.leadu.fms.common.constant.enums.cost;

/**
 * @author yanfengbo
 * @ClassName: 逾期合同当前是否逾期状态用于罚息
 * @Description:
 * @date  
 */
public enum OverdueContStatusEnums {
    YES("1","是"),
    NO("0","否");

    private String type;

    private String desc;

    OverdueContStatusEnums(String type, String desc) {
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
