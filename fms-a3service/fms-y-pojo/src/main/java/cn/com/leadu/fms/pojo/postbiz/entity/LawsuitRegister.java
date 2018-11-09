package cn.com.leadu.fms.pojo.postbiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: LawsuitRegister
 * @Description: 诉讼登记信息实体
 */
@Data
public class LawsuitRegister extends BaseEntity<LawsuitRegister> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 诉讼登记id
	 * @author lijunjun
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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