package cn.com.leadu.fms.pojo.finance.vo.contrepaysked;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.vo.contreceipt.ContReceiptVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: ContRepaySkedVo
 * @Description: 合同还款计划表载体
 * @date 2018-05-08
 */
@ExcelTitle(typeValues = {"待勾稽租金信息", "已认领信息", "勾稽明细信息","合同还款计划明细","财务还款计划查询一览","结清车辆租金明细","在租车辆租金明细","未收租金明细","本期实收租金明细"}, types = {ExcelTypeConstants.ONE, ExcelTypeConstants.TWO, ExcelTypeConstants.THREE,ExcelTypeConstants.FOUR,ExcelTypeConstants.FIVE,ExcelTypeConstants.SEX,ExcelTypeConstants.SEVEN,ExcelTypeConstants.EIGHT,ExcelTypeConstants.NINE})
@Data
public class ContRepaySkedVo extends PageQuery<ContRepaySked> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 还款计划表ID
	 * @author lijunjun
	 */
	private String repaySkedId;

	/**
	 * @Fields  : 财务勾稽ID
	 * @author lijunjun
	 */
	private String contReceiptExamId;

	/**
	 * @Fields  : 合同编号
	 * @author lijunjun
	 */
	private String contNo;

	/**
	 * @Fields  : 申请编号
	 * @author lijunjun
	 */
	private String applyNo;

	/**
	 * @Fields  : 期数
	 * @author lijunjun
	 */
	private Integer period;

	/**
	 * @Fields  : 还款类别
	 * @author yangyiquan
	 */
	private String repayType;

    /**
     * @Fields  : 抵扣金额
     * @author yangyiquan
     */
    private BigDecimal  deductionAmount;

	/**
	 * @Fields  : 成交日期
	 * @author lijunjun
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date dealDate;

	/**
	 * @Fields  : 收款日期
	 * @author lijunjun
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date repayDate;

	/**
	 * @Fields  : 判断时间
	 * @author ningyangyang
	 */
	private String jugDate;

	/**
	 * @Fields  : 申请类型
	 * @author ningyangyang
	 */
	private String applyType;

	/**
	 * @Fields  : 客户姓名
	 * @author ningyangyang
	 */
	private String name;

	/**
	 * @Fields  : 客户手机号
	 * @author ningyangyang
	 */
	private String mobileNo;

	/**
	 * @Fields  : 收款日期检索项(开始)
	 * @author lijunjun
	 */
	private String repayDateSearchStart;

	/**
	 * @Fields  : 收款日期检索项(结束)
	 * @author lijunjun
	 */
	private String repayDateSearchEnd;

	/**
	 * @Fields  : 月利率
	 * @author lijunjun
	 */
	private BigDecimal intrstMonthRate;

	/**
	 * @Fields  : 每期客户租金
	 * @author lijunjun
	 */
	private BigDecimal rent;

	/**
	 * @Fields  : 勾稽金额
	 * @author lijunjun
	 */
	private BigDecimal receiptExamAmount;

	/**
	 * @Fields  : 勾稽状态
	 * @author lijunjun
	 */
	private String receiptExamStatus;

	/**
	 * @Fields  : 当期本金
	 * @author lijunjun
	 */
	private BigDecimal principal;

	/**
	 * @Fields  : 当期利息
	 * @author lijunjun
	 */
	private BigDecimal interest;

	/**
	 * @Fields  : 手续费用
	 * @author lijunjun
	 */
	private BigDecimal charge;

	/**
	 * @Fields  : 当期剩余本金
	 * @author lijunjun
	 */
	private BigDecimal restPrincipal;

	/**
	 * @Fields  : 扣款状态
	 * @author lijunjun
	 */
	private String repayStatus;

	/**
	 * @Fields  : 逾期状态
	 * @author lijunjun
	 */
	private String overdueStatus;

	/**
	 * @Fields  : 暂不扣款标志
	 * @author lijunjun
	 */
	private String repayFlag;

	/**
	 * @Fields  : 收款银行
	 * @author lijunjun
	 */
	private String recAccBank;

	/**
	 * @Fields  : 收款银行
	 * @author lijunjun
	 */
	private String recAccBranch;
	/**
	 * @Fields  : 收款账号
	 * @author lijunjun
	 */
	private String recAccountNo;

	/**
	 * @Fields  : 收款户名
	 * @author lijunjun
	 */
	private String recAccountName;

	/**
	 * @Fields  : 数据来源
	 * @author lijunjun
	 */
	private String inputMode;

	/**
	 * @Fields  : 保证金
	 * @author lijunjun
	 */
	private BigDecimal deposit;

	/**
	 * @Fields  : 每期客户实际租金
	 * @author lijunjun
	 */
	private BigDecimal rentActual;

	/**
	 * @Fields  : 开始时间
	 * @author ningyangyang
	 */
	private String startTime;

	/**
	 * @Fields  : 结束时间
	 * @author ningyangyang
	 */
	private String endTime;

	/**
	 * @Fields  : 开始时间(到账日期)
	 * @author yanfengbo
	 */
	private String startTime2;

	/**
	 * @Fields  : 结束时间(到账日期)
	 * @author yanfengbo
	 */
	private String endTime2;

	/**
	 * @Fields  : 开始时间(实际还款日)
	 * @author yanfengbo
	 */
	private String startTimeReceiptDate;

	/**
	 * @Fields  : 结束时间(实际还款日)
	 * @author yanfengbo
	 */
	private String endTimeReceiptDate;

	/**
	 * @Fields  : 到账日期(页面显示为实际还款日,取自销售还款计划表)
	 * @author lijunjun
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date receiptDate;

	/**
	 * @Fields  : 到账日期(页面显示为到账日期,取自收款表)
	 * @author lijunjun
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date accountReceiptDate;

	/**
	 * @Fields  : 还款计划表ID
	 * @author lijunjun
	 */
	private List<String> repaySkedIds;

	/**
	 * @Fields  : 逾期罚息额
	 * @author lijunjun
	 */
	private BigDecimal overdueAmount;

	/**
	 * @Fields  : 罚息免除金额
	 * @author yanfengbo
	 */
	private BigDecimal exemptAmount;

	/**
	 * @Fields  : 罚息已收金额
	 * @author yanfengbo
	 */
	private BigDecimal overdueReceiptAmount;

	/**
	 * @Fields  : 已认领金额
	 * @author lijunjun
	 */
	private BigDecimal claimedAmount;

	/**
	 * @Fields  : 已收金额
	 * @author ningyangyang
	 */
	private BigDecimal  alreadyReceiptAmount;

	/**
	 * @Fields  : 开票id(用于检索区分)
	 * @author yanfengbo
	 */
	private String invoiceId;

	/**
	 * @Fields  : 开票日期
	 * @author yangyiquan
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date invoiceDate;

	/**
	 * @Fields  : 开票金额
	 * @author ningyangyang
	 */
	private BigDecimal  invoiceAmount;

	/**
	 * @Fields  : 开票备注
	 * @author ningyangyang
	 */
	private String invoiceMemo;

	/**
	 * @Fields  : 开票状态
	 * @author ningyangyang
	 */
	private BigDecimal  invoiceStatus;

	/**
	 * @Fields  : 勾稽备注
	 * @author yangyiquan
	 */
	private String memoChecked;

	/**
	 * @Fields  : 收款业务类型
	 * @author lijunjun
	 */
	private String receiptBizType;

	/**
	 * @Fields  : 收款明细List
	 * @author lijunjun
	 */
	List<ContReceiptVo> contReceiptVoList;

	/**
	 * @Fields  : 待勾稽明细
	 * @author lijunjun
	 */
	List<ContRepaySkedVo> contRepaySkedVoList;

	/**
	 * @Fields  : 收款id
	 * @author lijunjun
	 */
	private String contReceiptId;

	/**
	 * @Fields  : 付款银行
	 * @author lijunjun
	 */
	private String payAccBank;

	/**
	 * @Fields  : 付款账号
	 * @author lijunjun
	 */
	private String payAccBranch;
	/**
	 * @Fields  : 付款账号
	 * @author lijunjun
	 */
	private String payAccountNo;

	/**
	 * @Fields  : 付款户名
	 * @author lijunjun
	 */
	private String payAccountName;

	/**
	 * @Fields  : 付款金额
	 * @author lijunjun
	 */
	private BigDecimal receiptAmount;

	/**
	 * @Fields  : 付款备注
	 * @author lijunjun
	 */
	private String memo;


	/**
	 * @Fields  : 剩余金额
	 * @author lijunjun
	 */
	private BigDecimal restAmount;

	/**
	 * @Fields  : 财务租金
	 * @author lijunjun
	 */
	private BigDecimal finRent;

	/**
	 * @Fields  : 财务本金
	 * @author lijunjun
	 */
	private BigDecimal finRprincipal;

	/**
	 * @Fields  : 财务利息
	 * @author lijunjun
	 */
	private BigDecimal finRinterest;

	/**
	 * @Fields  : 财务剩余本金
	 * @author lijunjun
	 */
	private BigDecimal finRestPrincipal;

	/**
	 * @Fields  : 财务主营收入
	 * @author lijunjun
	 */
	private BigDecimal finRevenue;

	/**
	 * @Fields  : 区域
	 * @author ningyangyang
	 */
	private String groupDistrict;

	/**
	 * @Fields  : 申请类别
	 * @author ningyangyang
	 */
	private String companyType2;

	/**
	 * @Fields  : 财务税金
	 * @author lijunjun
	 */
	private BigDecimal finRtax;

	/**
	 * @Fields  : 企业类型
	 * @author ningyangyang
	 */
	private String companyType;

	/**
	 * @Fields  : 车架号
	 * @author ningyangyang
	 */
	private String vinNo;

	/**
	 * @Fields  : 业务类型
	 * @author ningyangyang
	 */
	private String licenseAttr;

	/**
	 * @Fields  : 发票日期
	 * @author ningyangyang
	 */
	private String invoDate;

	/**
	 * @Fields  : 还款日期
	 * @author ningyangyang
	 */
	private String receDate;

	/**
	 * @Fields  : 到账日期检索项
	 * @author ningyangyang
	 */
	private String receiptDateSearch;

	/**
	 * @Fields  : 所属公司
	 * @author ningyangyang
	 */
	private String groupCode;

	/**
	 * @Fields  : 所属公司
	 * @author ningyangyang
	 */
	private String groupName;

	/**
	 * @Fields  : 应收罚息额(罚息金额-罚息免除金额)
	 * @author yanfengbo
	 */
	private BigDecimal receivableOverdueAmount;

	/**
	 * @Fields  : 实收租金(取自销售还款计划表“已收金额”)
	 * @author yanfengbo
	 */
	private BigDecimal crsReceiptAmount;

	/**
	 * @Fields  : 实收罚息(取自还款逾期罚息表“罚息已收金额”)
	 * @author yanfengbo
	 */
	private BigDecimal coReceiptAmount;

	/**
	 * @Fields  : 凭证生成状态
	 * @author yangyiquan
	 */
	private String voucherStatus;


