package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.DeferTaskDao;
import cn.com.leadu.fms.data.postbiz.repository.DeferTaskRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.DeferTask;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.vo.defertask.DeferTaskVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: DeferTaskRepositoryImpl
 * @Description: 合同展期Repository 实现层
 */
@Repository
public class DeferTaskRepositoryImpl extends AbstractBaseRepository<DeferTaskDao, DeferTask> implements DeferTaskRepository {

    /**
     * @Title:
     * @Description: 新增合同展期
     * @param deferTask
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    public int insertData(DeferTask deferTask) {
        return super.insert(deferTask);
    }

    /**
     * @Title:
     * @Description: 批量保存合同展期
     * @param deferTasks
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    public int insertDataList(List<DeferTask> deferTasks){
        return super.insertListByJdbcTemplate(deferTasks);
    }

    /**
     * @Title:
     * @Description: 修改合同展期
     * @param deferTask
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    public int updateByPrimaryKeyData(DeferTask deferTask) {
        return super.updateByPrimaryKey(deferTask);
    }

    /**
     * @Title:
     * @Description: 批量修改合同展期
     * @param deferTasks
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    public int updateByPrimaryKeyDataList(List<DeferTask> deferTasks){
        return super.updateListByPrimaryKey(deferTasks);
    }

    /**
     * @Title:
     * @Description: 动态修改合同展期
     * @param deferTask
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    public int updateByPrimaryKeySelectiveData(DeferTask deferTask) {
        return super.updateByPrimaryKeySelective(deferTask);
    }

    /**
     * @Title:
     * @Description: 批量动态修改合同展期
     * @param deferTasks
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<DeferTask> deferTasks) {
        return super.updateListByPrimaryKeySelective(deferTasks);
    }

    /**
     * @Title:
     * @Description: 根据条件修改合同展期
     * @param deferTask
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    public int updateByExampleData(DeferTask deferTask, Example example) {
        return super.updateByExample(deferTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改合同展期
     * @param deferTask
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    public int updateByExampleSelectiveData(DeferTask deferTask, Example example){
        return super.updateByExampleSelective(deferTask,example);
    }
    
    /**
     * @Title:
     * @Description: 根据deferTaskId删除合同展期
     * @param deferTask
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    public int deleteData(DeferTask deferTask) {
        return super.delete(deferTask);
    }

    /**
     * @Title:
     * @Description: 根据deferTaskId集合批量删除合同展期
     * @param deferTask
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    public int deleteDataList(List deferTaskIds,DeferTask deferTask){
        return super.deleteByIds(deferTaskIds,deferTask);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除合同展期
     * @param example
     * @param deferTask
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    public int deleteExampleData(Example example,DeferTask deferTask){
        return super.deleteByExample(example,deferTask);
    }

    /**
     * @Title:
     * @Description: 查询全部合同展期
     * @return List<DeferTask>
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    public List<DeferTask> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个合同展期
     * @param example
     * @return DeferTask
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    public DeferTask selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询合同展期
     * @param example
     * @return List<DeferTask>
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    public List<DeferTask> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过deferTaskId查询合同展期
     * @param deferTaskId
     * @return DeferTask
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    public DeferTask selectByPrimaryKey(Object deferTaskId) {
        return super.selectByPrimaryKey(deferTaskId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询合同展期
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<DeferTask>
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    public PageInfoExtend<DeferTask> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询合同展期vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改合同展期
     * @param deferTask,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    public int updateByPrimaryKeyData(DeferTask deferTask,boolean exclusive) {
        return super.updateByPrimaryKey(deferTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改合同展期,并进行排他
     * @param deferTasks
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    public int updateByPrimaryKeyDataList(List<DeferTask> deferTasks,boolean exclusive){
        return super.updateListByPrimaryKey(deferTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改合同展期,并进行排他
     * @param deferTask
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(DeferTask deferTask,boolean exclusive) {
        return super.updateByPrimaryKeySelective(deferTask,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改合同展期,并进行排他
     * @param deferTasks
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<DeferTask> deferTasks,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(deferTasks,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改合同展期,并进行排他
     * @param deferTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    public int updateByExampleData(DeferTask deferTask, Example example,boolean exclusive) {
        return super.updateByExample(deferTask,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改合同展期,并进行排他
     * @param deferTask
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-9-1 14:35:16
     */
    @Override
    public int updateByExampleSelectiveData(DeferTask deferTask, Example example,boolean exclusive){
        return super.updateByExampleSelective(deferTask,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据contNo获取展期合同的当前合同信息
     * @param deferTaskVo
     * @return DeferTaskVo
     * @throws
     * @author ningyangyang
     * @date 2018-9-3 14:35:16
     */
    @Override
    public DeferTaskVo selectDeferTaskVoByContNo(DeferTaskVo deferTaskVo) {
        return baseDao.selectDeferTaskVoByContNo(deferTaskVo);
    }

}
