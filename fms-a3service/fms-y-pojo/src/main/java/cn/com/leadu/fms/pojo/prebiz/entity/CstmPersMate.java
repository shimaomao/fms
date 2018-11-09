package cn.com.leadu.fms.pojo.prebiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ningyangyang
 * @ClassName: CstmPersMate
 * @Description: 客户个人配偶信息实体
 * @date 2018-03-26
 */
@Data
public class CstmPersMate extends BaseEntity<CstmPersMate> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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