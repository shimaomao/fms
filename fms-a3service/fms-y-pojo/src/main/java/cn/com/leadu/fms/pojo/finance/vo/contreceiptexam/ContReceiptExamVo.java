package cn.com.leadu.fms.pojo.finance.vo.contreceiptexam;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.entity.ContReceiptExam;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: ContReceiptExamVo
 * @Description: 财务勾稽载体
 * @date 2018-05-09
 */
@Data
public class ContReceiptExamVo extends PageQuery<ContReceiptExam> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 财务勾稽Id
	 * @author lijunjun
	 */
	private String contReceiptExamId;

	/**
	 * @Fields  : 收款业务类型
	 * @author lijunjun
	 */
	private String receiptBizType;

	/**
	 * @Fields  : 收款业务ID
	 * @author lijunjun
	 */
	private String receiptBizId;

	/**
	 * @Fields  : 财务收款ID
	 * @author lijunjun
	 */
	private String contReceiptId;

	/**
	 * @Fields  : 勾稽状态
	 * @author lijunjun
	 */
	private String examType;

	/**
	 * @Fields  : 勾稽金额
	 * @author lijunjun
	 */
	private BigDecimal receiptExamAmount;

	/**
	 * @Fields  : 勾稽状态
	 * @author lijunjun
	 */
	private String receiptExamStatus;

	/**
	 * @Fields  : 财务勾稽Id
	 * @author lijunjun
	 */
	private List<String> contReceiptExamIds;

	/**
	 * @Fields  : 凭证生成状态
	 * @author yangyiquan
	 */
	private String voucherStatus;

}