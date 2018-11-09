package cn.com.leadu.fms.prebiz.validator.rationalitypurchase.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.RationalityPurchase;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ningyangyang
 * @ClassName: RationalityPurchaseVo
 * @Description: 购买合理性修改时载体及验证
 * @date 2018-05-29
 */
@Data
public class RationalityPurchaseModifyVo extends BaseVo<RationalityPurchase> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 购车原因id
	 * @author ningyangyang
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String buyCarId;

	/**
	 * @Fields  : 申请编号
	 * @author ningyangyang
	 */
	private String applyNo;

	/**
	 * @Fields  : 客户来源
	 * @author ningyangyang
	 */
	private String customerSource;

	/**
	 * @Fields  : 购车目的
	 * @author ningyangyang
	 */
	private String purposePurchase;

	/**
	 * @Fields  : 选择原因
	 * @author ningyangyang
	 */
	private String chooseReason;

	/**
	 * @Fields  : 原有车辆
	 * @author ningyangyang
	 */
	private String originalVehicle;

	/**
	 * @Fields  : 购买时间
	 * @author ningyangyang
	 */
	private Date purchaseTime;

	/**
	 * @Fields  : 购买价格
	 * @author ningyangyang
	 */
	private BigDecimal price;

}