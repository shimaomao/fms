package cn.com.leadu.fms.schedule.rpc.insurance;/**
 * Created by ningyangyang on 2018/6/19.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Title: fms
 * @Description: 续保任务生成
 * @author: ningyangyang
 * @date 2018/6/19 17:28
 */
@FeignClient("${fms.feigns.serverNames.fmsInsurance}")
public interface InsuranceRenewalRpc {

    /**
     * @Title:
     * @Description: 续保任务生成
     * @param
     * @return void
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 11:52:38
     */
    @RequestMapping(value = "insurance_renewal/insuranceRenewalTask" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> insuranceRenewalTask();
}
