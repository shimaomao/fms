package cn.com.leadu.fms.prebiz.controller;/**
 * Created by yyq on 2018/6/30.
 */

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.applymanageapprove.ApplyManageApproveVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.service.ApplyManageApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @program: fms
 * @description: 总经理审批Controller
 * @author: yangyiquan
 * @create: 2018-06-30 16:09
 **/
@RestController
@RequestMapping("apply_manage_approve")
public class ApplyManageApproveController {
    /**
     * @Fields  : 总经理审核service
     */
    @Autowired
    private ApplyManageApproveService applyManageApproveService;

    /** 
    * @Description: 总经理审核通过
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/30 16:17
    */ 
    @RequestMapping(value = "approval",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> approval(@Valid @RequestBody ApplyManageApproveVo applyManageApproveVo, @AuthUserInfo SysUser sysUser){
        applyManageApproveVo.setUser(sysUser.getUser());
        applyManageApproveService.approval(applyManageApproveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /** 
    * @Description: 总经理审核退回
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/30 16:27
    */ 
    @RequestMapping(value = "sendBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBack(@Valid @RequestBody ApplyManageApproveVo applyManageApproveVo, @AuthUserInfo SysUser sysUser){
        applyManageApproveVo.setUser(sysUser.getUser());
        applyManageApproveService.sendBack(applyManageApproveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
    * @Description: 退回风控经理
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/27 12:05
    */
    @RequestMapping(value = "backToDiragree",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> backToDiragree(@Valid @RequestBody ApplyManageApproveVo applyManageApproveVo, @AuthUserInfo SysUser sysUser){
        applyManageApproveVo.setUser(sysUser.getUser());
        applyManageApproveService.backToDiragree(applyManageApproveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
}
