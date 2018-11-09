package cn.com.leadu.fms.pojo.prebiz.vo.applyfinance;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyFinance;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: ApplyFinanceVo
 * @Description: 融资信息载体
 * @date 2018-03-24
 */
@Data
public class ApplyFinanceVo extends PageQuery<ApplyFinance> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 融资信息ID
	 */
	private String applyFinId;

	/**
	 * @Fields  : 订单编号
	 */
	private String applyNo;

	/**
	 * @Fields  : 产品大类代码
	 */
	@NotBlank(message = "产品大类不能为空")
	private String productCatg;

	/**
	 * @Fields  : 产品大类名称
	 */
	@NotBlank(message = "产品大类不能为空")
	private String productCatgName;

	/**
	 * @Fields  : 产品方案代码
	 */
	@NotBlank(message = "产品方案不能为空")
	private String product;

	/**
	 * @Fields  : 产品方案名称
	 */
	@NotBlank(message = "产品方案不能为空")
	private String productName;

	/**
	 * @Fields  : 车辆类型
	 */
	@NotBlank(message = "车辆类型不能为空")
	private String vehicleForm;

	/**
	 * @Fields  : 牌照属性
	 */
	@NotBlank(message = "牌照属性不能为空")
	private String licenseAttr;

	/**
	 * @Fields  : 还款方式
	 */
	@NotBlank(message = "还款方式不能为空")
	private String repayMode;

	/**
	 * @Fields  : 还款频率
	 */
	@NotBlank(message = "还款频率不能为空")
	private String repayRate;

	/**
	 * @Fields  : 租金支付模式
	 */
	@NotBlank(message = "租金支付模式不能为空")
	private String rentPayMode;

	/**
	 * @Fields  : 融资期限
	 */
	@NotBlank(message = "融资期限不能为空")
	private String finPeriodType;

	/**
	 * @Fields  : 手续费收取方式
	 */
//	@NotBlank(message = "手续费收取方式不能为空")
	private String chargePayMode;

	/**
	 * @Fields  : 保证金率
	 */
	@NotNull(message = "保证金率不能为空")
	@Max(value = 100, message = "保证金率不能大于100%")
	@Digits(integer = 3, fraction = 2, message = "保证金率最多两位小数")
	private BigDecimal depositPerc;

	/**
	 * @Fields  : 保证金
	 */
	@NotNull(message = "保证金不能为空")
	private BigDecimal deposit;

	/**
	 * @Fields  : 保证金返还方式
	 */
	@NotBlank(message = "保证金返还方式不能为空")
	private String depositRtnMode;

	/**
	 * @Fields  : 首付比例
	 */
	@NotNull(message = "首付比例不能为空")
	@Max(value = 100, message = "首付比例不能大于100%")
	@Digits(integer = 3, fraction = 2, message = "首付比例最多两位小数")
	private BigDecimal initPerc;

	/**
	 * @Fields  : 首付金额
	 */
	@NotNull(message = "首付金额不能为空")
	private BigDecimal initAmount;

	/**
	 * @Fields  : 尾付比例
	 */
	@NotNull(message = "尾付比例不能为空")
	@Max(value = 100, message = "尾付比例不能大于100%")
	@Digits(integer = 3, fraction = 2, message = "尾付比例最多两位小数")
	private BigDecimal finalPerc;

	/**
	 * @Fields  : 尾付金额
	 */
	@NotNull(message = "尾付金额不能为空")
	private BigDecimal finalAmount;
	/**
	 * @Fields  : 年供比例
	 */
	private BigDecimal annualSupplyRate;

	/**
	 * @Fields  : 年供金额
	 */
	private BigDecimal annualSupplyAmount;

	/**
	 * @Fields  : 投资总额
	 */
	@NotNull(message = "投资总额不能为空")
	private BigDecimal investTotal;

	/**
	 * @Fields  : 融资金额
	 */
	@NotNull(message = "融资金额不能为空")
	private BigDecimal finTotal;

	/**
	 * @Fields  : 客户利率
	 */
	@NotNull(message = "客户利率不能为空")
	private BigDecimal intrstRate;

	/**
	 * @Fields  : 结算利率
	 */
	private BigDecimal settleIntrstRate;

	/**
	 * @Fields  : 手续费率
	 */
