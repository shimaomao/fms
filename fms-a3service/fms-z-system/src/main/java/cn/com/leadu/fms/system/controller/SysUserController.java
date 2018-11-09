package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;
import cn.com.leadu.fms.system.service.SysUserService;
import cn.com.leadu.fms.system.validator.sysuser.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysUserController
 * @Description: 系统用户相关接口
 * @date 2018/1/9
 */
@RestController
@RequestMapping("sys_user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * @Title:
     * @Description: 分页查询用户信息
     * @param sysUserVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 05:15:08
     */
    @RequestMapping(value = "findSysUserByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserByPage(SysUserVo sysUserVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysUserService.findSysUserByPage(sysUserVo)),
                HttpStatus.OK);
    }
    
    /**
     * @Title:
     * @Description: 保存用户
     * @param sysUserSaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 05:42:12
     */
    @RequestMapping(value = "saveSysUser",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysUser(@Valid @RequestBody SysUserSaveVo sysUserSaveVo){
        sysUserService.saveSysUser(sysUserSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:  
     * @Description:  修改用户
     * @param sysUserModifyVo
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/01/11 05:46:05
     */
    @RequestMapping(value = "modifySysUser",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysUser(@Valid @RequestBody SysUserModifyVo sysUserModifyVo){
        sysUserService.modifySysUser(sysUserModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
    
    /**
     * @Title:  
     * @Description:  删除用户
     * @param sysUserDeleteVo
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/01/11 05:47:25
     */
    @RequestMapping(value = "deleteSysUser",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysUser(@Valid @RequestBody SysUserDeleteVo sysUserDeleteVo){
        sysUserService.deleteSysUser(sysUserDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据id获取用户
     * @param userId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:47:25
     */
    @RequestMapping(value = "findSysUserById", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserById(String userId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysUserService.findSysUserById(userId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据用户代码获取用户
     * @param username
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:47:25
     */
    @RequestMapping(value = "findSysUserByUsername", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserByUsername(String username){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysUserService.findSysUserByUsername(username)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  获取当前登录用户的详细信息
     * @param sysUser
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 02:26:33
     */
    @RequestMapping(value = "findSysUserDetail", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserDetail(@AuthUserInfo SysUser sysUser){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysUserService.findSysUserDetail(sysUser)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据id集合删除用户
     * @param sysUserDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/17 03:37:25
     */
    @RequestMapping(value = "deleteSysUserByIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysUserByIds(@Valid @RequestBody SysUserDeleteListVo sysUserDeleteListVo,@AuthUserInfo SysUser sysUser){
        sysUserService.deleteSysUserByIds(sysUserDeleteListVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   修改用户密码
     * @param sysUserModifyPwdVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/19 06:00:46
     */
    @RequestMapping(value = "modifySysUserPwd" , method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysUserPwd(@Valid @RequestBody SysUserModifyPwdVo sysUserModifyPwdVo){
        sysUserService.modifySysUserPwd(sysUserModifyPwdVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据id获取用户vo
     * @param userId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:47:25
     */
    @RequestMapping(value = "findSysUserVoById", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserVoById(String userId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysUserService.findSysUserVoById(userId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 分页查询用户vo信息
     * @param sysUserVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 05:15:08
     */
    @RequestMapping(value = "findSysUserVoByPage", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserVoByPage(SysUserVo sysUserVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysUserService.findSysUserVoByPage(sysUserVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据username获取用户Vo，得到用户基本信息和角色名称,角色名使用String存储, 使用,分隔
     * @param username
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:47:25
     */
    @RequestMapping(value = "findSysUserVoByUsername", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserVoByUsername(String username){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysUserService.findSysUserByUsername(username)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   获取所有用户,通过添加时间倒序,并得到用户所在的组织及上级组织集合
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 04:21:31
     */
    @RequestMapping(value = "findSysUserVosAndSysOrganizationsByAll", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUsersByAll(){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysUserService.findSysUserVosAndSysOrganizationsByAll()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据组织机构code查询用户列表
     * @param groupCode
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/14 05:55:47
     */
    @RequestMapping(value = "findSysUserLoginNamesByGroupCode",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserLoginNamesByGroupCode(String groupCode){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysUserService.findSysUserLoginNamesByGroupCode(groupCode)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据组织机构code查询用户列表
     * @param groupCodes
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/14 05:55:47
     */
    @RequestMapping(value = "findSysUserLoginNamesByGroupCodes",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserLoginNamesByGroupCodes(@RequestParam List<String> groupCodes){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysUserService.findSysUserLoginNamesByGroupCodes(groupCodes)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  更新用户最后登录时间
     * @param user
     * @return
     * @throws
     * @author wangxue
     * @date 2018/04/4 13:46:05
     */
    @RequestMapping(value = "modifyLastLoginTime",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyLastLoginTime(@RequestBody String user){
        sysUserService.modifyLastLoginTime(user);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  找到所有菜单权限类型为用户的用户
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/04/4 13:46:05
     */
    @RequestMapping(value = "findAllUsers",method = RequestMethod.POST)
    public List<SysUser> findAllUsers(){
        return sysUserService.findAllUsers();
    }

    /**
     * @Title:
     * @Description:   根据roleId查询用户登录名集合
     * @param role
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 05:13:18
     */
    @RequestMapping(value = "findSysUserLoginNamesByRole",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserLoginNamesByRole(String role){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysUserService.findSysUserLoginNamesByRole(role)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据roleId集合查询用户登录名集合
     * @param roles
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 05:13:18
     */
    @RequestMapping(value = "findSysUserLoginNamesByRoles",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserLoginNamesByRoles(@RequestParam List<String> roles){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysUserService.findSysUserLoginNamesByRoles(roles)), HttpStatus.OK);
    }

    /** 
    * @Description: 根据roleId集合和组织机构代码（当前机构没有则向上级查询）查询用户登录名集合
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/12 15:13
    */ 
    @RequestMapping(value = "findSysUserLoginNamesByRolesWithGroupCode",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysUserLoginNamesByRolesWithGroupCode(@RequestParam List<String> roles,@RequestParam String groupCode){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysUserService.findSysUserLoginNamesByRolesWithGroupCode(roles,groupCode)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  获取当前登录用户的信息
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-22 19:35:32
     */
    @RequestMapping(value = "findUserDetailByUser", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findUserDetailByUser(@AuthUserInfo SysUser sysUser){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysUserService.findSysUserByUsername(sysUser.getUser())), HttpStatus.OK);
    }

}
