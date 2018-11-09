package cn.com.leadu.fms.pojo.postbiz.vo.invoiceauto;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceAuto;
import lombok.Data;
import java.util.List;
import java.util.Date;

/**
 * @author yangyiquan
 * @ClassName: InvoiceAutoVo
 * @Description: 自动开票信息载体
 */
@Data
public class InvoiceAutoVo extends PageQuery<InvoiceAuto> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 自动开票id
	 * @author yangyiquan
	 */
	private String invoiceAutoId;

	/**
	 * @Fields  : 发票种类
	 * @author yangyiquan
	 */
	private String infokind;

	/**
	 * @Fields  : 购方名称
	 * @author yangyiquan
	 */
	private String infoclientname;

	/**
	 * @Fields  : 购方税号（公司必填）
	 * @author yangyiquan
	 */
	private String infoclienttaxcode;

	/**
	 * @Fields  : 购方开户行及账号（专用发票必填）
	 * @author yangyiquan
	 */
	private String infoclientbankaccount;

	/**
	 * @Fields  : 购方地址电话（专用发票必填）
	 * @author yangyiquan
	 */
	private String infoclientaddressphone;

	/**
	 * @Fields  : 发票十位代码
	 * @author yangyiquan
	 */
	private String infotypecode;

	/**
	 * @Fields  : 发票号码
	 * @author yangyiquan
	 */
	private String infonumber;

	/**
	 * @Fields  : 销货清单标志
	 * @author yangyiquan
	 */
	private String goodslistflag;

	/**
	 * @Fields  : 开票日期
	 * @author yangyiquan
	 */
	private String infoinvdate;

	/**
	 * @Fields  : 所属月份
	 * @author yangyiquan
	 */
	private String infmonth;

	/**
	 * @Fields  : 合计不含税金额
	 * @author yangyiquan
	 */
	private String infoamount;

	/**
	 * @Fields  : 合计税额
	 * @author yangyiquan
	 */
	private String infotaxamount;

	/**
	 * @Fields  : 接口请求xml
	 * @author yangyiquan
	 */
	private String invSendXml;

	/**
	 * @Fields  : 接口返回xml
	 * @author yangyiquan
	 */
	private String invBackXml;

	/**
	 * @Fields  : 自动开票id
	 * @author yangyiquan
	 */
	private List<String> invoiceAutoIds;

	/**
	 * @Fields  : 是否已经打印
	 * @author ningyangyang
	 */
	private String printStatus;

	/**
	 * @Fields  : 备注
	 * @author ningyangyang
	 */
	private String infonotes;

}