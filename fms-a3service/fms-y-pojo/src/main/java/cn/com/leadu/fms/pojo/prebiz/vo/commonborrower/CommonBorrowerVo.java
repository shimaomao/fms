package cn.com.leadu.fms.pojo.prebiz.vo.commonborrower;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.CommonBorrower;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ningyangyang
 * @ClassName: CommonBorrowerVo
 * @Description: 共同借款人载体
 * @date 2018-05-25
 */
@Data
public class CommonBorrowerVo extends PageQuery<CommonBorrower> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 共同借款人ID
	 * @author ningyangyang
	 */
	private String comBorrowerId;

	/**
	 * @Fields  : 订单编号
	 * @author ningyangyang
	 */
	private String applyNo;

	/**
	 * @Fields  : 借款人姓名
	 * @author ningyangyang
	 */
	private String name;

	/**
	 * @Fields  : 证件类型
	 * @author ningyangyang
	 */
	private String certifType;

	/**
	 * @Fields  : 证件号码
	 * @author ningyangyang
	 */
	private String certifNo;

	/**
	 * @Fields  : 手机号码
	 * @author ningyangyang
	 */
	private String mobileNo;

	/**
	 * @Fields  : 单位名称
	 * @author ningyangyang
	 */
	private String compName;

	/**
	 * @Fields  : 单位电话
	 * @author ningyangyang
	 */
	private String compTel;

	/**
	 * @Fields  : 职位
	 * @author ningyangyang
	 */
	private String position;

	/**
	 * @Fields  : 年薪(万元)
	 * @author ningyangyang
	 */
	private BigDecimal salary;

	/**
	 * @Fields  : 单位所在省份
	 * @author ningyangyang
	 */
	private String compProv;

	/**
	 * @Fields  : 单位所在城市
	 * @author ningyangyang
	 */
	private String compCity;

	/**
	 * @Fields  : 单位所在区县
	 * @author ningyangyang
	 */
	private String compCounty;

	/**
	 * @Fields  : 单位所在详细地址
	 * @author ningyangyang
	 */
	private String compAddr;

	/**
	 * @Fields  : 共同借款人ID
	 * @author ningyangyang
	 */
	private List<String> comBorrowerIds;

	/**
	 * @Fields  : 是否是配偶
	 * @author ningyangyang
	 */
	private String whetherSpouse;

}