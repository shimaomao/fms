package cn.com.leadu.fms.pojo.cost.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author yangyiquan
 * @ClassName: MonthlySettlement
 * @Description: gps月结任务表实体
 * @date 2018-05-28
 */
@Data
public class MonthlySettlement extends BaseEntity<MonthlySettlement> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : gps月结任务id
	 * @author yangyiquan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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