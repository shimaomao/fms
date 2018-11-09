package cn.com.leadu.fms.postbiz.validator.annualinspection.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.AnnualInspection;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;

/**
 * @author qinmuqiao
 * @ClassName: AnnualInspectionVo
 * @Description: 年检提醒修改时载体及验证
 */
@Data
public class AnnualInspectionModifyVo extends BaseVo<AnnualInspection> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 年检提醒id
	 * @author qinmuqiao
	 */
	@NotBlank(message = "修改id不能为空")
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