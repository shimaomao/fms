package cn.com.leadu.fms.postbiz.validator.overdueassignment.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueAssignment;
import lombok.Data;
import java.util.Date;

/**
 * @author lijunjun
 * @ClassName: OverdueAssignmentVo
 * @Description: 当日逾期任务信息保存时载体及验证
 * @date 2018-05-16
 */
@Data
public class OverdueAssignmentSaveVo extends BaseVo<OverdueAssignment> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 逾期任务ID
	 * @author lijunjun
	 */
	private String overdueAssignmentId;

	/**
	 * @Fields  : 逾期客户ID
	 * @author lijunjun
	 */
	private String overdueCstmId;

	/**
	 * @Fields  : 分配日期
	 * @author lijunjun
	 */
	private Date assignDate;

	/**
	 * @Fields  : 催收类型
	 * @author lijunjun
	 */
	private String assignmentType;

	/**
	 * @Fields  : 分配人员账号
	 * @author lijunjun
	 */
	private String assignUser;

	/**
	 * @Fields  : 是否新进数
	 * @author lijunjun
	 */
	private String fistOverdueFlag;

	/**
	 * @Fields  : 任务处理状态
	 * @author lijunjun
	 */
	private String assignmentSts;

}