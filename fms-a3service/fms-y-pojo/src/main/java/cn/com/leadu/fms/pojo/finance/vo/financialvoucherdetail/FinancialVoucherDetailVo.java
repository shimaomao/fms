package cn.com.leadu.fms.pojo.finance.vo.financialvoucherdetail;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.entity.AssisAccountType;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherDetail;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author ningyangyang
 * @ClassName: FinancialVoucherDetailVo
 * @Description: 凭证类型明细管理载体
 * @date 2018-06-20
 */
@Data
public class FinancialVoucherDetailVo extends PageQuery<FinancialVoucherDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 凭证明细id
	 * @author ningyangyang
	 */
	private String voucherDetailId;

	/**
	 * @Fields  : 凭证类型
	 * @author ningyangyang
	 */
	private String voucherType;

	/**
	 * @Fields  : 分录号
	 * @author ningyangyang
	 */
	private Integer voucherDetailNo;

	/**
	 * @Fields  : 核算账簿
	 * @author ningyangyang
	 */
	private String voucherAccountNo;


	/**
	 * @Fields  : 附单据数
	 * @author ningyangyang
	 */
	private Integer attachCount;

	/**
	 * @Fields  : 科目代码
	 * @author ningyangyang
	 */
	private String subjectCd;

	/**
	 * @Fields  : 科目代码动态值
	 * @author qiaomengnan
	 */
	private String subjectCdDyn;

	/**
	 * @Fields  : 科目名称
	 * @author ningyangyang
	 */
	private String subjectName;

	/**
	 * @Fields  : 摘要格式
	 * @author ningyangyang
	 */
	private String summary;

	/**
	 * @Fields  : 借贷方向
	 * @author ningyangyang
	 */
	private String crdrFlag;

	/**
	 * @Fields  : 借方金额
	 * @author ningyangyang
	 */
	private String debitAmountItem;

	/**
	 * @Fields  : 贷方金额
	 * @author ningyangyang
	 */
	private String creditAmountItem;


	/**
	 * @Fields  : 是否循环
	 * @author ningyangyang
	 */
	private String cycleFlag;

	/**
	 * @Fields  : 循环对象
	 * @author ningyangyang
	 */
	private String cycleList;

	/**
	 * @Fields  : 备注
	 * @author ningyangyang
	 */
	private String voucherDetailMemo;

	/**
	 * @Fields  : 凭证明细id
	 * @author ningyangyang
	 */
	private List<String> voucherDetailIds;

	/**
	 * @Fields  : 凭证类型名称
	 * @author ningyangyang
	 */
	private String voucherName;

	/**
	 * @Fields  : 辅助核算类型
	 * @author ningyangyang
	 */
	private List<AssisAccountType> AssisAccountTypes;

	/**
	 * @Fields  : 辅助核算类型名称
	 * @author yanfengbo
	 */
	private String assisAccountTypeName;

}