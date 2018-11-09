package cn.com.leadu.fms.data.product.repository.impl;

import cn.com.leadu.fms.data.product.dao.ProductCatgDao;
import cn.com.leadu.fms.data.product.repository.ProductCatgRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.product.entity.ProductCatg;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: ProductCatgRepositoryImpl
 * @Description: 产品大类管理Repository 实现层
 * @date 2018-03-21
 */
@Repository
public class ProductCatgRepositoryImpl extends AbstractBaseRepository<ProductCatgDao, ProductCatg> implements ProductCatgRepository {

    /**
     * @Title:
     * @Description: 新增产品大类管理
     * @param productCatg
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @Override
    public int insertData(ProductCatg productCatg) {
        return super.insert(productCatg);
    }

    /**
     * @Title:
     * @Description: 批量保存产品大类管理
     * @param productCatgs
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @Override
    public int insertDataList(List<ProductCatg> productCatgs){
        return super.insertListByJdbcTemplate(productCatgs);
    }

    /**
     * @Title:
     * @Description: 修改产品大类管理
     * @param productCatg
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @Override
    public int updateByPrimaryKeyData(ProductCatg productCatg) {
        return super.updateByPrimaryKey(productCatg);
    }

    /**
     * @Title:
     * @Description: 批量修改产品大类管理
     * @param productCatgs
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ProductCatg> productCatgs){
        return super.updateListByPrimaryKey(productCatgs);
    }

    /**
     * @Title:
     * @Description: 动态修改产品大类管理
     * @param productCatg
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ProductCatg productCatg) {
        return super.updateByPrimaryKeySelective(productCatg);
    }

    /**
     * @Title:
     * @Description: 批量动态修改产品大类管理
     * @param productCatgs
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    public int updateByPrimaryKeySelectiveDataList(List<ProductCatg> productCatgs) {
        return super.updateListByPrimaryKeySelective(productCatgs);
    }

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
    @Override
    public int updateByExampleData(ProductCatg productCatg, Example example) {
        return super.updateByExample(productCatg,example);
    }
    
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
    @Override
    public int updateByExampleSelectiveData(ProductCatg productCatg, Example example){
        return super.updateByExampleSelective(productCatg,example);
    }
    
    /**
     * @Title:
     * @Description: 根据productCatgId删除产品大类管理
     * @param productCatg
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @Override
    public int deleteData(ProductCatg productCatg) {
        return super.delete(productCatg);
    }

    /**
     * @Title:
     * @Description: 根据productCatgId集合批量删除产品大类管理
     * @param productCatg
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    public int deleteDataList(List productCatgIds,ProductCatg productCatg){
        return super.deleteByIds(productCatgIds,productCatg);
    }

    /**
     * @Title:
     * @Description: 查询全部产品大类管理
     * @return List<ProductCatg>
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @Override
    public List<ProductCatg> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个产品大类管理
     * @param example
     * @return ProductCatg
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @Override
    public ProductCatg selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询产品大类管理
     * @param example
     * @return List<ProductCatg>
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @Override
    public List<ProductCatg> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过productCatgId查询产品大类管理
     * @param productCatgId
     * @return ProductCatg
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    @Override
    public ProductCatg selectByPrimaryKey(Object productCatgId) {
        return super.selectByPrimaryKey(productCatgId);
    }
    
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
    @Override
    public PageInfoExtend<ProductCatg> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

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
    public PageInfoExtend<ProductCatg> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
