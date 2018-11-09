package cn.com.leadu.fms.data.baseinfo.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasRepayRule;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author huchenghao
 * @ClassName: BasRepayRuleRepository
 * @Description: 还款日规则Repository层
 * @date 2018-03-16
 */
public interface BasRepayRuleRepository {

	/**
	 * @Title:
	 * @Description: 新增还款日规则
	 * @param basRepayRule
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 13:46:36
	 */
	int insertData(BasRepayRule basRepayRule);

	/**
	 * @Title:
	 * @Description: 批量保存还款日规则
	 * @param basRepayRules
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 13:46:36
	 */
	int insertDataList(List<BasRepayRule> basRepayRules);

	/**
	 * @Title:
	 * @Description: 修改还款日规则
	 * @param basRepayRule
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 13:46:36
	 */
	int updateByPrimaryKeyData(BasRepayRule basRepayRule);

	/**
	 * @Title:
	 * @Description: 批量修改还款日规则
	 * @param basRepayRules
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 13:46:36
	 */
	int updateByPrimaryKeyDataList(List<BasRepayRule> basRepayRules);

	/**
	 * @Title:
	 * @Description: 动态修改还款日规则
	 * @param basRepayRule
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 13:46:36
	 */
	int updateByPrimaryKeySelectiveData(BasRepayRule basRepayRule);

	/**
	 * @Title:
	 * @Description: 批量动态修改还款日规则
	 * @param basRepayRules
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 13:46:36
	 */
	int updateByPrimaryKeySelectiveDataList(List<BasRepayRule> basRepayRules);

	/**
	 * @Title:
	 * @Description: 根据条件修改还款日规则
	 * @param basRepayRule
	 * @param example
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 13:46:36
	 */
	int updateByExampleData(BasRepayRule basRepayRule, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改还款日规则
	 * @param basRepayRule
	 * @param example
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 13:46:36
	 */
	int updateByExampleSelectiveData(BasRepayRule basRepayRule, Example example);

	/**
	 * @Title:
	 * @Description: 根据ruleId删除还款日规则
	 * @param basRepayRule
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 13:46:36
	 */
	int deleteData(BasRepayRule basRepayRule);

	/**
	 * @Title:
	 * @Description: 根据ruleId集合批量删除还款日规则
	 * @param ruleIds
	 * @param basRepayRule
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 13:46:36
	 */
	int deleteDataList(List ruleIds, BasRepayRule basRepayRule);

	/**
	 * @Title:
	 * @Description: 查询全部还款日规则
	 * @return List<BasRepayRule>
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 13:46:36
	 */
	List<BasRepayRule> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个还款日规则
	 * @param example
	 * @return BasRepayRule
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 13:46:36
	 */
	BasRepayRule selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询还款日规则
	 * @param example
	 * @return List<BasRepayRule>
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 13:46:36
	 */
	List<BasRepayRule> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过ruleId查询还款日规则
	 * @param ruleId
	 * @return BasRepayRule
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 13:46:36
	 */
	BasRepayRule selectByPrimaryKey(Object ruleId);

	/**
	 * @Title:
	 * @Description: 分页查询还款日规则
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<BasRepayRule>
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 13:46:36
	 */
	PageInfoExtend<BasRepayRule> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询还款日规则vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<BasRepayRule>
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 13:46:36
	 */
	PageInfoExtend<BasRepayRule> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
