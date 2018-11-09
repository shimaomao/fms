package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.common.vo.BootstrapTreeViewNodeVo;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.entity.SysRole;
import cn.com.leadu.fms.pojo.system.vo.sysmenu.SysMenuVo;
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
 * @ClassName: SysMenuController
 * @Description: 系统菜单rpc
 * @date 2018-03-07
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface SysMenuRpc {

    /**
     * @Title:
     * @Description: 分页查询系统菜单信息
     * @param sysMenuVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @RequestMapping(value = "api/system/sys_menu/findSysMenuVosByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysMenuVosByPage(@RequestParam Map<String, Object> sysMenuVoMap);

    /**
     * @Title:
     * @Description: 保存系统菜单
     * @param sysMenuVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @RequestMapping(value = "api/system/sys_menu/saveSysMenu",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveSysMenu(@RequestBody SysMenuVo sysMenuVo);

    /**
     * @Title:
     * @Description:  修改系统菜单
     * @param sysMenuVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @RequestMapping(value = "api/system/sys_menu/modifySysMenu",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifySysMenu(@RequestBody SysMenuVo sysMenuVo);

    /**
     * @Title:
     * @Description:  根据id获取系统菜单
     * @param id
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @RequestMapping(value = "api/system/sys_menu/findSysMenuByMenuId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysMenuByMenuId(@RequestParam("menuId") String id);

    /**
     * @Title:
     * @Description:   根据id集合删除系统菜单
     * @param sysMenuVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @RequestMapping(value = "api/system/sys_menu/deleteSysMenusByMenuIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteSysMenusByMenuIds(@RequestBody SysMenuVo sysMenuVo);

    /**
     * 根据菜单等级获取菜单
     * @param resLevel
     * @return
     */
    @RequestMapping(value = "api/system/sys_menu/findSysResourceIsParent", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysResourceIsParent(@RequestParam("menuLevel") String resLevel);

    /**
     *
     * 根据角色id获取菜单
     * @param roleId
     * @return
     */
    @RequestMapping(value = "api/system/sys_menu/findSysMenusByRoleId", method = RequestMethod.POST)
    List<BootstrapTreeViewNodeVo> findSysMenusByRoleId(@RequestParam("roleId") String roleId);

    /**
     *
     * 根据用户id获取菜单
     * @param userId
     * @return
     */
    @RequestMapping(value = "api/system/sys_menu/findSysMenusByUserId", method = RequestMethod.POST)
    List<BootstrapTreeViewNodeVo> findSysMenusByUserId(@RequestParam("userId") String userId);

    /**
     * 根据角色id获取所有菜单并勾选已有菜单
     * @return
     */
    @RequestMapping(value ="api/system/sys_menu/findAllMenusByRoleId",method = RequestMethod.GET)
    List<BootstrapTreeViewNodeVo> findAllMenusByRoleId(@RequestParam("roleId") String roleId);
    /**
     * 根据用户id获取所有菜单并勾选已有菜单
     * @return
     */
    @RequestMapping(value ="api/system/sys_menu/findAllMenusByUserId",method = RequestMethod.GET)
    List<BootstrapTreeViewNodeVo> findAllMenusByUserId(@RequestParam("userId") String userId);
}
