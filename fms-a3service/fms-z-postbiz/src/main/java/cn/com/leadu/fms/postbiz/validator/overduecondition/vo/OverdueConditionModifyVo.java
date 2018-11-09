package cn.com.leadu.fms.postbiz.validator.overduecondition.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCondition;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;

/**
 * @author yanfengbo
 * @ClassName: OverdueConditionVo
 * @Description: 逾期状态维护修改时载体及验证
 * @date 2018-05-11
 */
@Data
public class OverdueConditionModifyVo extends BaseVo<OverdueCondition> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 逾期状态ID
	 * @author yanfengbo
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String overdueConditionId;

	/**
	 * @Fields  : 逾期状态代码
	 * @author yanfengbo
	 */
	private String overdueCondCd;

	/**
	 * @Fields  : 逾期状态名称
	 * @author yanfengbo
	 */
	private String overdueCondName;

	/**
	 * @Fields  : 逾期风险等级
	 * @author yanfengbo
	 */
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
	private String overdueMeno;

	/**
	 * @Fields  : 是否启用标示
	 * @author yanfengbo
	 */
	private String enableFlag;

}