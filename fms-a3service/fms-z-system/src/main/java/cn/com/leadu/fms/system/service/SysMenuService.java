package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.common.vo.BootstrapTreeViewNodeVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysMenu;
import cn.com.leadu.fms.pojo.system.vo.sysmenu.SysMenuVo;
import cn.com.leadu.fms.system.validator.sysmenu.vo.SysMenuDeleteVo;
import cn.com.leadu.fms.system.validator.sysmenu.vo.SysMenuModifyVo;
import cn.com.leadu.fms.system.validator.sysmenu.vo.SysMenuSaveVo;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SysMenuService
 * @Description: 系统菜单业务层
 * @date 2018-03-07
 */
public interface SysMenuService {

	/**
	 * @Title:
	 * @Description: 保存系统菜单
	 * @param sysMenuSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-7 17:31:54
	 */
    void saveSysMenu(SysMenuSaveVo sysMenuSaveVo);


	/**
	 * @Title:
	 * @Description: 修改系统菜单
	 * @param sysMenuModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-7 17:31:54
	 */
	void modifySysMenu(SysMenuModifyVo sysMenuModifyVo);

	/**
	 * @Title:
	 * @Description:  通过id删除系统菜单
	 * @param sysMenuDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-7 17:31:54
	 */
	void deleteSysMenu(SysMenuDeleteVo sysMenuDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过id集合删除系统菜单
	 * @param sysMenuVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-7 17:31:54
	 */
	void deleteSysMenuByMenuIds(SysMenuVo sysMenuVo);



	/**
	 * @Title:
	 * @Description:  根据id系统菜单
	 * @param id
	 * @return SysMenu
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-7 17:31:54
	 */
	SysMenu findSysMenuByMenuId(String id);


	/**
	 * @Title:
	 * @Description: 根据菜单名称，上级菜单名称，菜单等级分页查询系统菜单
	 * @param sysMenuVo
	 * @return PageInfoExtend<SysMenu>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-7 17:31:54
	 */
    PageInfoExtend<SysMenuVo> findSysMenuVosByPage(SysMenuVo sysMenuVo);

	/**
	 * 根据菜单等级获取菜单
	 * @param menuLevel
	 * @return
	 */
	  List<SysMenu> findSysResourceIsParent(String menuLevel);

	/**
	 * 根据角色id获取菜单
	 * @param roleId
	 * @return
	 */

	List<BootstrapTreeViewNodeVo> findSysMenusByRoleId(String roleId);

	/**
	 * 根据用户id获取菜单
	 * @param userId
	 * @return
	 */

	List<BootstrapTreeViewNodeVo> findSysMenusByUserId(String userId);

	/**
	 * @Title:
	 * @Description: 根据用户id和菜单权限类型
	 * @param userId
	 * @param validMenuType
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/03/22 11:28:09
	 */
	List<SysMenu> findSysMenusByUserId(String userId, String validMenuType);

	/**
	 * @Title:
	 * @Description:   根据父级id获取下级菜单
	 * @param parMenuId
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/03/29 12:09:04
	 */
	List<SysMenu> findSysMenusByParMenuId(String parMenuId);

	/**
	 * 根据角色id获取所有菜单并勾选已有菜单
	 * @return
	 */
	List<BootstrapTreeViewNodeVo> findAllMenusByRoleId(String roleId);

	/**
	 * 根据用户id获取所有菜单并勾选已有菜单
	 * @return
	 */
	List<BootstrapTreeViewNodeVo> findAllMenusByUserId(String userId);
}
