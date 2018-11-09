package cn.com.leadu.fms.pojo.finance.vo.contreceipt;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: ContReceiptVo
 * @Description: 收款明细信息载体
 * @date 2018-05-07
 */
@ExcelTitle(value = "收款明细信息")
@Data
public class ContReceiptVo extends PageQuery<ContReceipt> {

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
	 * @Fields  : 合同编号
	 * @author lijunjun
	 */
	private String contNo;

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
	@NotNull(message = "请输入实收金额")
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
	@NotBlank(message = "收款银行不能为空")
	private String recAccBank;

	/**
	 * @Fields  : 收款账号
	 * @author lijunjun
	 */
	@NotBlank(message = "收款账号不能为空")
	private String recAccountNo;

	/**
	 * @Fields  : 收款户名
	 * @author lijunjun
	 */
	@NotBlank(message = "收款户名不能为空")
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
	@NotBlank(message = "收款银行分行不能为空")
	private String recAccBranch;

	/**
	 * @Fields  : 财务收款Id
	 * @author lijunjun
	 */
	private List<String> contReceiptIds;

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

	/**
	 * @Fields  : 财务确认金额
	 * @author lijunjun
	 */
	private BigDecimal financeConfirmAmount;

	/**
	 * @Fields  : 提前还款ID
	 * @author lijunjun
	 */
	private String contPrepaymentId;

	/**
	 * @Fields  : 任务id
	 */
	private String taskId;
	/**
	 * @Fields  :user
	 */
	private String user;

	@ExcelTitle(value = "到账日期", sort = 1 ,types = {ExcelTypeConstants.ONE})
	public String getReceiptDateStr() {return DateUtils.dateToStr(receiptDate, DateUtils.formatStr_yyyyMMdd);}

	@ExcelTitle(value = "到账时刻", sort = 2)
	public String getReceiptTimeStr() {return DateUtils.dateToStr(receiptTime, DateUtils.formatStr_HHmmss);}

	@ExcelTitle(value = "付款银行", sort = 3)
	public String getPayAccBank() { return payAccBank; }

	@ExcelTitle(value = "付款账号", sort = 4)
	public String getPayAccountNo() {return payAccountNo;}

	@ExcelTitle(value = "付款户名", sort = 5)
	public String getPayAccountName() {return payAccountName;}

	@ExcelTitle(value = "到账金额", sort = 6)
	public BigDecimal getReceiptAmount() {return receiptAmount;}

	@ExcelTitle(value = "付款备注", sort = 7)
	public String getMemo() {return memo;}

	@ExcelTitle(value = "剩余金额", sort = 8)
	public BigDecimal getRestAmount() {return restAmount;}

	@ExcelTitle(value = "收款银行", sort = 9)
	public String getRecAccBank() {return recAccBank;}

	@ExcelTitle(value = "收款账号", sort = 10)
	public String getRecAccountNo() {return recAccountNo;}

	@ExcelTitle(value = "收款户名", sort = 11)
	public String getRecAccountName() {return recAccountName;}
}