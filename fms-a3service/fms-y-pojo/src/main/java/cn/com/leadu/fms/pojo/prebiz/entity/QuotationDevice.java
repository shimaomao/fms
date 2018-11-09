package cn.com.leadu.fms.pojo.prebiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: QuotationDevice
 * @Description: 报价器信息实体
 * @date 2018-05-23
 */
@Data
public class QuotationDevice extends BaseEntity<QuotationDevice> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 报价器ID
	 * @author lijunjun
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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
}