package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.InvoiceChangeTaskDao;
import cn.com.leadu.fms.data.postbiz.repository.InvoiceChangeTaskRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceChangeTask;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: InvoiceChangeTaskRepositoryImpl
 * @Description: 开票变更任务Repository 实现层
 * @date 2018-08-29
 */
@Repository
public class InvoiceChangeTaskRepositoryImpl extends AbstractBaseRepository<InvoiceChangeTaskDao, InvoiceChangeTask> implements InvoiceChangeTaskRepository {

    /**
     * @Title:
     * @Description: 新增开票变更任务
     * @param invoiceChangeTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public int insertData(InvoiceChangeTask invoiceChangeTask) {
        return super.insert(invoiceChangeTask);
    }

    /**
     * @Title:
     * @Description: 批量保存开票变更任务
     * @param invoiceChangeTasks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public int insertDataList(List<InvoiceChangeTask> invoiceChangeTasks){
        return super.insertListByJdbcTemplate(invoiceChangeTasks);
    }

    /**
     * @Title:
     * @Description: 修改开票变更任务
     * @param invoiceChangeTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public int updateByPrimaryKeyData(InvoiceChangeTask invoiceChangeTask) {
        return super.updateByPrimaryKey(invoiceChangeTask);
    }

    /**
     * @Title:
     * @Description: 批量修改开票变更任务
     * @param invoiceChangeTasks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public int updateByPrimaryKeyDataList(List<InvoiceChangeTask> invoiceChangeTasks){
        return super.updateListByPrimaryKey(invoiceChangeTasks);
    }

    /**
     * @Title:
     * @Description: 动态修改开票变更任务
     * @param invoiceChangeTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public int updateByPrimaryKeySelectiveData(InvoiceChangeTask invoiceChangeTask) {
        return super.updateByPrimaryKeySelective(invoiceChangeTask);
    }

    /**
     * @Title:
     * @Description: 批量动态修改开票变更任务
     * @param invoiceChangeTasks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<InvoiceChangeTask> invoiceChangeTasks) {
        return super.updateListByPrimaryKeySelective(invoiceChangeTasks);
    }

    /**
     * @Title:
     * @Description: 根据条件修改开票变更任务
     * @param invoiceChangeTask
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public int updateByExampleData(InvoiceChangeTask invoiceChangeTask, Example example) {
        return super.updateByExample(invoiceChangeTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改开票变更任务
     * @param invoiceChangeTask
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public int updateByExampleSelectiveData(InvoiceChangeTask invoiceChangeTask, Example example){
        return super.updateByExampleSelective(invoiceChangeTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据invoiceChangeTaskId删除开票变更任务
     * @param invoiceChangeTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public int deleteData(InvoiceChangeTask invoiceChangeTask) {
        return super.delete(invoiceChangeTask);
    }

    /**
     * @Title:
     * @Description: 根据invoiceChangeTaskId集合批量删除开票变更任务
     * @param invoiceChangeTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public int deleteDataList(List invoiceChangeTaskIds,InvoiceChangeTask invoiceChangeTask){
        return super.deleteByIds(invoiceChangeTaskIds,invoiceChangeTask);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除开票变更任务
     * @param example
     * @param invoiceChangeTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public int deleteExampleData(Example example,InvoiceChangeTask invoiceChangeTask){
        return super.deleteByExample(example,invoiceChangeTask);
    }

    /**
     * @Title:
     * @Description: 查询全部开票变更任务
     * @return List<InvoiceChangeTask>
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public List<InvoiceChangeTask> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个开票变更任务
     * @param example
     * @return InvoiceChangeTask
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public InvoiceChangeTask selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询开票变更任务
     * @param example
     * @return List<InvoiceChangeTask>
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public List<InvoiceChangeTask> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过invoiceChangeTaskId查询开票变更任务
     * @param invoiceChangeTaskId
     * @return InvoiceChangeTask
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public InvoiceChangeTask selectByPrimaryKey(Object invoiceChangeTaskId) {
        return super.selectByPrimaryKey(invoiceChangeTaskId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询开票变更任务
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<InvoiceChangeTask>
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public PageInfoExtend<InvoiceChangeTask> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询开票变更任务vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改开票变更任务
     * @param invoiceChangeTask,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public int updateByPrimaryKeyData(InvoiceChangeTask invoiceChangeTask,boolean exclusive) {
        return super.updateByPrimaryKey(invoiceChangeTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改开票变更任务,并进行排他
     * @param invoiceChangeTasks
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public int updateByPrimaryKeyDataList(List<InvoiceChangeTask> invoiceChangeTasks,boolean exclusive){
        return super.updateListByPrimaryKey(invoiceChangeTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改开票变更任务,并进行排他
     * @param invoiceChangeTask
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(InvoiceChangeTask invoiceChangeTask,boolean exclusive) {
        return super.updateByPrimaryKeySelective(invoiceChangeTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改开票变更任务,并进行排他
     * @param invoiceChangeTasks
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<InvoiceChangeTask> invoiceChangeTasks,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(invoiceChangeTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改开票变更任务,并进行排他
     * @param invoiceChangeTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public int updateByExampleData(InvoiceChangeTask invoiceChangeTask, Example example,boolean exclusive) {
        return super.updateByExample(invoiceChangeTask,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改开票变更任务,并进行排他
     * @param invoiceChangeTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public int updateByExampleSelectiveData(InvoiceChangeTask invoiceChangeTask, Example example,boolean exclusive){
        return super.updateByExampleSelective(invoiceChangeTask,example,exclusive);
    }

}
