package cn.com.leadu.fms.common.constant.enums.original;

/**
 * Created by root on 2018/6/20.
 */
public enum FileTypeCodeEnums {

    NOT_CARKEY("0","复核"),
    CARKEY_DEPOSIT_FLAG_YES("1","财务确认"),
    CARKEY_DEPOSIT_FLAG_NO("2","审核");

    private String type;

    private String desc;

    FileTypeCodeEnums(String type, String desc) {
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
