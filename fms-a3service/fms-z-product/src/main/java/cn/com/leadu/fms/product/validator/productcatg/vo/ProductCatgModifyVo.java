package cn.com.leadu.fms.product.validator.productcatg.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.product.entity.ProductCatg;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author niehaibing
 * @ClassName: ProductCatgVo
 * @Description: 产品大类管理修改时载体及验证
 * @date 2018-03-21
 */
@Data
public class ProductCatgModifyVo extends BaseVo<ProductCatg> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 产品大类ID
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String productCatgId;

	/**
	 * @Fields  : 产品大类代码
	 */
	private String productCatg;

	/**
	 * @Fields  : 产品大类名称
	 */
	private String productCatgName;

	/**
	 * @Fields  : 产品大类描述
	 */
	private String productCatgMemo;

	/**
	 * @Fields  : 车辆类型
	 */
	private String vehicleForm;

	/**
	 * @Fields  : 申请类型
	 */
	private String applyType;

	/**
	 * @Fields  : 车辆种类
	 */
	private String vehicleType;

	/**
	 * @Fields  : 启用标志
	 */
	private String enableFlag;

}