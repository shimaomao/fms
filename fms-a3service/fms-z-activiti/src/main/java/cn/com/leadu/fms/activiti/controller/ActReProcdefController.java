package cn.com.leadu.fms.activiti.controller;

import cn.com.leadu.fms.activiti.service.ActReProcdefService;
import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.activiti.vo.actreprocdef.ActReProcdefVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiaomengnan
 * @ClassName: ActReProcdefController
 * @Description:  流程定义接口
 * @date 2018/3/13
 */
@RestController
@RequestMapping("act_re_procdef")
public class ActReProcdefController {


    @Autowired
    private ActReProcdefService actReProcdefService;

    /**
     * @Title:
     * @Description:   分页查询流程定义vos
     * @param actReProcdefVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/13 05:00:50
     */
    @RequestMapping(value = "findActReProcdefVosByPage" , method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findActReProcdefVosByPage(ActReProcdefVo actReProcdefVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(actReProcdefService.findActReProcdefVosByPage(actReProcdefVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据当前用户名和所在组，查询其所拥有的工作流类型
     * @param sysUser
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 03:18:12
     */
    @RequestMapping(value = "findActReProcdefVosByUserOrGroup" , method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findActReProcdefVosByUserOrGroup(@AuthUserInfo SysUser sysUser){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(actReProcdefService.findActReProcdefVosByUserOrGroup(sysUser)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据当前用户名和所在组，查询其所拥有的工作流类型，并得到树形
     * @param sysUser
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/12 11:15:14
     */
    @RequestMapping(value = "findProcdefTree" , method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findProcdefTree(@AuthUserInfo SysUser sysUser){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(actReProcdefService.findProcdefTree(sysUser)),
                HttpStatus.OK);
    }

}
