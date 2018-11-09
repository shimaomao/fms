package cn.com.leadu.fms.pojo.finance.entity;

import cn.com.leadu.fms.common.annotation.ExcelImportTitle;
import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import cn.com.leadu.fms.common.util.DateUtils;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: ContReceipt
 * @Description: 财务收款
 * @date 2018-05-07
 */
@Data
public class ContReceipt extends BaseEntity<ContReceipt> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 财务收款Id
	 * @author lijunjun
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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
	@ExcelImportTitle("付款银行")
	private String payAccBank;

	/**
	 * @Fields  : 付款账号
	 * @author lijunjun
	 */
	@ExcelImportTitle("付款账号")
	private String payAccountNo;

	/**
	 * @Fields  : 付款户名
	 * @author lijunjun
	 */
	@ExcelImportTitle("付款户名")
	private String payAccountName;

	/**
	 * @Fields  : 到账日期
	 * @author lijunjun
	 */
	@ExcelImportTitle(value = "到账日期" , dateFormats = {DateUtils.formatStr_yyyyMMdd , DateUtils.formatStr_yyyyMMdd_bias})
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
	@ExcelImportTitle("到账金额")
	private BigDecimal receiptAmount;

	/**
	 * @Fields  : 摘要
	 * @author lijunjun
	 */
	@ExcelImportTitle("付款备注")
	private String memo;

	/**
	 * @Fields  : 收款银行
	 * @author lijunjun
	 */
	@ExcelImportTitle("收款银行")
	private String recAccBank;

	/**
	 * @Fields  : 收款账号
	 * @author lijunjun
	 */
	@ExcelImportTitle("收款账号")
	private String recAccountNo;

	/**
	 * @Fields  : 收款户名
	 * @author lijunjun
	 */
	@ExcelImportTitle("收款户名")
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
	 * @Fields  : 付款银行分行
	 * @author lijunjun
	 */
	private String payAccBranch;

	/**
	 * @Fields  : 收款银行分行
	 * @author lijunjun
	 */
	private String recAccBranch;



	@ExcelTitle(value = "付款银行", sort = 1,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getPayAccBank() { return payAccBank; }

	@ExcelTitle(value = "付款账号", sort = 2,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getPayAccountNo() {return payAccountNo;}

	@ExcelTitle(value = "付款户名", sort = 3,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getPayAccountName() {return payAccountName;}

	@ExcelTitle(value = "到账日期", sort = 4,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getReceiptDateStr() {return DateUtils.dateToStr(receiptDate, DateUtils.formatStr_yyyyMMdd);}

	@ExcelTitle(value = "到账时刻", sort = 5,types = {ExcelTypeConstants.ONE})
	public String getReceiptTimeStr() {return DateUtils.dateToStr(receiptTime, DateUtils.formatStr_HHmmss);}

	@ExcelTitle(value = "到账金额", sort = 6,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public BigDecimal getReceiptAmount() {return receiptAmount;}

	@ExcelTitle(value = "付款备注", sort = 7,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getMemo() {return memo;}

	@ExcelTitle(value = "收款银行", sort = 8,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getRecAccBank() {return recAccBank;}

	@ExcelTitle(value = "收款账号", sort = 9,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getRecAccountNo() {return recAccountNo;}

	@ExcelTitle(value = "收款户名", sort = 10,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
	public String getRecAccountName() {return recAccountName;}

	@ExcelTitle(value = "收款联行号", sort = 11,types = {ExcelTypeConstants.ONE})
	public String getRecEleBankNo() {
		return recEleBankNo;
	}
}