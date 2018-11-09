package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.pojo.system.entity.SysGroupParent;

import java.util.List;

/**
 * @author wangxue
 * @ClassName: SysGroupParentService
 * @Description: 用户组关系业务层
 * @date 2018-03-12
 */
public interface SysGroupParentService {

	/**
	 * @Title:
	 * @Description: 根据用户组代码，获取全部用户组关系
	 * @param groupCode
	 * @return List
	 * @throws
	 * @author wangxue
	 * @date 2018-3-12 15:41:14
	 */
	List<SysGroupParent> findSysGroupParentsByGroup(String groupCode);

	/**
	 * @Title:
	 * @Description: 保存用户组关系
	 * @param sysGroupParent
	 * @return java.lang.String
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-29 15:41:14
	 */

    void saveSysGroupParent(SysGroupParent sysGroupParent);
	/**
	 * @Title:
	 * @Description: 保存用户组关系List
	 * @param sysGroupParentList
	 * @return java.lang.String
	 * @throws
	 * @author wangxue
	 * @date 2018-3-12 15:41:14
	 */
	void saveSysGroupParents(List<SysGroupParent> sysGroupParentList);

	/**
	 * @Title:
	 * @Description: 修改用户组关系List
	 * @param sysGroupParentList
	 * @return java.lang.String
	 * @throws
	 * @author wangxue
	 * @date 2018-3-12 15:41:14
	 */
	void modifySysGroupParents(List<SysGroupParent> sysGroupParentList);

	/**
	 * @Title:
	 * @Description:  通过parentId集合删除用户组关系
	 * @param parentIds
	 * @return
	 * @throws
	 * @author wangxue
	 * @date 2018-3-12 15:41:14
	 */
	void deleteSysGroupParentsByParentIds(List<String> parentIds);

	/**
	 * @Title:
	 * @Description:  通过code删除
	 * @param groupCode
	 * @return
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-12 15:41:14
	 */
	void deleteSysGroupParentByGroupCode(String groupCode);

	/**
	 * @Title:
	 * @Description:  通过条件查询组织关系
	 * @param groupCode
	 * @return
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-12 15:41:14
	 */
	SysGroupParent findSysGroupParentsByGroupCode(String groupCode);

	/**
	 * @Title:
	 * @Description:  通过id修改信息
	 * @param sysGroupParent
	 * @return
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-12 15:41:14
	 */
	void modifySysGroupParent(SysGroupParent sysGroupParent);
}
