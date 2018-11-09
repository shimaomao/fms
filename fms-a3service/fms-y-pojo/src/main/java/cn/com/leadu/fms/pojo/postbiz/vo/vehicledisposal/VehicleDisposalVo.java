package cn.com.leadu.fms.pojo.postbiz.vo.vehicledisposal;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.VehicleDisposal;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Date;

/**
 * @author wangxue
 * @ClassName: VehicleDisposalVo
 * @Description: 车辆处置载体
 */
@Data
public class VehicleDisposalVo extends PageQuery<VehicleDisposal> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields : 工作流任务id
	 * @author wangxue
	 */
	private String taskId;

	/**
	 * @Fields  : 车辆处置ID
	 * @author wangxue
	 */
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
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
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
	 * @Fields  : 车辆处置ID
	 * @author wangxue
	 */
	private List<String> vehicleDisposalIds;

	/**
	 * @Fields  : 处置任务流程状态
	 * @author wangxue
	 */
	private String disposalTaskStatus;

    /**
     * @Fields  : 车辆残值
     * @author wangxue
     */
    private BigDecimal residualValue;

    /**
     * @Fields  : 说明或备注
     * @author wangxue
     */
    private String remark;

    /**
     * @Fields  : 附件集合
     * @author qiaomengnan
     */
    private List<BizFiles> bizFilesList;

	/**
	 * @Fields  : 当前登录用户
	 * @author qiaomengnan
	 */
	private String user;

	/******************************    合同信息和合同融资信息    *****************/
    /**
     * @Fields  : 车架号
     * @author wangxue
     */
    private String vinNo;

	/**
	 * @Fields  : 车牌号
	 * @author wangxue
	 */
	private String vehicleLicenseNo;

	/**
	 * @Fields  : 发动机号
	 * @author wangxue
	 */
	private String engineNo;

	/**
	 * @Fields  : 融资额
	 * @author wangxue
	 */
	private BigDecimal finTotal;

	/**
	 * @Fields  : 融资期限
	 * @author wangxue
	 */
	private BigDecimal finPeriodType;

	/**
	 * @Fields  : 出租人
	 * @author wangxue
	 */
	private String rentPerson;

	/**
	 * @Fields  : 承租人
	 * @author wangxue
	 */
	private String cstmName;

    /**
     * @Fields  : 客户证件号
     * @author wangxue
     */
    private String certifNo;

	/**
	 * @Fields  : GPS厂商
	 * @author wangxue
	 */
	private String gpsSeller;

    /**
     * @Fields  : 车辆行驶证注册日期
     * @author wangxue
     */
    private Date vehicleDrivingLicenseRegisterDate;

	/******************************    收车信息    *****************/
	/**
	 * @Fields  : 收车实际费用
	 */
	private BigDecimal recoveryAmount;

	/**
	 * @Fields  : 入库地点
	 */
	private String storageAddr;

	/**
	 * @Fields  : 入库时间
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date storageDate;

	/**
	 * @Fields  : 收车发起时间
	 */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date recoverySubmitDate;

    /**
     * @Fields  : 入库登记车架号
     * @author ningyangyang
     */
    private String registerVinNo;

    /**
     * @Fields  : 入库登记行驶公里数
     * @author ningyangyang
     */
    private BigDecimal registerMileAge;

    /**
     * @Fields  : 入库登记车辆状态描述
     * @author ningyangyang
     */
    private String carStatusDes;


}