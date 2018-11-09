package cn.com.leadu.fms.common.constant.enums.baseinfo;

/**
 * @author qiaomengnan
 * @ClassName: RuleItemTypeEnums
 * @Description:
 * @date 2018/5/21
 */
public enum RuleItemTypeEnums {

    CONSEQUENCE("0","结果"),
    CONDITION("1","条件");

    private String type;

    private String desc;


    RuleItemTypeEnums(String type,String desc){
        this.type = type;
        this.desc = desc;
    }

    public String getType(){
        return this.type;
    }

    public String getDesc(){
        return this.desc;
    }


}
