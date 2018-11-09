package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.entity.SysRoleMenu;
import cn.com.leadu.fms.pojo.system.vo.sysrolemenu.SysRoleMenuVo;
import cn.com.leadu.fms.system.service.SysRoleMenuService;
import cn.com.leadu.fms.system.validator.sysrolemenu.vo.SysRoleMenuDeleteListVo;
import cn.com.leadu.fms.system.validator.sysrolemenu.vo.SysRoleMenuDeleteVo;
import cn.com.leadu.fms.system.validator.sysrolemenu.vo.SysRoleMenuModifyVo;
import cn.com.leadu.fms.system.validator.sysrolemenu.vo.SysRoleMenuSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SysRoleMenuController
 * @Description: 菜单角色设置相关接口
 * @date 2018-03-15
 */
@RestController
@RequestMapping("sys_role_menu")
public class SysRoleMenuController {

    /**
     * @Fields  : 菜单角色设置service
     */
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * @Title:
     * @Description: 分页查询菜单角色设置信息
     * @param sysRoleMenuVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @RequestMapping(value = "findSysRoleMenusByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysRoleMenusByPage(SysRoleMenuVo sysRoleMenuVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysRoleMenuService.findSysRoleMenusByPage(sysRoleMenuVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存菜单角色设置
     * @param sysRoleMenuSaveVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @RequestMapping(value = "saveSysRoleMenu",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysRoleMenu(@Valid @RequestBody SysRoleMenuSaveVo sysRoleMenuSaveVo){
        sysRoleMenuService.saveSysRoleMenu(sysRoleMenuSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改菜单角色设置
     * @param sysRoleMenuModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @RequestMapping(value = "modifySysRoleMenu",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysRoleMenu(@Valid @RequestBody SysRoleMenuModifyVo sysRoleMenuModifyVo){
        sysRoleMenuService.modifySysRoleMenu(sysRoleMenuModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除菜单角色设置
     * @param sysRoleMenuDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @RequestMapping(value = "deleteSysRoleMenu",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysRoleMenu(@Valid @RequestBody SysRoleMenuDeleteVo sysRoleMenuDeleteVo){
        sysRoleMenuService.deleteSysRoleMenu(sysRoleMenuDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据roleMenuId集合删除菜单角色设置
     * @param sysRoleMenuDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @RequestMapping(value = "deleteSysRoleMenusByRoleMenuIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysRoleMenusByRoleMenuIds(@Valid @RequestBody SysRoleMenuDeleteListVo sysRoleMenuDeleteListVo){
        sysRoleMenuService.deleteSysRoleMenusByRoleMenuIds(sysRoleMenuDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据roleMenuId获取菜单角色设置
     * @param roleMenuId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @RequestMapping(value = "findSysRoleMenuByRoleMenuId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysRoleMenuByRoleMenuId(String roleMenuId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysRoleMenuService.findSysRoleMenuByRoleMenuId(roleMenuId)), HttpStatus.OK);
    }

    /**
     * 根据角色id更新菜单信息
     * @param sysRoleMenus
     * @return
     */
   @RequestMapping(value = "updateSysRoleMenuByRoleId",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> updateSysRoleMenuByRoleId(@RequestBody List<SysRoleMenu> sysRoleMenus){

        sysRoleMenuService.updateSysRoleMenuByRoleId(sysRoleMenus);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);

    }

}
