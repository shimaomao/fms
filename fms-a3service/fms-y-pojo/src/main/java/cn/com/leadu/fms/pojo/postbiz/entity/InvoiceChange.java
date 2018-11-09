package cn.com.leadu.fms.pojo.postbiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author lijunjun
 * @ClassName: InvoiceChange
 * @Description: 开票信息变更实体
 * @date 2018-08-29
 */
@Data
public class InvoiceChange extends BaseEntity<InvoiceChange> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 开票信息变更id
	 * @author lijunjun
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String invoiceChangeId;

	/**
	 * @Fields  : 数据类型
	 * @author lijunjun
	 */
	private String solveType;

	/**
	 * @Fields  : 社会统一信用代码
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

}