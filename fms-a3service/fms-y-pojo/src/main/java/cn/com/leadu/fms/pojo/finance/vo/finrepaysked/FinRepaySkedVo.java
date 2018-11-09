package cn.com.leadu.fms.pojo.finance.vo.finrepaysked;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.entity.FinRepaySked;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: FinRepaySkedVo
 * @Description: 财务还款计划载体
 * @date 2018-05-12
 */
@Data
public class FinRepaySkedVo extends PageQuery<FinRepaySked> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 扣款ID
	 * @author lijunjun
	 */
	private String finRepaySkedId;

	/**
	 * @Fields  : 合同编号
	 * @author lijunjun
	 */
	private String contNo;

	/**
	 * @Fields  : 期数
	 * @author lijunjun
	 */
	private Integer period;

	/**
	 * @Fields  : 成交日期
	 * @author lijunjun
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date dealDate;

	/**
	 * @Fields  : 收款日期
	 * @author lijunjun
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date repayDate;

	/**
	 * @Fields  : 月利率
	 * @author lijunjun
	 */
	private BigDecimal intrstMonthRate;

	/**
	 * @Fields  : 每期客户租金
	 * @author lijunjun
	 */
	private BigDecimal rent;

	/**
	 * @Fields  : 应收租金
	 * @author lijunjun
	 */
	private BigDecimal rentActual;

	/**
	 * @Fields  : 当期本金
	 * @author lijunjun
	 */
	private BigDecimal principal;

	/**
	 * @Fields  : 当期利息
	 * @author lijunjun
	 */
	private BigDecimal interest;

	/**
	 * @Fields  : 当期剩余本金
	 * @author lijunjun
	 */
	private BigDecimal restPrincipal;

	/**
	 * @Fields  : 主营收入
	 * @author lijunjun
	 */
	private BigDecimal revenue;

	/**
	 * @Fields  : 税金
	 * @author lijunjun
	 */
	private BigDecimal tax;

	/**
	 * @Fields  : 扣款状态
	 * @author lijunjun
	 */
	private String repayStatus;

	/**
	 * @Fields  : 扣款结算状态
	 * @author lijunjun
	 */
	private String repaySetStatus;

	/**
	 * @Fields  : 收款银行
	 * @author lijunjun
	 */
	private String recAccBank;

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
	 * @Fields  : 到账日期
	 * @author lijunjun
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date receiptDate;

	/**
	 * @Fields  : 扣款ID
	 * @author lijunjun
	 */
	private List<String> finRepaySkedIds;

	/**
	 * @Fields  : 手续费用
	 */
	private BigDecimal charge;

	/**
	 * @Fields  : 开始时间
	 * @author ningyangyang
	 */
	private String startTime;

	/**
	 * @Fields  : 结束时间
	 * @author ningyangyang
	 */
	private String endTime;

	/**
	 * @Fields  : 区域
	 * @author ningyangyang
	 */
	private String groupDistrict;

	/**
	 * @Fields  : 客户姓名
	 * @author ningyangyang
	 */
	private String name;

	/**
	 * @Fields  : 申请类型
	 * @author ningyangyang
	 */
	private String applyType;

	/**
	 * @Fields  : 申请类别
	 * @author ningyangyang
	 */
	private String companyType2;

	/**
	 * @Fields  : 逾期罚息额
	 * @author ningyangyang
	 */
	private BigDecimal overdueAmount;

	/**
	 * @Fields  : 车架号
	 * @author ningyangyang
	 */
	private String vinNo;

	/**
	 * @Fields  : 业务类型
	 * @author ningyangyang
	 */
	private String licenseAttr;

	/**
	 * @Fields  : 发票日期
	 * @author ningyangyang
	 */
	private String invoDate;

	/**
	 * @Fields  : 还款日期
	 * @author ningyangyang
	 */
	private String receDate;

	/**
	 * @Fields  : 备注
	 * @author ningyangyang
	 */
	private String memo;

	/**
	 * @Fields  : 开票日期
	 * @author ningyangyang
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date invoiceDate;

	/**
	 * @Fields  : 开票类型
	 * @author ningyangyang
	 */
	private String invoiceType;

	/**
	 * @Fields  : 所属公司
	 * @author ningyangyang
	 */
	private String groupName;

	/**
	 * @Fields  : 付款金额
	 * @author ningyangyang
	 */
	private BigDecimal receiptAmount;

	/**
	 * @Fields  : 逾期状态
	 * @author lijunjun
	 */
	private String overdueStatus;
	/**
	 * @Fields  : 合同还款实体
	 * @author ningyangyang
	 */
	private List<ContRepaySked> contRepaySkedList;

	/**
	 * @Fields  : 还款状态
	 * @author yanfengbo
	 */
	private String paymentSts;

	/**
	 * @Fields  : 开票属性：是否先开票
	 * @author yangyiquan
	 */
	private String invoiceProp;

	/**
	 * @Fields  : 开始时间(实际还款日)
	 * @author yanfengbo
	 */
	private String startTimeReceiptDate;

	/**
	 * @Fields  : 结束时间(实际还款日)
	 * @author yanfengbo
	 */
	private String endTimeReceiptDate;

	/**
	 * @Fields  : 开票状态
	 * @author yanfengbo
	 */
	private BigDecimal  invoiceStatus;

}