package cn.com.leadu.fms.baseinfo.validator.rulecondition.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.RuleCondition;
import lombok.Data;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: RuleConditionVo
 * @Description: 规则引擎条件保存时载体及验证
 * @date 2018-05-17
 */
@Data
public class RuleConditionSaveVo extends BaseVo<RuleCondition> {

	private static final long serialVersionUID = 1L;

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
	 * @Fields  : 条件匹配逻辑
	 * @author qiaomengnan
	 */
	private String condLogicType;

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

}