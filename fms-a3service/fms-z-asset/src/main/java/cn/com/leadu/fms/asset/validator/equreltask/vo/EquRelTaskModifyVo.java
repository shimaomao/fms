package cn.com.leadu.fms.asset.validator.equreltask.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.asset.entity.EquRelTask;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author qiaomengnan
 * @ClassName: EquRelTaskVo
 * @Description: 资方解押任务修改时载体及验证
 * @date 2018-05-30
 */
@Data
public class EquRelTaskModifyVo extends BaseVo<EquRelTask> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 资方解押任务id
	 * @author qiaomengnan
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String equRelTaskId;

	/**
	 * @Fields  : 资方解押任务号
	 * @author qiaomengnan
	 */
	private String equRelTaskNo;

	/**
	 * @Fields  : 解押任务状态
	 * @author qiaomengnan
	 */
	private String reliefStatus;

	/**
	 * @Fields  : 审批人
	 * @author qiaomengnan
	 */
	private String presentUser;

	/**
	 * @Fields  : 差额
	 * @author qiaomengnan
	 */
	private BigDecimal differenceCharge;

}