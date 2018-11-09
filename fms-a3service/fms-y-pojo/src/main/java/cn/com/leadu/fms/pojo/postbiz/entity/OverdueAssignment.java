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
 * @ClassName: OverdueAssignment
 * @Description: 当日逾期任务信息实体
 * @date 2018-05-16
 */
@Data
public class OverdueAssignment extends BaseEntity<OverdueAssignment> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 逾期任务ID
	 * @author lijunjun
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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

}