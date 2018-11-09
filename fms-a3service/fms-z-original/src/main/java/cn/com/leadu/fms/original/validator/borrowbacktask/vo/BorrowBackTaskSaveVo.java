package cn.com.leadu.fms.original.validator.borrowbacktask.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.original.entity.BorrowBackTask;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: BorrowBackTaskVo
 * @Description: 借阅归还任务信息保存时载体及验证
 * @date 2018-06-04
 */
@Data
public class BorrowBackTaskSaveVo extends BaseVo<BorrowBackTask> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 借阅归还任务id
	 * @author lijunjun
	 */
	private String borrowBackTaskId;

	/**
	 * @Fields  : 借阅归还任务号
	 * @author lijunjun
	 */
	private String borrowBackTaskNo;

	/**
	 * @Fields  : 借阅任务号
	 * @author lijunjun
	 */
	private String borrowTaskNo;

	/**
	 * @Fields  : 借阅归还任务状态
	 * @author lijunjun
	 */
	private String borrowBackTaskStatus;

	/**
	 * @Fields  : 是否交押金
	 * @author lijunjun
	 */
	private String depositFlag;

	/**
	 * @Fields  : 押金金额
	 * @author lijunjun
	 */
	private BigDecimal depositAmount;

	/**
	 * @Fields  : 当前节点用户
	 * @author yangyiquan
	 */
	private String presentUser;

	/**
	 * @Fields  : 备注
	 * @author lijunjun
	 */
	private String remark;

	/**
	 * @Fields  : 是否抵扣租金
	 * @author lijunjun
	 */
	private String deductFlag;

	/**
	 * @Fields  : 快递公司
	 * @author lijunjun
	 */
	private String postComp;

	/**
	 * @Fields  : 快递编号
	 * @author lijunjun
	 */
	private String postNo;

	/**
	 * @Fields  : 邮寄日期
	 * @author lijunjun
	 */
	private Date postDate;

	/**
	 * @Fields  : 邮寄人员
	 * @author lijunjun
	 */
	private String postMember;

}