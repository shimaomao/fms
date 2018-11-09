package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.common.vo.BootstrapTreeViewNodeVo;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.entity.SysMenu;
import cn.com.leadu.fms.pojo.system.entity.SysRole;
import cn.com.leadu.fms.pojo.system.vo.sysmenu.SysMenuVo;
import cn.com.leadu.fms.webclient.system.rpc.SysMenuRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: SysMenuController
 * @Description: 系统菜单controller
 * @date 2018-03-07
 */
@RestController
@RequestMapping("sys_menu")
public class SysMenuController {

    @Autowired
    private SysMenuRpc sysMenuRpc;

    /**
     * @Title:
     * @Description: 分页查询系统菜单信息
     * @param sysMenuVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @RequestMapping(value = "findSysMenuVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysMenuVosByPage(SysMenuVo sysMenuVo){
        Map sysMenuVoMap = sysMenuVo == null?null:(Map) JSON.toJSON(sysMenuVo);
        return sysMenuRpc.findSysMenuVosByPage(sysMenuVoMap);
    }

    /**
     * @Title:
     * @Description: 保存系统菜单
     * @param sysMenuVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @RequestMapping(value = "saveSysMenu",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysMenu(@RequestBody SysMenuVo sysMenuVo){
        return sysMenuRpc.saveSysMenu(sysMenuVo);
    }

    /**
     * @Title:
     * @Description:  修改系统菜单
     * @param sysMenuVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @RequestMapping(value = "modifySysMenu",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysMenu(@RequestBody SysMenuVo sysMenuVo){
        return sysMenuRpc.modifySysMenu(sysMenuVo);
    }

    /**
     * @Title:
     * @Description:  根据id获取系统菜单
     * @param menuId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @RequestMapping(value = "findSysMenuByMenuId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysMenuByMenuId(String menuId){
        return sysMenuRpc.findSysMenuByMenuId(menuId);
    }

    /**
     * @Title:
     * @Description:   根据id集合删除系统菜单
     * @param menuIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @RequestMapping(value = "deleteSysMenusByMenuIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysMenusByMenuIds(@RequestBody List<String> menuIds){
       SysMenuVo sysMenuVo = new SysMenuVo();
       sysMenuVo.setMenuIds(menuIds);

//        SysMenuDeleteListVo sysMenuDeleteListVo = new SysMenuDeleteListVo();
//        sysMenuDeleteListVo.setMenuIds(ids);
        return sysMenuRpc.deleteSysMenusByMenuIds(sysMenuVo);
    }

    /**
     * 根据菜单等级获取父类菜单
     * @param menuLevel
     * @return
     */
    @RequestMapping(value = "findSysResourceIsParent", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysResourceIsParent(@RequestParam(required = false) String menuLevel){
        return sysMenuRpc.findSysResourceIsParent(menuLevel);
    }

    /**
     * 根据角色id获取菜单
     * @param roleId
     * @return
     */
    @RequestMapping(value = "findSysMenusByRoleId",method = RequestMethod.POST)
    public List<BootstrapTreeViewNodeVo> findSysMenusByRoleId(@RequestParam("roleId") String roleId){
        return sysMenuRpc.findSysMenusByRoleId(roleId);
    }

    /**
     * 根据用户id获取菜单
     */
    @RequestMapping(value = "findSysMenusByUserId",method = RequestMethod.POST)
    @ResponseBody
    public List<BootstrapTreeViewNodeVo> findSysMenusByUserId(@RequestParam("userId") String userId){
        return sysMenuRpc.findSysMenusByUserId(userId);
    }

    /**
     * 根据角色id获取所有菜单并勾选已有菜单
     * @return
     */
    @RequestMapping(value ="findAllMenusByRoleId",method = RequestMethod.GET)
    public List<BootstrapTreeViewNodeVo> findAllMenusByRoleId(@RequestParam("roleId") String roleId) {
        return sysMenuRpc.findAllMenusByRoleId(roleId);
    }

    /**
     * 根据用户id获取所有菜单并勾选已有菜单
     * @return
     */
    @RequestMapping(value ="findAllMenusByUserId",method = RequestMethod.GET)
    public List<BootstrapTreeViewNodeVo> findAllMenusByUserId(@RequestParam("userId") String userId) {
        return sysMenuRpc.findAllMenusByUserId(userId);
    }
}
