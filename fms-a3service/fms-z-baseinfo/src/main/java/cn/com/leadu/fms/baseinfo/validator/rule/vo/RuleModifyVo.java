package cn.com.leadu.fms.baseinfo.validator.rule.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.Rule;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleVo
 * @Description: 规则引擎修改时载体及验证
 * @date 2018-05-17
 */
@Data
public class RuleModifyVo extends BaseVo<Rule> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 规则ID
	 * @author qiaomengnan
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String ruleId;

	/**
	 * @Fields  : 规则类型
	 * @author qiaomengnan
	 */
	private String ruleType;

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

	private List<RuleDetailModifyVo> ruleDetailVos;

}