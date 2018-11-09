package cn.com.leadu.fms.pojo.system.entity;

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
 * @author wangxue
 * @ClassName: SysGroupLevelDao
 * @Description: 用户组层级实体
 * @date 2018-03-08
 */
@ExcelTitle(value = "用户组层级信息")
@Data
public class SysGroupLevel extends BaseEntity<SysGroupLevel> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 层级ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String groupLevId;

	/**
	 * @Fields  : 层级代码
	 */
	private String groupLev;

	/**
	 * @Fields  : 层级名称
	 */
	private String groupLevName;

	/**
	 * @Fields  : 启用标识
	 */
	private String enableFlag;

	@ExcelTitle(value = "层级代码", sort = 1)
	public String getGroupLev(){
		return groupLev;
	}

	@ExcelTitle(value = "层级名称", sort = 2)
	public String getGroupLevName(){
		return groupLevName;
	}

	@ExcelTitle(value = "启用标志", sort = 3 ,codeType = CommonCodeTypeConstants.COMMON_STATUS)
	public String getEnableFlag(){
		return enableFlag;
	}

	@ExcelTitle(value = "更新时间", sort = 4, types = {ExcelTypeConstants.ONE})
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(updateTime,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新人员", sort = 5, types = {ExcelTypeConstants.ONE})
	public String getUpdater(){
		return updater;
	}

}