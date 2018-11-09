package cn.com.leadu.fms.pojo.system.entity;

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

/**
 * @author qiaomengnan
 * @ClassName: SysLog
 * @Description: 日志管理实体
 * @date 2018-03-22
 */
@ExcelTitle(value = "日志一览信息")
@Data
public class SysLog extends BaseEntity<SysLog> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 日志ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String logId;

	/**
	 * @Fields  : 操作识别ID
	 */
	private String actWidgetId;

	/**
	 * @Fields  : 操作人员
	 */
	private String user;

	/**
	 * @Fields  : 操作开始时间
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMddHHmmss)
	private Date startTime;

	/**
	 * @Fields  : 操作结束时间
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMddHHmmss)
	private Date endTime;

	/**
	 * @Fields  : 参数信息
	 */
	private String actParamInfo;

	@ExcelTitle(value = "操作识别ID", sort = 1 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getActWidgetId(){
		return this.actWidgetId;
	}

	@ExcelTitle(value = "操作人员", sort = 2)
	public String getUser(){
		return this.user;
	}

	@ExcelTitle(value = "操作开始时间", sort = 3)
	public String getStartTimeStr(){
		return DateUtils.dateToStr(startTime,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "操作结束时间", sort = 4)
	public String getEndTimeStr() {return DateUtils.dateToStr(endTime,DateUtils.formatStr_yyyyMMddHHmmss);}

	@ExcelTitle(value = "参数信息", sort = 5)
	public String getActParamInfo(){
		return actParamInfo;
	}

	@ExcelTitle(value = "更新时间", sort = 6)
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(updateTime,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新人员", sort = 7)
	public String getUpdater(){
		return updater;
	}

}