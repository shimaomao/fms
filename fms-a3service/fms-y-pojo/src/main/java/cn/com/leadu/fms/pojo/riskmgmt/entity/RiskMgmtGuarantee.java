package cn.com.leadu.fms.pojo.riskmgmt.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author liujinge
 * @ClassName: RiskMgmtGuarantee
 * @Description: 风控担保人信息实体
 * @date 2018-06-04
 */
@Data
@EqualsAndHashCode(of = { "guaranteeName" })
public class RiskMgmtGuarantee extends BaseEntity<RiskMgmtGuarantee> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 风控企业信息id
	 * @author liujinge
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String riskMgmtGuaranteeId;

	/**
	 * @Fields  : 申请编号
	 * @author liujinge
	 */
	private String applyNo;

	/**
	 * @Fields  : 担保人
	 * @author liujinge
	 */
	private String guaranteeName;

	/**
	 * @Fields  : 担保人月收入总额
	 * @author liujinge
	 */
	private BigDecimal guaranteeAmount;

	/**
	 * @Fields  : 担保人收入负债比
	 * @author liujinge
	 */
	private BigDecimal guaranteeDebtRatio;

	/**
	 * @Fields  : 担保人月还贷金额
	 * @author liujinge
	 */
	private BigDecimal guaranteeRepay;

}