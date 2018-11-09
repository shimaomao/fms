package cn.com.leadu.fms.pojo.postbiz.vo.monthlyoverdue;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.MonthlyOverdue;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: MonthlyOverduesVo
 * @Description: 逾期率统计载体
 */
@Data
public class MonthlyOverduesVo extends PageQuery<MonthlyOverdue> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 逾期率统计ID
	 * @author wangxue
	 */
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

	/**
	 * @Fields  : 逾期率统计ID
	 * @author wangxue
	 */
	private List<String> monthlyOverdueIds;

	/**
	 * @Fields  : 零售逾期率
	 * @author wangxue
	 */
	private BigDecimal retailOverdueRate;

	/**
	 * @Fields  : 经销商逾期率
	 * @author wangxue
	 */
	private BigDecimal parOverdueRate;

	/**
	 * @Fields  : 总逾期率
	 * @author wangxue
	 */
	private BigDecimal totalOverdueRate;

	/**
	 * @Fields  : 逾期1-7占比
	 * @author wangxue
	 */
	private BigDecimal overdue1;

	/**
	 * @Fields  : 逾期8-15占比
	 * @author wangxue
	 */
	private BigDecimal overdue2;

	/**
	 * @Fields  : 逾期16-30占比
	 * @author wangxue
	 */
	private BigDecimal overdue3;

	/**
	 * @Fields  : 逾期31-60占比
	 * @author wangxue
	 */
	private BigDecimal overdue4;

	/**
	 * @Fields  : 逾期60-90占比
	 * @author wangxue
	 */
	private BigDecimal overdue5;

	/**
	 * @Fields  : 逾期90+占比
	 * @author wangxue
	 */
	private BigDecimal overdue6;

	/**
	 * @Fields  : 报表开始时间
	 * @author wangxue
	 */
	private String beginMonthlyOverdueDate;

	/**
	 * @Fields  : 报表结束时间
	 * @author wangxue
	 */
	private String endMonthlyOverdueDate;
	/**
	 * @Fields  : 零售逾期数据overdueType(0-6)
	 * @author wangxue
	 */
	private String orderRetailOverdue;
	/**
	 * @Fields  : 零售总应收数据overdueType(0-6)
	 * @author wangxue
	 */
	private String orderRetailAmount;
	/**
	 * @Fields  : 经销商逾期数据overdueType(0-6)
	 * @author wangxue
	 */
	private String orderParOverdue;
	/**
	 * @Fields  : 经销商总应收数据overdueType(0-6)
	 * @author wangxue
	 */
	private String orderParAmount;
	/**
	 * @Fields  : 总逾期数据overdueType(0-6)
	 * @author wangxue
	 */
	private String orderTotalOverdue;
	/**
	 * @Fields  : 总应收数据overdueType(0-6)
	 * @author wangxue
	 */
	private String orderTotalAmount;

	//零售逾期
	private BigDecimal retailOverdue1;
	private BigDecimal retailOverdue2;
	private BigDecimal retailOverdue3;
	private BigDecimal retailOverdue4;
	private BigDecimal retailOverdue5;
	private BigDecimal retailOverdue6;
	//经销商逾期
	private BigDecimal parOverdue1;
	private BigDecimal parOverdue2;
	private BigDecimal parOverdue3;
	private BigDecimal parOverdue4;
	private BigDecimal parOverdue5;
	private BigDecimal parOverdue6;
	//零售逾期占比
	private BigDecimal retailOverdueRatio1;
	private BigDecimal retailOverdueRatio2;
	private BigDecimal retailOverdueRatio3;
	private BigDecimal retailOverdueRatio4;
	private BigDecimal retailOverdueRatio5;
	private BigDecimal retailOverdueRatio6;
	//零售逾期率
	private BigDecimal retailOverdueRate1;
	private BigDecimal retailOverdueRate2;
	private BigDecimal retailOverdueRate3;
	private BigDecimal retailOverdueRate4;
	private BigDecimal retailOverdueRate5;
	private BigDecimal retailOverdueRate6;
	//经销商逾期占比
	private BigDecimal parOverdueRatio1;
	private BigDecimal parOverdueRatio2;
	private BigDecimal parOverdueRatio3;
	private BigDecimal parOverdueRatio4;
	private BigDecimal parOverdueRatio5;
	private BigDecimal parOverdueRatio6;
	//经销商逾期率
	private BigDecimal parOverdueRate1;
	private BigDecimal parOverdueRate2;
	private BigDecimal parOverdueRate3;
	private BigDecimal parOverdueRate4;
	private BigDecimal parOverdueRate5;
	private BigDecimal parOverdueRate6;
	//总逾期率
	private BigDecimal totalOverdueRate1;
	private BigDecimal totalOverdueRate2;
	private BigDecimal totalOverdueRate3;
	private BigDecimal totalOverdueRate4;
	private BigDecimal totalOverdueRate5;
	private BigDecimal totalOverdueRate6;







}