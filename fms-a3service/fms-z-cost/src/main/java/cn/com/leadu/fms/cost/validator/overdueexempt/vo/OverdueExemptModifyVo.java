package cn.com.leadu.fms.cost.validator.overdueexempt.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.cost.entity.OverdueExempt;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;

/**
 * @author yanfengbo
 * @ClassName: OverdueExemptVo
 * @Description: 罚息免除任务表修改时载体及验证
 * @date 2018-05-30
 */
@Data
public class OverdueExemptModifyVo extends BaseVo<OverdueExempt> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 罚息免除任务id
	 * @author yanfengbo
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String overdueExemptId;

	/**
	 * @Fields  : 罚息免除任务号
	 * @author yanfengbo
	 */
	private String overdueExemptNo;

	/**
	 * @Fields  : 罚息免除任务状态
	 * @author yanfengbo
	 */
	private String overdueExemptStatus;

	/**
	 * @Fields  : 当前节点用户
	 */
	private String presentUser;

}