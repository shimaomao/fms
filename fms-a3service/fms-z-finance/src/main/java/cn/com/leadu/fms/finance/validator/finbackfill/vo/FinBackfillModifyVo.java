package cn.com.leadu.fms.finance.validator.finbackfill.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.FinBackfill;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: FinBackfillVo
 * @Description: 融资回填修改时载体及验证
 * @date 2018-05-11
 */
@Data
public class FinBackfillModifyVo extends BaseVo<FinBackfill> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 融资回填ID
	 * @author lijunjun
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
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