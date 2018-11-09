package cn.com.leadu.fms.baseinfo.service;

import cn.com.leadu.fms.pojo.baseinfo.entity.RuleConsequence;
import cn.com.leadu.fms.pojo.baseinfo.vo.ruleconsequence.RuleConsequenceVo;
import cn.com.leadu.fms.baseinfo.validator.ruleconsequence.vo.RuleConsequenceSaveVo;
import cn.com.leadu.fms.baseinfo.validator.ruleconsequence.vo.RuleConsequenceModifyVo;
import cn.com.leadu.fms.baseinfo.validator.ruleconsequence.vo.RuleConsequenceDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.ruleconsequence.vo.RuleConsequenceDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleConsequenceService
 * @Description: 规则引擎结果业务层
 * @date 2018-05-17
 */
public interface RuleConsequenceService {

	/**
	 * @Title:
	 * @Description: 分页查询规则引擎结果
	 * @param ruleConsequenceVo
	 * @return PageInfoExtend<RuleConsequence>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:36:10
	 */
	PageInfoExtend<RuleConsequence> findRuleConsequencesByPage(RuleConsequenceVo ruleConsequenceVo);

	/**
	 * @Title:
	 * @Description: 保存规则引擎结果
	 * @param ruleConsequenceSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:36:10
	 */
    void saveRuleConsequence(RuleConsequenceSaveVo ruleConsequenceSaveVo);


	/**
	 * @Title:
	 * @Description: 修改规则引擎结果
	 * @param ruleConsequenceModifyVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:36:10
	 */
	void modifyRuleConsequence(RuleConsequenceModifyVo ruleConsequenceModifyVo);

	/**
	 * @Title:
	 * @Description:  通过ruleConseqId删除规则引擎结果
	 * @param ruleConsequenceDeleteVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:36:10
	 */
	void deleteRuleConsequence(RuleConsequenceDeleteVo ruleConsequenceDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过ruleConseqId集合删除规则引擎结果
	 * @param ruleConsequenceDeleteListVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:36:10
	 */
	void deleteRuleConsequencesByRuleConseqIds(RuleConsequenceDeleteListVo ruleConsequenceDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据ruleConseqId获取规则引擎结果
	 * @param ruleConseqId
	 * @return RuleConsequence
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:36:10
	 */
	RuleConsequence findRuleConsequenceByRuleConseqId(String ruleConseqId);

	/**
	 * @Title:
	 * @Description:   批量保存结果
	 * @param ruleConsequences
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/18 05:32:16
	 */
	void saveRuleConsequences(List<RuleConsequence> ruleConsequences);

	/**
	 * @Title:
	 * @Description:   根据规则id查找结果，并根据规则顺序和结果排序进行顺序排列
	 * @param ruleId
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/21 10:48:33
	 */
	List<RuleConsequenceVo> findRuleConsequenceVosByRuleId(String ruleId);

	/**
	 * @Title:
	 * @Description:   查找结果，并根据规则顺序和结果排序进行顺序排列
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/21 10:48:33
	 */
	List<RuleConsequenceVo> findRuleConsequenceVos();

	/**
	 * @Title:
	 * @Description:   查找结果，并根据规则顺序和结果排序进行顺序排列
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/21 10:48:33
	 */
	List<RuleConsequenceVo> findRuleConsequenceVos(String ruleId);

	/**
	 * @Title:
	 * @Description:   批量更新结果
	 * @param ruleConsequences
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/21 04:59:23
	 */
	void modifyRuleConsequences(List<RuleConsequence> ruleConsequences);

	/**
	 * @Title:
	 * @Description:   根据规则id和已知的结果id，删除该规则id下不在已经结果id中的数据
	 * @param ruleId
	 * @param ruleConseqIds
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/21 05:06:00
	 */
	void deleteRuleConsequences(String ruleId,List<String> ruleConseqIds);

	/**
	 * @Title:
	 * @Description:   根据规则id删除对应的结果
	 * @param ruleIds
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/21 06:29:29
	 */
	void deleteRuleConsequences(List<String> ruleIds);

}
