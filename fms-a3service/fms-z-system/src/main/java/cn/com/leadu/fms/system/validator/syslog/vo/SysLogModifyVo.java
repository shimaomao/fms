package cn.com.leadu.fms.system.validator.syslog.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysLog;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * @author yanfengbo
 * @ClassName: SysLogVo
 * @Description: 日志管理修改时载体及验证
 * @date 2018-04-10
 */
@Data
public class SysLogModifyVo extends BaseVo<SysLog> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 日志ID
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
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
	private Date startTime;

	/**
	 * @Fields  : 操作结束时间
	 */
	private Date endTime;

	/**
	 * @Fields  : 参数信息
	 */
	private String actParamInfo;

}