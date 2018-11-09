package cn.com.leadu.fms.pojo.postbiz.vo.monthlyoverdue;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.MonthlyOverdue;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author wangxue
 * @ClassName: MonthlyOverdueVo
 * @Description: 逾期率统计载体
 */
@Data
public class MonthlyOverdueVo extends PageQuery<MonthlyOverdue> {

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

	/************************************** 数据统计的查询条件 *************************************/

	/**
	 * @Fields  : 申请类型1集合
	 * @author wangxue
	 */
	private List<String> companyTypeList;

	/**
	 * @Fields  : 最小逾期天数
	 * @author wangxue
	 */
	private Integer minOverdueDay;

	/**
	 * @Fields  : 最大逾期天数
	 * @author wangxue
	 */
	private Integer maxOverdueDay;

}