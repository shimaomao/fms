package cn.com.leadu.fms.product.validator.intrstfactor.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.product.entity.IntrstFactor;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;

/**
 * @author niehaibing
 * @ClassName: IntrstFactorVo
 * @Description: 利率因子修改时载体及验证
 * @date 2018-03-27
 */
@Data
public class IntrstFactorModifyVo extends BaseVo<IntrstFactor> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 利率因子ID
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String intrstFactorId;

	/**
	 * @Fields  : 因子代码
	 */
	private String factorCode;

	/**
	 * @Fields  : 因子名称
	 */
	private String factorName;

	/**
	 * @Fields  : 匹配类型*1-等于（checkbox）；2-区间（inputtext）
	 */
	private String factorType;

	/**
	 * @Fields  : 启用标志
	 */
	private String enableFlag;

	/**
	 * @Fields  : 排序
	 */
	private Integer orderNo;

}