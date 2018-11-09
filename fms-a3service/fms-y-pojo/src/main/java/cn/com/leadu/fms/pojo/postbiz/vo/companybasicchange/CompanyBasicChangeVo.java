package cn.com.leadu.fms.pojo.postbiz.vo.companybasicchange;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.CompanyBasicChange;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmContact;
import lombok.Data;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: CompanyBasicChangeVo
 * @Description: 企业基本信息变更载体
 * @date 2018-09-01
 */
@Data
public class CompanyBasicChangeVo extends PageQuery<CompanyBasicChange> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 企业基本信息变更id
	 * @author lijunjun
	 */
	private String companyChangeId;

	/**
	 * @Fields  : 数据类型
	 * @author lijunjun
	 */
	private String solveType;

	/**
	 * @Fields  : 申请编号
	 * @author lijunjun
	 */
	private String applyNo;

	/**
	 * @Fields  : 申请类型
	 * @author lijunjun
	 */
	private String applyType;

	/**
	 * @Fields  : 变更任务号
	 * @author lijunjun
	 */
	private String companyTaskNo;

	/**
	 * @Fields  : 承租人
	 * @author lijunjun
	 */
	private String name;

	/**
	 * @Fields  : 联系人姓名
	 * @author lijunjun
	 */
	private String contactName;

	/**
	 * @Fields  : 联系人手机号码
	 * @author lijunjun
	 */
	private String contactMobno;

	/**
	 * @Fields  : 经营地址-省份
	 * @author lijunjun
	 */
	private String compProv;

	/**
	 * @Fields  : 经营地址-城市
	 * @author lijunjun
	 */
	private String compCity;

	/**
	 * @Fields  : 经营地址-区县
	 * @author lijunjun
	 */
	private String compCounty;

	/**
	 * @Fields  : 经营地址-详细地址
	 * @author lijunjun
	 */
	private String compAddr;

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
	 * @Fields  : 备注
	 * @author lijunjun
	 */
	private String remark;

	/**
	 * @Fields  : 企业基本信息变更id
	 * @author lijunjun
	 */
	private List<String> companyChangeIds;

	/**
	 * @Fields : 客户联系人信息
	 */
	private List<CstmContact> cstmContactList;

}