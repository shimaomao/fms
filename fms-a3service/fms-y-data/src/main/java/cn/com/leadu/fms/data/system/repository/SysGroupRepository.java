package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.SysGroup;
import cn.com.leadu.fms.pojo.system.vo.sysgroup.SysGroupDetailVo;
import cn.com.leadu.fms.pojo.system.vo.sysgroup.SysGroupVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.vo.sysgroupparent.SysGroupParentVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: SysGroupRepository
 * @Description: 用户组管理Repository层
 * @date 2018-03-10
 */
public interface SysGroupRepository {

	/**
	 * @Title:
	 * @Description: 新增用户组管理
	 * @param sysGroup
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	int insertData(SysGroup sysGroup);

	/**
	 * @Title:
	 * @Description: 批量保存用户组管理
	 * @param sysGroups
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	int insertDataList(List<SysGroup> sysGroups);

	/**
	 * @Title:
	 * @Description: 修改用户组管理
	 * @param sysGroup
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	int updateByPrimaryKeyData(SysGroup sysGroup);

	/**
	 * @Title:
	 * @Description: 批量修改用户组管理
	 * @param sysGroups
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	int updateByPrimaryKeyDataList(List<SysGroup> sysGroups);

	/**
	 * @Title:
	 * @Description: 动态修改用户组管理
	 * @param sysGroup
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	int updateByPrimaryKeySelectiveData(SysGroup sysGroup);

	/**
	 * @Title:
	 * @Description: 批量动态修改用户组管理
	 * @param sysGroups
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	int updateByPrimaryKeySelectiveDataList(List<SysGroup> sysGroups);

	/**
	 * @Title:
	 * @Description: 根据条件修改用户组管理
	 * @param sysGroup
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	int updateByExampleData(SysGroup sysGroup, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改用户组管理
	 * @param sysGroup
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	int updateByExampleSelectiveData(SysGroup sysGroup, Example example);

	/**
	 * @Title:
	 * @Description: 根据groupId删除用户组管理
	 * @param sysGroup
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	int deleteData(SysGroup sysGroup);

	/**
	 * @Title:
	 * @Description: 根据groupId集合批量删除用户组管理
	 * @param groupIds
	 * @param sysGroup
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	int deleteDataList(List groupIds, SysGroup sysGroup);

	/**
	 * @Title:
	 * @Description: 查询全部用户组管理
	 * @return List<SysGroup>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	List<SysGroup> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个用户组管理
	 * @param example
	 * @return SysGroup
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	SysGroup selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询用户组管理
	 * @param example
	 * @return List<SysGroup>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	List<SysGroup> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过groupId查询用户组管理
	 * @param groupId
	 * @return SysGroup
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	SysGroup selectByPrimaryKey(Object groupId);

	/**
	 * @Title:
	 * @Description: 分页查询用户组管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<SysGroup>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	PageInfoExtend<SysGroup> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询用户组管理vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<SysGroupVo>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	PageInfoExtend<SysGroupVo> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 根据用户ID,获取有下级用户组的用户组信息的总件数
	 * @param groupIds 查询参数
	 * @return long
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	Long selectParentGroupCountByGroupIds(List<String> groupIds);

	/**
	 * @Title:
	 * @Description: 根据用户组代码,获取上级用户组信息
	 * @param groupCode 用户组代码
	 * @return List
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	List<SysGroupParentVo> selectParentGroupsByGroup(String groupCode);

	/**
	 * @Title:
	 * @Description: 根据组织类型，取得用户组信息树
	 * @param parentType 组织类型
	 * @return long
	 * @throws
	 * @author wangxue
	 * @date 2018-3-13 17:39:58
	 */
	List<SysGroupVo> selectSysGroupVosByTree(String parentType);

	/**
	 * @Title:
	 * @Description: 根据用户组ID，取得用户组信息
	 * @param groupId 用户组Id
	 * @return SysGroupDetailVo
	 * @throws
	 * @author wangxue
	 * @date 2018-3-14 14:39:58
	 */
	SysGroupDetailVo selectSysGroupVoByGroupId(String groupId);

	/**
	 * @Title:
	 * @Description: 根据經銷商代碼，获取用户组信息
	 * @param example 条件
	 * @throws
	 * @author wangxue
	 * @date 2018-3-14 14:39:58
	 */
	SysGroup selectSysGroupVoByGroupCode(Example example);

	/**
	 * @Title:
	 * @Description: 根据用户组ID，取得用户组信息
	 * @param groupIds 用户组Id
	 * @return List<String>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-20 14:39:58
	 */
	List<String> selectParentIdsByGroupIds(List<String> groupIds);
}
