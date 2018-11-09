package cn.com.leadu.fms.pojo.postbiz.vo.overduecstm;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstm;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmVo
 * @Description: 【逾期总额】合同还款计划表关联逾期罚息表
 * @date 2018-05-16
 */
@Data
public class ContRepaySkedOverdueTotalVo extends PageQuery<OverdueCstm> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 合同编号
	 */
	private String contNo;

	/**
	 * @Fields  : 期数
	 */
	private Integer period;

	/**
	 * @Fields  : 成交日期
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date dealDate;

	/**
	 * @Fields  : 收款日期
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date repayDate;

	/**
	 * @Fields  : 月利率
	 */
	private BigDecimal intrstMonthRate;

	/**
	 * @Fields  : 每期客户租金
	 */
	private BigDecimal rent;

	/**
	 * @Fields  : 当期本金
	 */
	private BigDecimal principal;

	/**
	 * @Fields  : 当期利息
	 */
	private BigDecimal interest;

	/**
	 * @Fields  : 手续费用
	 */
	private BigDecimal charge;

	/**
	 * @Fields  : 当期剩余本金
	 */
	private BigDecimal restPrincipal;

	/**
	 * @Fields  : 租金扣款状态
	 */
	private String rentRepayStatus;

	/**
	 * @Fields  : 逾期状态
	 */
	private String overdueStatus;

	/**
	 * @Fields  : 暂不扣款标志
	 */
	private String repayFlag;

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
	 * @Fields  : 保证金
	 */
	private BigDecimal deposit;

	/**
	 * @Fields  : 每期客户实际租金
	 */
	private BigDecimal rentActual;

	/**
	 * @Fields  : 到账日期
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date receiptDate;

	/**
	 * @Fields  : 逾期日利率
	 * @author lijunjun
	 */
	private BigDecimal overdueDayRate;

	/**
	 * @Fields  : 罚息金额
	 * @author lijunjun
	 */
	private BigDecimal overdueAmount;

	/**
	 * @Fields  : 罚息已收金额
	 * @author lijunjun
	 */
	private BigDecimal receiptAmount;

	/**
	 * @Fields  : 罚息免除金额
	 * @author lijunjun
	 */
	private BigDecimal exemptAmount;

	/**
	 * @Fields  : 剩余罚息金额
	 * @author lijunjun
	 */
	private BigDecimal restOverdueAmount;

	/**
	 * @Fields  : 罚息扣款状态
	 * @author lijunjun
	 */
	private String overdueRepayStatus;

	/**
	 * @Fields  : 逾期天数
	 * @author lijunjun
	 */
	private Integer overdueDays;
}