package cn.com.leadu.fms.pojo.finance.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: FinBackfillDetail
 * @Description: 融资回填明细实体
 * @date 2018-05-12
 */
@Data
public class FinBackfillDetail extends BaseEntity<FinBackfillDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 融资回填明细ID
	 * @author lijunjun
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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

	/**
	 * @Fields  : 是否只用来展示,0-否，1-是
	 * @author yangyiquan
	 */
	private String showDetail;

}