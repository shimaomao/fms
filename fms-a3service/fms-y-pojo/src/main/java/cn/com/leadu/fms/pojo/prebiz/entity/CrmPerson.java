package cn.com.leadu.fms.pojo.prebiz.entity;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import cn.com.leadu.fms.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ningyangyang
 * @ClassName: CrmPerson
 * @Description: CRM个人信息实体
 * @date 2018-05-23
 */
@ExcelTitle(value = "CRM个人信息")
@Data
public class CrmPerson extends BaseEntity<CrmPerson> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 客户id
	 * @author ningyangyang
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String personId;

	/**
	 * @Fields  : 客户姓名
	 * @author ningyangyang
	 */

	private String name;

	/**
	 * @Fields  : 证件类型
	 * @author ningyangyang
	 */
	private String certifType;

	/**
	 * @Fields  : 证件号码
	 * @author ningyangyang
	 */
	private String certifNo;

	/**
	 * @Fields  : 客户性别
	 * @author ningyangyang
	 */
	private String sex;

	/**
	 * @Fields  : 婚姻状况
	 * @author ningyangyang
	 */
	private String marriageStatus;

	/**
	 * @Fields  : 配偶姓名
	 * @author ningyangyang
	 */
	private String mateName;

	/**
	 * @Fields  : 配偶证件类型
	 * @author ningyangyang
	 */
	private String mateCertifType;

	/**
	 * @Fields  : 配偶证件号码
	 * @author ningyangyang
	 */
	private String mateCertifNo;

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
	private String  quasiDriveModel;

	/**
	 * @Fields  : 户口类别
	 * @author ningyangyang
	 */
	private String censusType;

	/**
	 * @Fields  : 出生日期
	 * @author ningyangyang
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date birthDate;

	/**
	 * @Fields  : 客户学历
	 * @author ningyangyang
	 */
	private String eduBgType;

	/**
	 * @Fields  : 生肖
	 * @author ningyangyang
	 */
	private String chineseZodiac;

	/**
	 * @Fields  : 手机号码
	 * @author ningyangyang
	 */
	private String mobileNo;

	/**
	 * @Fields  : 住宅电话
	 * @author ningyangyang
	 */
	private String telNo;

	/**
	 * @Fields  : QQ号码
	 * @author ningyangyang
	 */
	private String qqNo;

	/**
	 * @Fields  : 微信号
	 * @author ningyangyang
	 */
	private String wechatNo;

	/**
	 * @Fields  : 电子邮件
	 * @author ningyangyang
	 */
	private String mail;

	/**
	 * @Fields  : 客户民族
	 * @author ningyangyang
	 */
	private String ethnicType;

	/**
	 * @Fields  : 驾驶证号
	 * @author ningyangyang
	 */
	private String licenseNo;

	/**
	 * @Fields  : 单位名称
	 * @author ningyangyang
	 */
	private String compName;

	/**
	 * @Fields  : 单位电话
	 * @author ningyangyang
	 */
	private String compTel;

	/**
	 * @Fields  : 在职年限
	 * @author ningyangyang
	 */
	private String workYear;

	/**
	 * @Fields  : 职业
	 * @author ningyangyang
	 */
	private String profession;

	/**
	 * @Fields  : 职位
	 * @author ningyangyang
	 */
	private String position;

	/**
	 * @Fields  : 单位所属行业类别
	 * @author ningyangyang
	 */
	private String industry;

	/**
	 * @Fields  : 单位所在省
	 * @author ningyangyang
	 */
	private String compProv;

	/**
	 * @Fields  : 单位所在市
	 * @author ningyangyang
	 */
	private String compCity;

	/**
	 * @Fields  : 单位所在区县
	 * @author ningyangyang
	 */
	private String compCounty;

	/**
	 * @Fields  : 单位所在详细地址
	 * @author ningyangyang
	 */
	private String compAddr;

	/**
	 * @Fields  : 税后年薪(万元)
	 * @author ningyangyang
	 */
	private BigDecimal salary;

	/**
	 * @Fields  : 其他税后年薪(万元)
	 * @author ningyangyang
	 */
	private BigDecimal elseSalary;

	/**
	 * @Fields  : 收入来源描述
	 * @author ningyangyang
	 */
	private String sourceIncomeDes;

	/**
	 * @Fields  : 居住状况
	 * @author ningyangyang
	 */
	private String resideCond;

	/**
	 * @Fields  : 居住年限
	 * @author ningyangyang
	 */
	private String resideYear;

	/**
	 * @Fields  : 居住省份
	 * @author ningyangyang
	 */
	private String resideProv;

	/**
	 * @Fields  : 居住城市
	 * @author ningyangyang
	 */
	private String resideCity;

	/**
	 * @Fields  : 居住区县
	 * @author ningyangyang
	 */
	private String resideCounty;

	/**
	 * @Fields  : 居住详细地址
	 * @author ningyangyang
	 */
	private String resideAddr;

	/**
	 * @Fields  : 户籍省份
	 * @author ningyangyang
	 */
	private String censusProv;

	/**
	 * @Fields  : 户籍城市
	 * @author ningyangyang
	 */
	private String censusCity;

	/**
	 * @Fields  : 户籍区县
	 * @author ningyangyang
	 */
	private String censusCounty;

	/**
	 * @Fields  : 户籍详细地址
	 * @author ningyangyang
	 */
	private String censusAddr;

	/**
	 * @Fields  : 是否有房产
	 */
	private String isHaveProperty;

	/**
	 * @Fields  : 房产类型
	 * @author ningyangyang
	 */
	private String propertyType;

	/**
	 * @Fields  : 房产省份
	 * @author ningyangyang
	 */
	private String propertyProv;

	/**
	 * @Fields  : 房产城市
	 * @author ningyangyang
	 */
	private String propertyCity;

	/**
	 * @Fields  : 房产区县
	 * @author ningyangyang
	 */
	private String propertyCounty;

	/**
	 * @Fields  : 房产详细地址
	 * @author ningyangyang
	 */
	private String propertyAddr;

	/**
	 * @Fields  : 房产建筑面积
	 * @author ningyangyang
	 */
	private String propertySize;

	/**
	 * @Fields  : 房产购买时间
	 * @author ningyangyang
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date propertyGetDate;

	/**
	 * @Fields  : 房产评估值
	 * @author ningyangyang
	 */
	private BigDecimal propertyValue;

	/**
	 * @Fields  : 财务辅助核算代码
	 * @author qiaomengnan
	 */
	private String finassCstmCode;

	@ExcelTitle(value = "客户姓名",sort = 1,types = {ExcelTypeConstants.ONE})
	public String getName() {
		return name;
	}
	@ExcelTitle(value = "证件类型",sort = 2,types = {ExcelTypeConstants.ONE},codeType = CommonCodeTypeConstants.CERTIF_TYPE)
	public String getCertifType() {
		return certifType;
	}
	@ExcelTitle(value = "证件号码",sort = 3,types = {ExcelTypeConstants.ONE})
	public String getCertifNo() {
		return certifNo;
	}
	@ExcelTitle(value = "客户性别",sort = 4,types = {ExcelTypeConstants.ONE},codeType = CommonCodeTypeConstants.GENDER)
	public String getSex() {
		return sex;
	}
	@ExcelTitle(value = "婚姻状况",sort = 5,types = {ExcelTypeConstants.ONE},codeType = CommonCodeTypeConstants.MARRIAGE_STATUS)
	public String getMarriageStatus() {
		return marriageStatus;
	}
	@ExcelTitle(value = "配偶姓名",sort = 6,types = {ExcelTypeConstants.ONE})
	public String getMateName() {
		return mateName;
	}
	@ExcelTitle(value = "配偶证件类型",sort = 7,types = {ExcelTypeConstants.ONE},codeType = CommonCodeTypeConstants.CERTIF_TYPE)
	public String getMateCertifType() {
		return mateCertifType;
	}
	@ExcelTitle(value = "配偶证件号码",sort = 8,types = {ExcelTypeConstants.ONE})
	public String getMateCertifNo() {
		return mateCertifNo;
	}
	@ExcelTitle(value = "首次领证时间",sort = 9,types = {ExcelTypeConstants.ONE})
	public String getFirstIssueDateStr() {
		return DateUtils.dateToStr(firstIssueDate,DateUtils.formatStr_yyyyMMdd);
	}
	@ExcelTitle(value = "户口类型",sort = 10,types = {ExcelTypeConstants.ONE},codeType = CommonCodeTypeConstants.CENSUS_TYPE)
	public String getCensusType() {
		return censusType;
	}
	@ExcelTitle(value = "出生日期",sort = 11,types = {ExcelTypeConstants.ONE})
	public String getBirthDateStr() {
		return DateUtils.dateToStr(birthDate,DateUtils.formatStr_yyyyMMdd);
	}
	@ExcelTitle(value = "客户学历",sort = 12,types = {ExcelTypeConstants.ONE},codeType = CommonCodeTypeConstants.EDU_BG_TYPE)
	public String getEduBgType() {
		return eduBgType;
	}
	@ExcelTitle(value = "手机号码",sort = 13,types = {ExcelTypeConstants.ONE})
	public String getMobileNo() {
		return mobileNo;
	}
	@ExcelTitle(value = "电话号码",sort = 14,types = {ExcelTypeConstants.ONE})
	public String getTelNo() {
		return telNo;
	}
	@ExcelTitle(value = "QQ号",sort = 15,types = {ExcelTypeConstants.ONE})
	public String getQqNo() {
		return qqNo;
	}
	@ExcelTitle(value = "微信号",sort = 16,types = {ExcelTypeConstants.ONE})
	public String getWechatNo() {
		return wechatNo;
	}
	@ExcelTitle(value = "邮箱",sort = 17,types = {ExcelTypeConstants.ONE})
	public String getMail() {
		return mail;
	}
	@ExcelTitle(value = "客户民族",sort = 18,types = {ExcelTypeConstants.ONE},codeType = CommonCodeTypeConstants.ETHNIC_TYPE)
	public String getEthnicType() {
		return ethnicType;
	}
	@ExcelTitle(value = "驾驶证号",sort = 19,types = {ExcelTypeConstants.ONE})
	public String getLicenseNo() {
		return licenseNo;
	}
	@ExcelTitle(value = "公司名称",sort = 20,types = {ExcelTypeConstants.ONE})
	public String getCompName() {
		return compName;
	}
	@ExcelTitle(value = "公司电话号码",sort = 21,types = {ExcelTypeConstants.ONE})
	public String getCompTel() {
		return compTel;
	}
	@ExcelTitle(value = "工作年限",sort = 22,types = {ExcelTypeConstants.ONE})
	public String getWorkYear() {
		return workYear;
	}
	@ExcelTitle(value = "客户职业",sort = 23,types = {ExcelTypeConstants.ONE},codeType = CommonCodeTypeConstants.PROFESSION_TYPE)
	public String getProfession() {
		return profession;
	}
	@ExcelTitle(value = "客户职位",sort = 24,types = {ExcelTypeConstants.ONE},codeType = CommonCodeTypeConstants.POSITION_TYPE)
	public String getPosition() {
		return position;
	}
	@ExcelTitle(value = "更新时间", sort =25,types = ExcelTypeConstants.ONE)
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(updateTime,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新人员", sort =26,types = ExcelTypeConstants.ONE)
	public String getUpdater(){
		return updater;
	}
}