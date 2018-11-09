package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.postbiz.dao.CollectionTaskDao;
import cn.com.leadu.fms.data.postbiz.repository.CollectionTaskRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.CollectionTask;
import cn.com.leadu.fms.pojo.postbiz.vo.collectiontask.CollectionTaskVo;
import cn.com.leadu.fms.pojo.postbiz.vo.collectiontask.CstmAddrInfoVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.CollectionLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.LawyerLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmPostVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: CollectionTaskRepositoryImpl
 * @Description: 催收任务Repository 实现层
 */
@Repository
public class CollectionTaskRepositoryImpl extends AbstractBaseRepository<CollectionTaskDao, CollectionTask> implements CollectionTaskRepository {

    /**
     * @Title:
     * @Description: 新增催收任务
     * @param collectionTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @Override
    public int insertData(CollectionTask collectionTask) {
        return super.insert(collectionTask);
    }

    /**
     * @Title:
     * @Description: 批量保存催收任务
     * @param collectionTasks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @Override
    public int insertDataList(List<CollectionTask> collectionTasks){
        return super.insertListByJdbcTemplate(collectionTasks);
    }

    /**
     * @Title:
     * @Description: 修改催收任务
     * @param collectionTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @Override
    public int updateByPrimaryKeyData(CollectionTask collectionTask) {
        return super.updateByPrimaryKey(collectionTask);
    }

    /**
     * @Title:
     * @Description: 批量修改催收任务
     * @param collectionTasks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @Override
    public int updateByPrimaryKeyDataList(List<CollectionTask> collectionTasks){
        return super.updateListByPrimaryKey(collectionTasks);
    }

    /**
     * @Title:
     * @Description: 动态修改催收任务
     * @param collectionTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @Override
    public int updateByPrimaryKeySelectiveData(CollectionTask collectionTask) {
        return super.updateByPrimaryKeySelective(collectionTask);
    }

    /**
     * @Title:
     * @Description: 批量动态修改催收任务
     * @param collectionTasks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<CollectionTask> collectionTasks) {
        return super.updateListByPrimaryKeySelective(collectionTasks);
    }

    /**
     * @Title:
     * @Description: 根据条件修改催收任务
     * @param collectionTask
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @Override
    public int updateByExampleData(CollectionTask collectionTask, Example example) {
        return super.updateByExample(collectionTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改催收任务
     * @param collectionTask
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @Override
    public int updateByExampleSelectiveData(CollectionTask collectionTask, Example example){
        return super.updateByExampleSelective(collectionTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据collectionTaskId删除催收任务
     * @param collectionTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @Override
    public int deleteData(CollectionTask collectionTask) {
        return super.delete(collectionTask);
    }

    /**
     * @Title:
     * @Description: 根据collectionTaskId集合批量删除催收任务
     * @param collectionTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @Override
    public int deleteDataList(List collectionTaskIds,CollectionTask collectionTask){
        return super.deleteByIds(collectionTaskIds,collectionTask);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除催收任务
     * @param example
     * @param collectionTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @Override
    public int deleteExampleData(Example example,CollectionTask collectionTask){
        return super.deleteByExample(example,collectionTask);
    }

    /**
     * @Title:
     * @Description: 查询全部催收任务
     * @return List<CollectionTask>
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @Override
    public List<CollectionTask> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个催收任务
     * @param example
     * @return CollectionTask
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @Override
    public CollectionTask selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询催收任务
     * @param example
     * @return List<CollectionTask>
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @Override
    public List<CollectionTask> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过collectionTaskId查询催收任务
     * @param collectionTaskId
     * @return CollectionTask
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @Override
    public CollectionTask selectByPrimaryKey(Object collectionTaskId) {
        return super.selectByPrimaryKey(collectionTaskId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询催收任务
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<CollectionTask>
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @Override
    public PageInfoExtend<CollectionTask> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询催收任务vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改催收任务
     * @param collectionTask,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @Override
    public int updateByPrimaryKeyData(CollectionTask collectionTask,boolean exclusive) {
        return super.updateByPrimaryKey(collectionTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改催收任务,并进行排他
     * @param collectionTasks
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @Override
    public int updateByPrimaryKeyDataList(List<CollectionTask> collectionTasks,boolean exclusive){
        return super.updateListByPrimaryKey(collectionTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改催收任务,并进行排他
     * @param collectionTask
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(CollectionTask collectionTask,boolean exclusive) {
        return super.updateByPrimaryKeySelective(collectionTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改催收任务,并进行排他
     * @param collectionTasks
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<CollectionTask> collectionTasks,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(collectionTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改催收任务,并进行排他
     * @param collectionTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @Override
    public int updateByExampleData(CollectionTask collectionTask, Example example,boolean exclusive) {
        return super.updateByExample(collectionTask,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改催收任务,并进行排他
     * @param collectionTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @Override
    public int updateByExampleSelectiveData(CollectionTask collectionTask, Example example,boolean exclusive){
        return super.updateByExampleSelective(collectionTask,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据certifNo获取客户地址信息
     * @param overdueCstmId
     * @return CollectionTaskVo
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @Override
    public CollectionTaskVo selectCstmAddrPerInfosByOverdueCstmId(String overdueCstmId) {
        return baseDao.selectCstmAddrPerInfosByOverdueCstmId(overdueCstmId);
    }

    /**
     * 根据certifNo获取客户地址信息
     *
     * @param certifNo
     * @return
     */
    @Override
    public List<CstmAddrInfoVo> getCstmAddrInfoVoList(String certifNo) {
        return baseDao.getCstmAddrInfoVoList(certifNo);
    }

    /**
     * 根据collectionTaskNo获取催收任务信息
     *
     * @param collectionTaskNo
     * @return
     */
    @Override
    public CollectionTaskVo selectCollectionTaskByCollectionTaskNo(String collectionTaskNo) {
        return baseDao.selectCollectionTaskByCollectionTaskNo(collectionTaskNo);
    }

    /**
     * 取得上门催收任务表中全部的逾期客户ID
     * @return List<String>
     * @author wangxue
     * @date 2018-9-19
     */
    @Override
    public List<String> selectAllOverdueCstmIds() {
        return baseDao.selectAllOverdueCstmIds();
    }

    /**
     * 根据任务号获取所有逾期合同号
     *
     * @param collectionTaskNo
     * @return
     */
    @Override
    public List<OverdueCstmPostVo> selectContNoListByCollectionTaskNo(String collectionTaskNo) {
        return baseDao.selectContNoListByCollectionTaskNo(collectionTaskNo);
    }

    /**
     * 获取委托书需要数据
     *
     * @param collectionTaskNo
     * @return
     */
    @Override
    public List<CollectionLetterVo> selectProxyLetterInfo(String collectionTaskNo) {
        return baseDao.selectProxyLetterInfo(collectionTaskNo);
    }

    /**
     * 获取律师函数据
     */
    @Override
    public List<LawyerLetterVo> selectLawyerLetterVoList(String collectionTaskNo) {
        return baseDao.selectLawyerLetterVoList(collectionTaskNo);
    }
}
