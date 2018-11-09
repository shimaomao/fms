package cn.com.leadu.fms.riskmgmt.validator.pycreditcorpbkcheck.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpBkcheck;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;

/**
 * @author liujinge
 * @ClassName: PycreditCorpBkcheckVo
 * @Description: 企业银行卡核查修改时载体及验证
 * @date 2018-06-04
 */
@Data
public class PycreditCorpBkcheckModifyVo extends BaseVo<PycreditCorpBkcheck> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 企业银行卡核查id
	 * @author liujinge
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
	private String pycreditCorpBkcheckId;

	/**
	 * @Fields  : 企业名称
	 * @author liujinge
	 */
	private String corpName;

	/**
	 * @Fields  : 银行账户号
	 * @author liujinge
	 */
	private String accountNo;

	/**
	 * @Fields  : 开户行号
	 * @author liujinge
	 */
	private String openBankNo;

	/**
	 * @Fields  : 查询日期
	 * @author liujinge
	 */
	private Date queryDate;

	/**
	 * @Fields  : 接口请求xml
	 * @author liujinge
	 */
	private String conditionsXml;

	/**
	 * @Fields  : 接口返回xml
	 * @author liujinge
	 */
	private String cisReportsXml;

}