package cn.com.leadu.fms.pojo.finance.vo.contreceipt;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: ContReceiptVo
 * @Description: 黑名单载体
 * @date 2018-05-07
 */
@Data
public class ContReceiptPostVo extends PageQuery<ContReceipt> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 财务收款Id
	 * @author lijunjun
	 */
	private String contReceiptId;

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
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date receiptDate;

	/**
	 * @Fields  : 到账日期检索项
	 * @author lijunjun
	 */
	private String receiptDateSearch;

	/**
	 * @Fields  : 到账时刻
	 * @author lijunjun
	 */
	@JsonFormat(pattern = DateUtils.formatStr_HHmmss)
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

	/**
	 * @Fields  : 财务收款Id
	 * @author lijunjun
	 */
	private List<String> contReceiptIds;

	/**
	 * @Fields  : 收款明细List
	 * @author lijunjun
	 */
	private List<ContReceiptVo> contReceiptVoList;

	/**
	 * @Fields  : 处理区分
	 * @author lijunjun
	 */
	private String solveFlag;

	/**
	 * @Fields  : 待勾稽租金List
	 * @author lijunjun
	 */
	private List<ContRepaySkedVo> contRepaySkedVoList;
}