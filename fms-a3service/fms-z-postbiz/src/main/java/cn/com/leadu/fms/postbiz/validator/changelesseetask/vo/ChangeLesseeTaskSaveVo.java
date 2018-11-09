package cn.com.leadu.fms.postbiz.validator.changelesseetask.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.ChangeLesseeTask;
import lombok.Data;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: ChangeLesseeTaskVo
 * @Description: 承租人变更保存时载体及验证
 */
@Data
public class ChangeLesseeTaskSaveVo extends BaseVo<ChangeLesseeTask> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 变更任务id
	 * @author ningyangyang
	 */
	private String taskId;

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

}