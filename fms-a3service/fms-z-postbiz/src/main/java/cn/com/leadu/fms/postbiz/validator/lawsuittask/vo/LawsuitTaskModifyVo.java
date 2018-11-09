package cn.com.leadu.fms.postbiz.validator.lawsuittask.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.LawsuitTask;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: LawsuitTaskVo
 * @Description: 诉讼任务信息修改时载体及验证
 */
@Data
public class LawsuitTaskModifyVo extends BaseVo<LawsuitTask> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 诉讼任务id
	 * @author lijunjun
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
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
	private Date lawsuitEndDate;

	/**
	 * @Fields  : 诉讼结案备注
	 * @author lijunjun
	 */
	private String remark;

	/**
	 * @Fields  : 诉讼结案备注
	 * @author lijunjun
	 */
	private String lawsuitEndRemark;

}