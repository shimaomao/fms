package cn.com.leadu.fms.postbiz.validator.invoicechange.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceChange;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author lijunjun
 * @ClassName: InvoiceChangeVo
 * @Description: 开票信息变更修改时载体及验证
 * @date 2018-08-29
 */
@Data
public class InvoiceChangeModifyVo extends BaseVo<InvoiceChange> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 开票信息变更id
	 * @author lijunjun
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
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