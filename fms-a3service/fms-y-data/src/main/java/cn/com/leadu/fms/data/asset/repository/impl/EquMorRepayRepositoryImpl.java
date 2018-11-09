package cn.com.leadu.fms.data.asset.repository.impl;

import cn.com.leadu.fms.data.asset.dao.EquMorRepayDao;
import cn.com.leadu.fms.data.asset.repository.EquMorRepayRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.asset.entity.EquMorRepay;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorRepayRepositoryImpl
 * @Description: 资方抵押还款计划Repository 实现层
 * @date 2018-05-30
 */
@Repository
public class EquMorRepayRepositoryImpl extends AbstractBaseRepository<EquMorRepayDao, EquMorRepay> implements EquMorRepayRepository {

    /**
     * @Title:
     * @Description: 新增资方抵押还款计划
     * @param equMorRepay
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:35
     */
    @Override
    public int insertData(EquMorRepay equMorRepay) {
        return super.insert(equMorRepay);
    }

    /**
     * @Title:
     * @Description: 批量保存资方抵押还款计划
     * @param equMorRepays
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:35
     */
    @Override
    public int insertDataList(List<EquMorRepay> equMorRepays){
        return super.insertListByJdbcTemplate(equMorRepays);
    }

    /**
     * @Title:
     * @Description: 修改资方抵押还款计划
     * @param equMorRepay
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:35
     */
    @Override
    public int updateByPrimaryKeyData(EquMorRepay equMorRepay) {
        return super.updateByPrimaryKey(equMorRepay);
    }

    /**
     * @Title:
     * @Description: 批量修改资方抵押还款计划
     * @param equMorRepays
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:35
     */
    @Override
    public int updateByPrimaryKeyDataList(List<EquMorRepay> equMorRepays){
        return super.updateListByPrimaryKey(equMorRepays);
    }

    /**
     * @Title:
     * @Description: 动态修改资方抵押还款计划
     * @param equMorRepay
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:35
     */
    @Override
    public int updateByPrimaryKeySelectiveData(EquMorRepay equMorRepay) {
        return super.updateByPrimaryKeySelective(equMorRepay);
    }

    /**
     * @Title:
     * @Description: 批量动态修改资方抵押还款计划
     * @param equMorRepays
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:35
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<EquMorRepay> equMorRepays) {
        return super.updateListByPrimaryKeySelective(equMorRepays);
    }

    /**
     * @Title:
     * @Description: 根据条件修改资方抵押还款计划
     * @param equMorRepay
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:35
     */
    @Override
    public int updateByExampleData(EquMorRepay equMorRepay, Example example) {
        return super.updateByExample(equMorRepay,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改资方抵押还款计划
     * @param equMorRepay
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:35
     */
    @Override
    public int updateByExampleSelectiveData(EquMorRepay equMorRepay, Example example){
        return super.updateByExampleSelective(equMorRepay,example);
    }
    
    /**
     * @Title:
     * @Description: 根据equMorRepayId删除资方抵押还款计划
     * @param equMorRepay
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:35
     */
    @Override
    public int deleteData(EquMorRepay equMorRepay) {
        return super.delete(equMorRepay);
    }

    /**
     * @Title:
     * @Description: 根据equMorRepayId集合批量删除资方抵押还款计划
     * @param equMorRepay
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:35
     */
    @Override
    public int deleteDataList(List equMorRepayIds,EquMorRepay equMorRepay){
        return super.deleteByIds(equMorRepayIds,equMorRepay);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除资方抵押还款计划
     * @param example
     * @param equMorRepay
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:35
     */
    @Override
    public int deleteExampleData(Example example,EquMorRepay equMorRepay){
        return super.deleteByExample(example,equMorRepay);
    }

    /**
     * @Title:
     * @Description: 查询全部资方抵押还款计划
     * @return List<EquMorRepay>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:35
     */
    @Override
    public List<EquMorRepay> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个资方抵押还款计划
     * @param example
     * @return EquMorRepay
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:35
     */
    @Override
    public EquMorRepay selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询资方抵押还款计划
     * @param example
     * @return List<EquMorRepay>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:35
     */
    @Override
    public List<EquMorRepay> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过equMorRepayId查询资方抵押还款计划
     * @param equMorRepayId
     * @return EquMorRepay
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:35
     */
    @Override
    public EquMorRepay selectByPrimaryKey(Object equMorRepayId) {
        return super.selectByPrimaryKey(equMorRepayId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询资方抵押还款计划
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<EquMorRepay>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:35
     */
    @Override
    public PageInfoExtend<EquMorRepay> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询资方抵押还款计划vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:35
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改资方抵押还款计划
     * @param equMorRepay,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:35
     */
    @Override
    public int updateByPrimaryKeyData(EquMorRepay equMorRepay,boolean exclusive) {
        return super.updateByPrimaryKey(equMorRepay,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改资方抵押还款计划,并进行排他
     * @param equMorRepays
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:35
     */
    @Override
    public int updateByPrimaryKeyDataList(List<EquMorRepay> equMorRepays,boolean exclusive){
        return super.updateListByPrimaryKey(equMorRepays,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改资方抵押还款计划,并进行排他
     * @param equMorRepay
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(EquMorRepay equMorRepay,boolean exclusive) {
        return super.updateByPrimaryKeySelective(equMorRepay,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改资方抵押还款计划,并进行排他
     * @param equMorRepays
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:35
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<EquMorRepay> equMorRepays,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(equMorRepays,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改资方抵押还款计划,并进行排他
     * @param equMorRepay
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:35
     */
    @Override
    public int updateByExampleData(EquMorRepay equMorRepay, Example example,boolean exclusive) {
        return super.updateByExample(equMorRepay,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改资方抵押还款计划,并进行排他
     * @param equMorRepay
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:35
     */
    @Override
    public int updateByExampleSelectiveData(EquMorRepay equMorRepay, Example example,boolean exclusive){
        return super.updateByExampleSelective(equMorRepay,example,exclusive);
    }

}
