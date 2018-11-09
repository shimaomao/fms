package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.ChangeLesseeTaskDao;
import cn.com.leadu.fms.data.postbiz.repository.ChangeLesseeTaskRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.ChangeLesseeTask;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: ChangeLesseeTaskRepositoryImpl
 * @Description: 承租人变更Repository 实现层
 */
@Repository
public class ChangeLesseeTaskRepositoryImpl extends AbstractBaseRepository<ChangeLesseeTaskDao, ChangeLesseeTask> implements ChangeLesseeTaskRepository {

    /**
     * @Title:
     * @Description: 新增承租人变更
     * @param changeLesseeTask
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public int insertData(ChangeLesseeTask changeLesseeTask) {
        return super.insert(changeLesseeTask);
    }

    /**
     * @Title:
     * @Description: 批量保存承租人变更
     * @param changeLesseeTasks
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public int insertDataList(List<ChangeLesseeTask> changeLesseeTasks){
        return super.insertListByJdbcTemplate(changeLesseeTasks);
    }

    /**
     * @Title:
     * @Description: 修改承租人变更
     * @param changeLesseeTask
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public int updateByPrimaryKeyData(ChangeLesseeTask changeLesseeTask) {
        return super.updateByPrimaryKey(changeLesseeTask);
    }

    /**
     * @Title:
     * @Description: 批量修改承租人变更
     * @param changeLesseeTasks
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ChangeLesseeTask> changeLesseeTasks){
        return super.updateListByPrimaryKey(changeLesseeTasks);
    }

    /**
     * @Title:
     * @Description: 动态修改承租人变更
     * @param changeLesseeTask
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ChangeLesseeTask changeLesseeTask) {
        return super.updateByPrimaryKeySelective(changeLesseeTask);
    }

    /**
     * @Title:
     * @Description: 批量动态修改承租人变更
     * @param changeLesseeTasks
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<ChangeLesseeTask> changeLesseeTasks) {
        return super.updateListByPrimaryKeySelective(changeLesseeTasks);
    }

    /**
     * @Title:
     * @Description: 根据条件修改承租人变更
     * @param changeLesseeTask
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public int updateByExampleData(ChangeLesseeTask changeLesseeTask, Example example) {
        return super.updateByExample(changeLesseeTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改承租人变更
     * @param changeLesseeTask
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public int updateByExampleSelectiveData(ChangeLesseeTask changeLesseeTask, Example example){
        return super.updateByExampleSelective(changeLesseeTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据taskId删除承租人变更
     * @param changeLesseeTask
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public int deleteData(ChangeLesseeTask changeLesseeTask) {
        return super.delete(changeLesseeTask);
    }

    /**
     * @Title:
     * @Description: 根据taskId集合批量删除承租人变更
     * @param changeLesseeTask
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public int deleteDataList(List taskIds,ChangeLesseeTask changeLesseeTask){
        return super.deleteByIds(taskIds,changeLesseeTask);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除承租人变更
     * @param example
     * @param changeLesseeTask
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public int deleteExampleData(Example example,ChangeLesseeTask changeLesseeTask){
        return super.deleteByExample(example,changeLesseeTask);
    }

    /**
     * @Title:
     * @Description: 查询全部承租人变更
     * @return List<ChangeLesseeTask>
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public List<ChangeLesseeTask> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个承租人变更
     * @param example
     * @return ChangeLesseeTask
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public ChangeLesseeTask selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询承租人变更
     * @param example
     * @return List<ChangeLesseeTask>
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public List<ChangeLesseeTask> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过taskId查询承租人变更
     * @param taskId
     * @return ChangeLesseeTask
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public ChangeLesseeTask selectByPrimaryKey(Object taskId) {
        return super.selectByPrimaryKey(taskId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询承租人变更
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ChangeLesseeTask>
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public PageInfoExtend<ChangeLesseeTask> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询承租人变更vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改承租人变更
     * @param changeLesseeTask,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public int updateByPrimaryKeyData(ChangeLesseeTask changeLesseeTask,boolean exclusive) {
        return super.updateByPrimaryKey(changeLesseeTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改承租人变更,并进行排他
     * @param changeLesseeTasks
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ChangeLesseeTask> changeLesseeTasks,boolean exclusive){
        return super.updateListByPrimaryKey(changeLesseeTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改承租人变更,并进行排他
     * @param changeLesseeTask
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ChangeLesseeTask changeLesseeTask,boolean exclusive) {
        return super.updateByPrimaryKeySelective(changeLesseeTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改承租人变更,并进行排他
     * @param changeLesseeTasks
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<ChangeLesseeTask> changeLesseeTasks,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(changeLesseeTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改承租人变更,并进行排他
     * @param changeLesseeTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public int updateByExampleData(ChangeLesseeTask changeLesseeTask, Example example,boolean exclusive) {
        return super.updateByExample(changeLesseeTask,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改承租人变更,并进行排他
     * @param changeLesseeTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public int updateByExampleSelectiveData(ChangeLesseeTask changeLesseeTask, Example example,boolean exclusive){
        return super.updateByExampleSelective(changeLesseeTask,example,exclusive);
    }

}
