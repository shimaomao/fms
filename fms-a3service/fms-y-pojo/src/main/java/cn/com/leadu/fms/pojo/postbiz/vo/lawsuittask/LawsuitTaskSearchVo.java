package cn.com.leadu.fms.pojo.postbiz.vo.lawsuittask;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.LawsuitTask;
import cn.com.leadu.fms.pojo.postbiz.vo.lawsuitregister.LawsuitRegisterVo;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: LawsuitTaskVo
 * @Description: 诉讼任务信息载体
 */
@Data
@ExcelTitle(value ="诉讼任务信息",types = {ExcelTypeConstants.ONE, ExcelTypeConstants.TWO})
public class LawsuitTaskSearchVo extends PageQuery<LawsuitTask> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 诉讼任务id
	 * @author lijunjun
	 */
	private String lawsuitTaskId;

	/**
	 * @Fields  : 诉讼任务号
	 * @author lijunjun
	 */
	private String lawsuitTaskNo;

	/**
	 * @Fields  : 诉讼任务状态
	 * @author lijunjun
	 */
	private String lawsuitTaskStatus;

	/**
	 * @Fields  : 当前节点用户
	 * @author lijunjun
	 */
	private String presentUser;

	/**
	 * @Fields  : 逾期合同ID
	 * @author lijunjun
	 */
	private String overdueContId;

	/**
	 * @Fields  : 合同号
	 * @author lijunjun
	 */
	private String contNo;

	/**
	 * @Fields  : 任务发起人
	 * @author lijunjun
	 */
	private String submitUser;

	/**
	 * @Fields  : 任务发起人姓名
	 * @author lijunjun
	 */
	private String submitUserName;

	/**
	 * @Fields  : 任务发起时间
	 * @author lijunjun
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date submitDate;

	/**
	 * @Fields  : 诉讼类型
	 * @author lijunjun
	 */
	private String lawsuitType;

	/**
	 * @Fields  : 诉讼原因
	 * @author lijunjun
	 */
	private String lawsuitReason;

	/**
	 * @Fields  : 诉讼金额
	 * @author lijunjun
	 */
	private BigDecimal lawsuitAmount;

	/**
	 * @Fields  : 诉讼发起时间
	 * @author lijunjun
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date lawsuitSponsorDate;

	/**
	 * @Fields  : 诉讼地址
	 * @author lijunjun
	 */
	private String lawsuitAddr;

	/**
	 * @Fields  : 被告人
	 * @author lijunjun
	 */
	private String defendant;

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
	 * @Fields  : 派单人姓名
	 * @author lijunjun
	 */
	private String dispatchUserName;

	/**
	 * @Fields  : 登记人
	 * @author lijunjun
	 */
	private String registerUser;

	/**
	 * @Fields  : 登记人姓名
	 * @author lijunjun
	 */
	private String registerUserName;

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
	 * @Fields  : 结案原因
	 * @author lijunjun
	 */
	private String lawsuitEndReason;

	/**
	 * @Fields  : 结案时间
	 * @author lijunjun
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date lawsuitEndDate;

	/**
	 * @Fields  : 备注
	 * @author lijunjun
	 */
	private String remark;

	/**
	 * @Fields  : 诉讼结案备注
	 * @author lijunjun
	 */
	private String lawsuitEndRemark;

	/**
	 * @Fields  : 诉讼任务id
	 * @author lijunjun
	 */
	private List<String> lawsuitTaskIds;

	/**
	 * @Fields  : 车架号
	 * @author lijunjun
	 */
	private String vinNo;

	/**
	 * @Fields  : 申请编号
	 * @author lijunjun
	 */
	private String applyNo;

	/**
	 * @Fields  : 申请类型
	 * @author lijunjun
	 */
	private String applyType;

	/**
	 * @Fields  : 车牌号
	 * @author lijunjun
	 */
	private String vehicleLicenseNo;

	/**
	 * @Fields  : 发动机号
	 * @author lijunjun
	 */
	private String engineNo;

	/**
	 * @Fields  : 承租人
	 * @author lijunjun
	 */
	private String cstmName;

	/**
	 * @Fields  : 出租人
	 * @author lijunjun
	 */
	private String belongGroupName;

	/**
	 * @Fields  : taskId
	 * @author lijunjun
	 */
	private String taskId;

	/**
	 * @Fields  : 诉讼跟进信息List
	 * @author lijunjun
	 */
	private List<LawsuitRegisterVo> lawsuitRegisterVoList;

	/**
	 * @Fields  : 附件List
	 * @author lijunjun
	 */
	private List<BizFiles> bizFilesList;

	@ExcelTitle(value ="任务号", sort = 1, types = {ExcelTypeConstants.ONE})
	public String getLawsuitTaskNo(){return this.lawsuitTaskNo;}

	@ExcelTitle(value ="任务状态", sort = 2, codeType = CommonCodeTypeConstants.BIZSTATUS, types = {ExcelTypeConstants.ONE})
	public String getLawsuitTaskStatus(){return this.lawsuitTaskStatus;}

	@ExcelTitle(value ="当前节点用户", sort = 3, types = {ExcelTypeConstants.ONE})
	public String getPresentUser(){return this.presentUser;}

	@ExcelTitle(value ="申请编号", sort = 4, types = {ExcelTypeConstants.ONE})
	public String getApplyNo(){return this.applyNo;}

	@ExcelTitle(value ="合同编号", sort = 5, types = {ExcelTypeConstants.ONE})
	public String getContNo(){return this.contNo;}

	@ExcelTitle(value ="车架号", sort = 6, types = {ExcelTypeConstants.ONE})
	public String getVinNo(){return this.vinNo;}

	@ExcelTitle(value ="车牌号", sort = 7, types = {ExcelTypeConstants.ONE})
	public String getVehicleLicenseNo(){return this.vehicleLicenseNo;}

	@ExcelTitle(value ="承租人", sort = 8, types = {ExcelTypeConstants.ONE})
	public String getCstmName(){return this.cstmName;}

	@ExcelTitle(value ="任务发起人", sort = 9, types = {ExcelTypeConstants.ONE})
	public String getSubmitUser(){return this.submitUser;}

	@ExcelTitle(value ="任务发起时间", sort = 10, types = {ExcelTypeConstants.ONE})
	public String getSubmitDateStr(){return DateUtils.dateToStr(this.submitDate,DateUtils.formatStr_yyyyMMdd);}

	@ExcelTitle(value ="诉讼类型", sort = 11, codeType = CommonCodeTypeConstants.LAWSUIT_TYPE, types = {ExcelTypeConstants.ONE})
	public String getLawsuitType(){return this.lawsuitType;}

	@ExcelTitle(value ="诉讼原因", sort = 12, codeType = CommonCodeTypeConstants.LAWSUIT_REASON, types = {ExcelTypeConstants.ONE})
	public String getLawsuitReason(){return this.lawsuitReason;}

	@ExcelTitle(value ="派单类型", sort = 13, codeType = CommonCodeTypeConstants.DISPATCH_TYPE, types = {ExcelTypeConstants.ONE})
	public String getDispatchType(){return this.dispatchType;}

	@ExcelTitle(value ="登记人", sort = 14, types = {ExcelTypeConstants.ONE})
	public String getRegisterUserName(){return this.registerUserName;}
}