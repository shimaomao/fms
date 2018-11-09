package cn.com.leadu.fms.pojo.finance.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherSummary
 * @Description: 财务凭证管理实体
 * @date 2018-07-21
 */
@Data
public class FinancialVoucherSummary extends BaseEntity<FinancialVoucherSummary> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 财务凭证管理id
	 * @author qiaomengnan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String voucherSummaryId;

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
	 * @Fields  : 凭证区域
	 * @author qiaomengnan
	 */
	private String voucherGroup;

	/**
	 * @Fields  : 财务凭证号
	 * @author qiaomengnan
	 */
	private String voucherNo;

	/**
	 * @Fields  : 发送状态  0-未发送；1-发送成功；2-发送失败
	 * @author qiaomengnan
	 */
	private String sendStatus;

	/**
	 * @Fields  : 发送批次号 最后一条发送批次号
	 * @author qiaomengnan
	 */
	private String sendBatchNo;

}