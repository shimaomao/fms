package cn.com.leadu.fms.pojo.finance.vo.financialvoucher;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucher;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: FinancialVoucherVo
 * @Description: 凭证类型管理载体
 * @date 2018-06-20
 */
@Data
public class FinancialVoucherVo extends PageQuery<FinancialVoucher> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 凭证类型id
	 * @author ningyangyang
	 */
	private String voucherId;

	/**
	 * @Fields  : 凭证类型
	 * @author ningyangyang
	 */
	private String voucherType;

	/**
	 * @Fields  : 凭证类型名称
	 * @author ningyangyang
	 */
	private String voucherName;

	/**
	 * @Fields  : 凭证类型备注
	 * @author ningyangyang
	 */
	private String voucherMemo;

	/**
	 * @Fields  : 凭证类型id
	 * @author ningyangyang
	 */
	private List<String> voucherIds;

}