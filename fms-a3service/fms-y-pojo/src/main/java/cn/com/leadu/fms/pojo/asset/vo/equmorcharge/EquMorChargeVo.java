package cn.com.leadu.fms.pojo.asset.vo.equmorcharge;

import cn.com.leadu.fms.common.annotation.ExcelImportTitle;
import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.asset.entity.EquMorCharge;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author qiaomengnan
 * @ClassName: EquMorChargeVo
 * @Description: 资方抵押费用载体
 * @date 2018-05-30
 */
@Data
public class EquMorChargeVo extends PageQuery<EquMorCharge> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 资方抵押费用id
	 * @author qiaomengnan
	 */
	private String equMorChargeId;

	/**
	 * @Fields  : 资方抵押任务号
	 * @author qiaomengnan
	 */
	private String equMorTaskNo;

	/**
	 * @Fields  : 客户合同编号
	 * @author qiaomengnan
	 */
	private String clientContNo;

	/**
	 * @Fields  : 资方名称
	 * @author qiaomengnan
	 */
	@ExcelImportTitle("资方名称")
	private String managementName;

	/**
	 * @Fields  : 抵押合同号
	 * @author qiaomengnan
	 */
	@ExcelImportTitle("抵押合同号")
	private String equContNo;

	/**
	 * @Fields  : 车架号
	 * @author qiaomengnan
	 */
	@ExcelImportTitle("车架号")
	private String vinNo;


	/**
	 * @Fields  : 抵押起租日期
	 * @author qiaomengnan
	 */
	@ExcelImportTitle(value = "起租日" , dateFormats = {DateUtils.formatStr_yyyyMMdd , DateUtils.formatStr_yyyyMMdd_bias})
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date equStartDate;

	/**
	 * @Fields  : 抵押止租日期
	 * @author qiaomengnan
	 */
	@ExcelImportTitle(value = "到期日" , dateFormats = {DateUtils.formatStr_yyyyMMdd , DateUtils.formatStr_yyyyMMdd_bias})
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date equEndDate;


	/**
	 * @Fields  : 抵押合同金额
	 * @author qiaomengnan
	 */
	@ExcelImportTitle("抵押合同金额")
	private BigDecimal equFinAmount;

	/**
	 * @Fields  : 保证金
	 * @author qiaomengnan
	 */
	@ExcelImportTitle("保证金")
	private BigDecimal margin;

	/**
	 * @Fields  : 手续费
	 * @author qiaomengnan
	 */
	@ExcelImportTitle("手续费")
	private BigDecimal factorge;

	/**
	 * @Fields  : 管理费
	 * @author qiaomengnan
	 */
	@ExcelImportTitle("管理费")
	private BigDecimal managementCharge;

	/**
	 * @Fields  : 服务费
	 * @author qiaomengnan
	 */
	@ExcelImportTitle("服务费")
	private BigDecimal serviceCharge;

	/**
	 * @Fields  : 一次性利息
	 * @author qiaomengnan
	 */
	@ExcelImportTitle("一次性利息")
	private BigDecimal oneTimeInterest;

	/**
	 * @Fields  : 留购价
	 * @author qiaomengnan
	 */
	@ExcelImportTitle("留购价")
	private BigDecimal retentionPrice;

	/**
	 * @Fields  : 应付合计
	 * @author qiaomengnan
	 */
	@ExcelImportTitle("应付合计")
	private BigDecimal totalShouldPay;

	/**
	 * @Fields  : 财务应收合计
	 * @author qiaomengnan
	 */
	@ExcelImportTitle("财务应收合计")
	private BigDecimal finShouldReceive;

	/**
	 * @Fields  : 明细区分
	 * @author qiaomengnan
	 */
	private String contDetailFlag;

	/**
	 * @Fields  : 资方抵押费用id
	 * @author qiaomengnan
	 */
	private List<String> equMorChargeIds;

	@ExcelTitle(value = "资方名称" , sort = 1)
	public String getManagementName(){
		return managementName;
	}

	@ExcelTitle(value = "抵押合同号" , sort = 2)
	public String getEquContNo(){
		return equContNo;
	}

	@ExcelTitle(value = "车架号" , sort = 3)
	public String getVinNo(){
		return vinNo;
	}

	@ExcelTitle(value = "起租日", sort = 4)
	public String getEquStartDateStr(){ return DateUtils.dateToStr(equStartDate,DateUtils.formatStr_yyyyMMdd);}

	@ExcelTitle(value = "到期日", sort = 5)
	public String getEquEndDateStr(){ return DateUtils.dateToStr(equEndDate,DateUtils.formatStr_yyyyMMdd);}

	@ExcelTitle(value = "抵押合同金额" , sort = 6)
	public BigDecimal getEquFinAmount(){
		return equFinAmount;
	}

	@ExcelTitle(value = "保证金" , sort = 7)
	public BigDecimal getMargin(){
		return margin;
	}

	@ExcelTitle(value = "手续费" , sort = 8)
	public BigDecimal getFactorge(){
		return factorge;
	}

	@ExcelTitle(value = "管理费" , sort = 9)
	public BigDecimal getManagementCharge(){
		return managementCharge;
	}

	@ExcelTitle(value = "服务费" , sort = 10)
	public BigDecimal getServiceCharge(){
		return serviceCharge;
	}

	@ExcelTitle(value = "一次性利息" , sort = 11)
	public BigDecimal getOneTimeInterest(){
		return oneTimeInterest;
	}

	@ExcelTitle(value = "留购价" , sort = 12)
	public BigDecimal getRetentionPrice(){
		return retentionPrice;
	}

	@ExcelTitle(value = "应付合计" , sort = 13)
	public BigDecimal getTotalShouldPay(){
		return totalShouldPay;
	}

	@ExcelTitle(value = "财务应收合计" , sort = 14)
	public BigDecimal getFinShouldReceive(){
		return finShouldReceive;
	}

}