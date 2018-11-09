package cn.com.leadu.fms.common.constant.enums.product;

/**
 * @author wangxue
 * @ClassName: FinItemTypeEnums
 * @Description:
 * @date 2018/3/24
 */
public enum FinItemTypeEnums {

    FINANCE_ITEM("1","融资项目"),
    INIT_FINAL_ITEM("2","首尾付融资项目"),
    DEPOSIT_ITEM("3","保证金融资项目"),
    FINAL_ITEM("4","保证金融资项目");

    private String type;

    private String desc;

    FinItemTypeEnums(String type, String desc){
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
