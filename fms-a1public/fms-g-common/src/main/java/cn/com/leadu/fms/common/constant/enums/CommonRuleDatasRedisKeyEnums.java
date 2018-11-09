package cn.com.leadu.fms.common.constant.enums;

/**
 * @author qiaomengnan
 * @ClassName: CommonRuleDatasRedisKeyEnums
 * @Description: redis存储规则数据key
 * @date 2018/5/21
 */
public enum  CommonRuleDatasRedisKeyEnums {


    FMS_COMMON_RULE_DATAS_MAP("fms:common:rule:datas:map:","用户保存规则引擎计算的数据"),
    FMS_COMMON_RULE_DATAS_TREE("fms:common:rule:datas:tree:","用户保存规则引擎计算的数据");



    private String prefix;

    private String desc;

    CommonRuleDatasRedisKeyEnums(String prefix, String desc){
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
