package cn.com.leadu.fms.activiti.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.activiti.vo.actuserleave.ActUserLeaveVo;
import cn.com.leadu.fms.activiti.service.ActUserLeaveService;
import cn.com.leadu.fms.activiti.validator.actuserleave.vo.*;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author qiaomengnan
 * @ClassName: ActUserLeaveController
 * @Description: 用户请假相关接口
 * @date 2018-03-14
 */
@RestController
@RequestMapping("act_user_leave")
public class ActUserLeaveController {

    /**
     * @Fields  : 用户请假service
     */
    @Autowired
    private ActUserLeaveService actUserLeaveService;

    /**
     * @Title:
     * @Description: 分页查询用户请假信息
     * @param actUserLeaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:51
     */
    @RequestMapping(value = "findActUserLeavesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findActUserLeavesByPage(ActUserLeaveVo actUserLeaveVo,@AuthUserInfo SysUser sysUser){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(actUserLeaveService.findActUserLeavesByPage(actUserLeaveVo,sysUser)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存用户请假
     * @param actUserLeaveSaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:51
     */
    @RequestMapping(value = "saveActUserLeave",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveActUserLeave(@Valid @RequestBody ActUserLeaveSaveVo actUserLeaveSaveVo, @AuthUserInfo SysUser sysUser){
        actUserLeaveService.saveActUserLeave(actUserLeaveSaveVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改用户请假
     * @param actUserLeaveModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:51
     */
    @RequestMapping(value = "modifyActUserLeave",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyActUserLeave(@Valid @RequestBody ActUserLeaveModifyVo actUserLeaveModifyVo){
        actUserLeaveService.modifyActUserLeave(actUserLeaveModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除用户请假
     * @param actUserLeaveDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:51
     */
    @RequestMapping(value = "deleteActUserLeave",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteActUserLeave(@Valid @RequestBody ActUserLeaveDeleteVo actUserLeaveDeleteVo){
        actUserLeaveService.deleteActUserLeave(actUserLeaveDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据leaveId集合删除用户请假
     * @param actUserLeaveDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:51
     */
    @RequestMapping(value = "deleteActUserLeavesByLeaveIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteActUserLeavesByLeaveIds(@Valid @RequestBody ActUserLeaveDeleteListVo actUserLeaveDeleteListVo){
        actUserLeaveService.deleteActUserLeavesByLeaveIds(actUserLeaveDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据leaveId获取用户请假
     * @param leaveId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:51
     */
    @RequestMapping(value = "findActUserLeaveByLeaveId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findActUserLeaveByLeaveId(String leaveId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(actUserLeaveService.findActUserLeaveByLeaveId(leaveId)), HttpStatus.OK);
    }


    /**
     * @Title:
     * @Description:  根据leaveId获取用户请假
     * @param taskId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:51
     */
    @RequestMapping(value = "adopt", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> adopt(String taskId){
        actUserLeaveService.adopt(taskId);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }

}
