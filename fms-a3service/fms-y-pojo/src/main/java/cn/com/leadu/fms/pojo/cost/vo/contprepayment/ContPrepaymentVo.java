package cn.com.leadu.fms.pojo.cost.vo.contprepayment;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.cost.entity.ContPrepayDetail;
import cn.com.leadu.fms.pojo.cost.entity.ContPrepayment;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author yangyiquan
 * @ClassName: ContPrepaymentVo
 * @Description: 提前还款载体
 * @date 2018-05-10
 */
@Data
public class ContPrepaymentVo extends PageQuery<ContPrepayment> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 提前还款ID
	 * @author yangyiquan
	 */
	private String contPrepaymentId;

	/**
	 * @Fields  : 提前还款业务号
	 * @author yangyiquan
	 */
	private String contPrepaymentNo;

	/**
	 * @Fields  : 合同编号
	 * @author yangyiquan
	 */
	private String contNo;

	/**
	 * @Fields  : 提前还款状态
	 * @author yangyiquan
	 */
	private String prepaymentSts;

	/**
	 * @Fields  : 提前还款类型
	 * @author yangyiquan
	 */
	private String prepaymentType;

	/**
	 * @Fields  : 提前还款日期
	 * @author yangyiquan
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date prepaymentDate;

	/**
	 * @Fields  : 合同生效日期
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date contractValidDate;

	/**
	 * @Fields  : 提前还款试算总金额
	 * @author yangyiquan
	 */
	private BigDecimal prepayTrialAmount;

	/**
	 * @Fields  : 提前还款实际总金额
	 * @author yangyiquan
	 */
	private BigDecimal prepayActualAmount;

    /**
     * @Fields  : 实收总金额
     * @author yangyiquan
     */
    private BigDecimal receiptActualAmount;

	/**
	 * @Fields  : 已还期数
	 * @author yangyiquan
	 */
	private Integer alreadyRepayNper;

	/**
	 * @Fields  : 已还金额
	 * @author yangyiquan
	 */
	private BigDecimal alreadyRepayAmount;

	/**
	 * @Fields  : 剩余未还租金
	 * @author yangyiquan
	 */
	private BigDecimal residueAmount;

	/**
	 * @Fields  : 审批通过日期
	 * @author yangyiquan
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date prepayPassDate;

	/**
	 * @Fields  : 财务确认日期
	 * @author yangyiquan
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date prepayValidDate;

	/**
	 * @Fields  : 有效期
	 * @author yangyiquan
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date validityDate;

	/**
	 * @Fields  : 当前节点用户
	 * @author yangyiquan
	 */
	private String presentUser;

	/**
	 * @Fields  : 提前还款ID
	 * @author yangyiquan
	 */
	private List<String> contPrepaymentIds;

	/**
	 * @Fields  : 提前还款明细数据
	 * @author yangyiquan
	 */
	private List<ContPrepayDetail> contPrepayDetails;

	/**
	 * @Fields  : 当前任务id
	 * @author yangyiquan
	 */
	private String taskId;
	/**
	 * @Fields  : 当前登录人
	 * @author yangyiquan
	 */
	private String user;

	/**
	 * @Fields  : 备注
	 * @author yangyiquan
	 */
	private String memo;

	/******************************    客户个人/企业基本信息    *****************/
	/**
	 * @Fields  : 客户姓名
	 */
	private String name;
	/**
	 * @Fields  : 客户证件号码
	 */
	private String certifNo;
	/**
	 * @Fields  : 个人标志
	 */
	private String personFlag;
	/**
	 * @Fields  : 企业标志
	 */
	private String companyFlag;

	/******************************    合同融资信息    *****************************/
	/**
	 * @Fields  : 产品名称代码
	 */
	private String product;
	/**
	 * @Fields  : 产品名称
	 */
	private String productName;
	/**
	 * @Fields  : 每期租金
	 */
	private String rent;
	/**
	 * @Fields  : 每期支付日期
	 */
	private String repayDay;
	/**
	 *@Fields  : 融资期数
	 */
	private String finPeriodType;
	/**
	 * @Fields  : 保证金
	 */
	private BigDecimal deposit;
	/**
	 * @Fields  : 融资额
	 */
	private BigDecimal finTotal;
	/**
	 * @Fields  : 业务类型
	 */
	private String licenseAttr;
	/************************    合同融资车辆信息    ***********************/
	/**
	 * @Fields  : 品牌名称
	 */
	private String vehBrandCodeName;
	/**
	 * @Fields  : 车型名称
	 */
	private String vehicleCodeName;
	/**
	 * @Fields  : 续保押金
	 */
	private BigDecimal renewalDeposit;

	/******************************    合同信息    *****************************/
	/**
	 * @Fields  : 车架号
	 */
	private String vinNo;
	/**
	 * @Fields  : 合同状态
	 */
	private String bizStatus;
	/**
	 * @Field : 申请编号
	 */
	private String applyNo;
	/**
	 * @Field : 车牌号
	 */
	private String vehicleLicenseNo;
	/**
	 * @Field : 发动机号
	 */
	private String engineNo;

	/**
	 * @Field : 出租人
	 */
	private String rentPerson;

	/**
	 * @Field : 出租人注册地址
	 */
	private String registeredAddr;

	/**
	 * @Field : 还款状态
	 */
	private String paymentSts;

	/**
	 * @Fields  :出租人区域
	 */
	private String groupDistrict;

	/**
	 * @Fields  :  付款银行
	 */
	private String payAccBank;

	/**
	 * @Fields  :  付款银行分行
	 */
	private String payAccBranch;
	/**
	 * @Fields  : 付款账号
	 */
	private String payAccountNo;

	/**
	 * @Fields  : 付款户名
	 */
	private String payAccountName;

	/**
	 * @Fields  :  收款银行
	 */
	private String recAccBank;

	/**
	 * @Fields  :  收款银行分行
	 */
	private String recAccBranch;
	/**
	 * @Fields  :  收款账号
	 */
	private String recAccountNo;

	/**
	 * @Fields  :  收款户名
	 */
	private String recAccountName;

	/**
	 * @Field : 还款状态检索条件
	 */
	private String paymentStsForSer;

	/******************************    过户信息    *****************/

	/**
	 * @Fields  : 过户任务号
	 * @author wangxue
	 */
	private String transferNo;

	/**
	 * @Fields  : 过户处理状态
	 * @author wangxue
	 */
	private String transferHandleSts;

	/**
	 * @Fields  : 过户费用总额
	 * @author wangxue
	 */
	private BigDecimal transferTotalCost;

}