package cn.com.leadu.fms.business.common.constant.enums.activiti;

/**
 * @author qiaomengnan
 * @ClassName: ActProcessInstanceKeyEnums
 * @Description: activiti流程引擎key名称
 * @date 2018/4/8
 */
public enum ActProcessInstanceKeyEnums {

    CONTRACT_GENERATION("contract_generation","融资租赁审批流程"),
    FILE_POST("file_post","原件邮寄流程"),
    ORIG_FILE_SORT("orig_file_sort","原件归档流程"),
    INVOICE_CHANGE("invoice_change","开票信息变更流程"),
    BASIC_CHANGE("basic_change","基本信息变更流程"),
    COLLECTION_TASK("collection_task","上门催收流程流程"),
    LAWSUIT_TASK("lawsuit_task","诉讼流程"),
    CONT_PREPAYMENT("cont_prepayment","提前还款审批"),
    RENEWAL_REGISTER("renewal_register","续保流程"),
    INSUR_CLAIM_CHECK("insur_claim_check","保险理赔"),
    BAS_BANK_INFO("bas_bank_info","银行账号维护"),
    BAS_SALES("bas_sales","实际销售方"),
    OVERDUE_EXEMPT("overdue_exempt","罚息免除"),
    RELEASED_MORTGAGE("released_mortgage","资方解抵押流程"),
    GPS_MONTHLY("gps_monthly","gps月结流程"),
    FILE_BORROW_TASK("file_borrow_task","原件借阅流程"),
    FILE_BORROW_BACK_TASK("file_borrow_back_task","借阅归还流程"),
    PILFER_MONTHLY("pilfer_monthly","盗抢险月结流程"),
    EQU_MORTGAGE("equ_mortgage","资方抵押申请流程(先抵押后放款)"),
    EQU_MORTGAGE_PAY("equ_mortgage_pay","资方抵押申请流程(先放款后抵押)"),
    DEFER_TASK("defer_task","合同展期流程"),
    DEPOSIT_CHANGE("deposit_change","保证金变更流程"),
    TRANSFER_TASK("transfer_task", "过户流程"),
    CHANGE_LESSEE_TASK("change_lessee_task","变更承租人"),
    CAPITAL_ASSETS("capital_assets","转固定资产"),
    RETRIEVE_CAR("retrieve_car","收车任务流程"),
    SURRENDER_CHARGE("surrender_charge","退保费结算任务流程");



    private String key;

    private String desc;

    ActProcessInstanceKeyEnums(String key, String desc){
        this.key = key;
        this.desc = desc;
    }

    public String getKey(){
        return this.key;
    }

    public String getDesc(){
        return this.desc;
    }

}
