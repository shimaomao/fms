package cn.com.leadu.fms.pojo.finance.vo.financialvoucherassis;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherAssis;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherAssisVo
 * @Description: 财务凭证核算数据载体
 * @date 2018-06-26
 */
@Data
public class FinancialVoucherAssisVo extends PageQuery<FinancialVoucherAssis> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 财务凭证核算id
	 * @author qiaomengnan
	 */
	private String voucherAssisId;

	/**
	 * @Fields  : 财务凭证id
	 * @author qiaomengnan
	 */
	private String voucherDataId;

	/**
	 * @Fields  : 辅助核算类型
	 * @author qiaomengnan
	 */
	private String assisAccountType;

	/**
	 * @Fields  : 辅助核算序号
	 * @author qiaomengnan
	 */
	private Integer assisAccountOrder;

	/**
	 * @Fields  : 核算项目值
	 * @author qiaomengnan
	 */
	private String assisAccountValue;

	/**
	 * @Fields  : 财务凭证核算id
	 * @author qiaomengnan
	 */
	private List<String> voucherAssisIds;

	/** 
	 * @Fields  : 辅助核算类型名称
	 * @author qiaomengnan
	 */ 
	private String assisAccountTypeName;

	/**
	 * @Fields  : 财务凭证id
	 * @author qiaomengnan
	 */
	private List<String> vouDataIds;

	/**
	 * @Fields  : 核算类型 企业
	 * @author qiaomengnan
	 */
	private String itemCompany;

	/**
	 * @Fields  : 核算类型 个人
	 * @author qiaomengnan
	 */
	private String itemCustom;

}