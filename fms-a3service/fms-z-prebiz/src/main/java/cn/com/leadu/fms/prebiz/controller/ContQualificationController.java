package cn.com.leadu.fms.prebiz.controller;/**
 * Created by yyq on 2018/5/24.
 */

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.contQualification.ContQualificationVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.service.ContQualificationService;
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
 * @description:合同资管审批controller
 * @author: yangyiquan
 * @create: 2018-05-24 16:09
 **/
@RestController
@RequestMapping("cont_qualification")
public class ContQualificationController {

    /**
     * @Fields  : 合同资管审批核查service
     */
    @Autowired
    private ContQualificationService contQualificationService;

    /** 
    * @Description: 合同资管审批通过
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/24 16:10
    */ 
    @RequestMapping(value = "approve",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> approve(@Valid @RequestBody ContQualificationVo contQualificationVo, @AuthUserInfo SysUser sysUser){
        contQualificationVo.setUser(sysUser.getUser());
        contQualificationService.approve(contQualificationVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /** 
    * @Description: 合同资管审批退回
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/24 16:21
    */ 
    @RequestMapping(value = "sendBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBack(@Valid @RequestBody ContQualificationVo contQualificationVo, @AuthUserInfo SysUser sysUser){
        contQualificationVo.setUser(sysUser.getUser());
        contQualificationService.sendBack(contQualificationVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
}
