package cn.com.leadu.fms.common.constant.enums.postbiz;

/**
 * 过户状态
 * Created by wangxue on 2018/8/31.
 */
public enum TransferStatusEnums {

    NOT_TRANSFER("0","待过户"),
    TRANSFERRED("1","已过户");

    private String type;

    private String desc;

    TransferStatusEnums(String type, String desc) {
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
