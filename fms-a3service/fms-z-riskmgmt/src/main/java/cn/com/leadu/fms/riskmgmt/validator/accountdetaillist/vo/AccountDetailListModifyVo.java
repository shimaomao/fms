package cn.com.leadu.fms.riskmgmt.validator.accountdetaillist.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.AccountDetailList;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author liujinge
 * @ClassName: AccountDetailListVo
 * @Description: 银行流水明细修改时载体及验证
 * @date 2018-06-04
 */
@Data
public class AccountDetailListModifyVo extends BaseVo<AccountDetailList> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 银行流水明细id
	 * @author liujinge
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String accountDetailListId;

	/**
	 * @Fields  : 银行流水id
	 * @author liujinge
	 */
	private String accountDetailId;

	/**
	 * @Fields  : 年月
	 * @author liujinge
	 */
	private String yearMon;

	/**
	 * @Fields  : 流入量
	 * @author liujinge
	 */
	private BigDecimal income;

	/**
	 * @Fields  : 倒账金额
	 * @author liujinge
	 */
	private BigDecimal receipt;

	/**
	 * @Fields  : 实际流入量
	 * @author liujinge
	 */
	private BigDecimal actualIncome;

}