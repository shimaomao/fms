package cn.com.leadu.fms.cost.validator.contprepayment.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.cost.entity.ContPrepayment;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author yangyiquan
 * @ClassName: ContPrepaymentVo
 * @Description: 提前还款修改时载体及验证
 * @date 2018-05-10
 */
@Data
public class ContPrepaymentModifyVo extends BaseVo<ContPrepayment> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 提前还款ID
	 * @author yangyiquan
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String contPrepaymentId;

	/**
	 * @Fields  : 提前还款业务号
	 * @author yangyiquan
	 */
	private String contPrepaymentNo;

	/**
	 * @Fields  : 合同编号
	 * @author yangyiquan
	 */
	private String contNo;

	/**
	 * @Fields  : 提前还款状态
	 * @author yangyiquan
	 */
	private String prepaymentSts;

	/**
	 * @Fields  : 提前还款类型
	 * @author yangyiquan
	 */
	private String prepaymentType;

	/**
	 * @Fields  : 提前还款日期
	 * @author yangyiquan
	 */
	private Date prepaymentDate;

	/**
	 * @Fields  : 提前还款试算总金额
	 * @author yangyiquan
	 */
	private BigDecimal prepayTrialAmount;

	/**
	 * @Fields  : 提前还款实际总金额
	 * @author yangyiquan
	 */
	private BigDecimal prepayActualAmount;

	/**
	 * @Fields  : 审批通过日期
	 * @author yangyiquan
	 */
	private Date prepayPassDate;

	/**
	 * @Fields  : 财务确认日期
	 * @author yangyiquan
	 */
	private Date prepayValidDate;

	/**
	 * @Fields  : 当前节点用户
	 * @author yangyiquan
	 */
	private String presentUser;

}