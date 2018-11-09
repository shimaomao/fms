package cn.com.leadu.fms.finance.validator.contreceiptexam.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.ContReceiptExam;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: ContReceiptExamVo
 * @Description: 财务勾稽修改时载体及验证
 * @date 2018-05-09
 */
@Data
public class ContReceiptExamModifyVo extends BaseVo<ContReceiptExam> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 财务勾稽Id
	 * @author lijunjun
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
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

}