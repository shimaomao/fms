package cn.com.leadu.fms.pojo.postbiz.vo.collectiontask;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.CollectionTask;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: CollectionTaskVo
 * @Description: 催收任务载体
 */
@Data
@ExcelTitle(value ="上门催收信息",types = {ExcelTypeConstants.ONE, ExcelTypeConstants.TWO})
public class CollectionTaskVo extends PageQuery<CollectionTask> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 催收任务id
	 * @author lijunjun
	 */
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
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
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
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
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
	 * @Fields  : 派单人姓名
	 * @author lijunjun
	 */
	private String dispatchUserName;

	/**
	 * @Fields  : 任务登记人
	 * @author lijunjun
	 */
	private String registerUser;

	/**
	 * @Fields  : 任务登记人姓名
	 * @author lijunjun
	 */
	private String registerUserName;

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
	 * @Fields  : 催收任务id
	 * @author lijunjun
	 */
	private List<String> collectionTaskIds;

	/**
	 * @Fields  : 承租人
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
	 * @Fields  : 备注
	 * @author lijunjun
	 */
	private String remark;

	/**
	 * @Fields  : 任务id
	 * @author lijunjun
	 */
	private String taskId;

	/**
	 * @Fields  : 地址列表信息
	 * @author lijunjun
	 */
	private List<CstmAddrInfoVo> cstmAddrInfoVoList;

	/**
	 * @Fields  : 附件信息
	 * @author lijunjun
	 */
	private List<BizFiles> bizFilesList;

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

	@ExcelTitle(value ="任务号", sort = 1, types = {ExcelTypeConstants.ONE})
	public String getCollectionTaskNo(){return this.collectionTaskNo;}

	@ExcelTitle(value ="任务状态", sort = 2, codeType = CommonCodeTypeConstants.BIZSTATUS, types = {ExcelTypeConstants.ONE})
	public String getCollectionTaskStatus(){return this.collectionTaskStatus;}

	@ExcelTitle(value ="当前节点用户", sort = 3, types = {ExcelTypeConstants.ONE})
	public String getPresentUser(){return this.presentUser;}

	@ExcelTitle(value ="承租人", sort = 4, types = {ExcelTypeConstants.ONE})
	public String getCstmName(){return this.cstmName;}

	@ExcelTitle(value ="证件类型", sort = 5, codeType = CommonCodeTypeConstants.CERTIF_TYPE, types = {ExcelTypeConstants.ONE})
	public String getCertifType(){return this.certifType;}

	@ExcelTitle(value ="证件号", sort = 6, types = {ExcelTypeConstants.ONE})
	public String getCertifNo(){return this.certifNo;}

	@ExcelTitle(value ="数据来源", sort = 7, codeType = CommonCodeTypeConstants.DATA_SOURCE_TYPE, types = {ExcelTypeConstants.ONE})
	public String getDataSource(){return this.dataSource;}

	@ExcelTitle(value ="催收级别", sort = 8, codeType = CommonCodeTypeConstants.COLLECTION_LEVEL, types = {ExcelTypeConstants.ONE})
	public String getCollectionLevel(){return this.collectionLevel;}

	@ExcelTitle(value ="发起人", sort = 9, types = {ExcelTypeConstants.ONE})
	public String getApplyUser(){return this.applyUser;}

	@ExcelTitle(value ="发起时间", sort = 10, types = {ExcelTypeConstants.ONE})
	public String getApplyDateStr(){return DateUtils.dateToStr(this.applyDate,DateUtils.formatStr_yyyyMMdd);}

	@ExcelTitle(value ="派单类型", sort = 11, codeType = CommonCodeTypeConstants.DISPATCH_TYPE, types = {ExcelTypeConstants.ONE})
	public String getDispatchType(){return this.dispatchType;}

	@ExcelTitle(value ="派单人", sort = 12, types = {ExcelTypeConstants.ONE})
	public String getDispatchUserName(){return this.dispatchUserName;}

	@ExcelTitle(value ="任务登记人", sort = 13, types = {ExcelTypeConstants.ONE})
	public String getRegisterUserName(){return this.registerUserName;}

	@ExcelTitle(value ="申请上门时间", sort = 14, types = {ExcelTypeConstants.ONE})
	public String getApplyVisitDateStr(){return DateUtils.dateToStr(this.applyVisitDate,DateUtils.formatStr_yyyyMMdd);}

}