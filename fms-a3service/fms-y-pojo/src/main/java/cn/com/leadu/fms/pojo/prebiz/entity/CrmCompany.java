package cn.com.leadu.fms.pojo.prebiz.entity;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonAreaConstants;
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
 * @ClassName: CrmCompany
 * @Description: CRM企业信息实体
 * @date 2018-05-23
 */
@ExcelTitle(value = "CRM企业信息")
@Data
public class CrmCompany extends BaseEntity<CrmCompany> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 企业ID
	 * @author ningyangyang
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
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
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
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
	 * @Fields  : 企业联系人
	 */
	private String contactName;

	/**
	 * @Fields  : 联系人手机号
	 */
	private String contactMobno;

	/**
	 * @Fields  : 成立年限
	 * @author ningyangyang
	 */
	private String establYear;

	/**
	 * @Fields  : 财务辅助核算代码
	 * @author qiaomengnan
	 */
	private String finassCstmCode;

	/**
	 * @Fields  : 发票类型
	 * @author lijunjun
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
	 * @author ningyangyang
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


	@ExcelTitle(value = "公司名称",sort = 1,types = {ExcelTypeConstants.ONE})
	public String getName() {
		return name;
	}
	@ExcelTitle(value = "统一社会信用代码",sort = 2,types = {ExcelTypeConstants.ONE})
	public String getSocialCertifNo() {
		return socialCertifNo;
	}
	@ExcelTitle(value = "法定代表人",sort = 3,types = {ExcelTypeConstants.ONE})
	public String getCompLegalRep() {
		return compLegalRep;
	}
	@ExcelTitle(value = "法人证件类型",sort = 4,types = {ExcelTypeConstants.ONE},codeType = CommonCodeTypeConstants.CERTIF_TYPE)
	public String getCertifType() {
		return certifType;
	}
	@ExcelTitle(value = "证件号码",sort = 5,types = {ExcelTypeConstants.ONE})
	public String getCertifNo() {
		return certifNo;
	}
	@ExcelTitle(value = "法人手机号码",sort = 6,types = {ExcelTypeConstants.ONE})
	public String getMobileNo() {
		return mobileNo;
	}
	@ExcelTitle(value = "经营省份",sort = 7,types = {ExcelTypeConstants.ONE},areaType = CommonAreaConstants.BAS_AREA_VALUE)
	public String getCompProv() {
		return compProv;
	}
	@ExcelTitle(value = "经营城市",sort = 8,types = {ExcelTypeConstants.ONE},areaType = CommonAreaConstants.BAS_AREA_VALUE)
	public String getCompCity() {
		return compCity;
	}
	@ExcelTitle(value = "经营区县",sort = 9,types = {ExcelTypeConstants.ONE},areaType = CommonAreaConstants.BAS_AREA_VALUE)
	public String getCompCounty() {
		return compCounty;
	}
	@ExcelTitle(value = "经营详细地址",sort = 10,types = {ExcelTypeConstants.ONE})
	public String getCompAddr() {
		return compAddr;
	}
	@ExcelTitle(value = "经营地址类型",sort = 11,types = {ExcelTypeConstants.ONE},codeType = CommonCodeTypeConstants.COMPADDR_TYPE)
	public String getCompAddrType() {
		return compAddrType;
	}

	@ExcelTitle(value = "注册省份",sort = 12,types = {ExcelTypeConstants.ONE},areaType = CommonAreaConstants.BAS_AREA_VALUE)
	public String getRegisterProv() {
		return registerProv;
	}
	@ExcelTitle(value = "注册城市",sort = 13,types = {ExcelTypeConstants.ONE},areaType = CommonAreaConstants.BAS_AREA_VALUE)
	public String getRegisterCity() {
		return registerCity;
	}
	@ExcelTitle(value = "注册区县",sort = 14,types = {ExcelTypeConstants.ONE},areaType = CommonAreaConstants.BAS_AREA_VALUE)
	public String getRegisterCounty() {
		return registerCounty;
	}
	@ExcelTitle(value = "注册详细地址",sort = 15,types = {ExcelTypeConstants.ONE})
	public String getRegisterAddr() {
		return registerAddr;
	}
	@ExcelTitle(value = "注册资金",sort = 16,types = {ExcelTypeConstants.ONE})
	public String getRegCapital() {
		return regCapital;
	}
	@ExcelTitle(value = "企业联系电话",sort = 17,types = {ExcelTypeConstants.ONE})
	public String getCompTel() {
		return compTel;
	}
	@ExcelTitle(value = "经营地址类型",sort = 18,types = {ExcelTypeConstants.ONE},codeType = CommonCodeTypeConstants.COMP_TYPE)
	public String getCompType() {
		return compType;
	}
	@ExcelTitle(value = "成立年限",sort = 19,types = {ExcelTypeConstants.ONE})
	public String getEstablYear() {
		return establYear;
	}
	@ExcelTitle(value = "更新时间", sort =20,types = ExcelTypeConstants.ONE)
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(updateTime,DateUtils.formatStr_yyyyMMddHHmmss);
	}
	@ExcelTitle(value = "更新人员", sort =21,types = ExcelTypeConstants.ONE)
	public String getUpdater(){
		return updater;
	}
}