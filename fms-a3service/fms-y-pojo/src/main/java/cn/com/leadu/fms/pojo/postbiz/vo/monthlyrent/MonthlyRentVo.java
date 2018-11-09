package cn.com.leadu.fms.pojo.postbiz.vo.monthlyrent;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.MonthlyRent;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author wangxue
 * @ClassName: MonthlyRentVo
 * @Description: 月度租金到账率载体
 */
@Data
public class MonthlyRentVo extends PageQuery<MonthlyRent> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 月度租金统计ID
	 * @author wangxue
	 */
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

	/**
	 * @Fields  : 月度租金统计ID
	 * @author wangxue
	 */
	private List<String> monthlyRentIds;

}