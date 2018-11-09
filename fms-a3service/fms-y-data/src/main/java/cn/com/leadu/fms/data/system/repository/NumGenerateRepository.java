package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.NumGenerate;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: NumGenerateRepository
 * @Description: 业务编号管理Repository层
 * @date 2018-03-26
 */
public interface NumGenerateRepository {

	/**
	 * @Title:
	 * @Description: 新增业务编号管理
	 * @param numGenerate
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 14:53:41
	 */
	int insertData(NumGenerate numGenerate);

	/**
	 * @Title:
	 * @Description: 批量保存业务编号管理
	 * @param numGenerates
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 14:53:41
	 */
	int insertDataList(List<NumGenerate> numGenerates);

	/**
	 * @Title:
	 * @Description: 修改业务编号管理
	 * @param numGenerate
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 14:53:41
	 */
	int updateByPrimaryKeyData(NumGenerate numGenerate);

	/**
	 * @Title:
	 * @Description: 批量修改业务编号管理
	 * @param numGenerates
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 14:53:41
	 */
	int updateByPrimaryKeyDataList(List<NumGenerate> numGenerates);

	/**
	 * @Title:
	 * @Description: 动态修改业务编号管理
	 * @param numGenerate
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 14:53:41
	 */
	int updateByPrimaryKeySelectiveData(NumGenerate numGenerate);

	/**
	 * @Title:
	 * @Description: 批量动态修改业务编号管理
	 * @param numGenerates
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 14:53:41
	 */
	int updateByPrimaryKeySelectiveDataList(List<NumGenerate> numGenerates);

	/**
	 * @Title:
	 * @Description: 根据条件修改业务编号管理
	 * @param numGenerate
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 14:53:41
	 */
	int updateByExampleData(NumGenerate numGenerate, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改业务编号管理
	 * @param numGenerate
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 14:53:41
	 */
	int updateByExampleSelectiveData(NumGenerate numGenerate, Example example);

	/**
	 * @Title:
	 * @Description: 根据numGenerateId删除业务编号管理
	 * @param numGenerate
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 14:53:41
	 */
	int deleteData(NumGenerate numGenerate);

	/**
	 * @Title:
	 * @Description: 根据numGenerateId集合批量删除业务编号管理
	 * @param numGenerateIds
	 * @param numGenerate
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 14:53:41
	 */
	int deleteDataList(List numGenerateIds, NumGenerate numGenerate);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除业务编号管理
	 * @param example
	 * @param numGenerate
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 14:53:41
	 */
	int deleteExampleData(Example example, NumGenerate numGenerate);

	/**
	 * @Title:
	 * @Description: 查询全部业务编号管理
	 * @return List<NumGenerate>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 14:53:41
	 */
	List<NumGenerate> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个业务编号管理
	 * @param example
	 * @return NumGenerate
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 14:53:41
	 */
	NumGenerate selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询业务编号管理
	 * @param example
	 * @return List<NumGenerate>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 14:53:41
	 */
	List<NumGenerate> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过numGenerateId查询业务编号管理
	 * @param numGenerateId
	 * @return NumGenerate
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 14:53:41
	 */
	NumGenerate selectByPrimaryKey(Object numGenerateId);

	/**
	 * @Title:
	 * @Description: 分页查询业务编号管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<NumGenerate>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 14:53:41
	 */
	PageInfoExtend<NumGenerate> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询业务编号管理vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<NumGenerate>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 14:53:41
	 */
	PageInfoExtend<NumGenerate> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);
	/**
	 * @Title:
	 * @Description: 取得当前号并Lock该行
	 * @param numType
	 * @return NumGenerate
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 14:53:41
	 */
	NumGenerate selectByNumTypeLock(String numType, String date);
}
