package cn.com.leadu.fms.pojo.baseinfo.vo.basvehicle;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasVehicle;
import lombok.Data;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: BasVehicleVo
 * @Description: 车辆信息维护载体
 * @date 2018-03-20
 */
@ExcelTitle(typeValues ={ "车辆信息","车型信息"},types = {ExcelTypeConstants.ONE, ExcelTypeConstants.TWO})
@Data
public class BasVehicleVo extends PageQuery<BasVehicle> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 车型信息ID
	 */
	private String vehicleId;

	/**
	 * @Fields  : 车型代码
	 */
	private String vehicleCode;

	/**
	 * @Fields  : 车型名称
	 */
	private String vehicleName;

	/**
	 * @Fields  : 上级车型名称
	 */
	private String parentVehicleName;

	/**
	 * @Fields  : 级别(*1-制造商；2-品牌；3-车系；4-车型)
	 */
	private String vehicleLevel;

	/**
	 * @Fields  : 上级车型代码
	 */
	private String parentVehicleCode;

	/**
	 * @Fields  : 首字母
	 */
	private String firstLetter;

	/**
	 * @Fields  : 车辆大类(*1-乘用车；2-商用车)
	 */
	private String vehicleType1;

	/**
	 * @Fields  : 车辆分类(*乘用车/皮卡/微面/轻卡/轻客)
	 */
	private String vehicleType2;

	/**
	 * @Fields  : 指导价格
	 */
	private Double guidePrice;

	/**
	 * @Fields  : 排量
	 */
	private Double displacement;

	/**
	 * @Fields  : 座位数量
	 */
	private Integer seat;

	/**
	 * @Fields  : 车型年款
	 */
	private String modelYear;

	/**
	 * @Fields  : 吨位
	 */
	private String weight;

	/**
	 * @Fields  : 功率
	 */
	private String power;

	/**
	 * @Fields  : 轮毂尺寸
	 */
	private String wheelSize;

	/**
	 * @Fields  : 排放标准
	 */
	private String effluentStd;

	/**
	 * @Fields  : 是否新能源车（0-不是，1-是）
	 */
	private String newEnergy;

	/**
	 * @Fields  : 制造商
	 */
	private String manufacturer;

	/**
	 * @Fields  : 品牌
	 */
	private String brand;

	/**
	 * @Fields  : 车系
	 */
	private String carSeries;

	/**
	 * @Fields  : 车型信息ID
	 */
	private List<String> vehicleIds;

	/**
	 * @Fields  : 制造商Code
	 */
	private String vehMakerCode;

	/**
	 * @Fields  : 制造商名称
	 */
	private String vehMakerName;

	/**
	 * @Fields  : 品牌Code
	 */
	private String vehBrandCode;

	/**
	 * @Fields  : 品牌名称
	 */
	private String vehBrandName;

	/**
	 * @Fields  : 车系Code
	 */
	private String vehSeriesCode;

	/**
	 * @Fields  : 车系名称
	 */
	private String vehSeriesName;

	/**
	 * @Fields  : 产品拥有的车型codeList
	 */
	private List<String> vehicleCodeList;

	/**
	 * @Fields  : 车辆类型List
	 */
	private List<String> vehicleTypeList;

	/**
	 * @Fields  : 产品拥有的车型code
	 */
	private String vehicleCodes;

	/**
	 * @Fields  : 车辆类型
	 */
	private String vehicleTypes;

	/**
	 * @Fields  : 禁用标志
	 */
	private String enableFlag;

	@ExcelTitle(typeValues ={"代码", "车型代码"}, sort = 1, types = {ExcelTypeConstants.ONE, ExcelTypeConstants.TWO})
	public String getVehicleCode(){return this.vehicleCode;}

	@ExcelTitle(typeValues ={"名称", "车型名称"}, sort = 2, types = {ExcelTypeConstants.ONE, ExcelTypeConstants.TWO})
	public String getVehicleNames(){return this.vehicleName;}

	@ExcelTitle(value = "级别", sort = 3, codeType = CommonCodeTypeConstants.BAS_VEHICLE_LEVEL, types = {ExcelTypeConstants.ONE})
	public String getVehicleLevel(){return this.vehicleLevel;}

	@ExcelTitle(value = "车辆大类", sort = 3, codeType = CommonCodeTypeConstants.PROD_VEHICLE_TYPE, types = {ExcelTypeConstants.TWO})
	public String getVehicleType1() {return vehicleType1;}

	@ExcelTitle(value = "首字母", sort = 4, types = {ExcelTypeConstants.ONE})
	public String getFirstLetter(){return this.firstLetter;}

	@ExcelTitle(value = "指导价格", sort = 4, types = {ExcelTypeConstants.TWO})
	public Double getGuidePrice() {return guidePrice;}

	@ExcelTitle(value = "制造商代码", sort = 5, types = {ExcelTypeConstants.TWO})
	public String getVehMakerCode() {return vehMakerCode;}

	@ExcelTitle(value = "制造商名称", sort = 6, types = {ExcelTypeConstants.TWO})
	public String getVehMakerName() {return vehMakerName;}

	@ExcelTitle(value = "品牌代码", sort = 7, types = {ExcelTypeConstants.TWO})
	public String getVehBrandCode() {return vehBrandCode;}

	@ExcelTitle(value = "品牌名称", sort = 8, types = {ExcelTypeConstants.TWO})
	public String getVehBrandName() {return vehBrandName;}

	@ExcelTitle(value = "车系代码", sort = 9, types = {ExcelTypeConstants.TWO})
	public String getVehSeriesCode() {return vehSeriesCode;}

	@ExcelTitle(value = "车系名称", sort = 10, types = {ExcelTypeConstants.TWO})
	public String getVehSeriesName() {return vehSeriesName;}

}