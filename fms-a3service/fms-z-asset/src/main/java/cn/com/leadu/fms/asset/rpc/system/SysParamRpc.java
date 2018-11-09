package cn.com.leadu.fms.asset.rpc.system;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author qiaomengnan
 * @ClassName: SysParamRpc
 * @Description: 系统常量rpc
 * @date 2018/6/4
 */
@FeignClient("${fms.feigns.serverNames.fmsSystem}")
public interface SysParamRpc {

    /**
     * @Title:
     * @Description:  根据paramKey获取系统常量值
     * @param paramKey
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @RequestMapping(value = "sys_param/findParamValueByParamKey", method = RequestMethod.GET)
    ResponseEntity<RestResponse<String>> findSysParamByParamKey(@RequestParam("paramKey") String paramKey);

}
