package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysRoleMenu;
import cn.com.leadu.fms.pojo.system.vo.sysrolemenu.SysRoleMenuVo;
import cn.com.leadu.fms.system.validator.sysrolemenu.vo.SysRoleMenuDeleteListVo;
import cn.com.leadu.fms.system.validator.sysrolemenu.vo.SysRoleMenuDeleteVo;
import cn.com.leadu.fms.system.validator.sysrolemenu.vo.SysRoleMenuModifyVo;
import cn.com.leadu.fms.system.validator.sysrolemenu.vo.SysRoleMenuSaveVo;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SysRoleMenuService
 * @Description: 菜单角色设置业务层
 * @date 2018-03-15
 */
public interface SysRoleMenuService {

	/**
	 * @Title:
	 * @Description: 分页查询菜单角色设置
	 * @param sysRoleMenuVo
	 * @return PageInfoExtend<SysRoleMenu>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-15 10:47:40
	 */
	PageInfoExtend<SysRoleMenu> findSysRoleMenusByPage(SysRoleMenuVo sysRoleMenuVo);

	/**
	 * @Title:
	 * @Description: 保存菜单角色设置
	 * @param sysRoleMenuSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-15 10:47:40
	 */
    void saveSysRoleMenu(SysRoleMenuSaveVo sysRoleMenuSaveVo);


	/**
	 * @Title:
	 * @Description: 修改菜单角色设置
	 * @param sysRoleMenuModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-15 10:47:40
	 */
	void modifySysRoleMenu(SysRoleMenuModifyVo sysRoleMenuModifyVo);

	/**
	 * @Title:
	 * @Description:  通过roleMenuId删除菜单角色设置
	 * @param sysRoleMenuDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-15 10:47:40
	 */
	void deleteSysRoleMenu(SysRoleMenuDeleteVo sysRoleMenuDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过roleMenuId集合删除菜单角色设置
	 * @param sysRoleMenuDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-15 10:47:40
	 */
	void deleteSysRoleMenusByRoleMenuIds(SysRoleMenuDeleteListVo sysRoleMenuDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据roleMenuId获取菜单角色设置
	 * @param roleMenuId
	 * @return SysRoleMenu
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-15 10:47:40
	 */
	SysRoleMenu findSysRoleMenuByRoleMenuId(String roleMenuId);

	/**
	 *  根据角色重新分配菜单
	 * @param sysRoleMenus
	 */
	void updateSysRoleMenuByRoleId(List<SysRoleMenu> sysRoleMenus);


}
