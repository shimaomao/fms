package cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author huzongcheng
 * @ClassName: BasicChangeTaskVo
 * @Description: 企业基本信息变更历史载体
 * @date 2018-08-31
 */
@Data
public class BasicChangeCompHistoryVo extends PageQuery<BasicChangeCompHistoryVo> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 变更任务号
	 * @author huzongcheng
	 */
	private String taskNo;

	/**
	 * @Fields  : 变更任务状态
	 * @author huzongcheng
	 */
	private String basicTaskStatus;

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
	 * @Fields  : 备注
	 * @author huzongcheng
	 */
	private String remark;

	/**
	 * @Fields  : 承租人
	 * @author huzongcheng
	 */
	private String name;

	/**
	 * @Fields  : 联系人姓名
	 * @author huzongcheng
	 */
	private String contactName;

	/**
	 * @Fields  : 联系人手机号码
	 * @author huzongcheng
	 */
	private String contactMobno;

	/**
	 * @Fields  : 经营地址-省份
	 * @author huzongcheng
	 */
	private String compProv;

	/**
	 * @Fields  : 经营地址-城市
	 * @author huzongcheng
	 */
	private String compCity;

	/**
	 * @Fields  : 经营地址-区县
	 * @author huzongcheng
	 */
	private String compCounty;

	/**
	 * @Fields  : 经营地址-详细地址
	 * @author huzongcheng
	 */
	private String compAddr;

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
	 * @Fields  : 发票邮寄地址
	 * @author huzongcheng
	 */
	private String invoiceMailAddr;

	/**
	 * @Fields  : 邮寄联系人
	 * @author huzongcheng
	 */
	private String invoiceContactPer;

	/**
	 * @Fields  : 联系人电话
	 * @author huzongcheng
	 */
	private String invoiceContactNo;

	/**
	 * @Fields  : 开户行
	 * @author huzongcheng
	 */
	private String bankName;

	/**
	 * @Fields  : 变更前承租人
	 * @author huzongcheng
	 */
	private String nameOld;

	/**
	 * @Fields  : 变更前联系人姓名
	 * @author huzongcheng
	 */
	private String contactNameOld;

	/**
	 * @Fields  : 变更前联系人手机号码
	 * @author huzongcheng
	 */
	private String contactMobnoOld;

	/**
	 * @Fields  : 变更前申请编号
	 * @author huzongcheng
	 */
	private String applyNo;

}