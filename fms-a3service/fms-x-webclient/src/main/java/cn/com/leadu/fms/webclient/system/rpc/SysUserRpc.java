package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: SysUserRpc
 * @Description: 系统用户远程Rpc调用
 * @date 2018/1/9
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface SysUserRpc {

    /**
     * @Title:
     * @Description: 远程调用注册用户
     * @param sysUserVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 11:26:47
     */
    @RequestMapping(value = "api/system/sys_user/saveSysUser" , method = RequestMethod.POST)
    ResponseEntity<RestResponse<String>> saveSysUser(@RequestBody SysUserVo sysUserVo);

    /**
     * @Title:
     * @Description: 分页查询用户信息
     * @param sysUserVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 05:15:08
     */
    @RequestMapping(value = "api/system/sys_user/findSysUserByPage" , method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysUserByPage(@RequestParam Map<String,Object> sysUserVo);

    /**
     * @Title:
     * @Description:  修改用户
     * @param sysUserVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:46:05
     */
    @RequestMapping(value = "api/system/sys_user/modifySysUser" , method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifySysUser(@RequestBody SysUserVo sysUserVo);

    /**
     * @Title:
     * @Description:  删除用户
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:47:25
     */
    @RequestMapping(value = "api/system/sys_user/deleteSysUser" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteSysUser(@RequestParam("id") String id);

    /**
     * @Title:
     * @Description:  根据id获取用户
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:47:25
     */
    @RequestMapping(value = "api/system/sys_user/findSysUserById", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysUserById(@RequestParam("id") String id);


    /**
     * @Title:
     * @Description:  获取当前登录用户的详细信息
     * @param
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 02:26:33
     */
    @RequestMapping(value = "api/system/sys_user/findSysUserDetail", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysUserDetail();

    /**
     * @Title:
     * @Description:   根据id集合删除用户
     * @param sysUserVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/17 03:37:25
     */
    @RequestMapping(value = "api/system/sys_user/deleteSysUserByIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteSysUserByIds(@RequestBody SysUserVo sysUserVo);

    /**
     * @Title:
     * @Description:   修改用户密码
     * @param sysUserVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/19 06:00:46
     */
    @RequestMapping(value = "api/system/sys_user/modifySysUserPwd" , method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifySysUserPwd(@RequestBody SysUserVo sysUserVo);

    /**
     * @Title:
     * @Description:  根据id获取用户vo
     * @param userId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:47:25
     */
    @RequestMapping(value = "api/system/sys_user/findSysUserVoById", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysUserVoById(@RequestParam("userId") String userId);

    /**
     * @Title:
     * @Description: 分页查询用户vo信息
     * @param sysUserVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 05:15:08
     */
    @RequestMapping(value = "api/system/sys_user/findSysUserVoByPage", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysUserVoByPage(@RequestParam Map<String,Object> sysUserVo);

    /**
     * 根据菜单权限类型为用户找到所有用户
     * @return
     */
    @RequestMapping(value = "api/system/sys_user/findAllUsers", method = RequestMethod.POST)
    List<SysUser> findAllUsers();

    /**
     * 根据菜单权限类型为用户找到所有用户
     * @return
     */
    @RequestMapping(value = "api/system/sys_user/findUserDetailByUser", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findUserDetailByUser();
}
