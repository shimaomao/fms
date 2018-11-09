package cn.com.leadu.fms.pojo.prebiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import cn.com.leadu.fms.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: CstmPerson
 * @Description: 客户个人基本信息实体
 * @date 2018-03-26
 */
@Data
public class CstmPerson extends BaseEntity<CstmPerson> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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