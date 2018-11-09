package cn.com.leadu.fms.cost.controller;

import cn.com.leadu.fms.cost.service.ContPrepaymentAutoJobService;
import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.cost.vo.contprepayment.ContPrepaymentVo;
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
 * @program: fms
 * @description: 提前还款自动任务
 * @author: yangyiquan
 * @create: 2018-10-24 16:32
 **/
@RestController
@RequestMapping("prepayment_auto_job")
public class ContPrepaymentAutoJobController {

    /**
     * @Fields  : 提前还款自动任务service
     */
    @Autowired
    private ContPrepaymentAutoJobService contPrepaymentAutoJobService;

    /**
     * @Title:
     * @Description: 自动结清
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-9 11:52:38
     */
    @RequestMapping(value = "autoCancelPrepayment",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> autoCancelPrepayment(){
        contPrepaymentAutoJobService.autoCancelPrepayment();
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
    * @Description: 提前还款手动作废
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/30 17:56
    */
    @RequestMapping(value = "manualCancelPrepayment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> manualCancelPrepayment(@Valid @RequestBody ContPrepaymentVo contPrepaymentVo, @AuthUserInfo SysUser sysUser){
        contPrepaymentVo.setUser(sysUser.getUser());
        contPrepaymentAutoJobService.manualCancelPrepayment(contPrepaymentVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
}