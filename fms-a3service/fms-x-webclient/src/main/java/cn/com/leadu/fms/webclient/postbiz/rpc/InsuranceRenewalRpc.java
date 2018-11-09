package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description:   续保任务测试rpc
 * @author:ningyangyang
 * @since:2018/5/17
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface InsuranceRenewalRpc {

    @RequestMapping(value = "api/insurance/insurance_renewal/insuranceRenewalTask" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> insuranceRenewalTask();
}
