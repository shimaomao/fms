package cn.com.leadu.fms.business.common.constant.enums.activiti;
/**
 * @author yanfengbo
 * @ClassName: ActBasBankInfoEnums
 * @Description: 银行账号维护工作流枚举
 * @date
 */
public enum ActBasBankInfoEnums {

    OPERATION_BAS_BANK_INFO_USER("operationBasBankInfoUser","维护人标识"),
    BAS_BANK_INFO_APPROVAL_USER("basBankInfoApprovalUser","审批人标识"),

    BAS_BANK_INFO_OPERATION_STATUS("basBankInfoOperationStatus","维护标识"),
    BAS_BANK_INFO_APPROVAL_STATUS("basBankInfoApprovalStatus","审批状态标识"),

    BAS_BANK_INFO_OPERATION("bas_bank_info_operation","银行账号维护任务Key"),
    BAS_BANK_INFO_APPROVE("bas_bank_info_approve","银行账号财务审批任务Key"),

    BAS_BANK_INFO_APPROVAL_USER_UNIT("basBankInfoApprovalUserUnit","银行账号审批用户单位标识"),
    BAS_BANK_INFO_APPROVAL_USER_ID("basBankInfoApprovalUserId","银行账号审批用户单位标识");




    private String flag;

    private String desc;

    ActBasBankInfoEnums(String flag,String desc){
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
