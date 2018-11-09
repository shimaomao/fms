package cn.com.leadu.fms.common.constant.enums.activiti;

import lombok.Data;

/**
 * @author qiaomengnan
 * @ClassName: ActProcdefKeys
 * @Description: 工作流流程key定义
 * @date 2018/3/14
 */
public enum ActProcdefKeys {

    ACT_USER_LEAVE("act_user_leave","请假"),
    ACT_USER_LEAVE_ALL("act_user_leave_all","员工请假");

    private String key;

    private String desc;

    ActProcdefKeys(String key,String desc){
        this.key = key;
        this.desc = desc;
    }

    public String getKey(){
        return this.key;
    }

    public String getDesc(){
        return desc;
    }

}
