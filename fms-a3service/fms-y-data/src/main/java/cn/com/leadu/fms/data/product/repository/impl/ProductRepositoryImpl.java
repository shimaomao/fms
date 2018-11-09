package cn.com.leadu.fms.data.product.repository.impl;

import cn.com.leadu.fms.data.product.dao.ProductDao;
import cn.com.leadu.fms.data.product.repository.ProductRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.product.entity.Product;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.product.vo.product.ProductVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: ProductRepositoryImpl
 * @Description: 产品方案管理Repository 实现层
 * @date 2018-03-23
 */
@Repository
public class ProductRepositoryImpl extends AbstractBaseRepository<ProductDao, Product> implements ProductRepository {

    /**
     * @Title:
     * @Description: 新增产品方案管理
     * @param product
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @Override
    public int insertData(Product product) {
        return super.insert(product);
    }

    /**
     * @Title:
     * @Description: 批量保存产品方案管理
     * @param products
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @Override
    public int insertDataList(List<Product> products){
        return super.insertListByJdbcTemplate(products);
    }

    /**
     * @Title:
     * @Description: 修改产品方案管理
     * @param product
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @Override
    public int updateByPrimaryKeyData(Product product) {
        return super.updateByPrimaryKey(product);
    }

    /**
     * @Title:
     * @Description: 批量修改产品方案管理
     * @param products
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @Override
    public int updateByPrimaryKeyDataList(List<Product> products){
        return super.updateListByPrimaryKey(products);
    }

    /**
     * @Title:
     * @Description: 动态修改产品方案管理
     * @param product
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @Override
    public int updateByPrimaryKeySelectiveData(Product product) {
        return super.updateByPrimaryKeySelective(product);
    }

    /**
     * @Title:
     * @Description: 批量动态修改产品方案管理
     * @param products
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    public int updateByPrimaryKeySelectiveDataList(List<Product> products) {
        return super.updateListByPrimaryKeySelective(products);
    }

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
    @Override
    public int updateByExampleData(Product product, Example example) {
        return super.updateByExample(product,example);
    }
    
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
    @Override
    public int updateByExampleSelectiveData(Product product, Example example){
        return super.updateByExampleSelective(product,example);
    }
    
    /**
     * @Title:
     * @Description: 根据productId删除产品方案管理
     * @param product
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @Override
    public int deleteData(Product product) {
        return super.delete(product);
    }

    /**
     * @Title:
     * @Description: 根据productId集合批量删除产品方案管理
     * @param product
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    public int deleteDataList(List productIds,Product product){
        return super.deleteByIds(productIds,product);
    }

    /**
     * @Title:
     * @Description: 查询全部产品方案管理
     * @return List<Product>
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @Override
    public List<Product> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个产品方案管理
     * @param example
     * @return Product
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @Override
    public Product selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询产品方案管理
     * @param example
     * @return List<Product>
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @Override
    public List<Product> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过productId查询产品方案管理
     * @param productId
     * @return Product
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @Override
    public Product selectByPrimaryKey(Object productId) {
        return super.selectByPrimaryKey(productId);
    }
    
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
    @Override
    public PageInfoExtend<Product> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

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
    public PageInfoExtend<ProductVo> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

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
    @Override
    public List<ProductVo> selectProductVoListByGroupCodes(ProductVo productVo, List<String> groupCodes) {
        return baseDao.selectProductVoListByGroupCodes(productVo, groupCodes);
    }

    /**
     * @Title:
     * @Description: 根据产品代码 获取产品的有权限的车型代码
     * @param product 产品方案代码
     * @return List<String>
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @Override
    public List<String> selectVehicleCodeListByProduct(String product) {
        return baseDao.selectVehicleCodeListByProduct(product);
    }
    /**
     * @Title:
     * @Description: 根据产品方案Id取得产品方案
     * @param productId 产品方案Id
     * @return ProductVo
     * @throws
     * @author liujinge
     * @date 2018-3-10 17:39:58
     */
    @Override
    public ProductVo selectProductVoByProductId(String productId) {
        return baseDao.selectProductVoByProductId(productId);
    }
}
