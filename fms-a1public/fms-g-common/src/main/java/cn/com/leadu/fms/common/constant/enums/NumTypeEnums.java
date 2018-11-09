package cn.com.leadu.fms.common.constant.enums;

/**
 * @author wangxue
 * @ClassName: FinItemTypeEnums
 * @Description:
 * @date 2018/3/24
 */
public enum NumTypeEnums {

    APPLY_NUM_TYPE("1","申请编号"),
    CONTRACT_NUM_TYPE("2","合同编号"),//根据日期
    ORIG_FILE_SORT_NUM_TYPE("3","原件归档任务编号"),
    BORROW_TASK_NUM_TYPE("4","原件借阅任务编号"),
    INSURANCE_RENEWAL("5","保险续保任务编号"),
    CONT_INSUR_CLAIM_NUM_TYPE("6","保险理赔任务号"),
    CONT_PREPAYMENT_NO("7","提前还款任务号"),
    BORROW_BACK_TASK_NUM_TYPE("8","借阅归还任务编号"),

    OVERDUE_EXEMPT_NUM_TYPE("10","罚息免除任务表"),
    BAS_BANK_INFO_NUM_TYPE("11","银行账号维护任务编号"),
    BAS_SALES_NUM_TYPE("12","实际销售方任务编号"),

    ORIG_FILE_NUM("16","原件归档编号"),//根据日期

    FIN_VOU_DATA_NUM_TYPE("17","财务凭证明细任务号"),
    FINASS_CSTMPER_CODE("18","个人财务核算代码"),
    FINASS_CSTMCO_CODE("19","企业财务核算代码"),
    EQU_MOR_TASK_NUM_TYPE("21","资产抵押任务编号"),
    RELIEF_NUM_TYPE("22","资产解押任务号"),
    MONTHLY_SETTLEMENT_NUM_TYPE("23","gps月结业务编号"),
    MONTHLY_PILFER_INSURANCE_NUM_TYPE("24","盗抢险月结业务编号"),
    FIN_VOU_SEND("25","财务凭证发送批次号"),
    INVOICE_CHANGE("31","开票信息变更任务号"),
    BASIC_CHANGE("32","基本信息变更任务号"),
    DEFER_CONTRACT_NUM_TYPE("33","合同展期任务编号"),
    DEPOSIT_CHANGE_TYPE("34","增加保证金任务编号"),
    TRANSFER_NUM_TYPE("35","过户任务号"),
    FIND_ANNULINSPECTION_NUM_TYPE("36","年检任务号"),
    COLLECTION_TASK_NUM_TYPE("37","上门催收任务号"),
    CHANGE_LESSEE_TASK_NUM_TYPE("38","变更承租人"),
    CAPITAL_ASSETS_NUM_TYPE("39","转固定资产任务号"),
    LAWSUIT("40","诉讼任务号"),
    RETRIEVE_CAR_TASK_NUM_TYPE("41","收车任务号"),
    SURRENDER_CHARGE("42","退保费结算任务号"),
    RECEIPT_NO("43","财务凭证收款编号");

    private String type;
    private String prefix;
    private String suffix;
    private String desc;

    NumTypeEnums(String type, String desc){
        this.type = type;
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
