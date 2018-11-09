package cn.com.leadu.fms.product.validator.prodintrst.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.product.entity.ProdIntrst;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author niehaibing
 * @ClassName: ProdIntrstVo
 * @Description: 产品利率修改时载体及验证
 * @date 2018-03-27
 */
@Data
public class ProdIntrstModifyVo extends BaseVo<ProdIntrst> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 产品利率ID
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String prodIntrstId;

	/**
	 * @Fields  : 产品方案代码
	 */
	private String product;

	/**
	 * @Fields  : 利率方案序号
	 */
	private String intrstNo;

	/**
	 * @Fields  : 客户利率
	 */
	private BigDecimal intrstRate;

	/**
	 * @Fields  : 结算利率
	 */
	private BigDecimal settleIntrstRate;

	/**
	 * @Fields  : 手续费率
	 */
	private BigDecimal chargeRate;

	/**
	 * @Fields  : 结算手续费率
	 */
	private BigDecimal settleChargeRate;

	/**
	 * @Fields  : 一次性手续费
	 */
	private BigDecimal onetimeCharge;

	/**
	 * @Fields  : 贴息方式
	 */
	private String subsidyMode;

	/**
	 * @Fields  : 贴息利率
	 */
	private BigDecimal subsidyRate;

	/**
	 * @Fields  : 贴息年限
	 */
	private Integer subsidyYear;

	/**
	 * @Fields  : 贴息金额
	 */
	private BigDecimal subsidyAmount;

	/**
	 * @Fields  : 利率方式
	 */
	private String intrstRateMode;

}