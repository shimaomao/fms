package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.workflowlog.WorkflowLogVo;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liujinge
 * @ClassName: WorkflowLogController
 * @Description: 审批备注日志相关接口
 * @date 2018-03-28
 */
@RestController
@RequestMapping("workflow_log")
public class WorkflowLogController {

    /**
     * @Fields  : 审批备注日志service
     */
    @Autowired
    private WorkflowLogService workflowLogService;

    /**
     * @Title:
     * @Description: 分页查询审批备注日志信息
     * @param workflowLogVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-28 10:17:34
     */
    @RequestMapping(value = "findWorkflowLogsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findWorkflowLogsByPage(WorkflowLogVo workflowLogVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(workflowLogService.findWorkflowLogsByPage(workflowLogVo)),
                HttpStatus.OK);
    }



    /**
     * @Title:
     * @Description:  根据wfLogId获取审批备注日志
     * @param wfLogId
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-28 10:17:34
     */
    @RequestMapping(value = "findWorkflowLogByWfLogId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findWorkflowLogByWfLogId(String wfLogId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(workflowLogService.findWorkflowLogByWfLogId(wfLogId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  取得审批日志
     * @param applyNo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-28 10:17:34
     */
    @RequestMapping(value = "findWorkflowLogs", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findWorkflowLogs(String wfLogType, String applyNo, String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(workflowLogService.findWorkflowLogs(wfLogType, applyNo, contNo)), HttpStatus.OK);
    }

}
