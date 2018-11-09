package cn.com.leadu.fms.data.asset.repository.impl;

import cn.com.leadu.fms.data.asset.dao.EquRelTaskDao;
import cn.com.leadu.fms.data.asset.repository.EquRelTaskRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.asset.entity.EquRelTask;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquRelTaskRepositoryImpl
 * @Description: 资方解押任务Repository 实现层
 * @date 2018-05-30
 */
@Repository
public class EquRelTaskRepositoryImpl extends AbstractBaseRepository<EquRelTaskDao, EquRelTask> implements EquRelTaskRepository {

    /**
     * @Title:
     * @Description: 新增资方解押任务
     * @param equRelTask
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @Override
    public int insertData(EquRelTask equRelTask) {
        return super.insert(equRelTask);
    }

    /**
     * @Title:
     * @Description: 批量保存资方解押任务
     * @param equRelTasks
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @Override
    public int insertDataList(List<EquRelTask> equRelTasks){
        return super.insertListByJdbcTemplate(equRelTasks);
    }

    /**
     * @Title:
     * @Description: 修改资方解押任务
     * @param equRelTask
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @Override
    public int updateByPrimaryKeyData(EquRelTask equRelTask) {
        return super.updateByPrimaryKey(equRelTask);
    }

    /**
     * @Title:
     * @Description: 批量修改资方解押任务
     * @param equRelTasks
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @Override
    public int updateByPrimaryKeyDataList(List<EquRelTask> equRelTasks){
        return super.updateListByPrimaryKey(equRelTasks);
    }

    /**
     * @Title:
     * @Description: 动态修改资方解押任务
     * @param equRelTask
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @Override
    public int updateByPrimaryKeySelectiveData(EquRelTask equRelTask) {
        return super.updateByPrimaryKeySelective(equRelTask);
    }

    /**
     * @Title:
     * @Description: 批量动态修改资方解押任务
     * @param equRelTasks
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<EquRelTask> equRelTasks) {
        return super.updateListByPrimaryKeySelective(equRelTasks);
    }

    /**
     * @Title:
     * @Description: 根据条件修改资方解押任务
     * @param equRelTask
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @Override
    public int updateByExampleData(EquRelTask equRelTask, Example example) {
        return super.updateByExample(equRelTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改资方解押任务
     * @param equRelTask
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @Override
    public int updateByExampleSelectiveData(EquRelTask equRelTask, Example example){
        return super.updateByExampleSelective(equRelTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据equRelTaskId删除资方解押任务
     * @param equRelTask
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @Override
    public int deleteData(EquRelTask equRelTask) {
        return super.delete(equRelTask);
    }

    /**
     * @Title:
     * @Description: 根据equRelTaskId集合批量删除资方解押任务
     * @param equRelTask
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @Override
    public int deleteDataList(List equRelTaskIds,EquRelTask equRelTask){
        return super.deleteByIds(equRelTaskIds,equRelTask);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除资方解押任务
     * @param example
     * @param equRelTask
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @Override
    public int deleteExampleData(Example example,EquRelTask equRelTask){
        return super.deleteByExample(example,equRelTask);
    }

    /**
     * @Title:
     * @Description: 查询全部资方解押任务
     * @return List<EquRelTask>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @Override
    public List<EquRelTask> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个资方解押任务
     * @param example
     * @return EquRelTask
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @Override
    public EquRelTask selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询资方解押任务
     * @param example
     * @return List<EquRelTask>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @Override
    public List<EquRelTask> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过equRelTaskId查询资方解押任务
     * @param equRelTaskId
     * @return EquRelTask
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @Override
    public EquRelTask selectByPrimaryKey(Object equRelTaskId) {
        return super.selectByPrimaryKey(equRelTaskId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询资方解押任务
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<EquRelTask>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @Override
    public PageInfoExtend<EquRelTask> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询资方解押任务vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改资方解押任务
     * @param equRelTask,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @Override
    public int updateByPrimaryKeyData(EquRelTask equRelTask,boolean exclusive) {
        return super.updateByPrimaryKey(equRelTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改资方解押任务,并进行排他
     * @param equRelTasks
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @Override
    public int updateByPrimaryKeyDataList(List<EquRelTask> equRelTasks,boolean exclusive){
        return super.updateListByPrimaryKey(equRelTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改资方解押任务,并进行排他
     * @param equRelTask
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(EquRelTask equRelTask,boolean exclusive) {
        return super.updateByPrimaryKeySelective(equRelTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改资方解押任务,并进行排他
     * @param equRelTasks
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<EquRelTask> equRelTasks,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(equRelTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改资方解押任务,并进行排他
     * @param equRelTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @Override
    public int updateByExampleData(EquRelTask equRelTask, Example example,boolean exclusive) {
        return super.updateByExample(equRelTask,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改资方解押任务,并进行排他
     * @param equRelTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:56:55
     */
    @Override
    public int updateByExampleSelectiveData(EquRelTask equRelTask, Example example,boolean exclusive){
        return super.updateByExampleSelective(equRelTask,example,exclusive);
    }

}
