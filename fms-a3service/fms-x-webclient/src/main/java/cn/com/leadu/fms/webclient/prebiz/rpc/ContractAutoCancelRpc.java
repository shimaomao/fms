package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yanfengbo
 * @ClassName: ContractAutoCancelRpc
 * @Description: 未生成合同自动取消
 * @date
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContractAutoCancelRpc {
    @RequestMapping(value = "api/prebiz/contract_auto_cancel/contractAutoCancel" , method = RequestMethod.GET)
    ResponseEntity<RestResponse> contractAutoCancel();
}
