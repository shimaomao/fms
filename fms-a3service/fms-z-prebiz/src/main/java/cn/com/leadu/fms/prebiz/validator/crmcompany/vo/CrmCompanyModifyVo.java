package cn.com.leadu.fms.prebiz.validator.crmcompany.vo;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CrmCompany;
import cn.com.leadu.fms.prebiz.validator.crmcompany.validator.CrmCompCertifNoValidator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ningyangyang
 * @ClassName: CrmCompanyVo
 * @Description: CRM企业信息修改时载体及验证
 * @date 2018-05-24
 */
@Data
public class CrmCompanyModifyVo extends BaseVo<CrmCompany> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 企业ID
	 * @author ningyangyang
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String companyId;

	/**
	 * @Fields  : 企业名称
	 * @author ningyangyang
	 */
	private String name;

	/**
	 * @Fields  : 统一社会信用代码
	 * @author ningyangyang
	 */
	private String socialCertifNo;

	/**
	 * @Fields  : 法定代表人
	 * @author ningyangyang
	 */
	private String compLegalRep;

	/**
	 * @Fields  : 法人证件类型
	 * @author ningyangyang
	 */
	private String certifType;

	/**
	 * @Fields  : 法人证件号码
	 * @author ningyangyang
	 */
	private String certifNo;

	/**
	 * @Fields  : 法人手机号码
	 * @author ningyangyang
	 */
	private String mobileNo;

	/**
	 * @Fields  : 经营省份
	 * @author ningyangyang
	 */
	private String compProv;

	/**
	 * @Fields  : 经营城市
	 * @author ningyangyang
	 */
	private String compCity;

	/**
	 * @Fields  : 经营区县
	 * @author ningyangyang
	 */
	private String compCounty;

	/**
	 * @Fields  : 经营详细地址
	 * @author ningyangyang
	 */
	private String compAddr;

	/**
	 * @Fields  : 经营地址类型
	 * @author ningyangyang
	 */
	private String compAddrType;

	/**
	 * @Fields  : 购买时间
	 * @author ningyangyang
	 */
	private Date buyTime;

	/**
	 * @Fields  : 建筑面积
	 * @author ningyangyang
	 */
	private String constructionArea;

	/**
	 * @Fields  : 租赁时间
	 * @author ningyangyang
	 */
	private Date leaseTime;

	/**
	 * @Fields  : 租赁面积
	 * @author ningyangyang
	 */
	private String leaseArea;

	/**
	 * @Fields  : 租金
	 * @author ningyangyang
	 */
	private BigDecimal rent;

	/**
	 * @Fields  : 注册省份
	 * @author ningyangyang
	 */
	private String registerProv;

	/**
	 * @Fields  : 注册城市
	 * @author ningyangyang
	 */
	private String registerCity;

	/**
	 * @Fields  : 注册区县
	 * @author ningyangyang
	 */
	private String registerCounty;

	/**
	 * @Fields  : 注册详细地址
	 * @author ningyangyang
	 */
	private String registerAddr;

	/**
	 * @Fields  : 注册资金
	 * @author ningyangyang
	 */
	private String regCapital;

	/**
	 * @Fields  : 企业联系电话
	 * @author ningyangyang
	 */
	private String compTel;

	/**
	 * @Fields  : 企业性质
	 * @author ningyangyang
	 */
	private String compType;

	/**
	 * @Fields  : 成立年限
	 * @author ningyangyang
	 */
	private String establYear;

	/**
	 * @Fields  : 企业联系人
	 */
	private String contactName;

	/**
	 * @Fields  : 联系人手机号
	 */
	private String contactMobno;

	/**
	 * @Fields  : 财务辅助核算代码
	 * @author qiaomengnan
	 */
	private String finassCstmCode;

	/**
	 * @Fields  : 开票名
	 * @author ningyangyang
	 */
	private String ticketOpening;

	/**
	 * @Fields  : 税号
	 * @author ningyangyang
	 */
	private String dutyParagraph;

	/**
	 * @Fields  : 地址、电话
	 * @author ningyangyang
	 */
	private String invoiceAddr;

	/**
	 * @Fields  : 账号
	 * @author ningyangyang
	 */
	private String accountNumber;

	/**
	 * @Fields  : 开户行
	 */
	private String bankName;

//	/**
//	 * @Fields  : 企业类型
//	 * @author ningyangyang
//	 */
//	private String companyType1;

	/**
	 * @Fields  : 成立日期
	 * @author ningyangyang
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date establDate;

	/**
	 * @Fields  : 单位行业类别
	 * @author ningyangyang
	 */
	private String industry;

}