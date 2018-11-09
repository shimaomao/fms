package cn.com.leadu.fms.activiti.validator.actuserleaveapproval.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.activiti.entity.ActUserLeaveApproval;
import lombok.Data;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: ActUserLeaveApprovalVo
 * @Description: 用户请假审批保存时载体及验证
 * @date 2018-03-20
 */
@Data
public class ActUserLeaveApprovalSaveVo extends BaseVo<ActUserLeaveApproval> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 审批id
	 */
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