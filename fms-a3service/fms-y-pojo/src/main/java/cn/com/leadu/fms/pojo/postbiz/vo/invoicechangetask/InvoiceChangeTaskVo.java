package cn.com.leadu.fms.pojo.postbiz.vo.invoicechangetask;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceChangeTask;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: InvoiceChangeTaskVo
 * @Description: 开票变更任务载体
 * @date 2018-08-29
 */
@Data
public class InvoiceChangeTaskVo extends PageQuery<InvoiceChangeTask> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 变更任务id
	 * @author lijunjun
	 */
	private String invoiceChangeTaskId;

	/**
	 * @Fields  : 变更任务号
	 * @author lijunjun
	 */
	private String invoiceTaskNo;

	/**
	 * @Fields  : 变更任务状态
	 * @author lijunjun
	 */
	private String invoiceTaskStatus;

	/**
	 * @Fields  : 任务提交人
	 * @author lijunjun
	 */
	private String submitUser;

	/**
	 * @Fields  : 任务提交时间
	 * @author lijunjun
	 */
	private Date submitDate;

	/**
	 * @Fields  : 当前节点用户
	 * @author lijunjun
	 */
	private String presentUser;

	/**
	 * @Fields  : 申请编号
	 * @author lijunjun
	 */
	private String applyNo;

	/**
	 * @Fields  : 备注
	 * @author lijunjun
	 */
	private String remark;

	/**
	 * @Fields  : 变更任务id
	 * @author lijunjun
	 */
	private List<String> invoiceChangeTaskIds;

}