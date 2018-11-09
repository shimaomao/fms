package cn.com.leadu.fms.oauth2.rpc.system;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: SysUserRpc
 * @Description: 系统用户远程Rpc调用
 * @date 2018/3/6
 */
@FeignClient("${fms.feigns.serverNames.fmsSystem}")
public interface SysUserRpc {

    /**
     * @Title:
     * @Description:  根据username获取用户
     * @param username
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:47:25
     */
    @RequestMapping(value = "sys_user/findSysUserVoByUsername", method = RequestMethod.GET)
    ResponseEntity<RestResponse<Map<String,Object>>> findSysUserByUsername(@RequestParam("username") String username);

    /**
     * @Title:
     * @Description:  更新用户最后登录时间
     * @param user
     * @return
     * @throws
     * @author wangxue
     * @date 2018/04/4 13:46:05
     */
    @RequestMapping(value = "sys_user/modifyLastLoginTime", method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyLastLoginTime(@RequestBody String user);

}
