package cn.com.leadu.fms.pojo.finance.vo.contcharge;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.entity.ContCharge;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

/**
 * @author ningyangyang
 * @ClassName: ContChargeVo
 * @Description: 财务待收款载体
 * @date 2018-06-01
 */
@Data
public class ContChargeVo extends PageQuery<ContCharge> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 财务待收款id
	 * @author ningyangyang
	 */
	private String contChargeId;

	/**
	 * @Fields  : 业务类型
	 * @author ningyangyang
	 */
	private String chargeBizType;

	/**
	 * @Fields  : 业务号
	 * @author ningyangyang
	 */
	private String chargeBizId;

	/**
	 * @Fields  : 款项名称
	 * @author ningyangyang
	 */
	private String chargeFund;

	/**
	 * @Fields  : 应收款金额
	 * @author ningyangyang
	 */
	private BigDecimal chargeAmount;

	/**
	 * @Fields  : 实收款金额
	 * @author ningyangyang
	 */
	private BigDecimal chargeActualAmount;

	/**
	 * @Fields  : 抵扣金额
	 * @author ningyangyang
	 */
	private BigDecimal chargeDeductionAmount;

	/**
	 * @Fields  : 收款状态
	 * @author ningyangyang
	 */
	private String chargeStatus;

	/**
	 * @Fields  : 明细区分
	 * @author ningyangyang
	 */
	private String chargeDetailFlag;

	/**
	 * @Fields  : 备注
	 * @author ningyangyang
	 */
	private String memo;

	/**
	 * @Fields  : 财务待收款id
	 * @author ningyangyang
	 */
	private List<String> contChargeIds;

}