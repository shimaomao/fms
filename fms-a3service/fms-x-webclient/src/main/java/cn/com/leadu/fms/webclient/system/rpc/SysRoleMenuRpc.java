package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.entity.SysRoleMenu;
import cn.com.leadu.fms.pojo.system.vo.sysrolemenu.SysRoleMenuVo;
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
 * @ClassName: SysRoleMenuController
 * @Description: 菜单角色设置rpc
 * @date 2018-03-15
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface SysRoleMenuRpc {

    /**
     * @Title:
     * @Description: 分页查询菜单角色设置信息
     * @param sysRoleMenuVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @RequestMapping(value = "api/system/sys_role_menu/findSysRoleMenusByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysRoleMenusByPage(@RequestParam Map<String, Object> sysRoleMenuVoMap);

    /**
     * @Title:
     * @Description: 保存菜单角色设置
     * @param sysRoleMenuVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @RequestMapping(value = "api/system/sys_role_menu/saveSysRoleMenu",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveSysRoleMenu(@RequestBody SysRoleMenuVo sysRoleMenuVo);

    /**
     * @Title:
     * @Description:  修改菜单角色设置
     * @param sysRoleMenuVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @RequestMapping(value = "api/system/sys_role_menu/modifySysRoleMenu",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifySysRoleMenu(@RequestBody SysRoleMenuVo sysRoleMenuVo);

    /**
     * @Title:
     * @Description:   根据roleMenuId集合删除菜单角色设置
     * @param sysRoleMenuVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @RequestMapping(value = "api/system/sys_role_menu/deleteSysRoleMenusByRoleMenuIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteSysRoleMenusByRoleMenuIds(@RequestBody SysRoleMenuVo sysRoleMenuVo);

    /**
     * @Title:
     * @Description:  根据roleMenuId获取菜单角色设置
     * @param roleMenuId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @RequestMapping(value = "api/system/sys_role_menu/findSysRoleMenuByRoleMenuId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysRoleMenuByRoleMenuId(@RequestParam("roleMenuId") String roleMenuId);

    /**
     * 根据角色id更新菜单
     * @param sysRoleMenus
     * @return
     */
    @RequestMapping(value = "api/system/sys_role_menu/updateSysRoleMenuByRoleId", method = RequestMethod.POST)
    ResponseEntity<RestResponse> updateSysRoleMenuByRoleId(@RequestBody List<SysRoleMenu> sysRoleMenus);
}
