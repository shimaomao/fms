package cn.com.leadu.fms.pojo.prebiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author liujinge
 * @ClassName: ContRepayAccount
 * @Description: 融资合同还款信息实体
 * @date 2018-03-23
 */
@Data
public class ContRepayAccount extends BaseEntity<ContRepayAccount> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 还款信息ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String repayAccId;

	/**
	 * @Fields  : 合同编号
	 */
	private String contNo;

	/**
	 * @Fields  : 订单编号
	 */
	private String applyNo;

	/**
	 * @Fields  : 车辆序号
	 */
	private String vehicleNo;

	/**
	 * @Fields  : 还款借记卡户名
	 */
	private String accountName;

	/**
	 * @Fields  : 还款借记卡开户证件号码
	 */
	private String certifNo;

	/**
	 * @Fields  : 还款卡绑定手机号
	 */
	private String accMobileNo;

	/**
	 * @Fields  : 还款借记卡开户行
	 */
	private String accBank;

	/**
	 * @Fields  : 还款借记卡帐号
	 */
	private String accountNo;

}