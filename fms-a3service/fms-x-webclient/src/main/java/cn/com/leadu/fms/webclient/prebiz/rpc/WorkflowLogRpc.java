package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.workflowlog.WorkflowLogVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author liujinge
 * @ClassName: WorkflowLogController
 * @Description: 审批备注日志rpc
 * @date 2018-03-28
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface WorkflowLogRpc {

    /**
     * @Title:
     * @Description: 分页查询审批备注日志信息
     * @param workflowLogVoMap
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-28 10:17:35
     */
    @RequestMapping(value = "api/prebiz/workflow_log/findWorkflowLogsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findWorkflowLogsByPage(@RequestParam Map<String, Object> workflowLogVoMap);

    /**
     * @Title:
     * @Description: 保存审批备注日志
     * @param workflowLogVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-28 10:17:35
     */
    @RequestMapping(value = "api/prebiz/workflow_log/saveWorkflowLog",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveWorkflowLog(@RequestBody WorkflowLogVo workflowLogVo);


    /**
     * @Title:
     * @Description:  根据wfLogId获取审批备注日志
     * @param wfLogId
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-28 10:17:35
     */
    @RequestMapping(value = "api/prebiz/workflow_log/findWorkflowLogByWfLogId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findWorkflowLogByWfLogId(@RequestParam("wfLogId") String wfLogId);

    /**
     * @Title:
     * @Description:  根据wfLogId获取审批备注日志
     * @param applyNo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-28 10:17:35
     */
    @RequestMapping(value = "api/prebiz/workflow_log/findWorkflowLogs", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findWorkflowLogs(@RequestParam("wfLogType") String wfLogType, @RequestParam("applyNo") String applyNo, @RequestParam("contNo") String contNo);

}
