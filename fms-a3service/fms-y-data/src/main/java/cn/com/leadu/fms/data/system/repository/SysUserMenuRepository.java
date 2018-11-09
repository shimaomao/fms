package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.SysUserMenu;
import cn.com.leadu.fms.pojo.system.vo.sysusermenu.SysUserMenuVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SysUserMenuRepository
 * @Description: 用户角色设置Repository层
 * @date 2018-03-17
 */
public interface SysUserMenuRepository {

	/**
	 * @Title:
	 * @Description: 新增用户角色设置
	 * @param sysUserMenu
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-17 9:49:58
	 */
	int insertData(SysUserMenu sysUserMenu);

	/**
	 * @Title:
	 * @Description: 批量保存用户角色设置
	 * @param sysUserMenus
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-17 9:49:58
	 */
	int insertDataList(List<SysUserMenu> sysUserMenus);

	/**
	 * @Title:
	 * @Description: 修改用户角色设置
	 * @param sysUserMenu
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-17 9:49:58
	 */
	int updateByPrimaryKeyData(SysUserMenu sysUserMenu);

	/**
	 * @Title:
	 * @Description: 批量修改用户角色设置
	 * @param sysUserMenus
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-17 9:49:58
	 */
	int updateByPrimaryKeyDataList(List<SysUserMenu> sysUserMenus);

	/**
	 * @Title:
	 * @Description: 动态修改用户角色设置
	 * @param sysUserMenu
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-17 9:49:58
	 */
	int updateByPrimaryKeySelectiveData(SysUserMenu sysUserMenu);

	/**
	 * @Title:
	 * @Description: 批量动态修改用户角色设置
	 * @param sysUserMenus
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-17 9:49:58
	 */
	int updateByPrimaryKeySelectiveDataList(List<SysUserMenu> sysUserMenus);

	/**
	 * @Title:
	 * @Description: 根据条件修改用户角色设置
	 * @param sysUserMenu
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-17 9:49:58
	 */
	int updateByExampleData(SysUserMenu sysUserMenu, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改用户角色设置
	 * @param sysUserMenu
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-17 9:49:58
	 */
	int updateByExampleSelectiveData(SysUserMenu sysUserMenu, Example example);


	/**
	 *  根据条件删除
	 * @param example
	 * @param sysUserMenu
	 * @return
	 */
	int deleteExampleData(Example example,SysUserMenu sysUserMenu);
	/**
	 * @Title:
	 * @Description: 根据userMenuId删除用户角色设置
	 * @param sysUserMenu
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-17 9:49:58
	 */
	int deleteData(SysUserMenu sysUserMenu);

	/**
	 * @Title:
	 * @Description: 根据userMenuId集合批量删除用户角色设置
	 * @param userMenuIds
	 * @param sysUserMenu
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-17 9:49:58
	 */
	int deleteDataList(List userMenuIds, SysUserMenu sysUserMenu);

	/**
	 * @Title:
	 * @Description: 查询全部用户角色设置
	 * @return List<SysUserMenu>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-17 9:49:58
	 */
	List<SysUserMenu> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个用户角色设置
	 * @param example
	 * @return SysUserMenu
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-17 9:49:58
	 */
	SysUserMenu selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询用户角色设置
	 * @param example
	 * @return List<SysUserMenu>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-17 9:49:58
	 */
	List<SysUserMenu> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过userMenuId查询用户角色设置
	 * @param userMenuId
	 * @return SysUserMenu
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-17 9:49:58
	 */
	SysUserMenu selectByPrimaryKey(Object userMenuId);

	/**
	 * @Title:
	 * @Description: 分页查询用户角色设置
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<SysUserMenu>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-17 9:49:58
	 */
	PageInfoExtend<SysUserMenu> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询用户角色设置vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<SysUserMenu>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-17 9:49:58
	 */
	PageInfoExtend<SysUserMenu> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * 根据用户id删除菜单
	 * @param userId
	 * @return
	 */
	Integer deleteUserMenusByUserId( String userId);
}
