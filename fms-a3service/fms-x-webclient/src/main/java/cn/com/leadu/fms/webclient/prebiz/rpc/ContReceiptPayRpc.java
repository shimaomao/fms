package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.contReceiptPay.ContReceiptPayVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contrequestpay.ContRequestPayVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yangyiquan
 * @ClassName: ContReceiptPayRpc
 * @Description: rpc
 * @date 2018-06-13
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContReceiptPayRpc {
    /** 
    * @Description: 根据合同编号查询合同待付款信息 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/13 15:14
    */ 
    @RequestMapping(value = "api/prebiz/cont_receipt_pay/findContReceiptPayVoByContNo",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContReceiptPayVoByContNo(@RequestParam("contNo")String contNo);

    /** 
    * @Description: 暂存财务确认收款 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/13 15:19
    */ 
    @RequestMapping(value = "api/prebiz/cont_receipt_pay/saveContCharge",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveContCharge(@RequestBody ContReceiptPayVo contReceiptPayVo);

    /**
     * @Description: 提交财务确认收款
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/13 15:19
     */
    @RequestMapping(value = "api/prebiz/cont_receipt_pay/submitContCharge",method = RequestMethod.POST)
    ResponseEntity<RestResponse> submitContCharge(@RequestBody ContReceiptPayVo contReceiptPayVo);

    /**
     * @Description: 退回财务确认收款
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/13 15:19
     */
    @RequestMapping(value = "api/prebiz/cont_receipt_pay/backContCharge",method = RequestMethod.POST)
    ResponseEntity<RestResponse> backContCharge(@RequestBody ContReceiptPayVo contReceiptPayVo);

    /** 
    * @Description: 根据合同号查询合同请款信息,包括付款信息 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/15 17:00
    */ 
    @RequestMapping(value = "api/prebiz/cont_receipt_pay/findContRequestPayWithContPayByContNo",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContRequestPayWithContPayByContNo(@RequestParam("contNo")String contNo);
    
    /** 
    * @Description:  打印
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/19 11:38
    */ 
    @RequestMapping(value = "api/prebiz/cont_receipt_pay/printContMakeVoucher",method = RequestMethod.GET)
    ResponseEntity<RestResponse> printContMakeVoucher(@RequestParam("contNo")String contNo);

    /** 
    * @Description: 暂存 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/19 16:42
    */ 
    @RequestMapping(value = "api/prebiz/cont_receipt_pay/saveContMakeVoucher",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveContMakeVoucher(@RequestBody ContRequestPayVo contRequestPayVo);

    /** 
    * @Description: 贷前合同财务制单 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/14 18:40
    */
    @RequestMapping(value = "api/prebiz/cont_receipt_pay/submitContMakeVoucher",method = RequestMethod.POST)
    ResponseEntity<RestResponse> submitContMakeVoucher(@RequestBody ContRequestPayVo contRequestPayVo);

    /** 
    * @Description: 财务付款确认 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/15 17:01
    */ 
    @RequestMapping(value = "api/prebiz/cont_receipt_pay/submitContPayment",method = RequestMethod.POST)
    ResponseEntity<RestResponse> submitContPayment(@RequestBody ContRequestPayVo contRequestPayVo);

    /** 
    * @Description: 财务付款退回
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/15 17:01
    */ 
    @RequestMapping(value = "api/prebiz/cont_receipt_pay/backContPayment",method = RequestMethod.POST)
    ResponseEntity<RestResponse> backContPayment(@RequestBody ContRequestPayVo contRequestPayVo);


}
