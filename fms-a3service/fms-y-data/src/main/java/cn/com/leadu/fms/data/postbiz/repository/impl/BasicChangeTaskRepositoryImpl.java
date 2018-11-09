package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.postbiz.dao.BasicChangeTaskDao;
import cn.com.leadu.fms.data.postbiz.repository.BasicChangeTaskRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.BasicChangeTask;
import cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask.BasicChangeTaskCancelVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: BasicChangeTaskRepositoryImpl
 * @Description: 基本信息变更任务Repository 实现层
 * @date 2018-08-31
 */
@Repository
public class BasicChangeTaskRepositoryImpl extends AbstractBaseRepository<BasicChangeTaskDao, BasicChangeTask> implements BasicChangeTaskRepository {

    /**
     * @Title:
     * @Description: 新增基本信息变更任务
     * @param basicChangeTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:11:00
     */
    @Override
    public int insertData(BasicChangeTask basicChangeTask) {
        return super.insert(basicChangeTask);
    }

    /**
     * @Title:
     * @Description: 批量保存基本信息变更任务
     * @param basicChangeTasks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:11:00
     */
    @Override
    public int insertDataList(List<BasicChangeTask> basicChangeTasks){
        return super.insertListByJdbcTemplate(basicChangeTasks);
    }

    /**
     * @Title:
     * @Description: 修改基本信息变更任务
     * @param basicChangeTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:11:00
     */
    @Override
    public int updateByPrimaryKeyData(BasicChangeTask basicChangeTask) {
        return super.updateByPrimaryKey(basicChangeTask);
    }

    /**
     * @Title:
     * @Description: 批量修改基本信息变更任务
     * @param basicChangeTasks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:11:00
     */
    @Override
    public int updateByPrimaryKeyDataList(List<BasicChangeTask> basicChangeTasks){
        return super.updateListByPrimaryKey(basicChangeTasks);
    }

    /**
     * @Title:
     * @Description: 动态修改基本信息变更任务
     * @param basicChangeTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:11:00
     */
    @Override
    public int updateByPrimaryKeySelectiveData(BasicChangeTask basicChangeTask) {
        return super.updateByPrimaryKeySelective(basicChangeTask);
    }

    /**
     * @Title:
     * @Description: 批量动态修改基本信息变更任务
     * @param basicChangeTasks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:11:00
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<BasicChangeTask> basicChangeTasks) {
        return super.updateListByPrimaryKeySelective(basicChangeTasks);
    }

    /**
     * @Title:
     * @Description: 根据条件修改基本信息变更任务
     * @param basicChangeTask
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:11:00
     */
    @Override
    public int updateByExampleData(BasicChangeTask basicChangeTask, Example example) {
        return super.updateByExample(basicChangeTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改基本信息变更任务
     * @param basicChangeTask
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:11:00
     */
    @Override
    public int updateByExampleSelectiveData(BasicChangeTask basicChangeTask, Example example){
        return super.updateByExampleSelective(basicChangeTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据personChangeTaskId删除基本信息变更任务
     * @param basicChangeTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:11:00
     */
    @Override
    public int deleteData(BasicChangeTask basicChangeTask) {
        return super.delete(basicChangeTask);
    }

    /**
     * @Title:
     * @Description: 根据personChangeTaskId集合批量删除基本信息变更任务
     * @param basicChangeTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:11:00
     */
    @Override
    public int deleteDataList(List personChangeTaskIds,BasicChangeTask basicChangeTask){
        return super.deleteByIds(personChangeTaskIds,basicChangeTask);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除基本信息变更任务
     * @param example
     * @param basicChangeTask
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:11:00
     */
    @Override
    public int deleteExampleData(Example example,BasicChangeTask basicChangeTask){
        return super.deleteByExample(example,basicChangeTask);
    }

    /**
     * @Title:
     * @Description: 查询全部基本信息变更任务
     * @return List<BasicChangeTask>
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:11:00
     */
    @Override
    public List<BasicChangeTask> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个基本信息变更任务
     * @param example
     * @return BasicChangeTask
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:11:00
     */
    @Override
    public BasicChangeTask selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询基本信息变更任务
     * @param example
     * @return List<BasicChangeTask>
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:11:00
     */
    @Override
    public List<BasicChangeTask> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过personChangeTaskId查询基本信息变更任务
     * @param personChangeTaskId
     * @return BasicChangeTask
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:11:00
     */
    @Override
    public BasicChangeTask selectByPrimaryKey(Object personChangeTaskId) {
        return super.selectByPrimaryKey(personChangeTaskId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询基本信息变更任务
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<BasicChangeTask>
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:11:00
     */
    @Override
    public PageInfoExtend<BasicChangeTask> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询基本信息变更任务vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:11:00
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改基本信息变更任务
     * @param basicChangeTask,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:11:00
     */
    @Override
    public int updateByPrimaryKeyData(BasicChangeTask basicChangeTask,boolean exclusive) {
        return super.updateByPrimaryKey(basicChangeTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改基本信息变更任务,并进行排他
     * @param basicChangeTasks
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:11:00
     */
    @Override
    public int updateByPrimaryKeyDataList(List<BasicChangeTask> basicChangeTasks,boolean exclusive){
        return super.updateListByPrimaryKey(basicChangeTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改基本信息变更任务,并进行排他
     * @param basicChangeTask
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(BasicChangeTask basicChangeTask,boolean exclusive) {
        return super.updateByPrimaryKeySelective(basicChangeTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改基本信息变更任务,并进行排他
     * @param basicChangeTasks
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:11:00
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<BasicChangeTask> basicChangeTasks,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(basicChangeTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改基本信息变更任务,并进行排他
     * @param basicChangeTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:11:00
     */
    @Override
    public int updateByExampleData(BasicChangeTask basicChangeTask, Example example,boolean exclusive) {
        return super.updateByExample(basicChangeTask,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改基本信息变更任务,并进行排他
     * @param basicChangeTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:11:00
     */
    @Override
    public int updateByExampleSelectiveData(BasicChangeTask basicChangeTask, Example example,boolean exclusive){
        return super.updateByExampleSelective(basicChangeTask,example,exclusive);
    }

    /**
     * 获取基本信息变更取消内容
     *
     * @param basicChangeTaskCancelVo
     */
    @Override
    public BasicChangeTaskCancelVo selectBasicChangeCancelVo(BasicChangeTaskCancelVo basicChangeTaskCancelVo) {
        return baseDao.selectBasicChangeCancelVo(basicChangeTaskCancelVo);
    }

}
