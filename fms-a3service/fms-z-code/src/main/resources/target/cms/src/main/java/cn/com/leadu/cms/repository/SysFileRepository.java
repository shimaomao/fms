package cn.com.leadu.fms.data.repository;

import cn.com.leadu.fms.pojo.system.entity.SysFile;
import cn.com.leadu.fms.pojo.system.vo.sysfile.SysFileVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysFileRepository
 * @Description: 菜单Repository层
 * @date 2018-03-05
 */
public interface SysFileRepository {

	/**
	 * @Title:
	 * @Description: 新增菜单
	 * @param sysFile
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-5 15:17:52
	 */
	int insertData(SysFile sysFile);

	/**
	 * @Title:
	 * @Description: 批量保存菜单
	 * @param sysFiles
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-5 15:17:52
	 */
	int insertDataList(List<SysFile> sysFiles);

	/**
	 * @Title:
	 * @Description: 修改菜单
	 * @param sysFile
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-5 15:17:52
	 */
	int updateByPrimaryKeyData(SysFile sysFile);

	/**
	 * @Title:
	 * @Description: 批量修改菜单
	 * @param sysFiles
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-5 15:17:52
	 */
	int updateByPrimaryKeyDataList(List<SysFile> sysFiles);

	/**
	 * @Title:
	 * @Description: 动态修改菜单
	 * @param sysFile
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-5 15:17:52
	 */
	int updateByPrimaryKeySelectiveData(SysFile sysFile);

	/**
	 * @Title:
	 * @Description: 批量动态修改菜单
	 * @param sysFiles
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-5 15:17:52
	 */
	int updateByPrimaryKeySelectiveDataList(List<SysFile> sysFiles);

	/**
	 * @Title:
	 * @Description: 根据条件修改菜单
	 * @param sysFile
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-5 15:17:52
	 */
	int updateByExampleData(SysFile sysFile, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改菜单
	 * @param sysFile
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-5 15:17:52
	 */
	int updateByExampleSelectiveData(SysFile sysFile, Example example);

	/**
	 * @Title:
	 * @Description: 根据ID删除菜单
	 * @param sysFile
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-5 15:17:52
	 */
	int deleteData(SysFile sysFile);

	/**
	 * @Title:
	 * @Description: 根据ID集合批量删除菜单
	 * @param sysFile
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-5 15:17:52
	 */
	int deleteDataList(List ids,SysFile sysFile);

	/**
	 * @Title:
	 * @Description: 查询全部菜单
	 * @return List<SysFile>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-5 15:17:52
	 */
	List<SysFile> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个菜单
	 * @param example
	 * @return SysFile
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-5 15:17:52
	 */
	SysFile selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询菜单
	 * @param example
	 * @return List<SysFile>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-5 15:17:52
	 */
	List<SysFile> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过ID查询菜单
	 * @param id
	 * @return SysFile
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-5 15:17:52
	 */
	SysFile selectByPrimaryKey(Object id);

	/**
	 * @Title:
	 * @Description: 分页查询菜单
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<SysFile>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-5 15:17:52
	 */
	PageInfoExtend<SysFile> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询菜单vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<SysFile>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-3-5 15:17:52
	 */
	PageInfoExtend<SysFile> selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

}
