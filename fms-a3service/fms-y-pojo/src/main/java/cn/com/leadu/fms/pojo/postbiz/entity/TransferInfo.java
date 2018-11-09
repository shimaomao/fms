package cn.com.leadu.fms.pojo.postbiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author wangxue
 * @ClassName: TransferInfo
 * @Description: 过户流程实体
 * @date 2018-08-30
 */
@Data
public class TransferInfo extends BaseEntity<TransferInfo> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 过户信息ID
	 * @author wangxue
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String transferId;

	/**
	 * @Fields  : 过户任务号
	 * @author wangxue
	 */
	private String transferNo;

	/**
	 * @Fields  : 合同编号
	 * @author wangxue
	 */
	private String contNo;

	/**
	 * @Fields  : 车架号
	 * @author wangxue
	 */
	private String vinNo;

	/**
	 * @Fields  : 过户状态
	 * @author wangxue
	 */
	private String transferSts;

	/**
	 * @Fields  : 当前节点用户
	 * @author wangxue
	 */
	private String presentUser;

	/**
	 * @Fields  : 过户处理状态
	 * @author wangxue
	 */
	private String transferHandleSts;

	/**
	 * @Fields  : 所有权转移人
	 * @author wangxue
	 */
	private String ownershipPerson;

	/**
	 * @Fields  : 证件号码
	 * @author wangxue
	 */
	private String certifNo;

	/**
	 * @Fields  : 过户申请日期
	 * @author wangxue
	 */
	private Date transferApplyDate;

	/**
	 * @Fields  : 保险处置方式
	 * @author wangxue
	 */
	private String insurancDealType;

	/**
	 * @Fields  : 退保金额
	 * @author wangxue
	 */
	private BigDecimal retreatsAmount;

	/**
	 * @Fields  : 过户手续费
	 * @author wangxue
	 */
	private BigDecimal transferCost;

	/**
	 * @Fields  : 保证金
	 * @author wangxue
	 */
	private BigDecimal deposit;

	/**
	 * @Fields  : 过户保证金
	 * @author wangxue
	 */
	private BigDecimal transferDeposit;

	/**
	 * @Fields  : 费用总额
	 * @author wangxue
	 */
	private BigDecimal totalCost;

	/**
	 * @Fields  : 备注
	 * @author wangxue
	 */
	private String remark;

	/**
	 * @Fields  : 联系电话
	 * @author wangxue
	 */
	private String contactMobile;

	/**
	 * @Fields  : 联系地址
	 * @author wangxue
	 */
	private String contactAddr;

	/**
	 * @Fields  : 退保处理状态
	 * @author yanfengbo
	 */
	private String retreatsHandleSts;

	/**
	 * @Fields  : 退保当前节点
	 * @author yanfengbo
	 */
	private String retreatsPresentUser;

	/**
	 * @Fields  : 退保任务号
	 * @author yanfengbo
	 */
	private String retreatsNo;

}