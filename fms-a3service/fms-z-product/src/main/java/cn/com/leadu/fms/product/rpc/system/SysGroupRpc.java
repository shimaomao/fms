package cn.com.leadu.fms.product.rpc.system;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author wangxue
 * @ClassName: SysGroupController
 * @Description: 用户组管理rpc
 * @date 2018-03-10
 */
@FeignClient("${fms.feigns.serverNames.fmsSystem}")
public interface SysGroupRpc {

    /**
     * @Title:
     * @Description: 根据groupCode获取该用户的全部下级用户组代码
     * @param groupCode
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @RequestMapping(value = "sys_group/findSysGroupCodeListByGroupCode" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse<List<String>>> findSysGroupCodeListByGroupCode(@RequestParam("groupCode") String groupCode);
}
