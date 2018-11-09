package cn.com.leadu.fms.pojo.postbiz.vo.invoicechange;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author huzongcheng
 * @ClassName: HistoryChangeVo
 * @Description: 开票信息历史变更载体
 */
@Data
public class HistoryChangeVo extends PageQuery<HistoryChangeVo> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 社统一信用代码
	 * @author huzongcheng
	 */
	private String socialCertifNo;

	/**
	 * @Fields  : 发票类型
	 * @author huzongcheng
	 */
	private String invoiceType;

	/**
	 * @Fields  : 开票名
	 * @author huzongcheng
	 */
	private String ticketOpening;

	/**
	 * @Fields  : 税号
	 * @author huzongcheng
	 */
	private String dutyParagraph;

	/**
	 * @Fields  : 地址
	 * @author huzongcheng
	 */
	private String invoiceAddr;

	/**
	 * @Fields  : 账号
	 * @author huzongcheng
	 */
	private String accountNumber;

	/**
	 * @Fields  : 开户行
	 * @author huzongcheng
	 */
	private String bankName;

	/**
	 * @Fields  : 任务提交人
	 * @author huzongcheng
	 */
	private String submitUser;

	/**
	 * @Fields  : 任务提交时间
	 * @author huzongcheng
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date submitDate;

	/**
	 * @Fields  : 任务号
	 * @author huzongcheng
	 */
	private String invoiceTaskNo;

	/**
	 * @Fields  : 备注
	 * @author huzongcheng
	 */
	private String remark;

	/**
	 * @Fields  : 任务状态
	 * @author huzongcheng
	 */
	private String invoiceTaskStatus;

	/**
	 * @Fields  : 变更前发票类型
	 * @author huzongcheng
	 */
	private String invoiceTypeOld;

	/**
	 * @Fields  : 变更前开票名
	 * @author huzongcheng
	 */
	private String ticketOpeningOld;

	/**
	 * @Fields  : 变更前税号
	 * @author huzongcheng
	 */
	private String dutyParagraphOld;

	/**
	 * @Fields  : 变更前地址
	 * @author huzongcheng
	 */
	private String invoiceAddrOld;

	/**
	 * @Fields  : 变更前账号
	 * @author huzongcheng
	 */
	private String accountNumberOld;

	/**
	 * @Fields  : 变更前开户行
	 * @author huzongcheng
	 */
	private String bankNameOld;


}