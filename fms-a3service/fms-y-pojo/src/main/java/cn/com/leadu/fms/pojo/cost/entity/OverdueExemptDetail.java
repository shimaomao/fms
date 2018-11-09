package cn.com.leadu.fms.pojo.cost.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author yanfengbo
 * @ClassName: OverdueExemptDetail
 * @Description: 罚息免除任务明细表实体
 * @date 2018-05-30
 */
@Data
public class OverdueExemptDetail extends BaseEntity<OverdueExemptDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 罚息免除任务明细表id
	 * @author yanfengbo
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String overdueExemptDetailId;

	/**
	 * @Fields  : 罚息免除任务号
	 * @author yanfengbo
	 */
	private String overdueExemptNo;

	/**
	 * @Fields  : 合同编号
	 * @author yanfengbo
	 */
	private String contNo;

	/**
	 * @Fields  : 期数
	 * @author yanfengbo
	 */
	private Integer periods;

	/**
	 * @Fields  : 免除金额
	 * @author yanfengbo
	 */
	private BigDecimal manualExemptAmount;

	/**
	 * @Fields  : 罚息免除任务明细状态
	 * @author yanfengbo
	 */
	private String overdueExemptDetailStatus;

}