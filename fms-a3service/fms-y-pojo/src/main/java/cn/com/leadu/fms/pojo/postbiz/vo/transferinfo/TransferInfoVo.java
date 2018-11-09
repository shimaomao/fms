package cn.com.leadu.fms.pojo.postbiz.vo.transferinfo;

import cn.com.leadu.fms.common.constant.enums.asset.MortgageStatusEnums;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.TransferInfo;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author wangxue
 * @ClassName: TransferInfoVo
 * @Description: 过户流程载体
 * @date 2018-08-30
 */
@Data
public class TransferInfoVo extends PageQuery<TransferInfo> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 过户信息ID
	 * @author wangxue
	 */
	private String transferId;

	/**
	 * @Fields  : 过户任务号
	 * @author wangxue
	 */
	private String transferNo;

	/**
	 * @Fields  : 合同编号
	 * @author wangxue
	 */
	private String contNo;

	/**
	 * @Fields  : 车架号
	 * @author wangxue
	 */
	private String vinNo;

	/**
	 * @Fields  : 过户状态
	 * @author wangxue
	 */
	private String transferSts;

	/**
	 * @Fields  : 当前节点用户
	 * @author wangxue
	 */
	private String presentUser;

	/**
	 * @Fields  : 过户处理状态
	 * @author wangxue
	 */
	private String transferHandleSts;

	/**
	 * @Fields  : 所有权转移人
	 * @author wangxue
	 */
	private String ownershipPerson;

	/**
	 * @Fields  : 证件号码
	 * @author wangxue
	 */
	private String certifNo;

	/**
	 * @Fields  : 过户申请日期
	 * @author wangxue
	 */
	private Date transferApplyDate;

	/**
	 * @Fields  : 保险处置方式
	 * @author wangxue
	 */
	private String insurancDealType;

	/**
	 * @Fields  : 退保金额
	 * @author wangxue
	 */
	private BigDecimal retreatsAmount;

	/**
	 * @Fields  : 过户手续费
	 * @author wangxue
	 */
	private BigDecimal transferCost;

	/**
	 * @Fields  : 保证金
	 * @author wangxue
	 */
	private BigDecimal deposit;

	/**
	 * @Fields  : 过户保证金
	 * @author wangxue
	 */
	private BigDecimal transferDeposit;

	/**
	 * @Fields  : 费用总额
	 * @author wangxue
	 */
	private BigDecimal totalCost;

	/**
	 * @Fields  : 备注
	 * @author wangxue
	 */
	private String remark;

	/**
	 * @Fields  : 联系电话
	 * @author wangxue
	 */
	private String contactMobile;

	/**
	 * @Fields  : 联系地址
	 * @author wangxue
	 */
	private String contactAddr;

	/**
	 * @Fields  : 当前用户
	 * @author wangxue
	 */
	private String user;

	/**
	 * @Fields  : 当前任务id
	 * @author wangxue
	 */
	private String taskId;

	/**
	 * @Fields  : 附件集合用于返回详情使用
	 * @author qiaomengnan
	 */
	private List<BizFiles> bizFilesList;

	/**
	 * @Fields  : 申请附件集合用于返回详情使用
	 * @author wangxue
	 */
	private List<BizFiles> applyBizFilesList;

	/**
	 * @Fields  : 提前还款状态
	 * @author yangyiquan
	 */
	private String prepaymentSts;

	/******************************    合同信息和合同融资信息    *****************/
	/**
	 * @Fields  : 发动机号
	 * @author wangxue
	 */
	private String engineNo;

	/**
	 * @Fields  : 车牌号
	 * @author wangxue
	 */
	private String vehicleLicenseNo;

	/**
	 * @Fields  : 合同生效日期
	 * @author wangxue
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date contractValidDate;

	/**
	 *  @Fields 行驶证登记日期
	 *  @author wangxue
	 */
	private Date vehicleDrivingLicenseRegisterDate;

	/**
	 * @Fields  : 还款状态（结清状态）
	 * @author wangxue
	 */
	private String paymentSts;

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
	private String belongGroup;

	/**
	 * @Fields  : 承租人
	 * @author wangxue
	 */
	private String cstmName;

	/**
	 * @Fields  : 地区
	 * @author wangxue
	 */
	private String groupDistrict;

	/**
	 *  @Fields 已还金额
	 *  @author wangxue
	 */
	private BigDecimal paidAmount;

	/******************************    车辆保险信息    *****************/
	/**
	 *  @Fields 保险状态
	 *  @author wangxue
	 */
	private String insuranceStatus;

	/**
	 *  @Fields 保险失效日
	 *  @author wangxue
	 */
	private Date validEndDay;

	/******************************    车辆资方抵押信息    *****************/
	/**
	 * @Fields  : 抵押状态
	 * @author wangxue
	 */
	private String mortgageStatus;

	/**
	 * @Fields  : 资方
	 * @author wangxue
	 */
	private String management;

	/******************************    车辆登记证文件信息    *****************/
	/**
	 * @Fields  : 文件类型集合
	 * @author wangxue
	 */
	private List<String> fileTypes;

	/**
	 * @Fields  : 登记证文件状态
	 * @author wangxue
	 */
	private String origFileDetailStatus;


	/**
	 * @Fields  : 邮寄日期
	 * @author wangxue
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date postDate;

	/**
	 * @Fields  : 资料归档业务类型
	 * @author wangxue
	 */
	private String bizCodeType;

	/**
	 * @Fields  : 归档附件大类
	 * @author wangxue
	 */
	private String origFileType;

	/**
	 * @Fields  : 归档编号
	 * @author wangxue
	 */
	private String fileRecordNo;

	/**
	 * @Fields  : 归档状态
	 * @author wangxue
	 */
	private String origFileStatus;

	/**
	 * @Fields  : 归档任务状态
	 * @author wangxue
	 */
	private String origFileTaskStatus;

	/******************************    收款银行信息    *****************/
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
	 * @Fields  : 收款联行号
	 */
	private String recEleBankNo;

	/**
	 * @Fields  : 付款银行
	 */
	private String payAccBank;

	/**
	 * @Fields  : 付款银行分行
	 * @author lijunjun
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
	 * @Fields  : 抵押状态(取消)
	 * @author qiaomengnan
	 */
	@JsonIgnore
	private String cancelMortgageStatus = MortgageStatusEnums.CANCEL.getStatus();

	/**
	 * @Fields  : 抵押状态(无效)
	 * @author qiaomengnan
	 */
	@JsonIgnore
	private String invalidMortgageStatus = MortgageStatusEnums.INVALID.getStatus();

}