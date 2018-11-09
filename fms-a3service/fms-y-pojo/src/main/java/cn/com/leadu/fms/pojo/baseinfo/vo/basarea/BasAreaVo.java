package cn.com.leadu.fms.pojo.baseinfo.vo.basarea;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasArea;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: BasAreaVo
 * @Description: 省市县信息维护载体
 * @date 2018-03-15
 */
@ExcelTitle(value = "省市县信息")
@Data
public class BasAreaVo extends PageQuery<BasArea> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 区域ID
	 */
	private String areaId;

	/**
	 * @Fields  : 区域代码
	 */
	private String areaCode;

	/**
	 * @Fields  : 区域名称
	 */
	private String areaName;

	/**
	 * @Fields  : 区域级别
	 */
	private String areaLevel;

	/**
	 * @Fields  : 父区域代码
	 */
	private String parentAreaCode;
	/**
	 * @Fields  : 上级区名称
	 */
	private String   parentAreaName;

	/**
	 * @Fields  : 区域ID
	 */

	private List<String> areaIds;

	@ExcelTitle(value = "省市县代码", sort = 1, types = {ExcelTypeConstants.ONE, ExcelTypeConstants.TWO})
	public  String getAreaCode(){
		return this.areaCode;
	}

	@ExcelTitle(value = "省市县名称", sort = 2, types = {ExcelTypeConstants.ONE, ExcelTypeConstants.TWO})
	public  String getAreaName(){
		return this.areaName;
	}

	@ExcelTitle(value = "省市县级别", sort = 3, codeType = CommonCodeTypeConstants.BAS_AREA_LEVEL, types = {ExcelTypeConstants.ONE})
	public  String getAreaLevel(){
		return this.areaLevel;
	}

	@ExcelTitle(value = "上级省市县名称", sort = 4, types = {ExcelTypeConstants.ONE})
	public String getParentAreaName(){
		return this.parentAreaName;
	}

	@ExcelTitle(value = "上级省市县代码", sort = 5, types = {ExcelTypeConstants.ONE})
	public String getParentAreaCode(){
		return this.parentAreaCode;
	}

	@ExcelTitle(value = "更新时间", sort = 6, types = {ExcelTypeConstants.ONE})
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(updateTime,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新人员", sort = 7, types = {ExcelTypeConstants.ONE})
	public String getUpdater(){
		return updater;
	}
}