package cn.com.leadu.fms.webclient.prebiz.controller;/**
 * Created by yyq on 2018/5/31.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.webclient.prebiz.rpc.ContPayRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: fms
 * @description:财务付款表Controller
 * @author: yangyiquan
 * @create: 2018-05-31 10:21
 **/
@RestController
@RequestMapping("contpay")
public class ContPayController {

    /**
     * @Fields  : 财务付款表rpc
     */
    @Autowired
    private ContPayRpc contPayRpc;

    /** 
    * @Description: 根据业务编号和业务类型查询付款表
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/31 10:24
    */ 
    @RequestMapping(value = "findContPayByBizCodeAndPaymentType", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContPayByBizCodeAndPaymentType(String paymentType,String bizCode){
        return contPayRpc.findContPayByBizCodeAndPaymentType(paymentType,bizCode);
    }
}
