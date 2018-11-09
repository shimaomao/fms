package cn.com.leadu.fms.pojo.prebiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author liujinge
 * @ClassName: ContPay
 * @Description: 财务付款表实体
 * @date 2018-04-11
 */
@Data
public class ContPay extends BaseEntity<ContPay> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 付款ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String contPayId;

	/**
	 * @Fields  : 业务类型
	 */
	private String paymentType;

	/**
	 * @Fields  : 业务关联号
	 */
	private String bizCode;

	/**
	 * @Fields  : 付款状态
	 */
	private String payStatus;

	/**
	 * @Fields  : 付款金额
	 */
	private BigDecimal payAmount;

	/**
	 * @Fields  : 付款日期
	 */
	private Date payDate;

	/**
	 * @Fields  : 付款人员
	 */
	private String user;

	/**
	 * @Fields  : 付款机构
	 */
	private String groupCode;

	/**
	 * @Fields  :  付款机构银行序号
	 */
	private String groupBankNo;

	/**
	 * @Fields  : 付款银行
	 */
	private String payAccBank;

	/**
	 * @Fields  : 付款账号
	 */
	private String payAccountNo;

	/**
	 * @Fields  : 付款户名
	 */
	private String payAccountName;

	/**
	 * @Fields  :  付款联行号
	 */
	private String payEleBankNo;

	/**
	 * @Fields  : 收款银行
	 */
	private String recAccBank;

	/**
	 * @Fields  : 收款账号
	 */
	private String recAccountNo;

	/**
	 * @Fields  : 收款户名
	 */
	private String recAccountName;

	/**
	 * @Fields  : 收款联行号
	 */
	private String recEleBankNo;

	/**
	 * @Fields  :  付款款项
	 */
	private String payFund;

	/**
	 * @Fields  : 付款银行分行
	 * @author lijunjun
	 */
	private String payAccBranch;

	/**
	 * @Fields  : 收款银行分行
	 * @author lijunjun
	 */
	private String recAccBranch;

}