package cn.com.leadu.fms.product.validator.prodintrstfactor.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.product.entity.ProdIntrstFactor;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;

/**
 * @author niehaibing
 * @ClassName: ProdIntrstFactorVo
 * @Description: 产品利率修改时载体及验证
 * @date 2018-03-27
 */
@Data
public class ProdIntrstFactorModifyVo extends BaseVo<ProdIntrstFactor> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 产品利率因子ID
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String prodIntrstFactorId;

	/**
	 * @Fields  : 产品方案代码
	 */
	private String product;

	/**
	 * @Fields  : 利率方案序号
	 */
	private String intrstNo;

	/**
	 * @Fields  : 因子代码
	 */
	private String factorCode;

	/**
	 * @Fields  : 因子值开始
	 */
	private String factorValueFrom;

	/**
	 * @Fields  : 因子值结束
	 */
	private String factorValueTo;

}