package cn.com.leadu.fms.pojo.finance.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import java.math.BigDecimal;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 * @author ningyangyang
 * @ClassName: ContCharge
 * @Description: 财务待收款实体
 * @date 2018-06-01
 */
@Data
public class ContCharge extends BaseEntity<ContCharge> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 财务待收款id
	 * @author ningyangyang
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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