package cn.com.leadu.fms.pojo.prebiz.vo.contpay;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * @author liujinge
 * @ClassName: ContPayVo
 * @Description: 财务付款表载体
 * @date 2018-04-11
 */
@Data
public class ContPayVo extends PageQuery<ContPay> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	private String contPayId;

	/**
	 * @Fields  : 
	 */
	private String paymentType;

	/**
	 * @Fields  : 
	 */
	private String bizCode;

	/**
	 * @Fields  : 
	 */
	private String payStatus;

	/**
	 * @Fields  : 
	 */
	private BigDecimal payAmount;

	/**
	 * @Fields  : 
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date payDate;

	/**
	 * @Fields  : 
	 */
	private String user;

	/**
	 * @Fields  : 
	 */
	private String groupCode;

	/**
	 * @Fields  :
	 */
	private String groupName;

	/**
	 * @Fields  : 
	 */
	private String groupBankNo;

	/**
	 * @Fields  : 
	 */
	private String payAccBank;

	/**
	 * @Fields  : 
	 */
	private String payAccountNo;

	/**
	 * @Fields  : 
	 */
	private String payAccountName;

	/**
	 * @Fields  :  付款联行号
	 */
	private String payEleBankNo;

	/**
	 * @Fields  : 
	 */
	private String recAccBank;

	/**
	 * @Fields  : 
	 */
	private String recAccountNo;

	/**
	 * @Fields  : 
	 */
	private String recAccountName;

	/**
	 * @Fields  : 收款联行号
	 */
	private String recEleBankNo;

	/**
	 * @Fields  : 
	 */
	private List<String> contPayIds;

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

	// 分界线-----------------------
	/**
	 * @Fields  :  融资合同编号
	 */
	private String contractNo;

	/**
	 * @Fields  :  融资申请编号
	 */
	private String applyNo;

	/**
	 * @Fields  :  承租人
	 */
	private String userName;

	/**
	 * @Fields  :  产品方案名称
	 */
	private String productName;

	/**
	 * @Fields  :  租赁属性
	 */
	private String licenseAttr;

	/**
	 * @Fields  :  融资期限
	 */
	private String finPeriodType;

	/**
	 * @Fields  :  付款类型标志位
	 */
	private String paymentTypeFlag;

	/**
	 * @Fields  :扣款状态
	 */
	private String repayStatus;

	/**
	 * @Fields  :  已收首付
	 */
	private BigDecimal accInitAmount;

	/**
	 * @Fields  :  应收尾款
	 */
	private BigDecimal needfFinalAmount;

	/**
	 * @Fields  :  已收尾款
	 */
	private BigDecimal accFinalAmount;

	/**
	 * @Fields  :  融资金额
	 */
	private String finTotal;

	/**
	 * @Fields  :  应收租金
	 */
	private BigDecimal rent;

	/**
	 * @Fields  :  应收利息
	 */
	private BigDecimal interest;

	/**
	 * @Fields  :  累计已收租金
	 */
	private BigDecimal actualAccRent;

	/**
	 * @Fields  :  累计已收利息
	 */
	private BigDecimal actualAccInterest;

	/**
	 * @Fields  :  应收首付金额
	 */
	private BigDecimal initAmount;

	/**
	 * @Fields  :  尾付
	 */
	private BigDecimal finalAmount;

}