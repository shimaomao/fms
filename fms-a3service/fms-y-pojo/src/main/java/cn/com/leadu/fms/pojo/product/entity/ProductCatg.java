package cn.com.leadu.fms.pojo.product.entity;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author niehaibing
 * @ClassName: ProductCatg
 * @Description: 产品大类管理实体
 * @date 2018-03-21
 */
@ExcelTitle(value = "产品大类信息")
@Data
public class ProductCatg extends BaseEntity<ProductCatg> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 产品大类ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String productCatgId;

	/**
	 * @Fields  : 产品大类代码
	 */
	private String productCatg;

	/**
	 * @Fields  : 产品大类名称
	 */
	private String productCatgName;

	/**
	 * @Fields  : 产品大类描述
	 */
	private String productCatgMemo;

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
	 * @Fields  : 启用标志
	 */
	private String enableFlag;

	@ExcelTitle(value = "产品大类代码", sort = 1 ,types = {ExcelTypeConstants.ONE})
	public String getProductCatg() {
		return this.productCatg;
	}

	@ExcelTitle(value = "产品大类名称", sort = 2)
	public String getProductCatgName() {
		return this.productCatgName;
	}

	@ExcelTitle(value = "产品大类描述", sort = 3)
	public String getProductCatgMemo() {
		return this.productCatgMemo;
	}

	@ExcelTitle(value = "申请类型", sort = 4, codeType = CommonCodeTypeConstants.PROD_APPLY_TYPE, joinDelimiter = StringUtils.COMMA)
	public String getApplyType() {
		return this.applyType;
	}

	@ExcelTitle(value = "车辆类型", sort = 5, codeType = CommonCodeTypeConstants.PROD_VEHICLE_FORM, joinDelimiter = StringUtils.COMMA)
	public String getVehicleForm() {
		return this.vehicleForm;
	}

	@ExcelTitle(value = "车辆种类", sort = 6, codeType = CommonCodeTypeConstants.PROD_VEHICLE_TYPE , joinDelimiter = StringUtils.COMMA)
	public String getVehicleType() {
		return this.vehicleType;
	}

	@ExcelTitle(value = "启用标志", sort = 7, codeType = CommonCodeTypeConstants.COMMON_ENABLE_FLAG)
	public String getEnableFlag() {
		return this.enableFlag;
	}

	@ExcelTitle(value = "更新时间", sort = 8)
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(updateTime,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新人", sort = 9)
	public String getUpdater(){
		return updater;
	}
}