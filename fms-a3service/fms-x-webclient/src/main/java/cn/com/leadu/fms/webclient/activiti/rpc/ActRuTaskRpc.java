package cn.com.leadu.fms.webclient.activiti.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: ActRuTaskController
 * @Description: 工作流任务 rpc
 * @date 2018/3/14
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ActRuTaskRpc {

    /**
     * @Title:
     * @Description:   查询个人任务和候选任务
     * @param actRuTaskVoMap
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/14 05:09:34
     */
    @RequestMapping(value = "api/activiti/act_ru_task/findActRuTaskVosByCandidateOrAssigned" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findActRuTaskVosByCandidateOrAssigned(@RequestParam Map<String,Object> actRuTaskVoMap);


    /**
     * @Title:
     * @Description:   审批任务
     * @param actRuTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/14 08:49:31
     */
    @RequestMapping(value = "api/activiti/act_ru_task/approvalActRuTask" ,method = RequestMethod.POST)
    ResponseEntity<RestResponse> approvalActRuTask(@RequestBody ActRuTaskVo actRuTaskVo);

    /**
     * @Title:
     * @Description: 测试工作流流程
     * @param: taskId
     * @param: status
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/17  16:15
     */
    @RequestMapping(value = "api/activiti/act_ru_task/approvalTest" ,method = RequestMethod.POST)
    ResponseEntity<RestResponse> approvalTest(@RequestParam("taskId") String taskId, @RequestParam("status") Integer status);

}
