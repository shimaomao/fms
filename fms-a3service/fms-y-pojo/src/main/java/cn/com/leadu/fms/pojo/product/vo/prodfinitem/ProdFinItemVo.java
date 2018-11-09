package cn.com.leadu.fms.pojo.product.vo.prodfinitem;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.product.entity.ProdFinItem;
import lombok.Data;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ProdFinItemVo
 * @Description: 产品方案融资项目载体
 * @date 2018-04-06
 */
@Data
public class ProdFinItemVo extends PageQuery<ProdFinItem> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 产品融资项目ID
	 */
	private String prodFinItemId;

	/**
	 * @Fields  : 产品方案代码
	 */
	private String product;

	/**
	 * @Fields  : 融资项目代码
	 */
	private String finItem;

	/**
	 * @Fields  : 融资项目类型
	 */
	private String finItemType;

	/**
	 * @Fields  : 产品融资项目ID
	 */
	private List<String> prodFinItemIds;

}