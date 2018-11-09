package cn.com.leadu.fms.pojo.asset.entity;

import cn.com.leadu.fms.common.annotation.ExcelImportTitle;
import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import cn.com.leadu.fms.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: EquMorCharge
 * @Description: 资方抵押费用实体
 * @date 2018-05-30
 */
@Data
public class EquMorCharge extends BaseEntity<EquMorCharge> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 资方抵押费用id
	 * @author qiaomengnan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String equMorChargeId;

	/**
	 * @Fields  : 资方抵押任务号
	 * @author qiaomengnan
	 */
	private String equMorTaskNo;

	/** 
	 * @Fields  : 客户合同编号
	 * @author qiaomengnan
	 */
	private String clientContNo;

	/** 
	 * @Fields  : 资方名称
	 * @author qiaomengnan
	 */
	private String managementName;

	/** 
	 * @Fields  : 抵押合同号
	 * @author qiaomengnan
	 */ 
	private String equContNo;

	/** 
	 * @Fields  : 车架号
	 * @author qiaomengnan
	 */ 
	private String vinNo;

	/** 
	 * @Fields  : 抵押合同金额
	 * @author qiaomengnan
	 */ 
	private BigDecimal equFinAmount;

	/**
	 * @Fields  : 保证金
	 * @author qiaomengnan
	 */
	private BigDecimal margin;

	/**
	 * @Fields  : 手续费
	 * @author qiaomengnan
	 */
	private BigDecimal factorge;

	/**
	 * @Fields  : 管理费
	 * @author qiaomengnan
	 */
	private BigDecimal managementCharge;

	/**
	 * @Fields  : 服务费
	 * @author qiaomengnan
	 */
	private BigDecimal serviceCharge;

	/**
	 * @Fields  : 一次性利息
	 * @author qiaomengnan
	 */
	private BigDecimal oneTimeInterest;

	/**
	 * @Fields  : 留购价
	 * @author qiaomengnan
	 */
	private BigDecimal retentionPrice;

	/**
	 * @Fields  : 应付合计
	 * @author qiaomengnan
	 */
	private BigDecimal totalShouldPay;

	/**
	 * @Fields  : 财务应收合计
	 * @author qiaomengnan
	 */
	private BigDecimal finShouldReceive;

	/** 
	 * @Fields  : 明细区分
	 * @author qiaomengnan
	 */ 
	private String contDetailFlag;

	/**
	 * @Fields  : 抵押起租日期
	 * @author qiaomengnan
	 */
	private Date equStartDate;

	/**
	 * @Fields  : 抵押止租日期
	 * @author qiaomengnan
	 */
	private Date equEndDate;

}