package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yangyiquan
 * @ClassName: ContPayRpc
 * @Description: 财务付款表rpc
 * @date 2018-03-26
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContPayRpc {

    /** 
    * @Description: 根据业务编号和业务类型查询付款表
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/31 10:22
    */ 
    @RequestMapping(value = "api/prebiz/contpay/findContPayByBizCodeAndPaymentType", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContPayByBizCodeAndPaymentType(@RequestParam("paymentType") String paymentType,@RequestParam("bizCode")String bizCode);
}
