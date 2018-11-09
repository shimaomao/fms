package cn.com.leadu.fms.pojo.postbiz.vo.retrievecarstask;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.RetrieveCarsTask;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author ningyangyang
 * @ClassName: RetrieveCarsTaskVo
 * @Description: 收车任务载体
 */
@ExcelTitle(value = "收车任务一览明细")
@Data
public class RetrieveCarsTaskVo extends PageQuery<RetrieveCarsTask> {

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
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
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
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
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

	/**
	 * @Fields  : 收车任务id
	 * @author ningyangyang
	 */
	private List<String> retrieveCarIds;

	/**
	 * @Fields  : 申请编号
	 * @author qiaomengnan
	 */
	private String applyNo;

	/**
	 * @Fields  : 车牌号
	 * @author qiaomengnan
	 */
	private String vehicleLicenseNo;

	/**
	 * @Fields  : 承租人
	 * @author qiaomengnan
	 */
	private String cstmName;

	/**
	 * @Fields  : 逾期合同车架号
	 * @author qiaomengnan
	 */
	private String overdueContVinNo;

	/**
	 * @Fields  : GPS厂商
	 * @author qiaomengnan
	 */
	private String gpsSeller;

	/**
	 * @Fields  : 出租人
	 * @author qiaomengnan
	 */
	private String lessor;

	/**
	 * @Fields  : 发动机号
	 * @author qiaomengnan
	 */
	private String engineNo;

	/**
	 * @Fields  : 登记人用户名
	 * @author qiaomengnan
	 */
	private String registerPeopleName;

	/**
	 * @Fields  : 派单人用户名
	 * @author qiaomengnan
	 */
	private String dispachPeopleName;

	/**
	 * @Fields  : 审批备注
	 * @author ningyangyang
	 */
	private String memo;

	/**
	 * @Fields  : 付款银行
	 */
	private String payAccBank;

	/**
	 * @Fields  : 付款账号
	 */
	private String payAccountNo;

	/**
	 * @Fields  : 付款户名
	 */
	private String payAccountName;

	/**
	 * @Fields  : 付款银行支行
	 */
	private String payAccBranch;


	/**
	 * @Fields  : 收款银行
	 */
	private String recAccBank;

	/**
	 * @Fields  : 收款账号
	 */
	private String recAccountNo;

	/**
	 * @Fields  : 收款户名
	 */
	private String recAccountName;

	/**
	 * @Fields  : 收款银行支行
	 */
	private String recAccBranch;

	/**
	 * @Fields  : taskId
	 */
	private String taskId;

	/**
	 * @Fields  : 委派登记附件
	 */
	private List<BizFiles> registerFileList;

	/**
	 * @Fields  : 入库附件
	 */
	private List<BizFiles> storageFileList;

	/**
	 * @Fields  : 归档附件附件
	 */
	private List<BizFiles> origSortFileList;

	/**
	 * @Fields  : 暂存标志
	 */
	private String flag;

	/**
	 * @Fields  : 车钥匙状态
	 */
	private String carKeyStatus;


	/**
	 * @Fields  : 申请类型
	 */
	private String	applyType;


	/**
	 * @Fields  : 业务类型
	 */
	private String  bizCodeType;
	/**
	 * @Fields  : 邮寄类型
	 */
	private String	origFileType;
	/**
	 * @Fields  : 归档编号
	 */
	private String fileRecordNo;
	/**
	 * @Fields  : 借阅任务号
	 */
	 private String borrowTaskNo;
	/**
	 * @Fields  : 借阅归还任务号
	 */
	private String	borrowBackTaskNo;

	/**
	 * @Fields  : 附件类型
	 */
	private String fileType;

	@ExcelTitle(value = "收车任务号", sort = 1)
	public String getRetrieveCarTaskNo() {
		return retrieveCarTaskNo;
	}
	@ExcelTitle(value = "申请编号", sort = 2)
	public String getApplyNo() {
		return applyNo;
	}
	@ExcelTitle(value = "合同编号", sort = 3)
	public String getContNo() {
		return contNo;
	}
	@ExcelTitle(value = "车架号", sort = 4)
	public String getVinNo() {
		return overdueContVinNo;
	}
	@ExcelTitle(value = "车牌号", sort = 5)
	public String getVehicleLicenseNo() {
		return vehicleLicenseNo;
	}
	@ExcelTitle(value = "GPS厂商", sort = 6,codeType = CommonCodeTypeConstants.GPSACC_TYPE)
	public String getGpsSeller() {
		return gpsSeller;
	}
	@ExcelTitle(value = "承租人", sort = 7)
	public String getCstmName() {
		return cstmName;
	}
	@ExcelTitle(value = "发起人", sort = 8)
	public String getSubmitUser() {
		return submitUser;
	}
	@ExcelTitle(value = "发起日期", sort = 9)
	public String getSubmitDateToStr() {
		return DateUtils.dateToStr(submitDate,DateUtils.formatStr_yyyyMMdd);
	}
	@ExcelTitle(value = "收车原因", sort = 10)
	public String getRetrieveReason() {
		return retrieveReason;
	}
	@ExcelTitle(value = "当前用户", sort = 11)
	public String getPresentUser() {
		return presentUser;
	}
	@ExcelTitle(value = "收车结果", sort = 12,codeType = CommonCodeTypeConstants.RETRIEVE_RESULT)
	public String getRetrieveResult() {
		return retrieveResult;
	}
	@ExcelTitle(value = "任务状态", sort = 13,codeType = CommonCodeTypeConstants.BIZSTATUS)
	public String getTaskStatus() {
		return taskStatus;
	}
	@ExcelTitle(value = "派单类型", sort = 14,codeType = CommonCodeTypeConstants.DISPATCH_TYPE)
	public String getDispachType() {
		return dispachType;
	}
	@ExcelTitle(value = "登记人", sort = 15)
	public String getRegisterPeople() {
		return registerPeople;
	}
	@ExcelTitle(value = "预估收车佣金", sort = 16)
	public BigDecimal getForRetrAmount() {
		return forRetrAmount;
	}
	@ExcelTitle(value = "实际收车佣金", sort = 17)
	public BigDecimal getActRetrAmount() {
		return actRetrAmount;
	}
	@ExcelTitle(value = "入库地点", sort = 18)
	public String getStorageAddr() {
		return storageAddr;
	}










}