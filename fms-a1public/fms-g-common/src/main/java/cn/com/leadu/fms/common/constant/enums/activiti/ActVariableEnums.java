package cn.com.leadu.fms.common.constant.enums.activiti;

/**
 * @author qiaomengnan
 * @ClassName: ActVariableEnums
 * @Description: 流程参数枚举
 * @date 2018/3/15
 */
public enum  ActVariableEnums {

    PROJECT_MANAGER_IDS("projectManagerIds","项目经理id集合"),
    DIVISION_MANAGER_IDS("divisionManagerIds","部门经理id集合"),
    GENERAL_MANAGER_IDS("generalManagerIds","总经理id集合");

    private String key;

    private String desc;

    ActVariableEnums(String key,String desc){
        this.key = key;
        this.desc = desc;
    }

    public String getKey(){
        return this.key;
    }


}
