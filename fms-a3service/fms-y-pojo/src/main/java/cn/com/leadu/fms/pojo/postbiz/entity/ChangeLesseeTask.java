package cn.com.leadu.fms.pojo.postbiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: ChangeLesseeTask
 * @Description: 承租人变更实体
 */
@Data
public class ChangeLesseeTask extends BaseEntity<ChangeLesseeTask> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 变更任务id
	 * @author ningyangyang
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String changeTaskId;

	/**
	 * @Fields  : 变更任务号
	 * @author ningyangyang
	 */
	private String taskNo;

	/**
	 * @Fields  : 变更任务状态
	 * @author ningyangyang
	 */
	private String taskStatus;

	/**
	 * @Fields  : 合同号
	 * @author ningyangyang
	 */
	private String contNo;

	/**
	 * @Fields  : 当前节点用户
	 * @author ningyangyang
	 */
	private String presentUser;

	/**
	 * @Fields  : 任务提出人
	 * @author ningyangyang
	 */
	private String submitUser;

	/**
	 * @Fields  : 任务提出时间
	 * @author ningyangyang
	 */
	private Date submitDate;

	/**
	 * @Fields  : 变更原因说明
	 * @author ningyangyang
	 */
	private String changeReason;

	/**
	 * @Fields  : 企业类型1
	 * @author ningyangyang
	 */
	private String companyType1;

	/**
	 * @Fields  : 企业类型2
	 * @author ningyangyang
	 */
	private String companyType2;

	/**
	 * @Fields  : 审批备注
	 * @author ningyangyang
	 */
	private String remark;

	/**
	 * @Fields  : 申请类型
	 * @author ningyangyang
	 */
	private String applyType;

}