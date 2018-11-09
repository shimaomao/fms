package cn.com.leadu.fms.common.constant.enums.original;

/**
 * @description: 资料状态
 * @author:ningyangyang
 * @since:2018/5/3
 */
public enum OrigFileStatusEnums {

    VERIFIED("0","待归档"),
    ARCHIVED("1","已归档"),
    CHECKED("2","归档中");

    private String type;

    private String desc;

    OrigFileStatusEnums(String type, String desc) {
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
