package cn.com.leadu.fms.pojo.system.entity;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author yanfengbo
 * @ClassName: SysParamDao
 * @Description: 系统常量表实体
 * @date 2018-03-09
 */
@ExcelTitle(value = "系统常量信息")
@Data
public class SysParam extends BaseEntity<SysParam> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 参数主键id
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String paramKeyId;

	/**
	 * @Fields  : 参数主键
	 */
	private String paramKey;

	/**
	 * @Fields  : 参数名称
	 */
	private String paramName;

	/**
	 * @Fields  : 参数描述
	 */
	private String paramDesc;

	/**
	 * @Fields  : 参数值
	 */
	private String paramValue;

	/**
	 * @Fields  : 开始日期
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date validStartDate;

	/**
	 * @Fields  : 结束日期
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date validEndDate;

	@ExcelTitle(value = "参数主键", sort = 1 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getParamKey(){
		return this.paramKey;
	}

	@ExcelTitle(value = "参数名称", sort = 2)
	public String getParamName(){
		return this.paramName;
	}

	@ExcelTitle(value = "参数值", sort = 3)
	public String getParamValue(){
		return paramValue;
	}

	@ExcelTitle(value = "开始日期", sort = 4)
	@JsonIgnore
	public String getValidStartDateStr(){
		return DateUtils.dateToStr(validStartDate,DateUtils.formatStr_yyyyMMdd);
	}

	@ExcelTitle(value = "结束日期", sort = 5)
	@JsonIgnore
	public String getValidEndDateStr() {return DateUtils.dateToStr(validEndDate,DateUtils.formatStr_yyyyMMdd);}

	@ExcelTitle(value = "更新时间", sort = 6)
	@JsonIgnore
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(updateTime,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新人员", sort = 7)
	public String getUpdater(){
		return updater;
	}

}