package cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditcorpbkcheck;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpBkcheck;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditCorpBkcheckVo
 * @Description: 企业银行卡核查载体
 * @date 2018-06-04
 */
@Data
public class PycreditCorpBkcheckVo extends PageQuery<PycreditCorpBkcheck> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 企业银行卡核查id
	 * @author liujinge
	 */
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

	/**
	 * @Fields  : 企业银行卡核查id
	 * @author liujinge
	 */
	private List<String> pycreditCorpBkcheckIds;
	/**
	 * @Fields  : 核查状态
	 * @author yanggang
	 */
	private String treatResult;
	/**
	 * @Fields  : 银行卡核对结果
	 * @author yanggang
	 */
	private String status;
}