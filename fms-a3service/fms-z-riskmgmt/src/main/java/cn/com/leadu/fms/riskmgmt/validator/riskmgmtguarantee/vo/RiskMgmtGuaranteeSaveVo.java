package cn.com.leadu.fms.riskmgmt.validator.riskmgmtguarantee.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtGuarantee;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author liujinge
 * @ClassName: RiskMgmtGuaranteeVo
 * @Description: 风控担保人信息保存时载体及验证
 * @date 2018-06-04
 */
@Data
public class RiskMgmtGuaranteeSaveVo extends BaseVo<RiskMgmtGuarantee> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 风控企业信息id
	 * @author liujinge
	 */
	private String riskMgmtGuaranteeId;

	/**
	 * @Fields  : 申请编号
	 * @author liujinge
	 */
	private String applyNo;

	/**
	 * @Fields  : 担保人
	 * @author liujinge
	 */
	private String guaranteeName;

	/**
	 * @Fields  : 担保人月收入总额
	 * @author liujinge
	 */
	private BigDecimal guaranteeAmount;

	/**
	 * @Fields  : 担保人收入负债比
	 * @author liujinge
	 */
	private BigDecimal guaranteeDebtRatio;

	/**
	 * @Fields  : 担保人月还贷金额
	 * @author liujinge
	 */
	private BigDecimal guaranteeRepay;

}