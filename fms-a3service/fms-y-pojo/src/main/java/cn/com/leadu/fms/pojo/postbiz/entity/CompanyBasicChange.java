package cn.com.leadu.fms.pojo.postbiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author lijunjun
 * @ClassName: CompanyBasicChange
 * @Description: 企业基本信息变更实体
 * @date 2018-09-01
 */
@Data
public class CompanyBasicChange extends BaseEntity<CompanyBasicChange> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 企业基本信息变更id
	 * @author lijunjun
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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

}