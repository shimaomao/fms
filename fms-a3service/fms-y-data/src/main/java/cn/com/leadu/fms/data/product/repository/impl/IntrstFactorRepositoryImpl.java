package cn.com.leadu.fms.data.product.repository.impl;

import cn.com.leadu.fms.data.product.dao.IntrstFactorDao;
import cn.com.leadu.fms.data.product.repository.IntrstFactorRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.product.entity.IntrstFactor;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: IntrstFactorRepositoryImpl
 * @Description: 利率因子Repository 实现层
 * @date 2018-03-27
 */
@Repository
public class IntrstFactorRepositoryImpl extends AbstractBaseRepository<IntrstFactorDao, IntrstFactor> implements IntrstFactorRepository {

    /**
     * @Title:
     * @Description: 新增利率因子
     * @param intrstFactor
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    @Override
    public int insertData(IntrstFactor intrstFactor) {
        return super.insert(intrstFactor);
    }

    /**
     * @Title:
     * @Description: 批量保存利率因子
     * @param intrstFactors
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    @Override
    public int insertDataList(List<IntrstFactor> intrstFactors){
        return super.insertListByJdbcTemplate(intrstFactors);
    }

    /**
     * @Title:
     * @Description: 修改利率因子
     * @param intrstFactor
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    @Override
    public int updateByPrimaryKeyData(IntrstFactor intrstFactor) {
        return super.updateByPrimaryKey(intrstFactor);
    }

    /**
     * @Title:
     * @Description: 批量修改利率因子
     * @param intrstFactors
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    @Override
    public int updateByPrimaryKeyDataList(List<IntrstFactor> intrstFactors){
        return super.updateListByPrimaryKey(intrstFactors);
    }

    /**
     * @Title:
     * @Description: 动态修改利率因子
     * @param intrstFactor
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    @Override
    public int updateByPrimaryKeySelectiveData(IntrstFactor intrstFactor) {
        return super.updateByPrimaryKeySelective(intrstFactor);
    }

    /**
     * @Title:
     * @Description: 批量动态修改利率因子
     * @param intrstFactors
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    public int updateByPrimaryKeySelectiveDataList(List<IntrstFactor> intrstFactors) {
        return super.updateListByPrimaryKeySelective(intrstFactors);
    }

    /**
     * @Title:
     * @Description: 根据条件修改利率因子
     * @param intrstFactor
     * @param example
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    @Override
    public int updateByExampleData(IntrstFactor intrstFactor, Example example) {
        return super.updateByExample(intrstFactor,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改利率因子
     * @param intrstFactor
     * @param example
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    @Override
    public int updateByExampleSelectiveData(IntrstFactor intrstFactor, Example example){
        return super.updateByExampleSelective(intrstFactor,example);
    }
    
    /**
     * @Title:
     * @Description: 根据intrstFactorId删除利率因子
     * @param intrstFactor
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    @Override
    public int deleteData(IntrstFactor intrstFactor) {
        return super.delete(intrstFactor);
    }

    /**
     * @Title:
     * @Description: 根据intrstFactorId集合批量删除利率因子
     * @param intrstFactor
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    public int deleteDataList(List intrstFactorIds,IntrstFactor intrstFactor){
        return super.deleteByIds(intrstFactorIds,intrstFactor);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除利率因子
     * @param example
     * @param intrstFactor
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    public int deleteExampleData(Example example,IntrstFactor intrstFactor){
        return super.deleteByExample(example,intrstFactor);
    }

    /**
     * @Title:
     * @Description: 查询全部利率因子
     * @return List<IntrstFactor>
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    @Override
    public List<IntrstFactor> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个利率因子
     * @param example
     * @return IntrstFactor
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    @Override
    public IntrstFactor selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询利率因子
     * @param example
     * @return List<IntrstFactor>
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    @Override
    public List<IntrstFactor> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过intrstFactorId查询利率因子
     * @param intrstFactorId
     * @return IntrstFactor
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    @Override
    public IntrstFactor selectByPrimaryKey(Object intrstFactorId) {
        return super.selectByPrimaryKey(intrstFactorId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询利率因子
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<IntrstFactor>
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    @Override
    public PageInfoExtend<IntrstFactor> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询利率因子vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<IntrstFactor>
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    public PageInfoExtend<IntrstFactor> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
