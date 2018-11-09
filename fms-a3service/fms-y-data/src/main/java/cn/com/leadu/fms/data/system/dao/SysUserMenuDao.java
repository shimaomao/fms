package cn.com.leadu.fms.data.system.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.system.entity.SysUserMenu;

/**
 * @author ningyangyang
 * @ClassName: SysUserMenuDao
 * @Description: 用户角色设置dao层
 * @date 2018-03-17
 */
public interface SysUserMenuDao extends BaseDao<SysUserMenu> {

    Integer deleteUserMenusByUserId( String userId);
}