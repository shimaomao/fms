package cn.com.leadu.fms.prebiz.validator.guaranteecomp.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteeComp;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: GuaranteeCompVo
 * @Description: 担保企业信息修改时载体及验证
 * @date 2018-03-30
 */
@Data
public class GuaranteeCompModifyVo extends BaseVo<GuaranteeComp> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 担保企业id
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String guarCompId;

	/**
	 * @Fields  : 订单编号
	 */
	private String applyNo;

	/**
	 * @Fields  : 序号
	 */
	private String guarCompNo;

	/**
	 * @Fields  : 企业名称
	 */
	private String name;

	/**
	 * @Fields  : 担保人关系
	 */
	private String relation;

	/**
	 * @Fields  : 统一社会信用代码
	 */
	private String socialCertifNo;


	/**
	 * @Fields  : 企业性质
	 */
	private String compType;

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
	 * @Fields  : 企业联系人
	 */
	private String compContactPers;

	/**
	 * @Fields  : 联系人手机号
	 */
	private String contactMobno;

	/**
	 * @Fields  : 企业联系电话
	 */
	private String compTel;

	/**
	 * @Fields  : 企业所在省份
	 */
	private String compProv;

	/**
	 * @Fields  : 企业所在城市
	 */
	private String compCity;

	/**
	 * @Fields  : 企业所在区县
	 */
	private String compCounty;

	/**
	 * @Fields  : 企业详细地址
	 */
	private String compAddr;

	/**
	 * @Fields  : 担保人与担保人关系
	 */
	private String guaRelation;

	//地址信息
	/**
	 * @Fields  : 注册省份
	 */
	private String registerProv;

	/**
	 * @Fields  : 注册城市
	 */
	private String registerCity;

	/**
	 * @Fields  : 注册区县
	 */
	private String registerCounty;

	/**
	 * @Fields  : 注册地址
	 */
	private String registerAddr;

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
	 * @Fields  : 成立年限
	 */
	private String establYear;

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



}