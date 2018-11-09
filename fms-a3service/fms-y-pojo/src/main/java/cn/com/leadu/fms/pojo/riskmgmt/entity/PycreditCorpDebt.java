package cn.com.leadu.fms.pojo.riskmgmt.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author liujinge
 * @ClassName: PycreditCorpDebt
 * @Description: 企业债务实体
 * @date 2018-06-04
 */
@Data
public class PycreditCorpDebt extends BaseEntity<PycreditCorpDebt> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 企业债务id
	 * @author liujinge
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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

	/**
	 * @Fields  : 企业债务信息
	 * @author liujinge
	 */
	private String corpDebt;

}