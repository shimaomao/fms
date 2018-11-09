package cn.com.leadu.fms.prebiz.controller;/**
 * Created by yyq on 2018/6/13.
 */

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.contReceiptPay.ContReceiptPayVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contrequestpay.ContRequestPayVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.service.ContReceiptPayService;
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
 * @description: 合同待收款controller
 * @author: yangyiquan
 * @create: 2018-06-13 14:29
 **/
@RestController
@RequestMapping("cont_receipt_pay")
public class ContReceiptPayController {

    /**
     * @Fields  : 合同请款收款相关service
     */
    @Autowired
    private ContReceiptPayService contReceiptPayService;

    /** 
    * @Description: 根据合同编号查询合同待付款信息 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/13 14:33
    */ 
    @RequestMapping(value = "findContReceiptPayVoByContNo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContReceiptPayVoByContNo(String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contReceiptPayService.findContReceiptPayVoByContNo(contNo)), HttpStatus.OK);
    }

    /** 
    * @Description: 暂存财务确认收款（没有暂存了）
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/13 14:42
    */ 
    @RequestMapping(value = "saveContCharge",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContCharge(@Valid @RequestBody ContReceiptPayVo contReceiptPayVo){
        contReceiptPayService.saveContCharge(contReceiptPayVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Description: 提交财务确认收款
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/13 14:42
     */
    @RequestMapping(value = "submitContCharge",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> submitContCharge(@Valid @RequestBody ContReceiptPayVo contReceiptPayVo,@AuthUserInfo SysUser sysUser){
        contReceiptPayVo.setUser(sysUser.getUser());
        contReceiptPayService.submitContCharge(contReceiptPayVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Description: 退回财务确认收款
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/13 14:42
     */
    @RequestMapping(value = "backContCharge",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> backContCharge(@Valid @RequestBody ContReceiptPayVo contReceiptPayVo,@AuthUserInfo SysUser sysUser){
        contReceiptPayVo.setUser(sysUser.getUser());
        contReceiptPayService.backContCharge(contReceiptPayVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /** 
    * @Description:  根据合同号查询合同请款信息,包括付款信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/15 15:47
    */ 
    @RequestMapping(value = "findContRequestPayWithContPayByContNo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRequestPayWithContPayByContNo(String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contReceiptPayService.findContRequestPayWithContPayByContNo(contNo)), HttpStatus.OK);
    }
    
    /** 
    * @Description: 打印
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/19 11:39
    */ 
    @RequestMapping(value = "printContMakeVoucher",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> printContMakeVoucher(String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contReceiptPayService.printContMakeVoucher(contNo)), HttpStatus.OK);
    }

    /** 
    * @Description: 暂存
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/19 16:44
    */ 
    @RequestMapping(value = "saveContMakeVoucher",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContMakeVoucher(@Valid @RequestBody ContRequestPayVo contRequestPayVo, @AuthUserInfo SysUser sysUser){
        contRequestPayVo.setUser(sysUser.getUser());
        contReceiptPayService.saveMakeVoucherCommon(contRequestPayVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /** 
    * @Description: 贷前合同财务制单
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/14 17:49
    */ 
    @RequestMapping(value = "submitContMakeVoucher",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> submitContMakeVoucher(@Valid @RequestBody ContRequestPayVo contRequestPayVo, @AuthUserInfo SysUser sysUser){
        contRequestPayVo.setUser(sysUser.getUser());
        contReceiptPayService.submitContMakeVoucher(contRequestPayVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Description: 财务付款确认
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/15 14:42
     */
    @RequestMapping(value = "submitContPayment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> submitContPayment(@Valid @RequestBody ContRequestPayVo contRequestPayVo,@AuthUserInfo SysUser sysUser){
        contRequestPayVo.setUser(sysUser.getUser());
        contReceiptPayService.submitContPayment(contRequestPayVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Description: 财务付款退回
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/15 14:42
     */
    @RequestMapping(value = "backContPayment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> backContPayment(@Valid @RequestBody ContRequestPayVo contRequestPayVo,@AuthUserInfo SysUser sysUser){
        contRequestPayVo.setUser(sysUser.getUser());
        contReceiptPayService.backContPayment(contRequestPayVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }


}
