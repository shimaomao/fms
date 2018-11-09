package cn.com.leadu.fms.pojo.postbiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author wangxue
 * @ClassName: VehicleDisposal
 * @Description: 车辆处置实体
 */
@Data
public class VehicleDisposal extends BaseEntity<VehicleDisposal> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 车辆处置ID
	 * @author wangxue
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String vehicleDisposalId;

	/**
	 * @Fields  : 合同编号
	 * @author wangxue
	 */
	private String contNo;

	/**
	 * @Fields  : 车辆处置方式
	 * @author wangxue
	 */
	private String disposalStatus;

	/**
	 * @Fields  : 收车任务号
	 * @author wangxue
	 */
	private String recoveryTaskNo;

	/**
	 * @Fields  : 出库时间
	 * @author wangxue
	 */
	private Date shipmentDate;

	/**
	 * @Fields  : 出库经办人
	 * @author wangxue
	 */
	private String agent;

	/**
	 * @Fields  : 出库经办人联系方式
	 * @author wangxue
	 */
	private String agentMobileNo;

	/**
	 * @Fields  : 车辆处置状态
	 * @author wangxue
	 */
	private String vehicleDisposalStatus;

	/**
	 * @Fields  : 处置任务号
	 * @author wangxue
	 */
	private String disposalTaskNo;

	/**
	 * @Fields  : 备注
	 * @author wangxue
	 */
	private String remark;

}