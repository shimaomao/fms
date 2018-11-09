package cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditcorprisk;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpRisk;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditCorpRiskVo
 * @Description: 企业风险载体
 * @date 2018-06-04
 */
@Data
public class PycreditCorpRiskVo extends PageQuery<PycreditCorpRisk> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 企业风险id
	 * @author liujinge
	 */
	private String pycreditCorpRiskId;

	/**
	 * @Fields  : 被查询的企业名称
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
	 * @Fields  : 企业风险id
	 * @author liujinge
	 */
	private List<String> pycreditCorpRiskIds;
	/**
	 * @Fields  : 司法案例信息条数
	 * @author yanggang
	 */
	private Integer alCount;
	/**
	 * @Fields  : 司法执行信息条数
	 * @author yanggang
	 */
	private Integer zxCount;
	/**
	 * @Fields  : 司法失信信息条数
	 * @author yanggang
	 */
	private Integer sxCount;

	/**
	 * @Fields  : 税务行政执法信息条数
	 * @author yanggang
	 */
	private String swCount;
	/**
	 * @Fields  : 催欠公告信息条数
	 * @author yanggang
	 */
	private Integer cqggCount;
	/**
	 * @Fields  : 网贷逾期信息条数
	 * @author yanggang
	 */
	private Integer wdyqCount;
	/**
	 * @Fields  : 开庭公告信息条数
	 * @author yanggang
	 */
	private Integer ktggCount;
	/**
	 * @Fields  : 其他司法公告信息条数
	 * @author yanggang
	 */
	private Integer qtsfggCount;
	/**
	 * @Fields  : 审判流程信息条数
	 * @author yanggang
	 */
	private Integer splcCount;
	/**
	 * @Fields  : 核查结果状态
	 * @author yanggang
	 */
	private String treatResult;
}