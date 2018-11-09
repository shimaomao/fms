package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @author lijunjun
 * @ClassName: ActFileBorrowTaskEnums
 * @Description: activiti流程引擎key名称
 * @date 2018/4/8
 */
public enum ActFileBorrowTaskEnums {

    APPLY_USER("applyUser","申请人标识"),
    FINANCE_CONFIRM_USER("financeConfirmUser","财务确认人标识"),
    BORROW_TASK_EXAMINE_USER("borrowTaskExamineUser","借阅审核人标识"),
    MAIL_USER("mailUser","财务邮寄人标识"),
    BORROW_TASK_REEXAMINE_USER("borrowTaskReExamineUser","复核人标识"),

    BORROW_TASK_APPLY("borrow_task_apply","借阅申请任务key"),
    FINANCE_CONFIRM("finance_confirm","财务确认任务key"),
    BORROW_TASK_EXAMINE("borrow_task_examine","初审任务key"),
    BORROW_TASK_MAIL("borrow_task_mail","邮寄资料任务key"),
    BORROW_TASK_REEXAMINE("borrow_task_reExamine","复核任务key"),

    FILE_TYPE_CODE("fileTypeCode","申请提交状态标识"),
    FINANCE_CONFIRM_STATUS("financeConfirmStatus","财务确认状态标识"),
    EXAMINE_STATUS("examineStatus","初审状态标识"),
    MAIL_STATUS("mailStatus","邮寄状态标识"),
    RE_EXAMINE_STATUS("reExamineStatus","资管复核状态标识"),

    FINANCE_CONFIRM_USER_UNIT("financeConfirmUserUnit","财务确认用户单位标识"),
    FINANCE_CONFIRM_USER_ID("financeConfirmUserId","财务确认用户单位id标识"),
    BORROW_TASK_EXAMINE_USER_UNIT("borrowTaskExamineUserUnit","初审用户单位标识"),
    BORROW_TASK_EXAMINE_USER_ID("borrowTaskExamineUserId","初审用户单位id标识"),
    BORROW_TASK_MAIL_USER_UNIT("borrowTaskMailUserUnit","邮寄资料用户单位标识"),
    BORROW_TASK_MAIL_USER_ID("borrowTaskMailUserId","邮寄资料用户单位id标识"),
    BORROW_TASK_REEXAMINE_USER_UNIT("borrowTaskReExamineUserUnit","复审用户单位标识"),
    BORROW_TASK_REEXAMINE_USER_ID("borrowTaskReExamineUserId","复审用户单位id标识"),

    PARAM_VARIABLES("paramVariables", "业务传递用参数");

    private String flag;

    private String desc;

    ActFileBorrowTaskEnums(String flag,String desc){
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
