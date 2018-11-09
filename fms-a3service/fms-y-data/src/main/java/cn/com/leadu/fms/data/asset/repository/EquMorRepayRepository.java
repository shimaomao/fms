package cn.com.leadu.fms.data.asset.repository;

import cn.com.leadu.fms.pojo.asset.entity.EquMorRepay;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorRepayRepository
 * @Description: 资方抵押还款计划Repository层
 * @date 2018-05-30
 */
public interface EquMorRepayRepository {

	/**
	 * @Title:
	 * @Description: 新增资方抵押还款计划
	 * @param equMorRepay
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:35
	 */
	int insertData(EquMorRepay equMorRepay);

	/**
	 * @Title:
	 * @Description: 批量保存资方抵押还款计划
	 * @param equMorRepays
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:35
	 */
	int insertDataList(List<EquMorRepay> equMorRepays);

	/**
	 * @Title:
	 * @Description: 修改资方抵押还款计划
	 * @param equMorRepay
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:35
	 */
	int updateByPrimaryKeyData(EquMorRepay equMorRepay);

	/**
	 * @Title:
	 * @Description: 批量修改资方抵押还款计划
	 * @param equMorRepays
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:35
	 */
	int updateByPrimaryKeyDataList(List<EquMorRepay> equMorRepays);

	/**
	 * @Title:
	 * @Description: 动态修改资方抵押还款计划
	 * @param equMorRepay
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:35
	 */
	int updateByPrimaryKeySelectiveData(EquMorRepay equMorRepay);

	/**
	 * @Title:
	 * @Description: 批量动态修改资方抵押还款计划
	 * @param equMorRepays
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:35
	 */
	int updateByPrimaryKeySelectiveDataList(List<EquMorRepay> equMorRepays);

	/**
	 * @Title:
	 * @Description: 根据条件修改资方抵押还款计划
	 * @param equMorRepay
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:35
	 */
	int updateByExampleData(EquMorRepay equMorRepay, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改资方抵押还款计划
	 * @param equMorRepay
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:35
	 */
	int updateByExampleSelectiveData(EquMorRepay equMorRepay, Example example);

	/**
	 * @Title:
	 * @Description: 根据equMorRepayId删除资方抵押还款计划
	 * @param equMorRepay
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:35
	 */
	int deleteData(EquMorRepay equMorRepay);

	/**
	 * @Title:
	 * @Description: 根据equMorRepayId集合批量删除资方抵押还款计划
	 * @param equMorRepayIds
	 * @param equMorRepay
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:35
	 */
	int deleteDataList(List equMorRepayIds, EquMorRepay equMorRepay);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除资方抵押还款计划
	 * @param example
	 * @param equMorRepay
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:35
	 */
	int deleteExampleData(Example example, EquMorRepay equMorRepay);

	/**
	 * @Title:
	 * @Description: 查询全部资方抵押还款计划
	 * @return List<EquMorRepay>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:35
	 */
	List<EquMorRepay> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个资方抵押还款计划
	 * @param example
	 * @return EquMorRepay
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:35
	 */
	EquMorRepay selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询资方抵押还款计划
	 * @param example
	 * @return List<EquMorRepay>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:35
	 */
	List<EquMorRepay> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过equMorRepayId查询资方抵押还款计划
	 * @param equMorRepayId
	 * @return EquMorRepay
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:35
	 */
	EquMorRepay selectByPrimaryKey(Object equMorRepayId);

	/**
	 * @Title:
	 * @Description: 分页查询资方抵押还款计划
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<EquMorRepay>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:35
	 */
	PageInfoExtend<EquMorRepay> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询资方抵押还款计划vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:35
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改资方抵押还款计划
	 * @param equMorRepay,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:35
	 */
	int updateByPrimaryKeyData(EquMorRepay equMorRepay, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改资方抵押还款计划,并进行排他
	 * @param equMorRepays
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:35
	 */
	int updateByPrimaryKeyDataList(List<EquMorRepay> equMorRepays, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改资方抵押还款计划,并进行排他
	 * @param equMorRepay
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(EquMorRepay equMorRepay, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改资方抵押还款计划,并进行排他
	 * @param equMorRepays
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:35
	 */
	int updateByPrimaryKeySelectiveDataList(List<EquMorRepay> equMorRepays, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改资方抵押还款计划,并进行排他
	 * @param equMorRepay
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:35
	 */
	int updateByExampleData(EquMorRepay equMorRepay, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改资方抵押还款计划,并进行排他
	 * @param equMorRepay
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:57:35
	 */
	int updateByExampleSelectiveData(EquMorRepay equMorRepay, Example example, boolean exclusive);

}
