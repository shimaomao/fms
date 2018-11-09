package cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditlist;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.riskmgmt.entity.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditListVo
 * @Description: 鹏元查询一览载体
 * @date 2018-06-04
 */
@Data
@EqualsAndHashCode(of = { "pycreditType", "relation", "name" })
public class PycreditListVo extends PageQuery<PycreditList> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 鹏元查询id
	 * @author liujinge
	 */
	private String pycreditId;

	/**
	 * @Fields  : 申请编号
	 * @author liujinge
	 */
	private String applyNo;

	/**
	 * @Fields  : 鹏元接口类型
	 * @author liujinge
	 */
	private String pycreditType;

	/**
	 * @Fields  : 关系类型
	 * @author liujinge
	 */
	private String relation;

	/**
	 * @Fields  : 姓名
	 * @author liujinge
	 */
	private String name;

	/**
	 * @Fields  : 证件号码
	 * @author liujinge
	 */
	private String documentNo;

	/**
	 * @Fields  : 手机号码
	 * @author liujinge
	 */
	private String phone;

	/**
	 * @Fields  : 单位地址
	 * @author liujinge
	 */
	private String compAddr;

	/**
	 * @Fields  : 户籍地址
	 * @author liujinge
	 */
	private String censusAddr;

	/**
	 * @Fields  : 居住地址
	 * @author liujinge
	 */
	private String resideAddr;

	/**
	 * @Fields  : 房产地址
	 * @author liujinge
	 */
	private String propertyAddr;

	/**
	 * @Fields  : 准驾车型
	 * @author liujinge
	 */
	private String carModels;

	/**
	 * @Fields  : 初次领证日期
	 * @author liujinge
	 */
	private String firstGetDate;
	/**
	 * @Fields  : 驾驶证收费子报告
	 * @author liujinge
	 */
	private String subReportId;
	/**
	 * @Fields  : 驾驶证档案编号
	 * @author liujinge
	 */
	private String archviesNo;

	/**
	 * @Fields  : 银行账号
	 * @author liujinge
	 */
	private String accountNo;

	/**
	 * @Fields  : 开户行号
	 * @author liujinge
	 */
	private String openBankNo;

	/**
	 * @Fields  : 是否调用接口
	 * @author liujinge
	 */
	private String queryFlag;

	/**
	 * @Fields  : 鹏元信息id
	 * @author liujinge
	 */
	private String pycreditResultId;

	/**
	 * @Fields  : 鹏元查询id
	 * @author liujinge
	 */
	private List<String> pycreditIds;

	/**
	 * @Fields  : 反欺诈分析实体
	 * @author yangyiquan
	 */
	private PycreditAnti pycreditAnti;

	/**
	 * @Fields  : 地址核验实体
	 * @author yangyiquan
	 */
	private PycreditAddr pycreditAddr;

	/**
	 * @Fields  : 卡核查及交易实体
	 * @author yangyiquan
	 */
	private PycreditCardCheck pycreditCardCheck;

	/**
	 * @Fields  : 企业银行卡核查实体
	 * @author yangyiquan
	 */
	private PycreditCorpBkcheck pycreditCorpBkcheck;

	/**
	 * @Fields  : 企业债务实体
	 * @author yangyiquan
	 */
	private PycreditCorpDebt pycreditCorpDebt;

	/**
	 * @Fields  : 企业风险实体
	 * @author yangyiquan
	 */
	private PycreditCorpRisk pycreditCorpRisk;

	/**
	 * @Fields  : 驾驶证核查实体
	 * @author yangyiquan
	 */
	private PycreditDriver pycreditDriver;

	/**
	 * @Fields  : 个人银行卡核查实体
	 * @author yangyiquan
	 */
	private PycreditPersonBkcheck pycreditPersonBkcheck;

	/**
	 * @Fields  : 实际用车人
	 * @author ningyangyang
	 */
	private String actCarUser;

	/**
	 * @Fields  : 驾驶证号
	 * @author ningyangyang
	 */
	private String driLicenseNo;

	/**
	 * @Fields  : 驾驶证档案编号
	 * @author ningyangyang
	 */
	private String actLicenseNo;

}