//	@NotNull(message = "手续费率不能为空")
	private BigDecimal chargeRate;

	/**
	 * @Fields  : 结算手续费率
	 */
	private BigDecimal settleChargeRate;

	/**
	 * @Fields  : 手续费用
	 */
//	@NotNull(message = "手续费用不能为空")
	private BigDecimal charge;

	/**
	 * @Fields  : 结算手续费用
	 */
	private BigDecimal settleCharge;

	/**
	 * @Fields  : 贴息方式
	 */
	private String subsidyMode;

	/**
	 * @Fields  : 贴息利率
	 */
	private BigDecimal subsidyRate;

	/**
	 * @Fields  : 贴息年限
	 */
	private Integer subsidyYear;

	/**
	 * @Fields  : 贴息金额
	 */
	private BigDecimal subsidyAmount;

	/**
	 * @Fields  : 利率方式
	 */
	@NotBlank(message = "利率方式不能为空")
	private String intrstRateMode;

	/**
	 * @Fields  : 日逾期率
	 */
	private BigDecimal overdueDayRate;

	/**
	 * @Fields  : 每期租金
	 */
	private BigDecimal rent;


	/**
	 * @Fields  : irr
	 */
	private BigDecimal irr;

	/**
	 * @Fields  : 万量税费
	 */
	private BigDecimal tax;

	/**
	 * @Fields  : 风险融资额
	 */
	private BigDecimal riskFinTotal;

	/**
	 * @Fields  : 利率方案序号
	 */
	private String intrstNo;

	/**
	 * @Fields  : 有条件同意首付比例
	 */
	private BigDecimal initPercAgree;

	/**
	 * @Fields  : 有条件同意首付金额
	 */
	private BigDecimal initAmountAgree;

	/**
	 * @Fields  : 有条件同意尾付比例
	 */
	private BigDecimal finalPercAgree;

	/**
	 * @Fields  : 有条件同意尾付金额
	 */
	private BigDecimal finalAmountAgree;

	/**
	 * @Fields  : 有条件同意保证金率
	 */
	private BigDecimal depositPercAgree;

	/**
	 * @Fields  : 有条件同意保证金
	 */
	private BigDecimal depositAgree;

	/**
	 * @Fields  : 有条件同意每期租金
	 */
	private BigDecimal rentAgree;

	/**
	 * @Fields  : 有条件同意irr
	 */
	private BigDecimal irrAgree;

	/**
	 * @Fields  : 有条件同意万量税费
	 */
	private BigDecimal taxAgree;

	/**
	 * @Fields  : 有条件同意融资金额
	 */
	private BigDecimal finTotalAgree;

	/**
	 * @Fields  : 出租人
	 */
	private String belongGroup;

	/**
	 * @Fields  : 出租人
	 */
	private String belongGroupName;

	/**
	 * @Fields  : 报价单id
	 * @author ningyangyang
	 */
	private String quotationDeviceId;

	/**
	 * @Fields  : 有条件同意贷款利息
	 */
	private BigDecimal loanInterestAgree;

	/**
	 * @Fields  : 有条件同意贷款利息
	 */
	private BigDecimal loanInterest;

	/**
	 * @Fields  : 融资信息ID
	 */
	private List<String> applyFinIds;

	/**
	 * @Fields  : 销售顾问
	 * @author lijunjun
	 */
	private String salesCounselor;

	/**
	 * @Fields  : 销售顾问手机
	 * @author lijunjun
	 */
	private String salesCounselorMobno;

	/**
	 * @Fields  : 出租人区域
	 * @author lijunjun
	 */
	private String groupDistrict;

}