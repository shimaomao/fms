package cn.com.leadu.fms.data.baseinfo.repository;

import cn.com.leadu.fms.pojo.baseinfo.entity.Rule;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.vo.rule.RuleVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleRepository
 * @Description: 规则引擎Repository层
 * @date 2018-05-17
 */
public interface RuleRepository {

	/**
	 * @Title:
	 * @Description: 新增规则引擎
	 * @param rule
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 9:57:26
	 */
	int insertData(Rule rule);

	/**
	 * @Title:
	 * @Description: 批量保存规则引擎
	 * @param rules
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 9:57:26
	 */
	int insertDataList(List<Rule> rules);

	/**
	 * @Title:
	 * @Description: 修改规则引擎
	 * @param rule
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 9:57:26
	 */
	int updateByPrimaryKeyData(Rule rule);

	/**
	 * @Title:
	 * @Description: 批量修改规则引擎
	 * @param rules
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 9:57:26
	 */
	int updateByPrimaryKeyDataList(List<Rule> rules);

	/**
	 * @Title:
	 * @Description: 动态修改规则引擎
	 * @param rule
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 9:57:26
	 */
	int updateByPrimaryKeySelectiveData(Rule rule);

	/**
	 * @Title:
	 * @Description: 批量动态修改规则引擎
	 * @param rules
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 9:57:26
	 */
	int updateByPrimaryKeySelectiveDataList(List<Rule> rules);

	/**
	 * @Title:
	 * @Description: 根据条件修改规则引擎
	 * @param rule
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 9:57:26
	 */
	int updateByExampleData(Rule rule, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改规则引擎
	 * @param rule
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 9:57:26
	 */
	int updateByExampleSelectiveData(Rule rule, Example example);

	/**
	 * @Title:
	 * @Description: 根据ruleId删除规则引擎
	 * @param rule
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 9:57:26
	 */
	int deleteData(Rule rule);

	/**
	 * @Title:
	 * @Description: 根据ruleId集合批量删除规则引擎
	 * @param ruleIds
	 * @param rule
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 9:57:26
	 */
	int deleteDataList(List ruleIds, Rule rule);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除规则引擎
	 * @param example
	 * @param rule
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 9:57:26
	 */
	int deleteExampleData(Example example, Rule rule);

	/**
	 * @Title:
	 * @Description: 查询全部规则引擎
	 * @return List<Rule>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 9:57:26
	 */
	List<Rule> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个规则引擎
	 * @param example
	 * @return Rule
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 9:57:26
	 */
	Rule selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询规则引擎
	 * @param example
	 * @return List<Rule>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 9:57:26
	 */
	List<Rule> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过ruleId查询规则引擎
	 * @param ruleId
	 * @return Rule
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 9:57:26
	 */
	Rule selectByPrimaryKey(Object ruleId);

	/**
	 * @Title:
	 * @Description: 分页查询规则引擎
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<Rule>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 9:57:26
	 */
	PageInfoExtend<Rule> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询规则引擎vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 9:57:26
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description:   查询ruleVo，并根据时间导学
	 * @param ruleVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/23 12:28:09
	 */
	List<RuleVo> selectRuleVos(RuleVo ruleVo);


	/**
	 * @Title:
	 * @Description:   根据条件单个查询ruleVo
	 * @param ruleVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/24 11:29:19
	 */
	RuleVo selectRuleVo(RuleVo ruleVo);

}
