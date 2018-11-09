package cn.com.leadu.fms.pojo.prebiz.vo.applyvehicle;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyVehicle;
import cn.com.leadu.fms.pojo.prebiz.vo.applyfindetail.ApplyFinDetailVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: ApplyVehicleVo
 * @Description: 融资车辆信息载体
 * @date 2018-03-24
 */
@Data
public class ApplyVehicleVo extends PageQuery<ApplyVehicle> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 融资车辆ID
	 */
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
	@NotNull(message = "数量不能为空")
	@Min(value = 1, message = "车辆的数据不能小于1")
	private Integer vehicleCount;

	/**
	 * @Fields  : GPS安装情况
	 */
	@NotBlank(message = "GPS安装情况不能为空")
	private String gpsInstMode;

	/**
	 * @Fields  : 制造商代码
	 */
	@NotBlank(message = "制造商不能为空")
	private String vehMakerCode;

	/**
	 * @Fields  : 制造商名称
	 */
	@NotBlank(message = "制造商不能为空")
	private String vehMakerName;

	/**
	 * @Fields  : 品牌代码
	 */
	@NotBlank(message = "品牌不能为空")
	private String vehBrandCode;

	/**
	 * @Fields  : 品牌名称
	 */
	@NotBlank(message = "品牌不能为空")
	private String vehBrandName;

	/**
	 * @Fields  : 车系代码
	 */
	@NotBlank(message = "车系不能为空")
	private String vehSeriesCode;

	/**
	 * @Fields  : 车系名称
	 */
	@NotBlank(message = "车系不能为空")
	private String vehSeriesName;

	/**
	 * @Fields  : 车型代码
	 */
	@NotBlank(message = "车型不能为空")
	private String vehicleCode;

	/**
	 * @Fields  : 车型名称
	 */
	@NotBlank(message = "车型不能为空")
	private String vehicleName;

	/**
	 * @Fields  : 新车/二手车车辆指导价(元) 
	 */
	@NotNull(message = "车辆指导价不能为空")
	private BigDecimal guidePrice;

	/**
	 * @Fields  : 车辆大类
	 */
	private String vehicleType1;

	/**
	 * @Fields  : 车辆分类
	 */
	private String vehicleType2;

	/**
	 * @Fields  : 是否挂靠
	 */
	@NotBlank(message = "是否挂靠不能为空")
	private String linkFlag;

	/**
	 * @Fields  : 挂靠名称
	 */
	private String linkName;

	/**
	 * @Fields  : 实际销售方代码
	 */
	@NotBlank(message = "实际销售方不能为空")
	private String saleGroupCode;

	/**
	 * @Fields  : 实际销售方名称
	 */
	@NotBlank(message = "实际销售方不能为空")
	private String saleGroupName;

	/**
	 * @Fields  : 登记日期
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date registDate;

	/**
	 * @Fields  : 出厂日期
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
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
	 * @Fields  : 投资总额
	 */
	private BigDecimal investTotal;
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
	 * @Fields  : 融资明细
	 */
	private List<ApplyFinDetailVo> applyFinDetailVoList;

	/**
	 * @Fields  : 融资车辆ID
	 */
	private List<String> applyVehicleIds;

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