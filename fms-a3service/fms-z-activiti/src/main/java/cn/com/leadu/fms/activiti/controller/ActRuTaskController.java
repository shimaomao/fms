package cn.com.leadu.fms.activiti.controller;

import cn.com.leadu.fms.activiti.service.ActRuTaskService;
import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    private ActRuTaskService actRuTaskService;

    /**
     * @Title:
     * @Description:   查询个人任务和候选任务
     * @param actRuTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/14 05:09:34
     */
    @RequestMapping(value = "findActRuTaskVosByCandidateOrAssigned" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findActRuTaskVosByCandidateOrAssigned(ActRuTaskVo actRuTaskVo
            , @AuthUserInfo SysUser sysUser){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(actRuTaskService.findActRuTaskVosByCandidateOrAssigned(actRuTaskVo,sysUser)),
                HttpStatus.OK);
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
        actRuTaskService.approvalActRuTask(actRuTaskVo);
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据业务key集合查询任务
     * @param businessKeys
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 03:57:20
     */
    @RequestMapping(value = "findActRuTasksByBusinessKeys" ,method = RequestMethod.POST)
    public ResponseEntity<RestResponse> findActRuTasksByBusinessKeys(@RequestBody List<String> businessKeys){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(
                        actRuTaskService.findActRuTasksByBusinessKeys(businessKeys)
                ),
                HttpStatus.OK);
    }

}
