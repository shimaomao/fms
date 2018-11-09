package cn.com.leadu.fms.pojo.prebiz.vo.contrequestpay;

import cn.com.leadu.fms.pojo.finance.vo.contcharge.ContChargeReceiptVo;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinPayVo;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * @author liujinge
 * @ClassName: ContInsuranceVo
 * @Description: 合同车辆保险信息载体
 * @date 2018-03-23
 */
@Data
public class ContRequestPayVo{

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 保险信息ID
	 */
	private String contVehinsId;

	/**
	 * @Fields  : 申请编号
	 */
	private String applyNo;
	/**
	 * @Fields  : 合同号
	 */
	private String contNo;

	/**
	 * @Fields  : 保险公司名称
	 */
	private String insCompName;

	/**
	 * @Fields  : 商业险保单号
	 */
	private String insPolicyNo;

	/**
	 * @Fields  : 投保生效日
	 */
	private Date validStartDay;

	/**
	 * @Fields  : 投保失效日
	 */
	private Date validEndDay;

	/**
	 * @Fields  : 保单实际金额
	 */
	private BigDecimal insFee;

	/**
	 * @Fields  : 保单状态
	 */
	private String insuranceStatus;

	/**
	 * @Fields  : 备注
	 */
	private String memo;

	/**
	 * @Fields  : 当前用户
	 */
	private String user;

	/**
	 * @Fields  : 抵扣金额
	 * @author ningyangyang
	 */
	private BigDecimal chargeDeductionAmount;

	/**
	 * @Fields  : 
	 */
	private List<String> contVehinsIds;

	/**
	 * @Fields  : 附件
	 * @author liujinge
	 */
	private CommonBizFilesVo bizFilesVo;

	/**
	 * @Fields  :  任务id
	 * @author qiaomengnan
	 */
	private String taskId;

	/**
	 * @Fields  :  付款项目明细
	 * @author yangyiquan
	 */
	private List<ContFinPayVo> contFinPayVoList;

	/**
	 * @Fields  : 财务待收款表和收款表关联信息
	 * @author yangyiquan
	 */
	List<ContChargeReceiptVo> contChargeReceiptVoList;

	/**
	 * @Fields  :  出租人
	 * @author yangyiquan
	 */
	private String rentName;

	/**
	 * @Fields  :  出租人区域
	 * @author yangyiquan
	 */
	private String voucherGroup;
	/**
	 * @Fields  :  承租人
	 * @author yangyiquan
	 */
	private String personName;
	/**
	 * @Fields  :  业务类型
	 * @author yangyiquan
	 */
	private String licenseAttr;
	/**
	 * @Fields  : 车架号
	 * @author yangyiquan
	 */
	private String vinNo;
	/**
	 * @Fields  : 车型
	 */
	private String vehicleCode;
	/**
	 * @Fields  : 车型名称
	 */
	private String vehicleCodeName;
	/**
	 * @Fields  : 实际销售方代码
	 */
	private String saleGroupCode;
	/**
	 * @Fields  : 实际销售方名称
	 */
	private String saleGroupName;
	/**
	 * @Fields  : 实际销售方银行
	 */
	private String accBank;

	/**
	 * @Fields  : 实际销售方银行账号
	 */
	private String accountNo;

	/**
	 * @Fields  : 实际销售方银行户名
	 */
	private String accountName;

	/**
	 * @Fields  : 实际销售方联行号
	 */
	private String eleAccountNo;
	/**
	 * @Fields  : 首付款
	 */
	private BigDecimal initAmount;
	/**
	 * @Fields  : 尾款
	 */
	private BigDecimal finalAmount;
	/**
	 * @Fields  : 保证金
	 */
	private BigDecimal deposit;
	/**
	 * @Fields  : 续保押金
	 */
	private BigDecimal renewalDeposit;
	/**
	 * @Fields  : 年供
	 */
	private BigDecimal annualSupplyAmount;
	/**
	 * @Fields  : 月租金
	 */
	private BigDecimal rent;
	/**
	 * @Fields  : 手续费
	 */
	private BigDecimal charge;

	/**
	 * @Fields  : 代收手续费
	 */
	private BigDecimal salesCharge;
	/**
	 * @Fields  : 定金金额
	 */
	private BigDecimal vehDeposit;
	/**
	 * @Fields  : 定金是否抵扣车款
	 */
	private String deductibleFees;
	/**
	 * @Fields  : 制单，付款时使用，付款实体
	 */
	private ContPay contPay;

	/**
	 * @Fields  : 附件集合用于返回详情使用
	 * @author qiaomengnan
	 */
	private List<BizFiles> bizFilesList;

	/**
	 * @Fields  :  租金支付模式
	 * @author yanfengbo
	 */
	private String rentPayMode;

	/**
	 * @Fields  :  每期支付日期
	 * @author yanfengbo
	 */
	private String repayDay;

	/**
	 * @Fields  : 合同生成日期
	 * @author yanfengbo
	 */
	private Date contractDate;

	/**
	 * @Fields  : 融资期限
	 * @author yanfengbo
	 */
	private String finPeriodType;
}