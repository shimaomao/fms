package cn.com.leadu.fms.pojo.riskmgmt.vo.riskmgmtperson;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtPerson;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskMgmtPersonVo
 * @Description: 风控个人信息载体
 * @date 2018-06-04
 */
@Data
public class RiskMgmtPersonVo extends PageQuery<RiskMgmtPerson> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 风控个人信息id
	 * @author liujinge
	 */
	private String riskMgmtPersonId;

	/**
	 * @Fields  : 申请编号
	 * @author liujinge
	 */
	private String applyNo;

	/**
	 * @Fields  : 承租人税后月薪
	 * @author liujinge
	 */
	private BigDecimal lesseeSalary;

	/**
	 * @Fields  : 承租人其他税后月薪
	 * @author liujinge
	 */
	private BigDecimal lesseeElseSalary;

	/**
	 * @Fields  : 承租人月收入总额
	 * @author liujinge
	 */
	private BigDecimal lesseeAmount;

	/**
	 * @Fields  : 承租人收入负债比
	 * @author liujinge
	 */
	private BigDecimal lesseeDebtRatio;

	/**
	 * @Fields  : 承租人月还贷金额
	 * @author liujinge
	 */
	private BigDecimal lesseeRepay;

	/**
	 * @Fields  : 购车每月租金
	 * @author liujinge
	 */
	private BigDecimal rent;

	/**
	 * @Fields  : 承租人月负债总额
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

	/**
	 * @Fields  : 风控个人信息id
	 * @author liujinge
	 */
	private List<String> riskMgmtPersonIds;

}