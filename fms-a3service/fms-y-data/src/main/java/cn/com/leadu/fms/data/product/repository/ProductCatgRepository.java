package cn.com.leadu.fms.data.product.repository;

import cn.com.leadu.fms.pojo.product.entity.ProductCatg;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: ProductCatgRepository
 * @Description: 产品大类管理Repository层
 * @date 2018-03-21
 */
public interface ProductCatgRepository {

	/**
	 * @Title:
	 * @Description: 新增产品大类管理
	 * @param productCatg
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-21 12:09:48
	 */
	int insertData(ProductCatg productCatg);

	/**
	 * @Title:
	 * @Description: 批量保存产品大类管理
	 * @param productCatgs
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-21 12:09:48
	 */
	int insertDataList(List<ProductCatg> productCatgs);

	/**
	 * @Title:
	 * @Description: 修改产品大类管理
	 * @param productCatg
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-21 12:09:48
	 */
	int updateByPrimaryKeyData(ProductCatg productCatg);

	/**
	 * @Title:
	 * @Description: 批量修改产品大类管理
	 * @param productCatgs
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-21 12:09:48
	 */
	int updateByPrimaryKeyDataList(List<ProductCatg> productCatgs);

	/**
	 * @Title:
	 * @Description: 动态修改产品大类管理
	 * @param productCatg
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-21 12:09:48
	 */
	int updateByPrimaryKeySelectiveData(ProductCatg productCatg);

	/**
	 * @Title:
	 * @Description: 批量动态修改产品大类管理
	 * @param productCatgs
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-21 12:09:48
	 */
	int updateByPrimaryKeySelectiveDataList(List<ProductCatg> productCatgs);

	/**
	 * @Title:
	 * @Description: 根据条件修改产品大类管理
	 * @param productCatg
	 * @param example
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-21 12:09:48
	 */
	int updateByExampleData(ProductCatg productCatg, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改产品大类管理
	 * @param productCatg
	 * @param example
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-21 12:09:48
	 */
	int updateByExampleSelectiveData(ProductCatg productCatg, Example example);

	/**
	 * @Title:
	 * @Description: 根据productCatgId删除产品大类管理
	 * @param productCatg
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-21 12:09:48
	 */
	int deleteData(ProductCatg productCatg);

	/**
	 * @Title:
	 * @Description: 根据productCatgId集合批量删除产品大类管理
	 * @param productCatgIds
	 * @param productCatg
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-21 12:09:48
	 */
	int deleteDataList(List productCatgIds, ProductCatg productCatg);

	/**
	 * @Title:
	 * @Description: 查询全部产品大类管理
	 * @return List<ProductCatg>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-21 12:09:48
	 */
	List<ProductCatg> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个产品大类管理
	 * @param example
	 * @return ProductCatg
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-21 12:09:48
	 */
	ProductCatg selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询产品大类管理
	 * @param example
	 * @return List<ProductCatg>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-21 12:09:48
	 */
	List<ProductCatg> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过productCatgId查询产品大类管理
	 * @param productCatgId
	 * @return ProductCatg
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-21 12:09:48
	 */
	ProductCatg selectByPrimaryKey(Object productCatgId);

	/**
	 * @Title:
	 * @Description: 分页查询产品大类管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ProductCatg>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-21 12:09:48
	 */
	PageInfoExtend<ProductCatg> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询产品大类管理vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<ProductCatg>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-21 12:09:48
	 */
	PageInfoExtend<ProductCatg> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
