package cn.com.leadu.fms.postbiz.validator.defertask.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.DeferTask;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ningyangyang
 * @ClassName: DeferTaskVo
 * @Description: 合同展期保存时载体及验证
 */
@Data
public class DeferTaskSaveVo extends BaseVo<DeferTask> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 展期任务id
	 * @author ningyangyang
	 */
	private String deferTaskId;

	/**
	 * @Fields  : 展期任务号
	 * @author ningyangyang
	 */
	private String deferTaskNo;

	/**
	 * @Fields  : 展期任务状态
	 * @author ningyangyang
	 */
	private String deferTaskStatus;

	/**
	 * @Fields  : 合同编号
	 * @author ningyangyang
	 */
	private String contNo;

	/**
	 * @Fields  : 当前节点用户
	 * @author ningyangyang
	 */
	private String presentUser;

	/**
	 * @Fields  : 展期金额
	 * @author ningyangyang
	 */
	private BigDecimal deferAmount;

	/**
	 * @Fields  : 展期期限
	 * @author ningyangyang
	 */
	private String deferMaturity;

	/**
	 * @Fields  : 利率
	 * @author ningyangyang
	 */
	private BigDecimal interestRate;

	/**
	 * @Fields  : 还款日
	 * @author ningyangyang
	 */
	private String repayDate;

	/**
	 * @Fields  : 月供
	 * @author ningyangyang
	 */
	private BigDecimal rent;

	/**
	 * @Fields  : irr
	 * @author ningyangyang
	 */
	private BigDecimal irr;

	/**
	 * @Fields  : 展期申请提出日期
	 * @author ningyangyang
	 */
	private Date deferSubmitDate;

	/**
	 * @Fields  : 展期申请提出用户
	 * @author ningyangyang
	 */
	private String deferSubmitUser;

}