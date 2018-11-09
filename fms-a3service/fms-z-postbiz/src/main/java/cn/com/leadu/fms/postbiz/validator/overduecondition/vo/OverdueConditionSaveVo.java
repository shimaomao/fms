package cn.com.leadu.fms.postbiz.validator.overduecondition.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCondition;
import cn.com.leadu.fms.postbiz.validator.overduecondition.validator.OverdueConditionValidator;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * @author yanfengbo
 * @ClassName: OverdueConditionVo
 * @Description: 逾期状态维护保存时载体及验证
 * @date 2018-05-11
 */
@Data
public class OverdueConditionSaveVo extends BaseVo<OverdueCondition> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 逾期状态ID
	 * @author yanfengbo
	 */
	private String overdueConditionId;

	/**
	 * @Fields  : 逾期状态代码
	 * @author yanfengbo
	 */
	@OverdueConditionValidator(message = "已经存在，不能重复添加")
	@NotBlank(message = "逾期状态代码不能为空")
	private String overdueCondCd;

	/**
	 * @Fields  : 逾期状态名称
	 * @author yanfengbo
	 */
	@NotBlank(message = "逾期状态名称不能为空")
	private String overdueCondName;

	/**
	 * @Fields  : 逾期风险等级
	 * @author yanfengbo
	 */
	@NotBlank(message = "逾期风险等级不能为空")
	private String overdueRisk;

	/**
	 * @Fields  : 逾期状态详情代码
	 * @author yanfengbo
	 */
	private String overdueDetailType;

	/**
	 * @Fields  : 逾期状态备注
	 * @author yanfengbo
	 */
	@NotBlank(message = "逾期状态备注不能为空")
	private String overdueMeno;

	/**
	 * @Fields  : 是否启用标示
	 * @author yanfengbo
	 */
	@NotBlank(message = "是否启用标示不能为空")
	private String enableFlag;

}