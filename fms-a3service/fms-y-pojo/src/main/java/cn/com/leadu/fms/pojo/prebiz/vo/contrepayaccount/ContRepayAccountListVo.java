package cn.com.leadu.fms.pojo.prebiz.vo.contrepayaccount;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepayAccount;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContRepayAccountVo
 * @Description: 客户融资合同还款信息一览查询载体
 * @date 2018-03-23
 */
@Data
public class ContRepayAccountListVo extends PageQuery<ContRepayAccount> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 还款信息ID
	 */
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
	 * @Fields  : 定金是否抵扣车款
	 */
	private String deductibleFees;

	/**
	 * @Fields  : 还款信息ID
	 */
	private List<String> repayAccIds;

	/******************************    客户个人/企业基本信息    *****************/
	/**
	 * @Fields  : 客户姓名
	 */
	private String name;
	/**
	 * @Fields  : 客户证件号码
	 */
	private String cstmCertifNo;
	/**
	 * @Fields  : 个人标志
	 */
	private String personFlag;
	/**
	 * @Fields  : 企业标志
	 */
	private String companyFlag;

	/******************************    合同状态    *****************/
	/**
	 * @Fields  :合同状态
	 */
	private String bizStatus;

}