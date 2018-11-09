package cn.com.leadu.fms.pojo.prebiz.vo.quotationdevice;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.QuotationDevice;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: QuotationDeviceVo
 * @Description: 报价器信息载体
 * @date 2018-05-23
 */
@ExcelTitle(value = "报价器一览信息")
@Data
public class QuotationDeviceVo extends PageQuery<QuotationDevice> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 报价器ID
	 * @author lijunjun
	 */
	private String quotationDeviceId;

	/**
	 * @Fields  : 客户姓名
	 * @author lijunjun
	 */
	private String name;

	/**
	 * @Fields  : 申请类型
	 * @author lijunjun
	 */
	private String applyType;

	/**
	 * @Fields  : 生成日期
	 * @author lijunjun
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMddHHmmss)
	private Date generationDate;

	/**
	 * @Fields  : 报价类型
	 * @author lijunjun
	 */
	private String quotationType;

	/**
	 * @Fields  : 报价时间
	 * @author lijunjun
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMddHHmmss)
	private Date quotationDate;

	/**
	 * @Fields  : 车型代码
	 * @author lijunjun
	 */
	private String vehicleCode;

	/**
	 * @Fields  : 车型名称
	 * @author lijunjun
	 */
	private String vehicleName;

	/**
	 * @Fields  : 车辆标签价
	 * @author lijunjun
	 */
	private BigDecimal cehicleLabelPrice;

	/**
	 * @Fields  : 车辆成交价
	 * @author lijunjun
	 */
	private BigDecimal cehicleTransactionPrice;

	/**
	 * @Fields  : 车辆采购价
	 * @author lijunjun
	 */
	private BigDecimal cehiclePurchasingPrice;

	/**
	 * @Fields  : 购置税
	 * @author lijunjun
	 */
	private BigDecimal purchaseTax;

	/**
	 * @Fields  : 商业保险
	 * @author lijunjun
	 */
	private BigDecimal commercialInsurance;

	/**
	 * @Fields  : 上牌综合服务
	 * @author lijunjun
	 */
	private BigDecimal boardServiceCharge;

	/**
	 * @Fields  : 交强险车船税
	 * @author lijunjun
	 */
	private BigDecimal highRiskVehicleTax;

	/**
	 * @Fields  : 精品
	 * @author lijunjun
	 */
	private BigDecimal fineQuality;

	/**
	 * @Fields  : 申请金额
	 * @author lijunjun
	 */
	private BigDecimal applicationAmount;

	/**
	 * @Fields  : 手续费
	 * @author lijunjun
	 */
	private BigDecimal serviceCharge;

	/**
	 * @Fields  : 融资额
	 * @author lijunjun
	 */
	private BigDecimal financingAmount;

	/**
	 * @Fields  : 返还经销商手续费
	 * @author lijunjun
	 */
	private BigDecimal restitutionFee;

	/**
	 * @Fields  : 续保押金
	 * @author lijunjun
	 */
	private BigDecimal renewDeposit;

	/**
	 * @Fields  : 渠道佣金
	 * @author lijunjun
	 */
	private BigDecimal channelCommission;

	/**
	 * @Fields  : 现金奖励
	 * @author lijunjun
	 */
	private BigDecimal cashReward;

	/**
	 * @Fields  : 内部提成
	 * @author lijunjun
	 */
	private BigDecimal internalFormation;

	/**
	 * @Fields  : 贷款期限
	 * @author lijunjun
	 */
	private Integer loanTerm;

	/**
	 * @Fields  : 大客户补贴比例
	 * @author lijunjun
	 */
	private BigDecimal customerSubsidyRatio;

	/**
	 * @Fields  : 大客户补贴金额
	 * @author lijunjun
	 */
	private BigDecimal customerSubsidyAmount;

	/**
	 * @Fields  : 首付款比例
	 * @author lijunjun
	 */
	private BigDecimal downPaymentRatio;

	/**
	 * @Fields  : 首付款
	 * @author lijunjun
	 */
	private BigDecimal firstPayment;

	/**
	 * @Fields  : 首付合计
	 * @author lijunjun
	 */
	private BigDecimal firstPaymentTotal;

	/**
	 * @Fields  : 保证金比例
	 * @author lijunjun
	 */
	private BigDecimal marginLevel;

	/**
	 * @Fields  : 保证金
	 * @author lijunjun
	 */
	private BigDecimal bond;

	/**
	 * @Fields  : 尾款比例
	 * @author lijunjun
	 */
	private BigDecimal tailProportion;

	/**
	 * @Fields  : 尾款金额
	 * @author lijunjun
	 */
	private BigDecimal tailMoney;

	/**
	 * @Fields  : 年供比例
	 * @author lijunjun
	 */
	private BigDecimal annualSupplyRate;

	/**
	 * @Fields  : 年供金额
	 * @author lijunjun
	 */
	private BigDecimal annualSupplyAmount;

	/**
	 * @Fields  : 客户利率
	 * @author lijunjun
	 */
	private BigDecimal customerInterestRate;

	/**
	 * @Fields  : 月供
	 * @author lijunjun
	 */
	private BigDecimal monthlySupply;

	/**
	 * @Fields  : 贸易收入
	 * @author lijunjun
	 */
	private BigDecimal tradeIncome;

	/**
	 * @Fields  : 项目粗利
	 * @author lijunjun
	 */
	private BigDecimal projectCoarseProfit;

	/**
	 * @Fields  : 贷款利息
	 * @author lijunjun
	 */
	private BigDecimal loanInterest;

	/**
	 * @Fields  : 静态收益率
	 * @author lijunjun
	 */
	private BigDecimal staticRateOfReturn;

	/**
	 * @Fields  : 增值税节税
	 * @author lijunjun
	 */
	private BigDecimal vatTaxSaving;

	/**
	 * @Fields  : 所得税节税
	 * @author lijunjun
	 */
	private BigDecimal incomeTaxSaving;

	/**
	 * @Fields  : 需动用资金
	 * @author lijunjun
	 */
	private BigDecimal needToUseFunds;

	/**
	 * @Fields  : IRR
	 * @author lijunjun
	 */
	private BigDecimal irr;

	/**
	 * @Fields  : 备注
	 * @author lijunjun
	 */
	private String remarks;

	/**
	 * @Fields  : 报价器ID
	 * @author lijunjun
	 */
	private List<String> quotationDeviceIds;

	/**
	 * @Fields  : 手续费率
	 * @author lijunjun
	 */
	private String serviceChargeRate;

	/**
	 * @Fields  : 企业所得税税率
	 * @author lijunjun
	 */
	private String incomeTaxRate;

	/**
	 * @Fields  : 增值税税率
	 * @author lijunjun
	 */
	private String vatTaxRate;

	/**
	 * @Fields  : 保险费率
	 * @author lijunjun
	 */
	private String commercialInsuranceRate;

	/**
	 * @Fields  : 购置税税率
	 * @author lijunjun
	 */
	private String purchaseTaxRate;

	/**
	 * @Fields  : 制造商代码
	 */
	private String vehMakerCode;

	/**
	 * @Fields  : 品牌代码
	 */
	private String vehBrandCode;

	/**
	 * @Fields  : 车系代码
	 */
	private String vehSeriesCode;

	/**
	 * @Fields  : 产品方案
	 * @author lijunjun
	 */
	private String product;

	/**
	 * @Fields  : 万量税费
	 * @author lijunjun
	 */
	private BigDecimal tax;

	/**
	 * @Fields  : 文件路径
	 * @author lijunjun
	 */
	private String filePath;

	/**
	 * @Fields  : 用户组代码
	 * @author lijunjun
	 */
	private String groupCode;

	/**
	 * @Fields  : 用户组名称
	 * @author lijunjun
	 */
	private String groupName;

	/**
	 * @Fields  : 注册地址
	 * @author lijunjun
	 */
	private String registeredAddr;

	/**
	 * @Fields  : 租金支付模式
	 * @author lijunjun
	 */
	private String rentPayMode;

	/**
	 * @Fields  : 回购价
	 * @author lijunjun
	 */
	private BigDecimal backPurchase;

	/**
	 * @Fields  : 参考出租人
	 * @author ningyangyang
	 */
	private String lessor;

	/**
	 * @Fields  : 参考车型
	 * @author ningyangyang
	 */
	private String models;

	/**
	 * @Fields  : 录入区分
	 * @author yanfengbo
	 */
	private String quotationEntryDistinction;

	/**
	 * @Fields  : 业务经理(订单提出用户)
	 * @author yanfengbo
	 */
	private String applyUser;

	/**
	 * @Fields  : 订单提出机构代码
	 * @author yanfengbo
	 */
	private String applyGroup;

	/**
	 * @Fields  : 业务经理(订单提出用户)(传递参数用)
	 * @author yanfengbo
	 */
	private String applyUserContr;

	/**
	 * @Fields  : 订单提出机构代码(传递参数用)
	 * @author yanfengbo
	 */
	private String applyGroupContr;

	/**
	 * @Fields  : 业务经理名称(订单提出用户)
	 * @author yanfengbo
	 */
	private String applyUserName;

	/**
	 * @Fields  : 订单提出机构名称
	 * @author yanfengbo
	 */
	private String applyGroupName;

	/**
	 * @Fields  : 当前用户
	 */
	private String sysUser;

	/**
	 * @Fields  : 当前用户所属机构
	 */
	private List<String> sysUserGroup;

	@ExcelTitle(value = "客户姓名", sort = 1)
	public String getName() {
		return name;
	}
	@ExcelTitle(value = "报价时间", sort = 2)
	public String getQuotationDateStr() {
		return DateUtils.dateToStr(quotationDate,DateUtils.formatStr_yyyyMMddHHmmss);
	}
	@ExcelTitle(value = "参考出租人", sort = 3)
	public String getLessor() {
		return lessor;
	}
	@ExcelTitle(value = "车型代码", sort = 4)
	public String getVehicleCode() {
		return vehicleCode;
	}
	@ExcelTitle(value = "车型名称", sort = 5)
	public String getVehicleName() {
		return vehicleName;
	}
	@ExcelTitle(value = "参考车型", sort = 6)
	public String getModels() {
		return models;
	}
	@ExcelTitle(value = "车辆标签价", sort = 7)
	public BigDecimal getCehicleLabelPrice() {
		return cehicleLabelPrice;
	}
	@ExcelTitle(value = "车辆成交价", sort = 8)
	public BigDecimal getCehicleTransactionPrice() {
		return cehicleTransactionPrice;
	}
	@ExcelTitle(value = "车辆采购价", sort = 9)
	public BigDecimal getCehiclePurchasingPrice() {
		return cehiclePurchasingPrice;
	}
	@ExcelTitle(value = "购置税", sort = 10)
	public BigDecimal getPurchaseTax() {
		return purchaseTax;
	}
	@ExcelTitle(value = "商业保险", sort = 11)
	public BigDecimal getCommercialInsurance() {
		return commercialInsurance;
	}
	@ExcelTitle(value = "上牌综合服务", sort = 12)
	public BigDecimal getBoardServiceCharge() {
		return boardServiceCharge;
	}
	@ExcelTitle(value = "交强险车船税", sort = 13)
	public BigDecimal getHighRiskVehicleTax() {
		return highRiskVehicleTax;
	}
	@ExcelTitle(value = "精品", sort = 14)
	public BigDecimal getFineQuality() {
		return fineQuality;
	}
	@ExcelTitle(value = "申请金额", sort = 15)
	public BigDecimal getApplicationAmount() {
		return applicationAmount;
	}
	@ExcelTitle(value = "手续费", sort = 16)
	public BigDecimal getServiceCharge() {
		return serviceCharge;
	}
	@ExcelTitle(value = "融资额", sort = 17)
	public BigDecimal getFinancingAmount() {
		return financingAmount;
	}
	@ExcelTitle(value = "返还经销商手续费", sort = 18)
	public BigDecimal getRestitutionFee() {
		return restitutionFee;
	}
	@ExcelTitle(value = "续保押金", sort = 19)
	public BigDecimal getRenewDeposit() {
		return renewDeposit;
	}
	@ExcelTitle(value = "渠道佣金", sort = 20)
	public BigDecimal getChannelCommission() {
		return channelCommission;
	}
	@ExcelTitle(value = "现金奖励", sort = 21)
	public BigDecimal getCashReward() {
		return cashReward;
	}
	@ExcelTitle(value = "内部提成", sort = 22)
	public BigDecimal getInternalFormation() {
		return internalFormation;
	}
	@ExcelTitle(value = "贷款期限", sort = 23)
	public Integer getLoanTerm() {
		return loanTerm;
	}
	@ExcelTitle(value = "首付款比例", sort = 24)
	public BigDecimal getDownPaymentRatio() {
		return downPaymentRatio;
	}
	@ExcelTitle(value = "首付款", sort = 25)
	public BigDecimal getFirstPayment() {
		return firstPayment;
	}
	@ExcelTitle(value = "保证金比例", sort = 26)
	public BigDecimal getMarginLevel() {
		return marginLevel;
	}
	@ExcelTitle(value = "保证金", sort = 27)
	public BigDecimal getBond() {
		return bond;
	}
	@ExcelTitle(value = "尾款比例", sort = 28)
	public BigDecimal getTailProportion() {
		return tailProportion;
	}
	@ExcelTitle(value = "尾款金额", sort = 29)
	public BigDecimal getTailMoney() {
		return tailMoney;
	}
	@ExcelTitle(value = "年供比例", sort = 30)
	public BigDecimal getAnnualSupplyRate() {
		return annualSupplyRate;
	}
	@ExcelTitle(value = "年供金额", sort = 31)
	public BigDecimal getAnnualSupplyAmount() {
		return annualSupplyAmount;
	}
	@ExcelTitle(value = "客户利率", sort = 32)
	public BigDecimal getCustomerInterestRate() {
		return customerInterestRate;
	}
	@ExcelTitle(value = "月供", sort = 33)
	public BigDecimal getMonthlySupply() {
		return monthlySupply;
	}
	@ExcelTitle(value = "贸易收入", sort = 34)
	public BigDecimal getTradeIncome() {
		return tradeIncome;
	}
	@ExcelTitle(value = "项目粗利", sort = 35)
	public BigDecimal getProjectCoarseProfit() {
		return projectCoarseProfit;
	}
	@ExcelTitle(value = "贷款利息", sort = 36)
	public BigDecimal getLoanInterest() {
		return loanInterest;
	}
	@ExcelTitle(value = "静态收益率", sort = 37)
	public BigDecimal getStaticRateOfReturn() {
		return staticRateOfReturn;
	}
	@ExcelTitle(value = "增值税节税", sort = 38)
	public BigDecimal getVatTaxSaving() {
		return vatTaxSaving;
	}
	@ExcelTitle(value = "所得税节税", sort = 39)
	public BigDecimal getIncomeTaxSaving() {
		return incomeTaxSaving;
	}
	@ExcelTitle(value = "需动用资金", sort = 40)
	public BigDecimal getNeedToUseFunds() {
		return needToUseFunds;
	}
	@ExcelTitle(value = "IRR", sort = 41)
	public BigDecimal getIrr() {
		return irr;
	}
	@ExcelTitle(value = "业务经理", sort = 42)
	public String getApplyUserName() {
		return applyUserName;
	}
	@ExcelTitle(value = "订单提出机构", sort = 43)
	public String getApplyGroupName() {
		return applyGroupName;
	}
	@ExcelTitle(value = "申请类型", sort = 44 ,codeType = CommonCodeTypeConstants.QUO_APPLY_TYPE)
	public String getApplyType() {
		return applyType;
	}
	@ExcelTitle(value = "录入区分", sort = 45 ,codeType = CommonCodeTypeConstants.QUOTATION_ENTRY_DISTINCTION)
	public String getQuotationEntryDistinction() {
		return quotationEntryDistinction;
	}
	@ExcelTitle(value = "备注", sort = 46)
	public String getRemarks() {
		return remarks;
	}
}