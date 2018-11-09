package cn.com.leadu.fms.pojo.postbiz.vo.invoicechange;

import cn.com.leadu.fms.common.util.DateUtils;
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
@Data
public class InvoiceChangeSearchVo {

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
	 * @Fields  : 操作用户
	 * @author lijunjun
	 */
	private String user;

	/**
	 * @Fields  : 操作时间
	 * @author lijunjun
	 */
	private Date date;
}