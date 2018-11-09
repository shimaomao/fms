package cn.com.leadu.fms.pojo.postbiz.vo.invoice;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.Invoice;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author yangyiquan
 * @ClassName: InvoiceVo
 * @Description: 开票信息载体
 */
@ExcelTitle(typeValues = {"开票信息一览"}, types = {ExcelTypeConstants.ONE})
@Data
public class InvoiceVo extends PageQuery<Invoice> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 开票信息ID
	 * @author yangyiquan
	 */
	private String invoiceId;

	/**
	 * @Fields  : 开票类型
	 * @author yangyiquan
	 */
	private String invoiceDataType;

	/**
	 * @Fields  : 合同编号
	 * @author yangyiquan
	 */
	private String contNo;

	/**
	 * @Fields  : 明细信息
	 * @author yangyiquan
	 */
	private String detailNo;

	/**
	 * @Fields  : 应收金额
	 * @author yangyiquan
	 */
	private BigDecimal receiveAccount;

	/**
	 * @Fields  : 实收金额
	 * @author yangyiquan
	 */
	private BigDecimal receiveActualAccount;

	/**
	 * @Fields  : 收款日期
	 * @author yangyiquan
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date receiveDate;

	/**
	 * @Fields  : 开始 收款日期
	 * @author qiaomengnan
	 */
	private String beginReceiveDate;

	/**
	 * @Fields  : 结束 收款日期
	 * @author qiaomengnan
	 */
	private String endReceiveDate;

	/**
	 * @Fields  : 开票日期
	 * @author yangyiquan
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date invoiceDate;

	/**
	 * @Fields  : 开票金额
	 * @author yangyiquan
	 */
	private BigDecimal invoiceAmount;

	/**
	 * @Fields  : 开票税率
	 * @author qiaomengnan
	 */
	private BigDecimal invoiceTax;

	/**
	 * @Fields  : 开票状态
	 * @author yangyiquan
	 */
	private String invoiceStatus;

	/**
	 * @Fields  : 开票备注
	 * @author yangyiquan
	 */
	private String invoiceMemo;

	/**
	 * @Fields  : 开票区分
	 * @author yangyiquan
	 */
	private String invoiceFlag;

	/**
	 * @Fields  : 发票号码
	 * @author yangyiquan
	 */
	private String invoiceNo;

	/**
	 * @Fields  : 作废发票号码
	 * @author yangyiquan
	 */
	private String invoiceDelNo;

	/**
	 * @Fields  : 凭证生成状态
	 * @author yangyiquan
	 */
	private String invoiceVoucherStatus;

	/**
	 * @Fields  : 开票信息ID
	 * @author yangyiquan
	 */
	private List<String> invoiceIds;

	/**
	 * @Fields  : 承租人
	 * @author qiaomengnan
	 */
	private String lessee;

	/**
	 * @Fields  : 车架号
	 * @author qiaomengnan
	 */
	private String vinNo;

	/**
	 * @Fields  : 出租人
	 * @author qiaomengnan
	 */
	private String lessor;

	/**
	 * @Fields  : 个人申请类型
	 * @author qiaomengnan
	 */
	private String applyTypePerson;

	/**
	 * @Fields  : 承租人证件号
	 * @author qiaomengnan
	 */
	private String certifNo;

	/**
	 * @Fields  : 申请类型
	 * @author qiaomengnan
	 */
	private String applyType;

	/**
	 * @Fields  : 用户发票类型
	 * @author qiaomengnan
	 */
	private String cstmInvoiceType;

	/**
	 * @Fields  : 开票名
	 * @author qiaomengnan
	 */
	private String ticketOpening;

	/**
	 * @Fields  : 税号
	 * @author qiaomengnan
	 */
	private String dutyParagraph;

	/**
	 * @Fields  : 发票地址
	 * @author qiaomengnan
	 */
	private String invoiceAddr;

	/**
	 * @Fields  : 开户行
	 * @author qiaomengnan
	 */
	private String bankName;

	/**
	 * @Fields  : 账号
	 * @author qiaomengnan
	 */
	private String accountNumber;

	/**
	 * @Fields  : 发票类型(查询条件)
	 * @author qiaomengnan
	 */
	private String invoiceType;

	/**
	 * @Fields  : 发票是否打印
	 * @author qiaomengnan
	 */
	private String invoicePrintStatus;

	/**
	 * @Fields  : 是否打印
	 * @author ningyangyang
	 */
	private String printStatus;

	/**
	 * @Fields  : 开票区分
	 * @author qiaomengnan
	 */
	private String jugInvoiceFlag;

	/**
	 * @Fields  : 备注   必填 否    长度
	 * @author qiaomengnan
	 */
	private String infonotes;

	/**
	 * @Fields  :出租人区域
	 */
	private String groupDistrict;

	/**
	 * @Fields  : 业务类型
	 */
	private String licenseAttr;

	/**
	 * @Fields  : 开始时间(开票日期)
	 * @author yanfengbo
	 */
	private String startTime2;

	/**
	 * @Fields  : 结束时间(开票日期)
	 * @author yanfengbo
	 */
	private String endTime2;

	@ExcelTitle(value = "合同编号", sort = 1, types = {ExcelTypeConstants.ONE})
	public String getContNoONE() {
		return contNo;
	}

	@ExcelTitle(value = "开票类型", sort = 2, types = {ExcelTypeConstants.ONE}, codeType = CommonCodeTypeConstants.INVOICE_DATA_TYPE)
	public String getInvoiceDataTypeONE() {
		return invoiceDataType;
	}

	@ExcelTitle(value = "发票类型", sort = 3, types = {ExcelTypeConstants.ONE}, codeType = CommonCodeTypeConstants.INVOICE_TYPE)
	public String getCstmInvoiceTypeONE() {
		return cstmInvoiceType;
	}

	@ExcelTitle(value = "开票区分", sort = 4, types = {ExcelTypeConstants.ONE}, codeType = CommonCodeTypeConstants.INVOICE_FLAG)
	public String getInvoiceFlagONE() {
		return invoiceFlag;
	}

	@ExcelTitle(value = "发票号码", sort = 5, types = {ExcelTypeConstants.ONE})
	public String getInvoiceNoONE() {
		return invoiceNo;
	}

	@ExcelTitle(value = "明细信息", sort = 6, types = {ExcelTypeConstants.ONE})
	public String getDetailNoONE() {
		return detailNo;
	}

	@ExcelTitle(value = "收款金额", sort = 7, types = {ExcelTypeConstants.ONE})
	public BigDecimal getReceiveActualAccountONE() {
		return receiveActualAccount;
	}

	@ExcelTitle(value = "收款日期", sort = 8, types = {ExcelTypeConstants.ONE})
	public String getReceiveDateToStrONE() {
		return DateUtils.dateToStr(receiveDate, DateUtils.formatStr_yyyyMMdd);
	}

	@ExcelTitle(value = "开票日期", sort = 9, types = {ExcelTypeConstants.ONE})
	public String getInvoiceDateToStrONE() {
		return DateUtils.dateToStr(invoiceDate, DateUtils.formatStr_yyyyMMdd);
	}

	@ExcelTitle(value = "开票状态", sort = 10, types = {ExcelTypeConstants.ONE}, codeType = CommonCodeTypeConstants.INVOICE_STATUS)
	public String getInvoiceStatusONE() {
		return invoiceStatus;
	}

	@ExcelTitle(value = "开票税率", sort = 11, types = {ExcelTypeConstants.ONE})
	public BigDecimal getInvoiceTaxONE() {return invoiceTax; }

	@ExcelTitle(value = "打印状态", sort = 12, types = {ExcelTypeConstants.ONE}, codeType = CommonCodeTypeConstants.PRINT_STATUS)
	public String getPrintStatusONE() {
		return printStatus;
	}

	@ExcelTitle(value = "开票金额", sort = 13, types = {ExcelTypeConstants.ONE})
	public BigDecimal getInvoiceAmountONE() {
		return invoiceAmount;
	}

	@ExcelTitle(value = "开票备注", sort = 14, types = {ExcelTypeConstants.ONE})
	public String getInvoiceMemoONE() {
		return invoiceMemo;
	}

	@ExcelTitle(value = "凭证状态", sort = 15, types = {ExcelTypeConstants.ONE}, codeType = CommonCodeTypeConstants.INVOICEVOUCHER_STATUS)
	public String getInvoiceVoucherStatusONE() {
		return invoiceVoucherStatus;
	}

	@ExcelTitle(value = "承租人", sort = 16, types = {ExcelTypeConstants.ONE})
	public String getLesseeONE() {
		return lessee;
	}

	@ExcelTitle(value = "车架号", sort = 17, types = {ExcelTypeConstants.ONE})
	public String getVinNoONE() {
		return vinNo;
	}

	@ExcelTitle(value = "出租人", sort = 18, types = {ExcelTypeConstants.ONE})
	public String getLessorONE() {
		return lessor;
	}

	@ExcelTitle(value = "申请类型", sort = 19, types = {ExcelTypeConstants.ONE}, codeType = CommonCodeTypeConstants.PROD_APPLY_TYPE)
	public String getApplyTypeONE() {
		return applyType;
	}

	@ExcelTitle(value = "业务类型", sort = 20, types = {ExcelTypeConstants.ONE}, codeType = CommonCodeTypeConstants.PROD_LICENSE_ATTR)
	public String getLicenseAttrONE() {
		return licenseAttr;
	}

	@ExcelTitle(value = "开票名", sort = 21, types = {ExcelTypeConstants.ONE})
	public String getTicketOpeningONE() {
		return ticketOpening;
	}

	@ExcelTitle(value = "税号", sort = 22, types = {ExcelTypeConstants.ONE})
	public String getDutyParagraphONE() {
		return dutyParagraph;
	}

	@ExcelTitle(value = "发票地址", sort = 23, types = {ExcelTypeConstants.ONE})
	public String getInvoiceAddrONE() {
		return invoiceAddr;
	}

	@ExcelTitle(value = "开户行", sort = 24, types = {ExcelTypeConstants.ONE})
	public String getBankNameONE() {
		return bankName;
	}

	@ExcelTitle(value = "账号", sort = 25, types = {ExcelTypeConstants.ONE})
	public String getAccountNumberONE() {
		return accountNumber;
	}
}