package cn.com.leadu.fms.pojo.postbiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author lijunjun
 * @ClassName: OverdueTelRegister
 * @Description: 电话催收登记信息实体
 * @date 2018-05-17
 */
@Data
public class OverdueTelRegister extends BaseEntity<OverdueTelRegister> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 电话催收登记ID
	 * @author lijunjun
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String overdueTelRegisterId;

	/**
	 * @Fields  : 逾期客户ID
	 * @author lijunjun
	 */
	private String overdueCstmId;

	/**
	 * @Fields  : 分配日期
	 * @author lijunjun
	 */
	private Date assignDate;

	/**
	 * @Fields  : 分配人员账号
	 * @author lijunjun
	 */
	private String assignUser;

	/**
	 * @Fields  : 逾期客户电话信息ID
	 * @author lijunjun
	 */
	private String overdueCstmTelId;

	/**
	 * @Fields  : 电话备注
	 * @author lijunjun
	 */
	private String telMemo;

	/**
	 * @Fields  : 逾期状态
	 * @author lijunjun
	 */
	private String overdueCondCd;

	/**
	 * @Fields  : 逾期状态详情
	 * @author lijunjun
	 */
	private String overdueDetail;

	/**
	 * @Fields  : 风险等级
	 * @author lijunjun
	 */
	private String overdueRisk;

	/**
	 * @Fields  : 承诺还款日
	 * @author lijunjun
	 */
	private Date commitRepayDate;

	/**
	 * @Fields  : 是否风险账户
	 * @author lijunjun
	 */
	private String riskFlag;

	/**
	 * @Fields  : 客户可联性
	 * @author lijunjun
	 */
	private String connectType;

	/**
	 * @Fields  : 工作稳定性
	 * @author lijunjun
	 */
	private String jobType;

	/**
	 * @Fields  : 收入类型
	 * @author lijunjun
	 */
	private String incomeType;

	/**
	 * @Fields  : 居住类型
	 * @author lijunjun
	 */
	private String resideType;

	/**
	 * @Fields  : 居住地真实性
	 * @author lijunjun
	 */
	private String addrValidType;

	/**
	 * @Fields  : 车辆适用情况
	 * @author lijunjun
	 */
	private String vehicleCondType;

	/**
	 * @Fields  : 担保人可联性
	 * @author lijunjun
	 */
	private String guaranteeConnType;

	/**
	 * @Fields  : 联系人可联性
	 * @author lijunjun
	 */
	private String contactConnType;

	/**
	 * @Fields  : 配偶可联性
	 * @author lijunjun
	 */
	private String mateConnType;

}