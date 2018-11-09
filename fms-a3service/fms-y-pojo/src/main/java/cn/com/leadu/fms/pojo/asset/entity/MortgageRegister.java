package cn.com.leadu.fms.pojo.asset.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author yangyiquan
 * @ClassName: MortgageRegister
 * @Description: 解抵押过户信息实体
 * @date 2018-05-18
 */
@Data
public class MortgageRegister extends BaseEntity<MortgageRegister> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 解除抵押ID
	 * @author yangyiquan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String mortgageRegisterId;

	/**
	 * @Fields  : 合同编号
	 * @author yangyiquan
	 */
	private String contNo;

	/**
	 * @Fields  : 结清日期
	 * @author yangyiquan
	 */
	private Date settleDate;

	/**
	 * @Fields  : 牌照属性
	 * @author yangyiquan
	 */
	private String licenseAttr;

	/**
	 * @Fields  : 解抵押状态
	 * @author yangyiquan
	 */
	private String mortgateSts;

	/**
	 * @Fields  : 登记账号
	 * @author yangyiquan
	 */
	private String registerUser;

	/**
	 * @Fields  : 保险公司
	 * @author yangyiquan
	 */
	private String insCompName;

	/**
	 * @Fields  : 商业险保单号
	 * @author yangyiquan
	 */
	private String insPolicyNo;

	/**
	 * @Fields  : 抵押日期
	 * @author yangyiquan
	 */
	private Date mortgageDate;

	/**
	 * @Fields  : 车管所
	 * @author yangyiquan
	 */
	private String dmvName;

	/**
	 * @Fields  : 解除抵押原因
	 * @author yangyiquan
	 */
	private String mortgageReason;

	/**
	 * @Fields  : 邮寄资料地址属性
	 * @author yangyiquan
	 */
	private String postAddrType;

	/**
	 * @Fields  : 邮寄地址 
	 * @author yangyiquan
	 */
	private String postAddr;

	/**
	 * @Fields  : 邮寄备注
	 * @author yangyiquan
	 */
	private String postMemo;

	/**
	 * @Fields  : 资料邮寄ID
	 * @author yangyiquan
	 */
	private String filePostId;

}