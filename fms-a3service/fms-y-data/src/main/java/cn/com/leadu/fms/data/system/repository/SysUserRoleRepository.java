package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.SysUserRole;
import cn.com.leadu.fms.pojo.system.vo.sysuserrole.SysUserRoleVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: SysUserRoleRepository
 * @Description: 用户角色管理Repository层
 * @date 2018-03-22
 */
public interface SysUserRoleRepository {

	/**
	 * @Title:
	 * @Description: 新增用户角色管理
	 * @param sysUserRole
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-22 11:15:21
	 */
	int insertData(SysUserRole sysUserRole);

	/**
	 * @Title:
	 * @Description: 批量保存用户角色管理
	 * @param sysUserRoles
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-22 11:15:21
	 */
	int insertDataList(List<SysUserRole> sysUserRoles);

	/**
	 * @Title:
	 * @Description: 修改用户角色管理
	 * @param sysUserRole
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-22 11:15:21
	 */
	int updateByPrimaryKeyData(SysUserRole sysUserRole);

	/**
	 * @Title:
	 * @Description: 批量修改用户角色管理
	 * @param sysUserRoles
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-22 11:15:21
	 */
	int updateByPrimaryKeyDataList(List<SysUserRole> sysUserRoles);

	/**
	 * @Title:
	 * @Description: 动态修改用户角色管理
	 * @param sysUserRole
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-22 11:15:21
	 */
	int updateByPrimaryKeySelectiveData(SysUserRole sysUserRole);

	/**
	 * @Title:
	 * @Description: 批量动态修改用户角色管理
	 * @param sysUserRoles
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-22 11:15:21
	 */
	int updateByPrimaryKeySelectiveDataList(List<SysUserRole> sysUserRoles);

	/**
	 * @Title:
	 * @Description: 根据条件修改用户角色管理
	 * @param sysUserRole
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-22 11:15:21
	 */
	int updateByExampleData(SysUserRole sysUserRole, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改用户角色管理
	 * @param sysUserRole
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-22 11:15:21
	 */
	int updateByExampleSelectiveData(SysUserRole sysUserRole, Example example);

	/**
	 * @Title:
	 * @Description: 根据userId删除用户角色管理
	 * @param sysUserRole
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-22 11:15:21
	 */
	int deleteData(SysUserRole sysUserRole);

	/**
	 * @Title:
	 * @Description: 根据userId集合批量删除用户角色管理
	 * @param userIds
	 * @param sysUserRole
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-22 11:15:21
	 */
	int deleteDataList(List userIds, SysUserRole sysUserRole);
	/**
	 *  根据条件删除
	 * @param example
	 * @param sysUserRole
	 * @return
	 */
	 int deleteExampleData(Example example,SysUserRole sysUserRole);
	/**
	 * @Title:
	 * @Description: 查询全部用户角色管理
	 * @return List<SysUserRole>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-22 11:15:21
	 */
	List<SysUserRole> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个用户角色管理
	 * @param example
	 * @return SysUserRole
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-22 11:15:21
	 */
	SysUserRole selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询用户角色管理
	 * @param example
	 * @return List<SysUserRole>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-22 11:15:21
	 */
	List<SysUserRole> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过userId查询用户角色管理
	 * @param userId
	 * @return SysUserRole
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-22 11:15:21
	 */
	SysUserRole selectByPrimaryKey(Object userId);

	/**
	 * @Title:
	 * @Description: 分页查询用户角色管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<SysUserRole>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-22 11:15:21
	 */
	PageInfoExtend<SysUserRole> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询用户角色管理vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<SysUserRole>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-22 11:15:21
	 */
	PageInfoExtend<SysUserRole> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
