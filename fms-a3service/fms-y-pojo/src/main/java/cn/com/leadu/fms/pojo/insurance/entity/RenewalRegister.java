package cn.com.leadu.fms.pojo.insurance.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ningyangyang
 * @ClassName: RenewalRegister
 * @Description: 续保任务登记实体
 * @date 2018-05-17
 */
@Data
public class RenewalRegister extends BaseEntity<RenewalRegister> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 续保任务ID
	 * @author ningyangyang
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String renewalRegisterId;

	/**
	 * @Fields  : 合同编号
	 * @author ningyangyang
	 */
	private String contNo;

	/**
	 * @Fields  : 续保期限日
	 * @author ningyangyang
	 */
	private Date renewalDeadlineDate;

	/**
	 * @Fields  : 续保任务状态
	 * @author ningyangyang
	 */
	private String renewalStatus;

	/**
	 * @Fields  : 审批人
	 * @author ningyangyang
	 */
	private String presentUser;


	/**
	 * @Fields  : 参考融资额
	 * @author ningyangyang
	 */
	private BigDecimal finAmount;

	/**
	 * @Fields  : 是否融资
	 * @author ningyangyang
	 */
	private String finFlag;

	/**
	 * @Fields  : 续保保险信息ID
	 * @author ningyangyang
	 */
	private String renewalContVehinsId;

	/**
	 * @Fields  : 续保任务号
	 * @author ningyangyang
	 */
	private String renewalTaskNo;

	/**
	 * @Fields  : 保险购买方式
	 * @author ningyangyang
	 */
	private String insurPurType;

	/**
	 * @Fields  : 客户打款金额
	 * @author ningyangyang
	 */
	private BigDecimal customPaymentAmount;

	/**
	 * @Fields  : 当前保险信息ID
	 * @author ningyangyang
	 */
	private String currentInsuranceId;

	/**
	 * @Fields  : 保险卡快递单号
	 * @author ningyangyang
	 */
	private String insurancePostNo;

}