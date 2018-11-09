package cn.com.leadu.fms.riskmgmt.validator.pycreditdriver.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditDriver;
import lombok.Data;
import java.util.Date;

/**
 * @author liujinge
 * @ClassName: PycreditDriverVo
 * @Description: 驾驶证核查保存时载体及验证
 * @date 2018-06-04
 */
@Data
public class PycreditDriverSaveVo extends BaseVo<PycreditDriver> {

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

}