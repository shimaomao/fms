package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.entity.SysUserMenu;
import cn.com.leadu.fms.pojo.system.vo.sysusermenu.SysUserMenuVo;
import cn.com.leadu.fms.system.service.SysUserMenuService;
import cn.com.leadu.fms.system.validator.sysusermenu.vo.SysUserMenuDeleteListVo;
import cn.com.leadu.fms.system.validator.sysusermenu.vo.SysUserMenuDeleteVo;
import cn.com.leadu.fms.system.validator.sysusermenu.vo.SysUserMenuModifyVo;
import cn.com.leadu.fms.system.validator.sysusermenu.vo.SysUserMenuSaveVo;
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
 * @ClassName: SysUserMenuController
 * @Description: 用户角色设置相关接口
 * @date 2018-03-17
 */
@RestController
@RequestMapping("sys_user_menu")
public class SysUserMenuController {

    /**
     * @Fields  : 用户角色设置service
     */
    @Autowired
    private SysUserMenuService sysUserMenuService;

    /**
     * @Title:
     * @Description: 分页查询用户角色设置信息
     * @param sysUserMenuVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:58
     */
    @RequestMapping(value = "findSysUserMenusByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserMenusByPage(SysUserMenuVo sysUserMenuVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysUserMenuService.findSysUserMenusByPage(sysUserMenuVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存用户角色设置
     * @param sysUserMenuSaveVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:58
     */
    @RequestMapping(value = "saveSysUserMenu",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysUserMenu(@Valid @RequestBody SysUserMenuSaveVo sysUserMenuSaveVo){
        sysUserMenuService.saveSysUserMenu(sysUserMenuSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改用户角色设置
     * @param sysUserMenuModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:58
     */
    @RequestMapping(value = "modifySysUserMenu",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysUserMenu(@Valid @RequestBody SysUserMenuModifyVo sysUserMenuModifyVo){
        sysUserMenuService.modifySysUserMenu(sysUserMenuModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除用户角色设置
     * @param sysUserMenuDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:58
     */
    @RequestMapping(value = "deleteSysUserMenu",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysUserMenu(@Valid @RequestBody SysUserMenuDeleteVo sysUserMenuDeleteVo){
        sysUserMenuService.deleteSysUserMenu(sysUserMenuDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据userMenuId集合删除用户角色设置
     * @param sysUserMenuDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:58
     */
    @RequestMapping(value = "deleteSysUserMenusByUserMenuIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysUserMenusByUserMenuIds(@Valid @RequestBody SysUserMenuDeleteListVo sysUserMenuDeleteListVo){
        sysUserMenuService.deleteSysUserMenusByUserMenuIds(sysUserMenuDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据userMenuId获取用户角色设置
     * @param userMenuId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:58
     */
    @RequestMapping(value = "findSysUserMenuByUserMenuId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserMenuByUserMenuId(String userMenuId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysUserMenuService.findSysUserMenuByUserMenuId(userMenuId)), HttpStatus.OK);
    }

    /**
     * 根据用户id更新菜单信息
     * @param sysUserMenus
     * @return
     */
    @RequestMapping(value = "updateSysUserMenuByUserId",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> updateSysUserMenuByUserId(@RequestBody List<SysUserMenu> sysUserMenus){

        sysUserMenuService.updateSysUserMenuByUserId(sysUserMenus);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);

    }

}
