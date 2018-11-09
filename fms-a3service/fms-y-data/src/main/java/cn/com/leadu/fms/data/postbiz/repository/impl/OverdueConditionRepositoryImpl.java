package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.OverdueConditionDao;
import cn.com.leadu.fms.data.postbiz.repository.OverdueConditionRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCondition;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: OverdueConditionRepositoryImpl
 * @Description: 逾期状态维护Repository 实现层
 * @date 2018-05-11
 */
@Repository
public class OverdueConditionRepositoryImpl extends AbstractBaseRepository<OverdueConditionDao, OverdueCondition> implements OverdueConditionRepository {

    /**
     * @Title:
     * @Description: 新增逾期状态维护
     * @param overdueCondition
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    @Override
    public int insertData(OverdueCondition overdueCondition) {
        return super.insert(overdueCondition);
    }

    /**
     * @Title:
     * @Description: 批量保存逾期状态维护
     * @param overdueConditions
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    @Override
    public int insertDataList(List<OverdueCondition> overdueConditions){
        return super.insertListByJdbcTemplate(overdueConditions);
    }

    /**
     * @Title:
     * @Description: 修改逾期状态维护
     * @param overdueCondition
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    @Override
    public int updateByPrimaryKeyData(OverdueCondition overdueCondition) {
        return super.updateByPrimaryKey(overdueCondition);
    }

    /**
     * @Title:
     * @Description: 批量修改逾期状态维护
     * @param overdueConditions
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    @Override
    public int updateByPrimaryKeyDataList(List<OverdueCondition> overdueConditions){
        return super.updateListByPrimaryKey(overdueConditions);
    }

    /**
     * @Title:
     * @Description: 动态修改逾期状态维护
     * @param overdueCondition
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    @Override
    public int updateByPrimaryKeySelectiveData(OverdueCondition overdueCondition) {
        return super.updateByPrimaryKeySelective(overdueCondition);
    }

    /**
     * @Title:
     * @Description: 批量动态修改逾期状态维护
     * @param overdueConditions
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    public int updateByPrimaryKeySelectiveDataList(List<OverdueCondition> overdueConditions) {
        return super.updateListByPrimaryKeySelective(overdueConditions);
    }

    /**
     * @Title:
     * @Description: 根据条件修改逾期状态维护
     * @param overdueCondition
     * @param example
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    @Override
    public int updateByExampleData(OverdueCondition overdueCondition, Example example) {
        return super.updateByExample(overdueCondition,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改逾期状态维护
     * @param overdueCondition
     * @param example
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    @Override
    public int updateByExampleSelectiveData(OverdueCondition overdueCondition, Example example){
        return super.updateByExampleSelective(overdueCondition,example);
    }
    
    /**
     * @Title:
     * @Description: 根据overdueConditionId删除逾期状态维护
     * @param overdueCondition
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    @Override
    public int deleteData(OverdueCondition overdueCondition) {
        return super.delete(overdueCondition);
    }

    /**
     * @Title:
     * @Description: 根据overdueConditionId集合批量删除逾期状态维护
     * @param overdueCondition
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    public int deleteDataList(List overdueConditionIds,OverdueCondition overdueCondition){
        return super.deleteByIds(overdueConditionIds,overdueCondition);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除逾期状态维护
     * @param example
     * @param overdueCondition
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    public int deleteExampleData(Example example,OverdueCondition overdueCondition){
        return super.deleteByExample(example,overdueCondition);
    }

    /**
     * @Title:
     * @Description: 查询全部逾期状态维护
     * @return List<OverdueCondition>
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    @Override
    public List<OverdueCondition> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个逾期状态维护
     * @param example
     * @return OverdueCondition
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    @Override
    public OverdueCondition selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询逾期状态维护
     * @param example
     * @return List<OverdueCondition>
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    @Override
    public List<OverdueCondition> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过overdueConditionId查询逾期状态维护
     * @param overdueConditionId
     * @return OverdueCondition
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    @Override
    public OverdueCondition selectByPrimaryKey(Object overdueConditionId) {
        return super.selectByPrimaryKey(overdueConditionId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询逾期状态维护
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<OverdueCondition>
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    @Override
    public PageInfoExtend<OverdueCondition> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询逾期状态维护vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
