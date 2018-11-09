package cn.com.leadu.fms.pojo.asset.vo.equmordetail;

import cn.com.leadu.fms.common.annotation.ExcelImportTitle;
import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.FileVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.asset.entity.EquMorDetail;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.BizFilesVo;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorDetailVo
 * @Description: 资方抵押明细载体
 * @date 2018-05-30
 */
@ExcelTitle(value = "资方解押明细")
@Data
public class EquMorDetailVo extends PageQuery<EquMorDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 资方抵押明细id
	 * @author qiaomengnan
	 */
	private String equMorDetailId;

	/**
	 * @Fields  : 资方抵押任务号
	 * @author qiaomengnan
	 */
	private String equMorTaskNo;

	/**
	 * @Fields  : 资方解押任务号
	 * @author qiaomengnan
	 */
	private String equRelTaskNo;

	/**
	 * @Fields  : 抵押状态
	 * @author qiaomengnan
	 */
	private String mortgageStatus;

	/**
	 * @Fields  : 车牌号
	 * @author qiaomengnan
	 */
	private String vehicleLicenseNo;

	/**
	 * @Fields  : 发动机号
	 * @author qiaomengnan
	 */
	private String engineNo;

	/**
	 * @Fields  : 车架号
	 * @author qiaomengnan
	 */
	private String vinNo;

	/**
	 * @Fields  : 客户合同编号
	 * @author qiaomengnan
	 */
	private String clientContNo;

	/**
	 * @Fields  : 抵押地(注册地)
	 * @author qiaomengnan
	 */
	private String mortgageAddr;

	/**
	 * @Fields  : 抵押日期
	 * @author qiaomengnan
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date mortgageDate;

	/**
	 * @Fields  : 抵押权人(出租人)
	 * @author qiaomengnan
	 */
	private String mortgagee;

	/**
	 * @Fields  : 业务类别
	 * @author qiaomengnan
	 */
	private String serviceCategory;

	/**
	 * @Fields  : 计划首期租金支付日
	 * @author qiaomengnan
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date planFirstPayDate;

	/**
	 * @Fields  : 计划提车时间
	 * @author qiaomengnan
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date planPickCarDate;

	/**
	 * @Fields  : 业务推荐单位
	 * @author qiaomengnan
	 */
	private String servRecommComp;

	/**
	 * @Fields  : 备注
	 * @author qiaomengnan
	 */
	private String memo;

	/**
	 * @Fields  : 合同金额
	 * @author qiaomengnan
	 */
	private BigDecimal contAmount;

	/**
	 * @Fields  : 租赁期限
	 * @author qiaomengnan
	 */
	private String leasePeriod;

	/**
	 * @Fields  : 计划还款期次
	 * @author qiaomengnan
	 */
	private Integer planRepaymentPeriod;

	/**
	 * @Fields  : 合同保证金比例
	 * @author qiaomengnan
	 */
	private BigDecimal contractMarginRatio;

	/**
	 * @Fields  : 合同保证金
	 * @author qiaomengnan
	 */
	private BigDecimal contMargin;

	/**
	 * @Fields  : 常规方案费率
	 * @author qiaomengnan
	 */
	private BigDecimal regularProgramRate;

	/**
	 * @Fields  : 尾款比例
	 * @author qiaomengnan
	 */
	private BigDecimal balanceRatio;

	/**
	 * @Fields  : 尾款金额
	 * @author qiaomengnan
	 */
	private BigDecimal balanceAmount;

	/**
	 * @Fields  : 尾款年利率
	 * @author qiaomengnan
	 */
	private BigDecimal balanceAnnualRate;

	/**
	 * @Fields  : 合同利息总额
	 * @author qiaomengnan
	 */
	private BigDecimal totalContInterest;

	/**
	 * @Fields  : 每期租金
	 * @author qiaomengnan
	 */
	private BigDecimal rent;

	/**
	 * @Fields  : 起租日
	 * @author qiaomengnan
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date rentalDate;

	/**
	 * @Fields  : 主合同编号
	 * @author qiaomengnan
	 */
	private String mainContNo;

	/**
	 * @Fields  : 抵押合同编号
	 * @author qiaomengnan
	 */
	private String mortgageContNo;

	/**
	 * @Fields  : 保证金
	 * @author qiaomengnan
	 */
	private BigDecimal margin;

	/**
	 * @Fields  : 服务费
	 * @author qiaomengnan
	 */
	private BigDecimal serviceCharge;

	/**
	 * @Fields  : 还款日
	 * @author qiaomengnan
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date repayDate;

	/**
	 * @Fields  : 管理费
	 * @author qiaomengnan
	 */
	private BigDecimal managementCharge;

	/**
	 * @Fields  : 留购价
	 * @author qiaomengnan
	 */
	private BigDecimal retentionPrice;

	/**
	 * @Fields  : 解押应收金额
	 * @author qiaomengnan
	 */
	private BigDecimal reliefReceivAmount;

	/**
	 * @Fields  : 解押违约金
	 * @author qiaomengnan
	 */
	private BigDecimal reliefPenalty;

	/**
	 * @Fields  : 解押剩余本金
	 * @author qiaomengnan
	 */
	private BigDecimal reliefRestPrincipal;

	/**
	 * @Fields  : 解押其他费用
	 * @author qiaomengnan
	 */
	private BigDecimal reliefOtherCharge;

	/**
	 * @Fields  : 解押差额
	 * @author qiaomengnan
	 */
	private BigDecimal reliefDifference;

	/**
	 * @Fields  : 资方抵押明细id
	 * @author qiaomengnan
	 */
	private List<String> equMorDetailIds;

	/**
	 * @Fields  : 出租人
	 * @author ningyangyang
	 */
     private String lessor;

	/**
	 * @Fields  : 承租人
	 * @author ningyangyang
	 */
	private String lessee;

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
	 * @Fields  : 经销商
	 * @author ningyangyang
	 */
	private String salesName;

	/**
	 * @Fields  : 申请类型 个人
	 * @author ningyangyang
	 */
	private String applyTypePer;

	/**
	 * @Fields  : 差额合计
	 * @author ningyangyang
	 */
	private BigDecimal differenceCount;

	/**
	 * @Fields  : 收款银行
	 * @author ningyangyang
	 */
	private String openingBank;

	/**
	 * @Fields  : 收款银行分行
	 * @author ningyangyang
	 */
	private String recAccBranch;

	/**
	 * @Fields  : 收款账号
	 * @author ningyangyang
	 */
	private String accountNo;

	/**
	 * @Fields  : 收款户名
	 * @author ningyangyang
	 */
	private String accountName;

	/**
	 * @Fields  : 收款联行号
	 * @author ningyangyang
	 */
	private String bankCode;

	/**
	 * @Fields  :  付款银行
	 */
	private String payAccBank;

	/**
	 * @Fields  : 收款银行分行
	 * @author ningyangyang
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
	 * @Fields  : 备注
	 * @author ningyangyang
	 */
	private String remark1;

	/**
	 * @Fields  : 附件
	 */
	private CommonBizFilesVo commonBizFilesVo;

	/**
	 * @Fields  : 明细集合
	 * @author ningyangyang
	 */
	private List<EquMorDetailVo> equMorDetailVoList;

	/**
	 * @Fields  : taskId
	 * @author ningyangyang
	 */
	private String taskId;

	/**
	 * @Fields  : 实收金额
	 * @author ningyangyang
	 */
	private BigDecimal receiptAmount;

	/**
	 * @Fields  : 还款日
	 * @author qiaomengnan
	 */
	private String repayDay;

	/**
	 * @Fields  : 租金支付模式
	 * @author qiaomengnan
	 */
	private String rentPayMode;

	/**
	 * @Fields  : 附件
	 * @author qiaomengnan
	 */
	private List<FileVo> fileVos;

	/**
	 * @Fields  : 归档编号
	 * @author qiaomengnan
	 */
	private String fileRecordNo;

	/**
	 * @Fields  : 附件集合用于返回详情使用
	 * @author qiaomengnan
	 */
	private List<BizFiles> bizFilesList;

	/**
	 * @Fields  : 资方
	 * @author ningyangyang
	 */
	private String management;

	/**
	 * @Fields  : 合同金额
	 * @author qiaomengnan
	 */
	private BigDecimal equFinAmount;

	/**
	 * @Fields  : 应付合计
	 * @author qiaomengnan
	 */
	private BigDecimal totalShouldPay;

	/**
	 * @Fields  : 财务应收合计
	 * @author qiaomengnan
	 */
	private BigDecimal finShouldReceive;

	private List<BizFilesVo> bizFilesVoList;

	/**
	 * @Fields  : sql判断时间
	 * @author ningyangyang
	 */
	private String jugDay;

	/**
	 * @Fields  : 提前结清状态
	 * @author ningyangyang
	 */
	private String prePaySts;

	/**
	 * @Fields  : 到账日期
	 * @author ningyangyang
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date receiptDate;

	/**
	 * @Fields  : 出租人区域
	 * @author qiaomengnan
	 */
	private String groupDistrict;

	/**
	 * @Fields  : 抵押状态集合
	 * @author yanfengbo
	 */
	private List<String> mortgageStatusList;

	/**
	 * @Fields  : 还款状态
	 * @author yanfengbo
	 */
	private String paymentSts;

	/**
	 * @Fields  : 解押任务状态
	 */
	private String reliefStatus;

	/**
	 * @Fields  : 解押任务当前节点用户
	 */
	private String presentUser;

	/**
	 * @Fields  : 抵押起租日期
	 * @author qiaomengnan
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date equStartDate;

	/**
	 * @Fields  : 抵押止租日期
	 * @author qiaomengnan
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date equEndDate;



	@ExcelTitle(value = "合同编号", sort = 1)
	public String getMainContNo() {
		return mainContNo;
	}
	@ExcelTitle(value = "出租人", sort = 2)
	public String getLessor() {
		return lessor;
	}
	@ExcelTitle(value = "承租人", sort = 3)
	public String getLessee() {
		return lessee;
	}
	@ExcelTitle(value = "车架号", sort = 4)
	public String getVinNo() {
		return vinNo;
	}
	@ExcelTitle(value = "业务类型", sort = 5,codeType = CommonCodeTypeConstants.PROD_LICENSE_ATTR)
	public String getServiceType() {
		return serviceType;
	}
	@ExcelTitle(value = "抵押状态", sort = 6,codeType = CommonCodeTypeConstants.MORTGAGE_STATUS)
	public String getMortgageStatus() {
		return mortgageStatus;
	}
	@ExcelTitle(value = "融资期限", sort = 7)
	public String getFinPeriodType() {
		return finPeriodType;
	}
	@ExcelTitle(value = "经销商", sort = 8)
	public String getSalesName() {
		return salesName;
	}
	@ExcelTitle(value = "资方", sort = 9,codeType = CommonCodeTypeConstants.MANAGEMENT)
	public String getManagement() {
		return management;
	}
	@ExcelTitle(value = "抵押地", sort = 10)
	public String getMortgageAddr() {
		return mortgageAddr;
	}
	@ExcelTitle(value = "抵押地", sort = 11)
	public String  getMortgageDateToString() {
		return DateUtils.dateToStr(mortgageDate,DateUtils.formatStr_yyyyMMdd);
	}
	@ExcelTitle(value = "抵押权人", sort = 12)
	public String getMortgagee() {
		return mortgagee;
	}
	@ExcelTitle(value = "还款日", sort = 13)
	public String getRepayDateToString() {
		return DateUtils.dateToStr(repayDate,DateUtils.formatStr_yyyyMMdd);
	}
	@ExcelTitle(value = "租金", sort = 14)
	public BigDecimal getRent() {
		return rent;
	}
}