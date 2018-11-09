package cn.com.leadu.fms.data.product.repository.impl;

import cn.com.leadu.fms.data.product.dao.ProdIntrstFactorDao;
import cn.com.leadu.fms.data.product.repository.ProdIntrstFactorRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.product.entity.ProdIntrstFactor;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.product.vo.prodintrstfactor.ProdIntrstFactorVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: ProdIntrstFactorRepositoryImpl
 * @Description: 产品利率Repository 实现层
 * @date 2018-03-27
 */
@Repository
public class ProdIntrstFactorRepositoryImpl extends AbstractBaseRepository<ProdIntrstFactorDao, ProdIntrstFactor> implements ProdIntrstFactorRepository {

    /**
     * @Title:
     * @Description: 新增产品利率
     * @param prodIntrstFactor
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @Override
    public int insertData(ProdIntrstFactor prodIntrstFactor) {
        return super.insert(prodIntrstFactor);
    }

    /**
     * @Title:
     * @Description: 批量保存产品利率
     * @param prodIntrstFactors
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @Override
    public int insertDataList(List<ProdIntrstFactor> prodIntrstFactors){
        return super.insertListByJdbcTemplate(prodIntrstFactors);
    }

    /**
     * @Title:
     * @Description: 修改产品利率
     * @param prodIntrstFactor
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @Override
    public int updateByPrimaryKeyData(ProdIntrstFactor prodIntrstFactor) {
        return super.updateByPrimaryKey(prodIntrstFactor);
    }

    /**
     * @Title:
     * @Description: 批量修改产品利率
     * @param prodIntrstFactors
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ProdIntrstFactor> prodIntrstFactors){
        return super.updateListByPrimaryKey(prodIntrstFactors);
    }

    /**
     * @Title:
     * @Description: 动态修改产品利率
     * @param prodIntrstFactor
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ProdIntrstFactor prodIntrstFactor) {
        return super.updateByPrimaryKeySelective(prodIntrstFactor);
    }

    /**
     * @Title:
     * @Description: 批量动态修改产品利率
     * @param prodIntrstFactors
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    public int updateByPrimaryKeySelectiveDataList(List<ProdIntrstFactor> prodIntrstFactors) {
        return super.updateListByPrimaryKeySelective(prodIntrstFactors);
    }

    /**
     * @Title:
     * @Description: 根据条件修改产品利率
     * @param prodIntrstFactor
     * @param example
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @Override
    public int updateByExampleData(ProdIntrstFactor prodIntrstFactor, Example example) {
        return super.updateByExample(prodIntrstFactor,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改产品利率
     * @param prodIntrstFactor
     * @param example
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @Override
    public int updateByExampleSelectiveData(ProdIntrstFactor prodIntrstFactor, Example example){
        return super.updateByExampleSelective(prodIntrstFactor,example);
    }
    
    /**
     * @Title:
     * @Description: 根据prodIntrstFactorId删除产品利率
     * @param prodIntrstFactor
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @Override
    public int deleteData(ProdIntrstFactor prodIntrstFactor) {
        return super.delete(prodIntrstFactor);
    }

    /**
     * @Title:
     * @Description: 根据prodIntrstFactorId集合批量删除产品利率
     * @param prodIntrstFactor
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    public int deleteDataList(List prodIntrstFactorIds,ProdIntrstFactor prodIntrstFactor){
        return super.deleteByIds(prodIntrstFactorIds,prodIntrstFactor);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除产品利率
     * @param example
     * @param prodIntrstFactor
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    public int deleteExampleData(Example example,ProdIntrstFactor prodIntrstFactor){
        return super.deleteByExample(example,prodIntrstFactor);
    }

    /**
     * @Title:
     * @Description: 查询全部产品利率
     * @return List<ProdIntrstFactor>
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @Override
    public List<ProdIntrstFactor> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个产品利率
     * @param example
     * @return ProdIntrstFactor
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @Override
    public ProdIntrstFactor selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询产品利率
     * @param example
     * @return List<ProdIntrstFactor>
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @Override
    public List<ProdIntrstFactor> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过prodIntrstFactorId查询产品利率
     * @param prodIntrstFactorId
     * @return ProdIntrstFactor
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @Override
    public ProdIntrstFactor selectByPrimaryKey(Object prodIntrstFactorId) {
        return super.selectByPrimaryKey(prodIntrstFactorId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询产品利率
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ProdIntrstFactor>
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @Override
    public PageInfoExtend<ProdIntrstFactor> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询产品利率vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<ProdIntrstFactor>
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    public PageInfoExtend<ProdIntrstFactor> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 根据机构代码等查询条件，取得产品方案信息
     * @param product 产品方案代码
     * @return List<ProdIntrstFactorVo>
     * @throws
     * @author wangxue
     * @date 2018-3-27 15:21:58
     */
    @Override
    public List<ProdIntrstFactorVo> selectProdIntrstFactorListByProduct(String product) {
        return baseDao.selectProdIntrstFactorListByProduct(product);
    }
}
