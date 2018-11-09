package cn.com.leadu.fms.prebiz.validator.guaranteepers.vo;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteePers;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ningyangyang
 * @ClassName: GuaranteePersVo
 * @Description: 担保个人信息保存时载体及验证
 * @date 2018-03-30
 */
@Data
public class GuaranteePersSaveVo extends BaseVo<GuaranteePers> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 担保个人id
	 */
	private String guarPersId;

	/**
	 * @Fields  : 订单编号
	 */
	private String applyNo;

	/**
	 * @Fields  : 序号
	 */
	private String guarPersNo;

	/**
	 * @Fields  : 担保人姓名
	 */
	private String name;

	/**
	 * @Fields  : 承租人与担保人关系
	 */
	private String relation;

	/**
	 * @Fields  : 担保人与担保人关系
	 */
	private String guaRelation;

	/**
	 * @Fields  : 证件类型
	 */
	private String certifType;

	/**
	 * @Fields  : 证件号码
	 */
	private String certifNo;

	/**
	 * @Fields  : 性别
	 */
	private String sex;

	/**
	 * @Fields  : 生日
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date birthDate;

	/**
	 * @Fields  : 婚姻状况
	 * @author ningyangyang
	 */
	private String marriageStatus;

	/**
	 * @Fields  : 手机号码
	 */
	private String mobileNo;

	/**
	 * @Fields  : 电话号码
	 */
	private String telNo;

//	/**
//	 * @Fields  : 居住省份
//	 */
//	private String resideProv;
//
//	/**
//	 * @Fields  : 居住城市
//	 */
//	private String resideCity;
//
//	/**
//	 * @Fields  : 居住区县
//	 */
//	private String resideCounty;
//
//	/**
//	 * @Fields  : 居住详细地址
//	 */
//	private String resideAddr;

	/**
	 * @Fields  : 单位名称
	 */
	private String compName;

	/**
	 * @Fields  : 单位电话
	 */
	private String compTel;

	/**
	 * @Fields  : 工作年限
	 */
	private String workYear;

	/**
	 * @Fields  : 职业
	 */
	private String profession;

	/**
	 * @Fields  : 职位
	 */
	private String position;

	/**
	 * @Fields  : 单位所属类型
	 */
	private String industry;

	/**
	 * @Fields  : 单位所在省份
	 */
	private String compProv;

	/**
	 * @Fields  : 单位所在市
	 */
	private String compCity;

	/**
	 * @Fields  : 单位所在区县
	 */
	private String compCounty;

	/**
	 * @Fields  : 单位详细地址
	 */
	private String compAddr;

	/**
	 * @Fields  : 年薪(万元)
	 */
	private BigDecimal salary;

	//配偶信息
	/**
	 * @Fields  : 配偶姓名
	 */
	private String mateName;

	/**
	 * @Fields  : 配偶证件类型
	 */
	private String mateCertifType;

	/**
	 * @Fields  : 配偶证件号码
	 */
	private String mateCertifNo;

	/**
	 * @Fields  :配偶手机号码
	 */
	private String mateMobileNo;

	/**
	 * @Fields  :配偶企业名称
	 */
	private String mateCompName;

	/**
	 * @Fields  :配偶企业电话
	 */
	private String mateCompTel;

	/**
	 * @Fields  :配偶职位
	 */
	private String matePosition;

	/**
	 * @Fields  : 配偶薪资
	 */
	private BigDecimal mateSalary;

	/**
	 * @Fields  :配偶单位所在省份
	 */
	private String mateCompProv;

	/**
	 * @Fields  :配偶单位所在城市
	 */
	private String mateCompCity;

	/**
	 * @Fields  :配偶单位所在区县
	 */
	private String mateCompCounty;

	/**
	 * @Fields  :配偶单位详细地址
	 */
	private String mateCompAddr;

	//地址信息

	/**
	 * @Fields  : 居住状况
	 */
	private String resideCond;

	/**
	 * @Fields  : 居住年份
	 */
	private String resideYear;

	/**
	 * @Fields  : 居住省份
	 */
	private String resideProv;

	/**
	 * @Fields  : 居住城市
	 */
	private String resideCity;

	/**
	 * @Fields  : 居住区县
	 */
	private String resideCounty;

	/**
	 * @Fields  : 居住详细地址
	 */
	private String resideAddr;

	/**
	 * @Fields  : 户籍省份
	 */
	private String censusProv;

	/**
	 * @Fields  : 户籍城市
	 */
	private String censusCity;

	/**
	 * @Fields  : 户籍区县
	 */
	private String censusCounty;

	/**
	 * @Fields  : 户籍详细地址
	 */
	private String censusAddr;

	/**
	 * @Fields  : 房产类型
	 */
	private String propertyType;

	/**
	 * @Fields  : 房产省份
	 */
	private String propertyProv;

	/**
	 * @Fields  : 房产城市
	 */
	private String propertyCity;

	/**
	 * @Fields  : 房产区县
	 */
	private String propertyCounty;

	/**
	 * @Fields  : 房产详细地址
	 */
	private String propertyAddr;

	/**
	 * @Fields  : 是否有房产
	 */
	private String isHaveProperty;

	/**
	 * @Fields  : 房产建筑面积
	 */
	private String propertySize;

	/**
	 * @Fields  : 是否共同擔保人
	 */
	private String isCommGuarantee;

	/**
	 * @Fields  : 是否配偶
	 */
	private String whetherSpouse ;

}