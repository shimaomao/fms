package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.entity.SysUserMenu;
import cn.com.leadu.fms.pojo.system.vo.sysusermenu.SysUserMenuVo;
import cn.com.leadu.fms.webclient.system.rpc.SysUserMenuRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: SysUserMenuController
 * @Description: 用户角色设置controller
 * @date 2018-03-17
 */
@RestController
@RequestMapping("sys_user_menu")
public class SysUserMenuController {

    /**
     * @Fields  : 用户角色设置rpc
     */
    @Autowired
    private SysUserMenuRpc sysUserMenuRpc;

    /**
     * @Title:
     * @Description: 分页查询用户角色设置信息
     * @param sysUserMenuVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @RequestMapping(value = "findSysUserMenusByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserMenusByPage(SysUserMenuVo sysUserMenuVo){
        Map sysUserMenuVoMap = sysUserMenuVo == null?null:(Map) JSON.toJSON(sysUserMenuVo);
        return sysUserMenuRpc.findSysUserMenusByPage(sysUserMenuVoMap);
    }

    /**
     * @Title:
     * @Description: 保存用户角色设置
     * @param sysUserMenuVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @RequestMapping(value = "saveSysUserMenu",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysUserMenu(@RequestBody SysUserMenuVo sysUserMenuVo){
        return sysUserMenuRpc.saveSysUserMenu(sysUserMenuVo);
    }

    /**
     * @Title:
     * @Description:  修改用户角色设置
     * @param sysUserMenuVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @RequestMapping(value = "modifySysUserMenu",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysUserMenu(@RequestBody SysUserMenuVo sysUserMenuVo){
        return sysUserMenuRpc.modifySysUserMenu(sysUserMenuVo);
    }

    /**
     * @Title:
     * @Description:   根据userMenuId集合删除用户角色设置
     * @param userMenuIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @RequestMapping(value = "deleteSysUserMenusByUserMenuIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysUserMenusByUserMenuIds(@RequestBody List<String> userMenuIds){
        SysUserMenuVo sysUserMenuVo = new SysUserMenuVo();
        sysUserMenuVo.setUserMenuIds(userMenuIds);
        return sysUserMenuRpc.deleteSysUserMenusByUserMenuIds(sysUserMenuVo);
    }

    /**
     * @Title:
     * @Description:  根据userMenuId获取用户角色设置
     * @param userMenuId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-17 9:49:59
     */
    @RequestMapping(value = "findSysUserMenuByUserMenuId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserMenuByUserMenuId(String userMenuId){
        return sysUserMenuRpc.findSysUserMenuByUserMenuId(userMenuId);
    }

    /**
     * 重新分配用户菜单
     * @param sysUserMenus
     * @return
     */
    @RequestMapping(value = "updateSysUserMenuByUserId",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> updateSysUserMenuByUserId(@RequestBody List<SysUserMenu> sysUserMenus){

        return sysUserMenuRpc.updateSysUserMenuByUserId(sysUserMenus);
        // return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);

    }

}
