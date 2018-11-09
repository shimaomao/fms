package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yangyiquan
 * @ClassName: ContractVehicleRpc
 * @Description: 合同车辆信息rpc
 * @date 2018-05-21
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContractVehicleRpc {

    /**
     * @Description: 查询合同车辆信息
     * @param:contNo
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/14 16:33
     */
    @RequestMapping(value = "api/prebiz/contract_vehicle/findContractVehicleFinanceVoByContNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContractVehicleFinanceVoByContNo(@RequestParam("contNo") String contNo);
}
