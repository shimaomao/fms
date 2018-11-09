package cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditcardcheck;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCardCheck;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: PycreditCardCheckVo
 * @Description: 卡核查及交易载体
 * @date 2018-06-14
 */
@Data
public class PycreditCardCheckVo extends PageQuery<PycreditCardCheck> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 卡核查及交易id
	 * @author yangyiquan
	 */
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

	/**
	 * @Fields  : 卡核查及交易id
	 * @author yangyiquan
	 */
	private List<String> pycreditCardCheckIds;

}