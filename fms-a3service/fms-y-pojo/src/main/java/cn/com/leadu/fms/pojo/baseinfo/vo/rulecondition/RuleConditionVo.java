package cn.com.leadu.fms.pojo.baseinfo.vo.rulecondition;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.entity.RuleCondition;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: RuleConditionVo
 * @Description: 规则引擎条件载体
 * @date 2018-05-17
 */
@Data
public class RuleConditionVo extends PageQuery<RuleCondition> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 规则条件ID
	 * @author qiaomengnan
	 */
	private String ruleCondId;

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
	 * @Fields  : 条件项目key
	 * @author qiaomengnan
	 */
	private String condItemKey;

	/**
	 * @Fields  : 条件项目key名称
	 * @author qiaomengnan
	 */
	private String condItemKeyName;

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
	 * @Fields  : 条件匹配逻辑
	 * @author qiaomengnan
	 */
	private String condLogicType;

	/**
	 * @Fields  : 条件匹配逻辑字典key
	 * @author qiaomengnan
	 */
	private String condLogicTypeKey;

	/**
	 * @Fields  : 条件匹配逻辑名称
	 * @author qiaomengnan
	 */
	private String condLogicTypeName;

	/**
	 * @Fields  : 条件项目值1
	 * @author qiaomengnan
	 */
	private String condLogicValue1;

	/**
	 * @Fields  : 条件项目值2
	 * @author qiaomengnan
	 */
	private String condLogicValue2;

	/**
	 * @Fields  : 排序
	 * @author qiaomengnan
	 */
	private Integer orderNo;

	/**
	 * @Fields  : 规则条件ID
	 * @author qiaomengnan
	 */
	private List<String> ruleCondIds;

}