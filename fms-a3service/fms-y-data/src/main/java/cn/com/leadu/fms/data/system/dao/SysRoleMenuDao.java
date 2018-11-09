package cn.com.leadu.fms.data.system.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.system.entity.SysRoleMenu;

/**
 * @author ningyangyang
 * @ClassName: SysRoleMenuDao
 * @Description: 菜单角色设置dao层
 * @date 2018-03-15
 */
public interface SysRoleMenuDao extends BaseDao<SysRoleMenu> {

      Integer deleteRoleMenusByRoleId( String roleId);

     // Integer insertRoleMenuByRoleId(@Param("roleId") String roleId,@Param("menuIds") List<String> menuIds);
}