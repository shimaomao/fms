package cn.com.leadu.fms.business.rpc.system;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.entity.SysParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: SysParamRpc
 * @Description: 系统常量rpc
 * @date 2018/6/20
 */
@FeignClient(name = "${fms.feigns.serverNames.fmsSystem}")
public interface SysParamRpc {

    /**
     * @Title:
     * @Description:   初始化系统常量值
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 09:19:43
     */
    @RequestMapping(value = "sys_param/initSysParamsValue", method = RequestMethod.GET)
    ResponseEntity<RestResponse<Map<String,Object>>> initSysParamsValue();

}
