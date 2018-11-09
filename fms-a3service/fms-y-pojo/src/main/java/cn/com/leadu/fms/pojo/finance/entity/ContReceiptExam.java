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
 * @author lijunjun
 * @ClassName: ContReceiptExam
 * @Description: 财务勾稽实体
 * @date 2018-05-09
 */
@Data
public class ContReceiptExam extends BaseEntity<ContReceiptExam> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 财务勾稽Id
	 * @author lijunjun
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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
	 * @Fields  : 凭证生成状态
	 * @author yangyiquan
	 */
	private String voucherStatus;

}