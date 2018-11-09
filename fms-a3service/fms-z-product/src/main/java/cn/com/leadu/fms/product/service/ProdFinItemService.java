package cn.com.leadu.fms.product.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.product.entity.ProdFinItem;
import cn.com.leadu.fms.pojo.product.vo.prodfinitem.ProdFinItemVo;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ProdFinItemService
 * @Description: 产品方案融资项目业务层
 * @date 2018-04-06
 */
public interface ProdFinItemService {

	/**
	 * @Title:
	 * @Description: 分页查询产品方案融资项目
	 * @param prodFinItemVo
	 * @return PageInfoExtend<ProdFinItem>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-6 13:39:12
	 */
	PageInfoExtend<ProdFinItem> findProdFinItemsByPage(ProdFinItemVo prodFinItemVo);

	/**
	 * @Title:
	 * @Description:  根据prodFinItemId获取产品方案融资项目
	 * @param prodFinItemId
	 * @return ProdFinItem
	 * @throws
	 * @author liujinge
	 * @date 2018-4-6 13:39:12
	 */
	ProdFinItem findProdFinItemByProdFinItemId(String prodFinItemId);

	/**
	 * @Title:
	 * @Description:  根据product获取产品方案融资项目
	 * @param product
	 * @return List<ProdFinItemVo>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-6 13:39:12
	 */
	List<ProdFinItem> findProdFinItemByProduct(String product);

	void deleteProdFinItemByProducts(List<String> products);
}
