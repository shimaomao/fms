package cn.com.leadu.fms.pojo.cost.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author yangyiquan
 * @ClassName: ContPrepayment
 * @Description: 提前还款实体
 * @date 2018-05-10
 */
@Data
public class ContPrepayment extends BaseEntity<ContPrepayment> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 提前还款ID
	 * @author yangyiquan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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

	/**
	 * @Fields  : 有效期
	 * @author yangyiquan
	 */
	private Date validityDate;

	/**
	 * @Fields  : 已还期数
	 * @author yangyiquan
	 */
	private Integer alreadyRepayNper;

	/**
	 * @Fields  : 已还金额
	 * @author yangyiquan
	 */
	private BigDecimal alreadyRepayAmount;

	/**
	 * @Fields  : 剩余未还租金
	 * @author yangyiquan
	 */
	private BigDecimal residueAmount;

}