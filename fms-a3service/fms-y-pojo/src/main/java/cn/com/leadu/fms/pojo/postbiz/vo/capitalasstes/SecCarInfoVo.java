package cn.com.leadu.fms.pojo.postbiz.vo.capitalasstes;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wangxue
 * @ClassName: VehicleDisposalVo
 * @Description: 二手车库存载体
 */
@Data
public class SecCarInfoVo {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 车架号
	 * @author huzongcheng
	 */
	private String vinNo;

	/**
	 * @Fields  : 发动机号
	 * @author huzongcheng
	 */
	private String engineNo;

	/**
	 * @Fields  : 颜色
	 * @author huzongcheng
	 */
	private String color;

	/**
	 * @Fields  : 车型
	 * @author huzongcheng
	 */
	private String vehicleCode;

	/**
	 * @Fields  : 行驶公里数
	 * @author huzongcheng
	 */
	private BigDecimal miles;

	/**
	 * @Fields  : 登记日期
	 * @author huzongcheng
	 */
	private Date registDate;

	/**
	 * @Fields  : 车龄
	 * @author huzongcheng
	 */
	private BigDecimal vehAgeMonths;

	/**
	 * @Fields  : 出厂日期
	 * @author huzongcheng
	 */
	private Date produceDate;

	/**
	 * @Fields  : 收车任务号
	 * @author huzongcheng
	 */
	private String recoveryTaskNo;


}