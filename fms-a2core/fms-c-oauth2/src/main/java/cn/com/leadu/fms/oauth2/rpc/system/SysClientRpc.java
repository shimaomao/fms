package cn.com.leadu.fms.oauth2.rpc.system;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: SysClientRpc
 * @Description: 远程调用系统客户端标识相关接口
 * @date 2018/3/6
 */
@FeignClient("${fms.feigns.serverNames.fmsSystem}")
public interface SysClientRpc {

    /**
     * @Title:
     * @Description:   通过clientId获取客户端标识对象
     * @param clientId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/06 08:56:58
     */
    @RequestMapping(value = "sys_client/findSysClientByClientId" , method = RequestMethod.GET)
    ResponseEntity<RestResponse<Map<String,Object>>> findSysClientByClientId(@RequestParam("clientId") String clientId);

}
