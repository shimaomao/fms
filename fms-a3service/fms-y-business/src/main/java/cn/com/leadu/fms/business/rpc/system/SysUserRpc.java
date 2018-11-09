package cn.com.leadu.fms.business.rpc.system;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysUserRpc
 * @Description: 用户信息远程rpc
 * @date 2018/4/8
 */
@FeignClient(name = "${fms.feigns.serverNames.fmsSystem}")
public interface SysUserRpc {

    /**
     * @Title:
     * @Description:   根据组织机构code查询用户列表
     * @param groupCode
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/14 05:55:47
     */
    @RequestMapping(value = "sys_user/findSysUserLoginNamesByGroupCode", method = RequestMethod.GET)
    ResponseEntity<RestResponse<List<String>>> findSysUserLoginNamesByGroupCode(@RequestParam("groupCode") String groupCode);

    /**
     * @Title:
     * @Description:   根据组织机构code集合查询用户列表
     * @param groupCodes
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/14 05:55:47
     */
    @RequestMapping(value = "sys_user/findSysUserLoginNamesByGroupCodes", method = RequestMethod.GET)
    ResponseEntity<RestResponse<List<String>>> findSysUserLoginNamesByGroupCodes(@RequestParam("groupCodes") List<String> groupCodes);

    /**
     * @Title:
     * @Description:   根据roleId查询用户登录名集合
     * @param role
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 05:13:18
     */
    @RequestMapping(value = "sys_user/findSysUserLoginNamesByRole", method = RequestMethod.GET)
    ResponseEntity<RestResponse<List<String>>> findSysUserLoginNamesByRole(@RequestParam("role") String role);

    /**
     * @Title:
     * @Description:   根据roleId集合查询用户登录名集合
     * @param roles
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 05:13:18
     */
    @RequestMapping(value = "sys_user/findSysUserLoginNamesByRoles", method = RequestMethod.GET)
    ResponseEntity<RestResponse<List<String>>> findSysUserLoginNamesByRoles(@RequestParam("roles") List<String> roles);

    /** 
    * @Description: 根据roleId集合和组织机构代码（当前机构没有则向上级查询）查询用户登录名集合
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/12 15:07
    */
    @RequestMapping(value = "sys_user/findSysUserLoginNamesByRolesWithGroupCode", method = RequestMethod.GET)
    ResponseEntity<RestResponse<List<String>>> findSysUserLoginNamesByRolesWithGroupCode(@RequestParam("roles") List<String> roles,@RequestParam("groupCode") String groupCode);
}
