package cn.com.leadu.fms.pojo.baseinfo.vo.rule;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.entity.Rule;
import cn.com.leadu.fms.pojo.baseinfo.vo.rulecondition.RuleConditionVo;
import cn.com.leadu.fms.pojo.baseinfo.vo.ruleconsequence.RuleConsequenceVo;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: RuleVo
 * @Description: 规则引擎载体
 * @date 2018-05-17
 */
@Data
public class RuleVo extends PageQuery<Rule> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 规则ID
	 * @author qiaomengnan
	 */
	private String ruleId;

	/**
	 * @Fields  : 规则类型
	 * @author qiaomengnan
	 */
	private String ruleType;

	/**
	 * @Fields  : 规则类型名称
	 * @author qiaomengnan
	 */
	private String ruleTypeName;

	/**
	 * @Fields  : 规则类型字典类型
	 * @author qiaomengnan
	 */
	private String ruleCodeType;

	/**
	 * @Fields  : 规则key
	 * @author qiaomengnan
	 */
	private String ruleKey;

	/**
	 * @Fields  : 规则名称
	 * @author qiaomengnan
	 */
	private String ruleName;

	/**
	 * @Fields  : 规则ID
	 * @author qiaomengnan
	 */
	private List<String> ruleIds;

	/**
	 * @Fields  : 用于接收前台的条件和结果 并排序
	 * @author qiaomengnan
	 */
	private List<RuleDetailVo> ruleDetailVos;



}