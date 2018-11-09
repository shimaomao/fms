package cn.com.leadu.fms.postbiz.validator.invoice.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.Invoice;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author yangyiquan
 * @ClassName: InvoiceVo
 * @Description: 开票信息保存时载体及验证
 */
@Data
public class InvoiceSaveVo extends BaseVo<Invoice> {

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
	private Date receiveDate;

	/**
	 * @Fields  : 开票日期
	 * @author yangyiquan
	 */
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

}