package cn.com.leadu.fms.finance.validator.contoverdue.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.ContOverdue;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: ContOverdueVo
 * @Description: 还款逾期罚息保存时载体及验证
 * @date 2018-05-08
 */
@Data
public class ContOverdueSaveVo extends BaseVo<ContOverdue> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 逾期罚息Id
	 * @author lijunjun
	 */
	private String contOverdueId;

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
	 * @Fields  : 逾期天数
	 * @author lijunjun
	 */
	private Integer overdueDays;

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
	 * @Fields  : 到账日期
	 * @author lijunjun
	 */
	private Date receiptDate;

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
	 * @Fields  : 扣款状态
	 * @author lijunjun
	 */
	private String repayStatus;

}