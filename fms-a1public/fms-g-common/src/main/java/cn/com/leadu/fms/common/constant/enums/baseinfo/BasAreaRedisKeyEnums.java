package cn.com.leadu.fms.common.constant.enums.baseinfo;

/**
 * @author qiaomengnan
 * @ClassName: BasAreaRedisKeyEnums
 * @Description:
 * @date 2018/7/24 0024
 */
public enum BasAreaRedisKeyEnums {

    FMS_COMMON_AREA_VALUES("fms:common:area:values","保存系统常量的值"),
    FMS_COMMON_AREA_VALUES_VERSION("fms:common:area:values:version","系统常量版本");

    BasAreaRedisKeyEnums(String prefix, String desc){
        this.prefix = prefix;
        this.desc = desc;
    }

    private String prefix;

    private String desc;

    public String getPrefix(){
        return prefix;
    }

    public String getDesc(){
        return desc;
    }

}
