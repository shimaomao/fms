package cn.com.leadu.fms.pojo.baseinfo.vo.ruleconsequence;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.entity.RuleConsequence;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: RuleConsequenceVo
 * @Description: 规则引擎结果载体
 * @date 2018-05-17
 */
@Data
public class RuleConsequenceVo extends PageQuery<RuleConsequence> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 规则结果ID
	 * @author qiaomengnan
	 */
	private String ruleConseqId;

	/**
	 * @Fields  : 规则ID
	 * @author qiaomengnan
	 */
	private String ruleId;

	/**
	 * @Fields  : 规则序号
	 * @author qiaomengnan
	 */
	private Integer ruleNo;

	/**
	 * @Fields  : 优先级
	 * @author qiaomengnan
	 */
	private Integer priority;


	/**
	 * @Fields  : 结果项目key
	 * @author qiaomengnan
	 */
	private String conseqItemKey;

	/**
	 * @Fields  : 结果项目名称
	 * @author qiaomengnan
	 */
	private String conseqItemKeyName;

	/**
	 * @Fields  : 规则类型
	 * @author qiaomengnan
	 */
	private String ruleType;

	/**
	 * @Fields  : 规则项目类型
	 * @author qiaomengnan
	 */
	private String ruleItemType;

	/**
	 * @Fields  : 结果匹配逻辑
	 * @author qiaomengnan
	 */
	private String conseqLogicType;

	/**
	 * @Fields  : 结果匹配逻辑字典key
	 * @author qiaomengnan
	 */
	private String conseqLogicTypeKey;

	/**
	 * @Fields  : 结果匹配逻辑名称
	 * @author qiaomengnan
	 */
	private String conseqLogicTypeName;

	/**
	 * @Fields  : 结果项目值1
	 * @author qiaomengnan
	 */
	private String conseqLogicValue1;

	/**
	 * @Fields  : 结果项目值2
	 * @author qiaomengnan
	 */
	private String conseqLogicValue2;

	/**
	 * @Fields  : 规则结果ID
	 * @author qiaomengnan
	 */
	private List<String> ruleConseqIds;

	/**
	 * @Fields  : 结果排序
	 * @author qiaomengnan
	 */
	private Integer orderNo;

}