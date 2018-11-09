package cn.com.leadu.fms.pojo.baseinfo.entity;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import cn.com.leadu.fms.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author niehaibing
 * @ClassName: BasVehicle
 * @Description: 车辆信息维护实体
 * @date 2018-03-20
 */
@ExcelTitle(value = "车辆信息")
@Data
public class BasVehicle extends BaseEntity<BasVehicle> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 车型信息ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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
	 * @Fields  : 禁用标志
	 */
	private String enableFlag;

	@ExcelTitle(value = "车型代码", sort = 1 ,types = {ExcelTypeConstants.ONE})
	public String getVehicleCode(){return this.vehicleCode;}

	@ExcelTitle(value = "车型名称", sort = 2)
	public String getVehicleNames(){return this.vehicleName;}

	@ExcelTitle(value = "车型级别", sort = 3, codeType = CommonCodeTypeConstants.BAS_VEHICLE_LEVEL)
	public String getVehicleLevel(){return this.vehicleLevel;}

	@ExcelTitle(value = "上级车型代码", sort = 4)
	public String getParentVehicleCode(){return this.parentVehicleCode;}

	@ExcelTitle(value = "首字母", sort = 5)
	public String getFirstLetter(){return this.firstLetter;}

	@ExcelTitle(value = "指导价格", sort = 6)
	public Double getGuidePrice(){return this.guidePrice;}

	@ExcelTitle(value = "排量", sort = 7)
	public Double getDisplacement(){return this.displacement;}

	@ExcelTitle(value = "座位数量", sort = 8)
	public Integer getSeat(){return this.seat;}

	@ExcelTitle(value = "车型年款", sort = 9)
	public String getModelYear(){return this.modelYear;}

	@ExcelTitle(value = "吨位", sort = 10)
	public String getWeight(){return this.weight;}

	@ExcelTitle(value = "功率", sort = 11)
	public String getPower(){return this.power;}

	@ExcelTitle(value = "轮毂尺寸", sort = 12)
	public String getWheelSize(){return this.wheelSize;}

	@ExcelTitle(value = "排放标准", sort = 13)
	public String getEffluentStd(){return this.effluentStd;}

	@ExcelTitle(value = "是否新能源车", sort = 14, codeType = CommonCodeTypeConstants.NEW_ENERGY)
	public String getNewEnergy(){return this.newEnergy;}

	@ExcelTitle(value = "更新时间", sort = 15)
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(updateTime,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新人员", sort = 16)
	public String getUpdater(){
		return updater;
	}

}