package cn.com.leadu.fms.pojo.finance.vo.financialvoucherdata;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherData;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucherassis.FinancialVoucherAssisVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherDataVo
 * @Description: 财务凭证数据载体
 * @date 2018-06-25
 */
@ExcelTitle("财务凭证数据")
@Data
public class FinancialVoucherDataVo extends PageQuery<FinancialVoucherData> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 财务凭证id
	 * @author qiaomengnan
	 */
	private String voucherDataId;

	/**
	 * @Fields  : 业务号
	 * @author qiaomengnan
	 */
	private String voucherBizCode;

	/**
	 * @Fields  : 业务日期
	 * @author qiaomengnan
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date voucherBizDate;

	/**
	 * @Fields  : 凭证类型
	 * @author qiaomengnan
	 */
	private String voucherType;

	/**
	 * @Fields  : 凭证类型名称
	 * @author qiaomengnan
	 */
	private String voucherTypeName;

	/**
	 * @Fields  : 凭证号
	 * @author qiaomengnan
	 */
	private String voucherNo;

	/**
	 * @Fields  : 分录号
	 * @author qiaomengnan
	 */
	private Integer voucherDetailNo;

	/**
	 * @Fields  : 核算账簿
	 * @author qiaomengnan
	 */
	private String voucherAccountNo;

	/**
	 * @Fields  : 附单据数
	 * @author qiaomengnan
	 */
	private Integer attachCount;

	/**
	 * @Fields  : 摘要格式
	 * @author qiaomengnan
	 */
	private String summary;

	/**
	 * @Fields  : 科目代码
	 * @author qiaomengnan
	 */
	private String subjectCd;

	/**
	 * @Fields  : 科目名称
	 * @author qiaomengnan
	 */
	private String subjectName;

	/**
	 * @Fields  : 贷方金额
	 * @author qiaomengnan
	 */
	private BigDecimal creditAmount;

	/**
	 * @Fields  : 借贷方向
	 * @author qiaomengnan
	 */
	private String crdrFlag;

	/**
	 * @Fields  : 借方金额
	 * @author qiaomengnan
	 */
	private BigDecimal debitAmount;

	/**
	 * @Fields  : 财务凭证id
	 * @author qiaomengnan
	 */
	private List<String> voucherDataIds;

	/**
	 * @Fields  : 凭证核算项目(公司：xx/客户：xx)
	 * @author yanfengbo
	 */
	private String assisStr;

	/** 
	 * @Fields  : 财务凭证核算数据
	 * @author qiaomengnan
	 */ 
	private List<FinancialVoucherAssisVo> finVouAssisVos;

	@ExcelTitle(value = "凭证号" , sort = 1)
	public String getVoucherNo() {
		return voucherNo;
	}

	@ExcelTitle(value = "业务号" , sort = 2)
	public String getVoucherBizCode() {
		return voucherBizCode;
	}

	@ExcelTitle(value = "业务日期" , sort = 3)
	public String getVoucherBizDateStr() {
		return DateUtils.dateToStr(voucherBizDate,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "凭证类型" , sort = 4)
	public String getVoucherTypeName() {
		return voucherTypeName;
	}

	@ExcelTitle(value = "科目名称" , sort = 5)
	public String getSubjectName() {
		return subjectName;
	}

	@ExcelTitle(value = "分录号" , sort = 6)
	public Integer getVoucherDetailNo() {
		return voucherDetailNo;
	}

	@ExcelTitle(value = "核算账簿" , sort = 7)
	public String getVoucherAccountNo() {
		return voucherAccountNo;
	}

	@ExcelTitle(value = "附单据数" , sort = 8)
	public Integer getAttachCount() {
		return attachCount;
	}

	@ExcelTitle(value = "摘要格式" , sort = 9)
	public String getSummary() {
		return summary;
	}

	@ExcelTitle(value = "借贷方向" , sort = 10)
	public String getCrdrFlag() {
		return crdrFlag;
	}

	@ExcelTitle(value = "借方金额" , sort = 11)
	public BigDecimal getDebitAmount() {
		return debitAmount;
	}

	@ExcelTitle(value = "贷方金额" , sort = 12)
	public BigDecimal getCreditAmount() {
		return creditAmount;
	}


}