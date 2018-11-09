package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.entity.SysRole;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.system.vo.sysrole.SysRoleVo;
import cn.com.leadu.fms.system.service.SysRoleService;
import cn.com.leadu.fms.system.validator.sysrole.vo.SysRoleDeleteListVo;
import cn.com.leadu.fms.system.validator.sysrole.vo.SysRoleDeleteVo;
import cn.com.leadu.fms.system.validator.sysrole.vo.SysRoleModifyVo;
import cn.com.leadu.fms.system.validator.sysrole.vo.SysRoleSaveVo;
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
 * @author qiaomengnan
 * @ClassName: SysRoleController
 * @Description: 角色相关接口
 * @date 2018/1/12
 */
@RestController
@RequestMapping("sys_role")
public class SysRoleController {

    /**
     * @Fields  : 角色service
     */
    @Autowired
    private SysRoleService sysRoleService;


    /**
     * @Title:
     * @Description: 分页查询角色信息
     * @param sysRoleVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 05:15:08
     */
    @RequestMapping(value = "findSysRolesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysRolesByPage(SysRoleVo sysRoleVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysRoleService.findSysRolesByPage(sysRoleVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存角色
     * @param sysRoleSaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 05:42:12
     */
    @RequestMapping(value = "saveSysRole",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysRole(@Valid @RequestBody SysRoleSaveVo sysRoleSaveVo){
        sysRoleService.saveSysRole(sysRoleSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改角色
     * @param sysRoleModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:46:05
     */
    @RequestMapping(value = "modifySysRole",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysRole(@Valid @RequestBody SysRoleModifyVo sysRoleModifyVo){
        sysRoleService.modifySysRole(sysRoleModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除角色
     * @param sysRoleDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:47:25
     */
    @RequestMapping(value = "deleteSysRole",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysRole(@Valid @RequestBody SysRoleDeleteVo sysRoleDeleteVo){
        sysRoleService.deleteSysRole(sysRoleDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据id获取角色
     * @param roleId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:47:25
     */
    @RequestMapping(value = "findSysRoleById", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysRoleById(String roleId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysRoleService.findSysRoleById(roleId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据id集合删除角色
     * @param sysRoleDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/17 03:37:25
     */
    @RequestMapping(value = "deleteSysRolesByIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysRoleByIds(@Valid @RequestBody SysRoleDeleteListVo sysRoleDeleteListVo){
        sysRoleService.deleteSysRolesByIds(sysRoleDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * 找到所有角色
     * @return
     */
    @RequestMapping(value = "findAllRoles",method = RequestMethod.POST)
    public List<SysRole> findAllRoles(){
        return sysRoleService.findAllRoles();
    }

    /**
     * 找某角色对应的应该显示的审批情况集合
     * @return
     */
    @RequestMapping(value = "findApproveInfo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApproveInfo(@AuthUserInfo SysUser sysUser,String searchType){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysRoleService.findApproveInfo(sysUser, searchType)),
                HttpStatus.OK);
    }
}
