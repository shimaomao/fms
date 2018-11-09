package cn.com.leadu.fms.data.product.repository;

import cn.com.leadu.fms.pojo.product.entity.Product;
import cn.com.leadu.fms.pojo.product.vo.product.ProductVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: ProductRepository
 * @Description: 产品方案管理Repository层
 * @date 2018-03-23
 */
public interface ProductRepository {

	/**
	 * @Title:
	 * @Description: 新增产品方案管理
	 * @param product
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-23 10:18:12
	 */
	int insertData(Product product);

	/**
	 * @Title:
	 * @Description: 批量保存产品方案管理
	 * @param products
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-23 10:18:12
	 */
	int insertDataList(List<Product> products);

	/**
	 * @Title:
	 * @Description: 修改产品方案管理
	 * @param product
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-23 10:18:12
	 */
	int updateByPrimaryKeyData(Product product);

	/**
	 * @Title:
	 * @Description: 批量修改产品方案管理
	 * @param products
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-23 10:18:12
	 */
	int updateByPrimaryKeyDataList(List<Product> products);

	/**
	 * @Title:
	 * @Description: 动态修改产品方案管理
	 * @param product
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-23 10:18:12
	 */
	int updateByPrimaryKeySelectiveData(Product product);

	/**
	 * @Title:
	 * @Description: 批量动态修改产品方案管理
	 * @param products
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-23 10:18:12
	 */
	int updateByPrimaryKeySelectiveDataList(List<Product> products);

	/**
	 * @Title:
	 * @Description: 根据条件修改产品方案管理
	 * @param product
	 * @param example
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-23 10:18:12
	 */
	int updateByExampleData(Product product, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改产品方案管理
	 * @param product
	 * @param example
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-23 10:18:12
	 */
	int updateByExampleSelectiveData(Product product, Example example);

	/**
	 * @Title:
	 * @Description: 根据productId删除产品方案管理
	 * @param product
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-23 10:18:12
	 */
	int deleteData(Product product);

	/**
	 * @Title:
	 * @Description: 根据productId集合批量删除产品方案管理
	 * @param productIds
	 * @param product
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-23 10:18:12
	 */
	int deleteDataList(List productIds, Product product);

	/**
	 * @Title:
	 * @Description: 查询全部产品方案管理
	 * @return List<Product>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-23 10:18:12
	 */
	List<Product> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个产品方案管理
	 * @param example
	 * @return Product
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-23 10:18:12
	 */
	Product selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询产品方案管理
	 * @param example
	 * @return List<Product>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-23 10:18:12
	 */
	List<Product> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过productId查询产品方案管理
	 * @param productId
	 * @return Product
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-23 10:18:12
	 */
	Product selectByPrimaryKey(Object productId);

	/**
	 * @Title:
	 * @Description: 分页查询产品方案管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<Product>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-23 10:18:12
	 */
	PageInfoExtend<Product> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询产品方案管理vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<Product>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-23 10:18:12
	 */
	PageInfoExtend<ProductVo> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 根据机构代码等查询条件，取得产品方案信息
	 * @param productVo 查询参数
	 * @param groupCodes 机构代码
	 * @return List<ProductVo>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	List<ProductVo> selectProductVoListByGroupCodes(ProductVo productVo, List<String> groupCodes);

	/**
	 * @Title:
	 * @Description: 根据产品代码 获取产品的有权限的车型代码
	 * @param product 产品方案代码
	 * @return List<String>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	List<String> selectVehicleCodeListByProduct(String product);
	/**
	 * @Title:
	 * @Description: 根据产品方案Id取得产品方案
	 * @param productId 产品方案Id
	 * @return ProductVo
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	ProductVo selectProductVoByProductId(String productId);
}
