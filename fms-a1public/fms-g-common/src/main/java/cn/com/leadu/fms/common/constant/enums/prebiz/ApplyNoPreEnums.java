package cn.com.leadu.fms.common.constant.enums.prebiz;

/**
 * Created by ningyangyang on 2018/9/14.
 * 申请编号前缀枚举
 */
public enum ApplyNoPreEnums {

    CHANGE_LESSEE("BG","变更承租人");

    private String type;

    private String desc;

    ApplyNoPreEnums(String type, String desc){
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
