package cn.com.leadu.fms.common.constant.enums.finance;

/**
 * @author qiaomengnan
 * @ClassName: AssisAccountTypeEnums
 * @Description: 辅助核算类型enums
 * @date 2018/7/30
 */
public enum AssisAccountTypeEnums {

    ITEM_COMPANY("Item_company","公司"),
    ITEM_CUSTOM("Item_custom","客户");

    private String type;

    private String desc;

    AssisAccountTypeEnums(String type, String desc){
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
