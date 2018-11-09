package cn.com.leadu.fms.pojo.finance.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherData
 * @Description: 财务凭证数据实体
 * @date 2018-06-25
 */
@Data
public class FinancialVoucherData extends BaseEntity<FinancialVoucherData> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 财务凭证id
	 * @author qiaomengnan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String voucherDataId;

	/**
	 * @Fields  : 业务号
	 * @author qiaomengnan
	 */
	private String voucherBizCode;

	/**
	 * @Fields  : 业务日期
	 * @author qiaomengnan
	 */
	private Date voucherBizDate;

	/**
	 * @Fields  : 凭证类型
	 * @author qiaomengnan
	 */
	private String voucherType;

	/**
	 * @Fields  : 凭证号
	 * @author qiaomengnan
	 */
	private String voucherNo;

	/**
	 * @Fields  : 分录号
	 * @author qiaomengnan
	 */
	private Integer voucherDetailNo;

	/**
	 * @Fields  : 核算账簿
	 * @author qiaomengnan
	 */
	private String voucherAccountNo;

	/**
	 * @Fields  : 附单据数
	 * @author qiaomengnan
	 */
	private Integer attachCount;

	/**
	 * @Fields  : 摘要格式
	 * @author qiaomengnan
	 */
	private String summary;

	/**
	 * @Fields  : 科目代码
	 * @author qiaomengnan
	 */
	private String subjectCd;

	/**
	 * @Fields  : 贷方金额
	 * @author qiaomengnan
	 */
	private BigDecimal creditAmount;

	/**
	 * @Fields  : 借贷方向
	 * @author qiaomengnan
	 */
	private String crdrFlag;

	/**
	 * @Fields  : 借方金额
	 * @author qiaomengnan
	 */
	private BigDecimal debitAmount;

}