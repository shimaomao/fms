package cn.com.leadu.fms.finance.validator.contreceipt.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: ContReceiptVo
 * @Description: 黑名单保存时载体及验证
 * @date 2018-05-07
 */
@Data
public class ContReceiptSaveVo extends BaseVo<ContReceipt> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 财务收款Id
	 * @author lijunjun
	 */
	private String contReceiptId;

	/**
	 * @Fields  : 数据来源
	 * @author lijunjun
	 */
	private String inputMode;

	/**
	 * @Fields  : 付款银行
	 * @author lijunjun
	 */
	private String payAccBank;

	/**
	 * @Fields  : 付款账号
	 * @author lijunjun
	 */
	private String payAccountNo;

	/**
	 * @Fields  : 付款户名
	 * @author lijunjun
	 */
	private String payAccountName;

	/**
	 * @Fields  : 到账日期
	 * @author lijunjun
	 */
	private Date receiptDate;

	/**
	 * @Fields  : 到账时刻
	 * @author lijunjun
	 */
	private Date receiptTime;

	/**
	 * @Fields  : 到账金额
	 * @author lijunjun
	 */
	private BigDecimal receiptAmount;

	/**
	 * @Fields  : 摘要
	 * @author lijunjun
	 */
	private String memo;

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
	 * @Fields  : 收款联行号
	 * @author ningyangyang
	 */
	private String recEleBankNo;

	/**
	 * @Fields  : 剩余金额
	 * @author lijunjun
	 */
	private BigDecimal restAmount;

}