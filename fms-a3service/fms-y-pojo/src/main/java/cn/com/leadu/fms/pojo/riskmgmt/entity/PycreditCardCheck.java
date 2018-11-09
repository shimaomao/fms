package cn.com.leadu.fms.pojo.riskmgmt.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author yangyiquan
 * @ClassName: PycreditCardCheck
 * @Description: 卡核查及交易实体
 * @date 2018-06-14
 */
@Data
public class PycreditCardCheck extends BaseEntity<PycreditCardCheck> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 卡核查及交易id
	 * @author yangyiquan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String pycreditCardCheckId;

	/**
	 * @Fields  : 被查询者姓名
	 * @author yangyiquan
	 */
	private String name;

	/**
	 * @Fields  : 被查询者证件号码
	 * @author yangyiquan
	 */
	private String documentNo;

	/**
	 * @Fields  : 银行卡号
	 * @author yangyiquan
	 */
	private String cardNos;

	/**
	 * @Fields  : 查询日期
	 * @author yangyiquan
	 */
	private Date queryDate;

	/**
	 * @Fields  : 接口请求xml
	 * @author yangyiquan
	 */
	private String conditionsXml;

	/**
	 * @Fields  : 接口返回xml
	 * @author yangyiquan
	 */
	private String cisReportsXml;

}