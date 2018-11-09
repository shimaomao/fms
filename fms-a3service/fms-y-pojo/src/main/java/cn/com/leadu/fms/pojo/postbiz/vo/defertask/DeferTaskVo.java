package cn.com.leadu.fms.pojo.postbiz.vo.defertask;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.DeferTask;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ningyangyang
 * @ClassName: DeferTaskVo
 * @Description: 合同展期载体
 */
@Data
public class DeferTaskVo extends PageQuery<DeferTask> {

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

	/**
	 * @Fields  : 展期任务id
	 * @author ningyangyang
	 */
	private List<String> deferTaskIds;

	/**
	 * @Fields  : 承租人
	 * @author ningyangyang
	 */
	private String lessee;

	/**
	 * @Fields  : 出租人
	 * @author ningyangyang
	 */
	private String lessor;

	/**
	 * @Fields  : 车架号
	 * @author ningyangyang
	 */
	private String vinNo;

	/**
	 * @Fields  : 融资额
	 * @author ningyangyang
	 */
	private BigDecimal finAmount;

	/**
	 * @Fields  : 融资期限
	 * @author ningyangyang
	 */
	private String finPeriodType;

	/**
	 * @Fields  : 已还金额
	 * @author ningyangyang
	 */
	private BigDecimal alreadyPayAmount;

	/**
	 * @Fields  : 已还期数
	 * @author ningyangyang
	 */
	private Integer alreadyPayPeriod;

	/**
	 * @Fields  : 当前利率
	 * @author ningyangyang
	 */
	private BigDecimal currentInterestRate;

	/**
	 * @Fields  : 保证金
	 * @author ningyangyang
	 */
	private BigDecimal deposit;

	/**
	 * @Fields  : 尾款
	 * @author ningyangyang
	 */
	private BigDecimal balancePayment;

	/**
	 * @Fields  : 备注
	 * @author ningyangyang
	 */
	private String memo;

	/**
	 * @Fields  : 任务号
	 * @author ningyangyang
	 */
	private String taskId;

	/**
	 * @Fields  : 展期合同申请附件信息
	 * @author ningyangyang
	 */
	private List<BizFiles> bizFilesList;

	/**
	 * @Fields  : 展期合同生成附件信息
	 * @author ningyangyang
	 */
	private List<BizFiles> contractGenerateFileList;

	/**
	 * @Fields  : 展期合同打印附件信息
	 * @author ningyangyang
	 */
	private List<BizFiles> contractPrintFileList;


	/**
	 * @Fields  : 业务类型
	 * @author ningyangyang
	 */
	private String licenseAttr;

	/**
	 * @Fields  : 展期保证金
	 * @author ningyangyang
	 */
	private BigDecimal deferDeposit;

	/**
	 * @Fields  : 退还保证金
	 * @author ningyangyang
	 */
	private BigDecimal backDeposit;

	/**
	 * @Fields  : 付款银行
	 */
	private String payAccBank;

	/**
	 * @Fields  : 付款账号
	 */
	private String payAccountNo;

	/**
	 * @Fields  : 付款户名
	 */
	private String payAccountName;

	/**
	 * @Fields  : 付款银行支行
	 */
	private String payAccBranch;


	/**
	 * @Fields  : 收款银行
	 */
	private String recAccBank;

	/**
	 * @Fields  : 收款账号
	 */
	private String recAccountNo;

	/**
	 * @Fields  : 收款户名
	 */
	private String recAccountName;

	/**
	 * @Fields  : 申请类型
	 */
	private String applyType;

	/**
	 * @Fields  : 申请编号
	 */
	private String applyNo;

	/**
	 * @Fields  : 合同附件类型
	 */
	private String FileType;

}