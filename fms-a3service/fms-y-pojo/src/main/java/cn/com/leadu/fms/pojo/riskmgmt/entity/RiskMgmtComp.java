package cn.com.leadu.fms.pojo.riskmgmt.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author liujinge
 * @ClassName: RiskMgmtComp
 * @Description: 风控企业信息实体
 * @date 2018-06-04
 */
@Data
public class RiskMgmtComp extends BaseEntity<RiskMgmtComp> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 风控企业信息id
	 * @author liujinge
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String riskMgmtCompId;

	/**
	 * @Fields  : 申请编号
	 * @author liujinge
	 */
	private String applyNo;

	/**
	 * @Fields  : 承租人年主营收入
	 * @author liujinge
	 */
	private BigDecimal lesseeRevenue;

	/**
	 * @Fields  : 承租人利润率
	 * @author liujinge
	 */
	private BigDecimal lesseeProfitRatio;

	/**
	 * @Fields  : 承租人月均利润
	 * @author liujinge
	 */
	private BigDecimal lesseeProfit;

	/**
	 * @Fields  : 收入负债比
	 * @author liujinge
	 */
	private BigDecimal lesseeDebtRatio;

	/**
	 * @Fields  : 承租人月均还贷金额
	 * @author liujinge
	 */
	private BigDecimal lesseeRepay;

	/**
	 * @Fields  : 购车每月租金
	 * @author liujinge
	 */
	private BigDecimal rent;

	/**
	 * @Fields  : 承租人月均负债总额
	 * @author liujinge
	 */
	private BigDecimal lesseeDebtAmount;

	/**
	 * @Fields  : 收入情况描述
	 * @author liujinge
	 */
	private String salaryMemo;

	/**
	 * @Fields  : 项目风险分析及操作建议
	 * @author liujinge
	 */
	private String riskMemo;

}