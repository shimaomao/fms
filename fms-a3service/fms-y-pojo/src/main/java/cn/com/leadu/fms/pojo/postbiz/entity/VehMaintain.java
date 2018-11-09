package cn.com.leadu.fms.pojo.postbiz.entity;

import cn.com.leadu.fms.common.annotation.ExcelImportTitle;
import cn.com.leadu.fms.common.annotation.ExcelTitle;
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
import java.math.BigDecimal;

/**
 * @author qinmuqiao
 * @ClassName: VehMaintain
 * @Description: 车辆维修记录实体
 */
@Data
public class VehMaintain extends BaseEntity<VehMaintain> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 车辆维修id

	 * @author qinmuqiao
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String vehMaintainId;

	/**
	 * @Fields  : 来源
	 * @author qinmuqiao
	 */
	private String maintainFlag;

	/**
	 * @Fields  : 理赔号
	 * @author qinmuqiao
	 */
	private String contInsurClaimNo;

	/**
	 * @Fields  : 车架号
	 * @author qinmuqiao
	 */
	@ExcelImportTitle("车架号")
	private String vinNo;

	/**
	 * @Fields  : 发动机号
	 * @author qinmuqiao
	 */
	@ExcelImportTitle("发动机号")
	private String engineNo;

	/**
	 * @Fields  : 车牌号
	 * @author qinmuqiao
	 */
	@ExcelImportTitle("车牌号")
	private String vehicleLicenseNo;

	/**
	 * @Fields  : 维修日期
	 * @author qinmuqiao
	 */
	@ExcelImportTitle(value = "维修日期" , dateFormats = {DateUtils.formatStr_yyyyMMdd , DateUtils.formatStr_yyyyMMdd_bias})
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date maintainDate;

	/**
	 * @Fields  : 维修地点
	 * @author qinmuqiao
	 */
	@ExcelImportTitle("维修地点")
	private String maintainAddr;

	/**
	 * @Fields  : 维修金额
	 * @author qinmuqiao
	 */
	@ExcelImportTitle("维修金额")
	private BigDecimal maintainAmount;

	/**
	 * @Fields  : 维修备注
	 * @author qinmuqiao
	 */
	private String maintainMemo;


	@ExcelTitle(value = "车架号", sort = 2,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getVinNo() {return vinNo;}

	@ExcelTitle(value = "发动机号", sort = 3,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getEngineNo() {return engineNo;}

	@ExcelTitle(value = "车牌号", sort = 4,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getVehicleLicenseNo() {return vehicleLicenseNo;}

	@ExcelTitle(value = "维修日期", sort = 5,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getMaintainDateStr() {return DateUtils.dateToStr(maintainDate, DateUtils.formatStr_yyyyMMdd);}

	@ExcelTitle(value = "维修地点", sort = 6,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getMaintainAddr() {return maintainAddr;}

	@ExcelTitle(value = "维修金额", sort = 7,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public BigDecimal getMaintainAmount() {return maintainAmount;}

}