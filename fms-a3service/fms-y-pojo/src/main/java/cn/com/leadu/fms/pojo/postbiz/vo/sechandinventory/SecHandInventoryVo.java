package cn.com.leadu.fms.pojo.postbiz.vo.sechandinventory;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.BigDecimalUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.SecHandInventory;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author qinmuqiao
 * @ClassName: SecHandInventoryVo
 * @Description: 库存管理载体
 */
@ExcelTitle(value = "库存管理")
@Data
public class SecHandInventoryVo extends PageQuery<SecHandInventory> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 二手车id
	 * @author qinmuqiao
	 */
	private String secHandId;

	/**
	 * @Fields  : 车架号
	 * @author qinmuqiao
	 */
	private String vinNo;

	/**
	 * @Fields  : 发动机号
	 * @author qinmuqiao
	 */
	private String engineNo;

	/**
	 * @Fields  : 颜色
	 * @author qinmuqiao
	 */
	private String color;

	/**
	 * @Fields  : 车型
	 * @author qinmuqiao
	 */
	private String vehicleCode;

	/**
	 * @Fields  : 行驶公里数
	 * @author qinmuqiao
	 */
	private BigDecimal miles;

	/**
	 * @Fields  : 登记日期
	 * @author qinmuqiao
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date registDate;

	/**
	 * @Fields  : 车龄
	 * @author qinmuqiao
	 */
	private BigDecimal vehAgeMonths;

	/**
	 * @Fields  : 出厂日期
	 * @author qinmuqiao
	 */
	@JsonFormat (pattern = DateUtils.formatStr_yyyyMMdd)
	private Date produceDate;

	/**
	 * @Fields  : 车辆评估价
	 * @author qinmuqiao
	 */
	private BigDecimal evaluationPrice;

	/**
	 * @Fields  : 状态
	 * @author qinmuqiao
	 */
	private String status;

	/**
	 * @Fields  : 二手车来源
	 * @author qinmuqiao
	 */
	private String carSource;

	/**
	 * @Fields  : 收车任务号
	 * @author qinmuqiao
	 */
	private String recoveryTaskNo;

	/**
	 * @Fields  : 车型名称
	 * @author qinmuqiao
	 */
	private String vehicleName;

	/**
	 * @Fields  : 二手车id
	 * @author qinmuqiao
	 */
	private List<String> secHandIds;

	/**
	 * @Fields  : 收车入库时间
	 * @author yanfengo
	 */
	@JsonFormat (pattern = DateUtils.formatStr_yyyyMMdd)
	private Date storageDate;

	/**
	 * @Fields  : 开始时间(收车入库时间)
	 * @author yanfengo
	 */
	private String startTime;

	/**
	 * @Fields  : 结束时间(收车入库时间)
	 * @author yanfengo
	 */
	private String endTime;



	@ExcelTitle(value = "车架号", sort = 1)
	public String getVinNo(){return this.vinNo;}

	@ExcelTitle(value = "发动机号", sort = 2)
	public String getEngineNo(){return this.engineNo;}

	@ExcelTitle(value = "行驶公里数", sort = 3)
	public String getMiles() {return BigDecimalUtils.getNotNullBigDecimal(this.miles).toString();}

	@ExcelTitle(value = "登记日期", sort = 4)
	public String getRegistDateStr(){
		return DateUtils.dateToStr(this.registDate,DateUtils.formatStr_yyyyMMdd);
	}

	@ExcelTitle(value = "车龄", sort = 5)
	public String getVehAgeMonths() {return BigDecimalUtils.getNotNullBigDecimal(this.vehAgeMonths).toString();}

	@ExcelTitle(value = "出厂日期", sort = 6)
	public String getProduceDateStr(){
		return DateUtils.dateToStr(this.produceDate,DateUtils.formatStr_yyyyMMdd);
	}

	@ExcelTitle(value = "车辆评估价", sort = 7)
	public String getEvaluationPrice(){
		return BigDecimalUtils.getNotNullBigDecimal(this.evaluationPrice).toString();
	}

	@ExcelTitle(value = "颜色", sort = 8)
	public String getColor() {return this.color;}

	@ExcelTitle(value = "车型", sort = 9)
	public String getVehicleCode() {return this.vehicleCode;}


	@ExcelTitle(value = "收车任务号", sort = 10)
	public String getRecoveryTaskNo() {return this.recoveryTaskNo;}

	@ExcelTitle(value = "状态", sort = 11,codeType = CommonCodeTypeConstants.SEC_HAND_STATUS, types = {ExcelTypeConstants.ONE})
	public String getStatus(){
		return  this.status;
	}


	@ExcelTitle(value = "来源", sort = 12,codeType = CommonCodeTypeConstants.SEC_HAND_CAR_SOURCE, types = {ExcelTypeConstants.ONE})
	public String getCarSource(){
		return  this.carSource;
	}



}