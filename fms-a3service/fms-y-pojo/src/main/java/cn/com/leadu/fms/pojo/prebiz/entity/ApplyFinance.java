package cn.com.leadu.fms.pojo.prebiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author wangxue
 * @ClassName: ApplyFinance
 * @Description: 融资信息实体
 * @date 2018-03-24
 */
@Data
public class ApplyFinance extends BaseEntity<ApplyFinance> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 融资信息ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String applyFinId;

	/**
	 * @Fields  : 订单编号
	 */
	private String applyNo;

	/**
	 * @Fields  : 产品大类代码
	 */
	private String productCatg;

	/**
	 * @Fields  : 产品方案代码
	 */
	private String product;

	/**
	 * @Fields  : 车辆类型
	 */
	private String vehicleForm;

	/**
	 * @Fields  : 牌照属性
	 */
	private String licenseAttr;

	/**
	 * @Fields  : 还款方式
	 */
	private String repayMode;

	/**
	 * @Fields  : 还款频率
	 */
	private String repayRate;

	/**
	 * @Fields  : 租金支付模式
	 */
	private String rentPayMode;

	/**
	 * @Fields  : 融资期限
	 */
	private String finPeriodType;

	/**
	 * @Fields  : 手续费收取方式
	 */
	private String chargePayMode;

	/**
	 * @Fields  : 保证金率
	 */
	private BigDecimal depositPerc;

	/**
	 * @Fields  : 保证金
	 */
	private BigDecimal deposit;

	/**
	 * @Fields  : 保证金返还方式
	 */
	private String depositRtnMode;

	/**
	 * @Fields  : 首付比例
	 */
	private BigDecimal initPerc;

	/**
	 * @Fields  : 首付金额
	 */
	private BigDecimal initAmount;

	/**
	 * @Fields  : 尾付比例
	 */
	private BigDecimal finalPerc;

	/**
	 * @Fields  : 尾付金额
	 */
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
	private BigDecimal investTotal;

	/**
	 * @Fields  : 融资金额
	 */
	private BigDecimal finTotal;

	/**
	 * @Fields  : 客户利率
	 */
	private BigDecimal intrstRate;

	/**
	 * @Fields  : 结算利率
	 */
	private BigDecimal settleIntrstRate;

	/**
	 * @Fields  : 手续费率
	 */
	private BigDecimal chargeRate;

	/**
	 * @Fields  : 结算手续费率
	 */
	private BigDecimal settleChargeRate;

	/**
	 * @Fields  : 手续费用
	 */
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
	 * @Fields  : 贷款利息
	 */
	private BigDecimal loanInterest;
	/**
	 * @Fields  : 风险融资额
	 */
	private BigDecimal riskFinTotal;

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
	 * @Fields  : 有条件同意贷款利息
	 */
	private BigDecimal loanInterestAgree;

	/**
	 * @Fields  : 有条件同意融资金额
	 */
	private BigDecimal finTotalAgree;

	/**
	 * @Fields  : 出租人
	 */
	private String belongGroup;

	/**
	 * @Fields  : 报价单id
	 * @author ningyangyang
	 */
	private String quotationDeviceId;

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


}