package cn.com.leadu.fms.finance.validator.finrepaysked.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.FinRepaySked;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: FinRepaySkedVo
 * @Description: 财务还款计划保存时载体及验证
 * @date 2018-05-12
 */
@Data
public class FinRepaySkedSaveVo extends BaseVo<FinRepaySked> {

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
	private Date receiptDate;

}