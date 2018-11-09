package cn.com.leadu.fms.data.prebiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.prebiz.vo.workflowlog.WorkflowLogVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: WorkflowLogDao
 * @Description: 审批日志dao层
 * @date 2018-03-24
 */
public interface WorkflowLogDao extends BaseDao<WorkflowLog> {


    List<WorkflowLogVo> selectWorkFlowLogs(@Param("wfLogType") String wfLogType, @Param("applyNo") String applyNo, @Param("contNo") String contNo);
}