package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.entity.SysRoleMenu;
import cn.com.leadu.fms.pojo.system.vo.sysrolemenu.SysRoleMenuVo;
import cn.com.leadu.fms.webclient.system.rpc.SysRoleMenuRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: SysRoleMenuController
 * @Description: 菜单角色设置controller
 * @date 2018-03-15
 */
@RestController
@RequestMapping("sys_role_menu")
public class SysRoleMenuController {

    /**
     * @Fields  : 菜单角色设置rpc
     */
    @Autowired
    private SysRoleMenuRpc sysRoleMenuRpc;

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
        Map sysRoleMenuVoMap = sysRoleMenuVo == null?null:(Map) JSON.toJSON(sysRoleMenuVo);
        return sysRoleMenuRpc.findSysRoleMenusByPage(sysRoleMenuVoMap);
    }

    /**
     * @Title:
     * @Description: 保存菜单角色设置
     * @param sysRoleMenuVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @RequestMapping(value = "saveSysRoleMenu",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysRoleMenu(@RequestBody SysRoleMenuVo sysRoleMenuVo){
        return sysRoleMenuRpc.saveSysRoleMenu(sysRoleMenuVo);
    }

    /**
     * @Title:
     * @Description:  修改菜单角色设置
     * @param sysRoleMenuVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @RequestMapping(value = "modifySysRoleMenu",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysRoleMenu(@RequestBody SysRoleMenuVo sysRoleMenuVo){
        return sysRoleMenuRpc.modifySysRoleMenu(sysRoleMenuVo);
    }

    /**
     * @Title:
     * @Description:   根据roleMenuId集合删除菜单角色设置
     * @param roleMenuIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-15 10:47:40
     */
    @RequestMapping(value = "deleteSysRoleMenusByRoleMenuIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysRoleMenusByRoleMenuIds(@RequestBody List<String> roleMenuIds){
        SysRoleMenuVo sysRoleMenuVo = new SysRoleMenuVo();
        sysRoleMenuVo.setRoleMenuIds(roleMenuIds);
        return sysRoleMenuRpc.deleteSysRoleMenusByRoleMenuIds(sysRoleMenuVo);
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
    public ResponseEntity<RestResponse> findSysRoleMenuByRoleMenuId( String roleMenuId){
        return sysRoleMenuRpc.findSysRoleMenuByRoleMenuId(roleMenuId);
    }

    /**
     * 重新分配角色菜单
     * @param sysRoleMenus
     * @return
     */
    @RequestMapping(value = "updateSysRoleMenuByRoleId",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> updateSysRoleMenuByRoleId(@RequestBody List<SysRoleMenu> sysRoleMenus){

        return sysRoleMenuRpc.updateSysRoleMenuByRoleId(sysRoleMenus);
       // return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);

    }



}
