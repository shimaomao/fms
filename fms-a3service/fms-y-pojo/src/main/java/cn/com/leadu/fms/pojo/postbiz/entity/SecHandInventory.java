package cn.com.leadu.fms.pojo.postbiz.entity;

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
 * @author huzongcheng
 * @ClassName: SecHandInventory
 * @Description: 二手车库存实体
 */
@Data
public class SecHandInventory extends BaseEntity<SecHandInventory> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 二手车id
	 * @author huzongcheng
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String secHandId;

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
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
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
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date produceDate;

	/**
	 * @Fields  : 车辆评估价
	 * @author huzongcheng
	 */
	private BigDecimal evaluationPrice;

	/**
	 * @Fields  : 状态
	 * @author huzongcheng
	 */
	private String status;

	/**
	 * @Fields  : 二手车来源
	 * @author huzongcheng
	 */
	private String carSource;

	/**
	 * @Fields  : 收车任务号
	 * @author huzongcheng
	 */
	private String recoveryTaskNo;

	/**
	 * @Fields : 处理时间
	 * @author huzongcheng
	 */
	private Date handleDate;

}