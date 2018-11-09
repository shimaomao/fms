package cn.com.leadu.fms.finance.validator.contcharge.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.ContCharge;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ningyangyang
 * @ClassName: ContChargeVo
 * @Description: 财务待收款修改时载体及验证
 * @date 2018-06-01
 */
@Data
public class ContChargeModifyVo extends BaseVo<ContCharge> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 财务待收款id
	 * @author ningyangyang
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
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

}