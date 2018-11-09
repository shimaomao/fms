package cn.com.leadu.fms.pojo.prebiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wangxue
 * @ClassName: ApplyVehicle
 * @Description: 融资车辆信息实体
 * @date 2018-03-24
 */
@Data
public class ApplyVehicle extends BaseEntity<ApplyVehicle> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 融资车辆ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String applyVehicleId;

	/**
	 * @Fields  : 订单编号
	 */
	private String applyNo;

	/**
	 * @Fields  : 车辆序号
	 */
	private String vehicleNo;

	/**
	 * @Fields  : 车辆类型
	 */
	private String vehicleForm;

	/**
	 * @Fields  : 数量
	 */
	private Integer vehicleCount;

	/**
	 * @Fields  : GPS安装情况
	 */
	private String gpsInstMode;

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
	 * @Fields  : 车型代码
	 */
	private String vehicleCode;

	/**
	 * @Fields  : 新车/二手车车辆指导价(元) 
	 */
	private BigDecimal guidePrice;

	/**
	 * @Fields  : 是否挂靠
	 */
	private String linkFlag;

	/**
	 * @Fields  : 挂靠名称
	 */
	private String linkName;

	/**
	 * @Fields  : 实际销售方代码
	 */
	private String saleGroupCode;

	/**
	 * @Fields  : 登记日期
	 */
	private Date registDate;

	/**
	 * @Fields  : 出厂日期
	 */
	private Date produceDate;

	/**
	 * @Fields  : 车龄（月）
	 */
	private BigDecimal vehAgeMonths;

	/**
	 * @Fields  : 二手车公里数
	 */
	private BigDecimal secHandMiles;

	/**
	 * @Fields  : 二手车车架号
	 */
	private String secHandVin;

	/**
	 * @Fields  : 评估金额
	 */
	private BigDecimal evaluatePrice;

	/**
	 * @Fields  : 评估人员
	 */
	private String evaluatePer;
	/**
	 * @Fields  : 续保押金
	 * @author lijunjun
	 */
	private BigDecimal renewalDeposit;

	/**
	 * @Fields  : 代收手续费
	 * @author lijunjun
	 */
	private BigDecimal salesCharge;

	/**
	 * @Fields  : 牌照使用费
	 * @author lijunjun
	 */
	private BigDecimal licenseFee;

	/**
	 * @Fields  : 盗抢险投保渠道
	 * @author lijunjun
	 */
	private String theftInsuranceType;

	/**
	 * @Fields  : 是否融盗抢险
	 * @author lijunjun
	 */
	private String theftInsuranceFlag;

	/**
	 * @Fields  : 提车方式
	 * @author lijunjun
	 */
	private String pickType;

	/**
	 * @Fields  : 折扣率
	 * @author lijunjun
	 */
	private BigDecimal priceOffRate;

	/**
	 * @Fields  : 回购价
	 * @author lijunjun
	 */
	private BigDecimal backPurchase;
	/**
	 * @Fields  : 保险购买方式
	 * @author lijunjun
	 */
	private String insuranceMode;
	/**
	 * @Fields  : 参考购置税
	 * @author lijunjun
	 */
	private BigDecimal referPurchaseTax;
	/**
	 * @Fields  : 参考保险费
	 * @author lijunjun
	 */
	private BigDecimal referInsuranceFee;
	/**
	 * @Fields  : 车辆外观颜色
	 * @author lijunjun
	 */
	private String carAppearance;

	/**
	 * @Fields  : 手续费用
	 */
	private BigDecimal charge;

	/**
	 * @Fields  : 渠道佣金
	 */
	private BigDecimal channelCommission;

	/**
	 * @Fields  : 现金奖励
	 */
	private BigDecimal cashReward;

	/**
	 * @Fields  : 内部提成
	 */
	private BigDecimal internalFormation;

}