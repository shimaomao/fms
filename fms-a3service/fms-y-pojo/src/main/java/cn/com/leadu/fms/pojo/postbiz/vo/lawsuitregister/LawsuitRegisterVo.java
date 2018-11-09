package cn.com.leadu.fms.pojo.postbiz.vo.lawsuitregister;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.LawsuitRegister;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: LawsuitRegisterVo
 * @Description: 诉讼登记信息载体
 */
@Data
public class LawsuitRegisterVo extends PageQuery<LawsuitRegister> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 诉讼登记id
	 * @author lijunjun
	 */
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
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
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

	/**
	 * @Fields  : 诉讼登记id
	 * @author lijunjun
	 */
	private List<String> lawsuitRegisterIds;

}