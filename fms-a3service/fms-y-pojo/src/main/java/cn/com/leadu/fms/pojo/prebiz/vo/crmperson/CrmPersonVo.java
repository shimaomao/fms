package cn.com.leadu.fms.pojo.prebiz.vo.crmperson;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.CrmPerson;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ningyangyang
 * @ClassName: CrmPersonVo
 * @Description: CRM个人信息载体
 * @date 2018-05-23
 */
@Data
public class CrmPersonVo extends PageQuery<CrmPerson> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 客户id
	 * @author ningyangyang
	 */
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
	private Date firstIssueDate;

	/**
	 * @Fields  : 户口类别
	 * @author ningyangyang
	 */
	private String censusType;

	/**
	 * @Fields  : 出生日期
	 * @author ningyangyang
	 */
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
	private Date propertyGetDate;

	/**
	 * @Fields  : 房产评估值
	 * @author ningyangyang
	 */
	private BigDecimal propertyValue;

	/**
	 * @Fields  : 是否有房产
	 */
	private String isHaveProperty;

	/**
	 * @Fields  : 客户id
	 * @author ningyangyang
	 */
	private List<String> personIds;

	/**
	 * @Fields  : 准驾车型
	 * @author ningyangyang
	 */
	private String  quasiDriveModel;

	/**
	 * @Fields  : 财务辅助核算代码
	 * @author qiaomengnan
	 */
	private String finassCstmCode;

}