package cn.com.leadu.fms.baseinfo.service;

import cn.com.leadu.fms.pojo.baseinfo.entity.Rule;
import cn.com.leadu.fms.pojo.baseinfo.vo.rule.RuleVo;
import cn.com.leadu.fms.baseinfo.validator.rule.vo.RuleSaveVo;
import cn.com.leadu.fms.baseinfo.validator.rule.vo.RuleModifyVo;
import cn.com.leadu.fms.baseinfo.validator.rule.vo.RuleDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.rule.vo.RuleDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author qiaomengnan
 * @ClassName: RuleService
 * @Description: 规则引擎业务层
 * @date 2018-05-17
 */
public interface RuleService {

	/**
	 * @Title:
	 * @Description: 分页查询规则引擎
	 * @param ruleVo
	 * @return PageInfoExtend<Rule>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 9:57:27
	 */
	PageInfoExtend<Rule> findRulesByPage(RuleVo ruleVo);

	/**
	 * @Title:
	 * @Description: 保存规则引擎
	 * @param ruleSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 9:57:27
	 */
    void saveRule(RuleSaveVo ruleSaveVo);


	/**
	 * @Title:
	 * @Description: 修改规则引擎
	 * @param ruleModifyVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 9:57:27
	 */
	void modifyRule(RuleModifyVo ruleModifyVo);

	/**
	 * @Title:
	 * @Description:  通过ruleId删除规则引擎
	 * @param ruleDeleteVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 9:57:27
	 */
	void deleteRule(RuleDeleteVo ruleDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过ruleId集合删除规则引擎
	 * @param ruleDeleteListVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 9:57:27
	 */
	void deleteRulesByRuleIds(RuleDeleteListVo ruleDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据ruleId获取规则引擎
	 * @param ruleId
	 * @return Rule
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 9:57:27
	 */
	Rule findRuleByRuleId(String ruleId);

	/**
	 * @Title:
	 * @Description:   查询规则引擎详情
	 * @param ruleId
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/21 11:26:36
	 */
	RuleVo findRuleVoByRuleId(String ruleId);

	/**
	 * @Title:
	 * @Description:   初始化规则引擎到redis中
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/22 11:29:42
	 */
	void initRule();

	/**
	 * @Title:
	 * @Description: 根据ruleType ruleKey查询一条完整的规则数据
	 * @param ruleType
	 * @param ruleKey
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/24 11:12:31
	 */
	RuleVo findRuleVo(String ruleType,String ruleKey);

}
