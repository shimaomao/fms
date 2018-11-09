package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.workflowlog.WorkflowLogVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.WorkflowLogRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author liujinge
 * @ClassName: WorkflowLogController
 * @Description: 审批备注日志controller
 * @date 2018-03-28
 */
@RestController
@RequestMapping("workflow_log")
public class WorkflowLogController {

    /**
     * @Fields  : 审批备注日志rpc
     */
    @Autowired
    private WorkflowLogRpc workflowLogRpc;

    /**
     * @Title:
     * @Description: 分页查询审批备注日志信息
     * @param workflowLogVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-28 10:17:35
     */
    @RequestMapping(value = "findWorkflowLogsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findWorkflowLogsByPage(WorkflowLogVo workflowLogVo){
        Map workflowLogVoMap = workflowLogVo == null?null:(Map) JSON.toJSON(workflowLogVo);
        return workflowLogRpc.findWorkflowLogsByPage(workflowLogVoMap);
    }

    /**
     * @Title:
     * @Description: 保存审批备注日志
     * @param workflowLogVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-28 10:17:35
     */
    @RequestMapping(value = "saveWorkflowLog",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveWorkflowLog(@RequestBody WorkflowLogVo workflowLogVo){
        return workflowLogRpc.saveWorkflowLog(workflowLogVo);
    }

    /**
     * @Title:
     * @Description:  根据wfLogId获取审批备注日志
     * @param wfLogId
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-28 10:17:35
     */
    @RequestMapping(value = "findWorkflowLogByWfLogId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findWorkflowLogByWfLogId(String wfLogId){
        return workflowLogRpc.findWorkflowLogByWfLogId(wfLogId);
    }

    /**
     * @Title:
     * @Description:  根据wfLogId获取审批备注日志
     * @param applyNo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-28 10:17:35
     */
    @RequestMapping(value = "findWorkflowLogs", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findWorkflowLogs(String wfLogType,String applyNo, String contNo){
        return workflowLogRpc.findWorkflowLogs(wfLogType, applyNo, contNo);
    }
}
