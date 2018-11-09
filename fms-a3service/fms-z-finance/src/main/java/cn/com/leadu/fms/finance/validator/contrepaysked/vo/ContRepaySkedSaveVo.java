package cn.com.leadu.fms.finance.validator.contrepaysked.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: ContRepaySkedVo
 * @Description: 黑名单保存时载体及验证
 * @date 2018-05-08
 */
@Data
public class ContRepaySkedSaveVo extends BaseVo<ContRepaySked> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 还款计划表ID
	 * @author lijunjun
	 */
	private String repaySkedId;

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
	private Date dealDate;

	/**
	 * @Fields  : 收款日期
	 * @author lijunjun
	 */
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
	 * @Fields  : 手续费用
	 * @author lijunjun
	 */
	private BigDecimal charge;

	/**
	 * @Fields  : 当期剩余本金
	 * @author lijunjun
	 */
	private BigDecimal restPrincipal;

	/**
	 * @Fields  : 逾期日利率
	 * @author lijunjun
	 */
	private BigDecimal overdueDayRate;

	/**
	 * @Fields  : 逾期金额
	 * @author lijunjun
	 */
	private BigDecimal overdueAmount;

	/**
	 * @Fields  : 扣款状态
	 * @author lijunjun
	 */
	private String repayStatus;

	/**
	 * @Fields  : 逾期状态
	 * @author lijunjun
	 */
	private String overdueStatus;

	/**
	 * @Fields  : 暂不扣款标志
	 * @author lijunjun
	 */
	private String repayFlag;

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
	 * @Fields  : 保证金
	 * @author lijunjun
	 */
	private BigDecimal deposit;

	/**
	 * @Fields  : 每期客户实际租金
	 * @author lijunjun
	 */
	private BigDecimal rentActual;

	/**
	 * @Fields  : 到账日期
	 * @author lijunjun
	 */
	private Date receiptDate;

	/**
	 * @Fields  : 到账金额
	 * @author ningyangyang
	 */
	private BigDecimal  receiptAmount;

}