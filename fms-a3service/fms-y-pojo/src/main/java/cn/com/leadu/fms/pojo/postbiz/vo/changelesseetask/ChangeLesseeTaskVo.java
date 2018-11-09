package cn.com.leadu.fms.pojo.postbiz.vo.changelesseetask;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.ChangeLesseeTask;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: ChangeLesseeTaskVo
 * @Description: 承租人变更载体
 */
@Data
public class ChangeLesseeTaskVo extends PageQuery<ChangeLesseeTask> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 变更任务id
	 * @author ningyangyang
	 */
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
	 * @Fields  : 变更任务id
	 * @author ningyangyang
	 */
	private List<String> taskIds;

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

	/**
	 * @Fields  : 备注
	 * @author ningyangyang
	 */
	private String Memo;

	/**
	 * @Fields  : taskId
	 * @author ningyangyang
	 */
	private String taskId;

	/**
	 * @Fields  : 旧的申请编号
	 * @author ningyangyang
	 */
	private String applyNo;

	/**
	 * @Fields  : 变更承租人合同生成附件
	 * @author
	 */
	private List<BizFiles> contGenerateFilesList;

	/**
	 * @Fields  : 变更承租人合同打印附件
	 * @author
	 */
	private List<BizFiles> contPrintFilesList;

	/**
	 * @Fields  : 申请信息载体
	 * @author
	 */
	private ApplyInputVo applyInputVo;

}