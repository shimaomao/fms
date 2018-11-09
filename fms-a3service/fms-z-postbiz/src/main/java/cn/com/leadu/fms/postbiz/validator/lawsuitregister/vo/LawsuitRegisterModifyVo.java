package cn.com.leadu.fms.postbiz.validator.lawsuitregister.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.LawsuitRegister;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: LawsuitRegisterVo
 * @Description: 诉讼登记信息修改时载体及验证
 */
@Data
public class LawsuitRegisterModifyVo extends BaseVo<LawsuitRegister> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 诉讼登记id
	 * @author lijunjun
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String lawsuitRegisterId;

	/**
	 * @Fields  : 诉讼任务号
	 * @author lijunjun
	 */
	private String lawsuitTaskNo;

	/**
	 * @Fields  : 受理法院
	 * @author lijunjun
	 */
	private String court;

	/**
	 * @Fields  : 立案案号
	 * @author lijunjun
	 */
	private String caseRecordNo;

	/**
	 * @Fields  : 案件状态
	 * @author lijunjun
	 */
	private String caseStatus;

	/**
	 * @Fields  : 案件时间
	 * @author lijunjun
	 */
	private Date caseDate;

	/**
	 * @Fields  : 承办法官
	 * @author lijunjun
	 */
	private String judge;

	/**
	 * @Fields  : 承办法官联系方式
	 * @author lijunjun
	 */
	private String judgeContactNo;

	/**
	 * @Fields  : 案件说明
	 * @author lijunjun
	 */
	private String caseIntroduce;

	/**
	 * @Fields  : 诉讼金额
	 * @author lijunjun
	 */
	private BigDecimal lawsuitAmount;

	/**
	 * @Fields  : 判决金额
	 * @author lijunjun
	 */
	private BigDecimal judgmentAmount;

	/**
	 * @Fields  : 执行案号
	 * @author lijunjun
	 */
	private String executeCaseNo;

}