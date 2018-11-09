package cn.com.leadu.fms.product.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.product.entity.Product;
import cn.com.leadu.fms.pojo.product.vo.product.ProductVo;
import cn.com.leadu.fms.product.validator.product.vo.ProductDeleteListVo;
import cn.com.leadu.fms.product.validator.product.vo.ProductDeleteVo;
import cn.com.leadu.fms.product.validator.product.vo.ProductModifyVo;

import java.util.List;

/**
 * @author niehaibing
 * @ClassName: ProductService
 * @Description: 产品方案管理业务层
 * @date 2018-03-23
 */
public interface ProductService {

	/**
	 * @Title:
	 * @Description: 分页查询产品方案管理
	 * @param productVo
	 * @return PageInfoExtend<Product>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-23 10:18:12
	 */
	PageInfoExtend<ProductVo> findProductsByPage(ProductVo productVo);

	/**
	 * @Title:
	 * @Description: 保存产品方案管理
	 * @param productVo
	 * @return java.lang.String
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-23 10:18:12
	 */
    void saveProduct(ProductVo productVo);

	/**
	 * @Title:
	 * @Description: 修改产品方案管理
	 * @param productModifyVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-23 10:18:12
	 */
	void modifyProduct(ProductModifyVo productModifyVo);
	/**
	 * @Title:
	 * @Description:  根据产品方案代码，获取产品方案信息
	 * @param productId
	 * @return ProductVo
	 * @throws
	 * @author wangxue
	 * @date 2018-3-23 16:18:12
	 */

	ProductVo findProductVoByProductId(String productId);
	/**
	 * @Title:
	 * @Description:  通过productId删除产品方案管理
	 * @param productDeleteVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-23 10:18:12
	 */
	void deleteProduct(ProductDeleteVo productDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过productId集合删除产品方案管理
	 * @param productDeleteListVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-23 10:18:12
	 */
	void deleteProductsByProductIds(ProductDeleteListVo productDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据productId获取产品方案管理
	 * @param productId
	 * @return Product
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-23 10:18:12
	 */
	Product findProductByProductId(String productId);

	/**
	 * @Title:
	 * @Description:  根据机构代码等条件获取用户组及下层分组中的全部产品方案
	 * @param productVo
	 * @return List<ProductVo>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-23 16:18:12
	 */
	List<ProductVo> findProductVoListByGroupCodes(ProductVo productVo);

	/**
	 * @Title:
	 * @Description:  根据产品方案代码，获取产品方案信息
	 * @param product
	 * @return ProductVo
	 * @throws
	 * @author wangxue
	 * @date 2018-3-23 16:18:12
	 */
	ProductVo findProductVoByProduct(String product);

}
