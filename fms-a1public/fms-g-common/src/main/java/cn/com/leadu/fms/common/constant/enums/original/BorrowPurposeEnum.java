package cn.com.leadu.fms.common.constant.enums.original;

/**
 * 借阅用途枚举类
 * Created by yyq on 2018/5/21.
 */
public enum BorrowPurposeEnum {

    NORMAL("01","常规"),
    TRANSFER("02","过户");

    private String type;

    private String desc;

    BorrowPurposeEnum(String type, String desc) {
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
