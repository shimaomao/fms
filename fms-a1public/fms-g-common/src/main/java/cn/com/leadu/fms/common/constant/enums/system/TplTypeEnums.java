package cn.com.leadu.fms.common.constant.enums.system;

/**
 * @author qiaomengnan
 * @ClassName: TplTypeEnums
 * @Description: 模板类型枚举
 * @date 2018/7/12
 */
public enum  TplTypeEnums {

    MESSAGE("1","短信"),
    CONTRACT("2","合同");

    private String type;

    private String name;

    TplTypeEnums(String type, String name){
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

}
