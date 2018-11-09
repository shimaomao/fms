package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * Created by ningyangyang on 2018/9/5.
 * 展期任务工具
 */
public enum ActDeferTaskEnums {

    //流程任务key
    DEFER_TASK_APPLY("defer_task_apply","展期任务申请任务key"),
    DEFER_TASK_APPROVE("defer_task_approve","展期任务风控初审任务key"),
    DEFER_TASK_REVIEW("defer_task_review","展期任务风控复审任务key"),
    DEFER_TASK_AUDIT("defer_task_audit","展期任务业务副总审核任务key"),
    DEFER_TASK_CONT_GENERATE("defer_task_cont_generate","展期任务合同生成任务key"),
    DEFER_TASK_CONT_PRINT("defer_task_cont_print","展期任务合同打印任务key"),
    DEFER_TASK_CONT_AUDIT("defer_task_cont_audit","展期任务合同审核任务key"),
    DEFER_TASK_FINANCE_APPROVE("defer_task_finance_approve","展期任务财务审核任务key"),
    DEFER_TASK_MANAGER_APPROVE("defer_task_manager_approve","展期任务总经理审核任务key"),

    //代理人
    APPLY_USER("applyUser","展期任务发起人"),
    APPROVE_USER("approveUser","风控初审人"),
    REVIEW_USER("reviewUser","风控复审人"),
    AUDIT_USER("auditUser","业务副总"),
    CONT_GENERATOR("contGenerator","合同生成节点人"),
    CONT_PRINTER("contPrinter","合同打印节点人"),
    CONT_AUDITOR("contAuditor","合同审核人"),
    FINANCE_USER("financeUser","财务审核人"),
    MANAGER_USER("managerUser","总经理"),

    //流程状态
    APPLY_STATUS("applyStatus","展期任务申请状态"),
    APPROVE_STATUS("approveStatus","风控初审状态"),
    REVIEW_STATUS("reviewStatus","风控复审状态"),
    AUDIT_STATUS("auditStatus","业务副总审核状态"),
    GENERATE_STATUS("generateStatus","展期合同生成状态"),
    PRINT_STATUS("printStatus","展期合同打印状态"),
    CONT_AUDIT_STATUS("contAuditStatus","展期合同审核状态"),
    FINANCE_STATUS("financeStatus","展期财务审核状态"),
    MANAGER_STATUS("managerStatus","展期总经理审核状态"),

    //代理人单位和ID标识
    APPLY_USER_UNIT("applyUserUnit","展期任务发起人单位"),
    APPLY_USER_ID("applyUserId","展期任务发起人id"),
    APPROVE_USER_UNIT("approveUserUnit","风控初审人单位"),
    APPROVE_USER_ID("approveUserId","风控初审人id"),
    REVIEW_USER_UNIT("reviewUserUnit","风控复审人单位"),
    REVIEW_USER_ID("reviewUserId","风控复审人id"),
    AUDIT_USER_UNIT("auditUserUnit","业务副总单位"),
    AUDIT_USER_ID("auditUserId","业务副总id"),
    CONT_GENERATOR_UNIT("contGeneratorUnit","合同生成节点人单位"),
    CONT_GENERATOR_ID("contGeneratorId","复合同生成节点人id"),
    CONT_PRINTER_UNIT("contPrinterUnit","合同打印节点人单位"),
    CONT_PRINTER_ID("contPrinterId","合同打印节点人id"),
    CONT_AUDITOR_UNIT("contAuditorUnit","合同审核人单位"),
    CONT_AUDITOR_ID("contAuditorId","合同审核人id"),
    FINANCE_APPROVE_UNIT("financeApproveUnit","财务审核节点人单位"),
    FINANCE_APPROVE_ID("financeApproveId","财务审核节点人id"),
    MANAGER_APPROVE_UNIT("managerApproveUnit","总经理审核节点人单位"),
    MANAGER_APPROVE_ID("managerApproveId","总经理审核节点人id");

    private String flag;

    private String desc;

    ActDeferTaskEnums(String flag,String desc){
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
