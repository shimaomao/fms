package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.SysCodeType;
import cn.com.leadu.fms.pojo.system.vo.syscodetype.SysCodeTypeVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author huchenghao
 * @ClassName: SysCodeTypeRepository
 * @Description: 字典数据类型Repository层
 * @date 2018-03-08
 */
public interface SysCodeTypeRepository {

	/**
	 * @Title:
	 * @Description: 新增字典数据类型
	 * @param sysCodeType
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-8 15:35:57
	 */
	int insertData(SysCodeType sysCodeType);

	/**
	 * @Title:
	 * @Description: 批量保存字典数据类型
	 * @param sysCodeTypes
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-8 15:35:57
	 */
	int insertDataList(List<SysCodeType> sysCodeTypes);

	/**
	 * @Title:
	 * @Description: 修改字典数据类型
	 * @param sysCodeType
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-8 15:35:57
	 */
	int updateByPrimaryKeyData(SysCodeType sysCodeType);

	/**
	 * @Title:
	 * @Description: 批量修改字典数据类型
	 * @param sysCodeTypes
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-8 15:35:57
	 */
	int updateByPrimaryKeyDataList(List<SysCodeType> sysCodeTypes);

	/**
	 * @Title:
	 * @Description: 动态修改字典数据类型
	 * @param sysCodeType
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-8 15:35:57
	 */
	int updateByPrimaryKeySelectiveData(SysCodeType sysCodeType);

	/**
	 * @Title:
	 * @Description: 批量动态修改字典数据类型
	 * @param sysCodeTypes
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-8 15:35:57
	 */
	int updateByPrimaryKeySelectiveDataList(List<SysCodeType> sysCodeTypes);

	/**
	 * @Title:
	 * @Description: 根据条件修改字典数据类型
	 * @param sysCodeType
	 * @param example
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-8 15:35:57
	 */
	int updateByExampleData(SysCodeType sysCodeType, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改字典数据类型
	 * @param sysCodeType
	 * @param example
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-8 15:35:57
	 */
	int updateByExampleSelectiveData(SysCodeType sysCodeType, Example example);

	/**
	 * @Title:
	 * @Description: 根据ID删除字典数据类型
	 * @param sysCodeType
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-8 15:35:57
	 */
	int deleteData(SysCodeType sysCodeType);

	/**
	 * @Title:
	 * @Description: 根据ID集合批量删除字典数据类型
	 * @param sysCodeType
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-8 15:35:57
	 */
	int deleteDataList(List ids, SysCodeType sysCodeType);
	/**
	 * @Title:
	 * @Description: 虚拟删除 根据定义的列名删除
	 * @param ids
	 * @param sysCodeType
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:53
	 */
	int deleteByIds(List ids,SysCodeType sysCodeType,String primaryKey);

	/**
	 *  根据条件删除
	 * @param example
	 * @param sysCodeType
	 * @return
	 */
	int deleteExampleData(Example example,SysCodeType sysCodeType);

	/**
	 * @Title:
	 * @Description: 查询全部字典数据类型
	 * @return List<SysCodeType>
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-8 15:35:57
	 */
	List<SysCodeType> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个字典数据类型
	 * @param example
	 * @return SysCodeType
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-8 15:35:57
	 */
	SysCodeType selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询字典数据类型
	 * @param example
	 * @return List<SysCodeType>
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-8 15:35:57
	 */
	List<SysCodeType> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过ID查询字典数据类型
	 * @param id
	 * @return SysCodeType
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-8 15:35:57
	 */
	SysCodeType selectByPrimaryKey(Object id);

	/**
	 * @Title:
	 * @Description: 分页查询字典数据类型
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<SysCodeType>
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-8 15:35:57
	 */
	PageInfoExtend<SysCodeType> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询字典数据类型vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<SysCodeType>
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-8 15:35:57
	 */
	PageInfoExtend<SysCodeType> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
