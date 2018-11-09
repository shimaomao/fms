package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.WorkflowLogDao;
import cn.com.leadu.fms.data.prebiz.repository.WorkflowLogRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.vo.workflowlog.WorkflowLogVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: WorkflowLogRepositoryImpl
 * @Description: 审批日志Repository 实现层
 * @date 2018-03-24
 */
@Repository
public class WorkflowLogRepositoryImpl extends AbstractBaseRepository<WorkflowLogDao, WorkflowLog> implements WorkflowLogRepository {

    /**
     * @Title:
     * @Description: 新增审批日志
     * @param workflowLog
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-24 11:31:24
     */
    @Override
    public int insertData(WorkflowLog workflowLog) {
        return super.insert(workflowLog);
    }

    /**
     * @Title:
     * @Description: 批量保存审批日志
     * @param workflowLogs
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-24 11:31:24
     */
    @Override
    public int insertDataList(List<WorkflowLog> workflowLogs){
        return super.insertListByJdbcTemplate(workflowLogs);
    }

    /**
     * @Title:
     * @Description: 修改审批日志
     * @param workflowLog
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-24 11:31:24
     */
    @Override
    public int updateByPrimaryKeyData(WorkflowLog workflowLog) {
        return super.updateByPrimaryKey(workflowLog);
    }

    /**
     * @Title:
     * @Description: 批量修改审批日志
     * @param workflowLogs
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-24 11:31:24
     */
    @Override
    public int updateByPrimaryKeyDataList(List<WorkflowLog> workflowLogs){
        return super.insertListByJdbcTemplate(workflowLogs);
    }

    /**
     * @Title:
     * @Description: 动态修改审批日志
     * @param workflowLog
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-24 11:31:24
     */
    @Override
    public int updateByPrimaryKeySelectiveData(WorkflowLog workflowLog) {
        return super.updateByPrimaryKeySelective(workflowLog);
    }

    /**
     * @Title:
     * @Description: 批量动态修改审批日志
     * @param workflowLogs
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-24 11:31:24
     */
    public int updateByPrimaryKeySelectiveDataList(List<WorkflowLog> workflowLogs) {
        return super.updateListByPrimaryKeySelective(workflowLogs);
    }

    /**
     * @Title:
     * @Description: 根据条件修改审批日志
     * @param workflowLog
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-24 11:31:24
     */
    @Override
    public int updateByExampleData(WorkflowLog workflowLog, Example example) {
        return super.updateByExample(workflowLog,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改审批日志
     * @param workflowLog
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-24 11:31:24
     */
    @Override
    public int updateByExampleSelectiveData(WorkflowLog workflowLog, Example example){
        return super.updateByExampleSelective(workflowLog,example);
    }
    
    /**
     * @Title:
     * @Description: 根据wfLogId删除审批日志
     * @param workflowLog
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-24 11:31:24
     */
    @Override
    public int deleteData(WorkflowLog workflowLog) {
        return super.delete(workflowLog);
    }

    /**
     * @Title:
     * @Description: 根据wfLogId集合批量删除审批日志
     * @param workflowLog
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-24 11:31:24
     */
    public int deleteDataList(List wfLogIds,WorkflowLog workflowLog){
        return super.deleteByIds(wfLogIds,workflowLog);
    }

    /**
     * @Title:
     * @Description: 查询全部审批日志
     * @return List<WorkflowLog>
     * @throws
     * @author liujinge
     * @date 2018-3-24 11:31:24
     */
    @Override
    public List<WorkflowLog> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个审批日志
     * @param example
     * @return WorkflowLog
     * @throws
     * @author liujinge
     * @date 2018-3-24 11:31:24
     */
    @Override
    public WorkflowLog selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询审批日志
     * @param example
     * @return List<WorkflowLog>
     * @throws
     * @author liujinge
     * @date 2018-3-24 11:31:24
     */
    @Override
    public List<WorkflowLog> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过wfLogId查询审批日志
     * @param wfLogId
     * @return WorkflowLog
     * @throws
     * @author liujinge
     * @date 2018-3-24 11:31:24
     */
    @Override
    public WorkflowLog selectByPrimaryKey(Object wfLogId) {
        return super.selectByPrimaryKey(wfLogId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询审批日志
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<WorkflowLog>
     * @throws
     * @author liujinge
     * @date 2018-3-24 11:31:24
     */
    @Override
    public PageInfoExtend<WorkflowLog> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询审批日志vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<WorkflowLog>
     * @throws
     * @author liujinge
     * @date 2018-3-24 11:31:24
     */
    public PageInfoExtend<WorkflowLog> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    @Override
    public List<WorkflowLogVo> selectWorkFlowLogs(String wfLogType, String applyNo, String contNo) {
        return baseDao.selectWorkFlowLogs(wfLogType, applyNo, contNo);
    }

}
