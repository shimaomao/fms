package cn.com.leadu.fms.pojo.finance.vo.finbackfilldetail;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.entity.FinBackfillDetail;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: FinBackfillDetailVo
 * @Description: 融资回填明细载体
 * @date 2018-05-12
 */
@Data
public class FinBackfillDetailVo extends PageQuery<FinBackfillDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 融资回填明细ID
	 * @author lijunjun
	 */
	private String finBackfillDetailId;

	/**
	 * @Fields  : 合同编号
	 * @author lijunjun
	 */
	private String contNo;

	/**
	 * @Fields  : 融资项目代码
	 * @author lijunjun
	 */
	private String finItem;

	/**
	 * @Fields  : 融资项目名称
	 * @author lijunjun
	 */
	private String finItemName;

	/**
	 * @Fields  : 融资项目年限
	 * @author lijunjun
	 */
	private Integer finItemYear;

	/**
	 * @Fields  : 融资费用金额
	 * @author lijunjun
	 */
	private BigDecimal finAmount;

	/**
	 * @Fields  : 实际支付金额
	 * @author lijunjun
	 */
	private BigDecimal actualFinAmount;

	/**
	 * @Fields  : 实际成本金额
	 * @author lijunjun
	 */
	private BigDecimal actualCostAmount;

	/**
	 * @Fields  : 实际税金金额
	 * @author lijunjun
	 */
	private BigDecimal actualTaxAmount;

	/**
	 * @Fields  : 是否收到发票
	 * @author lijunjun
	 */
	private String billReceiveFlag;

	/**
	 * @Fields  : 发票是否租赁公司抬头
	 * @author lijunjun
	 */
	private String billTitleFlag;

	/**
	 * @Fields  : 融资回填明细ID
	 * @author lijunjun
	 */
	private List<String> finBackfillDetailIds;

	/**
	 * @Fields  : 财务税率
	 */
	private BigDecimal finTax;

	/**
	 * @Fields  : 是否只用来展示,0-否，1-是
	 * @author yangyiquan
	 */
	private String showDetail;

}