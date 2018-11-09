package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @author yanfengbo
 * @ClassName: ActBasSalesEnums
 * @Description: 实际销售方工作流枚举
 * @date
 */
public enum ActBasSalesEnums {
    OPERATION_BAS_SALES_USER("operationBasSalesUser","维护人标识"),
    BAS_SALES_APPROVAL_USER("basSalesApprovalUser","审批人标识"),

    BAS_SALES_OPERATION_STATUS("basSalesOperationStatus","维护标识"),
    BAS_SALES_APPROVAL_STATUS("basSalesApprovalStatus","审批状态标识"),

    BAS_SALES_OPERATION("bas_sales_operation","实际销售方任务Key"),
    BAS_SALES_APPROVE("bas_sales_approve","实际销售方财务审批任务Key"),

    BAS_SALES_APPROVAL_USER_UNIT("basSalesApprovalUserUnit","实际销售方审批用户单位标识"),
    BAS_SALES_APPROVAL_USER_ID("basSalesApprovalUserId","实际销售方审批用户单位标识");




    private String flag;

    private String desc;

    ActBasSalesEnums(String flag,String desc){
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
