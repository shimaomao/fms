package cn.com.leadu.fms.common.constant.enums.finance;/**
 * Created by ningyangyang on 2018/6/1.
 */

/**
 * @Title: fms
 * @Description: 款项名称枚举
 * @author: ningyangyang
 * @date 2018/6/1 11:10
 */
public enum PayFundNameEnums {

    //借阅申请时
    BORROW_DEP("borrowDep", "借阅押金"),
    BORROW_TASK_COST("borrowDep", "借阅押金"),
    RELIEF_RECEIPT("equRelCost","资方解押费用"),
    EQU_MOR_CHARGE_IMPORT("equCost","资方抵押费用"),
    INSURANCE_COST("renewalIns","续保保费"),
    EQU_MOR_CHARGE_RECEIPT("equReciept","资方抵押收款"),
    INSURANCE_CLAIM("inuClaim","保险理赔额"),

    GPS_COST("gpsMon","gps费用"),
    PILFER_INSURANCE_COST("pilferMon","盗抢险费用"),
    PREPAYMENT("prepayAmount","提前还款"),

    FIRST_RENT("firstRent","首期租金"),
    INIT_AMOUNT("initRec","首付款"),
    DEPOSIT("depositRec","保证金"),
    RENEWAL_DEPOSIT("renDepRec","续保押金"),
    CHARGE("chargeRec","手续费用"),
    VEH_DEPOSIT("vehDepRec","定金金额"),
    RETREATS_AMOUNT("retreatsRec","退保金额"),
    TOTAL("total","合计"),
    SUPPLE_DEPOSIT("suppleDeposit","补充保证金"),
    BACK_DEPOSIT("backDeposit","退还保证金"),
    RETR_AMOUNT("retrAmount","收车实际佣金"),
    Insurance_AMOUNT("insuranceAmount","保险理赔金");
    private String type;

    private String desc;

    PayFundNameEnums(String type, String desc){
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
