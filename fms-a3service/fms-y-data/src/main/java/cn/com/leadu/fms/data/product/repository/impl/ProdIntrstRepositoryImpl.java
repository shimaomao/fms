package cn.com.leadu.fms.data.product.repository.impl;

import cn.com.leadu.fms.data.product.dao.ProdIntrstDao;
import cn.com.leadu.fms.data.product.repository.ProdIntrstRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.product.entity.ProdIntrst;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: ProdIntrstRepositoryImpl
 * @Description: 产品利率Repository 实现层
 * @date 2018-03-27
 */
@Repository
public class ProdIntrstRepositoryImpl extends AbstractBaseRepository<ProdIntrstDao, ProdIntrst> implements ProdIntrstRepository {

    /**
     * @Title:
     * @Description: 新增产品利率
     * @param prodIntrst
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @Override
    public int insertData(ProdIntrst prodIntrst) {
        return super.insert(prodIntrst);
    }

    /**
     * @Title:
     * @Description: 批量保存产品利率
     * @param prodIntrsts
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @Override
    public int insertDataList(List<ProdIntrst> prodIntrsts){
        return super.insertListByJdbcTemplate(prodIntrsts);
    }

    /**
     * @Title:
     * @Description: 修改产品利率
     * @param prodIntrst
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @Override
    public int updateByPrimaryKeyData(ProdIntrst prodIntrst) {
        return super.updateByPrimaryKey(prodIntrst);
    }

    /**
     * @Title:
     * @Description: 批量修改产品利率
     * @param prodIntrsts
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ProdIntrst> prodIntrsts){
        return super.updateListByPrimaryKey(prodIntrsts);
    }

    /**
     * @Title:
     * @Description: 动态修改产品利率
     * @param prodIntrst
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ProdIntrst prodIntrst) {
        return super.updateByPrimaryKeySelective(prodIntrst);
    }

    /**
     * @Title:
     * @Description: 批量动态修改产品利率
     * @param prodIntrsts
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    public int updateByPrimaryKeySelectiveDataList(List<ProdIntrst> prodIntrsts) {
        return super.updateListByPrimaryKeySelective(prodIntrsts);
    }

    /**
     * @Title:
     * @Description: 根据条件修改产品利率
     * @param prodIntrst
     * @param example
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @Override
    public int updateByExampleData(ProdIntrst prodIntrst, Example example) {
        return super.updateByExample(prodIntrst,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改产品利率
     * @param prodIntrst
     * @param example
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @Override
    public int updateByExampleSelectiveData(ProdIntrst prodIntrst, Example example){
        return super.updateByExampleSelective(prodIntrst,example);
    }
    
    /**
     * @Title:
     * @Description: 根据prodIntrstId删除产品利率
     * @param prodIntrst
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @Override
    public int deleteData(ProdIntrst prodIntrst) {
        return super.delete(prodIntrst);
    }

    /**
     * @Title:
     * @Description: 根据prodIntrstId集合批量删除产品利率
     * @param prodIntrst
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    public int deleteDataList(List prodIntrstIds,ProdIntrst prodIntrst){
        return super.deleteByIds(prodIntrstIds,prodIntrst);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除产品利率
     * @param example
     * @param prodIntrst
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    public int deleteExampleData(Example example,ProdIntrst prodIntrst){
        return super.deleteByExample(example,prodIntrst);
    }

    /**
     * @Title:
     * @Description: 查询全部产品利率
     * @return List<ProdIntrst>
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @Override
    public List<ProdIntrst> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个产品利率
     * @param example
     * @return ProdIntrst
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @Override
    public ProdIntrst selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询产品利率
     * @param example
     * @return List<ProdIntrst>
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @Override
    public List<ProdIntrst> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过prodIntrstId查询产品利率
     * @param prodIntrstId
     * @return ProdIntrst
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @Override
    public ProdIntrst selectByPrimaryKey(Object prodIntrstId) {
        return super.selectByPrimaryKey(prodIntrstId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询产品利率
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ProdIntrst>
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @Override
    public PageInfoExtend<ProdIntrst> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询产品利率vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<ProdIntrst>
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    public PageInfoExtend<ProdIntrst> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 查询最大的利率方案序号
     * @param product
     * @return String
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    public String selectIntrstNoMax(String product){
        return baseDao.selectIntrstNoMax(product);
    }
}
