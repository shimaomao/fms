package cn.com.leadu.fms.finance.validator.financialvoucher.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucher;
import lombok.Data;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: FinancialVoucherVo
 * @Description: 凭证类型管理保存时载体及验证
 * @date 2018-06-20
 */
@Data
public class FinancialVoucherSaveVo extends BaseVo<FinancialVoucher> {

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

}