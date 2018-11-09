package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author wubaoliang
 * @ClassName: SysTplItemController
 * @Description: 模板可设项目管理rpc
 * @date 2018-03-12
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface SysTplItemRpc {

    /**
     * @Title:
     * @Description:  根据tplTypeKey获取模板可设项目信息
     * @param tplTypeKey
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:53:25
     */
    @RequestMapping(value = "api/system/sys_tpl_item/findSysTplItemsByTplTypeKey", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysTplItemsByTplTypeKey(@RequestParam("tplTypeKey") String tplTypeKey);

}
