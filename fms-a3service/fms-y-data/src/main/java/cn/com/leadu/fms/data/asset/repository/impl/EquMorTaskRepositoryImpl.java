package cn.com.leadu.fms.data.asset.repository.impl;

import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.asset.dao.EquMorTaskDao;
import cn.com.leadu.fms.data.asset.repository.EquMorTaskRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.pojo.asset.entity.EquMorTask;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorTaskRepositoryImpl
 * @Description: 资方抵押任务Repository 实现层
 * @date 2018-05-30
 */
@Repository
public class EquMorTaskRepositoryImpl extends AbstractBaseRepository<EquMorTaskDao, EquMorTask> implements EquMorTaskRepository {

    /**
     * @Title:
     * @Description: 新增资方抵押任务
     * @param equMorTask
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @Override
    public int insertData(EquMorTask equMorTask) {
        return super.insert(equMorTask);
    }

    /**
     * @Title:
     * @Description: 批量保存资方抵押任务
     * @param equMorTasks
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @Override
    public int insertDataList(List<EquMorTask> equMorTasks){
        return super.insertListByJdbcTemplate(equMorTasks);
    }

    /**
     * @Title:
     * @Description: 修改资方抵押任务
     * @param equMorTask
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @Override
    public int updateByPrimaryKeyData(EquMorTask equMorTask) {
        return super.updateByPrimaryKey(equMorTask);
    }

    /**
     * @Title:
     * @Description: 批量修改资方抵押任务
     * @param equMorTasks
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @Override
    public int updateByPrimaryKeyDataList(List<EquMorTask> equMorTasks){
        return super.updateListByPrimaryKey(equMorTasks);
    }

    /**
     * @Title:
     * @Description: 动态修改资方抵押任务
     * @param equMorTask
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @Override
    public int updateByPrimaryKeySelectiveData(EquMorTask equMorTask) {
        return super.updateByPrimaryKeySelective(equMorTask);
    }

    /**
     * @Title:
     * @Description: 批量动态修改资方抵押任务
     * @param equMorTasks
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<EquMorTask> equMorTasks) {
        return super.updateListByPrimaryKeySelective(equMorTasks);
    }

    /**
     * @Title:
     * @Description: 根据条件修改资方抵押任务
     * @param equMorTask
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @Override
    public int updateByExampleData(EquMorTask equMorTask, Example example) {
        return super.updateByExample(equMorTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改资方抵押任务
     * @param equMorTask
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @Override
    public int updateByExampleSelectiveData(EquMorTask equMorTask, Example example){
        return super.updateByExampleSelective(equMorTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据equMorTaskId删除资方抵押任务
     * @param equMorTask
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @Override
    public int deleteData(EquMorTask equMorTask) {
        return super.delete(equMorTask);
    }

    /**
     * @Title:
     * @Description: 根据equMorTaskId集合批量删除资方抵押任务
     * @param equMorTask
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @Override
    public int deleteDataList(List equMorTaskIds,EquMorTask equMorTask){
        return super.deleteByIds(equMorTaskIds,equMorTask);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除资方抵押任务
     * @param example
     * @param equMorTask
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @Override
    public int deleteExampleData(Example example,EquMorTask equMorTask){
        return super.deleteByExample(example,equMorTask);
    }

    /**
     * @Title:
     * @Description: 查询全部资方抵押任务
     * @return List<EquMorTask>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @Override
    public List<EquMorTask> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个资方抵押任务
     * @param example
     * @return EquMorTask
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @Override
    public EquMorTask selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询资方抵押任务
     * @param example
     * @return List<EquMorTask>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @Override
    public List<EquMorTask> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过equMorTaskId查询资方抵押任务
     * @param equMorTaskId
     * @return EquMorTask
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @Override
    public EquMorTask selectByPrimaryKey(Object equMorTaskId) {
        return super.selectByPrimaryKey(equMorTaskId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询资方抵押任务
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<EquMorTask>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @Override
    public PageInfoExtend<EquMorTask> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询资方抵押任务vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改资方抵押任务
     * @param equMorTask,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @Override
    public int updateByPrimaryKeyData(EquMorTask equMorTask,boolean exclusive) {
        return super.updateByPrimaryKey(equMorTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改资方抵押任务,并进行排他
     * @param equMorTasks
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @Override
    public int updateByPrimaryKeyDataList(List<EquMorTask> equMorTasks,boolean exclusive){
        return super.updateListByPrimaryKey(equMorTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改资方抵押任务,并进行排他
     * @param equMorTask
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(EquMorTask equMorTask,boolean exclusive) {
        return super.updateByPrimaryKeySelective(equMorTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改资方抵押任务,并进行排他
     * @param equMorTasks
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<EquMorTask> equMorTasks,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(equMorTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改资方抵押任务,并进行排他
     * @param equMorTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @Override
    public int updateByExampleData(EquMorTask equMorTask, Example example,boolean exclusive) {
        return super.updateByExample(equMorTask,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改资方抵押任务,并进行排他
     * @param equMorTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:52
     */
    @Override
    public int updateByExampleSelectiveData(EquMorTask equMorTask, Example example,boolean exclusive){
        return super.updateByExampleSelective(equMorTask,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据任务号,更新任务状态和所在节点人
     * @param equMorTaskNo
     * @param equMorTask
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/09 05:04:51
     */
    public int updateByEquMorTaskNoSelectiveData(String equMorTaskNo,EquMorTask equMorTask){
        if(StringUtils.isTrimBlank(equMorTaskNo))
            throw new FmsServiceException("资方抵押任务号不能为空");
        if(equMorTask.getMortgageServStatus() == null)
            equMorTask.setMortgageServStatus("");
        if(equMorTask.getPresentUser() == null)
            equMorTask.setPresentUser("");
        Example example = SqlUtil.newExample(EquMorTask.class);
        example.createCriteria().andEqualTo("equMorTaskNo",equMorTaskNo);
        return super.updateByExampleSelective(equMorTask,example);
    }

}
