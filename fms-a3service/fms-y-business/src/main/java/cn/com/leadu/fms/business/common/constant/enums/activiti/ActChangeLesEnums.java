package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * Created by ningyangyang on 2018/9/13.
 *  变更承租人
 */
public enum ActChangeLesEnums {

    //流程任务key
    CHANGE_TASK_APPLY("change_task_apply","变更任务申请"),
    CHANGE_TASK_APPROVE("change_task_approve","风控初审"),
    CHANGE_TASK_REVIEW("change_task_review","风控复审"),
    CHANGE_TASK_CONT_CREATE("change_task_cont_create","合同生成"),
    CHANGE_TASK_CONT_PRINT("change_task_cont_print","合同打印"),
    CHANGE_TASK_CONT_AUDIT("change_task_cont_audit","合同审核"),

    //代理人
    APPLY_USER("applyUser","任务发起人"),
    APPROVE_USER("approveUser","风控初审人"),
    REVIEW_USER("reviewUser","风控复审人"),
    CONT_GENERATOR("contGenerator","合同生成节点人"),
    CONT_PRINTER("contPrinter","合同打印节点人"),
    CONT_AUDITOR("contAuditor","合同审核人"),

    //流程状态
    APPLY_STATUS("applyStatus","任务申请状态"),
    APPROVE_STATUS("approveStatus","风控初审状态"),
    REVIEW_STATUS("reviewStatus","风控复审状态"),
    GENERATE_STATUS("generateStatus","合同生成状态"),
    PRINT_STATUS("printStatus","合同打印状态"),
    CONT_AUDIT_STATUS("contAuditStatus","合同审核状态"),

    //代理人单位和ID标识
    APPLY_USER_UNIT("applyUserUnit","任务发起人单位"),
    APPLY_USER_ID("applyUserId","任务发起人id"),
    APPROVE_USER_UNIT("approveUserUnit","风控初审人单位"),
    APPROVE_USER_ID("approveUserId","风控初审人id"),
    REVIEW_USER_UNIT("reviewUserUnit","风控复审人单位"),
    REVIEW_USER_ID("reviewUserId","风控复审人id"),
    CONT_GENERATOR_UNIT("contGeneratorUnit","合同生成节点人单位"),
    CONT_GENERATOR_ID("contGeneratorId","复合同生成节点人id"),
    CONT_PRINTER_UNIT("contPrinterUnit","合同打印节点人单位"),
    CONT_PRINTER_ID("contPrinterId","合同打印节点人id"),
    CONT_AUDITOR_UNIT("contAuditorUnit","合同审核人单位"),
    CONT_AUDITOR_ID("contAuditorId","合同审核人id");

    private String flag;

    private String desc;

    ActChangeLesEnums(String flag,String desc){
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
