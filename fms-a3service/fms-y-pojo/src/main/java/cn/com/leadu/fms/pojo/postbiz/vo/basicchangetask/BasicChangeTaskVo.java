package cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.BasicChangeTask;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: BasicChangeTaskVo
 * @Description: 基本信息变更任务载体
 * @date 2018-08-31
 */
@Data
public class BasicChangeTaskVo extends PageQuery<BasicChangeTask> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 变更任务id
	 * @author lijunjun
	 */
	private String basicChangeTaskId;

	/**
	 * @Fields  : 变更任务号
	 * @author lijunjun
	 */
	private String basicTaskNo;

	/**
	 * @Fields  : 变更任务状态
	 * @author lijunjun
	 */
	private String basicTaskStatus;

	/**
	 * @Fields  : 任务提交人
	 * @author lijunjun
	 */
	private String submitUser;

	/**
	 * @Fields  : 任务提交时间
	 * @author lijunjun
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date submitDate;

	/**
	 * @Fields  : 当前节点用户
	 * @author lijunjun
	 */
	private String presentUser;

	/**
	 * @Fields  : 申请类型
	 * @author lijunjun
	 */
	private String applyType;

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
	private List<String> personChangeTaskIds;

	/**
	 * 合同编号
	 */
	private String contNo;

	/**
	 * 承租人
	 */
	private String name;

	/**
	 * 车架号
	 */
	private String vinNo;

	/**
	 * 合同状态
	 */
	private String bizStatus;

	/**
	 * 任务号
	 */
	private String taskNo;

	/**
	 * 任务状态
	 */
	private String taskStatus;

	/**
	 * 变更类型
	 */
	private String changeType;

	/**
	 * 变更后承租人
	 */
	private String newName;

	/**
	 * 展期期限
	 */
	private String deferMaturity;

	/**
	 * 展期金额
	 */
	private BigDecimal deferAmount;

	/**
	 * 展期金额
	 */
	private BigDecimal supplementDeposit;

	/**
	 * 还款状态
	 */
	private String paymentSts;
	/**
	 * 用户集合
	 */
	private List<String> userList;
}