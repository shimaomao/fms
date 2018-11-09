package cn.com.leadu.fms.pojo.riskmgmt.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author liujinge
 * @ClassName: AccountDetail
 * @Description: 银行流水实体
 * @date 2018-06-04
 */
@Data
public class AccountDetail extends BaseEntity<AccountDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 银行流水id
	 * @author liujinge
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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

}