package cn.com.leadu.fms.baseinfo.validator.basrepayrule.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasRepayRule;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author huchenghao
 * @ClassName: BasRepayRuleVo
 * @Description: 还款日规则修改时载体及验证
 * @date 2018-03-16
 */
@Data
public class BasRepayRuleModifyVo extends BaseVo<BasRepayRule> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String ruleId;
	/**
	 * @Fields  :
	 */
	@NotBlank(message = "还款日不能为空")
	private String repayDay;

	/**
	 * @Fields  :
	 */
	@NotBlank(message = "开始区间不能为空")
	private String beginInterval;

	/**
	 * @Fields  :
	 */
	@NotBlank(message = "结束区间不能为空")
	private String endInterval;

}