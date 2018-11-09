package cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditdriver;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditDriver;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditDriverVo
 * @Description: 驾驶证核查载体
 * @date 2018-06-04
 */
@Data
public class PycreditDriverVo extends PageQuery<PycreditDriver> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 驾驶证核查id
	 * @author liujinge
	 */
	private String pycreditDriverId;

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
	 * @Fields  : 档案编号
	 * @author liujinge
	 */
	private String archviesNo;

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
	 * @Fields  : 驾驶证核查id
	 * @author liujinge
	 */
	private List<String> pycreditDriverIds;
	/**
	 * @Fields  : 查询状态
	 * @author yanggang
	 */
	private String treatResult;
	/**
	 * @Fields  : 姓名核查结果
	 * @author yanggang
	 */
	private String nameCheckResult;
	/**
	 * @Fields  : 证件号码核查结果
	 * @author yanggang
	 */
	private String documentNoCheckResult;
	/**
	 * @Fields  : 驾驶证状态
	 * @author yanggang
	 */
	private String driverLicenseStatusDesc;
	/**
	 * @Fields  : 驾驶证档案编号核查,驾驶证初次领证时间核查结果,准驾车辆核查结果
	 * @author yanggang
	 */
	private String checkResult;
	/**
	 * @Fields  : 驾驶证收费子报告
	 * @author yanggang
	 */
	private String subReportId;
}