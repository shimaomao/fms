package cn.com.leadu.fms.baseinfo.validator.ruleitem.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.RuleItem;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: RuleItemVo
 * @Description: 规则引擎项目管理修改时载体及验证
 * @date 2018-05-17
 */
@Data
public class RuleItemModifyVo extends BaseVo<RuleItem> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 规则项目ID
	 * @author qiaomengnan
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String ruleItemId;

	/**
	 * @Fields  : 规则类型
	 * @author qiaomengnan
	 */
	@NotBlank(message = "规则类型不能为空")
	@Length(min = 1 ,max = 10 ,message = "规则类型最小字符为1，最大字符为10")
	private String ruleType;

	/**
	 * @Fields  : 规则项目key
	 * @author qiaomengnan
	 */
	@NotBlank(message = "规则项目key不能为空")
	@Length(min = 1 ,max = 50 ,message = "规则项目key最小字符为1，最大字符为50")
	private String ruleItemKey;

	/**
	 * @Fields  : 规则项目名称
	 * @author qiaomengnan
	 */
	@NotBlank(message = "规则项目名称不能为空")
	@Length(min = 1 ,max = 200 ,message = "规则项目名称最小字符为1，最大字符为200")
	private String ruleItemName;

	/**
	 * @Fields  : 项目属性
	 * @author qiaomengnan
	 */
	@NotBlank(message = "项目属性不能为空")
	@Length(min = 1 ,max = 10 ,message = "项目属性最小字符为1，最大字符为10")
	private String itemType;

}