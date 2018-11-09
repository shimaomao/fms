package cn.com.leadu.fms.riskmgmt.rpc.thirdinterface;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author yanggang
 * @ClassName: PyInterfaceRpc
 * @Description: 调用接口
 * @date 2018-6-13 9:18:12
 */
@FeignClient("${fms.feigns.serverNames.fmsThirdInterface}")
public interface PyInterfaceRpc {

    /**
     * @Title:
     * @Description: 调用接口
     * @param obj 接口所需要的实体类
     * @return String
     * @throws
     * @author yanggang
     * @date 2018-6-13 9:18:12
     */
    @RequestMapping(value = "py_interface/requestUnzipApi", method = RequestMethod.POST)
    ResponseEntity<RestResponse<Map<String,String>>> requestUnzipApi(@RequestBody Object obj);
}
