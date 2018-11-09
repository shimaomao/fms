package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCondition;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: OverdueConditionRepository
 * @Description: 逾期状态维护Repository层
 * @date 2018-05-11
 */
public interface OverdueConditionRepository {

	/**
	 * @Title:
	 * @Description: 新增逾期状态维护
	 * @param overdueCondition
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-11 10:10:17
	 */
	int insertData(OverdueCondition overdueCondition);

	/**
	 * @Title:
	 * @Description: 批量保存逾期状态维护
	 * @param overdueConditions
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-11 10:10:17
	 */
	int insertDataList(List<OverdueCondition> overdueConditions);

	/**
	 * @Title:
	 * @Description: 修改逾期状态维护
	 * @param overdueCondition
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-11 10:10:17
	 */
	int updateByPrimaryKeyData(OverdueCondition overdueCondition);

	/**
	 * @Title:
	 * @Description: 批量修改逾期状态维护
	 * @param overdueConditions
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-11 10:10:17
	 */
	int updateByPrimaryKeyDataList(List<OverdueCondition> overdueConditions);

	/**
	 * @Title:
	 * @Description: 动态修改逾期状态维护
	 * @param overdueCondition
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-11 10:10:17
	 */
	int updateByPrimaryKeySelectiveData(OverdueCondition overdueCondition);

	/**
	 * @Title:
	 * @Description: 批量动态修改逾期状态维护
	 * @param overdueConditions
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-11 10:10:17
	 */
	int updateByPrimaryKeySelectiveDataList(List<OverdueCondition> overdueConditions);

	/**
	 * @Title:
	 * @Description: 根据条件修改逾期状态维护
	 * @param overdueCondition
	 * @param example
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-11 10:10:17
	 */
	int updateByExampleData(OverdueCondition overdueCondition, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改逾期状态维护
	 * @param overdueCondition
	 * @param example
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-11 10:10:17
	 */
	int updateByExampleSelectiveData(OverdueCondition overdueCondition, Example example);

	/**
	 * @Title:
	 * @Description: 根据overdueConditionId删除逾期状态维护
	 * @param overdueCondition
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-11 10:10:17
	 */
	int deleteData(OverdueCondition overdueCondition);

	/**
	 * @Title:
	 * @Description: 根据overdueConditionId集合批量删除逾期状态维护
	 * @param overdueConditionIds
	 * @param overdueCondition
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-11 10:10:17
	 */
	int deleteDataList(List overdueConditionIds,OverdueCondition overdueCondition);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除逾期状态维护
	 * @param example
	 * @param overdueCondition
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-11 10:10:17
	 */
	int deleteExampleData(Example example,OverdueCondition overdueCondition);

	/**
	 * @Title:
	 * @Description: 查询全部逾期状态维护
	 * @return List<OverdueCondition>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-11 10:10:17
	 */
	List<OverdueCondition> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个逾期状态维护
	 * @param example
	 * @return OverdueCondition
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-11 10:10:17
	 */
	OverdueCondition selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询逾期状态维护
	 * @param example
	 * @return List<OverdueCondition>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-11 10:10:17
	 */
	List<OverdueCondition> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过overdueConditionId查询逾期状态维护
	 * @param overdueConditionId
	 * @return OverdueCondition
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-11 10:10:17
	 */
	OverdueCondition selectByPrimaryKey(Object overdueConditionId);

	/**
	 * @Title:
	 * @Description: 分页查询逾期状态维护
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<OverdueCondition>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-11 10:10:17
	 */
	PageInfoExtend<OverdueCondition> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询逾期状态维护vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-11 10:10:17
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

}
