package cn.com.leadu.fms.common.constant;

/**
 * @author qiaomengnan
 * @ClassName: CommonParamConstants
 * @Description:  系统常量通用paramKey
 * @date 2018/4/25 0025
 */
public class CommonParamConstants {

    /**
     * @Fields  : map中暂存key值
     * @author qiaomengnan
     */
    public static final String COMMON_PARAM_VALUES = "commonParamValues";

    /**
     * @Fields  : map中暂存key值
     * @author qiaomengnan
     */
    public static final String COMMON_PARAM_VALUE_VERSION = "commonParamValueVersion";

    /**
     * @Fields  : excel导出最大数量常量key
     * @author qiaomengnan
     */
    public static final String EXCEL_DATA_MAX = "excelDataMax";

    /**
     * @Fields  : 提前还款手续费
     * @author yangyiquan
     */
    public static final String REPAY_SERVICE_CHARGE = "repay_service_charge";

    /**
     * @Fields  : 过户保证金
     * @author yangyiquan
     */
    public static final String TRANSFER_DEPOSIT = "transfer_deposit";

    /**
     * @Fields  : 正租税率
     * @author lijunjun
     */
    public static final String RENT_TAX = "rentTax";

    /**
     * @Fields  : 回租税率
     * @author lijunjun
     */
    public static final String LEASE_BACK_TAX  = "leasebackTax";

    /**
     * @Fields  : 还款方式
     * @author lijunjun
     */
    public static final String REPAY_MODE  = "repayMode";

    /**
     * @Fields  : 还款频率
     * @author lijunjun
     */
    public static final String REPAY_RATE  = "repayRate";

    /**
     * @Fields  : 购置税税率
     * @author lijunjun
     */
    public static final String PURCHASE_TAX_RATE  = "purchaseTaxRate";

    /**
     * @Fields  : 保险费率
     * @author lijunjun
     */
    public static final String COMMERCIAL_INSURANCE_RATE  = "commercialInsuranceRate";

    /**
     * @Fields  : 增值税税率
     * @author lijunjun
     */
    public static final String VAT_TAX_RATE  = "vatTaxRate";

    /**
     * @Fields  : 企业所得税税率
     * @author lijunjun
     */
    public static final String INCOME_TAX_RATE  = "incomeTaxRate";

    /**
     * @Fields  : 手续费(增值税税率)
     * @author lijunjun
     */
    public static final String SERVICE_CHARGE_RATE  = "serviceChargeRate";

    /**
     * @Fields  : 购销合同印花税税率
     * @author lijunjun
     */
    public static final String SALE_CONTRACT_STAMP_TAX_RATE  = "saleContractStampTaxRate";

    /**
     * @Fields  : 租赁合同印花税率
     * @author lijunjun
     */
    public static final String LEASEHOLD_CONTRACT_STAMP_TAX_RATE  = "leaseholdContractStampTaxRate";

    /**
     * @Fields  : 借款合同印花税率
     * @author lijunjun
     */
    public static final String LOAN_CONTRACT_STAMP_TAX_RATE  = "loanContractStampTaxRate";

    /**
     * @Fields  : 业务佣金系数
     * @author lijunjun
     */
    public static final String BUSINESS_COMMISSION_RATE  = "businessCommissionRate";

    /**
     * @Fields  : 逾期天数临界点
     * @author yanfengbo
     */
    public static final String OVERDUE_DAYS_CRITICAL  = "overdueDaysCritical";


    /**
     * @Fields  : 车辆年检间隔几年
     * @author yanfengbo
     */
    public static final String ANNUALINSPECTION_YEAR  = "annualinspectionYear";

    /**
     * @Fields  : 车辆年检提交多少天加入年检表
     * @author yanfengbo
     */
    public static final String ANNUALINSPECTION_INSERT_DAYS  = "annualinspectionInsertDays";

    /**
     * @Fields  : 逾期发送短信 最大天数
     * @author yanfengbo
     */
    public static final String CONT_REPAY_MAXDAYS  = "contRepayMaxDays";


    /**
     * @Fields  : 逾期发送短信 最小天数
     * @author yanfengbo
     */
    public static final String CONT_REPAY_MINDAYS  = "contRepayMinDays";



    /**
     * @Fields  : 归档天数
     * @author yangyiquan
     */
    public static final String ARCHIVAL_DAYS  = "archivalDays";

    /**
     * @Fields  : 单车融资额
     * @author yangyiquan
     */
    public static final String SINGLE_FIN_AMOUNT  = "singleFinAmount";

    /**
     * @Fields  : 累积融资额
     * @author yangyiquan
     */
    public static final String CUMULATIVE_FIN_AMOUNT  = "cumulativeFinAmount";

    /**
     * @Fields  : 短信还款提醒天数
     * @author ningyangyang
     */
    public static final String MESSAGE_REMINDING_DAYS  = "message_reminding_days";

    /**
     * @Fields  : 逾期提醒频率
     * @author ningyangyang
     */
    public static final String OVERDUE_REMINDING_FREQUENCY  = "overdue_reminding_frequency";

