package cn.com.leadu.fms.cost.validator.monthlypilferinsurance.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.cost.entity.MonthlyPilferInsurance;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author yangyiquan
 * @ClassName: MonthlyPilferInsuranceVo
 * @Description: 盗抢险月结任务信息保存时载体及验证
 * @date 2018-05-31
 */
@Data
public class MonthlyPilferInsuranceSaveVo extends BaseVo<MonthlyPilferInsurance> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 盗抢险月结任务id
	 * @author yangyiquan
	 */
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