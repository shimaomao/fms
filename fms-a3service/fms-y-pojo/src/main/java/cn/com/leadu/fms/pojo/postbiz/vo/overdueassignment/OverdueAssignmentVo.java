package cn.com.leadu.fms.pojo.postbiz.vo.overdueassignment;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueAssignment;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author lijunjun
 * @ClassName: OverdueAssignmentVo
 * @Description: 当日逾期任务信息载体
 * @date 2018-05-16
 */
@Data
public class OverdueAssignmentVo extends PageQuery<OverdueAssignment> {

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

	/**
	 * @Fields  : 作废日期
	 * @author wangxue
	 */
	private Date cancelDate;

	/**
	 * @Fields  : 逾期任务ID
	 * @author lijunjun
	 */
	private List<String> overdueAssignmentIds;

}