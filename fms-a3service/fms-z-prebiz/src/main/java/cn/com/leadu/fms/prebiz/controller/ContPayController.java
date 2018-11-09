package cn.com.leadu.fms.prebiz.controller;/**
 * Created by yyq on 2018/5/30.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.prebiz.service.ContPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: fms
 * @description: 财务付款表Controller
 * @author: yangyiquan
 * @create: 2018-05-30 21:30
 **/
@RestController
@RequestMapping("contpay")
public class ContPayController {
    /**
     * @Fields  : 财务付款表业务层Service
     */
    @Autowired
    private ContPayService contPayService;

    /** 
    * @Description: 根据业务编号和业务类型查询付款表
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/30 21:33
    */ 
    @RequestMapping(value="findContPayByBizCodeAndPaymentType",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContPayByBizCodeAndPaymentType(String paymentType,String bizCode){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contPayService.findContPayByBizCodeAndPaymentType(paymentType,bizCode)), HttpStatus.OK);
    }
}
