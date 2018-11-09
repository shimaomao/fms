package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @author qiaomengnan
 * @ClassName: ActFlagEnums
 * @Description:
 * @date 2018/4/17 0017
 */
public enum  ActFlagEnums {

    SERVICE_ID("serviceId","业务id参数标识"),
    SERVICE_TYPE("serviceType","业务类型参数标识"),
    SERVICE_NAME("serviceName","业务名称标识"),
    PROCESS_INSTANCE_TYPE("processInstanceType","流程类型参数标识"),
    TASK_TITLE("taskTitle","任务标题"),
    START_USER("start_user","任务发起人"),
    START_USER_NAME("start_user_name","任务发起人姓名"),
    APPLY_USER("applyUser","申请人标识"),
    MESSAGE_STATUS_NAME("messageStatusName","消息状态名称"),
    SUPERIOR_TASK_KEY("superiorTaskKey","上一节点的key"),
    STATUS_NAME_SUFFIX("_statusName","form表单中的状态名称标识后缀"),
    STATUS_NAME("_status_","form表单中的状态标识后缀"),
    TASK_CODE_NAME("taskCodeName","需要从数据字典中取值的taskName标识"),
    DEFAULT_STATUS("defaultStatus","form表单中默认的状态标识名称"),
    EXIST_STATUS_NAMES("existStatusNames","已经存在的状态名称标识,说明是二次提交"),
    EXIST_STATUS("existStatus","需要从数据字典中取值的existStatus状态标识"),
    END_STATUS("endStatus","结束状态标识"),
    SUB_END_STATUS("subEndStatus","结束状态标识"),
    USER_UNIT("userUnit","用户单位标识"),
    USER_ID("userId","用户id标识"),
    SUPERIOR_TASK_USER("superiorTaskUser","上一节点的处理人");


    private String flag;

    private String desc;

    ActFlagEnums(String flag,String desc){
        this.flag = flag;
        this.desc = desc;
    }

    public String getFlag(){
        return this.flag;
    }

    public String getDesc(){
        return this.desc;
    }

}
