package cn.com.leadu.fms.pojo.prebiz.entity;

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
 * @author liujinge
 * @ClassName: ContInsurance
 * @Description: 合同车辆保险信息实体
 * @date 2018-03-23
 */
@Data
public class ContInsurance extends BaseEntity<ContInsurance> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 保险信息ID
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String contVehinsId;

	/**
	 * @Fields  : 合同编号
	 */
	private String contNo;

	/**
	 * @Fields  : 保险公司名称
	 */
	private String insCompName;

	/**
	 * @Fields  : 商业险保单号
	 */
	private String insPolicyNo;

	/**
	 * @Fields  : 投保生效日
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date validStartDay;

	/**
	 * @Fields  : 投保失效日
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date validEndDay;

	/**
	 * @Fields  : 保单实际金额
	 */
	private BigDecimal insFee;

	/**
	 * @Fields  : 保单状态
	 */
	private String insuranceStatus;

	/**
	 * @Fields  : 险种类型
	 */
	private String insuranceType;

	/**
	 * @Fields  : 险种信息
	 */
	private String insuranceSelectInfo;

	/**
	 * @Fields  : 已购买的保险年限
	 */
	private Integer insuranceYears;
}