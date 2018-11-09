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
 * @ClassName: FinBackfill
 * @Description: 融资回填实体
 * @date 2018-05-11
 */
@Data
public class FinBackfill extends BaseEntity<FinBackfill> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 融资回填ID
	 * @author lijunjun
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String filBackfillId;

	/**
	 * @Fields  : 合同编号
	 * @author lijunjun
	 */
	private String contNo;

	/**
	 * @Fields  : 回填状态
	 * @author lijunjun
	 */
	private String filBackfillSts;

	/**
	 * @Fields  : 财务实际投资额
	 * @author lijunjun
	 */
	private BigDecimal investTotal;

	/**
	 * @Fields  : 财务实际融资额
	 * @author lijunjun
	 */
	private BigDecimal finTotal;

	/**
	 * @Fields  : 财务首付金额
	 * @author lijunjun
	 */
	private BigDecimal initAmount;

	/**
	 * @Fields  : 财务尾付金额
	 * @author lijunjun
	 */
	private BigDecimal finalAmount;

	/**
	 * @Fields  : 财务实际收益年利率
	 * @author lijunjun
	 */
	private BigDecimal intrstRateYear;

	/**
	 * @Fields  : 进项税金
	 * @author lijunjun
	 */
	private BigDecimal inputTax;

	/**
	 * @Fields  : 销项税金
	 * @author lijunjun
	 */
	private BigDecimal outputTax;

}