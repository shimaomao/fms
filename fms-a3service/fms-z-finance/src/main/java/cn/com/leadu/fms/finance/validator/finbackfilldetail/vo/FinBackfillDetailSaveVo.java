package cn.com.leadu.fms.finance.validator.finbackfilldetail.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.FinBackfillDetail;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: FinBackfillDetailVo
 * @Description: 融资回填明细保存时载体及验证
 * @date 2018-05-12
 */
@Data
public class FinBackfillDetailSaveVo extends BaseVo<FinBackfillDetail> {

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

}