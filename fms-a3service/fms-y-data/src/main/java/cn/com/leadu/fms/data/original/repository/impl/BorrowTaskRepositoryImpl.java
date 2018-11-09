package cn.com.leadu.fms.data.original.repository.impl;

import cn.com.leadu.fms.data.original.dao.BorrowTaskDao;
import cn.com.leadu.fms.data.original.repository.BorrowTaskRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.original.entity.BorrowTask;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: BorrowTaskRepositoryImpl
 * @Description: 借阅任务信息Repository 实现层
 * @date 2018-05-30
 */
@Repository
public class BorrowTaskRepositoryImpl extends AbstractBaseRepository<BorrowTaskDao, BorrowTask> implements BorrowTaskRepository {

    /**
     * @Title:
     * @Description: 新增借阅任务信息
     * @param borrowTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:18:56
     */
    @Override
    public int insertData(BorrowTask borrowTask) {
        return super.insert(borrowTask);
    }

    /**
     * @Title:
     * @Description: 批量保存借阅任务信息
     * @param borrowTasks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:18:56
     */
    @Override
    public int insertDataList(List<BorrowTask> borrowTasks){
        return super.insertListByJdbcTemplate(borrowTasks);
    }

    /**
     * @Title:
     * @Description: 修改借阅任务信息
     * @param borrowTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:18:56
     */
    @Override
    public int updateByPrimaryKeyData(BorrowTask borrowTask) {
        return super.updateByPrimaryKey(borrowTask);
    }

    /**
     * @Title:
     * @Description: 批量修改借阅任务信息
     * @param borrowTasks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:18:56
     */
    @Override
    public int updateByPrimaryKeyDataList(List<BorrowTask> borrowTasks){
        return super.updateListByPrimaryKey(borrowTasks);
    }

    /**
     * @Title:
     * @Description: 动态修改借阅任务信息
     * @param borrowTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:18:56
     */
    @Override
    public int updateByPrimaryKeySelectiveData(BorrowTask borrowTask) {
        return super.updateByPrimaryKeySelective(borrowTask);
    }

    /**
     * @Title:
     * @Description: 批量动态修改借阅任务信息
     * @param borrowTasks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:18:56
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<BorrowTask> borrowTasks) {
        return super.updateListByPrimaryKeySelective(borrowTasks);
    }

    /**
     * @Title:
     * @Description: 根据条件修改借阅任务信息
     * @param borrowTask
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:18:56
     */
    @Override
    public int updateByExampleData(BorrowTask borrowTask, Example example) {
        return super.updateByExample(borrowTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改借阅任务信息
     * @param borrowTask
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:18:56
     */
    @Override
    public int updateByExampleSelectiveData(BorrowTask borrowTask, Example example){
        return super.updateByExampleSelective(borrowTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据borrowTaskId删除借阅任务信息
     * @param borrowTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:18:56
     */
    @Override
    public int deleteData(BorrowTask borrowTask) {
        return super.delete(borrowTask);
    }

    /**
     * @Title:
     * @Description: 根据borrowTaskId集合批量删除借阅任务信息
     * @param borrowTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:18:56
     */
    @Override
    public int deleteDataList(List borrowTaskIds,BorrowTask borrowTask){
        return super.deleteByIds(borrowTaskIds,borrowTask);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除借阅任务信息
     * @param example
     * @param borrowTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:18:56
     */
    @Override
    public int deleteExampleData(Example example,BorrowTask borrowTask){
        return super.deleteByExample(example,borrowTask);
    }

    /**
     * @Title:
     * @Description: 查询全部借阅任务信息
     * @return List<BorrowTask>
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:18:56
     */
    @Override
    public List<BorrowTask> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个借阅任务信息
     * @param example
     * @return BorrowTask
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:18:56
     */
    @Override
    public BorrowTask selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询借阅任务信息
     * @param example
     * @return List<BorrowTask>
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:18:56
     */
    @Override
    public List<BorrowTask> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过borrowTaskId查询借阅任务信息
     * @param borrowTaskId
     * @return BorrowTask
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:18:56
     */
    @Override
    public BorrowTask selectByPrimaryKey(Object borrowTaskId) {
        return super.selectByPrimaryKey(borrowTaskId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询借阅任务信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<BorrowTask>
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:18:56
     */
    @Override
    public PageInfoExtend<BorrowTask> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询借阅任务信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:18:56
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改借阅任务信息
     * @param borrowTask,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:18:56
     */
    @Override
    public int updateByPrimaryKeyData(BorrowTask borrowTask,boolean exclusive) {
        return super.updateByPrimaryKey(borrowTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改借阅任务信息,并进行排他
     * @param borrowTasks
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:18:56
     */
    @Override
    public int updateByPrimaryKeyDataList(List<BorrowTask> borrowTasks,boolean exclusive){
        return super.updateListByPrimaryKey(borrowTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改借阅任务信息,并进行排他
     * @param borrowTask
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(BorrowTask borrowTask,boolean exclusive) {
        return super.updateByPrimaryKeySelective(borrowTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改借阅任务信息,并进行排他
     * @param borrowTasks
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:18:56
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<BorrowTask> borrowTasks,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(borrowTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改借阅任务信息,并进行排他
     * @param borrowTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:18:56
     */
    @Override
    public int updateByExampleData(BorrowTask borrowTask, Example example,boolean exclusive) {
        return super.updateByExample(borrowTask,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改借阅任务信息,并进行排他
     * @param borrowTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:18:56
     */
    @Override
    public int updateByExampleSelectiveData(BorrowTask borrowTask, Example example,boolean exclusive){
        return super.updateByExampleSelective(borrowTask,example,exclusive);
    }

    /**
     * 根据借阅任务号获取合同号
     */
    @Override
    public String selectBizCodeByBorrowTaskNo(String borrowTaskNo) {
        return baseDao.selectBizCodeByBorrowTaskNo(borrowTaskNo);
    }

}
