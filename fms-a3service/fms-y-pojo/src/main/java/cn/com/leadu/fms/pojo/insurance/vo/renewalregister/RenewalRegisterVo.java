package cn.com.leadu.fms.pojo.insurance.vo.renewalregister;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.insurance.entity.RenewalRegister;
import cn.com.leadu.fms.pojo.prebiz.entity.ContFinDetail;
import cn.com.leadu.fms.pojo.prebiz.entity.ContInsurance;
import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteeComp;
import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteePers;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author yanfengbo
 * @ClassName: RenewalRegisterVo
 * @Description: 续保任务一览载体
 * @date 2018-05-17
 */
@ExcelTitle(value = "续保任务信息")
@Data
public class RenewalRegisterVo extends PageQuery<RenewalRegister> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 续保任务ID
	 * @author yanfengbo
	 */
	private String renewalRegisterId;

	/**
	 * @Fields  : 合同编号
	 * @author yanfengbo
	 */
	private String contNo;

	/**
	 * @Fields  : 任务Id
	 * @author yanfengbo
	 */
	private String taskId;

	/**
	 * @Fields  : 续保期限日
	 * @author yanfengbo
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date renewalDeadlineDate;

	/**
	 * @Fields  : 续保任务状态
	 * @author yanfengbo
	 */
	private String renewalStatus;

	/**
	 * @Fields  : 审批人
	 * @author ningyangyang
	 */
	private String presentUser;

	/**
	 * @Fields  : 保险融资额
	 * @author yanfengbo
	 */
	private BigDecimal finAmount;

	/**
	 * @Fields  : 是否融保险
	 * @author yanfengbo
	 */
	private String finFlag;

	/**
	 * @Fields  : 续保保险信息ID
	 * @author yanfengbo
	 */
	private String renewalContVehinsId;

	/**
	 * @Fields  : 续保任务ID
	 * @author yanfengbo
	 */
	private List<String> renewalRegisterIds;

	/**
	 * @Fields  : 承租人
	 * @author yanfengbo
	 */
	private String name;

	/**
	 * @Fields  : 申请类型
	 * @author yanfengbo
	 */
	private String applyType;

	/**
	 * @Fields  : 申请编号
	 * @author yanfengbo
	 */
	private String applyNo;

	/**
	 * @Fields  : 联系电话
	 * @author yanfengbo
	 */
	private String mobileNo;

	/**
	 * @Fields  : 发动机号
	 * @author yanfengbo
	 */
	private String engineNo;

	/**
	 * @Fields  : 车架号
	 * @author yanfengbo
	 */
	private String vinNo;

	/**
	 * @Fields  : 车牌号
	 * @author yanfengbo
	 */
	private String vehicleLicenseNo;

	/**
	 * @Fields  : 车型
	 * @author yanfengbo
	 */
	private String vehicleCodeName;

	/**
	 * @Fields  : 订单提出机构
	 * @author yanfengbo
	 */
	private String groupName;

	/**
	 * @Fields  : 合同车辆保险信息实体
	 * @author yanfengbo
	 */
	private ContInsurance contInsurance;

	/**
	 * @Fields  : 附件
	 */
	private CommonBizFilesVo bizfilesVo;

	/**
	 * @Fields  : 出租人
	 * @author ningyangyang
	 */
	private String lessor;

	/**
	 * @Fields  : 业务类型
	 * @author ningyangyang
	 */
	private String serviceType;

	/**
	 * @Fields  : 融资期限
	 * @author ningyangyang
	 */
	private String finPeriodType;

	/**
	 * @Fields  : 实际用车人
	 * @author ningyangyang
	 */
	private String driver;

	/**
	 * @Fields  : 实际用车人联系方式
	 * @author ningyangyang
	 */
	private String driverMobno;

	/**
	 * @Fields  : 续保押金
	 * @author ningyangyang
	 */
	private BigDecimal  renewalDeposit;

	/**
	 * @Fields  : 盗抢险投保渠道
	 * @author ningyangyang
	 */
	private String theftInsuranceType;

	/**
	 * @Fields  : 担保人信息
	 * @author ningyangyang
	 */
	private List<GuaranteePers> guaranteePersList;

	/**
	 * @Fields  : 担保企业信息
	 * @author ningyangyang
	 */
	private List<GuaranteeComp> guaranteeCompList;

	/**
	 * @Fields  : 融资金额
	 * @author ningyangyang
	 */
	private List<ContFinDetail> contFinDetailList;

	/**
	 * @Fields  : 续保任务号
	 * @author ningyangyang
	 */
	private String renewalTaskNo;

	/**
	 * @Fields  : 保险购买方式
	 * @author ningyangyang
	 */
	private String insurPurType;

	/**
	 * @Fields  : 客户打款金额
	 * @author ningyangyang
	 */
	private BigDecimal customPaymentAmount;

	/**
	 * @Fields  : 当前保险信息ID
	 * @author ningyangyang
	 */
	private String currentInsuranceId;

	/**
	 * @Fields  : 保险卡快递单号
	 * @author ningyangyang
	 */
	private String insurancePostNo;

	/**
	 * @Fields  : 请款金额
	 * @author ningyangyang
	 */
	private BigDecimal requesAmount;

	/**
	 * @Fields  : 收款银行
	 * @author ningyangyang
	 */
	private String  recAccBank;

	/**
	 * @Fields  : 收款银行
	 * @author ningyangyang
	 */
	private String  recAccBranch;
	/**
	 * @Fields  : 收款账号
	 * @author ningyangyang
	 */
	private String  recAccountNo;

	/**
	 * @Fields  : 收款户名
	 * @author ningyangyang
	 */
	private String  recAccountName;

	/**
	 * @Fields  : 收款联行号
	 * @author ningyangyang
	 */
	private String  recEleBankNo;

	/**
	 * @Fields  :  付款银行
	 */
	private String payAccBank;

	/**
	 * @Fields  :  付款银行
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
	 * @Fields  :  付款联行号
	 */
	private String payEleBankNo;

	/**
	 * @Fields  : 实收金额
	 * @author ningyangyang
	 */
	private BigDecimal  receiptAmount;

	/**
	 * @Fields  : 备注
	 * @author ningyangyang
	 */
	private String  memo;

	/**
	 * @Fields  : 续保实体集合
	 * @author ningyangyang
	 */
	private List<RenewalRegisterVo> renewalRegisterVoList;

	/**
	 * @Fields  : 备注
	 * @author ningyangyang
	 */
	private String remark1;

	/**
	 * @Fields  : 险种类型
	 */
	private String insuranceType;

	/**
	 * @Fields  : 险种信息
	 */
	private String insuranceSelectInfo;

	//最新保险信息
	/**
	 * @Fields  : 当前保险公司名称
	 * @author ningyangyang
	 */
	private String insCompName;

	/**
	 * @Fields  : 保单实际金额
	 * @author ningyangyang
	 */
	private BigDecimal insFee;

	/**
	 * @Fields  : 商业险保费单号
	 * @author ningyangyang
	 */
	private String insPolicyNo;

	/**
	 * @Fields  : 申请类别
	 * @author ningyangyang
	 */
	private String companyType;
	/**
	 * @Fields  : 投保生效日
	 * @author ningyangyang
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date validStartDay;

	/**
	 * @Fields  : 投保失效日
	 * @author ningyangyang
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date validEndDay;

	/**
	 * @Fields  : 判定时间
	 * @author ningyangyang
	 */
	private String jugTime;

	/**
	 * @Fields  : 短信类型判断
	 * @author ningyangyang
	 */
	private String msgType;


	/**
	 * @Fields  : 融资类型
	 * @author ningyangyang
	 */
	private String finItem;

	/**
	 * @Fields  : 到账日期
	 * @author ningyangyang
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date receiptDate;

	/**
	 * @Fields  : 保险失效日开始时间
	 * @author yanfengbo
	 */
	private String validStartTime;

	/**
	 * @Fields  : 保险失效日结束时间
	 * @author yanfengbo
	 */
	private String validEndTime;


	@ExcelTitle(value = "合同编号", sort = 1)
	public String getContNo() {
		return contNo;
	}
	@ExcelTitle(value = "承租人", sort = 2)
	public String getName() {
		return name;
	}
	@ExcelTitle(value = "出租人", sort = 3)
	public String getLessor() {
		return lessor;
	}
	@ExcelTitle(value = "联系方式", sort = 4)
	public String getMobileNo() {
		return mobileNo;
	}

	@ExcelTitle(value = "续保任务状态", sort = 5,codeType = CommonCodeTypeConstants.BIZSTATUS)
	public String getRenewalStatus() {
		return renewalStatus;
	}

	@ExcelTitle(value = "保险融资额", sort = 6)
	public String getContFinDetails() {
		StringBuffer contFinDetails = new StringBuffer();
		if(ArrayUtils.isNotNullAndLengthNotZero(contFinDetailList)){
			for(ContFinDetail contFinDetail : contFinDetailList){
				contFinDetails.append(contFinDetail.getFinItemYear()+"-"+contFinDetail.getFinAmount());
				contFinDetails.append(",");
			}
			contFinDetails = contFinDetails.deleteCharAt(contFinDetails.length() - 1);
		}
		return contFinDetails.toString();
	}
	@ExcelTitle(value = "融资期限", sort = 7)
	public String getFinPeriodType() {
		return finPeriodType;
	}
	@ExcelTitle(value = "担保人", sort = 8)
	public String getGuaranteePers() {
		StringBuffer guaranteePers = new StringBuffer();
		if(ArrayUtils.isNotNullAndLengthNotZero(guaranteePersList)){
			for(GuaranteePers guarantee : guaranteePersList){
				guaranteePers.append(guarantee.getName()+"-"+guarantee.getMobileNo());
				guaranteePers.append(",");
			}
			guaranteePers = guaranteePers.deleteCharAt(guaranteePers.length() - 1);
		}
		return guaranteePers.toString();
	}

	@ExcelTitle(value = "车架号", sort = 9)
	public String getVinNo() {
		return vinNo;
	}

	@ExcelTitle(value = "业务类型", sort = 10,codeType = CommonCodeTypeConstants.PROD_LICENSE_ATTR)
	public String getServiceType() {
		return serviceType;
	}

	@ExcelTitle(value = "实际用车人", sort = 11)
	public String getDriver() {
		return driver;
	}

	@ExcelTitle(value = "实际用车人联系方式", sort = 12)
	public String getDriverMobno() {
		return driverMobno;
	}

	@ExcelTitle(value = "续保押金(元)", sort = 13)
	public BigDecimal getRenewalDeposit(){
		return  renewalDeposit;
	}

	@ExcelTitle(value = "当前投保公司", sort = 14)
	public String getInsCompName(){
		return insCompName;
	}

	@ExcelTitle(value = "当前投保金额(元)", sort = 15)
	public BigDecimal getInsFee(){
		return insFee;
	}

	@ExcelTitle(value = "当前节点用户", sort = 16)
	public String getPresentUser() {
		return presentUser;
	}
}