package cn.com.leadu.fms.postbiz.rpc.system;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ningyangyang
 * @ClassName: ProductController
 * @Description: 系统常量rpc
 * @date 2018-03-23
 */
@FeignClient("${fms.feigns.serverNames.fmsSystem}")
public interface SysParamRpc {

    /**
     * @Title:
     * @Description:  根据常量key取得值
     * @param paramKey
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 16:18:12
     */
    @RequestMapping(value = "sys_param/findParamValueByParamKey", method = RequestMethod.GET)
    ResponseEntity<RestResponse<String>> findParamValueByParamKey(@RequestParam("paramKey") String paramKey);
}
