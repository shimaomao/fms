package cn.com.leadu.fms.activiti.validator.actuserleave.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.activiti.entity.ActUserLeave;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: ActUserLeaveVo
 * @Description: 用户请假修改时载体及验证
 * @date 2018-03-14
 */
@Data
public class ActUserLeaveModifyVo extends BaseVo<ActUserLeave> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 请假id
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String leaveId;

	/**
	 * @Fields  : 请假标题
	 */
	private String leaveTitle;

	/**
	 * @Fields  : 请假天数
	 */
	private Integer leaveDay;

	/**
	 * @Fields  : 请假原因
	 */
	private String leaveRemark;

	/**
	 * @Fields  : 请假用户
	 */
	private String sysUserId;

}