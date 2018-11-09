package cn.com.leadu.fms.common.constant.enums.finance;/**
 * Created by ningyangyang on 2018/6/1.
 */

/**
 * @Title: fms
 * @Description: 业务类型
 * @author: ningyangyang
 * @date 2018/6/1 10:44
 */
public enum BizTypeEnums {

    BEFORE_CREDIT("01","贷前"),
    CONT_NO("02","合同编号"),
    ORIG_FILE_SORT("03","原件归档"),
    BORROWED_DEPOSIT("04","原件借阅"),
    RENEWAL("05","续保任务"),
    CONT_INSUR_CLAIM("06","保险理赔"),
    PREPAYMENT("07","提前还款"),
    ORIG_BORROWED_BACK("08","借阅归还"),
    EQU_MORTGAGE("09","资方抵押"),


    OVERDUE_EXEMPT("10","罚息免除"),
    BAS_BANK_INFO("11","银行账号维护"),
    BAS_SALES("12","实际销售方"),
    RENEWAL_SORT("13","续保归档"),

    RELIEF("22","资方解押"),
    GPS_MONTHLY("23","gps月结"),
    THEFT_MONTHLY("24","盗抢险月结"),
    INVOICE_CHANGE("31","开票信息变更"),
    BASIC_CHANGE("32","基本信息变更"),
    DEFER_CONTRACT("33","合同展期"),
    DEPOSIT_CHANGE("34","增加保证金"),
    TRANSFER("35","过户任务"),
    COLLECTION_TASK("37","上门催收任务"),
    CHANGE_LESSEE("38","承租人变更"),
    CAPITAL_ASSETS("39","转固定资产任务"),
    LAWSUIT("40","诉讼"),
    RETRIEVE_CAR("41","收车"),
    SURRENDER_CHARGE("42","过户退保任务");

    private String type;

    private String desc;

    BizTypeEnums(String type, String desc){
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
