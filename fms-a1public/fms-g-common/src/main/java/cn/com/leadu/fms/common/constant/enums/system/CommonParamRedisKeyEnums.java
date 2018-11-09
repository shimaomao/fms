package cn.com.leadu.fms.common.constant.enums.system;

/**
 * @author qiaomengnan
 * @ClassName: CommonParamRedisKeyEnums
 * @Description: 系统常量redis存值key
 * @date 2018/6/20
 */
public enum CommonParamRedisKeyEnums {

    FMS_COMMON_PARAM_VALUES("fms:common:param:values","保存系统常量的值"),
    FMS_COMMON_PARAM_VALUES_VERSION("fms:common:param:values:version","系统常量版本");

    private String prefix;

    private String desc;

    CommonParamRedisKeyEnums(String prefix,String desc){
        this.prefix = prefix;
        this.desc = desc;
    }

    public String getPrefix(){
        return prefix;
    }

    public String getDesc(){
        return desc;
    }

}
