package cn.com.leadu.fms.pojo.postbiz.vo.invoicechange;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceChange;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: InvoiceChangeVo
 * @Description: 开票信息变更载体
 * @date 2018-08-29
 */
@ExcelTitle(typeValues ={"企业开票信息", "开票任务信息"},types = {ExcelTypeConstants.ONE, ExcelTypeConstants.TWO})
@Data
public class InvoiceChangeVo extends PageQuery<InvoiceChange> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 开票信息变更id
	 * @author lijunjun
	 */
	private String invoiceChangeId;

	/**
	 * @Fields  : 企业信息Id
	 * @author lijunjun
	 */
	private String cstmCompanyId;

	/**
	 * @Fields  : 数据类型
	 * @author lijunjun
	 */
	private String solveType;

	/**
	 * @Fields  : 社统一信用代码
	 * @author lijunjun
	 */
	private String socialCertifNo;

	/**
	 * @Fields  : 变更任务号
	 * @author lijunjun
	 */
	private String invoiceTaskNo;

	/**
	 * @Fields  : 发票类型
	 * @author lijunjun
	 */
	private String invoiceType;

	/**
	 * @Fields  : 开票名
	 * @author lijunjun
	 */
	private String ticketOpening;

	/**
	 * @Fields  : 税号
	 * @author lijunjun
	 */
	private String dutyParagraph;

	/**
	 * @Fields  : 地址
	 * @author lijunjun
	 */
	private String invoiceAddr;

	/**
	 * @Fields  : 账号
	 * @author lijunjun
	 */
	private String accountNumber;

	/**
	 * @Fields  : 发票邮寄地址
	 * @author lijunjun
	 */
	private String invoiceMailAddr;

	/**
	 * @Fields  : 邮寄联系人
	 * @author lijunjun
	 */
	private String invoiceContactPer;

	/**
	 * @Fields  : 联系人电话
	 * @author lijunjun
	 */
	private String invoiceContactNo;

	/**
	 * @Fields  : 开户行
	 * @author lijunjun
	 */
	private String bankName;

	/**
	 * @Fields  : 开票信息变更id
	 * @author lijunjun
	 */
	private List<String> invoiceChangeIds;

	/**
	 * @Fields  : 承租人
	 * @author lijunjun
	 */
	private String name;

	/**
	 * @Fields  : 合同状态
	 * @author lijunjun
	 */
	private String bizStatus;

	/**
	 * @Fields  : 申请类型
	 * @author lijunjun
	 */
	private String applyType;

	/**
	 * @Fields  : 备注
	 * @author lijunjun
	 */
	private String remark;

	/**
	 * @Fields  : 任务状态
	 * @author lijunjun
	 */
	private String invoiceTaskStatus;

	/**
	 * @Fields  : 任务提交人
	 * @author lijunjun
	 */
	private String submitUser;

	/**
	 * @Fields  : 任务提交时间
	 * @author lijunjun
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date submitDate;

	/**
	 * @Fields  : 任务提交开始时间(查询条件)
	 * @author lijunjun
	 */
	private String submitDateStartSearch;

	/**
	 * @Fields  : 任务提交开始时间(查询条件)
	 * @author lijunjun
	 */
	private String submitDateEndSearch;

	/**
	 * @Fields  : 当前用户
	 * @author lijunjun
	 */
	private String presentUser;

	/**
	 * @Fields  : 附件信息
	 * @author lijunjun
	 */
	private List<BizFiles> bizFilesList;

	/**
	 * @Fields  : 企业联系人
	 * @author lijunjun
	 */
	private String contactName;

	/**
	 * @Fields  : 企业联系人电话号码
	 * @author lijunjun
	 */
	private String contactMobno;

	/**
	 * @Fields  : 还款状态
	 * @author lijunjun
	 */
	private String paymentSts;

	/**
	 * @Fields  : 地区
	 * @author lijunjun
	 */
	private String groupDistrict;


	/*企业开票信息*/
	@ExcelTitle(value ="承租人", sort = 1, types = {ExcelTypeConstants.ONE})
	public String getName(){return this.name;}

	@ExcelTitle(value ="统一社会信用代码", sort = 2, types = {ExcelTypeConstants.ONE})
	public String getSocialCertifNo(){return this.socialCertifNo;}

	@ExcelTitle(value ="开票类型", sort = 3, codeType = CommonCodeTypeConstants.INVOICE_TYPE, types = {ExcelTypeConstants.ONE})
	public String getInvoiceType(){return this.invoiceType;}

	@ExcelTitle(value ="开票名称", sort = 4, types = {ExcelTypeConstants.ONE})
	public String getTicketOpening(){return this.ticketOpening;}

	@ExcelTitle(value ="开票地址电话", sort = 5, types = {ExcelTypeConstants.ONE})
	public String getInvoiceAddr(){return this.invoiceAddr;}

	@ExcelTitle(value ="税号", sort = 6, types = {ExcelTypeConstants.ONE})
	public String getDutyParagraph(){return this.dutyParagraph;}

	@ExcelTitle(value ="账号", sort = 7, types = {ExcelTypeConstants.ONE})
	public String getAccountNumber(){return this.accountNumber;}

	@ExcelTitle(value ="开户行", sort = 8, types = {ExcelTypeConstants.ONE})
	public String getBankName(){return this.bankName;}

	/*开票任务信息*/
	@ExcelTitle(value ="任务号", sort = 1, types = {ExcelTypeConstants.TWO})
	public String getInvoiceTaskNo(){return this.invoiceTaskNo;}

	@ExcelTitle(value ="任务状态", sort = 2, codeType = CommonCodeTypeConstants.BIZSTATUS, types = {ExcelTypeConstants.TWO})
	public String getInvoiceTaskStatus(){return this.invoiceTaskStatus;}

	@ExcelTitle(value ="当前节点用户", sort = 3, types = {ExcelTypeConstants.TWO})
	public String getPresentUsers(){return this.presentUser;}

	@ExcelTitle(value ="承租人", sort = 4, types = {ExcelTypeConstants.TWO})
	public String getNames(){return this.name;}

	@ExcelTitle(value ="统一社会信用代码", sort = 5, types = {ExcelTypeConstants.TWO})
	public String getSocialCertifNos(){return this.socialCertifNo;}

	@ExcelTitle(value ="开票类型", sort = 6, codeType = CommonCodeTypeConstants.INVOICE_TYPE, types = {ExcelTypeConstants.TWO})
	public String getInvoiceTypes(){return this.invoiceType;}

	@ExcelTitle(value ="开票名称", sort = 7, types = {ExcelTypeConstants.TWO})
	public String getTicketOpenings(){return this.ticketOpening;}

	@ExcelTitle(value ="开票地址电话", sort = 8, types = {ExcelTypeConstants.TWO})
	public String getInvoiceAddrs(){return this.invoiceAddr;}

	@ExcelTitle(value ="税号", sort = 9, types = {ExcelTypeConstants.TWO})
	public String getDutyParagraphs(){return this.dutyParagraph;}

	@ExcelTitle(value ="账号", sort = 10, types = {ExcelTypeConstants.TWO})
	public String getAccountNumbers(){return this.accountNumber;}

	@ExcelTitle(value ="开户行", sort = 11, types = {ExcelTypeConstants.TWO})
	public String getBankNames(){return this.bankName;}

	@ExcelTitle(value ="地区", sort = 12, types = {ExcelTypeConstants.TWO})
	public String getGroupDistrict(){return this.groupDistrict;}

}