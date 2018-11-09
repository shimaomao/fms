package cn.com.leadu.fms.common.constant.enums.system;

/**
 * @author qiaomengnan
 * @ClassName: SystemRedisKeyEnums
 * @Description:
 * @date 2018/2/25
 */
public enum SystemRedisKeyEnums {

    FMS_SYSTEM_SYS_DATA_DICTIONARY_TREE("fms:system:sys_data_dictionary:tree","全部数据字典,以树形保存"),

    FMS_SYSTEM_SYS_WIDGET_ATTRIBUTE_TREE("fms:system:sys_widget_attribute:tree","全部项目权限,以树形保存");

    private String prefix;

    private String desc;

    SystemRedisKeyEnums(String prefix, String desc){
        this.prefix = prefix;
        this.desc = desc;
    }

    public String getPrefix(){
        return this.prefix;
    }

    public String getDesc(){
        return this.desc;
    }


}
