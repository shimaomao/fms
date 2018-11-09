package cn.com.leadu.fms.common.constant.enums;

/**
 * @author wangxue
 * @ClassName: CommonStatusEnums
 * @Description: 枚举 常量
 * @date 2018/3/27
 */
public enum CommonStatusEnums {

    ENABLE("0","启用"),
    DISABLE("1","禁用");

    private String type;

    private String desc;

    CommonStatusEnums(String type, String desc){
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
