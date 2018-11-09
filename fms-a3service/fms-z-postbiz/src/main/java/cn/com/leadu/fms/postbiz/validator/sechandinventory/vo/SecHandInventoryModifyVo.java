package cn.com.leadu.fms.postbiz.validator.sechandinventory.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.SecHandInventory;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author qinmuqiao
 * @ClassName: SecHandInventoryVo
 * @Description: 库存管理修改时载体及验证
 */
@Data
public class SecHandInventoryModifyVo extends BaseVo<SecHandInventory> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 二手车id
	 * @author qinmuqiao
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String secHandId;

	/**
	 * @Fields  : 车架号
	 * @author qinmuqiao
	 */
	private String vinNo;

	/**
	 * @Fields  : 发动机号
	 * @author qinmuqiao
	 */
	private String engineNo;

	/**
	 * @Fields  : 颜色
	 * @author qinmuqiao
	 */
	private String color;

	/**
	 * @Fields  : 车型
	 * @author qinmuqiao
	 */
	private String vehicleCode;

	/**
	 * @Fields  : 行驶公里数
	 * @author qinmuqiao
	 */
	private BigDecimal miles;

	/**
	 * @Fields  : 登记日期
	 * @author qinmuqiao
	 */
	private Date registDate;

	/**
	 * @Fields  : 车龄
	 * @author qinmuqiao
	 */
	private BigDecimal vehAgeMonths;

	/**
	 * @Fields  : 出厂日期
	 * @author qinmuqiao
	 */
	private Date produceDate;

	/**
	 * @Fields  : 车辆评估价
	 * @author qinmuqiao
	 */
	private BigDecimal evaluationPrice;

	/**
	 * @Fields  : 状态
	 * @author qinmuqiao
	 */
	private String status;

	/**
	 * @Fields  : 二手车来源
	 * @author qinmuqiao
	 */
	private String carSource;

	/**
	 * @Fields  : 收车任务号
	 * @author qinmuqiao
	 */
	private String recoveryTaskNo;

}