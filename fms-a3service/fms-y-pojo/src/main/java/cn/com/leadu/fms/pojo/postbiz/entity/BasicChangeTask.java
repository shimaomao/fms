package cn.com.leadu.fms.pojo.postbiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author lijunjun
 * @ClassName: BasicChangeTask
 * @Description: 基本信息变更任务实体
 * @date 2018-08-31
 */
@Data
public class BasicChangeTask extends BaseEntity<BasicChangeTask> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 变更任务id
	 * @author lijunjun
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String basicChangeTaskId;

	/**
	 * @Fields  : 变更任务号
	 * @author lijunjun
	 */
	private String basicTaskNo;

	/**
	 * @Fields  : 变更任务状态
	 * @author lijunjun
	 */
	private String basicTaskStatus;

	/**
	 * @Fields  : 任务提交人
	 * @author lijunjun
	 */
	private String submitUser;

	/**
	 * @Fields  : 任务提交时间
	 * @author lijunjun
	 */
	private Date submitDate;

	/**
	 * @Fields  : 当前节点用户
	 * @author lijunjun
	 */
	private String presentUser;

	/**
	 * @Fields  : 申请类型
	 * @author lijunjun
	 */
	private String applyType;

	/**
	 * @Fields  : 申请编号
	 * @author lijunjun
	 */
	private String applyNo;

	/**
	 * @Fields  : 备注
	 * @author lijunjun
	 */
	private String remark;

}