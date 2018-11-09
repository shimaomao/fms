package cn.com.leadu.fms.common.constant.enums;

/**
 * @author qiaomengnan
 * @ClassName: CommonCodeRedisKeyEnums
 * @Description: 数据字典
 * @date 2018/3/27
 */
public enum CommonCodeRedisKeyEnums {

    FMS_COMMON_CODE_VALUES("fms:common:code:values","用于保存所有的数据字典值,key以codeType_codeValue拼接"),
    FMS_COMMON_CODE_VALUES_TREE("fms:common:code:values:tree","用于保存所有的数据字典,key为codeType,值为该codeType下的集合"),
    FMS_COMMON_CODE_VALUES_VERSION("fms:common:code:values:version","数据字典值版本");

    private String prefix;

    private String desc;

    CommonCodeRedisKeyEnums(String prefix, String desc){
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
