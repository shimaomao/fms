package cn.com.leadu.fms.business.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.prebiz.vo.workflowlog.WorkflowLogVo;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: WorkflowLogService
 * @Description: 审批日志业务层
 * @date 2018-03-24
 */
public interface WorkflowLogService {

	/**
	 * @Title:
	 * @Description: 分页查询审批日志
	 * @param workflowLogVo
	 * @return PageInfoExtend<WorkflowLog>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-24 11:31:24
	 */
	PageInfoExtend<WorkflowLog> findWorkflowLogsByPage(WorkflowLogVo workflowLogVo);


	/**
	 * @Title:
	 * @Description:  根据wfLogId获取审批日志
	 * @param wfLogId
	 * @return WorkflowLog
	 * @throws
	 * @author liujinge
	 * @date 2018-3-24 11:31:24
	 */
	WorkflowLog findWorkflowLogByWfLogId(String wfLogId);

	/**
	 * @Title:
	 * @Description:  插入审批日志
	 * @param workflowLog
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-24 11:31:24
	 */
	 int insertWorkFlowLog(WorkflowLog workflowLog);


	/**
	 * @Title:
	 * @Description:  根据订单编号取得日志
	 * @param applyNo
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-24 11:31:24
	 */
	 List<WorkflowLogVo> findWorkflowLogs(String wfLogType, String applyNo, String ContNo);


}
