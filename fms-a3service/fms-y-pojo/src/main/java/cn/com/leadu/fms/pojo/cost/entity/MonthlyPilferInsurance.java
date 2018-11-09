package cn.com.leadu.fms.pojo.cost.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author yangyiquan
 * @ClassName: MonthlyPilferInsurance
 * @Description: 盗抢险月结任务信息实体
 * @date 2018-05-31
 */
@Data
public class MonthlyPilferInsurance extends BaseEntity<MonthlyPilferInsurance> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 盗抢险月结任务id
	 * @author yangyiquan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String monthlyPilferInsuranceId;

	/**
	 * @Fields  : 盗抢险月结任务号
	 * @author yangyiquan
	 */
	private String monthlyPilferInsuranceNo;

	/**
	 * @Fields  : 月结状态
	 * @author yangyiquan
	 */
	private String monthlyPilferInsuranceSts;

	/**
	 * @Fields  : 合计金额
	 * @author yangyiquan
	 */
	private BigDecimal totalCost;

	/**
	 * @Fields  : 当前节点用户
	 * @author yangyiquan
	 */
	private String presentUser;

}