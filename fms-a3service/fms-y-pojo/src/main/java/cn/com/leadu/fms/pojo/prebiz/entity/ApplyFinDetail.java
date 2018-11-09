package cn.com.leadu.fms.pojo.prebiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author wangxue
 * @ClassName: ApplyFinDetail
 * @Description: 融资费用明细信息实体
 * @date 2018-03-24
 */
@Data
public class ApplyFinDetail extends BaseEntity<ApplyFinDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 融资费用明细ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String applyFinDetailId;

	/**
	 * @Fields  : 订单编号
	 */
	private String applyNo;

	/**
	 * @Fields  : 车辆序号
	 */
	private String vehicleNo;

	/**
	 * @Fields  : 融资项目代码
	 */
	private String finItem;

	/**
	 * @Fields  : 融资项目年限
	 */
	private Integer finItemYear;

	/**
	 * @Fields  : 融资额
	 */
	private BigDecimal finAmount;

}