package cn.com.leadu.fms.prebiz.validator.cstmperson.vo;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmPerson;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmcompany.CstmCompanyVo;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmcontact.CstmContactVo;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersaddr.CstmPersAddrVo;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersjob.CstmPersJobVo;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersmate.CstmPersMateVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: CstmPersonVo
 * @Description: 客户个人基本信息保存时载体及验证
 * @date 2018-03-26
 */
@Data
public class CstmPersonSaveVo extends BaseVo<CstmPerson> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 个人基本信息id
	 */
	private String cstmPersonId;

	/**
	 * @Fields  : 订单编号
	 */
	private String applyNo;

	/**
	 * @Fields  : 申请人姓名
	 */
	private String name;

	/**
	 * @Fields  : 证件类型
	 */
	private String certifType;

	/**
	 * @Fields  : 证件号
	 */
	private String certifNo;

	/**
	 * @Fields  : 性别
	 */
	private String sex;

	/**
	 * @Fields  : 婚姻状况
	 */
	private String marriageStatus;

	/**
	 * @Fields  : 户口类别
	 */
	private String censusType;

	/**
	 * @Fields  : 出生日期
	 */
	private Date birthDate;

	/**
	 * @Fields  : 生肖
	 * @author ningyangyang
	 */
	private String chineseZodiac;

	/**
	 * @Fields  : 学历
	 */
	private String eduBgType;

	/**
	 * @Fields  : 年龄
	 */
	private Integer age;

	/**
	 * @Fields  : 手机号
	 */
	private String mobileNo;

	/**
	 * @Fields  : 电话号码
	 */
	private String telNo;

	/**
	 * @Fields  : qq号
	 */
	private String qqNo;

	/**
	 * @Fields  : 微信号
	 */
	private String wechatNo;

	/**
	 * @Fields  : 邮箱
	 */
	private String mail;

	/**
	 * @Fields  : 民族
	 */
	private String ethnicType;

	/**
	 * @Fields  : 驾驶证号
	 */
	private String licenseNo;

	/**
	 * @Fields  : 实际用车人
	 */
	private String driver;

	/**
	 * @Fields  : 用车人手机号
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