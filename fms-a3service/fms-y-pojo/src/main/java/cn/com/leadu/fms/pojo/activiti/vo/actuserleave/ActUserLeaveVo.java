package cn.com.leadu.fms.pojo.activiti.vo.actuserleave;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.activiti.entity.ActUserLeave;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: ActUserLeaveVo
 * @Description: 用户请假载体
 * @date 2018-03-14
 */
@Data
public class ActUserLeaveVo extends PageQuery<ActUserLeave> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 请假id
	 */
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
	 * @Fields  : 请假id
	 */
	private List<String> leaveIds;

	/**
	 * @Fields  : 请假用户
	 */
	private String sysUserId;

	/**
	 * @Fields  : 请假状态(0.正在审批中 1.通过 2.拒绝)
	 */
	private Integer leaveStatus;

}