package cn.com.leadu.fms.pojo.insurance.vo.continsurclaim;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import cn.com.leadu.fms.pojo.insurance.entity.ContInsurClaim;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author yanfengbo
 * @ClassName: ContInsurClaimVo
 * @Description: 保险理赔载体
 * @date 2018-05-14
 */
@ExcelTitle(value = "保险理赔申请一览明细")
@Data
public class ContInsurClaimVo extends PageQuery<ContInsurClaim> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 保险理赔ID
	 * @author yanfengbo
	 */
	private String contInsurClaimId;

	/**
	 * @Fields  : 合同编号
	 * @author yanfengbo
	 */
	private String contNo;

	/**
	 * @Fields  : 保险信息ID
	 * @author yanfengbo
	 */
	private String contVehinsId;

	/**
	 * @Fields  : 保险理赔任务号
	 * @author yanfengbo
	 */
	private String contInsurClaimNo;

	/**
	 * @Fields  : 申请日期
	 * @author yanfengbo
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date insurClaimDate;

	/**
	 * @Fields  : 赔款到账日期
	 * @author yanfengbo
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date indemnityEnterAmountDate;

	/**
	 * @Fields  : 是否需要退还
	 * @author yanfengbo
	 */
	private String returnFlag;

	/**
	 * @Fields  : 退还方式
	 * @author yanfengbo
	 */
	private String returnMode;

	/**
	 * @Fields  : 出险日期
	 * @author yanfengbo
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date accidentTime;

	/**
	 * @Fields  : 报案号
	 * @author yanfengbo
	 */
	private String accidentRepno;

	/**
	 * @Fields  : 理赔金额
	 * @author yanfengbo
	 */
	private BigDecimal claimAmount;

	/**
	 * @Fields  : 情况说明
	 * @author yanfengbo
	 */
	private String description;

	/**
	 * @Fields  : 是否邮寄
	 * @author yanfengbo
	 */
	private String postFlag;

	/**
	 * @Fields  : 邮寄地址
	 * @author yanfengbo
	 */
	private String postAddr;

	/**
	 * @Fields  : 邮寄收货人
	 * @author yanfengbo
	 */
	private String postName;

	/**
	 * @Fields  : 快递单号
	 * @author yanfengbo
	 */
	private String postNo;

	/**
	 * @Fields  : 审批通过日期
	 * @author yanfengbo
	 */
	private Date claimPassDate;

	/**
	 * @Fields  : 财务确认日期
	 * @author yanfengbo
	 */
	private Date claimValidDate;

	/**
	 * @Fields  : 当前节点用户
	 * @author yanfengbo
	 */
	private String presentUser;

	/**
	 * @Fields  : 保险理赔ID
	 * @author yanfengbo
	 */
	private List<String> contInsurClaimIds;

	/**
	 * @Fields  : 保险公司名称
	 * @author yanfengbo
	 */
	private String insCompName;

	/**
	 * @Fields  : 商业保险单号
	 * @author yanfengbo
	 */
	private String insPolicyNo;

	/**
	 * @Fields  : 投保生效日
	 * @author yanfengbo
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date validStartDay;

	/**
	 * @Fields  : 投保失效日
	 * @author yanfengbo
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date validEndDay;

	/**
	 * @Fields  : 车型
	 * @author yanfengbo
	 */
	private String vehicleCodeName;

	/**
	 * @Fields  : 车架号
	 * @author yanfengbo
	 */
	private String vinNo;

	/**
	 * @Fields  : 合同状态
	 * @author yanfengbo
	 */
	private String bizStatus;

	/**
	 * @Fields  : 客户姓名
	 * @author yanfengbo
	 */
	private String name;

	/**
	 * @Fields  : 保险理赔状态
	 * @author yanfengbo
	 */
	private String insurClaimStatus;

	/**
	 * @Fields  : 联系电话
	 * @author yanfengbo
	 */
	private String postMobno;

	/**
	 * @Fields  : 附件
	 */
	private CommonBizFilesVo bizfilesVo;

	/**
	 * @Fields  : 操作分类
	 */
	private String actType;

	/**
	 * @Fields  : 备注
	 */
	private String remark1;
	/**
	 * @Fields  : taskId
	 */
	private String taskId;

	/**
	 * @Fields  : serviceId
	 */
	private String serviceId;

	/**
	 * @Fields  :付款银行
	 */
	private String payAccBank;

	/**
	 * @Fields  :付款账户
	 */
	private String payAccountNo;

	/**
	 * @Fields  :付款帐户名
	 */
	private String payAccountName;

	/**
	 * @Fields  :付款表id
	 */
	private String contPayId;

	/**
	 * @Fields  :
	 */
	private String user;

	/**
	 * @Fields  :出租人
	 */
	private String groupName;

	/**
	 * @Fields  :车牌号
	 */
	private String vehicleLicenseNo;

	/**
	 * @Fields  :保单实际金额
	 */
	private String insFee;

	/**
	 * @Fields  :理赔收款开户行
	 */
	private String accBank;

	/**
	 * @Fields  :理赔收款开户行
	 */
	private String accBranch;
	/**
	 * @Fields  :理赔收款户名
	 */
	private String accountName;

	/**
	 * @Fields  :理赔收款账户
	 */
	private String accountNo;

	private String approvalFlag;

	/**
	 * @Fields  : 险种类型
	 */
	private String insuranceType;

	/**
	 * @Fields  : 险种信息
	 */
	private String insuranceSelectInfo;

	/**
	 * @Fields  : 付款银行分行
	 * @author lijunjun
	 */
	private String payAccBranch;


	/**
	 * @Fields  : 收款银行分行
	 * @author lijunjun
	 */
	private String recAccBranch;

	/**
	 * @Fields  : 附件信息
	 * @author qiaomengnan
	 */
	private List<BizFiles> bizFilesList;

	/**
	 * @Fields  : 当前保险年限
	 * @author yanfengbo
	 */
	private Integer insuranceYears;

	/**
	 * @Fields  :出租人区域
	 */
	private String groupDistrict;

	/**
	 * @Fields  :发动机号
	 */
	private String engineNo;

	/**
	 * @Fields  : 实收总金额
	 */
	private BigDecimal receiptsAmount;

	/**
	 * @Fields  : 财务收款表
	 */
	List<ContReceipt> contReceiptList;

	@ExcelTitle(value = "承租人", sort = 1)
	public String getName() {
		return name;
	}
	@ExcelTitle(value = "出租人", sort = 2)
	public String getGroupName() {
		return groupName;
	}
	@ExcelTitle(value = "车架号", sort = 3)
	public String getVinNo() {
		return vinNo;
	}
	@ExcelTitle(value = "理赔金额", sort = 4)
	public BigDecimal getClaimAmount() {
		return claimAmount;
	}
	@ExcelTitle(value = "申请日期", sort = 5)
	public String getInsurClaimDateStr() {
		return DateUtils.dateToStr(insurClaimDate,DateUtils.formatStr_yyyyMMdd);
	}
}