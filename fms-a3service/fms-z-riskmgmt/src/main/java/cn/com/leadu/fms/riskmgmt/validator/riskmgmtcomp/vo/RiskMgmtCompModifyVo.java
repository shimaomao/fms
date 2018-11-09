package cn.com.leadu.fms.riskmgmt.validator.riskmgmtcomp.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtComp;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author liujinge
 * @ClassName: RiskMgmtCompVo
 * @Description: 风控企业信息修改时载体及验证
 * @date 2018-06-04
 */
@Data
public class RiskMgmtCompModifyVo extends BaseVo<RiskMgmtComp> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 风控企业信息id
	 * @author liujinge
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
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