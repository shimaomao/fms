package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * Created by root on 2018/10/11.
 */
public enum ChangeTypeEnums {

    BASIC_CHANGE("1","基本信息变更"),
    DEFER_TASK("2","合同展期"),
    DEPOSIT_CHANGE("3","保证金变更"),
    CHANGE_LESSEE("4","变更承租人");

    private String type;

    private String desc;

    ChangeTypeEnums(String type, String desc) {
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
