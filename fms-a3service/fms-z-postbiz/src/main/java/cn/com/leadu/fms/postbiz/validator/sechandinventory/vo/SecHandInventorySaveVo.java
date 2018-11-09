package cn.com.leadu.fms.postbiz.validator.sechandinventory.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.SecHandInventory;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author qinmuqiao
 * @ClassName: SecHandInventoryVo
 * @Description: 库存管理保存时载体及验证
 */
@Data
public class SecHandInventorySaveVo extends BaseVo<SecHandInventory> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 二手车id
	 * @author qinmuqiao
	 */
	private String secHandId;

	/**
	 * @Fields  : 车架号
	 * @author qinmuqiao
	 */
	@NotBlank(message = "车架号不能为空")
	private String vinNo;

	/**
	 * @Fields  : 发动机号
	 * @author qinmuqiao
	 */
	@NotBlank(message = "发动机号不能为空")
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
	@NotBlank(message = "车型不能为空")
	private String vehicleCode;

	/**
	 * @Fields  : 行驶公里数
	 * @author qinmuqiao
	 */
	@NotNull(message = "行驶公里数不能为空")
	private BigDecimal miles;

	/**
	 * @Fields  : 登记日期
	 * @author qinmuqiao
	 */
	@NotNull(message = "登记日期不能为空")
	private Date registDate;

	/**
	 * @Fields  : 车龄
	 * @author qinmuqiao
	 */
	@NotNull(message = "车龄不能为空")
	private BigDecimal vehAgeMonths;

	/**
	 * @Fields  : 出厂日期
	 * @author qinmuqiao
	 */
	@NotNull(message = "出厂日期不能为空")
	private Date produceDate;

	/**
	 * @Fields  : 车辆评估价
	 * @author qinmuqiao
	 */
	@NotNull(message = "车辆评估价不能为空")
	private BigDecimal evaluationPrice;

	/**
	 * @Fields  : 状态
	 * @author qinmuqiao
	 */
	@NotBlank(message = "状态不能为空")
	private String status;

	/**
	 * @Fields  : 二手车来源 0-新增；1-收车
	 * @author qinmuqiao
	 */
	private String carSource;

	/**
	 * @Fields  : 收车任务号
	 * @author qinmuqiao
	 */
	private String recoveryTaskNo;

}