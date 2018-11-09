package cn.com.leadu.fms.data.system.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.system.entity.SysRole;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysRoleDao
 * @Description: 角色dao
 * @date 2018/1/12
 */
public interface SysRoleDao extends BaseDao<SysRole> {
    /**
     * 根据用户id获取角色集合
     * @param userId
     * @return
     */
    List<SysRole> selectSysRolesBySysUserId(String userId);

    /**
     * 根据用户id获取角色id集合
     * @param userId
     * @return
     */
    List<String> selectSysRoleIdsBySysUserId(String userId);

}
