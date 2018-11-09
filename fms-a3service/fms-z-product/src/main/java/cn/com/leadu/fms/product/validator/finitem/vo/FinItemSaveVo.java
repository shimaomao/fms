package cn.com.leadu.fms.product.validator.finitem.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.product.entity.FinItem;
import cn.com.leadu.fms.product.validator.finitem.validator.FinItemValidator;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author niehaibing
 * @ClassName: FinItemVo
 * @Description: 融资项目管理保存时载体及验证
 * @date 2018-03-19
 */
@Data
public class FinItemSaveVo extends BaseVo<FinItem> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 融资项目ID
	 */
	private String finItemId;

	/**
	 * @Fields  : 融资项目代码
	 */
    @FinItemValidator(message = "融资费用信息已存在，请勿重复添加！")
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