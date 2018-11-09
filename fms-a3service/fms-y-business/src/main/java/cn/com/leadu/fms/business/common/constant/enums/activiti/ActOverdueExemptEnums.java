package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @author yanfengbo
 * @ClassName: ActOverdueExemptEnums
 * @Description: 罚息免除工作流枚举
 * @date
 */
public enum ActOverdueExemptEnums {
    SUBMIT_OVERDUE_EXEMPT_USER("submitOverdueExemptUser","提交人标识"),
    OVERDUE_EXEMPT_APPROVAL_USER("overdueExemptApprovalUser","审批人标识"),
    NEXT_USER("nextUser","保存list集合用户"),

    OVERDUE_EXEMPT_SUBMIT_STATUS("overdueExemptSubmitStatus","提交状态标识"),
    OVERDUE_EXEMPT_APPROVAL_STATUS("overdueExemptApprovalStatus","审批状态标识"),

    OVERDUE_EXEMPT_SUBMIT("overdue_exempt_submit","罚息免除提交任务Key"),
    OVERDUE_EXEMPT_APPROVE("overdue_exempt_approve","罚息免除审批任务Key"),

    OVERDUE_EXEMPT_APPROVAL_USER_UNIT("overdueExemptApprovalUserUnit","罚息免除审批用户单位标识"),
    OVERDUE_EXEMPT_APPROVAL_USER_ID("overdueExemptApprovalUserId","罚息免除审批用户单位标识");




    private String flag;

    private String desc;

    ActOverdueExemptEnums(String flag,String desc){
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
