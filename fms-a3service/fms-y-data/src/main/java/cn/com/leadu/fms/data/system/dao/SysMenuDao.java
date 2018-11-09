package cn.com.leadu.fms.data.system.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.system.entity.SysMenu;
import cn.com.leadu.fms.pojo.system.entity.SysRole;
import cn.com.leadu.fms.pojo.system.vo.sysmenu.SysMenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SysMenuDao
 * @Description: 系统菜单dao层
 * @date 2018-03-07
 */
public interface SysMenuDao extends BaseDao<SysMenu> {
      /**
       * 分页获取菜单信息
       * @param sysMenuVo
       * @return
       */
      List<SysMenuVo> selectSysMenuVosByPage(@Param("sysMenuVo") SysMenuVo sysMenuVo);

      /**
       * 根据角色id获取菜单
       * @param roleId
       * @return
       */
      List<SysMenu> selectSysMenusByRoleId(String roleId);

      /**
       * 根据用户id获取菜单
       * @param userId
       * @return
       */
      List<SysMenu> selectSysMenusByUserId(String userId);

      /**
       * @Title:
       * @Description:   根据角色id集合获取对应菜单信息
       * @param roleIds
       * @return
       * @throws
       * @author qiaomengnan
       * @date 2018/03/22 02:08:12
       */
      List<SysMenu> selectSysMenusByRoleIds(@Param("roleIds") List<String> roleIds);

}