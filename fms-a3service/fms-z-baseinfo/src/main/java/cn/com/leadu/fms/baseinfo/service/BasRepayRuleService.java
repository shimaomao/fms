package cn.com.leadu.fms.baseinfo.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasRepayRule;
import cn.com.leadu.fms.pojo.baseinfo.vo.basrepayrule.BasRepayRuleVo;
import cn.com.leadu.fms.baseinfo.validator.basrepayrule.vo.BasRepayRuleDeleteListVo;
import cn.com.leadu.fms.baseinfo.validator.basrepayrule.vo.BasRepayRuleDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.basrepayrule.vo.BasRepayRuleModifyVo;
import cn.com.leadu.fms.baseinfo.validator.basrepayrule.vo.BasRepayRuleSaveVo;

import java.util.Date;

/**
 * @author huchenghao
 * @ClassName: BasRepayRuleService
 * @Description: 还款日规则业务层
 * @date 2018-03-16
 */
public interface BasRepayRuleService {

	/**
	 * @Title:
	 * @Description: 分页查询还款日规则
	 * @param basRepayRuleVo
	 * @return PageInfoExtend<BasRepayRule>
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 13:46:36
	 */
	PageInfoExtend<BasRepayRule> findBasRepayRulesByPage(BasRepayRuleVo basRepayRuleVo);

	/**
	 * @Title:
	 * @Description: 保存还款日规则
	 * @param basRepayRuleSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 13:46:36
	 */
    void saveBasRepayRule(BasRepayRuleSaveVo basRepayRuleSaveVo);


	/**
	 * @Title:
	 * @Description: 修改还款日规则
	 * @param basRepayRuleModifyVo
	 * @return
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 13:46:36
	 */
	void modifyBasRepayRule(BasRepayRuleModifyVo basRepayRuleModifyVo);

	/**
	 * @Title:
	 * @Description:  通过ruleId删除还款日规则
	 * @param basRepayRuleDeleteVo
	 * @return
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 13:46:36
	 */
	void deleteBasRepayRule(BasRepayRuleDeleteVo basRepayRuleDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过ruleId集合删除还款日规则
	 * @param basRepayRuleDeleteListVo
	 * @return
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 13:46:36
	 */
	void deleteBasRepayRulesByRuleIds(BasRepayRuleDeleteListVo basRepayRuleDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据ruleId获取还款日规则
	 * @param ruleId
	 * @return BasRepayRule
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 13:46:36
	 */
	BasRepayRule findBasRepayRuleByRuleId(String ruleId);
	/**
	 * @Title:
	 * @Description:  根据当前日期取得还款日
	 * @param
	 * @return rePayDay
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 13:46:36
	 */
	String findRepayDay(Date repayDate);
}
