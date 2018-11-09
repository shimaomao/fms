package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * Created by ningyangyang on 2018/9/20.
 *  收车任务枚举
 */
public enum ActRetrieveCarEnums {

    //流程任务key
    RETRIEVE_TASK_APPLY("retrieve_task_apply","收车任务申请任务key"),
    RETRIEVE_TASK_DISPATCH("retrieve_task_dispatch","主管派单任务key"),
    RETRIEVE_TASK_APPROVE("retrieve_task_approve","风控经理审批任务key"),
    RETRIEVE_TASK_REVIEW("retrieve_task_review","业务副总审核任务key"),
    RETRIEVE_TASK_CHECK("retrieve_task_check","总经理审核任务key"),
    RETRIEVE_TASK_REGISTER("retrieve_task_register","委派与登记任务key"),
    RETRIEVE_TASK_STORAGE("retrieve_task_storage","车辆入库任务key"),
    RETRIEVE_TASK_HANDOVER("retrieve_task_handover","确认交接任务key"),
    RETRIEVE_TASK_FINANCIAL("retrieve_task_financial","财务审核任务key"),
    RETRIEVE_TASK_AUDIT("retrieve_task_audit","总经理审核任务key"),

    //代理人
    APPLY_USER("applyUser","收车任务发起人"),
    DISPATCH_USER("dispatchUser","主管派单人"),
    APPROVE_USER("approveUser","风控经理"),
    REVIEW_USER("reviewUser","业务副总"),
    CHECK_USER("checkUser","总经理"),
    REGISTER_USER("registerUser","委派与登记人"),
    STORAGE_USER("storageUser","车辆入库人"),
    HANDOVER_USER("handoverUser","确认交接人"),
    FINANCIAL_USER("financialUser","财务审核"),
    AUDIT_USER("auditUser","总经理"),

    //流程状态
    APPLY_STATUS("applyStatus","收车任务申请状态"),
    DISPATCH_STATUS("dispatchStatus","主管派单状态"),
    APPROVE_STATUS("approveStatus","风控审批状态"),
    REVIEW_STATUS("reviewStatus","业务副总审核状态"),
    CHECK_STATUS("checkStatus","总经理审核状态"),
    REGISTER_STATUS("registerStatus","委派登记状态"),
    STORAGE_STATUS("storageStatus","车辆入库状态"),
    HANDOVER_STATUS("handoverStatus","确认交接状态"),
    FINANCIAL_STATUS("financialStatus","财务审核状态"),
    AUDIT_STATUS("auditStatus","总经理审核状态"),

    //代理人单位和ID标识
    APPLY_USER_UNIT("applyUserUnit","收车任务发起人单位"),
    APPLY_USER_ID("applyUserId","收车任务发起人id"),
    DISPATCH_USER_UNIT("dispatchUserUnit","收车任务派单人单位"),
    DISPATCH_USER_ID("dispatchUserId","收车任务派单人id"),
    APPROVE_USER_UNIT("approveUserUnit","风控审批人单位"),
    APPROVE_USER_ID("approveUserId","风控审批人id"),
    REVIEW_USER_UNIT("reviewUserUnit","业务副总人单位"),
    REVIEW_USER_ID("reviewUserId","业务副总人id"),
    AUDIT_USER_UNIT("auditUserUnit","总经理单位"),
    AUDIT_USER_ID("auditUserId","总经理id"),
    REGISTER_USER_UNIT("registerUserUnit","委派登记人单位"),
    REGISTER_USER_ID("registerUserId","委派登记人id"),
    STORAGE_USER_UNIT("storageUserUnit","车辆入库人单位"),
    STORAGE_USER_ID("storageUserId","车辆入库人id"),
    HANDOVER_USER_UNIT("handoverUserUnit","确认交接人单位"),
    HANDOVER_USER_ID("handoverUserId","确认交接人id"),
    FINANCIAL_USER_UNIT("financialUserUnit","财务审核人单位"),
    FINANCIAL_USER_ID("financialUserId","财务审核人id");

    private String flag;

    private String desc;

    ActRetrieveCarEnums(String flag,String desc){
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
