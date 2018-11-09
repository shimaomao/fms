package cn.com.leadu.fms.pojo.baseinfo.vo.basrepayrule;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasRepayRule;
import lombok.Data;

import java.util.List;

/**
 * @author huchenghao
 * @ClassName: BasRepayRuleVo
 * @Description: 还款日规则载体
 * @date 2018-03-16
 */
@Data
public class BasRepayRuleVo extends PageQuery<BasRepayRule> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	private String ruleId;

	/**
	 * @Fields  : 
	 */
	private String repayDay;

	/**
	 * @Fields  : 
	 */
	private String beginInterval;

	/**
	 * @Fields  : 
	 */
	private String endInterval;

	/**
	 * @Fields  : 
	 */
	private List<String> ruleIds;

}