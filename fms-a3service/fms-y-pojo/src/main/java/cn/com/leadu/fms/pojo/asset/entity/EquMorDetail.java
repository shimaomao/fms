package cn.com.leadu.fms.pojo.asset.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import cn.com.leadu.fms.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author qiaomengnan
 * @ClassName: EquMorDetail
 * @Description: 资方抵押明细实体
 * @date 2018-05-30
 */
@Data
public class EquMorDetail extends BaseEntity<EquMorDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 资方抵押明细id
	 * @author qiaomengnan
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
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

}