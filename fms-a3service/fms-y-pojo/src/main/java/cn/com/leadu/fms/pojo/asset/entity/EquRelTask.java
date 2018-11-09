package cn.com.leadu.fms.pojo.asset.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author qiaomengnan
 * @ClassName: EquRelTask
 * @Description: 资方解押任务实体
 * @date 2018-05-30
 */
@Data
public class EquRelTask extends BaseEntity<EquRelTask> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 资方解押任务id
	 * @author qiaomengnan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String equRelTaskId;

	/**
	 * @Fields  : 资方解押任务号
	 * @author qiaomengnan
	 */
	private String equRelTaskNo;

	/**
	 * @Fields  : 解押任务状态
	 * @author qiaomengnan
	 */
	private String reliefStatus;

	/**
	 * @Fields  : 审批人
	 * @author qiaomengnan
	 */
	private String presentUser;

	/**
	 * @Fields  : 差额
	 * @author qiaomengnan
	 */
	private BigDecimal differenceCharge;

}