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
 * @ClassName: PycreditPersonBkcheck
 * @Description: 个人银行卡核查实体
 * @date 2018-06-04
 */
@Data
public class PycreditPersonBkcheck extends BaseEntity<PycreditPersonBkcheck> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 个人银行卡核查id
	 * @author liujinge
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String pycreditPersonBkcheckId;

	/**
	 * @Fields  : 被查询者姓名
	 * @author liujinge
	 */
	private String name;

	/**
	 * @Fields  : 被查询者证件号码
	 * @author liujinge
	 */
	private String documentNo;

	/**
	 * @Fields  : 银行账号
	 * @author liujinge
	 */
	private String accountNo;

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
	 * @Fields  : 开户行行号
	 * @author yanggang
	 */
	private String openBankNo;
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