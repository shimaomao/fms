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
 * @ClassName: CollectionTask
 * @Description: 催收任务实体
 */
@Data
public class CollectionTask extends BaseEntity<CollectionTask> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 催收任务id
	 * @author lijunjun
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String collectionTaskId;

	/**
	 * @Fields  : 逾期客户ID
	 * @author lijunjun
	 */
	private String overdueCstmId;

	/**
	 * @Fields  : 任务号
	 * @author lijunjun
	 */
	private String collectionTaskNo;

	/**
	 * @Fields  : 任务状态
	 * @author lijunjun
	 */
	private String collectionTaskStatus;

	/**
	 * @Fields  : 当前节点用户
	 * @author lijunjun
	 */
	private String presentUser;

	/**
	 * @Fields  : 数据来源 
	 * @author lijunjun
	 */
	private String dataSource;

	/**
	 * @Fields  : 发起人
	 * @author lijunjun
	 */
	private String applyUser;

	/**
	 * @Fields  : 发起时间
	 * @author lijunjun
	 */
	private Date applyDate;

	/**
	 * @Fields  : 催收级别
	 * @author lijunjun
	 */
	private String collectionLevel;

	/**
	 * @Fields  : 申请上门时间
	 * @author lijunjun
	 */
	private Date applyVisitDate;

	/**
	 * @Fields  : 申请上门地址
	 * @author lijunjun
	 */
	private String applyVisitAddr;

	/**
	 * @Fields  : 逾期状况描述
	 * @author lijunjun
	 */
	private String overdueDescription;

	/**
	 * @Fields  : 上门催收原因
	 * @author lijunjun
	 */
	private String collectionReason;

	/**
	 * @Fields  : 车辆使用情况
	 * @author lijunjun
	 */
	private String vehicleSituation;

	/**
	 * @Fields  : 派单类型 
	 * @author lijunjun
	 */
	private String dispatchType;

	/**
	 * @Fields  : 派单人
	 * @author lijunjun
	 */
	private String dispatchUser;

	/**
	 * @Fields  : 任务登记人
	 * @author lijunjun
	 */
	private String registerUser;

	/**
	 * @Fields  : 家访要求
	 * @author lijunjun
	 */
	private String collectionRequirement;

	/**
	 * @Fields  : 还款意愿 
	 * @author lijunjun
	 */
	private String repayDesire;

	/**
	 * @Fields  : 车辆是否本人使用
	 * @author lijunjun
	 */
	private String selfUseFlag;

	/**
	 * @Fields  : 是否亲眼见车
	 * @author lijunjun
	 */
	private String witnessFlag;

	/**
	 * @Fields  : 催收总结
	 * @author lijunjun
	 */
	private String collectionSummary;

	/**
	 * @Fields  : 第三方机构名称
	 * @author lijunjun
	 */
	private String tollyName;

	/**
	 * @Fields  : 第三方机构联系人
	 * @author lijunjun
	 */
	private String tollyContactName;

	/**
	 * @Fields  : 第三方机构联系电话
	 * @author lijunjun
	 */
	private String tollyMobileNo;

	/**
	 * @Fields  : 备注
	 * @author lijunjun
	 */
	private String remark;

}