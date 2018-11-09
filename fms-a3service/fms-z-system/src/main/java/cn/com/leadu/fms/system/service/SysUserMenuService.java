package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysUserMenu;
import cn.com.leadu.fms.pojo.system.vo.sysusermenu.SysUserMenuVo;
import cn.com.leadu.fms.system.validator.sysusermenu.vo.SysUserMenuDeleteListVo;
import cn.com.leadu.fms.system.validator.sysusermenu.vo.SysUserMenuDeleteVo;
import cn.com.leadu.fms.system.validator.sysusermenu.vo.SysUserMenuModifyVo;
import cn.com.leadu.fms.system.validator.sysusermenu.vo.SysUserMenuSaveVo;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SysUserMenuService
 * @Description: 用户角色设置业务层
 * @date 2018-03-17
 */
public interface SysUserMenuService {

	/**
	 * @Title:
	 * @Description: 分页查询用户角色设置
	 * @param sysUserMenuVo
	 * @return PageInfoExtend<SysUserMenu>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-17 9:49:59
	 */
	PageInfoExtend<SysUserMenu> findSysUserMenusByPage(SysUserMenuVo sysUserMenuVo);

	/**
	 * @Title:
	 * @Description: 保存用户角色设置
	 * @param sysUserMenuSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-17 9:49:59
	 */
    void saveSysUserMenu(SysUserMenuSaveVo sysUserMenuSaveVo);


	/**
	 * @Title:
	 * @Description: 修改用户角色设置
	 * @param sysUserMenuModifyVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-17 9:49:59
	 */
	void modifySysUserMenu(SysUserMenuModifyVo sysUserMenuModifyVo);

	/**
	 * @Title:
	 * @Description:  通过userMenuId删除用户角色设置
	 * @param sysUserMenuDeleteVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-17 9:49:59
	 */
	void deleteSysUserMenu(SysUserMenuDeleteVo sysUserMenuDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过userMenuId集合删除用户角色设置
	 * @param sysUserMenuDeleteListVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-17 9:49:59
	 */
	void deleteSysUserMenusByUserMenuIds(SysUserMenuDeleteListVo sysUserMenuDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据userMenuId获取用户角色设置
	 * @param userMenuId
	 * @return SysUserMenu
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-17 9:49:59
	 */
	SysUserMenu findSysUserMenuByUserMenuId(String userMenuId);

	/**
	 *  根据用户重新分配菜单
	 * @param sysUserMenus
	 */
	void updateSysUserMenuByUserId(List<SysUserMenu> sysUserMenus);
}
