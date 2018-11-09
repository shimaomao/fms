package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.SysGroupParent;
import cn.com.leadu.fms.pojo.system.vo.sysgroupparent.SysGroupParentVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: SysGroupParentRepository
 * @Description: 用户组关系Repository层
 * @date 2018-03-12
 */
public interface SysGroupParentRepository {

	/**
	 * @Title:
	 * @Description: 新增用户组关系
	 * @param sysGroupParent
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-12 15:41:14
	 */
	int insertData(SysGroupParent sysGroupParent);

	/**
	 * @Title:
	 * @Description: 批量保存用户组关系
	 * @param sysGroupParents
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-12 15:41:14
	 */
	int insertDataList(List<SysGroupParent> sysGroupParents);

	/**
	 *  根据条件删除
	 * @param example
	 * @param sysGroupParent
	 * @return
	 */
	int deleteExampleData(Example example,SysGroupParent sysGroupParent);
	/**
	 * @Title:
	 * @Description: 修改用户组关系
	 * @param sysGroupParent
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-12 15:41:14
	 */
	int updateByPrimaryKeyData(SysGroupParent sysGroupParent);

	/**
	 * @Title:
	 * @Description: 批量修改用户组关系
	 * @param sysGroupParents
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-12 15:41:14
	 */
	int updateByPrimaryKeyDataList(List<SysGroupParent> sysGroupParents);

	/**
	 * @Title:
	 * @Description: 动态修改用户组关系
	 * @param sysGroupParent
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-12 15:41:14
	 */
	int updateByPrimaryKeySelectiveData(SysGroupParent sysGroupParent);

	/**
	 * @Title:
	 * @Description: 批量动态修改用户组关系
	 * @param sysGroupParents
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-12 15:41:14
	 */
	int updateByPrimaryKeySelectiveDataList(List<SysGroupParent> sysGroupParents);

	/**
	 * @Title:
	 * @Description: 根据条件修改用户组关系
	 * @param sysGroupParent
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-12 15:41:14
	 */
	int updateByExampleData(SysGroupParent sysGroupParent, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改用户组关系
	 * @param sysGroupParent
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-12 15:41:14
	 */
	int updateByExampleSelectiveData(SysGroupParent sysGroupParent, Example example);

	/**
	 * @Title:
	 * @Description: 根据parentId删除用户组关系
	 * @param sysGroupParent
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-12 15:41:14
	 */
	int deleteData(SysGroupParent sysGroupParent);

	/**
	 * @Title:
	 * @Description: 根据parentId集合批量删除用户组关系
	 * @param parentIds
	 * @param sysGroupParent
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-12 15:41:14
	 */
	int deleteDataList(List parentIds, SysGroupParent sysGroupParent);

	/**
	 * @Title:
	 * @Description: 查询全部用户组关系
	 * @return List<SysGroupParent>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-12 15:41:14
	 */
	List<SysGroupParent> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个用户组关系
	 * @param example
	 * @return SysGroupParent
	 * @throws
	 * @author wangxue
	 * @date 2018-3-12 15:41:14
	 */
	SysGroupParent selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询用户组关系
	 * @param example
	 * @return List<SysGroupParent>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-12 15:41:14
	 */
	List<SysGroupParent> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过parentId查询用户组关系
	 * @param parentId
	 * @return SysGroupParent
	 * @throws
	 * @author wangxue
	 * @date 2018-3-12 15:41:14
	 */
	SysGroupParent selectByPrimaryKey(Object parentId);

	/**
	 * @Title:
	 * @Description: 分页查询用户组关系
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<SysGroupParent>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-12 15:41:14
	 */
	PageInfoExtend<SysGroupParent> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询用户组关系vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<SysGroupParent>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-12 15:41:14
	 */
	PageInfoExtend<SysGroupParent> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
