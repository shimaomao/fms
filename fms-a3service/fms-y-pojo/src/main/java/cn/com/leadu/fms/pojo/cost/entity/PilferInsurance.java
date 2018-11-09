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
 * @ClassName: PilferInsurance
 * @Description: 盗抢险信息实体
 * @date 2018-05-31
 */
@Data
public class PilferInsurance extends BaseEntity<PilferInsurance> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 盗抢险信息id
	 * @author yangyiquan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String pilferInsuranceId;

	/**
	 * @Fields  : 合同编号
	 * @author yangyiquan
	 */
	private String contNo;

	/**
	 * @Fields  : gps厂商
	 * @author yangyiquan
	 */
	private String gpsSeller;

	/**
	 * @Fields  : 第一受益人
	 * @author yangyiquan
	 */
	private String firstBeneficiary;

	/**
	 * @Fields  : 有线设备号
	 * @author yangyiquan
	 */
	private String wiredDeviceNo;

	/**
	 * @Fields  : 无线设备号
	 * @author yangyiquan
	 */
	private String wirelessDeviceNo;

	/**
	 * @Fields  : 新车购置价
	 * @author yangyiquan
	 */
	private BigDecimal purchasePrice;

	/**
	 * @Fields  : 最高赔偿限额
	 * @author yangyiquan
	 */
	private BigDecimal maximumCompensation;

	/**
	 * @Fields  : 盗抢险费用
	 * @author yangyiquan
	 */
	private BigDecimal pilferInsuranceCost;

	/**
	 * @Fields  : 年限
	 * @author yangyiquan
	 */
	private Integer timeLimit;

	/**
	 * @Fields  : 盗抢险月结任务号
	 * @author yangyiquan
	 */
	private String monthlyPilferInsuranceNo;

	/**
	 * @Fields  : 账单盗抢险费用
	 * @author yangyiquan
	 */
	private BigDecimal billPilferInsuranceCost;

	/**
	 * @Fields  : 备注
	 * @author yangyiquan
	 */
	private String memo;

	/**
	 * @Fields  : 账单月
	 * @author ningyangyang
	 */
	private String billMonth;

}