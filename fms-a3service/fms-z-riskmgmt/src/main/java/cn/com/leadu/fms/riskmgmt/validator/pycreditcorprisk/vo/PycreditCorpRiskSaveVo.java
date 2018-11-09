package cn.com.leadu.fms.riskmgmt.validator.pycreditcorprisk.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpRisk;
import lombok.Data;
import java.util.Date;

/**
 * @author liujinge
 * @ClassName: PycreditCorpRiskVo
 * @Description: 企业风险保存时载体及验证
 * @date 2018-06-04
 */
@Data
public class PycreditCorpRiskSaveVo extends BaseVo<PycreditCorpRisk> {

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

}