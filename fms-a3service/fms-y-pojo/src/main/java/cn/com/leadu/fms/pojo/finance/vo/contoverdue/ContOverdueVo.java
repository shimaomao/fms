package cn.com.leadu.fms.pojo.finance.vo.contoverdue;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.entity.ContOverdue;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: ContOverdueVo
 * @Description: 还款逾期罚息载体
 * @date 2018-05-08
 */
@Data
public class ContOverdueVo extends PageQuery<ContOverdue> {

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

	/**
	 * @Fields  : 逾期罚息Id
	 * @author lijunjun
	 */
	private List<String> contOverdueIds;

	/**
	 * @Fields  : 租金
	 * @author lijunjun
	 */
	private BigDecimal rent;

	/**
	 * @Fields  : 免除金额
	 */
	private BigDecimal manualExemptAmount;

	/**
	 * @Fields  : 申请编号
	 * @author lijunjun
	 */
	private String applyNo;

	/**
	 * @Fields  : 车架号
	 * @author lijunjun
	 */
	private String vinNo;

	/**
	 * @Fields  : 承租人
	 */
	private String cstmName;

	/**
	 * @Fields  : 每期客户租金
	 */
	private BigDecimal eachRent;

	/**
	 * @Fields  : 开票日期
	 * @author yangyiquan
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date invoiceDate;

	/**
	 * @Fields  : 备注
	 * @author yangyiquan
	 */
	private String memo;

	/**
	 * @Fields  : 收款日期
	 * @author yanfengbo
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date repayDate;

	/**
	 * @Fields  : 最大逾期天数
	 * @author lijunjun
	 */
	private Integer overdueDaysMax;

	/**
	 * @Fields  : 罚息总额
	 * @author lijunjun
	 */
	private BigDecimal overdueAmountSum;

	/**
	 * @Fields  :出租人
	 */
	private String groupName;

	/**
	 * @Fields  :出租人区域
	 */
	private String groupDistrict;

	/**
	 * @Fields  : 还款日期string类型
	 * @author yanfengbo
	 */
	private String repayDateStr;

	/**
	 * @Fields  : 查询条件期数 大于等于
	 * @author qiaomengnan
	 */
	private Integer gtSurplusPeriod;

	/**
	 * @Fields  : 查询条件期数 小于等于
	 * @author qiaomengnan
	 */
	private Integer ltSurplusPeriod;

	/**
	 * @Fields  : 剩余期数
	 * @author qiaomengnan
	 */
	private Integer surplusPeriod;

	/**
	 * @Fields  : 罚息免除任务明细表id
	 * @author yanfengbo
	 */
	private String overdueExemptDetailId;
}