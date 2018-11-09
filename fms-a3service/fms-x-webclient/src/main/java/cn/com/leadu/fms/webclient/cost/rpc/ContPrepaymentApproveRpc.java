package cn.com.leadu.fms.webclient.cost.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.contprepaymentApprove.ContPrepaymentApproveVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yangyiquan
 * @ClassName: ContPrepayDetailController
 * @Description: 提前还款审批rpc
 * @date 2018-05-16
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContPrepaymentApproveRpc {

    /** 
    * @Description: 提前还款审批通过
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/16 14:51
    */ 
    @RequestMapping(value = "api/cost/cont_prepayment_approve/approval",method = RequestMethod.POST)
    ResponseEntity<RestResponse> approval(@RequestBody ContPrepaymentApproveVo contPrepaymentApproveVo);

    /** 
    * @Description:  提前还款审批退回
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/16 14:52
    */ 
    @RequestMapping(value = "api/cost/cont_prepayment_approve/sendBack",method = RequestMethod.POST)
    ResponseEntity<RestResponse> sendBack(@RequestBody ContPrepaymentApproveVo contPrepaymentApproveVo);

    /** 
    * @Description: 财务确认 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/20 14:55
    */ 
    @RequestMapping(value = "api/cost/cont_prepayment_approve/receiptConfirm",method = RequestMethod.POST)
    ResponseEntity<RestResponse> receiptConfirm(@RequestBody ContPrepaymentApproveVo contPrepaymentApproveVo);

    /**
     * @Description: 根据业务code和业务类型 获取财务付款信息
     * @param: bizCode
     * @param: paymentType
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/16 15:17
     */
    @RequestMapping(value = "api/cost/cont_prepayment_approve/findContPayByBizCode", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContPayByBizCode(@RequestParam("bizCode") String bizCode,
                                                            @RequestParam("paymentType") String paymentType);
}
