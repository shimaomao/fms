package cn.com.leadu.fms.schedule.rpc.cost;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description: 提前还款自动作废
 * @author:yangyiquan
 * @since:2018/10/24
 */
@FeignClient("${fms.feigns.serverNames.fmsCost}")
public interface AutoCancelPrepaymentRpc {

    /**
    * @Description: 提前还款自动作废
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/24 16:12
    */
    @RequestMapping(value = "prepayment_auto_job/autoCancelPrepayment" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> autoCancelPrepayment();
}