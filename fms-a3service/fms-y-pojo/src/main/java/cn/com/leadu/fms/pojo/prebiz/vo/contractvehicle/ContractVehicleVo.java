package cn.com.leadu.fms.pojo.prebiz.vo.contractvehicle;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.ContractVehicle;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinDetailVo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContractVehicleVo
 * @Description: 合同融资车辆信息载体
 * @date 2018-03-23
 */
@Data
public class ContractVehicleVo extends PageQuery<ContractVehicle> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 合同融资车辆ID
	 */
	private String contVehicleId;

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
	 * @Fields  : 车辆类型
	 */
	private String vehicleForm;

	/**
	 * @Fields  : 数量
	 */
	private Integer vehicleCount;

	/**
	 * @Fields  : 制造商代码
	 */
	private String vehMakerCode;
	/**
	 * @Fields  : 制造商名称
	 */
	private String vehMakerName;
	/**
	 * @Fields  : 
	 */
	private String vehBrandCode;

	/**
	 * @Fields  : 品牌名称
	 */
	private String vehBrandName;

	/**
	 * @Fields  : 
	 */
	private String vehSeriesCode;

	/**
	 * @Fields  : 车系名称
	 */
	private String vehSeriesName;
	/**
	 * @Fields  : 
	 */
	private String vehicleCode;

	/**
	 * @Fields  : 车型名称
	 */
	private String vehicleName;
	/**
	 * @Fields  : 
	 */
	private BigDecimal guidePrice;

	/**
	 * @Fields  : 车辆类型
	 */
	private String vehicleType1;

	/**
	 * @Fields  : 车辆类型
	 */
	private String vehicleType2;

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
	 * @Fields  :实际销售方名称
	 */
	private String saleGroupName;
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
	 * @Fields  : GPS安装情况
	 */
	private String gpsInstMode;

	/**
	 * @Fields  :合同融资车辆ID
	 */
	private List<String> contVehicleIds;

	/**
	 * @Fields  :
	 */
	private List<ContFinDetailVo> contFinDetailVoList;

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
	 * @Fields  : 盗抢险投保渠道
	 */
	private String theftInsuranceType;

	/**
	 * @Fields  : 是否融盗抢险
	 */
	private String theftInsuranceFlag;

	/**
	 * @Fields  : 定金金额
	 */
	private BigDecimal vehDeposit;
	/**
	 * @Fields  : 定金是否抵扣车款
	 */
	private String deductibleFees;

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
	 * @Fields  : 车辆外观颜色
	 * @author lijunjun
	 */
	private String withinGroup;

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