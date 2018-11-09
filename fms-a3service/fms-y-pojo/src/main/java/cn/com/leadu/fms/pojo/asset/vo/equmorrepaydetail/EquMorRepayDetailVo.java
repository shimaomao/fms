package cn.com.leadu.fms.pojo.asset.vo.equmorrepaydetail;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.BigDecimalUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.asset.entity.EquMorRepayDetail;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author qinmuqiao
 * @ClassName: EquMorRepayDetailVo
 * @Description: 资方抵押还款计划载体
 */
@ExcelTitle(value = "资方抵押还款计划")

@Data
public class EquMorRepayDetailVo extends PageQuery<EquMorRepayDetail> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 资方抵押还款计划表明细id
	 * @author qinmuqiao
	 */
	private String equMorRepayDetailId;

	/**
	 * @Fields  : 资方抵押任务号
	 * @author qinmuqiao
	 */
	private String equMorTaskNo;

	/**
	 * @Fields  : 客户合同编号
	 * @author qinmuqiao
	 */
	private String clientContNo;

	/**
	 * @Fields  : 车架号
	 * @author qinmuqiao
	 */
	private String vinNo;

	/**
	 * @Fields  : 期数
	 * @author qinmuqiao
	 */
	private Integer period;

	/**
	 * @Fields  : 应还日期
	 * @author qinmuqiao
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date repayDate;

	/**
	 * @Fields  : 起始应还日期
	 * @author qinmuqiao
	 */
	private String repaySatrtStr;

	/**
	 * @Fields  : 起始应还日期
	 * @author qinmuqiao
	 */
	private String repayEndStr;

	/**
	 * @Fields  : 租金
	 * @author qinmuqiao
	 */
	private BigDecimal rent;

	/**
	 * @Fields  : 还款状态
	 * @author qinmuqiao
	 */
	private String equRepayStatus;

	/**
	 * @Fields  : 还款日期
	 * @author qinmuqiao
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date payUpdateDate;

	/**
	 * @Fields  : 资方名称
	 * @author qinmuqiao
	 */
	private String management;

	/**
	 * @Fields  : 抵押起租日期
	 * @author qiaomengnan
	 */
	private Date equStartDate;

	/**
	 * @Fields  : 抵押止租日期
	 * @author qiaomengnan
	 */
	private Date equEndDate;

	/**
	 * @Fields  : 融资期限
	 * @author qiaomengnan
	 */
	private Integer leasePeriod;

	/**
	 * @Fields  : 承租人
	 * @author qinmuqiao
	 */
	private String tenantUser;

	/**
	 * @Fields  : 资方抵押还款计划表明细id
	 * @author qinmuqiao
	 */
	private List<String> equMorRepayDetailIds;


	@ExcelTitle(value = "资方抵押任务号", sort = 1)
	public String getEquMorTaskNo(){return this.equMorTaskNo;}

	@ExcelTitle(value = "客户合同编号", sort = 2)
	public String getClientContNo(){return this.clientContNo;}

	@ExcelTitle(value = "车架号", sort = 3)
	public String getVinNo() {return this.vinNo;}

	@ExcelTitle(value = "承租人", sort = 4)
	public String getTenantUser(){return this.tenantUser;}

	@ExcelTitle(value = "资方名称", sort = 5, codeType = CommonCodeTypeConstants.MANAGEMENT, types = {ExcelTypeConstants.ONE})
	public String getManagement() {return this.management;}

	@ExcelTitle(value = "期数", sort = 6)
	public String getPeriodStr() {return String.valueOf(this.period);}

	@ExcelTitle(value = "应还日期", sort = 7)
	public String getRepayDateStr(){
		return DateUtils.dateToStr(repayDate,DateUtils.formatStr_yyyyMMdd);
	}

	@ExcelTitle(value = "租金", sort = 8)
	public String getRentStr(){
		return BigDecimalUtils.getNotNullBigDecimal(rent).toString();
	}

	@ExcelTitle(value = "还款状态", sort = 9, codeType = CommonCodeTypeConstants.EQUREPAYSTATUS, types = {ExcelTypeConstants.ONE})
	public String getEquRepayStatus(){
		return equRepayStatus;
	}

	@ExcelTitle(value = "还款日期", sort = 10)
	public String getPayUpdateDateStr(){
		return DateUtils.dateToStr(payUpdateDate,DateUtils.formatStr_yyyyMMdd);
	}

}