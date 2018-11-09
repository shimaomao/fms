package cn.com.leadu.fms.pojo.postbiz.vo.lawsuittask;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.LawsuitTask;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: LawsuitTaskVo
 * @Description: 诉讼任务信息载体
 */
@Data
public class LawsuitTaskVo extends PageQuery<LawsuitTask> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 诉讼任务id
	 * @author lijunjun
	 */
	private String lawsuitTaskId;

	/**
	 * @Fields  : 诉讼任务号
	 * @author lijunjun
	 */
	private String lawsuitTaskNo;

	/**
	 * @Fields  : 诉讼任务状态
	 * @author lijunjun
	 */
	private String lawsuitTaskStatus;

	/**
	 * @Fields  : 当前节点用户
	 * @author lijunjun
	 */
	private String presentUser;

	/**
	 * @Fields  : 逾期合同ID
	 * @author lijunjun
	 */
	private String overdueContId;

	/**
	 * @Fields  : 合同号
	 * @author lijunjun
	 */
	private String contNo;

	/**
	 * @Fields  : 任务发起人
	 * @author lijunjun
	 */
	private String submitUser;

	/**
	 * @Fields  : 任务发起时间
	 * @author lijunjun
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date submitDate;

	/**
	 * @Fields  : 诉讼类型
	 * @author lijunjun
	 */
	private String lawsuitType;

	/**
	 * @Fields  : 诉讼原因
	 * @author lijunjun
	 */
	private String lawsuitReason;

	/**
	 * @Fields  : 诉讼金额
	 * @author lijunjun
	 */
	private BigDecimal lawsuitAmount;

	/**
	 * @Fields  : 诉讼发起时间
	 * @author lijunjun
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date lawsuitSponsorDate;

	/**
	 * @Fields  : 诉讼地址
	 * @author lijunjun
	 */
	private String lawsuitAddr;

	/**
	 * @Fields  : 被告人
	 * @author lijunjun
	 */
	private String defendant;

	/**
	 * @Fields  : 派单类型
	 * @author lijunjun
	 */
	private String dispatchType;

	/**
	 * @Fields  : 派单人
	 * @author lijunjun
	 */
	private String dispatchUser;

	/**
	 * @Fields  : 登记人
	 * @author lijunjun
	 */
	private String registerUser;

	/**
	 * @Fields  : 第三方机构名称
	 * @author lijunjun
	 */
	private String tollyName;

	/**
	 * @Fields  : 第三方机构联系人
	 * @author lijunjun
	 */
	private String tollyContactName;

	/**
	 * @Fields  : 第三方机构联系电话
	 * @author lijunjun
	 */
	private String tollyMobileNo;

	/**
	 * @Fields  : 结案原因
	 * @author lijunjun
	 */
	private String lawsuitEndReason;

	/**
	 * @Fields  : 结案时间
	 * @author lijunjun
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date lawsuitEndDate;

	/**
	 * @Fields  : 备注
	 * @author lijunjun
	 */
	private String remark;

	/**
	 * @Fields  : 诉讼结案备注
	 * @author lijunjun
	 */
	private String lawsuitEndRemark;

	/**
	 * @Fields  : 诉讼任务id
	 * @author lijunjun
	 */
	private List<String> lawsuitTaskIds;

	/**
	 * @Fields  : 车架号
	 * @author lijunjun
	 */
	private String vinNo;

}