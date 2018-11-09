package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * Created by root on 2018/9/20.
 */
public enum ActLawsuitTaskEnums {

    APPLY_USER("applyUser","申请人标识"),
    APPROVAL_USER("approvalUser","风控经理标识"),
    DEMANAGER_USER("demanagerUser","业务副总标识"),
    MANAGER_USER("managerUser","总经理标识"),
    REGISTER_USER("registerUser","总经理标识"),

    LAWSUIT_TASK_APPLY("lawsuit_task_apply","诉讼申请key"),
    LAWSUIT_TASK_APPROVAL("lawsuit_task_approval","风控经理审核key"),
    LAWSUIT_TASK_DEMANAGER("lawsuit_task_demanager","业务副总审核key"),
    LAWSUIT_TASK_MANAGER("lawsuit_task_manager","总经理审核key"),
    LAWSUIT_TASK_REGISTER("lawsuit_task_register","诉讼登记key"),

    APPROVAL_STATUS("approvalStatus","风控经理审核状态标识"),
    DEMANAGER_STATUS("demanagerStatus","业务副总审核状态标识"),
    MANAGER_STATUS("managerStatus","总经理审核状态标识"),

    APPROVAL_USER_UNIT("approvalUserUnit","风控经理审核用户单位标识"),
    APPROVAL_USER_ID("approvalUserId","风控经理审核用户单位id"),
    DEMANAGER_USER_UNIT("demanagerUserUnit","业务副总审核用户单位标识"),
    DEMANAGER_USER_ID("demanagerUserId","业务副总审核用户单位id"),
    MANAGER_USER_UNIT("managerUserUnit","总经理审核用户单位标识"),
    MANAGER_USER_ID("managerUserId","总经理审核用户单位id");

    private String flag;

    private String desc;

    ActLawsuitTaskEnums(String flag, String desc){
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
