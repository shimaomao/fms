package cn.com.leadu.fms.activiti.controller;

import cn.com.leadu.fms.activiti.service.ActReDeploymentService;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.activiti.vo.actredeployment.ActReDeploymentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiaomengnan
 * @ClassName: ActReDeploymentController
 * @Description: 流程文件部署信息相关接口
 * @date 2018/3/13
 */
@RestController
@RequestMapping("act_re_deployment")
public class ActReDeploymentController {

    @Autowired
    private ActReDeploymentService actReDeploymentService;

    /**
     * @Title:
     * @Description:   分页查询流程文件信息
     * @param actReDeploymentVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/13 03:28:35
     */
    @RequestMapping(value = "findActReDeploymentsByPage" , method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findActReDeploymentsByPage(ActReDeploymentVo actReDeploymentVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(actReDeploymentService.findActReDeploymentsByPage(actReDeploymentVo)),
                HttpStatus.OK);
    }


}
