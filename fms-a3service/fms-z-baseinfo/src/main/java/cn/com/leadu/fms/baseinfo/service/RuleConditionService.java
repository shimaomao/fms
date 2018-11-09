package cn.com.leadu.fms.baseinfo.service;

import cn.com.leadu.fms.pojo.baseinfo.entity.RuleCondition;
import cn.com.leadu.fms.pojo.baseinfo.vo.rulecondition.RuleConditionVo;
import cn.com.leadu.fms.baseinfo.validator.rulecondition.vo.RuleConditionSaveVo;
import cn.com.leadu.fms.baseinfo.validator.rulecondition.vo.RuleConditionModifyVo;
import cn.com.leadu.fms.baseinfo.validator.rulecondition.vo.RuleConditionDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.rulecondition.vo.RuleConditionDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleConditionService
 * @Description: 规则引擎条件业务层
 * @date 2018-05-17
 */
public interface RuleConditionService {

	/**
	 * @Title:
	 * @Description: 分页查询规则引擎条件
	 * @param ruleConditionVo
	 * @return PageInfoExtend<RuleCondition>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:20:14
	 */
	PageInfoExtend<RuleCondition> findRuleConditionsByPage(RuleConditionVo ruleConditionVo);

	/**
	 * @Title:
	 * @Description: 保存规则引擎条件
	 * @param ruleConditionSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:20:14
	 */
    void saveRuleCondition(RuleConditionSaveVo ruleConditionSaveVo);


	/**
	 * @Title:
	 * @Description: 修改规则引擎条件
	 * @param ruleConditionModifyVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:20:14
	 */
	void modifyRuleCondition(RuleConditionModifyVo ruleConditionModifyVo);

	/**
	 * @Title:
	 * @Description:  通过ruleCondId删除规则引擎条件
	 * @param ruleConditionDeleteVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:20:14
	 */
	void deleteRuleCondition(RuleConditionDeleteVo ruleConditionDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过ruleCondId集合删除规则引擎条件
	 * @param ruleConditionDeleteListVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:20:14
	 */
	void deleteRuleConditionsByRuleCondIds(RuleConditionDeleteListVo ruleConditionDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据ruleCondId获取规则引擎条件
	 * @param ruleCondId
	 * @return RuleCondition
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:20:14
	 */
	RuleCondition findRuleConditionByRuleCondId(String ruleCondId);

	/**
	 * @Title:
	 * @Description:   批量保存条件
	 * @param ruleConditions
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/18 05:30:21
	 */
	void saveRuleConditions(List<RuleCondition> ruleConditions);

	/**
	 * @Title:
	 * @Description:   根据规则id查找条件，并根据规则顺序排序
	 * @param ruleId
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/21 10:35:29
	 */
	List<RuleConditionVo> findRuleConditionVosByRuleId(String ruleId);

	/**
	 * @Title:
	 * @Description:   查找条件，并根据规则顺序和条件顺序进行排序
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/21 10:35:29
	 */
	List<RuleConditionVo> findRuleConditionVos();

	/**
	 * @Title:
	 * @Description:   根据ruleId查找条件，并根据规则顺序和条件顺序进行排序
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/21 10:35:29
	 */
	List<RuleConditionVo> findRuleConditionVos(String ruleId);

	/**
	 * @Title:
	 * @Description: 批量更新条件
	 * @param ruleConditions
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/21 04:58:23
	 */
	void modifyRuleConditions(List<RuleCondition> ruleConditions);

	/**
	 * @Title:
	 * @Description:   根据规则id和已知的条件id，删除该规则id下不在已经条件id中的数据
	 * @param ruleId
	 * @param ruleCondIds
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/21 05:06:00
	 */
	void deleteRuleConditions(String ruleId,List<String> ruleCondIds);

	/**
	 * @Title:
	 * @Description:   根据规则id删除下面的条件
	 * @param ruleIds
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/21 06:28:28
	 */
	void deleteRuleConditions(List<String> ruleIds);

}
