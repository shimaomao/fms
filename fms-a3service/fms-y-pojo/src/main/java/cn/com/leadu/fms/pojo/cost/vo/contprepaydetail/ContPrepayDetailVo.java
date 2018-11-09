package cn.com.leadu.fms.pojo.cost.vo.contprepaydetail;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.cost.entity.ContPrepayDetail;
import lombok.Data;
import java.util.List;
import java.math.BigDecimal;

/**
 * @author yangyiquan
 * @ClassName: ContPrepayDetailVo
 * @Description: 提前还款明细载体
 * @date 2018-05-11
 */
@Data
public class ContPrepayDetailVo extends PageQuery<ContPrepayDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 提前还款明细ID
	 * @author yangyiquan
	 */
	private String contPrepayDetailId;

	/**
	 * @Fields  : 提前还款业务号
	 * @author yangyiquan
	 */
	private String contPrepaymentNo;

	/**
	 * @Fields  : 合同编号
	 * @author yangyiquan
	 */
	private String contNo;

	/**
	 * @Fields  : 提前还款明细类型
	 * @author yangyiquan
	 */
	private String prepaymDetailItem;

	/**
	 * @Fields  : 提前还款明细参考金额
	 * @author yangyiquan
	 */
	private BigDecimal prepayTrialAmount;

	/**
	 * @Fields  : 提前还款明细实际金额
	 * @author yangyiquan
	 */
	private BigDecimal prepayActualAmount;

	/**
	 * @Fields  : 排序
	 * @author yangyiquan
	 */
	private Integer orderNo;

	/**
	 * @Fields  : 备注
	 * @author yangyiquan
	 */
	private String memo;

	/**
	 * @Fields  : 提前还款明细ID
	 * @author yangyiquan
	 */
	private List<String> contPrepayDetailIds;

}