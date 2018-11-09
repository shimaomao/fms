package cn.com.leadu.fms.pojo.postbiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author wangxue
 * @ClassName: MonthlyRent
 * @Description: 月度租金到账率实体
 */
@Data
public class MonthlyRent extends BaseEntity<MonthlyRent> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 月度租金统计ID
	 * @author wangxue
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String monthlyRentId;

	/**
	 * @Fields  : 统计月份(YYYYMM)
	 * @author wangxue
	 */
	private String censusMonth;

	/**
	 * @Fields  : 本月应收金额
	 * @author wangxue
	 */
	private BigDecimal monthRent;

	/**
	 * @Fields  : 本月实收金额
	 * @author wangxue
	 */
	private BigDecimal receiptAmount;

	/**
	 * @Fields  : 累计逾期金额
	 * @author wangxue
	 */
	private BigDecimal overdueRent;

	/**
	 * @Fields  : 累计逾期实收金额
	 * @author wangxue
	 */
	private BigDecimal overdueReceipt;

	/**
	 * @Fields  : 本月应收客户数
	 * @author wangxue
	 */
	private Integer monthCount;

	/**
	 * @Fields  : 本月实收客户数
	 * @author wangxue
	 */
	private Integer receiptCount;

	/**
	 * @Fields  : 累计逾期客户数
	 * @author wangxue
	 */
	private Integer overdueCount;

	/**
	 * @Fields  : 累计逾期实收客户数
	 * @author wangxue
	 */
	private Integer overdueReCount;

}