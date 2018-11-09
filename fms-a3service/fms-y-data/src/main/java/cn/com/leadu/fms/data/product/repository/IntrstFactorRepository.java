package cn.com.leadu.fms.data.product.repository;

import cn.com.leadu.fms.pojo.product.entity.IntrstFactor;
import cn.com.leadu.fms.pojo.product.vo.intrstfactor.IntrstFactorVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: IntrstFactorRepository
 * @Description: 利率因子Repository层
 * @date 2018-03-27
 */
public interface IntrstFactorRepository {

	/**
	 * @Title:
	 * @Description: 新增利率因子
	 * @param intrstFactor
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 20:08:11
	 */
	int insertData(IntrstFactor intrstFactor);

	/**
	 * @Title:
	 * @Description: 批量保存利率因子
	 * @param intrstFactors
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 20:08:11
	 */
	int insertDataList(List<IntrstFactor> intrstFactors);

	/**
	 * @Title:
	 * @Description: 修改利率因子
	 * @param intrstFactor
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 20:08:11
	 */
	int updateByPrimaryKeyData(IntrstFactor intrstFactor);

	/**
	 * @Title:
	 * @Description: 批量修改利率因子
	 * @param intrstFactors
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 20:08:11
	 */
	int updateByPrimaryKeyDataList(List<IntrstFactor> intrstFactors);

	/**
	 * @Title:
	 * @Description: 动态修改利率因子
	 * @param intrstFactor
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 20:08:11
	 */
	int updateByPrimaryKeySelectiveData(IntrstFactor intrstFactor);

	/**
	 * @Title:
	 * @Description: 批量动态修改利率因子
	 * @param intrstFactors
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 20:08:11
	 */
	int updateByPrimaryKeySelectiveDataList(List<IntrstFactor> intrstFactors);

	/**
	 * @Title:
	 * @Description: 根据条件修改利率因子
	 * @param intrstFactor
	 * @param example
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 20:08:11
	 */
	int updateByExampleData(IntrstFactor intrstFactor, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改利率因子
	 * @param intrstFactor
	 * @param example
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 20:08:11
	 */
	int updateByExampleSelectiveData(IntrstFactor intrstFactor, Example example);

	/**
	 * @Title:
	 * @Description: 根据intrstFactorId删除利率因子
	 * @param intrstFactor
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 20:08:11
	 */
	int deleteData(IntrstFactor intrstFactor);

	/**
	 * @Title:
	 * @Description: 根据intrstFactorId集合批量删除利率因子
	 * @param intrstFactorIds
	 * @param intrstFactor
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 20:08:11
	 */
	int deleteDataList(List intrstFactorIds, IntrstFactor intrstFactor);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除利率因子
	 * @param example
	 * @param intrstFactor
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 20:08:11
	 */
	int deleteExampleData(Example example, IntrstFactor intrstFactor);

	/**
	 * @Title:
	 * @Description: 查询全部利率因子
	 * @return List<IntrstFactor>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 20:08:11
	 */
	List<IntrstFactor> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个利率因子
	 * @param example
	 * @return IntrstFactor
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 20:08:11
	 */
	IntrstFactor selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询利率因子
	 * @param example
	 * @return List<IntrstFactor>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 20:08:11
	 */
	List<IntrstFactor> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过intrstFactorId查询利率因子
	 * @param intrstFactorId
	 * @return IntrstFactor
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 20:08:11
	 */
	IntrstFactor selectByPrimaryKey(Object intrstFactorId);

	/**
	 * @Title:
	 * @Description: 分页查询利率因子
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<IntrstFactor>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 20:08:11
	 */
	PageInfoExtend<IntrstFactor> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询利率因子vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<IntrstFactor>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 20:08:11
	 */
	PageInfoExtend<IntrstFactor> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
