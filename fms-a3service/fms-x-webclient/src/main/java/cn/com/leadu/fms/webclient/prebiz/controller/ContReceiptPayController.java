package cn.com.leadu.fms.webclient.prebiz.controller;/**
 * Created by yyq on 2018/6/13.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.contReceiptPay.ContReceiptPayVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contrequestpay.ContRequestPayVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.ContReceiptPayRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: fms
 * @description: 合同待收款controller
 * @author: yangyiquan
 * @create: 2018-06-13 15:21
 **/
@RestController
@RequestMapping("cont_receipt_pay")
public class ContReceiptPayController {
    /**
     * @Fields  : 合同待收款rpc
     */
    @Autowired
    private ContReceiptPayRpc contReceiptPayRpc;

    /** 
    * @Description: 根据合同编号查询合同待付款信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/13 15:28
    */ 
    @RequestMapping(value = "findContReceiptPayVoByContNo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContReceiptPayVoByContNo(String contNo){
        return contReceiptPayRpc.findContReceiptPayVoByContNo(contNo);
    }

    /** 
    * @Description: 暂存财务确认收款
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/13 15:29
    */ 
    @RequestMapping(value = "saveContCharge",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContCharge(@RequestBody ContReceiptPayVo contReceiptPayVo){
        return contReceiptPayRpc.saveContCharge(contReceiptPayVo);
    }

    /**
     * @Description: 提交财务确认收款
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/13 15:29
     */
    @RequestMapping(value = "submitContCharge",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> submitContCharge(@RequestBody ContReceiptPayVo contReceiptPayVo){
        return contReceiptPayRpc.submitContCharge(contReceiptPayVo);
    }

    /**
     * @Description: 退回财务确认收款
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/13 15:29
     */
    @RequestMapping(value = "backContCharge",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> backContCharge(@RequestBody ContReceiptPayVo contReceiptPayVo){
        return contReceiptPayRpc.backContCharge(contReceiptPayVo);
    }

    /** 
    * @Description: 根据合同号查询合同请款信息,包括付款信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/15 16:58
    */ 
    @RequestMapping(value = "findContRequestPayWithContPayByContNo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRequestPayWithContPayByContNo(String contNo){
        return contReceiptPayRpc.findContRequestPayWithContPayByContNo(contNo);
    }

    /** 
    * @Description: 打印
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/19 11:38
    */ 
    @RequestMapping(value = "printContMakeVoucher",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> printContMakeVoucher(String contNo){
        return contReceiptPayRpc.printContMakeVoucher(contNo);
    }

    /** 
    * @Description: 暂存
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/19 16:42
    */ 
    @RequestMapping(value = "saveContMakeVoucher",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContMakeVoucher(@RequestBody ContRequestPayVo contRequestPayVo){
        return contReceiptPayRpc.saveContMakeVoucher(contRequestPayVo);
    }

    /**
    * @Description: 贷前合同财务制单
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/14 18:39
    */ 
    @RequestMapping(value = "submitContMakeVoucher",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> submitContMakeVoucher(@RequestBody ContRequestPayVo contRequestPayVo){
        return contReceiptPayRpc.submitContMakeVoucher(contRequestPayVo);
    }

    /** 
    * @Description: 财务付款确认
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/15 17:02
    */ 
    @RequestMapping(value = "submitContPayment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> submitContPayment(@RequestBody ContRequestPayVo contRequestPayVo){
        return contReceiptPayRpc.submitContPayment(contRequestPayVo);
    }

    /** 
    * @Description: 财务付款退回 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/15 16:59
    */ 
    @RequestMapping(value = "backContPayment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> backContPayment(@RequestBody ContRequestPayVo contRequestPayVo){
        return contReceiptPayRpc.backContPayment(contRequestPayVo);
    }
}
