package cn.com.leadu.fms.pojo.cost.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import cn.com.leadu.fms.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author yanfengbo
 * @ClassName: OverdueExempt
 * @Description: 罚息免除任务表实体
 * @date 2018-05-30
 */
@Data
public class OverdueExempt extends BaseEntity<OverdueExempt> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 罚息免除任务id
	 * @author yanfengbo
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String overdueExemptId;

	/**
	 * @Fields  : 罚息免除任务号
	 * @author yanfengbo
	 */
	private String overdueExemptNo;

	/**
	 * @Fields  : 罚息免除任务状态
	 * @author yanfengbo
	 */
	private String overdueExemptStatus;

	/**
	 * @Fields  : 合同编号
	 * @author yanfengbo
	 */
	private String contNo;

	/**
	 * @Fields  : 当前节点用户
	 */
	private String presentUser;

	/**
	 * @Fields  : 申请时间
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date overdueDate;
}