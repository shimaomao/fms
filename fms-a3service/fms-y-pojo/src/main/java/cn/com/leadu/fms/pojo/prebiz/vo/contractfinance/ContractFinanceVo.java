package cn.com.leadu.fms.pojo.prebiz.vo.contractfinance;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.ContractFinance;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContractFinanceVo
 * @Description: 合同融资信息载体
 * @date 2018-03-23
 */
@Data
public class ContractFinanceVo extends PageQuery<ContractFinance> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 合同融资信息ID
	 */
	private String contFinId;

	/**
	 * @Fields  : 合同编号
	 */
	private String contNo;

	/**
	 * @Fields  : 订单编号
	 */
	private String applyNo;

	/**
	 * @Fields  : 车辆序号
	 */
	private String vehicleNo;

	/**
	 * @Fields  : 产品大类代码
	 */
	private String productCatg;

	/**
	 * @Fields  : 产品大类名称
	 */
	private String productCatgName;

	/**
	 * @Fields  : 产品方案代码
	 */
	private String product;

	/**
	 * @Fields  : 产品方案名称
	 */
	private String productName;

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
	 * @Fields  : 出租人
	 */
	private String belongGroup;

	/**
	 * @Fields  : 出租人
	 */
	private String belongGroupName;

	/**
	 * @Fields  : 统一社会信用代码
	 */
	private String socialCertifNo;

	/**
	 * @Fields  : 注册地址
	 */
	private String registeredAddr;

	/**
	 * @Fields  : 负责人
	 */
	private String head;

	/**
	 * @Fields  : 区域
	 */
	private String groupDistrict;

	/**
	 * @Fields  : 万量税费
	 */
	private BigDecimal tax;

	/**
	 * @Fields  : 贷款利息
	 */
	private BigDecimal loanInterest;

	/**
	 * @Fields  : 每期支付日期
	 * @author qiaomengnan
	 */
	private String repayDay;

	/**
	 * @Fields  : 合同融资信息ID
	 */
	private List<String> contFinIds;


	/**
	 * @Fields  : 是否是常规产品
	 * @author lijunjun
	 */
	private String fillBackFlag;
	/**
	 * @Fields  : 续保押金
	 */
	private BigDecimal renewalDeposit;

	/**
	 * @Fields  : 代收手续费
	 */
	private BigDecimal salesCharge;

	/**
	 * @Fields  : 牌照使用费
	 */
	private BigDecimal licenseFee;

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