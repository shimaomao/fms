package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.SysRole;
import cn.com.leadu.fms.pojo.system.entity.SysRoleMenu;
import cn.com.leadu.fms.pojo.system.vo.sysrolemenu.SysRoleMenuVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SysRoleMenuRepository
 * @Description: 菜单角色设置Repository层
 * @date 2018-03-15
 */
public interface SysRoleMenuRepository {

	/**
	 * @Title:
	 * @Description: 新增菜单角色设置
	 * @param sysRoleMenu
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-15 10:47:40
	 */
	int insertData(SysRoleMenu sysRoleMenu);

	/**
	 * @Title:
	 * @Description: 批量保存菜单角色设置
	 * @param sysRoleMenus
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-15 10:47:40
	 */
	int insertDataList(List<SysRoleMenu> sysRoleMenus);

	/**
	 * @Title:
	 * @Description: 修改菜单角色设置
	 * @param sysRoleMenu
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-15 10:47:40
	 */
	int updateByPrimaryKeyData(SysRoleMenu sysRoleMenu);

	/**
	 * @Title:
	 * @Description: 批量修改菜单角色设置
	 * @param sysRoleMenus
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-15 10:47:40
	 */
	int updateByPrimaryKeyDataList(List<SysRoleMenu> sysRoleMenus);

	/**
	 * @Title:
	 * @Description: 动态修改菜单角色设置
	 * @param sysRoleMenu
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-15 10:47:40
	 */
	int updateByPrimaryKeySelectiveData(SysRoleMenu sysRoleMenu);

	/**
	 * @Title:
	 * @Description: 批量动态修改菜单角色设置
	 * @param sysRoleMenus
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-15 10:47:40
	 */
	int updateByPrimaryKeySelectiveDataList(List<SysRoleMenu> sysRoleMenus);

	/**
	 * @Title:
	 * @Description: 根据条件修改菜单角色设置
	 * @param sysRoleMenu
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-15 10:47:40
	 */
	int updateByExampleData(SysRoleMenu sysRoleMenu, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改菜单角色设置
	 * @param sysRoleMenu
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-15 10:47:40
	 */
	int updateByExampleSelectiveData(SysRoleMenu sysRoleMenu, Example example);

	/**
	 * @Title:
	 * @Description: 根据roleMenuId删除菜单角色设置
	 * @param sysRoleMenu
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-15 10:47:40
	 */
	int deleteData(SysRoleMenu sysRoleMenu);

	/**
	 * @Title:
	 * @Description:   根据条件删除
	 * @param example
	 * @param sysRoleMenu
	 * @return
	 * @throws
	 *
	 * @author QianHuaSheng
	 * @date 2018/03/21 02:28:57
	 */
	int deleteExampleData(Example example,SysRoleMenu sysRoleMenu);

	/**
	 * @Title:
	 * @Description: 根据roleMenuId集合批量删除菜单角色设置
	 * @param roleMenuIds
	 * @param sysRoleMenu
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-15 10:47:40
	 */
	int deleteDataList(List roleMenuIds, SysRoleMenu sysRoleMenu);

	/**
	 * @Title:
	 * @Description: 查询全部菜单角色设置
	 * @return List<SysRoleMenu>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-15 10:47:40
	 */
	List<SysRoleMenu> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个菜单角色设置
	 * @param example
	 * @return SysRoleMenu
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-15 10:47:40
	 */
	SysRoleMenu selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询菜单角色设置
	 * @param example
	 * @return List<SysRoleMenu>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-15 10:47:40
	 */
	List<SysRoleMenu> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过roleMenuId查询菜单角色设置
	 * @param roleMenuId
	 * @return SysRoleMenu
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-15 10:47:40
	 */
	SysRoleMenu selectByPrimaryKey(Object roleMenuId);

	/**
	 * @Title:
	 * @Description: 分页查询菜单角色设置
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<SysRoleMenu>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-15 10:47:40
	 */
	PageInfoExtend<SysRoleMenu> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询菜单角色设置vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<SysRoleMenu>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-15 10:47:40
	 */
	PageInfoExtend<SysRoleMenu> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * 根据id删除角色菜单表内容
	 * @param roleId
	 * @return
	 */
	Integer deleteRoleMenusByRoleId( String roleId);

	//Integer insertRoleMenuByRoleId(String roleId,List<String> menuIds);
}
