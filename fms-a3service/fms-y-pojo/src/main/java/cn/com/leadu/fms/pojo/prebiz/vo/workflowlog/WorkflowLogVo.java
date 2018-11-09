package cn.com.leadu.fms.pojo.prebiz.vo.workflowlog;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import lombok.Data;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: WorkflowLogVo
 * @Description: 审批备注日志载体
 * @date 2018-03-28
 */
@Data
public class WorkflowLogVo extends PageQuery<WorkflowLog> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 日志ID
	 */
	private String wfLogId;

	/**
	 * @Fields  : 日志类型
	 */
	private String wfLogType;

	/**
	 * @Fields  : 业务任务号
	 */
	private String wfLogNo;

	/**
	 * @Fields  : 业务子任务号
	 */
	private String wfLogSubNo;

	/**
	 * @Fields  : 操作人账号
	 */
	private String user;

	/**
	 * @Fields  : 操作人姓名
	 */
	private String userName;

	/**
	 * @Fields  : 操作
	 */
	private String actWidgetId;

	/**
	 * @Fields  :操作名称
	 */
	private String actWidgetName;

	/**
	 * @Fields  : 操作分类
	 */
	private String actType;

	/**
	 * @Fields  : 操作后状态
	 */
	private String status;

	/**
	 * @Fields  : 备注分类类型1
	 */
	private String codeType1;

	/**
	 * @Fields  : 备注分类值1
	 */
	private String codeValue1;

	/**
	 * @Fields  : 备注分类类型2
	 */
	private String codeType2;

	/**
	 * @Fields  : 备注分类值2
	 */
	private String codeValue2;

	/**
	 * @Fields  : 备注内容1
	 */
	private String remark1;

	/**
	 * @Fields  : 备注内容2
	 */
	private String remark2;

	/**
	 * @Fields  : 日志ID
	 */
	private List<String> wfLogIds;

}