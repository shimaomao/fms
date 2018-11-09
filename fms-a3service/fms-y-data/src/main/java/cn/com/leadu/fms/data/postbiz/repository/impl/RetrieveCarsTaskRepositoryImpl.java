package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.postbiz.dao.RetrieveCarsTaskDao;
import cn.com.leadu.fms.data.postbiz.repository.RetrieveCarsTaskRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.RetrieveCarsTask;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.CollectionLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.retrievecarstask.RetrieveCarsTaskVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: RetrieveCarsTaskRepositoryImpl
 * @Description: 收车任务Repository 实现层
 */
@Repository
public class RetrieveCarsTaskRepositoryImpl extends AbstractBaseRepository<RetrieveCarsTaskDao, RetrieveCarsTask> implements RetrieveCarsTaskRepository {

    /**
     * @Title:
     * @Description: 新增收车任务
     * @param retrieveCarsTask
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @Override
    public int insertData(RetrieveCarsTask retrieveCarsTask) {
        return super.insert(retrieveCarsTask);
    }

    /**
     * @Title:
     * @Description: 批量保存收车任务
     * @param retrieveCarsTasks
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @Override
    public int insertDataList(List<RetrieveCarsTask> retrieveCarsTasks){
        return super.insertListByJdbcTemplate(retrieveCarsTasks);
    }

    /**
     * @Title:
     * @Description: 修改收车任务
     * @param retrieveCarsTask
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @Override
    public int updateByPrimaryKeyData(RetrieveCarsTask retrieveCarsTask) {
        return super.updateByPrimaryKey(retrieveCarsTask);
    }

    /**
     * @Title:
     * @Description: 批量修改收车任务
     * @param retrieveCarsTasks
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @Override
    public int updateByPrimaryKeyDataList(List<RetrieveCarsTask> retrieveCarsTasks){
        return super.updateListByPrimaryKey(retrieveCarsTasks);
    }

    /**
     * @Title:
     * @Description: 动态修改收车任务
     * @param retrieveCarsTask
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @Override
    public int updateByPrimaryKeySelectiveData(RetrieveCarsTask retrieveCarsTask) {
        return super.updateByPrimaryKeySelective(retrieveCarsTask);
    }

    /**
     * @Title:
     * @Description: 批量动态修改收车任务
     * @param retrieveCarsTasks
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<RetrieveCarsTask> retrieveCarsTasks) {
        return super.updateListByPrimaryKeySelective(retrieveCarsTasks);
    }

    /**
     * @Title:
     * @Description: 根据条件修改收车任务
     * @param retrieveCarsTask
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @Override
    public int updateByExampleData(RetrieveCarsTask retrieveCarsTask, Example example) {
        return super.updateByExample(retrieveCarsTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改收车任务
     * @param retrieveCarsTask
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @Override
    public int updateByExampleSelectiveData(RetrieveCarsTask retrieveCarsTask, Example example){
        return super.updateByExampleSelective(retrieveCarsTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据retrieveCarId删除收车任务
     * @param retrieveCarsTask
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @Override
    public int deleteData(RetrieveCarsTask retrieveCarsTask) {
        return super.delete(retrieveCarsTask);
    }

    /**
     * @Title:
     * @Description: 根据retrieveCarId集合批量删除收车任务
     * @param retrieveCarsTask
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @Override
    public int deleteDataList(List retrieveCarIds,RetrieveCarsTask retrieveCarsTask){
        return super.deleteByIds(retrieveCarIds,retrieveCarsTask);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除收车任务
     * @param example
     * @param retrieveCarsTask
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @Override
    public int deleteExampleData(Example example,RetrieveCarsTask retrieveCarsTask){
        return super.deleteByExample(example,retrieveCarsTask);
    }

    /**
     * @Title:
     * @Description: 查询全部收车任务
     * @return List<RetrieveCarsTask>
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @Override
    public List<RetrieveCarsTask> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个收车任务
     * @param example
     * @return RetrieveCarsTask
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @Override
    public RetrieveCarsTask selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询收车任务
     * @param example
     * @return List<RetrieveCarsTask>
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @Override
    public List<RetrieveCarsTask> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过retrieveCarId查询收车任务
     * @param retrieveCarId
     * @return RetrieveCarsTask
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @Override
    public RetrieveCarsTask selectByPrimaryKey(Object retrieveCarId) {
        return super.selectByPrimaryKey(retrieveCarId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询收车任务
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<RetrieveCarsTask>
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @Override
    public PageInfoExtend<RetrieveCarsTask> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询收车任务vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改收车任务
     * @param retrieveCarsTask,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @Override
    public int updateByPrimaryKeyData(RetrieveCarsTask retrieveCarsTask,boolean exclusive) {
        return super.updateByPrimaryKey(retrieveCarsTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改收车任务,并进行排他
     * @param retrieveCarsTasks
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @Override
    public int updateByPrimaryKeyDataList(List<RetrieveCarsTask> retrieveCarsTasks,boolean exclusive){
        return super.updateListByPrimaryKey(retrieveCarsTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改收车任务,并进行排他
     * @param retrieveCarsTask
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(RetrieveCarsTask retrieveCarsTask,boolean exclusive) {
        return super.updateByPrimaryKeySelective(retrieveCarsTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改收车任务,并进行排他
     * @param retrieveCarsTasks
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<RetrieveCarsTask> retrieveCarsTasks,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(retrieveCarsTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改收车任务,并进行排他
     * @param retrieveCarsTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @Override
    public int updateByExampleData(RetrieveCarsTask retrieveCarsTask, Example example,boolean exclusive) {
        return super.updateByExample(retrieveCarsTask,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改收车任务,并进行排他
     * @param retrieveCarsTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-12 15:55:56
     */
    @Override
    public int updateByExampleSelectiveData(RetrieveCarsTask retrieveCarsTask, Example example,boolean exclusive){
        return super.updateByExampleSelective(retrieveCarsTask,example,exclusive);
    }

    /**
     * @Title:
     * @Description:   根据收车任务Id查询收车任务vo
     * @param retrieveCarId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/15 02:52:48
     */
    public RetrieveCarsTaskVo selectRetrieveCarsTaskVoById(String retrieveCarId){
        return baseDao.selectRetrieveCarsTaskVoById(retrieveCarId);
    }

    /**
     * @Title:
     * @Description:   根据收车任务Id查询收车任务vo
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/15 02:52:48
     */
    public List<RetrieveCarsTaskVo> selectRetrieveCarsTaskVos(RetrieveCarsTaskVo retrieveCarsTaskVo){
        return baseDao.selectRetrieveCarsTaskVos(retrieveCarsTaskVo);
    }

    /**
     * @Title:
     * @Description:   根据收车任务号查询收车任务vo
     * @param retrieveCarTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/18 01:47:40
     */
   public RetrieveCarsTaskVo selectRetrieveCarsTaskVoByTaskNo(String retrieveCarTaskNo){
       return baseDao.selectRetrieveCarsTaskVoByTaskNo(retrieveCarTaskNo);
   }

    /**
     * @Title:
     * @Description:   获取收车任务表中全部的逾期合同ID
     * @return List<String>
     * @throws
     * @author wangxue
     * @date 2018/09/19
     */
    @Override
    public List<String> selectAllOverdueContIds() {
        return baseDao.selectAllOverdueContIds();
    }

    /**
     * 获取委托书下载数据List
     *
     * @param retrieveCarTaskNo
     * @return
     */
    @Override
    public List<CollectionLetterVo> selectproxyDownloadInfo(String retrieveCarTaskNo) {
        return baseDao.selectproxyDownloadInfo(retrieveCarTaskNo);
    }
}
