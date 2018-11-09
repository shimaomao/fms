package cn.com.leadu.fms.webclient.activiti.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.webclient.activiti.rpc.ActRuTaskRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: ActRuTaskController
 * @Description: 工作流任务相关接口
 * @date 2018/3/14
 */
@RestController
@RequestMapping("act_ru_task")
public class ActRuTaskController {

    @Autowired
    private ActRuTaskRpc actRuTaskRpc;

    /**
     * @Title:
     * @Description:   查询个人任务和候选任务
     * @param actRuTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/14 05:09:34
     */
    @RequestMapping(value = "findActRuTaskVosByCandidateOrAssigned" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findActRuTaskVosByCandidateOrAssigned(ActRuTaskVo actRuTaskVo){
        Map actRuTaskVoMap = actRuTaskVo == null?null:(Map) JSON.toJSON(actRuTaskVo);
        return actRuTaskRpc.findActRuTaskVosByCandidateOrAssigned(actRuTaskVoMap);
    }

    /**
     * @Title:
     * @Description:   审批任务
     * @param actRuTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/14 08:49:31
     */
    @RequestMapping(value = "approvalActRuTask" ,method = RequestMethod.POST)
    public ResponseEntity<RestResponse> approvalActRuTask(@RequestBody ActRuTaskVo actRuTaskVo){
        return actRuTaskRpc.approvalActRuTask(actRuTaskVo);
    }

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
    @RequestMapping(value = "approvalTest" ,method = RequestMethod.POST)
    public ResponseEntity<RestResponse> approvalTest(String taskId,Integer status){
        return actRuTaskRpc.approvalTest(taskId,status);
    }

}
