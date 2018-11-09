package cn.com.leadu.fms.schedule.rpc.prebiz;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yanfengbo
 * @ClassName: ContractAutoCancelRpc
 * @Description: 未生效合同自动取消
 * @date
 */
@FeignClient("${fms.feigns.serverNames.fmsPreBiz}")
public interface ContractAutoCancelRpc {
    /**
     * @Title:
     * @Description: 未生效合同自动取消
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "contract_auto_cancel/contractAutoCancel",method = RequestMethod.GET)
    ResponseEntity<RestResponse> contractAutoCancel();
}
