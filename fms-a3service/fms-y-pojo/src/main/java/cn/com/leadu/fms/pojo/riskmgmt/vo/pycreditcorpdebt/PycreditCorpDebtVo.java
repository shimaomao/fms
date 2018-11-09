package cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditcorpdebt;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpDebt;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditCorpDebtVo
 * @Description: 企业债务载体
 * @date 2018-06-04
 */
@Data
public class PycreditCorpDebtVo extends PageQuery<PycreditCorpDebt> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 企业债务id
	 * @author liujinge
	 */
	private String pycreditCorpDebtId;

	/**
	 * @Fields  : 被查询企业名称
	 * @author liujinge
	 */
	private String corpName;

	/**
	 * @Fields  : 被查询企业社会信用代码
	 * @author liujinge
	 */
	private String orgCode;

	/**
	 * @Fields  : 被查询企业工商注册号
	 * @author liujinge
	 */
	private String registerNo;

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
	 * @Fields  : 企业债务id
	 * @author liujinge
	 */
	private List<String> pycreditCorpDebtIds;
	/**
	 * @Fields  : 动产抵押
	 * @author yanggang
	 */
	private String morDetailInfo;
	/**
	 * @Fields  : 动产抵押物
	 * @author yanggang
	 */
	private String morgualInfo;
	/**
	 * @Fields  : 股权冻结
	 * @author yanggang
	 */
	private String sharesFrostInfo;
	/**
	 * @Fields  : 股权出质
	 * @author yanggang
	 */
	private String sharesImpawnInfo;
	/**
	 * @Fields  : 清算信息
	 * @author yanggang
	 */
	private String liquidationInfo;

	/**
	 * @Fields  : 核查状态
	 * @author yanggang
	 */
	private String treatResult;
}