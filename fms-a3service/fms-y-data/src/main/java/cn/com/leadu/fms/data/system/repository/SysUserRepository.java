package cn.com.leadu.fms.data.system.repository;


import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysUserRepository
 * @Description: 系统用户数据操作层
 * @date 2018/1/9
 */

public interface SysUserRepository {

    /**
     * @Title:
     * @Description: 保存用户信息
     * @param sysUser
     * @return String
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 10:26:22
     */
    String insertData(SysUser sysUser);

    /**
     * @Title:
     * @Description:  通过条件批量查询
     * @param example
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 04:23:21
     */
    List<SysUser> selectListByExample(Example example);

    /**
     * @Title:
     * @Description: 分页查询
     * @param example,pageQuery
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 04:49:17
     */
    PageInfoExtend selectListByExamplePage(Example example, PageQuery pageQuery);

    /**
     * @Title:
     * @Description:  更新用户
     * @param sysUser
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:53:16
     */
    void updateByPrimaryKeySelectiveData(SysUser sysUser);

    /**
     * @Title:
     * @Description: 根据条件动态修改用户
     * @param sysUser
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-4-4 15:16:18
     */
    int updateByExampleSelectiveData(SysUser sysUser, Example example);

    /**
     * @Title:
     * @Description:  删除用户
     * @param sysUser
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 05:53:28
     */
    void deleteData(SysUser sysUser);


    /**
     * @Title:
     * @Description:  根据id获取用户
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/11 06:31:34
     */
    SysUser selectByPrimaryKey(Object id);


    /**
     * @Title:
     * @Description:  根据ids批量删除
     * @param ids
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/17 03:28:23
     */
    void deleteDataList(List ids,SysUser sysUser);

    /**
     * @Title:
     * @Description:   根据用户id获取用户vo详细信息
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/01 09:59:08
     */
    SysUserVo selectSysUserVoById(Object id);

    /**
     * @Title:
     * @Description:   分页查询用户vo
     * @param sysUserVo
     * @param pageQuery
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/12 04:48:41
     */
    PageInfoExtend selectSysUserVoByPage(SysUserVo sysUserVo,PageQuery pageQuery);

    /**
     * @Title:
     * @Description:   根据groupCode查询用户登录名集合
     * @param groupCode
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 04:41:50
     */
    List<String> selectSysUserLoginNamesByGroupCode(String groupCode);

    /**
     * @Title:
     * @Description:   根据groupCode集合查询用户登录名集合
     * @param groupCodes
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 04:41:50
     */
    List<String> selectSysUserLoginNamesByGroupCodes(List<String> groupCodes);

    /**
     * @Title:
     * @Description:   根据roleId查询用户登录名集合
     * @param role
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 04:51:56
     */
    List<String> selectSysUserLoginNamesByRole(String role);

    /**
     * @Title:
     * @Description:   根据roleId查询用户登录名集合
     * @param roles
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/08 04:51:56
     */
    List<String> selectSysUserLoginNamesByRoles(List<String> roles);

    /** 
    * @Description: 根据roleId集合和组织机构代码查询用户登录名集合
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/12 15:32
    */ 
    List<String> findSysUserLoginNamesByRolesWithGroupCode(List<String> roles, String groupCode);

    /**
     * @Title:
     * @Description:  根据用户组ID集合获取用户登录名
     * @param groupIds
     * @return
     * @throws
     * @author wangxue
     * @date 2018/04/26 04:51:56
     */
    List<String> selectSysUserNameByGroupIds(List<String> groupIds);

    /**
     * @Title:
     * @Description: 通过条件查询一个用户
     * @param example
     * @return SysUser
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    SysUser selectOneByExample(Example example);

    /**
     * 根据账号获取用户所属角色List
     * @param user
     * @return
     */
    List<String> selectRolesByUser(String user);
}
