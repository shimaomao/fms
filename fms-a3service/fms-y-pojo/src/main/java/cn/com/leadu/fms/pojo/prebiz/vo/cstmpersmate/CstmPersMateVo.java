package cn.com.leadu.fms.pojo.prebiz.vo.cstmpersmate;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmPersMate;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ningyangyang
 * @ClassName: CstmPersMateVo
 * @Description: 客户个人配偶信息载体
 * @date 2018-03-26
 */
@Data
public class CstmPersMateVo extends PageQuery<CstmPersMate> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	private String persMateId;

	/**
	 * @Fields  : 
	 */
	private String applyNo;

	/**
	 * @Fields  : 
	 */
	private String name;

	/**
	 * @Fields  : 
	 */
	private String certifType;

	/**
	 * @Fields  : 
	 */
	private String certifNo;

	/**
	 * @Fields  : 
	 */
	private String mobileNo;

	/**
	 * @Fields  : 
	 */
	private String compName;

	/**
	 * @Fields  : 
	 */
	private String compTel;

	/**
	 * @Fields  : 
	 */
	private String position;

	/**
	 * @Fields  : 
	 */
	private BigDecimal salary;

	/**
	 * @Fields  : 
	 */
	private String compProv;

	/**
	 * @Fields  : 
	 */
	private String compCity;

	/**
	 * @Fields  : 
	 */
	private String compCounty;

	/**
	 * @Fields  : 
	 */
	private String compAddr;

	/**
	 * @Fields  : 
	 */
	private List<String> persMateIds;

	/**
	 * @Fields  : 是否共同借款人
	 * @author ningyangyang
	 */
	private String isCommonBorrower;

}