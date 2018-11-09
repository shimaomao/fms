package cn.com.leadu.fms.pojo.prebiz.entity;

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
 * @author liujinge
 * @ClassName: ContRepaySked
 * @Description: 客户还款计划表实体
 * @date 2018-04-10
 */
@Data
@EqualsAndHashCode(of = { "repaySkedId" })
public class ContRepaySked extends BaseEntity<ContRepaySked> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 还款计划表ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String repaySkedId;

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
	 * @Fields  : 扣款状态
	 */
	private String repayStatus;

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
	 * @Fields  : 财务租金
	 * @author lijunjun
	 */
	private BigDecimal finRent;

	/**
	 * @Fields  : 财务本金
	 * @author lijunjun
	 */
	private BigDecimal finRprincipal;

	/**
	 * @Fields  : 财务利息
	 * @author lijunjun
	 */
	private BigDecimal finRinterest;

	/**
	 * @Fields  : 财务剩余本金
	 * @author lijunjun
	 */
	private BigDecimal finRestPrincipal;

	/**
	 * @Fields  : 财务主营收入
	 * @author lijunjun
	 */
	private BigDecimal finRevenue;

	/**
	 * @Fields  : 财务税金
	 * @author lijunjun
	 */
	private BigDecimal finRtax;

	/**
	 * @Fields  : 到账金额
	 * @author ningyangyang
	 */
	private BigDecimal  receiptAmount;

    /**
     * @Fields  : 抵扣金额
     * @author yangyiquan
     */
    private BigDecimal  deductionAmount;

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
	 * @Fields  : 还款类别
	 * @author yangyiquan
	 */
	private String repayType;

	/**
	 * @Fields  : 开票属性：是否先开票
	 * @author yangyiquan
	 */
	private String invoiceProp;

}