package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.LawsuitTaskDao;
import cn.com.leadu.fms.data.postbiz.repository.LawsuitTaskRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.LawsuitTask;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.vo.lawsuitregister.LawsuitRegisterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.lawsuittask.LawsuitTaskSearchVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: LawsuitTaskRepositoryImpl
 * @Description: 诉讼任务信息Repository 实现层
 */
@Repository
public class LawsuitTaskRepositoryImpl extends AbstractBaseRepository<LawsuitTaskDao, LawsuitTask> implements LawsuitTaskRepository {

    /**
     * @Title:
     * @Description: 新增诉讼任务信息
     * @param lawsuitTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @Override
    public int insertData(LawsuitTask lawsuitTask) {
        return super.insert(lawsuitTask);
    }

    /**
     * @Title:
     * @Description: 批量保存诉讼任务信息
     * @param lawsuitTasks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @Override
    public int insertDataList(List<LawsuitTask> lawsuitTasks){
        return super.insertListByJdbcTemplate(lawsuitTasks);
    }

    /**
     * @Title:
     * @Description: 修改诉讼任务信息
     * @param lawsuitTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @Override
    public int updateByPrimaryKeyData(LawsuitTask lawsuitTask) {
        return super.updateByPrimaryKey(lawsuitTask);
    }

    /**
     * @Title:
     * @Description: 批量修改诉讼任务信息
     * @param lawsuitTasks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @Override
    public int updateByPrimaryKeyDataList(List<LawsuitTask> lawsuitTasks){
        return super.updateListByPrimaryKey(lawsuitTasks);
    }

    /**
     * @Title:
     * @Description: 动态修改诉讼任务信息
     * @param lawsuitTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @Override
    public int updateByPrimaryKeySelectiveData(LawsuitTask lawsuitTask) {
        return super.updateByPrimaryKeySelective(lawsuitTask);
    }

    /**
     * @Title:
     * @Description: 批量动态修改诉讼任务信息
     * @param lawsuitTasks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<LawsuitTask> lawsuitTasks) {
        return super.updateListByPrimaryKeySelective(lawsuitTasks);
    }

    /**
     * @Title:
     * @Description: 根据条件修改诉讼任务信息
     * @param lawsuitTask
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @Override
    public int updateByExampleData(LawsuitTask lawsuitTask, Example example) {
        return super.updateByExample(lawsuitTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改诉讼任务信息
     * @param lawsuitTask
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @Override
    public int updateByExampleSelectiveData(LawsuitTask lawsuitTask, Example example){
        return super.updateByExampleSelective(lawsuitTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据lawsuitTaskId删除诉讼任务信息
     * @param lawsuitTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @Override
    public int deleteData(LawsuitTask lawsuitTask) {
        return super.delete(lawsuitTask);
    }

    /**
     * @Title:
     * @Description: 根据lawsuitTaskId集合批量删除诉讼任务信息
     * @param lawsuitTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @Override
    public int deleteDataList(List lawsuitTaskIds,LawsuitTask lawsuitTask){
        return super.deleteByIds(lawsuitTaskIds,lawsuitTask);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除诉讼任务信息
     * @param example
     * @param lawsuitTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @Override
    public int deleteExampleData(Example example,LawsuitTask lawsuitTask){
        return super.deleteByExample(example,lawsuitTask);
    }

    /**
     * @Title:
     * @Description: 查询全部诉讼任务信息
     * @return List<LawsuitTask>
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @Override
    public List<LawsuitTask> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个诉讼任务信息
     * @param example
     * @return LawsuitTask
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @Override
    public LawsuitTask selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询诉讼任务信息
     * @param example
     * @return List<LawsuitTask>
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @Override
    public List<LawsuitTask> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过lawsuitTaskId查询诉讼任务信息
     * @param lawsuitTaskId
     * @return LawsuitTask
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @Override
    public LawsuitTask selectByPrimaryKey(Object lawsuitTaskId) {
        return super.selectByPrimaryKey(lawsuitTaskId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询诉讼任务信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<LawsuitTask>
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @Override
    public PageInfoExtend<LawsuitTask> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询诉讼任务信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改诉讼任务信息
     * @param lawsuitTask,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @Override
    public int updateByPrimaryKeyData(LawsuitTask lawsuitTask,boolean exclusive) {
        return super.updateByPrimaryKey(lawsuitTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改诉讼任务信息,并进行排他
     * @param lawsuitTasks
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @Override
    public int updateByPrimaryKeyDataList(List<LawsuitTask> lawsuitTasks,boolean exclusive){
        return super.updateListByPrimaryKey(lawsuitTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改诉讼任务信息,并进行排他
     * @param lawsuitTask
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(LawsuitTask lawsuitTask,boolean exclusive) {
        return super.updateByPrimaryKeySelective(lawsuitTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改诉讼任务信息,并进行排他
     * @param lawsuitTasks
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<LawsuitTask> lawsuitTasks,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(lawsuitTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改诉讼任务信息,并进行排他
     * @param lawsuitTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @Override
    public int updateByExampleData(LawsuitTask lawsuitTask, Example example,boolean exclusive) {
        return super.updateByExample(lawsuitTask,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改诉讼任务信息,并进行排他
     * @param lawsuitTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:47:47
     */
    @Override
    public int updateByExampleSelectiveData(LawsuitTask lawsuitTask, Example example,boolean exclusive){
        return super.updateByExampleSelective(lawsuitTask,example,exclusive);
    }

    /**
     * 根据lawsuitTaskNo获取诉讼任务信息
     *
     * @param lawsuitTaskNo
     * @return
     */
    @Override
    public LawsuitTaskSearchVo selectLawsuitTasksByTaskNo(String lawsuitTaskNo) {
        return baseDao.selectLawsuitTasksByTaskNo(lawsuitTaskNo);
    }

    /**
     * 根据overdueContId获取诉讼基本信息
     *
     * @param overdueContId
     * @return
     */
    @Override
    public LawsuitTaskSearchVo selectLawsuitTasksByOverdueContId(String overdueContId) {
        return baseDao.selectLawsuitTasksByOverdueContId(overdueContId);
    }

    /**
     * 根据lawsuitTaskNo获取诉讼登记信息
     *
     * @param lawsuitTaskNo
     * @return
     */
    @Override
    public LawsuitTaskSearchVo selectLawsuitRegistersByTaskNo(String lawsuitTaskNo) {
        return baseDao.selectLawsuitRegistersByTaskNo(lawsuitTaskNo);
    }

    /**
     * 获取诉讼任务表中所有的逾期合同ID
     * @param
     * @return List<String>
     * @author wangxue
     * @date 2018-9-19
     */
    @Override
    public List<String> selectAllOverdueContIds() {
        return baseDao.selectAllOverdueContIds();
    }

    /**
     * 根据任务号获取历史诉讼登记信息List
     */
    @Override
    public List<LawsuitRegisterVo> selectLawsuitRegisterVosByLawsuitTaskNo(String lawsuitTaskNo) {
        return baseDao.selectLawsuitRegisterVosByLawsuitTaskNo(lawsuitTaskNo);
    }
}
