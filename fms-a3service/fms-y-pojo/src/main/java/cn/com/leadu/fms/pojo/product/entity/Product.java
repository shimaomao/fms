package cn.com.leadu.fms.pojo.product.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author niehaibing
 * @ClassName: Product
 * @Description: 产品方案管理实体
 * @date 2018-03-23
 */
@Data
public class Product extends BaseEntity<Product> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 产品方案ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String productId;

	/**
	 * @Fields  : 产品方案代码
	 */
	private String product;

	/**
	 * @Fields  : 产品大类代码
	 */
	private String productCatg;

	/**
	 * @Fields  : 产品方案名称
	 */
	private String productName;

	/**
	 * @Fields  : 产品方案描述
	 */
	private String productMemo;

	/**
	 * @Fields  : 开始日期
	 */
	private Date startDate;

	/**
	 * @Fields  : 结束日期
	 */
	private Date endDate;

	/**
	 * @Fields  : 车辆类型
	 */
	private String vehicleForm;

	/**
	 * @Fields  : 申请类型
	 */
	private String applyType;

	/**
	 * @Fields  : 车辆种类
	 */
	private String vehicleType;

	/**
	 * @Fields  : 牌照属性
	 */
	private String licenseAttr;

	/**
	 * @Fields  : 租金支付模式
	 */
	private String rentPayMode;

	/**
	 * @Fields  : GPS安装情况
	 */
	private String gpsInstMode;

	/**
	 * @Fields  : 还款方式
	 */
	private String repayMode;

	/**
	 * @Fields  : 还款频率
	 */
	private String repayRate;

	/**
	 * @Fields  : 保证金返还方式
	 */
	private String depositRtnMode;

	/**
	 * @Fields  : 融资期限
	 */
	private String finPeriodType;

	/**
	 * @Fields  : 手续费收取方式
	 */
	private String chargePayMode;

	/**
	 * @Fields  : 首付比例开始
	 */
	private BigDecimal initPercFrom;

	/**
	 * @Fields  : 首付比例结束
	 */
	private BigDecimal initPercTo;

	/**
	 * @Fields  : 首付金额开始
	 */
	private BigDecimal initAmountFrom;

	/**
	 * @Fields  : 首付金额结束
	 */
	private BigDecimal initAmountTo;

	/**
	 * @Fields  : 尾付比例开始
	 */
	private BigDecimal finalPercFrom;

	/**
	 * @Fields  : 尾付比例结束
	 */
	private BigDecimal finalPercTo;

	/**
	 * @Fields  : 尾付金额开始
	 */
	private BigDecimal finalAmountFrom;

	/**
	 * @Fields  : 尾付金额结束
	 */
	private BigDecimal finalAmountTo;

	/**
	 * @Fields  : 保证金开始
	 */
	private BigDecimal depositFrom;

	/**
	 * @Fields  : 保证金结束
	 */
	private BigDecimal depositTo;

	/**
	 * @Fields  : 保证金率开始
	 */
	private BigDecimal depositPercFrom;

	/**
	 * @Fields  : 保证金率结束
	 */
	private BigDecimal depositPercTo;

	/**
	 * @Fields  : 融资总额开始
	 */
	private BigDecimal finTotalFrom;

	/**
	 * @Fields  : 融资总额结束
	 */
	private BigDecimal finTotalTo;

	/**
	 * @Fields  : 风险融资额开始
	 */
	private BigDecimal finRiskFrom;

	/**
	 * @Fields  : 风险融资额结束
	 */
	private BigDecimal finRiskTo;

	/**
	 * @Fields  : 贴息是否差额付款
	 */
	private String subsidyPayMode;

	/**
	 * @Fields  : 是否是常规产品
	 */
	private String fillBackFlag;

	/**
	 * @Fields  : 扩展属性1
	 */
	private String prodAttr1;

	/**
	 * @Fields  : 扩展属性2
	 */
	private String prodAttr2;

	/**
	 * @Fields  : 扩展属性3
	 */
	private String prodAttr3;
	/**
	 * @Fields  : 年供比例
	 */
	private BigDecimal annualSupplyRateFrom;
	/**
	 * @Fields  : 年供比例
	 */
	private BigDecimal annualSupplyRateTo;

	/**
	 * @Fields  : 年供金额
	 */
	private BigDecimal annualSupplyAmountFrom;

	/**
	 * @Fields  : 年供金额
	 */
	private BigDecimal annualSupplyAmountTo;


	/**
	 * @Fields  : irr
	 */
	private BigDecimal irrFrom;


	/**
	 * @Fields  : irr
	 */
	private BigDecimal irrTo;

}