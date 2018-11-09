package cn.com.leadu.fms.riskmgmt.validator.pycreditaddr.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditAddr;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;

/**
 * @author liujinge
 * @ClassName: PycreditAddrVo
 * @Description: 地址核验修改时载体及验证
 * @date 2018-06-04
 */
@Data
public class PycreditAddrModifyVo extends BaseVo<PycreditAddr> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 地址核验id
	 * @author liujinge
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
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

}