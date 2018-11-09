package cn.com.leadu.fms.product.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.product.entity.ProdGroup;
import cn.com.leadu.fms.pojo.product.vo.prodgroup.ProdGroupVo;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ProdGroupService
 * @Description: 产品方案机构权限业务层
 * @date 2018-04-05
 */
public interface ProdGroupService {

	/**
	 * @Title:
	 * @Description: 分页查询产品方案机构权限
	 * @param prodGroupVo
	 * @return PageInfoExtend<ProdGroup>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:36:32
	 */
	PageInfoExtend<ProdGroup> findProdGroupsByPage(ProdGroupVo prodGroupVo);


	/**
	 * @Title:
	 * @Description:  根据prodGroupId获取产品方案机构权限
	 * @param prodGroupId
	 * @return ProdGroup
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:36:32
	 */
	ProdGroup findProdGroupByProdGroupId(String prodGroupId);

	/**
	 * @Title:
	 * @Description:  根据prodGroupId获取产品方案机构权限
	 * @param product
	 * @return ProdGroup
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:36:32
	 */
	List<ProdGroup> findProdGroupsByProduct(String product);

	void deleteProdGroupsByProducts(List<String> products);
}
