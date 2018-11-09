package cn.com.leadu.fms.riskmgmt.validator.pycreditpersonbkcheck.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditPersonBkcheck;
import lombok.Data;
import java.util.Date;

/**
 * @author liujinge
 * @ClassName: PycreditPersonBkcheckVo
 * @Description: 个人银行卡核查保存时载体及验证
 * @date 2018-06-04
 */
@Data
public class PycreditPersonBkcheckSaveVo extends BaseVo<PycreditPersonBkcheck> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 个人银行卡核查id
	 * @author liujinge
	 */
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

}