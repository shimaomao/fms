package cn.com.leadu.fms.pojo.prebiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import cn.com.leadu.fms.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ningyangyang
 * @ClassName: RationalityPurchase
 * @Description: 购买合理性实体
 * @date 2018-05-29
 */
@Data
public class RationalityPurchase extends BaseEntity<RationalityPurchase> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 购车原因id
	 * @author ningyangyang
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date purchaseTime;

	/**
	 * @Fields  : 购买价格
	 * @author ningyangyang
	 */
	private BigDecimal price;

}