package cn.com.leadu.fms.pojo.finance.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import cn.com.leadu.fms.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: ContOverdue
 * @Description: 还款逾期罚息实体
 * @date 2018-05-08
 */
@Data
@EqualsAndHashCode(of = { "contOverdueId" })
public class ContOverdue extends BaseEntity<ContOverdue> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 逾期罚息Id
	 * @author lijunjun
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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
	 * @Fields  : 开票日期
	 * @author yangyiquan
	 */
	/*@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date invoiceDate;*/

	/**
	 * @Fields  : 备注
	 * @author yangyiquan
	 */
	private String memo;

	/**
	 * @Fields  : 开票日期
	 * @author yanfengbo
	 */
}