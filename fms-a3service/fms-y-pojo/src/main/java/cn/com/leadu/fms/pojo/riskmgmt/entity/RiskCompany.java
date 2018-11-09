package cn.com.leadu.fms.pojo.riskmgmt.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author liujinge
 * @ClassName: RiskCompany
 * @Description: 企业风险信息实体
 * @date 2018-06-04
 */
@Data
public class RiskCompany extends BaseEntity<RiskCompany> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 企业风险信息id
	 * @author liujinge
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String riskCompanyId;

	/**
	 * @Fields  : 申请编号
	 * @author liujinge
	 */
	private String applyNo;

	/**
	 * @Fields  : 关系类型
	 * @author liujinge
	 */
	private String relation;

	/**
	 * @Fields  : 姓名
	 * @author liujinge
	 */
	private String name;

	/**
	 * @Fields  : 企业风险信息
	 * @author liujinge
	 */
	private String corpRiskDebt;

	/**
	 * @Fields  : 企业债务信息
	 * @author liujinge
	 */
	private String corpDebt;

	/**
	 * @Fields  : 风险信息确认
	 * @author liujinge
	 */
	private String riskConfirm;

	/**
	 * @Fields  : 企业工商异常信息
	 * @author liujinge
	 */
	private String corpAbnornalMemo;

	/**
	 * @Fields  : 出租人城市和经营地址城市匹配
	 * @author liujinge
	 */
	private String applyAddrMatch;

}