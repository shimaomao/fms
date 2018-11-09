package cn.com.leadu.fms.common.constant.enums.system;

/**
 * Created by ningyangyang on 2018/7/23.
 * 组织层级
 */
public enum SysGroupLev {

    BRANCH("wl003","分公司");
    private String type;

    private String desc;

    SysGroupLev(String type, String desc){
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
