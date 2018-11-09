package cn.com.leadu.fms.baseinfo.validator.basvehicle.vo;

import cn.com.leadu.fms.baseinfo.validator.basvehicle.validator.BasVehicleValidator;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasVehicle;
import lombok.Data;

/**
 * @author niehaibing
 * @ClassName: BasVehicleVo
 * @Description: 车辆信息维护保存时载体及验证
 * @date 2018-03-20
 */
@Data
public class BasVehicleSaveVo extends BaseVo<BasVehicle> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 车型信息ID
	 */
	private String vehicleId;

	/**
	 * @Fields  : 车型代码
	 */
	@BasVehicleValidator(message = "车辆代码已存在，请勿重复添加！")
	private String vehicleCode;

	/**
	 * @Fields  : 车型名称
	 */
	private String vehicleName;

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
	 * @Fields  : 禁用标志
	 */
	private String enableFlag;

}