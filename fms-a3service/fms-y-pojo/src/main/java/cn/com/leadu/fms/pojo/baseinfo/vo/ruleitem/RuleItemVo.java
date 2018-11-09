package cn.com.leadu.fms.pojo.baseinfo.vo.ruleitem;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.entity.RuleItem;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: RuleItemVo
 * @Description: 规则引擎项目管理载体
 * @date 2018-05-17
 */
@Data
public class RuleItemVo extends PageQuery<RuleItem> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 规则项目ID
	 * @author qiaomengnan
	 */
	private String ruleItemId;

	/**
	 * @Fields  : 规则类型
	 * @author qiaomengnan
	 */
	private String ruleType;

	/**
	 * @Fields  : 规则项目key
	 * @author qiaomengnan
	 */
	private String ruleItemKey;

	/**
	 * @Fields  : 规则项目名称
	 * @author qiaomengnan
	 */
	private String ruleItemName;

	/**
	 * @Fields  : 项目属性
	 * @author qiaomengnan
	 */
	private String itemType;

	/**
	 * @Fields  : 规则项目ID
	 * @author qiaomengnan
	 */
	private List<String> ruleItemIds;

}