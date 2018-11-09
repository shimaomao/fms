package cn.com.leadu.fms.cost.validator.monthlysettlement.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.cost.entity.MonthlySettlement;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;

/**
 * @author yangyiquan
 * @ClassName: MonthlySettlementVo
 * @Description: gps月结任务表修改时载体及验证
 * @date 2018-05-28
 */
@Data
public class MonthlySettlementModifyVo extends BaseVo<MonthlySettlement> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : gps月结任务id
	 * @author yangyiquan
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String monthlySettlementId;

	/**
	 * @Fields  : gps月结任务号
	 * @author yangyiquan
	 */
	private String monthlySettlementNo;

	/**
	 * @Fields  : 月结状态
	 * @author yangyiquan
	 */
	private String monthlySts;

	/**
	 * @Fields  : 月结合计金额
	 * @author yangyiquan
	 */
	private BigDecimal totalCost;

	/**
	 * @Fields  : 当前节点用户
	 * @author yangyiquan
	 */
	private String presentUser;

}