package cn.com.leadu.fms.pojo.prebiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author liujinge
 * @ClassName: WorkflowLog
 * @Description: 审批备注日志实体
 * @date 2018-03-28
 */
@Data
public class WorkflowLog extends BaseEntity<WorkflowLog> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 日志ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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
	 * @Fields  : 操作
	 */
	private String actWidgetId;

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

}