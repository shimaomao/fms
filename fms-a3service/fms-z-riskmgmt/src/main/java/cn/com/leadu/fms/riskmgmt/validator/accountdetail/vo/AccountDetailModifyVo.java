package cn.com.leadu.fms.riskmgmt.validator.accountdetail.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.AccountDetail;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author liujinge
 * @ClassName: AccountDetailVo
 * @Description: 银行流水修改时载体及验证
 * @date 2018-06-04
 */
@Data
public class AccountDetailModifyVo extends BaseVo<AccountDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 银行流水id
	 * @author liujinge
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
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