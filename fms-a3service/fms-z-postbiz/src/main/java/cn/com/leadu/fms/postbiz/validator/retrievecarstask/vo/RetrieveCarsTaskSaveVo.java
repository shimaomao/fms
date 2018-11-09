package cn.com.leadu.fms.postbiz.validator.retrievecarstask.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.RetrieveCarsTask;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ningyangyang
 * @ClassName: RetrieveCarsTaskVo
 * @Description: 收车任务保存时载体及验证
 */
@Data
public class RetrieveCarsTaskSaveVo extends BaseVo<RetrieveCarsTask> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 收车任务id
	 * @author ningyangyang
	 */
	private String retrieveCarId;

	/**
	 * @Fields  : 收车任务号
	 * @author ningyangyang
	 */
	private String retrieveCarTaskNo;

	/**
	 * @Fields  : 当前节点用户
	 * @author ningyangyang
	 */
	private String presentUser;

	/**
	 * @Fields  : 合同号
	 * @author ningyangyang
	 */
	private String contNo;

	/**
	 * @Fields  : 逾期合同id
	 * @author ningyangyang
	 */
	private String overdueContId;

	/**
	 * @Fields  : 任务发起人
	 * @author ningyangyang
	 */
	private String submitUser;

	/**
	 * @Fields  : 任务发起日期
	 * @author ningyangyang
	 */
	private Date submitDate;

	/**
	 * @Fields  : 收车原因
	 * @author ningyangyang
	 */
	private String retrieveReason;

	/**
	 * @Fields  : 任务状态
	 * @author ningyangyang
	 */
	private String taskStatus;

	/**
	 * @Fields  : 派单类型
	 * @author ningyangyang
	 */
	private String dispachType;

	/**
	 * @Fields  : 登记人
	 * @author ningyangyang
	 */
	private String registerPeople;

	/**
	 * @Fields  : 派单人
	 * @author ningyangyang
	 */
	private String dispachPeople;

	/**
	 * @Fields  : 第三方派单机构
	 * @author ningyangyang
	 */
	private String thirdDispachOrg;

	/**
	 * @Fields  : 第三方联系人
	 * @author ningyangyang
	 */
	private String thirdDispachContact;

	/**
	 * @Fields  : 第三方联系人电话
	 * @author ningyangyang
	 */
	private String thirdDispachMobile;

	/**
	 * @Fields  : 预估收车佣金
	 * @author ningyangyang
	 */
	private BigDecimal forRetrAmount;

	/**
	 * @Fields  : 收车实际费用
	 * @author ningyangyang
	 */
	private BigDecimal actRetrAmount;

	/**
	 * @Fields  : 入库地点
	 * @author ningyangyang
	 */
	private String storageAddr;

	/**
	 * @Fields  : 车辆残值
	 * @author ningyangyang
	 */
	private BigDecimal salvageValue;

	/**
	 * @Fields  : 费用差额
	 * @author ningyangyang
	 */
	private BigDecimal costDifference;

	/**
	 * @Fields  : 提前还款试算金额
	 * @author ningyangyang
	 */
	private BigDecimal trialAmount;

	/**
	 * @Fields  : 收车结果
	 * @author ningyangyang
	 */
	private String retrieveResult;

	/**
	 * @Fields  : 收车过程描述
	 * @author ningyangyang
	 */
	private String retrProcessDes;

	/**
	 * @Fields  : 入库时间
	 * @author ningyangyang
	 */
	private Date storageDate;

	/**
	 * @Fields  : 入库经办人
	 * @author ningyangyang
	 */
	private String agent;

	/**
	 * @Fields  : 入库经办人联系方式
	 * @author ningyangyang
	 */
	private String agentMobileNo;

	/**
	 * @Fields  : 入库登记车架号
	 * @author ningyangyang
	 */
	private String vinNo;

	/**
	 * @Fields  : 入库登记行驶公里数
	 * @author ningyangyang
	 */
	private BigDecimal mileAge;

	/**
	 * @Fields  : 入库登记车辆状态描述
	 * @author ningyangyang
	 */
	private String carStatusDes;

}