//	/**
//	 * @Fields  : 最新勾稽时间
//	 * @author ningyangyang
//	 */
//	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
//	private Date updateTime;


	/**
	 * @Fields  : 还款状态
	 * @author yanfengbo
	 */
	private String paymentSts;

	/**
	 * @Fields  : 开票属性：是否先开票
	 * @author yangyiquan
	 */
	private String invoiceProp;
	/**
	 * @Fields  : 申请类型
	 * @author yanfengbo
	 */
	private String companyType1;


	/**
	 * @Fields  : 查询所需扣款状态
	 * @author yangyiquan
	 */
	private List<String> repayStatusList;

	/**
	 * @Fields  : 查询月份
	 * @author yangyiquan
	 */
	private String searchMonth;

	/**
	 * @Fields  : 剩余罚息金额
	 * @author yangyiquan
	 */
	private BigDecimal restOverdueAmount;

	/**
	 * @Fields  : 各报表导出检索条件专用
	 * @author yangyiquan
	 */
	private String exportFlag;

	/**
	 * @Fields  : 报表统计月份
	 * @author yangyiquan
	 */
	private String censuMonth;


	@ExcelTitle(value = "归属公司", sort = 1 ,types = {ExcelTypeConstants.FOUR, ExcelTypeConstants.SEX, ExcelTypeConstants.SEVEN, ExcelTypeConstants.EIGHT, ExcelTypeConstants.NINE})
	public String getGroupDistrict() {
		return groupDistrict;
	}
	@ExcelTitle(value = "客户名称", sort = 2 ,types = {ExcelTypeConstants.FOUR, ExcelTypeConstants.SEX, ExcelTypeConstants.SEVEN, ExcelTypeConstants.EIGHT, ExcelTypeConstants.NINE})
	public String getName() {return name;}
	@ExcelTitle(value = "车架号", sort = 3 ,types = {ExcelTypeConstants.FOUR,ExcelTypeConstants.SEX, ExcelTypeConstants.SEVEN, ExcelTypeConstants.EIGHT, ExcelTypeConstants.NINE})
	public String getVinNo() {return vinNo;}
	@ExcelTitle(value = "业务类型", sort = 4,codeType = CommonCodeTypeConstants.PROD_LICENSE_ATTR,types = {ExcelTypeConstants.FOUR, ExcelTypeConstants.SEX, ExcelTypeConstants.SEVEN, ExcelTypeConstants.EIGHT, ExcelTypeConstants.NINE})
	public String getLicenseAttr() {
		return licenseAttr;
	}

	@ExcelTitle(value = "申请类型", sort = 5,types = {ExcelTypeConstants.FOUR})
	public String getApplyType() {
		return applyType;
	}

	@ExcelTitle(value = "期数", sort = 5, types = {ExcelTypeConstants.SEX, ExcelTypeConstants.SEVEN, ExcelTypeConstants.EIGHT, ExcelTypeConstants.NINE})
	public Integer getPeriod6() {return period;}


	@ExcelTitle(value = "分类", sort = 6,types = {ExcelTypeConstants.FOUR})
	public String getCompanyType2() {return companyType2;}
	@ExcelTitle(value = "应还款日", sort = 6, types = {ExcelTypeConstants.SEX, ExcelTypeConstants.SEVEN, ExcelTypeConstants.EIGHT, ExcelTypeConstants.NINE})
	public String getRepayDateToStr6() {
		return DateUtils.dateToStr(repayDate,DateUtils.formatStr_yyyyMMdd);
	}

	@ExcelTitle(value = "期数", sort = 7, types = {ExcelTypeConstants.FOUR})
	public Integer getPeriod1() {return period;}
	@ExcelTitle(value = "应收租金", sort = 7, types = {ExcelTypeConstants.SEX, ExcelTypeConstants.SEVEN, ExcelTypeConstants.EIGHT, ExcelTypeConstants.NINE})
	public BigDecimal getRentActual6() {
		return rentActual;
	}

	@ExcelTitle(value = "应还款日", sort = 8, types = {ExcelTypeConstants.FOUR})
	public String getRepayDateToStr() {
		return DateUtils.dateToStr(repayDate,DateUtils.formatStr_yyyyMMdd);
	}
	@ExcelTitle(value = "实际还款日", sort = 8, types = {ExcelTypeConstants.SEX, ExcelTypeConstants.SEVEN, ExcelTypeConstants.NINE})
	public String getReceiptDateToStr6() {
		return DateUtils.dateToStr(receiptDate,DateUtils.formatStr_yyyyMMdd);
	}
	@ExcelTitle(value = "当期本金", sort = 8, types = {ExcelTypeConstants.EIGHT})
	public BigDecimal getPrincipal8() {
		return principal;
	}

	@ExcelTitle(value = "应收租金", sort = 9, types = {ExcelTypeConstants.FOUR})
	public BigDecimal getRentActual() {
		return rentActual;
	}
	@ExcelTitle(value = "实收租金", sort = 9, types = {ExcelTypeConstants.SEX, ExcelTypeConstants.SEVEN, ExcelTypeConstants.NINE})
	public  BigDecimal getReceiptAmount6(){return receiptAmount;}
	@ExcelTitle(value = "财务本金", sort = 9, types = {ExcelTypeConstants.EIGHT})
	public BigDecimal getFinRprincipal8() {return finRprincipal;}

	@ExcelTitle(value = "扣款状态", sort = 10, types = {ExcelTypeConstants.FOUR},codeType = CommonCodeTypeConstants.REPAY_STATUS)
	public String getRepayStatus() {
		return repayStatus;
	}
	@ExcelTitle(value = "当期本金", sort = 10, types = {ExcelTypeConstants.SEX, ExcelTypeConstants.SEVEN, ExcelTypeConstants.NINE})
	public BigDecimal getPrincipal6() {
		return principal;
	}
	@ExcelTitle(value = "发票开票时间", sort = 10, types = {ExcelTypeConstants.EIGHT})
	public String getInvoiceDateStr8() {
		return DateUtils.dateToStr(invoiceDate,DateUtils.formatStr_yyyyMMdd);
	}

	@ExcelTitle(value = "还款状态", sort = 11, types = {ExcelTypeConstants.FOUR},codeType = CommonCodeTypeConstants.PROD_PAYMENT_STS)
	public String getPaymentSts() {
		return paymentSts;
	}
	@ExcelTitle(value = "实收违约金", sort = 11, types = {ExcelTypeConstants.SEX, ExcelTypeConstants.SEVEN, ExcelTypeConstants.NINE})
	public BigDecimal getOverdueReceiptAmount6() {return overdueReceiptAmount;}
	@ExcelTitle(value = "备注", sort = 11, types = {ExcelTypeConstants.EIGHT})
	public  String getMemo8(){return memo;}

	@ExcelTitle(value = "实际还款日", sort = 12, types = {ExcelTypeConstants.FOUR})
	public String getReceiptDateToStr() {
		return DateUtils.dateToStr(receiptDate,DateUtils.formatStr_yyyyMMdd);
	}
	@ExcelTitle(value = "财务本金", sort = 12, types = {ExcelTypeConstants.SEX, ExcelTypeConstants.SEVEN, ExcelTypeConstants.NINE})
	public BigDecimal getFinRprincipal6() {return finRprincipal;}

	@ExcelTitle(value = "实收租金", sort = 13, types = {ExcelTypeConstants.FOUR})
	public  BigDecimal getReceiptAmount1(){return receiptAmount;}
	@ExcelTitle(value = "发票开票时间", sort = 13, types = {ExcelTypeConstants.SEX, ExcelTypeConstants.SEVEN, ExcelTypeConstants.NINE})
	public String getInvoiceDateStr6() {
		return DateUtils.dateToStr(invoiceDate,DateUtils.formatStr_yyyyMMdd);
	}

	@ExcelTitle(value = "当期本金", sort = 14, types = {ExcelTypeConstants.FOUR})
	public BigDecimal getPrincipal() {
		return principal;
	}
	@ExcelTitle(value = "备注", sort = 14, types = {ExcelTypeConstants.SEX, ExcelTypeConstants.SEVEN, ExcelTypeConstants.NINE})
	public  String getMemo16(){return memo;}

	@ExcelTitle(value = "剩余本金", sort = 15, types = {ExcelTypeConstants.FOUR})
	public BigDecimal getRestPrincipal() {
		return restPrincipal;
	}
	@ExcelTitle(value = "当期利息", sort = 16, types = {ExcelTypeConstants.FOUR})
	public BigDecimal getInterest() {
		return interest;
	}
	@ExcelTitle(value = "逾期状态", sort = 17, types = {ExcelTypeConstants.FOUR},codeType = CommonCodeTypeConstants.OVERDUE_FLAG)
	public String getOverdueStatus() {
		return overdueStatus;
	}
	@ExcelTitle(value = "罚息额", sort = 18, types = {ExcelTypeConstants.FOUR})
	public BigDecimal getOverdueAmount1() {return overdueAmount;}
	@ExcelTitle(value = "罚息免除金额", sort = 19, types = {ExcelTypeConstants.FOUR})
	public BigDecimal getExemptAmount() {return exemptAmount;}
	@ExcelTitle(value = "罚息已收金额", sort = 20, types = {ExcelTypeConstants.FOUR})
	public BigDecimal getOverdueReceiptAmount() {return overdueReceiptAmount;}


	@ExcelTitle(value = "发票开票时间", sort = 21, types = {ExcelTypeConstants.FOUR})
	public String getInvoiceDateStr() {
		return DateUtils.dateToStr(invoiceDate,DateUtils.formatStr_yyyyMMdd);
	}
	@ExcelTitle(value = "备注", sort = 22, types = {ExcelTypeConstants.FOUR})
	public  String getMemo1(){return memo;}
	@ExcelTitle(value = "开票备注", sort = 23, types = {ExcelTypeConstants.FOUR})
	public  String getInvoiceMemo1(){return invoiceMemo;}

	@ExcelTitle(value = "收款户名", sort = 24, types = {ExcelTypeConstants.FOUR})
	public String getRecAccountName() {
		return recAccountName;
	}
	@ExcelTitle(value = "收款银行", sort = 25, types = {ExcelTypeConstants.FOUR})
	public String getRecAccBank() {
		return recAccBank;
	}
	@ExcelTitle(value = "收款账号", sort = 26, types = {ExcelTypeConstants.FOUR})
	public String getRecAccountNo() {
		return recAccountNo;
	}
	@ExcelTitle(value = "合同编号", sort = 27 ,types = {ExcelTypeConstants.FOUR})
	public String getContNo1() {return contNo;}

	@ExcelTitle(value = "成交日期", sort = 28,types = {ExcelTypeConstants.FOUR})
	public String getDealDateStr() {
		return DateUtils.dateToStr(dealDate,DateUtils.formatStr_yyyyMMdd);
	}



	@ExcelTitle(value = "合同编号", sort = 1 ,types = { ExcelTypeConstants.TWO, ExcelTypeConstants.THREE})
	public String getContNo() {return contNo;}

	@ExcelTitle(value = "期数", sort = 2, types = { ExcelTypeConstants.TWO, ExcelTypeConstants.THREE})
	public Integer getPeriod() {return period;}

	@ExcelTitle(value = "收款日期", sort = 3, types = { ExcelTypeConstants.TWO})
	public String getReceiptDateStr() {return DateUtils.dateToStr(receiptDate, DateUtils.formatStr_yyyyMMdd);}

	@ExcelTitle(value = "收款日期", sort = 3, types = {ExcelTypeConstants.THREE})
	public String getRepayDateStr() {return DateUtils.dateToStr(repayDate, DateUtils.formatStr_yyyyMMdd);}

	@ExcelTitle(value = "每期客户实际租金", sort = 4, types = { ExcelTypeConstants.TWO, ExcelTypeConstants.THREE})
	public BigDecimal getRentAcutal() {return rentActual;}

	@ExcelTitle(value = "逾期罚息额", sort = 5, types = { ExcelTypeConstants.TWO, ExcelTypeConstants.THREE})
	public BigDecimal overdueAmountgetOverdueAmount() {return overdueAmount;}

	@ExcelTitle(value = "已认领金额", sort = 6, types = { ExcelTypeConstants.TWO})
	public BigDecimal getClaimedAmount() {return claimedAmount;}

	@ExcelTitle(value = "剩余金额", sort = 6, types = {ExcelTypeConstants.THREE})
	public BigDecimal getRestAmount() {return restAmount;}

	@ExcelTitle(value = "勾稽金额", sort = 7, types = {ExcelTypeConstants.THREE})
	public BigDecimal getReceiptExamAmount() {return receiptExamAmount;}

	@ExcelTitle(value = "勾稽状态", sort = 8, types = {ExcelTypeConstants.THREE}, codeType = CommonCodeTypeConstants.RECEIPT_EXAM_STATUS)
	public String getReceiptExamStatus() {return receiptExamStatus;}

	@ExcelTitle(value = "到账日期", sort = 9, types = {ExcelTypeConstants.THREE})
	public String getReceiptDateString() {return DateUtils.dateToStr(receiptDate, DateUtils.formatStr_yyyyMMdd);}

	@ExcelTitle(value = "付款银行", sort = 7, types = {ExcelTypeConstants.TWO})
	public  String getPayAccBank(){return payAccBank;}

	@ExcelTitle(value = "付款账号", sort = 8, types = {ExcelTypeConstants.TWO})
	public  String getPayAccountNo(){return payAccountNo;}

	@ExcelTitle(value = "付款户名", sort = 9, types = {ExcelTypeConstants.TWO})
	public  String getPayAccountName(){return payAccountName;}

	@ExcelTitle(value = "付款金额", sort = 10, types = {ExcelTypeConstants.TWO})
	public  BigDecimal getReceiptAmount(){return receiptAmount;}

	@ExcelTitle(value = "付款备注", sort = 11, types = {ExcelTypeConstants.TWO})
	public  String getMemo(){return memo;}

	@ExcelTitle(value = "付款银行", sort = 10, types = {ExcelTypeConstants.THREE})
	public  String getPayAccBankStr(){return payAccBank;}

	@ExcelTitle(value = "付款账号", sort = 11, types = {ExcelTypeConstants.THREE})
	public  String getPayAccountNoStr(){return payAccountNo;}

	@ExcelTitle(value = "付款户名", sort = 12, types = {ExcelTypeConstants.THREE})
	public  String getPayAccountNameStr(){return payAccountName;}

	@ExcelTitle(value = "付款金额", sort = 13, types = {ExcelTypeConstants.THREE})
	public  BigDecimal getReceiptAmountDe(){return receiptAmount;}

	@ExcelTitle(value = "付款备注", sort = 14, types = {ExcelTypeConstants.THREE})
	public  String getMemoStr(){return memo;}


	@ExcelTitle(value = "归属公司", sort = 1 ,types = {ExcelTypeConstants.FIVE})
	public String getGroupDistrict5() {
		return groupDistrict;
	}
	@ExcelTitle(value = "客户名称", sort = 2 ,types = {ExcelTypeConstants.FIVE})
	public String getName5() {
		return name;
	}
	@ExcelTitle(value = "车架号", sort = 3 ,types = {ExcelTypeConstants.FIVE})
	public String getVinNo5() {
		return vinNo;
	}
	@ExcelTitle(value = "业务类型", sort = 4,codeType = CommonCodeTypeConstants.PROD_LICENSE_ATTR,types = {ExcelTypeConstants.FIVE})
	public String getLicenseAttr5() {
		return licenseAttr;
	}

	@ExcelTitle(value = "申请类型", sort = 5,types = {ExcelTypeConstants.FIVE},codeType = CommonCodeTypeConstants.COMPANY_TYPE1)
	public String getApplyType5() {
		return applyType;
	}

	@ExcelTitle(value = "分类", sort = 6,types = {ExcelTypeConstants.FIVE},codeType = CommonCodeTypeConstants.COMPANY_TYPE2)
	public String getCompanyType5() {
		return companyType2;
	}
	@ExcelTitle(value = "期数", sort = 7, types = {ExcelTypeConstants.FIVE})
	public Integer getPeriod5() {return period;}

	@ExcelTitle(value = "应还款日", sort = 8, types = {ExcelTypeConstants.FIVE})
	public String getRepayDateToStr5() {
		return DateUtils.dateToStr(repayDate,DateUtils.formatStr_yyyyMMdd);
	}

	@ExcelTitle(value = "应收租金", sort = 9, types = {ExcelTypeConstants.FIVE})
	public BigDecimal getRentActual5() {
		return rentActual;
	}
	@ExcelTitle(value = "实际还款日", sort = 10, types = {ExcelTypeConstants.FIVE})
	public String getReceiptDateToStr5() {
		return DateUtils.dateToStr(receiptDate,DateUtils.formatStr_yyyyMMdd);
	}

	@ExcelTitle(value = "实收租金", sort = 11, types = {ExcelTypeConstants.FIVE})
	public  BigDecimal getReceiptAmount5(){return receiptAmount;}

	@ExcelTitle(value = "当期本金", sort = 12, types = {ExcelTypeConstants.FIVE})
	public BigDecimal getPrincipal5() {
		return principal;
	}
	@ExcelTitle(value = "当期利息", sort = 13, types = {ExcelTypeConstants.FIVE})
	public BigDecimal getInterest5() {
		return interest;
	}

	@ExcelTitle(value = "逾期状态", sort = 14, types = {ExcelTypeConstants.FIVE},codeType = CommonCodeTypeConstants.OVERDUE_FLAG)
	public String getOverdueStatus5() {
		return overdueStatus;
	}
	@ExcelTitle(value = "罚息额", sort = 15, types = {ExcelTypeConstants.FIVE})
	public BigDecimal getOverdueAmount5() {return overdueAmount;}
	@ExcelTitle(value = "罚息免除金额", sort = 16, types = {ExcelTypeConstants.FIVE})
	public BigDecimal getExemptAmount5() {return exemptAmount;}
	@ExcelTitle(value = "罚息已收金额", sort = 17, types = {ExcelTypeConstants.FIVE})
	public BigDecimal getOverdueReceiptAmount5() {return overdueReceiptAmount;}
	@ExcelTitle(value = "财务本金", sort = 18, types = {ExcelTypeConstants.FIVE})
	public BigDecimal getFinRprincipal() {return finRprincipal;}
	@ExcelTitle(value = "财务利息", sort = 19, types = {ExcelTypeConstants.FIVE})
	public BigDecimal getFinRinterest() {return finRinterest;}
	@ExcelTitle(value = "是否先开票", sort = 20, types = {ExcelTypeConstants.FIVE},codeType = CommonCodeTypeConstants.YESNOFLAG)
	public String getInvoiceProp5() {
		return invoiceProp;
	}
	@ExcelTitle(value = "发票开票时间", sort = 21, types = {ExcelTypeConstants.FIVE})
	public String getInvoiceDateStr5() {
		return DateUtils.dateToStr(invoiceDate,DateUtils.formatStr_yyyyMMdd);
	}
	@ExcelTitle(value = "备注", sort = 22, types = {ExcelTypeConstants.FIVE})
	public  String getMemo5(){return memo;}
	@ExcelTitle(value = "开票备注", sort = 23, types = {ExcelTypeConstants.FIVE})
	public  String getInvoiceMemo(){return invoiceMemo;}
	@ExcelTitle(value = "扣款状态", sort = 24, types = {ExcelTypeConstants.FIVE},codeType = CommonCodeTypeConstants.REPAY_STATUS)
	public String getRepayStatus5() {
		return repayStatus;
	}
	@ExcelTitle(value = "还款状态", sort = 25, types = {ExcelTypeConstants.FIVE},codeType = CommonCodeTypeConstants.PROD_PAYMENT_STS)
	public String getPaymentSts5() {
		return paymentSts;
	}

	@ExcelTitle(value = "收款户名", sort = 26, types = {ExcelTypeConstants.FIVE})
	public String getRecAccountName5() {
		return recAccountName;
	}
	@ExcelTitle(value = "收款银行", sort = 27, types = {ExcelTypeConstants.FIVE})
	public String getRecAccBank5() {
		return recAccBank;
	}
	@ExcelTitle(value = "收款账号", sort = 28, types = {ExcelTypeConstants.FIVE})
	public String getRecAccountNo5() {
		return recAccountNo;
	}
	@ExcelTitle(value = "合同编号", sort = 29 ,types = {ExcelTypeConstants.FIVE})
	public String getContNo5() {return contNo;}

	@ExcelTitle(value = "成交日期", sort = 30,types = {ExcelTypeConstants.FIVE})
	public String getDealDateStr5() {
		return DateUtils.dateToStr(dealDate,DateUtils.formatStr_yyyyMMdd);
	}



	/*excel导出待勾稽租金信息*/
	@ExcelTitle(value = "应还款日", sort = 1, types = {ExcelTypeConstants.ONE})
	public String getRepayDateToStrONE() {
		return DateUtils.dateToStr(repayDate,DateUtils.formatStr_yyyyMMdd);
	}
	@ExcelTitle(value = "承租人", sort = 2 ,types = {ExcelTypeConstants.ONE})
	public String getNameONE() {
		return name;
	}
	@ExcelTitle(value = "合同编号", sort = 3 ,types = {ExcelTypeConstants.ONE})
	public String getContNoONE() {return contNo;}
	@ExcelTitle(value = "区域", sort = 4 ,types = {ExcelTypeConstants.ONE})
	public String getGroupDistrictONE() {return groupDistrict;}
	@ExcelTitle(value = "车架号", sort = 5 ,types = {ExcelTypeConstants.ONE})
	public String getVinNoONE() {
		return vinNo;
	}
	@ExcelTitle(value = "期数", sort = 6, types = {ExcelTypeConstants.ONE})
	public Integer getPeriodONE() {return period;}
	@ExcelTitle(value = "应收租金", sort = 7, types = {ExcelTypeConstants.ONE})
	public BigDecimal getRentActualONE() {return rentActual;}
	@ExcelTitle(value = "已收租金", sort = 8, types = {ExcelTypeConstants.ONE})
	public BigDecimal getAlreadyReceiptAmountONE1() {
		return alreadyReceiptAmount;
	}
	@ExcelTitle(value = "应收罚息", sort = 9, types = {ExcelTypeConstants.ONE})
	public BigDecimal overdueAmountgetOverdueAmountONE() {return overdueAmount;}
	@ExcelTitle(value = "已收罚息", sort = 10, types = {ExcelTypeConstants.ONE})
	public BigDecimal getAlreadyReceiptAmountONE2() {
		return alreadyReceiptAmount;
	}
	@ExcelTitle(value = "实际还款日", sort = 11, types = {ExcelTypeConstants.ONE})
	public String getReceiptDateToStrONE() {
		return DateUtils.dateToStr(receiptDate,DateUtils.formatStr_yyyyMMdd);
	}
	@ExcelTitle(value = "申请类型", sort = 12,types = {ExcelTypeConstants.ONE},codeType = CommonCodeTypeConstants.COMPANY_TYPE1)
	public String getCompanyType1ONE() {
		return companyType1;
	}
	@ExcelTitle(value = "类别", sort = 13,types = {ExcelTypeConstants.ONE},codeType = CommonCodeTypeConstants.COMPANY_TYPE2)
	public String getCompanyType2ONE() {
		return companyType2;
	}
	@ExcelTitle(value = "备注", sort = 14, types = {ExcelTypeConstants.ONE})
	public  String getMemoONE(){return memo;}
}