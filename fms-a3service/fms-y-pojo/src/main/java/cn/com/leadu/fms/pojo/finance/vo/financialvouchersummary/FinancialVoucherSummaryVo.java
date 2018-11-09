package cn.com.leadu.fms.pojo.finance.vo.financialvouchersummary;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherSummary;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherSummaryVo
 * @Description: 财务凭证管理载体
 * @date 2018-07-21
 */
@Data
public class FinancialVoucherSummaryVo extends PageQuery<FinancialVoucherSummary> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 财务凭证管理id
	 * @author qiaomengnan
	 */
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
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
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
	 * @Fields  : 凭证类型名称
	 * @author qiaomengnan
	 */
	private String voucherTypeName;

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

	/**
	 * @Fields  : 财务凭证管理id
	 * @author qiaomengnan
	 */
	private List<String> voucherSummaryIds;

	/**
	 * @Fields  : 出租人
	 * @author yanfengbo
	 */
	private String groupName;

	/**
	 * @Fields  : 承租人
	 * @author yanfengbo
	 */
	private String name;

	/**
	 * @Fields  : 开始日期(业务日期)
	 * @author yanfengbo
	 */
	private String startTime;

	/**
	 * @Fields  : 结束日期(业务日期)
	 * @author yanfengbo
	 */
	private String endTime;

}