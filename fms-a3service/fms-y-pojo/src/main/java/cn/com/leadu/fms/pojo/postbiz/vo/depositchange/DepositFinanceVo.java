package cn.com.leadu.fms.pojo.postbiz.vo.depositchange;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author yanfengbo
 * @ClassName: DepositFinanceVo
 * @Description: 增加保证金财务收款载体
 */
@Data
public class DepositFinanceVo extends PageQuery<DepositFinanceVo> {

	private static final long serialVersionUID = 1L;


	/**
	 * @Fields : 收款银行
	 * @author huzongcheng
	 */
	private String recAccBank;

	/**
	 * @Fields : 收款银行
	 * @author huzongcheng
	 */
	private String recAccBranch;
	/**
	 * @Fields : 收款账号
	 * @author huzongcheng
	 */
	private String recAccountNo;

	/**
	 * @Fields : 收款户名
	 * @author huzongcheng
	 */
	private String recAccountName;

	/**
	 * @Fields : 收款联行号
	 * @author huzongcheng
	 */
	private String recEleBankNo;

	/**
	 * @Fields :  付款银行
	 */
	private String payAccBank;

	/**
	 * @Fields :  付款银行
	 */
	private String payAccBranch;
	/**
	 * @Fields : 付款账号
	 */
	private String payAccountNo;

	/**
	 * @Fields : 付款户名
	 */
	private String payAccountName;

	/**
	 * @Fields :  付款联行号
	 */
	private String payEleBankNo;

	/**
	 * @Fields : 实收金额
	 * @author huzongcheng
	 */
	private BigDecimal receiptAmount;

	/**
	 * @Fields : 备注
	 * @author huzongcheng
	 */
	private String memo;

	/**
	 * @Fields : 到账日期
	 * @author huzongcheng
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date receiptDate;
}
