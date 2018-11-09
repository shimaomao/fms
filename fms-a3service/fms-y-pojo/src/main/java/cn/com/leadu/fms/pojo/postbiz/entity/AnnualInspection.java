package cn.com.leadu.fms.pojo.postbiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author qinmuqiao
 * @ClassName: AnnualInspection
 * @Description: 年检提醒实体
 */
@Data
public class AnnualInspection extends BaseEntity<AnnualInspection> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 年检提醒id
	 * @author qinmuqiao
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String annualInspectionId;

	/**
	 * @Fields  : 年检任务号
	 * @author qinmuqiao
	 */
	private String annualInspectNo;

	/**
	 * @Fields  : 合同编号
	 * @author qinmuqiao
	 */
	private String contNo;

	/**
	 * @Fields  : 年检状态
	 * @author qinmuqiao
	 */
	private String annualInspectStatus;

	/**
	 * @Fields  : 年检期限
	 * @author qinmuqiao
	 */
	private Date annualInspectDeadline;

	/**
	 * @Fields  : 年检日期
	 * @author qinmuqiao
	 */
	private Date annualInspectDate;

}