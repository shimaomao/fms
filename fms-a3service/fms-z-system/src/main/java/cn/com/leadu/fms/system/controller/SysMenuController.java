package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.common.vo.BootstrapTreeViewNodeVo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.vo.sysmenu.SysMenuVo;
import cn.com.leadu.fms.system.service.SysMenuService;
import cn.com.leadu.fms.system.validator.sysmenu.vo.SysMenuDeleteVo;
import cn.com.leadu.fms.system.validator.sysmenu.vo.SysMenuModifyVo;
import cn.com.leadu.fms.system.validator.sysmenu.vo.SysMenuSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SysMenuController
 * @Description: 系统菜单相关接口
 * @date 2018-03-07
 */
@RestController
@RequestMapping("sys_menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

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
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysMenuService.findSysMenuVosByPage(sysMenuVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存系统菜单
     * @param sysMenuSaveVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @RequestMapping(value = "saveSysMenu",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysMenu(@Valid @RequestBody SysMenuSaveVo sysMenuSaveVo){
        sysMenuService.saveSysMenu(sysMenuSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改系统菜单
     * @param sysMenuModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @RequestMapping(value = "modifySysMenu",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysMenu(@Valid @RequestBody SysMenuModifyVo sysMenuModifyVo){
        sysMenuService.modifySysMenu(sysMenuModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除系统菜单
     * @param sysMenuDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @RequestMapping(value = "deleteSysMenu",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysMenu(@Valid @RequestBody SysMenuDeleteVo sysMenuDeleteVo){
        sysMenuService.deleteSysMenu(sysMenuDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据id集合删除系统菜单
     * @param sysMenuVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-7 17:31:54
     */
    @RequestMapping(value = "deleteSysMenusByMenuIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysMenusByMenuIds(@Valid @RequestBody SysMenuVo sysMenuVo){
        sysMenuService.deleteSysMenuByMenuIds(sysMenuVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
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
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysMenuService.findSysMenuByMenuId(menuId)), HttpStatus.OK);
    }

    /**
     * 根据菜单级别获取菜单
     * @param menuLevel
     * @return
     */
    @RequestMapping(value = "findSysResourceIsParent", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysResourceIsParent(@RequestParam(required = false) String  menuLevel){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysMenuService.findSysResourceIsParent(menuLevel)), HttpStatus.OK);
    }

    /**
     * 根据角色id获取菜单
     * @param roleId
     * @return
     */
    @RequestMapping(value = "findSysMenusByRoleId",method = RequestMethod.POST)
    public List<BootstrapTreeViewNodeVo> findSysMenusByRoleId(@RequestParam("roleId") String  roleId){
        //return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysMenuService.findSysMenusByRoleId(roleId)), HttpStatus.OK);
        return sysMenuService.findSysMenusByRoleId(roleId);
    }

    /**
     * 根据用户id获取菜单
     * @param userId
     * @return
     */
    @RequestMapping(value = "findSysMenusByUserId",method = RequestMethod.POST)
    public List<BootstrapTreeViewNodeVo> findSysMenusByUserId(@RequestParam("userId") String  userId){
        return sysMenuService.findSysMenusByUserId(userId);
    }

    /**
     * @Title:
     * @Description:   根据父级id获取下级菜单
     * @param parMenuId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/29 12:09:04
     */
    @RequestMapping(value = "findSysMenusByParMenuId",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysMenusByParMenuId(String parMenuId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysMenuService.findSysMenusByParMenuId(parMenuId)), HttpStatus.OK);
    }

    /**
     * 根据角色id获取所有菜单并勾选
     * @return
     */
    @RequestMapping(value ="findAllMenusByRoleId",method = RequestMethod.GET)
   public List<BootstrapTreeViewNodeVo> findAllMenusByRoleId(@RequestParam("roleId") String  roleId){
       return sysMenuService.findAllMenusByRoleId(roleId);
   }

    /**
     * 根据用户id获取所有菜单并勾选
     * @return
     */
    @RequestMapping(value ="findAllMenusByUserId",method = RequestMethod.GET)
    public List<BootstrapTreeViewNodeVo> findAllMenusByUserId(@RequestParam("userId") String  userId){
        return sysMenuService.findAllMenusByUserId(userId);
    }
}
