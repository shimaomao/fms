package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;
import cn.com.leadu.fms.system.validator.sysuser.vo.*;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysUserService
 * @Description: 用户业务层
 * @date 2018/1/12
 */
public interface SysUserService {

    /**
     * @Title:
     * @Description: 保存用户
     * @param sysUserSaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 10:17:25
     */
    void saveSysUser(SysUserSaveVo sysUserSaveVo);


    /**
     * @Title:
     * @Description: 根据用户名,手机号分页查询用户
     * @param sysUserVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 04:31:12
     */
    PageInfoExtend<SysUser> findSysUserByPage(SysUserVo sysUserVo);


    /**
     * @Title:
     * @Description: 修改用户
     * @param sysUserModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:50:35
     */
    void modifySysUser(SysUserModifyVo sysUserModifyVo);

    /**
     * @Title:
     * @Description:  通过id删除用户
     * @param sysUserDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:55:21
     */
    void deleteSysUser(SysUserDeleteVo sysUserDeleteVo);

    /**
     * @Title:
     * @Description:  根据id获取用户
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 06:32:58
     */
    SysUser findSysUserById(String id);

    /**
     * @Title:
     * @Description:  根据用户代码获取用户
     * @param username
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/12 12:37:31
     */
    SysUser findSysUserByUsername(String username);


    /**
     * @Title:
     * @Description:  获取用户的详细信息,包括拥有的菜单等等
     * @param sysUser
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/14 02:26:33
     */
    SysUserVo findSysUserDetail(SysUser sysUser);

    
    /**
     * @Title:
     * @Description:   根据id集合删除用户
     * @param sysUserDeleteListVo
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/01/17 03:37:25
     */
    void deleteSysUserByIds(SysUserDeleteListVo sysUserDeleteListVo,@AuthUserInfo SysUser sysUser);

    /**
     * @Title:
     * @Description:   修改用户密码
     * @param sysUserModifyPwdVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/19 06:00:46
     */
    void modifySysUserPwd(SysUserModifyPwdVo sysUserModifyPwdVo);

    /**
     * @Title:
     * @Description:   根据用户id获取用户vo详细信息
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/01 09:59:08
     */
    SysUserVo findSysUserVoById(String id);

    /**
     * @Title:
     * @Description: 根据用户名,手机号分页查询用户 并按录入时间倒序
     * @param sysUserVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 04:31:12
     */
    PageInfoExtend<SysUserVo> findSysUserVoByPage(SysUserVo sysUserVo);

    /**
     * @Title:
     * @Description:   获取所有用户,通过添加时间倒序
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 04:22:41
     */
    List<SysUserVo> findSysUserVosAndSysOrganizationsByAll();

    /**
     * @Title:
     * @Description:   根据组织机构code查询用户登录名集合
     * @param groupCode
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/14 05:55:47
     */
    List<String> findSysUserLoginNamesByGroupCode(String groupCode);

    /**
     * @Title:
     * @Description:   根据组织机构code集合查询用户登录名集合
     * @param groupCodes
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/14 05:55:47
     */
    List<String> findSysUserLoginNamesByGroupCodes(List<String> groupCodes);

    /**
     * @Title:
     * @Description:  更新用户最后登录时间
     * @param user
     * @return
     * @throws
     * @author wangxue
     * @date 2018/04/4 13:46:05
     */
    void modifyLastLoginTime(String user);

    /**
     * 根据菜单控制权限找到所有用户
     * @return
     */
    List<SysUser> findAllUsers();

    /**
     * @Title:
     * @Description:   根据roleId查询用户登录名集合
     * @param role
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 04:51:56
     */
    List<String> findSysUserLoginNamesByRole(String role);

    /**
     * @Title:
     * @Description:   根据roleId集合查询用户登录名集合
     * @param roles
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 04:51:56
     */
    List<String> findSysUserLoginNamesByRoles(List<String> roles);

    /** 
    * @Description: 根据roleId集合和组织机构代码（当前机构没有则向上级查询）查询用户登录名集合
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/12 15:22
    */ 
    List<String> findSysUserLoginNamesByRolesWithGroupCode(List<String> roles, String groupCode);

    /**
     * @Title:
     * @Description:   根据用户组ID集合获取用户登录名
     * @param groupIds
     * @return
     * @throws
     * @author wangxue
     * @date 2018/04/26 04:51:56
     */
    List<String> findSysUserLoginNamesByGroupIds(List<String> groupIds);

}
