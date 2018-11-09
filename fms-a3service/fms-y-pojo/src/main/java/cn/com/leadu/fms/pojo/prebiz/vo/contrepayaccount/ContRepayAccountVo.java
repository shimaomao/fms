package cn.com.leadu.fms.pojo.prebiz.vo.contrepayaccount;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepayAccount;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContRepayAccountVo
 * @Description: 融资合同还款信息载体
 * @date 2018-03-23
 */
@Data
public class ContRepayAccountVo extends PageQuery<ContRepayAccount> {

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
	 * @Fields  : 还款借记卡帐号
	 */
	private String accountNo;

	/**
	 * @Fields  : 还款信息ID
	 */
	private List<String> repayAccIds;

}