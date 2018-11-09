package cn.com.leadu.fms.pojo.asset.entity;

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
 * @author qiaomengnan
 * @ClassName: EquMorRepay
 * @Description: 资方抵押还款计划实体
 * @date 2018-05-30
 */
@Data
public class EquMorRepay extends BaseEntity<EquMorRepay> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 资方抵押还款计划表id
	 * @author qiaomengnan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String equMorRepayId;

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
	 * @Fields  : 客户姓名
	 * @author qiaomengnan
	 */ 
	private String clientName;

	/**
	 * @Fields  : 融资期限
	 * @author qiaomengnan
	 */
	private String leasePeriod;

	/**
	 * @Fields  : 车架号
	 * @author qiaomengnan
	 */
	private String vinNo;

	/**
	 * @Fields  : 还款日
	 * @author qiaomengnan
	 */
	private String repayDate;

	/**
	 * @Fields  : 租金
	 * @author qiaomengnan
	 */
	private BigDecimal rent;

}