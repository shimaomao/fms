package cn.com.leadu.fms.common.constant.enums.baseinfo;

/**
 * @author qiaomengnan
 * @ClassName: RuleTypeEnums
 * @Description: 规则引擎类型
 * @date 2018/5/21
 */
public enum RuleTypeEnums {

    OVERDUE_ASSIGNMENT("0","overdue_assignment","逾期分担规则"),
    PRODUCT("1","product","产品方案规则"),
    CONTRACT("2","contract_template","合同模板规则"),
    INSURANCE("3","insurance","保险险种规则"),
    ARCHIVAL_DAYS("4","archival_days","归档天数规则")
    ;

    private String type;

    private String key;

    private String desc;


    RuleTypeEnums(String type,String key,String desc){
        this.type = type;
        this.key = key;
        this.desc = desc;
    }

    public String getType(){
        return this.type;
    }

    public String getKey(){
        return this.key;
    }

    public String getDesc(){
        return this.desc;
    }

}
