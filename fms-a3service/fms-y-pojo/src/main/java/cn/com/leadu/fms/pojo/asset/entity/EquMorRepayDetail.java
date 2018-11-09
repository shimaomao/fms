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
 * @author qinmuqiao
 * @ClassName: EquMorRepayDetail
 * @Description: 资方抵押还款计划实体
 */
@Data
public class EquMorRepayDetail extends BaseEntity<EquMorRepayDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 资方抵押还款计划表明细id
	 * @author qinmuqiao
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String equMorRepayDetailId;

	/**
	 * @Fields  : 资方抵押任务号
	 * @author qinmuqiao
	 */
	private String equMorTaskNo;

	/**
	 * @Fields  : 客户合同编号
	 * @author qinmuqiao
	 */
	private String clientContNo;

	/**
	 * @Fields  : 车架号
	 * @author qinmuqiao
	 */
	private String vinNo;

	/**
	 * @Fields  : 期数
	 * @author qinmuqiao
	 */
	private Integer period;

	/**
	 * @Fields  : 应还日期
	 * @author qinmuqiao
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date repayDate;

	/**
	 * @Fields  : 租金
	 * @author qinmuqiao
	 */
	private BigDecimal rent;

	/**
	 * @Fields  : 还款状态
	 * @author qinmuqiao
	 */
	private String equRepayStatus;

	/**
	 * @Fields  : 还款日期
	 * @author qinmuqiao
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date payUpdateDate;

}