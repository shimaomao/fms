package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysRole;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.system.vo.desk.RoleDeskVo;
import cn.com.leadu.fms.pojo.system.vo.sysrole.SysRoleVo;
import cn.com.leadu.fms.system.validator.sysrole.vo.SysRoleDeleteListVo;
import cn.com.leadu.fms.system.validator.sysrole.vo.SysRoleDeleteVo;
import cn.com.leadu.fms.system.validator.sysrole.vo.SysRoleModifyVo;
import cn.com.leadu.fms.system.validator.sysrole.vo.SysRoleSaveVo;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysRoleService
 * @Description: 角色业务层
 * @date 2018/1/12
 */
public interface SysRoleService {

    /**
     * @Title:
     * @Description: 保存角色
     * @param sysRoleSaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 10:17:25
     */
    void saveSysRole(SysRoleSaveVo sysRoleSaveVo);


    /**
     * @Title:
     * @Description: 根据角色名分页查询角色,按照新增时间分页
     * @param sysRoleVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 04:31:12
     */
    PageInfoExtend<SysRole> findSysRolesByPage(SysRoleVo sysRoleVo);


    /**
     * @Title:
     * @Description: 修改角色
     * @param sysRoleModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:50:35
     */
    void modifySysRole(SysRoleModifyVo sysRoleModifyVo);

    /**
     * @Title:
     * @Description:  通过id删除角色
     * @param sysRoleDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:55:21
     */
    void deleteSysRole(SysRoleDeleteVo sysRoleDeleteVo);

    /**
     * @Title:
     * @Description:  根据id获取角色
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 06:32:58
     */
    SysRole findSysRoleById(String id);


    /**
     * @Title:
     * @Description:   根据id集合删除角色
     * @param sysRoleDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/17 03:37:25
     */
    void deleteSysRolesByIds(SysRoleDeleteListVo sysRoleDeleteListVo);

    /**
     * @Title:
     * @Description:   根据用户id查询拥有角色id集合
     * @param sysUserId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/07 12:02:28
     */
    List<String> findSysRoleIdsBySysUserId(String sysUserId);

    /**
     * @Title:
     * @Description:   根据用户id查询拥有角色集合
     * @param sysUserId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/07 01:57:26
     */
    List<SysRole> findSysRolesBySysUserId(String sysUserId);

    /**
     * 根据code获取角色
     * @param role
     * @return
     */
    SysRole findSysRoleByRole(String role);
    /**
     * 获取所有角色
     */
    List<SysRole> findAllRoles();
    /**
     * 找某角色对应的应该显示的审批情况集合
     */
    RoleDeskVo findApproveInfo(SysUser sysUser, String searchType);
}
