package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.entity.SysUserMenu;
import cn.com.leadu.fms.pojo.system.vo.sysusermenu.SysUserMenuVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: SysUserMenuController
 * @Description: 用户角色设置rpc
 * @date 2018-03-17
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface SysUserMenuRpc {

    /**
     * @Title:
     * @Description: 分页查询用户角色设置信息
     * @param sysUserMenuVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @RequestMapping(value = "api/system/sys_user_menu/findSysUserMenusByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysUserMenusByPage(@RequestParam Map<String, Object> sysUserMenuVoMap);

    /**
     * @Title:
     * @Description: 保存用户角色设置
     * @param sysUserMenuVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @RequestMapping(value = "api/system/sys_user_menu/saveSysUserMenu",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveSysUserMenu(@RequestBody SysUserMenuVo sysUserMenuVo);

    /**
     * @Title:
     * @Description:  修改用户角色设置
     * @param sysUserMenuVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @RequestMapping(value = "api/system/sys_user_menu/modifySysUserMenu",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifySysUserMenu(@RequestBody SysUserMenuVo sysUserMenuVo);

    /**
     * @Title:
     * @Description:   根据userMenuId集合删除用户角色设置
     * @param sysUserMenuVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @RequestMapping(value = "api/system/sys_user_menu/deleteSysUserMenusByUserMenuIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteSysUserMenusByUserMenuIds(@RequestBody SysUserMenuVo sysUserMenuVo);

    /**
     * @Title:
     * @Description:  根据userMenuId获取用户角色设置
     * @param userMenuId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @RequestMapping(value = "api/system/sys_user_menu/findSysUserMenuByUserMenuId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysUserMenuByUserMenuId(@RequestParam("userMenuId") String userMenuId);


    /**
     * 根据角色id更新菜单
     * @param sysUserMenus
     * @return
     */
    @RequestMapping(value = "api/system/sys_user_menu/updateSysUserMenuByUserId", method = RequestMethod.POST)
    ResponseEntity<RestResponse> updateSysUserMenuByUserId(@RequestBody List<SysUserMenu> sysUserMenus);

}
