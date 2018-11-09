package cn.com.leadu.fms.pojo.cost.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author yangyiquan
 * @ClassName: ContPrepayDetail
 * @Description: 提前还款明细实体
 * @date 2018-05-11
 */
@Data
public class ContPrepayDetail extends BaseEntity<ContPrepayDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 提前还款明细ID
	 * @author yangyiquan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String contPrepayDetailId;

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
	 * @Fields  : 提前还款明细类型
	 * @author yangyiquan
	 */
	private String prepaymDetailItem;

	/**
	 * @Fields  : 提前还款明细参考金额
	 * @author yangyiquan
	 */
	private BigDecimal prepayTrialAmount;

	/**
	 * @Fields  : 提前还款明细实际金额
	 * @author yangyiquan
	 */
	private BigDecimal prepayActualAmount;

	/**
	 * @Fields  : 排序
	 * @author yangyiquan
	 */
	private Integer orderNo;

	/**
	 * @Fields  : 备注
	 * @author yangyiquan
	 */
	private String memo;

}