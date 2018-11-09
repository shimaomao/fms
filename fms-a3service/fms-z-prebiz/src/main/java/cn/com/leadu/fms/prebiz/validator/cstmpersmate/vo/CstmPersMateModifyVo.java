package cn.com.leadu.fms.prebiz.validator.cstmpersmate.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmPersMate;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ningyangyang
 * @ClassName: CstmPersMateVo
 * @Description: 客户个人配偶信息修改时载体及验证
 * @date 2018-03-26
 */
@Data
public class CstmPersMateModifyVo extends BaseVo<CstmPersMate> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
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
	 * @Fields  : 是否共同借款人
	 * @author ningyangyang
	 */
	private String isCommonBorrower;

}