package cn.com.leadu.fms.asset.validator.equmorapply;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.FileVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.asset.entity.EquMorDetail;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorDetailArchiveVo
 * @Description: 资方抵押明细载体
 * @date 2018-05-30
 */
@Data
public class EquMorSeaWingDetailVo extends PageQuery<EquMorDetail> {

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
	@NotNull(message = "请选择计划首期租金支付日")
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date planFirstPayDate;

	/**
	 * @Fields  : 计划提车时间
	 * @author qiaomengnan
	 */
	@NotNull(message = "请选择计划提车时间")
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date planPickCarDate;

	/**
	 * @Fields  : 业务推荐单位
	 * @author qiaomengnan
	 */
	@NotBlank(message = "请输入业务推荐单位")
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
	@NotNull(message = "请输入合同金额")
	private BigDecimal contAmount;

	/**
	 * @Fields  : 租赁期限
	 * @author qiaomengnan
	 */
	@NotBlank(message = "请选择租赁期限")
	private String leasePeriod;

	/**
	 * @Fields  : 计划还款期次
	 * @author qiaomengnan
	 */
	@NotNull(message = "请输入计划还款期次")
	private Integer planRepaymentPeriod;

	/**
	 * @Fields  : 验证判断使用
	 * @author qiaomengnan
	 */
	@AssertTrue(message = "计划还款期次不能小于等于0")
	public boolean getComparisonPlanRepaymentPeriod(){
		return planRepaymentPeriod > 0;
	}

	/**
	 * @Fields  : 合同保证金比例
	 * @author qiaomengnan
	 */
	@NotNull(message = "请输入合同保证金比例")
	private BigDecimal contractMarginRatio;

	/**
	 * @Fields  : 合同保证金
	 * @author qiaomengnan
	 */
	@NotNull(message = "请确认合同保证金")
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
	@NotNull(message = "请输入尾款比例")
	private BigDecimal balanceRatio;

	/**
	 * @Fields  : 尾款金额
	 * @author qiaomengnan
	 */
	@NotNull(message = "请确认尾款金额")
	private BigDecimal balanceAmount;

	/**
	 * @Fields  : 尾款年利率
	 * @author qiaomengnan
	 */
	@NotNull(message = "请输入尾款年利率")
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
	@NotNull(message = "请确认每期租金")
	private BigDecimal rent;

	/**
	 * @Fields  : 起租日
	 * @author qiaomengnan
	 */
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
	 * @Fields  : 附件
	 */
	private CommonBizFilesVo bizfilesVo;

	/**
	 * @Fields  : 明细集合
	 * @author ningyangyang
	 */
	private List<EquMorSeaWingDetailVo> equMorDetailVoList;

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

}