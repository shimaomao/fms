package cn.com.leadu.fms.pojo.system.vo.syslog;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysLog;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: SysLogVo
 * @Description: 日志管理载体
 * @date 2018-03-22
 */
@Data
public class SysLogVo extends PageQuery<SysLog> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 日志ID
	 */
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

	/**
	 * @Fields  : 日志ID
	 */
	private List<String> logIds;

}