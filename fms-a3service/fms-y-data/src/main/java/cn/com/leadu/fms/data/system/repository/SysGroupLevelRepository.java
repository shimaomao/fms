package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.SysGroupLevel;
import cn.com.leadu.fms.pojo.system.vo.sysgrouplevel.SysGroupLevelVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: SysGroupLevelRepository
 * @Description: 用户组层级Repository层
 * @date 2018-03-08
 */
public interface SysGroupLevelRepository {

	/**
	 * @Title:
	 * @Description: 新增用户组层级
	 * @param sysGroupLevel
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-8 14:36:06
	 */
	int insertData(SysGroupLevel sysGroupLevel);

	/**
	 * @Title:
	 * @Description: 批量保存用户组层级
	 * @param sysGroupLevels
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-8 14:36:06
	 */
	int insertDataList(List<SysGroupLevel> sysGroupLevels);

	/**
	 * @Title:
	 * @Description: 修改用户组层级
	 * @param sysGroupLevel
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-8 14:36:06
	 */
	int updateByPrimaryKeyData(SysGroupLevel sysGroupLevel);

	/**
	 * @Title:
	 * @Description: 批量修改用户组层级
	 * @param sysGroupLevels
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-8 14:36:06
	 */
	int updateByPrimaryKeyDataList(List<SysGroupLevel> sysGroupLevels);

	/**
	 * @Title:
	 * @Description: 动态修改用户组层级
	 * @param sysGroupLevel
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-8 14:36:06
	 */
	int updateByPrimaryKeySelectiveData(SysGroupLevel sysGroupLevel);

	/**
	 * @Title:
	 * @Description: 批量动态修改用户组层级
	 * @param sysGroupLevels
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-8 14:36:06
	 */
	int updateByPrimaryKeySelectiveDataList(List<SysGroupLevel> sysGroupLevels);

	/**
	 * @Title:
	 * @Description: 根据条件修改用户组层级
	 * @param sysGroupLevel
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-8 14:36:06
	 */
	int updateByExampleData(SysGroupLevel sysGroupLevel, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改用户组层级
	 * @param sysGroupLevel
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-8 14:36:06
	 */
	int updateByExampleSelectiveData(SysGroupLevel sysGroupLevel, Example example);

	/**
	 * @Title:
	 * @Description: 根据ID删除用户组层级
	 * @param sysGroupLevel
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-8 14:36:06
	 */
	int deleteData(SysGroupLevel sysGroupLevel);

	/**
	 * @Title:
	 * @Description: 根据ID集合批量删除用户组层级
	 * @param sysGroupLevel
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-8 14:36:06
	 */
	int deleteDataList(List ids, SysGroupLevel sysGroupLevel);

	/**
	 * @Title:
	 * @Description: 查询全部用户组层级
	 * @return List<SysGroupLevel>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-8 14:36:06
	 */
	List<SysGroupLevel> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个用户组层级
	 * @param example
	 * @return SysGroupLevel
	 * @throws
	 * @author wangxue
	 * @date 2018-3-8 14:36:06
	 */
	SysGroupLevel selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询用户组层级
	 * @param example
	 * @return List<SysGroupLevel>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-8 14:36:06
	 */
	List<SysGroupLevel> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过ID查询用户组层级
	 * @param id
	 * @return SysGroupLevel
	 * @throws
	 * @author wangxue
	 * @date 2018-3-8 14:36:06
	 */
	SysGroupLevel selectByPrimaryKey(Object id);

	/**
	 * @Title:
	 * @Description: 分页查询用户组层级
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<SysGroupLevel>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-8 14:36:06
	 */
	PageInfoExtend<SysGroupLevel> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询用户组层级vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<SysGroupLevel>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-8 14:36:06
	 */
	PageInfoExtend<SysGroupLevel> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
