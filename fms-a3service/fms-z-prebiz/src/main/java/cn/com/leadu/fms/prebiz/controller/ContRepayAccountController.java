package cn.com.leadu.fms.prebiz.controller;/**
 * Created by yyq on 2018/5/8.
 */

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.contrepayaccount.ContRepayAccountListVo;
import cn.com.leadu.fms.prebiz.service.ContRepayAccountService;
import cn.com.leadu.fms.prebiz.validator.contrepayaccount.vo.ContRepayAccountModifyVo;
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
 * @description: 融资合同还款信息controller
 * @author: yangyiquan
 * @create: 2018-05-08 18:11
 **/
@RestController
@RequestMapping("contRepayAccount")
public class ContRepayAccountController {

    /**
     * @Fields  : 融资合同还款信息service
     */
    @Autowired
    private ContRepayAccountService contRepayAccountService;

    /** 
    * @Description:  分页查询客户信息一览
    * @param:
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/8 18:30
    */
    @RequestMapping(value = "findContRepayAccountListByPage",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepayAccountListByPage(ContRepayAccountListVo contRepayAccountListVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contRepayAccountService.findContRepayAccountListByPage(contRepayAccountListVo)),
                HttpStatus.OK
        );
    }

    /** 
    * @Description: 根据合同号取得融资合同还款信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/9 16:55
    */ 
    @RequestMapping(value = "findContRepayAccountByContNo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepayAccountByContNo(String contNo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contRepayAccountService.findContRepayAccountByContNo(contNo)),
                HttpStatus.OK
        );
    }

    /** 
    * @Description: 动态修改客户还款信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/9 18:16
    */ 
    @RequestMapping(value = "modifyContRepayAccount",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyContRepayAccount(@Valid @RequestBody ContRepayAccountModifyVo contRepayAccountModifyVo){
        contRepayAccountService.modifyContRepayAccount(contRepayAccountModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()),HttpStatus.OK);
    }

}
