package cn.com.leadu.fms.pojo.finance.vo.finbackfill;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.entity.FinBackfill;
import cn.com.leadu.fms.pojo.finance.vo.finbackfilldetail.FinBackfillDetailVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: FinBackfillVo
 * @Description: 融资回填载体
 * @date 2018-05-11
 */
@ExcelTitle(value = "财务回填信息")
@Data
public class FinBackfillVo extends PageQuery<FinBackfill> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 融资回填ID
	 * @author lijunjun
	 */
	private String filBackfillId;

	/**
	 * @Fields  : 合同编号
	 * @author lijunjun
	 */
	private String contNo;

	/**
	 * @Fields  : 申请编号
	 * @author lijunjun
	 */
	private String applyNo;

	/**
	 * @Fields  : 融资期限
	 * @author lijunjun
	 */
	private String finPeriodType;

	/**
	 * @Fields  : 申请姓名
	 * @author lijunjun
	 */
	private String name;

	/**
	 * @Fields  : 回填状态
	 * @author lijunjun
	 */
	private String filBackfillSts;

	/**
	 * @Fields  : 产品方案
	 * @author lijunjun
	 */
	private String productName;

	/**
	 * @Fields  : 财务实际投资额（销售投资总额）
	 * @author lijunjun
	 */
	private BigDecimal investTotal;

	/**
	 * @Fields  : 财务实际融资额（销售融资金额）
	 * @author lijunjun
	 */
	private BigDecimal finTotal;

	/**
	 * @Fields  : 首付比例
	 * @author lijunjun
	 */
	private BigDecimal initPerc;

	/**
	 * @Fields  : 财务首付金额（销售首付金额）
	 * @author lijunjun
	 */
	private BigDecimal initAmount;

	/**
	 * @Fields  : 每期租金
	 * @author lijunjun
	 */
	private BigDecimal rent;

	/**
	 * @Fields  : 每期租金()还款计划表
	 * @author lijunjun
	 */
	private List<BigDecimal> perRentList;

	/**
	 * @Fields  : 牌照属性
	 * @author lijunjun
	 */
	private String licenseAttr;

	/**
	 * @Fields  : 合同打款日期
	 * @author lijunjun
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date contractValidDate;

	/**
	 * @Fields  : 财务尾付金额（销售尾付金额）
	 * @author lijunjun
	 */
	private BigDecimal finalAmount;

	/**
	 * @Fields  : 财务实际收益年利率
	 * @author lijunjun
	 */
	private BigDecimal intrstRateYear;

	/**
	 * @Fields  : 进项税金
	 * @author lijunjun
	 */
	private BigDecimal inputTax;

	/**
	 * @Fields  : 销项税金
	 * @author lijunjun
	 */
	private BigDecimal outputTax;

	/**
	 * @Fields  : 融资回填ID
	 * @author lijunjun
	 */
	private List<String> filBackfillIds;

	/**
	 * @Fields  : 销售实际投资额
	 * @author lijunjun
	 */
	private BigDecimal cstmInvestTotal;

	/**
	 * @Fields  : 销售实际融资额
	 * @author lijunjun
	 */
	private BigDecimal cstmFinTotal;

	/**
	 * @Fields  : 销售首付金额
	 * @author lijunjun
	 */
	private BigDecimal cstmInitAmount;

	/**
	 * @Fields  : 销售尾付金额
	 * @author lijunjun
	 */
	private BigDecimal cstmFinalAmount;

	/**
	 * @Fields  : 融资回填明细信息List
	 * @author lijunjun
	 */
	private List<FinBackfillDetailVo> finBackfillDetailVoList;

	/**
	 * @Fields  : 出租人
	 * @author ningyangyang
	 */
	private String groupName;

	/**
	 * @Fields  : 车架号
	 * @author ningyangyang
	 */
	private String vinNo;

	/**
	 * @Fields  : 业务类型(用于导出excel)
	 * @author yanfengbo
	 */
	private String paymentType;

	/**
	 * @Fields  : 申请类型个人(用于导出excel)
	 * @author yanfengbo
	 */
	private String person;

	/**
	 * @Fields  : 0:回填/1:暂存判定flag
	 * @author ningyangyang
	 */
	private String flag;

	/**
	 * @Fields  : 租赁期限开始日
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date leaseTermStartDate;

	/**
	 * @Fields  : 租赁期限结束日
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date leaseTermEndDate;

	@ExcelTitle(value = "合同编号", sort = 1 ,types = {ExcelTypeConstants.ONE})
	public String getContNo(){return contNo;}

	@ExcelTitle(value = "申请姓名", sort = 2)
	public String getName(){return name;}

	@ExcelTitle(value = "回填状态", sort = 3, codeType = CommonCodeTypeConstants.FIL_BACKFILL_STS)
	public String getFilBackfillSts(){return filBackfillSts;}

	@ExcelTitle(value = "产品方案", sort = 4)
	public String getProductName(){return productName;}

	@ExcelTitle(value = "融资额", sort = 5)
	public BigDecimal getFinTotal(){return finTotal;}

	@ExcelTitle(value = "首付比例", sort = 6)
	public BigDecimal getInitPerc(){return initPerc;}

	@ExcelTitle(value = "首付金额", sort = 7)
	public BigDecimal getInitAmount(){return initAmount;}

	@ExcelTitle(value = "牌照属性", sort = 8)
	public String getLicenseAttr(){return licenseAttr;}

	@ExcelTitle(value = "合同打款日期", sort = 9)
	public String getContractValidDateStr(){return DateUtils.dateToStr(contractValidDate, DateUtils.formatStr_yyyyMMdd);}
}