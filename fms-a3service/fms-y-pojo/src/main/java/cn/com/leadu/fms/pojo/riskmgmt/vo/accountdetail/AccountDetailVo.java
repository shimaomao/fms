package cn.com.leadu.fms.pojo.riskmgmt.vo.accountdetail;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.riskmgmt.entity.AccountDetail;
import cn.com.leadu.fms.pojo.riskmgmt.entity.AccountDetailList;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: AccountDetailVo
 * @Description: 银行流水载体
 * @date 2018-06-04
 */
@Data
@EqualsAndHashCode(of = { "relation", "name" })
public class AccountDetailVo extends PageQuery<AccountDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 银行流水id
	 * @author liujinge
	 */
	private String accountDetailId;

	/**
	 * @Fields  : 申请编号
	 * @author liujinge
	 */
	private String applyNo;

	/**
	 * @Fields  : 关系类型
	 * @author liujinge
	 */
	private String relation;

	/**
	 * @Fields  : 姓名
	 * @author liujinge
	 */
	private String name;

	/**
	 * @Fields  : 银行
	 * @author liujinge
	 */
	private String bankName;

	/**
	 * @Fields  : 银行账号
	 * @author liujinge
	 */
	private String accountNo;

	/**
	 * @Fields  : 合计流入量
	 * @author liujinge
	 */
	private BigDecimal incomeSum;

	/**
	 * @Fields  : 合计到账金额
	 * @author liujinge
	 */
	private BigDecimal receiptSum;

	/**
	 * @Fields  : 合计实际流入量
	 * @author liujinge
	 */
	private BigDecimal actualIncomeSum;

	/**
	 * @Fields  : 平均流入量
	 * @author liujinge
	 */
	private BigDecimal incomeAver;

	/**
	 * @Fields  : 平均到账金额
	 * @author liujinge
	 */
	private BigDecimal receiptAver;

	/**
	 * @Fields  : 平均实际流入量
	 * @author liujinge
	 */
	private BigDecimal actualIncomeAver;

	/**
	 * @Fields  : 平均季度结息
	 * @author liujinge
	 */
	private BigDecimal quarterIntrest;

	/**
	 * @Fields  : 日均存款结余余额
	 * @author liujinge
	 */
	private BigDecimal dayIntrest;

	/**
	 * @Fields  : 流水余额
	 * @author liujinge
	 */
	private BigDecimal remainSum;

	/**
	 * @Fields  : 分析
	 * @author liujinge
	 */
	private String accountMemo;

	/**
	 * @Fields  : 银行流水id
	 * @author liujinge
	 */
	private List<String> accountDetailIds;

	/**
	 * @Fields  : 银行流水明细
	 * @author liujinge
	 */

	private List<AccountDetailList> AccountDetailLists;
}