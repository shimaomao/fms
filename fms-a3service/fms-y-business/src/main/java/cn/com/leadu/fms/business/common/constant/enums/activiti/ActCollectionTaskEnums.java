package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * Created by root on 2018/9/12.
 */
public enum ActCollectionTaskEnums {

    APPLY_USER("applyUser","申请人标识"),
    DISPATCH_USER("dispatchUser","派单人标识"),
    APPROVAL_USER("approvalUser","资管审核人标识"),
    MANAGER_USER("managerUser","副总标识"),
    REGISTER_USER("registerUser","登记人标识"),
    CONFIRM_USER("confirmUser","风控经理确认人标识"),

    COLLECTION_TASK_APPLY("collection_task_apply","上门催收申请key"),
    COLLECTION_TASK_DISPATCH("collection_task_dispatch","上门催收派单key"),
    COLLECTION_TASK_APPROVAL("collection_task_approval","风控经理审核key"),
    COLLECTION_TASK_MANAGER("collection_task_manager","副总审核key"),
    COLLECTION_TASK_REGISTER("collection_task_register","上门催收结果登记key"),
    COLLECTION_TASK_CONFIRM("collection_task_confirm","上门催收结果确认key"),

    DISPATCH_STATUS("dispatchStatus","派单状态标识"),
    APPROVAL_STATUS("approvalStatus","风控审核状态标识"),
    MANAGER_STATUS("managerStatus","副总审核状态标识"),
    CONFIRM_STATUS("confirmStatus","副总审核状态标识"),

    DISPATCH_USER_UNIT("dispatchUserUnit","派单用户单位标识"),
    DISPATCH_USER_ID("dispatchUserId","派单用户单位id"),
    APPROVAL_USER_UNIT("approvalUserUnit","风控审核用户单位标识"),
    APPROVAL_USER_ID("approvalUserId","风控审核用户单位id"),
    MANAGER_USER_UNIT("managerUserUnit","副总审核用户单位标识"),
    MANAGER_USER_ID("managerUserId","副总审核用户单位id"),
    REGISTER_USER_UNIT("registerUserUnit","催收结果登记用户单位标识"),
    REGISTER_USER_ID("registerUserId","催收结果登记用户单位id"),
    CONFIRM_USER_UNIT("confirmUserUnit","催收结果登记用户单位标识"),
    CONFIRM_USER_ID("confirmUserId","催收结果登记用户单位id");

    private String flag;

    private String desc;

    ActCollectionTaskEnums(String flag, String desc){
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