    /**
     * @Fields  : 保险到期提醒天数
     * @author ningyangyang
     */
    public static final String INSURANCE_REMINDING_DAYS  = "insurance_reminding_days";

    /**
     * @Fields  : 保险失效提醒频率
     * @author ningyangyang
     */
    public static final String INSURANCE_REMINDING_FREQUENCY  = "insurance_reminding_frequency";


    /**
     * @Fields  : 保险归档天数
     * @author ningyangyang
     */
    public static final String INSURANCE_ARCHIVAL_DAYS  = "insurance_archival_days";

    /**
     * @Fields  : 风险敞口低值
     * @author ningyangyang
     */
    public static final String MIN_RISK_AMOUNT  = "minRiskAmount";

    /**
     * @Fields  : 风险敞口高值
     * @author ningyangyang
     */
    public static final String MAX_RISK_AMOUNT  = "maxRiskAmount";

    /**
     * @Fields  : 未融资客户到期日前XX天短信通知续保
     * @author ningyangyang
     */
    public static final String NOTICE_RENEWAL_DAYS  = "noticeRenewalDays";

    /**
     * @Fields  : 到期前XX日未能取得客户合规的续保保单
     * @author ningyangyang
     */
    public static final String NOTICE_VOUCHER_DAYS  = "noticeVoucherDays";

    /**
     * @Fields  : 抵押到期期限天数
     * @author ningyangyang
     */
    public static final String MORTGAGE_DUE_DAYS  = "mortgageDueDays";

    /**
     * @Fields  : 提前还款小于24期违约金率
     * @author yangyiquan
     */
    public static final String LIQUIDATED_DAMAGES_RATE_1  = "liquidatedDamagesRate1";

    /**
     * @Fields  : 提前还款大于于24期违约金率
     * @author yangyiquan
     */
    public static final String LIQUIDATED_DAMAGES_RATE_2 = "liquidatedDamagesRate2";

    /**
     * @Fields  : 提前还款违约金最小值
     * @author yangyiquan
     */
    public static final String LIQUIDATED_DAMAGES_FLOOR_AMOOUNT = "liquidatedDamagesFloorAmoount";

    /**
     * @Fields  : 进入家访池的逾期天数
     * @author wangxue
     */
    public static final String COLLECTION_OVERDUE_DAY = "collectionOverdueDay";

    /**
     * @Fields  : 进入收车池的逾期天数
     * @author wangxue
     */
    public static final String RETRIEVE_OVERDUE_DAY = "retrieveOverdueDay";

    /**
     * @Fields  : 进入诉讼池的逾期天数
     * @author wangxue
     */
    public static final String LAWSUIT_OVERDUE_DAY = "lawsuitOverdueDay";

    /**
     * @Fields  : 普票最大发票金额值
     * @author qiaomengnan
     */
    public static final String MAX_INVOICE_AMOUNT = "maxInvoiceAmount";

    /**
     * @Fields  : 专票最大发票金额值
     * @author qiaomengnan
     */
    public static final String TICKET_MAX_INVOICE_AMOUNT = "ticketMaxInvoiceAmount";

    /**
     * @Fields  : 金税商品或劳务名称
     * @author qiaomengnan
     */
    public static final String GT_LIST_GOODS_NAME = "gtListGoodsName";

    /**
     * @Fields  : 金税编码版本号
     * @author qiaomengnan
     */
    public static final String GT_GOODS_NOVER = "gtGoodsNover";

    /**
     * @Fields  : 金税税收分类编码
     * @author qiaomengnan
     */
    public static final String GT_GOODS_TAXNO = "gtGoodsTaxno";

    /**
     * @Fields  : 金税开票人
     * @author qiaomengnan
     */
    public static final String GT_INFO_INVOICER = "gtInfoInvoicer";

    /**
     * @Fields  : 复核人
     * @author qiaomengnan
     */
    public static final String GT_INFO_CHECKER = "gtInfoChecker";

    /**
     * @Fields  : 收款人
     * @author qiaomengnan
     */
    public static final String GT_INFO_CASHIER = "gtInfoCashier";

    /**
     * @Fields  : 金税计量单位
     * @author qiaomengnan
     */
    public static final String GT_LIST_UNIT = "gtListUnit";

    /**
     * @Fields  : 金税数量
     * @author qiaomengnan
     */
    public static final String GT_LIST_NUMBER = "gtListNumber";
    /**
     * @Fields  : 用户分公司代码
     * @author fangshaofeng
     */
    public static final String USER_REGION_CONSTANT = "userRegionConstant";

    /**
     * @Fields  : 开票税率6
     * @author yangyiquan
     */
    public static final String INVOICE_TAX_6 = "invoiceTax6";

    /**
     * @Fields  : 开票税率16
     * @author yangyiquan
     */
    public static final String INVOICE_TAX_16 = "invoiceTax16";

    /**
     * @Fields  : 发票明细最大数量
     * @author ningyangyang
     */
    public static final String MAX_DETAIL_NUMBER = "maxDetailNumber";

}
