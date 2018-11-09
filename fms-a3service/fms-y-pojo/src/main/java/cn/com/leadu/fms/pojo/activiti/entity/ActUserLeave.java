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
 * @ClassName: ActUserLeave
 * @Description: 用户请假实体
 * @date 2018-03-14
 */
@Data
public class ActUserLeave extends BaseEntity<ActUserLeave> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 请假id
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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

	/** 
	 * @Fields  : 请假状态(0.正在审批中 1.通过 2.拒绝)
	 */ 
	private Integer leaveStatus;

}