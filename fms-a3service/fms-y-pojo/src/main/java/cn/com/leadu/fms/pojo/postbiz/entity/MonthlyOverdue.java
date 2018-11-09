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
 * @ClassName: MonthlyOverdue
 * @Description: 逾期率统计实体
 */
@Data
public class MonthlyOverdue extends BaseEntity<MonthlyOverdue> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 逾期率统计ID
	 * @author wangxue
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String monthlyOverdueId;

	/**
	 * @Fields  : 统计月份(YYYYMM)
	 * @author wangxue
	 */
	private String censusMonth;

	/**
	 * @Fields  : 生成时间
	 * @author wangxue
	 */
	private Date analyseTime;

	/**
	 * @Fields  : 零售逾期
	 * @author wangxue
	 */
	private BigDecimal retailOverdue;

	/**
	 * @Fields  : 经销商逾期
	 * @author wangxue
	 */
	private BigDecimal parOverdue;

	/**
	 * @Fields  : 总逾期
	 * @author wangxue
	 */
	private BigDecimal totalOverdue;

	/**
	 * @Fields  : 零售总应收
	 * @author wangxue
	 */
	private BigDecimal retailAmount;

	/**
	 * @Fields  : 经销商总应收
	 * @author wangxue
	 */
	private BigDecimal parAmount;

	/**
	 * @Fields  : 总应收
	 * @author wangxue
	 */
	private BigDecimal totalAmount;

	/**
	 * @Fields  : 逾期类型
	 * @author wangxue
	 */
	private String overdueType;

}