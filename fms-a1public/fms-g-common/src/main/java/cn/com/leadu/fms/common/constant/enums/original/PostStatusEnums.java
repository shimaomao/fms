package cn.com.leadu.fms.common.constant.enums.original;

/**
 * @description: 资料邮寄信息
 * @author:ningyangyang
 * @since:2018/5/7
 */
public enum PostStatusEnums {

    TO_BE_RECEIVED("0","待签收"),
    ALREADY_RECEIVED("1","已签收");

    private String type;

    private String desc;

    PostStatusEnums(String type, String desc) {
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
