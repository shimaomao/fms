package cn.com.leadu.fms.prebiz.rpc.system;/**
 * Created by ningyangyang on 2018/7/6.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Title: fms
 * @Description: 用户Rpc
 * @author: ningyangyang
 * @date 2018/7/6 17:20
 */
@FeignClient("${fms.feigns.serverNames.fmsSystem}")
public interface SysUserRpc {
    /**
     * @Title:
     * @Description:  根据代码获取用户信息
     * @param userName
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-6 16:18:12
     */
    @RequestMapping(value = "sys_user/findSysUserByUsername", method = RequestMethod.GET)
    ResponseEntity<RestResponse<SysUser>> findSysUserByUsername(@RequestParam("username") String username);

}
