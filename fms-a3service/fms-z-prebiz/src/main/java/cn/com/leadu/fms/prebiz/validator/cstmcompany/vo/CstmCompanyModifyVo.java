package cn.com.leadu.fms.prebiz.validator.cstmcompany.vo;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmCompany;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: CstmCompanyVo
 * @Description: 客户企业基本信息修改时载体及验证
 * @date 2018-03-27
 */
@Data
public class CstmCompanyModifyVo extends BaseVo<CstmCompany> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 企业基本信息id
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String cstmCompanyId;

	/**
	 * @Fields  : 订单编号
	 */
	private String applyNo;

	/**
	 * @Fields  : 企业名称
	 */
	private String name;

	/**
	 * @Fields  : 统一社会信用代码
	 */
	private String socialCertifNo;

	/**
	 * @Fields  : 法定代表人
	 */
	private String compLegalRep;

	/**
	 * @Fields  : 法人证件类型
	 */
	private String certifType;

	/**
	 * @Fields  : 法人证件号码
	 */
	private String certifNo;

	/**
	 * @Fields  : 法人手机号码
	 */
	private String mobileNo;

	/**
	 * @Fields  : 经营地址-省份
	 */
	private String compProv;

	/**
	 * @Fields  : 经营地址-城市
	 */
	private String compCity;

	/**
	 * @Fields  : 经营地址-区县
	 */
	private String compCounty;

	/**
	 * @Fields  : 经营地址-详细地址
	 */
	private String compAddr;

	/**
	 * @Fields  : 注册资金
	 */
	private String regCapital;

	/**
	 * @Fields  : 企业联系电话
	 */
	private String compTel;

	/**
	 * @Fields  : 企业性质
	 */
	private String compType;

	/**
	 * @Fields  : 成立年限
	 */
	private String establYear;

	/**
	 * @Fields  : 实际用车人
	 */
	private String driver;

	/**
	 * @Fields  : 实际用车人手机号码
	 */
	private String driverMobno;

	/**
	 * @Fields  : 实际用车人驾驶证档案编号
	 */
	private String driverLicenseNo;

	/**
	 * @Fields  : 准驾车型
	 */
	private String quasiDriveModel;

	/**
	 * @Fields  : 初次领证日期
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date firstIssueDate;

	/**
	 * @Fields  : 驾龄
	 */
	private Integer drivingAge;

	/**
	 * @Fields  : 联系人姓名
	 */
	private String contactName;

	/**
	 * @Fields  : 联系人手机号码
	 */
	private String contactMobno;

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

	//以下为增加发票信息
	/**
	 * @Fields  : 发票类型
	 * @author ningyangyang
	 */
	private String invoiceType;

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
	 * @Fields  : 地址
	 * @author ningyangyang
	 */
	private String invoiceAddr;

	/**
	 * @Fields  : 账号
	 * @author ningyangyang
	 */
	private String accountNumber;

	/**
	 * @Fields  : 发票邮寄地址
	 */
	private String invoiceMailAddr;

	/**
	 * @Fields  : 联系人
	 */
	private String invoiceContactPer;

	/**
	 * @Fields  : 联系人电话
	 */
	private String invoiceContactNo;

	/**
	 * @Fields  : 收入来源描述
	 */
	private String sourceIncomeDes;

	/**
	 * @Fields  : 主营业务
	 */
	private String mainBusiness;

	/**
	 * @Fields  : 行业利润率
	 */
	private BigDecimal industryProfitMargin;

	/**
	 * @Fields  : 单位行业类别
	 */
	private String industry;

	/**
	 * @Fields  : 成立日期
	 */
	private Date establDate;

	/**
	 * @Fields  : 经营地址类型
	 */
	private String compAddrType;

	/**
	 * @Fields  : 购买时间
	 */
	private Date buyTime;

	/**
	 * @Fields  : 建筑面积
	 */
	private String constructionArea;

	/**
	 * @Fields  : 租赁时间
	 */
	private Date leaseTime;

	/**
	 * @Fields  : 面积
	 */
	private String leaseArea;

	/**
	 * @Fields  : 租金
	 */
	private BigDecimal rent;

	/**
	 * @Fields  : 开户行
	 */
	private String bankName;

}