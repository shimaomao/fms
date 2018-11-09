package cn.com.leadu.fms.pojo.prebiz.vo.cstmperson;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmPerson;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmcompany.CstmCompanyVo;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmcontact.CstmContactVo;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersaddr.CstmPersAddrVo;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersjob.CstmPersJobVo;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersmate.CstmPersMateVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: CstmPersonVo
 * @Description: 客户个人基本信息载体
 * @date 2018-03-26
 */
@Data
public class CstmPersonVo extends PageQuery<CstmPerson> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	private String cstmPersonId;

	/**
	 * @Fields  : 
	 */
	private String applyNo;

	/**
	 * @Fields  : 
	 */
	private String name;

	/**
	 * @Fields  : 
	 */
	private String certifType;

	/**
	 * @Fields  : 
	 */
	private String certifNo;

	/**
	 * @Fields  : 
	 */
	private String sex;

	/**
	 * @Fields  : 
	 */
	private String marriageStatus;

	/**
	 * @Fields  : 
	 */
	private String censusType;

	/**
	 * @Fields  : 
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date birthDate;

	/**
	 * @Fields  : 生肖
	 * @author ningyangyang
	 */
	private String chineseZodiac;

	/**
	 * @Fields  : 
	 */
	private String eduBgType;

	/**
	 * @Fields  : 
	 */
	private Integer age;

	/**
	 * @Fields  : 
	 */
	private String mobileNo;

	/**
	 * @Fields  : 
	 */
	private String telNo;

	/**
	 * @Fields  : 
	 */
	private String qqNo;

	/**
	 * @Fields  : 
	 */
	private String wechatNo;

	/**
	 * @Fields  : 
	 */
	private String mail;

	/**
	 * @Fields  : 
	 */
	private String ethnicType;

	/**
	 * @Fields  : 
	 */
	private String licenseNo;

	/**
	 * @Fields  : 
	 */
	private String driver;

	/**
	 * @Fields  : 
	 */
	private String driverMobno;

	/**
	 * @Fields  : 
	 */
	private List<String> cstmPersonIds;
	/**
	 * 客户职业信息VO
	 */
	private CstmPersJobVo cstmPersJobVo;
	/**
	 * 客户配偶信息VO
	 */
	private CstmPersMateVo cstmPersMateVo;
	/**
	 * 客户地址信息VO
	 */
	private CstmPersAddrVo cstmPersAddrVo;
	/**
	 * 客户企业基本信息
	 */
	private CstmCompanyVo cstmCompanyVo;
	/**
	 * 客户联系人信息
	 */
	private CstmContactVo cstmContactVo;

	/**
	 * @Fields  : 初次领证日期
	 * @author ningyangyang
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date firstIssueDate;

	/**
	 * @Fields  : 准驾车型
	 * @author ningyangyang
	 */
	private String quasiDriveModel;

	/**
	 * @Fields  : 驾龄
	 * @author ningyangyang
	 */
	private Integer drivingAge;

	/**
	 * @Fields  : 实际用车人
	 * @author ningyangyang
	 */
	private String actCarUser;

	/**
	 * @Fields  : 驾驶证号
	 * @author ningyangyang
	 */
	private String driLicenseNo;

	/**
	 * @Fields  : 驾驶证档案编号
	 * @author ningyangyang
	 */
	private String actLicenseNo;

	/**
	 * @Fields  : 初次领证日期
	 * @author ningyangyang
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date actIssueDate;

	/**
	 * @Fields  : 驾龄
	 * @author ningyangyang
	 */
	private Integer actDrivingAge;
}