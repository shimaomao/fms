package cn.com.leadu.fms.product.validator.finitem.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.product.entity.FinItem;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;

/**
 * @author niehaibing
 * @ClassName: FinItemVo
 * @Description: 融资项目管理修改时载体及验证
 * @date 2018-03-19
 */
@Data
public class FinItemModifyVo extends BaseVo<FinItem> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 融资项目ID
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String finItemId;

	/**
	 * @Fields  : 融资项目代码
	 */
	private String finItem;

	/**
	 * @Fields  : 融资项目名称
	 */
	private String finItemName;

	/**
	 * @Fields  : 牌照属性
	 */
	private String licenseAttr;

	/**
	 * @Fields  : 融资方式
	 */
	private String finMode;

	/**
	 * @Fields  : 是否可修改
	 */
	private String editMode;

	/**
	 * @Fields  : 是否和车款一起支付
	 */
	private String payMode;

	/**
	 * @Fields  : 排序
	 */
	private Integer orderNo;

	/**
	 * @Fields  : 财务税率
	 */
	private BigDecimal finTax;

}