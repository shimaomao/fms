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
 * @ClassName: PycreditAddr
 * @Description: 地址核验实体
 * @date 2018-06-04
 */
@Data
public class PycreditAddr extends BaseEntity<PycreditAddr> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 地址核验id
	 * @author liujinge
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String pycreditAddrId;

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
	 * @Fields  : 被查询者手机号码
	 * @author liujinge
	 */
	private String mobile;

	/**
	 * @Fields  : 核验地址
	 * @author liujinge
	 */
	private String address;

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
	 * @Fields  : 省核查结果
	 * @author yanggang
	 */
	private String provinceCheckResult;
	/**
	 * @Fields  : 市核查结果
	 * @author yanggang
	 */
	private String cityCheckResult;
	/**
	 * @Fields  : 区/县核查结果
	 * @author 杨刚
	 */
	private String countyCheckResult;
	/**
	 * @Fields  : 详细地址核查结果
	 * @author yanggang
	 */
	private String detailAddressCheckResult;
	/**
	 * @Fields  : 核查结果状态
	 * @author yanggang
	 */
	private String treatResult;
	/**
	 * @Fields  : 风控报告地址核验
	 * @author yanggang
	 */
	private String addrCheck;
}