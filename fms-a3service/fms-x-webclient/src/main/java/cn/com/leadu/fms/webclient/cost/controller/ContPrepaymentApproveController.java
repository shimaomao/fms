package cn.com.leadu.fms.webclient.cost.controller;/**
 * Created by yyq on 2018/5/16.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.contprepaymentApprove.ContPrepaymentApproveVo;
import cn.com.leadu.fms.webclient.cost.rpc.ContPrepaymentApproveRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: fms
 * @description: 提前还款审批controller
 * @author: yangyiquan
 * @create: 2018-05-16 14:46
 **/
@RestController
@RequestMapping("cont_prepayment_approve")
public class ContPrepaymentApproveController {
    /**
     * @Field: 提前还款审批rpc
     */
    @Autowired
    private ContPrepaymentApproveRpc contPrepaymentApproveRpc;

    /** 
    * @Description:  提前还款审批通过
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/16 14:55
    */ 
    @RequestMapping(value = "approval",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> approval(@RequestBody ContPrepaymentApproveVo contPrepaymentApproveVo){
        return contPrepaymentApproveRpc.approval(contPrepaymentApproveVo);
    }

    /** 
    * @Description:  提前还款审批退回
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/16 14:55
    */ 
    @RequestMapping(value = "sendBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBack(@RequestBody ContPrepaymentApproveVo contPrepaymentApproveVo){
        return contPrepaymentApproveRpc.sendBack(contPrepaymentApproveVo);
    }

    /** 
    * @Description: 财务确认
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/20 14:54
    */ 
    @RequestMapping(value = "receiptConfirm",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> receiptConfirm(@RequestBody ContPrepaymentApproveVo contPrepaymentApproveVo){
        return contPrepaymentApproveRpc.receiptConfirm(contPrepaymentApproveVo);
    }

    /**
     * @Description: 根据业务code和业务类型 获取财务付款信息
     * @param: bizCode
     * @param: paymentType
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/16 15:17
     */
    @RequestMapping(value = "findContPayByBizCode", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContPayByBizCode(String bizCode, String paymentType) {
        return contPrepaymentApproveRpc.findContPayByBizCode(bizCode, paymentType);
    }
}
