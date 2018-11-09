package cn.com.leadu.fms.pojo.postbiz.vo.contcost;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.ContCost;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author wangxue
 * @ClassName: ContCostVo
 * @Description: 客户费用载体
 */
@Data
public class ContCostVo extends PageQuery<ContCost> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 客户费用ID
	 * @author wangxue
	 */
	private String contCostId;

	/**
	 * @Fields  : 合同编号
	 * @author wangxue
	 */
	private String contNo;

	/**
	 * @Fields  : 款项
	 * @author wangxue
	 */
	private String costItem;

	/**
	 * @Fields  : 类型
	 * @author wangxue
	 */
	private String costType;

	/**
	 * @Fields  : 金额
	 * @author wangxue
	 */
	private BigDecimal costAmount;

	/**
	 * @Fields  : 财务收款Id
	 * @author wangxue
	 */
	private String contReceiptId;

	/**
	 * @Fields  : 客户费用ID
	 * @author wangxue
	 */
	private List<String> contCostIds;

}