package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author wangxue
 * @ClassName: SysWidgetController
 * @Description: 画面控件管理rpc
 * @date 2018-03-09
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface SysWidgetRpc {

    /**
     * @Title:
     * @Description: 分页查询画面控件管理信息
     * @param sysWidgetVoMap
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 16:31:25
     */
    @RequestMapping(value = "api/system/sys_widget/findSysWidgetsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysWidgetsByPage(@RequestParam Map<String, Object> sysWidgetVoMap);

}
