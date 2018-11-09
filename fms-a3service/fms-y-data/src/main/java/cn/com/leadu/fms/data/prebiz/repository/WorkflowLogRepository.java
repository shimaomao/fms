package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.prebiz.vo.workflowlog.WorkflowLogVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: WorkflowLogRepository
 * @Description: 审批日志Repository层
 * @date 2018-03-24
 */
public interface WorkflowLogRepository {

	/**
	 * @Title:
	 * @Description: 新增审批日志
	 * @param workflowLog
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-24 11:31:23
	 */
	int insertData(WorkflowLog workflowLog);

	/**
	 * @Title:
	 * @Description: 批量保存审批日志
	 * @param workflowLogs
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-24 11:31:23
	 */
	int insertDataList(List<WorkflowLog> workflowLogs);

	/**
	 * @Title:
	 * @Description: 修改审批日志
	 * @param workflowLog
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-24 11:31:23
	 */
	int updateByPrimaryKeyData(WorkflowLog workflowLog);

	/**
	 * @Title:
	 * @Description: 批量修改审批日志
	 * @param workflowLogs
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-24 11:31:23
	 */
	int updateByPrimaryKeyDataList(List<WorkflowLog> workflowLogs);

	/**
	 * @Title:
	 * @Description: 动态修改审批日志
	 * @param workflowLog
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-24 11:31:23
	 */
	int updateByPrimaryKeySelectiveData(WorkflowLog workflowLog);

	/**
	 * @Title:
	 * @Description: 批量动态修改审批日志
	 * @param workflowLogs
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-24 11:31:23
	 */
	int updateByPrimaryKeySelectiveDataList(List<WorkflowLog> workflowLogs);

	/**
	 * @Title:
	 * @Description: 根据条件修改审批日志
	 * @param workflowLog
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-24 11:31:23
	 */
	int updateByExampleData(WorkflowLog workflowLog, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改审批日志
	 * @param workflowLog
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-24 11:31:23
	 */
	int updateByExampleSelectiveData(WorkflowLog workflowLog, Example example);

	/**
	 * @Title:
	 * @Description: 根据wfLogId删除审批日志
	 * @param workflowLog
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-24 11:31:23
	 */
	int deleteData(WorkflowLog workflowLog);

	/**
	 * @Title:
	 * @Description: 根据wfLogId集合批量删除审批日志
	 * @param wfLogIds
	 * @param workflowLog
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-24 11:31:23
	 */
	int deleteDataList(List wfLogIds, WorkflowLog workflowLog);

	/**
	 * @Title:
	 * @Description: 查询全部审批日志
	 * @return List<WorkflowLog>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-24 11:31:23
	 */
	List<WorkflowLog> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个审批日志
	 * @param example
	 * @return WorkflowLog
	 * @throws
	 * @author liujinge
	 * @date 2018-3-24 11:31:23
	 */
	WorkflowLog selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询审批日志
	 * @param example
	 * @return List<WorkflowLog>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-24 11:31:23
	 */
	List<WorkflowLog> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过wfLogId查询审批日志
	 * @param wfLogId
	 * @return WorkflowLog
	 * @throws
	 * @author liujinge
	 * @date 2018-3-24 11:31:23
	 */
	WorkflowLog selectByPrimaryKey(Object wfLogId);

	/**
	 * @Title:
	 * @Description: 分页查询审批日志
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<WorkflowLog>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-24 11:31:23
	 */
	PageInfoExtend<WorkflowLog> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询审批日志vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<WorkflowLog>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-24 11:31:23
	 */
	PageInfoExtend<WorkflowLog> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询审批日志vo
	 * @param applyNo
	 * @param contNo
	 * @return PageInfoExtend<WorkflowLog>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-24 11:31:23
	 */
	List<WorkflowLogVo> selectWorkFlowLogs(String wfLogType, String applyNo, String contNo);

}
