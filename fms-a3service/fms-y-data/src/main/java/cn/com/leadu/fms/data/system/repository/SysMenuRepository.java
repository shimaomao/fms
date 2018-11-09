package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.SysMenu;
import cn.com.leadu.fms.pojo.system.vo.sysmenu.SysMenuVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SysMenuRepository
 * @Description: 系统菜单Repository层
 * @date 2018-03-07
 */
public interface SysMenuRepository {

	/**
	 * @Title:
	 * @Description: 新增系统菜单
	 * @param sysMenu
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-7 17:31:54
	 */
	int insertData(SysMenu sysMenu);

	/**
	 * @Title:
	 * @Description: 批量保存系统菜单
	 * @param sysMenus
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-7 17:31:54
	 */
	int insertDataList(List<SysMenu> sysMenus);

	/**
	 * @Title:
	 * @Description: 修改系统菜单
	 * @param sysMenu
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-7 17:31:54
	 */
	int updateByPrimaryKeyData(SysMenu sysMenu);

	/**
	 * @Title:
	 * @Description: 批量修改系统菜单
	 * @param sysMenus
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-7 17:31:54
	 */
	int updateByPrimaryKeyDataList(List<SysMenu> sysMenus);

	/**
	 * @Title:
	 * @Description: 动态修改系统菜单
	 * @param sysMenu
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-7 17:31:54
	 */
	int updateByPrimaryKeySelectiveData(SysMenu sysMenu);

	/**
	 * @Title:
	 * @Description: 批量动态修改系统菜单
	 * @param sysMenus
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-7 17:31:54
	 */
	int updateByPrimaryKeySelectiveDataList(List<SysMenu> sysMenus);

	/**
	 * @Title:
	 * @Description: 根据条件修改系统菜单
	 * @param sysMenu
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-7 17:31:54
	 */
	int updateByExampleData(SysMenu sysMenu, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改系统菜单
	 * @param sysMenu
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-7 17:31:54
	 */
	int updateByExampleSelectiveData(SysMenu sysMenu, Example example);

	/**
	 * @Title:
	 * @Description: 根据ID删除系统菜单
	 * @param sysMenu
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-7 17:31:54
	 */
	int deleteData(SysMenu sysMenu);

	/**
	 * @Title:
	 * @Description: 根据ID集合批量删除系统菜单
	 * @param sysMenu
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-7 17:31:54
	 */
	int deleteDataList(List ids, SysMenu sysMenu);

	/**
	 * @Title:
	 * @Description: 查询全部系统菜单
	 * @return List<SysMenu>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-7 17:31:54
	 */
	List<SysMenu> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个系统菜单
	 * @param example
	 * @return SysMenu
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-7 17:31:54
	 */
	SysMenu selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询系统菜单
	 * @param example
	 * @return List<SysMenu>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-7 17:31:54
	 */
	List<SysMenu> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过ID查询系统菜单
	 * @param id
	 * @return SysMenu
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-7 17:31:54
	 */
	SysMenu selectByPrimaryKey(Object id);

	/**
	 * @Title:
	 * @Description: 分页查询系统菜单
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<SysMenu>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-7 17:31:54
	 */
	PageInfoExtend<SysMenu> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询系统菜单vo
	 * @param sysMenuVo
	 * @param pageQuery
	 * @return PageInfoExtend<SysMenu>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-7 17:31:54
	 */
	PageInfoExtend<SysMenuVo> selectListVoByPage(String methodName, SysMenuVo sysMenuVo, PageQuery pageQuery);

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
	List<SysMenu> selectSysMenusByRoleIds(List<String> roleIds);

}
