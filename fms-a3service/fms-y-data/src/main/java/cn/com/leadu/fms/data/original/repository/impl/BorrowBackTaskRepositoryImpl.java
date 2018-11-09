package cn.com.leadu.fms.data.original.repository.impl;

import cn.com.leadu.fms.data.original.dao.BorrowBackTaskDao;
import cn.com.leadu.fms.data.original.repository.BorrowBackTaskRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.original.entity.BorrowBackTask;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.original.vo.borrowbacktask.BorrowBackTaskVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: BorrowBackTaskRepositoryImpl
 * @Description: 借阅归还任务信息Repository 实现层
 * @date 2018-06-04
 */
@Repository
public class BorrowBackTaskRepositoryImpl extends AbstractBaseRepository<BorrowBackTaskDao, BorrowBackTask> implements BorrowBackTaskRepository {

    /**
     * @Title:
     * @Description: 新增借阅归还任务信息
     * @param borrowBackTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @Override
    public int insertData(BorrowBackTask borrowBackTask) {
        return super.insert(borrowBackTask);
    }

    /**
     * @Title:
     * @Description: 批量保存借阅归还任务信息
     * @param borrowBackTasks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @Override
    public int insertDataList(List<BorrowBackTask> borrowBackTasks){
        return super.insertListByJdbcTemplate(borrowBackTasks);
    }

    /**
     * @Title:
     * @Description: 修改借阅归还任务信息
     * @param borrowBackTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @Override
    public int updateByPrimaryKeyData(BorrowBackTask borrowBackTask) {
        return super.updateByPrimaryKey(borrowBackTask);
    }

    /**
     * @Title:
     * @Description: 批量修改借阅归还任务信息
     * @param borrowBackTasks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @Override
    public int updateByPrimaryKeyDataList(List<BorrowBackTask> borrowBackTasks){
        return super.updateListByPrimaryKey(borrowBackTasks);
    }

    /**
     * @Title:
     * @Description: 动态修改借阅归还任务信息
     * @param borrowBackTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @Override
    public int updateByPrimaryKeySelectiveData(BorrowBackTask borrowBackTask) {
        return super.updateByPrimaryKeySelective(borrowBackTask);
    }

    /**
     * @Title:
     * @Description: 批量动态修改借阅归还任务信息
     * @param borrowBackTasks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<BorrowBackTask> borrowBackTasks) {
        return super.updateListByPrimaryKeySelective(borrowBackTasks);
    }

    /**
     * @Title:
     * @Description: 根据条件修改借阅归还任务信息
     * @param borrowBackTask
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @Override
    public int updateByExampleData(BorrowBackTask borrowBackTask, Example example) {
        return super.updateByExample(borrowBackTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改借阅归还任务信息
     * @param borrowBackTask
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @Override
    public int updateByExampleSelectiveData(BorrowBackTask borrowBackTask, Example example){
        return super.updateByExampleSelective(borrowBackTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据borrowBackTaskId删除借阅归还任务信息
     * @param borrowBackTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @Override
    public int deleteData(BorrowBackTask borrowBackTask) {
        return super.delete(borrowBackTask);
    }

    /**
     * @Title:
     * @Description: 根据borrowBackTaskId集合批量删除借阅归还任务信息
     * @param borrowBackTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @Override
    public int deleteDataList(List borrowBackTaskIds,BorrowBackTask borrowBackTask){
        return super.deleteByIds(borrowBackTaskIds,borrowBackTask);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除借阅归还任务信息
     * @param example
     * @param borrowBackTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @Override
    public int deleteExampleData(Example example,BorrowBackTask borrowBackTask){
        return super.deleteByExample(example,borrowBackTask);
    }

    /**
     * @Title:
     * @Description: 查询全部借阅归还任务信息
     * @return List<BorrowBackTask>
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @Override
    public List<BorrowBackTask> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个借阅归还任务信息
     * @param example
     * @return BorrowBackTask
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @Override
    public BorrowBackTask selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询借阅归还任务信息
     * @param example
     * @return List<BorrowBackTask>
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @Override
    public List<BorrowBackTask> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过borrowBackTaskId查询借阅归还任务信息
     * @param borrowBackTaskId
     * @return BorrowBackTask
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @Override
    public BorrowBackTask selectByPrimaryKey(Object borrowBackTaskId) {
        return super.selectByPrimaryKey(borrowBackTaskId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询借阅归还任务信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<BorrowBackTask>
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @Override
    public PageInfoExtend<BorrowBackTask> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询借阅归还任务信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改借阅归还任务信息
     * @param borrowBackTask,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @Override
    public int updateByPrimaryKeyData(BorrowBackTask borrowBackTask,boolean exclusive) {
        return super.updateByPrimaryKey(borrowBackTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改借阅归还任务信息,并进行排他
     * @param borrowBackTasks
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @Override
    public int updateByPrimaryKeyDataList(List<BorrowBackTask> borrowBackTasks,boolean exclusive){
        return super.updateListByPrimaryKey(borrowBackTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改借阅归还任务信息,并进行排他
     * @param borrowBackTask
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(BorrowBackTask borrowBackTask,boolean exclusive) {
        return super.updateByPrimaryKeySelective(borrowBackTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改借阅归还任务信息,并进行排他
     * @param borrowBackTasks
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<BorrowBackTask> borrowBackTasks,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(borrowBackTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改借阅归还任务信息,并进行排他
     * @param borrowBackTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @Override
    public int updateByExampleData(BorrowBackTask borrowBackTask, Example example,boolean exclusive) {
        return super.updateByExample(borrowBackTask,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改借阅归还任务信息,并进行排他
     * @param borrowBackTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @Override
    public int updateByExampleSelectiveData(BorrowBackTask borrowBackTask, Example example,boolean exclusive){
        return super.updateByExampleSelective(borrowBackTask,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据借阅归还任务号获取借阅归还信息
     * @param borrowBackTaskNo
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @Override
    public BorrowBackTaskVo selectBorrowBackTaskByBorrowBackTaskNo(String borrowBackTaskNo) {
        return baseDao.selectBorrowBackTaskByBorrowBackTaskNo(borrowBackTaskNo);
    }

}
