package cn.com.leadu.fms.pojo.prebiz.vo.contpayment;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author liujinge
 * @ClassName: ContConfirmBefVo
 * @Description: 合同生成前确认载体
 * @date 2018-03-23
 */
@Data
public class ContPaymentVo {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  :
	 */
	private String applyNo;

	/**
	 * @Fields  : 
	 */
	private String contNo;

	/**
	 * @Fields  : 
	 */
	private String remark1;

	/**
	 * @Fields  :
	 */
	private String user;


	/**
	 * @Fields  :
	 */
	private BigDecimal payAmount;


	/**
	 * @Fields  :
	 */
	private String recAccBank;

	/**
	 * @Fields  :
	 */
	private String recAccountNo;

	/**
	 * @Fields  :
	 */
	private String recAccountName;


	/**
	 * @Fields  :付款银行
	 */
	private String accBank;

	/**
	 * @Fields  :付款银行
	 */
	private String accountNo;

	/**
	 * @Fields  : 财务取款退回原因
	 */
	private String contPaymentReason;

	/**
	 * @Fields  : 财务取款退回原因key
	 */
	private String contPaymentReasonKey;

	/**
	 * @Fields  :
	 */
	private String taskId;

	/**
	 * @Fields  :
	 */
	private String applyType;









}