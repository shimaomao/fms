package cn.com.leadu.fms.data.system.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysUserDao
 * @Description: 用户dao层
 * @date 2018/1/12
 */
public interface SysUserDao extends BaseDao<SysUser> {
    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    SysUserVo selectSysUserVoById(Object id);

    /**
     * 分页获取用户信息
     * @param sysUserVo
     * @return
     */
    List<SysUserVo> selectSysUserVoByPage(@Param("sysUserVo") SysUserVo sysUserVo);

    /**
     * @Title:
     * @Description:   根据groupCode查询用户登录名集合
     * @param groupCode
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 04:41:50
     */
    List<String> selectSysUserLoginNamesByGroupCode(@Param("groupCode") String groupCode);

    /**
     * @Title:
     * @Description:   根据groupCode集合查询用户登录名集合
     * @param groupCodes
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 04:41:50
     */
    List<String> selectSysUserLoginNamesByGroupCodes(@Param("groupCodes") List<String> groupCodes);


    /**
     * @Title:
     * @Description:   根据roleId查询用户登录名集合
     * @param role
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 04:51:56
     */
    List<String> selectSysUserLoginNamesByRole(@Param("role") String role);

    /**
     * @Title:
     * @Description:   根据roleId查询用户登录名集合
     * @param roles
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 04:51:56
     */
    List<String> selectSysUserLoginNamesByRoles(@Param("roles") List<String> roles);

    /**
     * @Description: 根据roleId集合和组织机构代码查询用户登录名集合
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/12 15:31
     */
    List<String> findSysUserLoginNamesByRolesWithGroupCode(@Param("roles") List<String> roles,@Param("groupCode") String groupCode);

    /**
     * @Title:
     * @Description:  根据用户组ID集合获取用户登录名
     * @param groupIds
     * @return
     * @throws
     * @author wangxue
     * @date 2018/04/26 04:51:56
     */
    List<String> selectSysUserNameByGroupIds(@Param("groupIds") List<String> groupIds);

    /**
     * 根据账号获取用户所属角色List
     * @param user
     * @return
     */
    List<String> selectRolesByUser(@Param("user") String user);
}
