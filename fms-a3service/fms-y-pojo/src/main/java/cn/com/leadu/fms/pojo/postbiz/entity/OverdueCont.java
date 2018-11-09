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
 * @author lijunjun
 * @ClassName: OverdueCont
 * @Description: 逾期合同信息实体
 * @date 2018-05-16
 */
@Data
public class OverdueCont extends BaseEntity<OverdueCont> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 逾期合同ID
	 * @author lijunjun
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String overdueContId;

	/**
	 * @Fields  : 逾期客户ID
	 * @author lijunjun
	 */
	private String overdueCstmId;

	/**
	 * @Fields  : 申请编号
	 * @author lijunjun
	 */
	private String applyNo;

	/**
	 * @Fields  : 合同编号
	 * @author lijunjun
	 */
	private String contNo;

	/**
	 * @Fields  : 车辆类型
	 * @author lijunjun
	 */
	private String vehicleForm;

	/**
	 * @Fields  : 合同生成日期
	 * @author lijunjun
	 */
	private Date contractDate;

	/**
	 * @Fields  : 合同生效日期
	 * @author lijunjun
	 */
	private Date contractValidDate;

	/**
	 * @Fields  : 订单提出机构代码
	 * @author lijunjun
	 */
	private String applyGroup;

	/**
	 * @Fields  : 初登日期
	 * @author lijunjun
	 */
	private Date firstOverdueDate;

	/**
	 * @Fields  : 首期租金
	 * @author lijunjun
	 */
	private BigDecimal rent;

	/**
	 * @Fields  : 车架号
	 * @author lijunjun
	 */
	private String vinNo;

	/**
	 * @Fields  : 发动机号
	 * @author lijunjun
	 */
	private String engineNo;

	/**
	 * @Fields  : 车牌号
	 * @author lijunjun
	 */
	private String vehicleLicenseNo;

	/**
	 * @Fields  : 品牌
	 * @author lijunjun
	 */
	private String vehBrandCode;

	/**
	 * @Fields  : 车型
	 * @author lijunjun
	 */
	private String vehicleCode;

	/**
	 * @Fields  : 车辆配置描述
	 * @author lijunjun
	 */
	private String vehicleComment;

	/**
	 * @Fields  : 颜色
	 * @author lijunjun
	 */
	private String color;

	/**
	 * @Fields  : 归档状态
	 * @author lijunjun
	 */
	private String origFileStatus;

	/**
	 * @Fields  : 归档期限
	 * @author lijunjun
	 */
	private Date origDeadline;

	/**
	 * @Fields  : 当前逾期天数
	 * @author lijunjun
	 */
	private Integer overdueDays;

	/**
	 * @Fields  : 当前逾期期数
	 * @author lijunjun
	 */
	private Integer overduePeriods;

	/**
	 * @Fields  : 当前逾期本金
	 * @author lijunjun
	 */
	private BigDecimal overduePrincipal;

	/**
	 * @Fields  : 当前逾期租金
	 * @author lijunjun
	 */
	private BigDecimal overdueRent;

	/**
	 * @Fields  : 当前逾期罚息
	 * @author lijunjun
	 */
	private BigDecimal overdueAmount;

	/**
	 * @Fields  : 当前逾期总额
	 * @author lijunjun
	 */
	private BigDecimal overdueSum;

	/**
	 * @Fields  : 当前销售未还剩余本金
	 * @author lijunjun
	 */
	private BigDecimal restPrincipal;

	/**
	 * @Fields  : 当前财务未还剩余本金
	 * @author lijunjun
	 */
	private BigDecimal finRestPrincipal;

	/**
	 * @Fields  : 融资期限
	 * @author lijunjun
	 */
	private String finPeriodType;

	/**
	 * @Fields  : 已还期数
	 * @author lijunjun
	 */
	private Integer repayPeriods;

	/**
	 * @Fields  : 历史最高逾期天数
	 * @author lijunjun
	 */
	private Integer overdueDaysHis;

	/**
	 * @Fields  : 逾期次数
	 * @author lijunjun
	 */
	private Integer overdueTimes;

	/**
	 * @Fields  : 当前是否逾期
	 * @author lijunjun
	 */
	private String overdueFlag;

	/**
	 * @Fields  : 车辆处置评估金额
	 * @author lijunjun
	 */
	private BigDecimal evaluatePrice;

	/**
	 * @Fields  : 车辆处置金额
	 * @author lijunjun
	 */
	private BigDecimal disposePrice;

	/**
	 * @Fields  : 逾期处理日期
	 * @author wangxue
	 */
	private Date overdueHandleDate;

}