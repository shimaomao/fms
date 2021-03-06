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
 * @ClassName: OverdueCstm
 * @Description: 逾期客户信息实体
 * @date 2018-05-16
 */
@Data
public class OverdueCstm extends BaseEntity<OverdueCstm> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 逾期客户ID
	 * @author lijunjun
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	private String overdueCstmId;

	/**
	 * @Fields  : 客户姓名
	 * @author lijunjun
	 */
	private String cstmName;

	/**
	 * @Fields  : 证件类型
	 * @author lijunjun
	 */
	private String certifType;

	/**
	 * @Fields  : 证件号码
	 * @author lijunjun
	 */
	private String certifNo;

	/**
	 * @Fields  : 申请类型
	 * @author lijunjun
	 */
	private String applyType;

	/**
	 * @Fields  : 性别
	 * @author lijunjun
	 */
	private String sex;

	/**
	 * @Fields  : 初登日期
	 * @author lijunjun
	 */
	private Date firstOverdueDate;

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
	 * @Fields  : 历史最高逾期天数
	 * @author lijunjun
	 */
	private Integer overdueDaysHis;

	/**
	 * @Fields  : 当前是否逾期
	 * @author lijunjun
	 */
	private String overdueFlag;

	/**
	 * @Fields  : 当前逾期状态
	 * @author lijunjun
	 */
	private String overdueCondCd;

	/**
	 * @Fields  : 当前逾期详情
	 * @author lijunjun
	 */
	private String overdueDetail;

	/**
	 * @Fields  : 当前风险等级
	 * @author lijunjun
	 */
	private String overdueRisk;

}