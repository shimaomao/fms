package cn.com.leadu.fms.insurance.validator.renewalregister.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.insurance.entity.RenewalRegister;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author yanfengbo
 * @ClassName: RenewalRegisterVo
 * @Description: 续保任务一览保存时载体及验证
 * @date 2018-05-17
 */
@Data
public class RenewalRegisterSaveVo extends BaseVo<RenewalRegister> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 续保任务ID
	 * @author yanfengbo
	 */
	private String renewalRegisterId;

	/**
	 * @Fields  : 合同编号
	 * @author yanfengbo
	 */
	private String contNo;

	/**
	 * @Fields  : 续保期限日
	 * @author yanfengbo
	 */
	private Date renewalDeadlineDate;

	/**
	 * @Fields  : 续保任务状态
	 * @author yanfengbo
	 */
	private String renewalStatus;

	/**
	 * @Fields  : 审批人
	 * @author ningyangyang
	 */
	private String presentUser;

	/**
	 * @Fields  : 参考融资额
	 * @author yanfengbo
	 */
	private BigDecimal finAmount;

	/**
	 * @Fields  : 是否融资
	 * @author yanfengbo
	 */
	private String finFlag;

	/**
	 * @Fields  : 续保保险信息ID
	 * @author yanfengbo
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