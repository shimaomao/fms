package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * Created by root on 2018/8/29.
 */
public enum SolveTypeEnums {

    BEFORE_MODIFY("0","变更前"),
    AFTER_MODIFY("1","变更后"),
    ADD("2","增加"),
    DELETE("3","删除");

    private String type;

    private String desc;

    SolveTypeEnums(String type, String desc) {
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
