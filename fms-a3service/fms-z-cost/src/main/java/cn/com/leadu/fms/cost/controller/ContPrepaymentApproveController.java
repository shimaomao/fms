package cn.com.leadu.fms.cost.controller;/**
 * Created by yyq on 2018/5/16.
 */

import cn.com.leadu.fms.cost.service.ContPrepaymentApproveService;
import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.cost.vo.contprepaymentApprove.ContPrepaymentApproveVo;
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
 * @description: 提前还款审批controller
 * @author: yangyiquan
 * @create: 2018-05-16 15:00
 **/
@RestController
@RequestMapping("cont_prepayment_approve")
public class ContPrepaymentApproveController {
    /**
     * @Field: 提前还款审批service
     */
    @Autowired
    private ContPrepaymentApproveService contPrepaymentApproveService;

    /** 
    * @Description: 提前还款审批通过
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/16 15:09
    */ 
    @RequestMapping(value = "approval",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> approval(@Valid @RequestBody ContPrepaymentApproveVo contPrepaymentApproveVo, @AuthUserInfo SysUser sysUser){
        contPrepaymentApproveVo.setUser(sysUser.getUser());
        contPrepaymentApproveService.approval(contPrepaymentApproveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /** 
    * @Description:  提前还款审批退回
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/16 15:16
    */ 
    @RequestMapping(value = "sendBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBack(@Valid @RequestBody ContPrepaymentApproveVo contPrepaymentApproveVo, @AuthUserInfo SysUser sysUser){
        contPrepaymentApproveVo.setUser(sysUser.getUser());
        contPrepaymentApproveService.sendBack(contPrepaymentApproveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /** 
    * @Description: 财务确认
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/20 14:56
    */ 
    @RequestMapping(value = "receiptConfirm",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> receiptConfirm(@Valid @RequestBody ContPrepaymentApproveVo contPrepaymentApproveVo, @AuthUserInfo SysUser sysUser){
        contPrepaymentApproveVo.setUser(sysUser.getUser());
        contPrepaymentApproveService.receiptConfirm(contPrepaymentApproveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Description: 根据业务code和业务类型 获取财务付款信息
     * @param: bizCode
     * @param: paymentType
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/16 15:17
     */
    @RequestMapping(value = "findContPayByBizCode" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContPayByBizCode(String bizCode, String paymentType){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contPrepaymentApproveService.findContPayByBizCode(bizCode, paymentType)),
                HttpStatus.OK);
    }
}
