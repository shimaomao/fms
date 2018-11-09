package cn.com.leadu.fms.pojo.original.vo.borrowbacktask;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.original.entity.BorrowBackTask;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileDetailVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: BorrowBackTaskVo
 * @Description: 借阅归还任务信息载体
 * @date 2018-06-04
 */
@Data
public class BorrowBackTaskVo extends PageQuery<BorrowBackTask> {

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
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date postDate;

	/**
	 * @Fields  : 邮寄人员
	 * @author lijunjun
	 */
	private String postMember;

	/**
	 * @Fields  : 借阅归还任务id
	 * @author lijunjun
	 */
	private List<String> borrowBackTaskIds;

	/**
	 * @Fields  : 收款银行
	 * @author lijunjun
	 */
	private String recAccBank;
	/**
	 * @Fields  : 收款银行
	 * @author lijunjun
	 */
	private String recAccBranch;
	/**
	 * @Fields  : 收款账号
	 * @author lijunjun
	 */
	private String recAccountNo;

	/**
	 * @Fields  : 收款户名
	 * @author lijunjun
	 */
	private String recAccountName;

	/**
	 * @Fields  : 收款联行号
	 */
	private String recEleBankNo;

	/**
	 * @Fields  : 资料邮寄业务号
	 * @author lijunjun
	 */
	private String bizCode;

	/**
	 * @Fields  : 付款银行
	 * @author lijunjun
	 */
	private String payAccBank;

	/**
	 * @Fields  : 付款银行
	 * @author lijunjun
	 */
	private String payAccBranch;
	/**
	 * @Fields  : 付款银行户名
	 * @author lijunjun
	 */
	private String payAccountName;

	/**
	 * @Fields  : 付款银行账号
	 * @author lijunjun
	 */
	private String payAccountNo;

	/**
	 * @Fields  : 电子联行号
	 * @author lijunjun
	 */
	private String payEleBankNo;

	/**
	 * @Fields  : 任务号
	 * @author lijunjun
	 */
	private String taskId;
	/**
	 * @Fields  : 归档编号
	 * @author lijunjun
	 */
	private String fileRecordNo;
	/**
	 * @Fields  : 资料邮寄附件明细List
	 * @author lijunjun
	 */
	private List<OrigFileDetailVo> origFileDetailVoList;

	/**
	 * @Fields  : 出租人
	 * @author yanfengbo
	 */
	private String groupName;

	/**
	 * @Fields  : 承租人
	 * @author yanfengbo
	 */
	private String cstmName;

	/**
	 * @Fields  : 车架号
	 * @author yanfengbo
	 */
	private String vinNo;
}