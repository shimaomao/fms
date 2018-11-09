package cn.com.leadu.fms.common.constant.enums.system;

/**
 * @author qiaomengnan
 * @ClassName: TplTypeKeyEnums
 * @Description: 合同模板key枚举
 * @date 2018/6/13
 */
public enum  TplTypeKeyEnums {
//合同模板key
    EQU_MOR_SEA_WING_APPLY("equMorSeaWingApply","海翼资方抵押申请合同模板"),
    CONT_MAKE_VOUCHER("contMakeVoucher","贷前财务制单"),
    LEASE_BACK_QUOTATION_DEVICE("leaseBackQuotationDevice","回租报价单合同模板"),
    DIRECT_LEASING_QUOTATION_DEVICE("directLeasingQuotationDevice","直租报价单合同模板"),
    ANNUAL_SUPPLY_QUOTATION_DEVICE("annualSupplyQuotationDevice","年供报价单合同模板"),
    DEPOSIT_CHANGE_SUPPLEMENT("depositChangeSupplement","增加保证金补充协议书"),
    DIRECT_RENT_FILE2("directRentFile2","担保保函（个人)"),
    DIRECT_RENT_FILE3("directRentFile3","担保保函(企业）"),
    WL_PREPAYMENT_TQHK("wlPrepaymentTqhk","提前还款测算表"),
    WL_PREPAYMENT_JQZM("wlPrepaymentJqzm","提前还款结清证明"),
    WL_PAYMENT_BILL_CONT_INSUR_CLAIM("wlPaymentBillContInsurClaim","保险理赔付款单"),
    WL_PAYMENT_BILL_BORROW_TASK("wlPaymentBillBorrowTask","借阅归还付款单"),
    WL_PAYMENT_BILL_RENEWAL_REGISTER("wlPaymentBillRenewalRegister","续保付款单"),
    WL_PAYMENT_BILL_GPS_MONTHLY("wlPaymentBillGpsMonthly","gps月结付款单"),
    WL_PAYMENT_BILL_PILFER_MONTHLY("wlPaymentBillPilferMonthly","盗抢险月结付款单"),
    WL_PAYMENT_BILL_EQU_MOR("wlPaymentBillEquMor","资方抵押付款单"),
    WL_PAYMENT_BILL_EQU_REL("wlPaymentBillEquRel","资方解押付款单"),
    WL_PAYMENT_FJ("wlPaymentFj","付款单附件"),
    WL_PAYMENT_BILL_CONT_PREPAYMENT("wlPaymentBillContPrePayment","付款单附件"),
    WL_PAYMENT_BILL_DEFER_TASK("wlPaymentBillDeferTask","合同展期付款单附件"),
    WL_PAYMENT_BILL_TRANSFER("wlPaymentBillTransfer","过户付款单附件"),
    WL_PAYMENT_BILL_RETRIEVE("wlPaymentBillRetrieve","收车付款单附件"),
    COLLECTION_LETTER_PER_CSTM("collectionLetterPerCstm","催告函个人承租人模板"),
    COLLECTION_LETTER_COM_CSTM("collectionLetterComCstm","催告函公司承租人模板"),
    COLLECTION_LETTER_GUA_PER("collectionLetterGuaPer","催告函担保个人模板"),
    COLLECTION_LETTER_GUA_COM("collectionLetterGuaCom","催告函担保企业模板"),
    LAWYER_LETTER_COM("lawyerLetterCom","律师函企业模板"),
    LAWYER_LETTER_PER("lawyerLetterPer","律师函个人模板"),
    COLLECTION_LETTER_TASK_PER_CSTM("collectionLetterTaskPerCstm","催告函个人承租人模板-上门催收"),
    COLLECTION_LETTER_TASK_COM_CSTM("collectionLetterTaskComCstm","催告函公司承租人模板-上门催收"),
    COLLECTION_LETTER_TASK_GUA_PER("collectionLetterTaskGuaPer","催告函担保个人模板-上门催收"),
    COLLECTION_LETTER_TASK_GUA_COM("collectionLetterTaskGuaCom","催告函担保企业模板-上门催收"),
    PROXY_LETTER("proxyLetter","授权委托书"),
    BCXY_WKZQ("bcxyWkzq","尾款展期补充协议"),
    BCXY_HTJY_BGCZR("bcxyHtjyBgczr","合同解约补充协议"),
    TRANS_INFO("transInfo","确认书-车辆转让"),

    //短信模板key
    FILE_SEND("fileSend","保险卡及强制贴寄出通知"),
    ALREADY_RENEWAL("alreadyRenewal","已续保短信通知"),
    ADVANCE_NOTICE("advanceNotice","未融资客户到期日前1个月短信通知续保"),
    RENEWAL_COST_NOTICE("renewalCostNotice","到期前3日未能取得客户合规的续保保单短信通知"),
    RENEWAL_BY_CUSTOMER("renewalByCustomer","保险到期租赁期满由客户自行续保的"),
    DXMB_REPAY("DXMBREPAY","还款提醒短信"),
    DUEDATE_SEND_MESSAGE("DueDateSendMessage","还款日当天发送短信"),
    OVERDUEDATE_SEND_MESSAGE("overdueSendMessage","逾期还款短信提醒"),

    DXMB_OVERDUE("DXMBOVERDUE","还款逾期提醒"),
    INSURANCE_END("INSURANCEEND","保险到期提醒"),
    INSURANCE_INVALID("INSURANCEINVALID","保险失效提醒"),

    //消息通知key
    RENEWAL_REGISTER("RenewalRegister","续保任务登记消息提醒"),
    RISK_PASS_NOTICE_MANAGE("riskPassNoticeManage","风控审核通过没经过总经理时通知总经理"),
//    WL_CONTRACT_ZZ_HKJHB("wlContractHkjhb","还款计划表"),
    NOTICE_GPS("noticeGps","车款放款完成后给GPS派单用户发送消息提醒"),
    NOTICE_PILFER("noticePilfer","车款放款完成后给盗抢险录入用户发送消息提醒"),
    NOTICE_ORIG_FILE("noticeOrigFile","车款放款完成后给归档用户（业务员、资管）发送消息提醒"),
    NOTICE_EQU_MOR("noticeEquMor","提前还款结束后，如果客户在抵押状态，通知资管解押"),

    //excel模板
    MONTHLY_OVERDUE("monthlyOverdue","逾期率统计报表模版"),
    //业务统计报表key
    BUSINESSS_TATISTICS("businessStatisticsExport","融资租赁业务统计报表模板"),
    REPORTSTATISTICS("reportstatisticsExport","当月提报数据统计报表"),
    //审批数据统计报表key
    Approval_STATISTICS("approvalstatisticsExport","融资租赁审批数据统计报表模板");

    private String type;

    private String desc;

    TplTypeKeyEnums(String type, String desc){
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
