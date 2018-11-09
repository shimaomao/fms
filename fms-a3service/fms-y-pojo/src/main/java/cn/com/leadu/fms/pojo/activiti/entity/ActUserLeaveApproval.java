package cn.com.leadu.fms.pojo.activiti.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: ActUserLeaveApproval
 * @Description: 用户请假审批实体
 * @date 2018-03-20
 */
@Data
public class ActUserLeaveApproval extends BaseEntity<ActUserLeaveApproval> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 审批id
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String approvalId;

	/**
	 * @Fields  : 审批备注
	 */
	private String approvalRemark;

	/**
	 * @Fields  : 审批人id
	 */
	private String sysUserId;

	/**
	 * @Fields  : 所属职位名称
	 */
	private String sysOrganizationName;

	/**
	 * @Fields  : 审批状态(0.通过 1.拒绝)
	 */
	private Integer approvalStatus;

}