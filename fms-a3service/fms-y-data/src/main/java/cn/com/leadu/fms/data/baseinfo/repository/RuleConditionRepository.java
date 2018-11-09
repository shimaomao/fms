package cn.com.leadu.fms.data.baseinfo.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.baseinfo.entity.RuleCondition;
import cn.com.leadu.fms.pojo.baseinfo.vo.rulecondition.RuleConditionVo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleConditionRepository
 * @Description: 规则引擎条件Repository层
 * @date 2018-05-17
 */
public interface RuleConditionRepository {

	/**
	 * @Title:
	 * @Description: 新增规则引擎条件
	 * @param ruleCondition
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:20:14
	 */
	int insertData(RuleCondition ruleCondition);

	/**
	 * @Title:
	 * @Description: 批量保存规则引擎条件
	 * @param ruleConditions
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:20:14
	 */
	int insertDataList(List<RuleCondition> ruleConditions);

	/**
	 * @Title:
	 * @Description: 修改规则引擎条件
	 * @param ruleCondition
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:20:14
	 */
	int updateByPrimaryKeyData(RuleCondition ruleCondition);

	/**
	 * @Title:
	 * @Description: 批量修改规则引擎条件
	 * @param ruleConditions
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:20:14
	 */
	int updateByPrimaryKeyDataList(List<RuleCondition> ruleConditions);

	/**
	 * @Title:
	 * @Description: 动态修改规则引擎条件
	 * @param ruleCondition
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:20:14
	 */
	int updateByPrimaryKeySelectiveData(RuleCondition ruleCondition);

	/**
	 * @Title:
	 * @Description: 批量动态修改规则引擎条件
	 * @param ruleConditions
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:20:14
	 */
	int updateByPrimaryKeySelectiveDataList(List<RuleCondition> ruleConditions);

	/**
	 * @Title:
	 * @Description: 根据条件修改规则引擎条件
	 * @param ruleCondition
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:20:14
	 */
	int updateByExampleData(RuleCondition ruleCondition, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改规则引擎条件
	 * @param ruleCondition
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:20:14
	 */
	int updateByExampleSelectiveData(RuleCondition ruleCondition, Example example);

	/**
	 * @Title:
	 * @Description: 根据ruleCondId删除规则引擎条件
	 * @param ruleCondition
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:20:14
	 */
	int deleteData(RuleCondition ruleCondition);

	/**
	 * @Title:
	 * @Description: 根据ruleCondId集合批量删除规则引擎条件
	 * @param ruleCondIds
	 * @param ruleCondition
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:20:14
	 */
	int deleteDataList(List ruleCondIds, RuleCondition ruleCondition);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除规则引擎条件
	 * @param example
	 * @param ruleCondition
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:20:14
	 */
	int deleteExampleData(Example example, RuleCondition ruleCondition);

	/**
	 * @Title:
	 * @Description: 查询全部规则引擎条件
	 * @return List<RuleCondition>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:20:14
	 */
	List<RuleCondition> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个规则引擎条件
	 * @param example
	 * @return RuleCondition
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:20:14
	 */
	RuleCondition selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询规则引擎条件
	 * @param example
	 * @return List<RuleCondition>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:20:14
	 */
	List<RuleCondition> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过ruleCondId查询规则引擎条件
	 * @param ruleCondId
	 * @return RuleCondition
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:20:14
	 */
	RuleCondition selectByPrimaryKey(Object ruleCondId);

	/**
	 * @Title:
	 * @Description: 分页查询规则引擎条件
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<RuleCondition>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:20:14
	 */
	PageInfoExtend<RuleCondition> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询规则引擎条件vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:20:14
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description:   根据规则id查询规则条件列表
	 * @param ruleConditionVo
	 * @return List<RuleConditionVo>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/21 12:41:42
	 */
	List<RuleConditionVo> selectRuleConditionVosByRuleId(RuleConditionVo ruleConditionVo);

	/**
	 * @Title:
	 * @Description:   查询规则条件列表
	 * @param ruleConditionVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/21 12:41:42
	 */
	List<RuleConditionVo> selectRuleConditionVos(RuleConditionVo ruleConditionVo);

}
