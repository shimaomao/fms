package cn.com.leadu.fms.pojo.product.vo.product;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.product.entity.Product;
import cn.com.leadu.fms.pojo.product.vo.finitem.FinItemVo;
import cn.com.leadu.fms.pojo.product.vo.prodfile.ProdFileVo;
import cn.com.leadu.fms.pojo.product.vo.prodfinitem.ProdFinItemVo;
import cn.com.leadu.fms.pojo.product.vo.prodgroup.ProdGroupVo;
import cn.com.leadu.fms.pojo.product.vo.prodintrst.ProdIntrstVo;
import cn.com.leadu.fms.pojo.product.vo.prodvehicle.ProdVehicleVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: testVo
 * @Description: 产品方案管理载体
 * @date 2018-03-23
 */
@ExcelTitle(value = "产品一览信息")
@Data
public class ProductVo extends PageQuery<Product> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 产品方案ID
	 */
	private String productId;

	/**
	 * @Fields  : 产品方案代码
	 */
	private String product;

	/**
	 * @Fields  : 产品大类代码
	 */
	private String productCatg;

	/**
	 * @Fields  : 产品大类名称
	 */
	private String productCatgName;

	/**
	 * @Fields  : 产品方案名称
	 */
	private String productName;

	/**
	 * @Fields  : 产品方案描述
	 */
	private String productMemo;

	/**
	 * @Fields  : 开始日期
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date startDate;

	/**
	 * @Fields  : 结束日期
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date endDate;

	/**
	 * @Fields  : 车辆类型
	 */
	private String vehicleForm;

	/**
	 * @Fields  : 申请类型
	 */
	private String applyType;

	/**
	 * @Fields  : 车辆种类
	 */
	private String vehicleType;

	/**
	 * @Fields  : 牌照属性
	 */
	private String licenseAttr;

	/**
	 * @Fields  : 租金支付模式
	 */
	private String rentPayMode;

	/**
	 * @Fields  : GPS安装情况
	 */
	private String gpsInstMode;

	/**
	 * @Fields  : 还款方式
	 */
	private String repayMode;

	/**
	 * @Fields  : 还款频率
	 */
	private String repayRate;

	/**
	 * @Fields  : 保证金返还方式
	 */
	private String depositRtnMode;

	/**
	 * @Fields  : 融资期限
	 */
	private String finPeriodType;

	/**
	 * @Fields  : 手续费收取方式
	 */
	private String chargePayMode;

	/**
	 * @Fields  : 首付比例开始
	 */
	private BigDecimal initPercFrom;

	/**
	 * @Fields  : 首付比例结束
	 */
	private BigDecimal initPercTo;

	/**
	 * @Fields  : 首付金额开始
	 */
	private BigDecimal initAmountFrom;

	/**
	 * @Fields  : 首付金额结束
	 */
	private BigDecimal initAmountTo;

	/**
	 * @Fields  : 尾付比例开始
	 */
	private BigDecimal finalPercFrom;

	/**
	 * @Fields  : 尾付比例结束
	 */
	private BigDecimal finalPercTo;

	/**
	 * @Fields  : 尾付金额开始
	 */
	private BigDecimal finalAmountFrom;

	/**
	 * @Fields  : 尾付金额结束
	 */
	private BigDecimal finalAmountTo;

	/**
	 * @Fields  : 保证金开始
	 */
	private BigDecimal depositFrom;

	/**
	 * @Fields  : 保证金结束
	 */
	private BigDecimal depositTo;

	/**
	 * @Fields  : 保证金率开始
	 */
	private BigDecimal depositPercFrom;

	/**
	 * @Fields  : 保证金率结束
	 */
	private BigDecimal depositPercTo;

	/**
	 * @Fields  : 融资总额开始
	 */
	private BigDecimal finTotalFrom;

	/**
	 * @Fields  : 融资总额结束
	 */
	private BigDecimal finTotalTo;

	/**
	 * @Fields  : 风险融资额开始
	 */
	private BigDecimal finRiskFrom;

	/**
	 * @Fields  : 风险融资额结束
	 */
	private BigDecimal finRiskTo;

	/**
	 * @Fields  : 贴息是否差额付款
	 */
	private String subsidyPayMode;

	/**
	 * @Fields  : 扩展属性1
	 */
	private String prodAttr1;

	/**
	 * @Fields  : 扩展属性2
	 */
	private String prodAttr2;

	/**
	 * @Fields  : 扩展属性3
	 */
	private String prodAttr3;
	/**
	 * @Fields  : 年供比例
	 */
	private BigDecimal annualSupplyRateFrom;
	/**
	 * @Fields  : 年供比例
	 */
	private BigDecimal annualSupplyRateTo;

	/**
	 * @Fields  : 年供金额
	 */
	private BigDecimal annualSupplyAmountFrom;

	/**
	 * @Fields  : 年供金额
	 */
	private BigDecimal annualSupplyAmountTo;


	/**
	 * @Fields  : irr
	 */
	private BigDecimal irrFrom;


	/**
	 * @Fields  : irr
	 */
	private BigDecimal irrTo;
	/**
	 * @Fields  : 经销商代码(用户组代码)
	 */
	private String groupCode;

	/**
	 * @Fields  : 产品的融资项目
	 */
	private List<ProdFinItemVo> prodFinItemVoList;
	/**
	 * @Fields  : 产品的融资项目
	 */
	private List<String> prodFinItems;

	/**
	 * @Fields  : 产品的首尾付融资项目
	 */
	private List<String> prodFinItemsIF;

	/**
	 * @Fields  : 产品的尾付融资项目
	 */
	private List<String> prodFinItemsFinal;

	/**
	 * @Fields  : 产品的保证金融资项目
	 */
	private List<String> prodFinItemsDep;
	/**
	 * @Fields  : 产品的利率方案
	 */
	private List<ProdIntrstVo> prodIntrstVoList;

	/**
	 * @Fields  : 产品的车型权限
	 */
	private List<ProdVehicleVo> prodVehicleVopList;

	/**
	 * @Fields  : 产品的机构权限
	 */
	private List<ProdGroupVo> prodGroupVoList;

	/**
	 * @Fields  : 产品的附件
	 */
	private List<ProdFileVo> prodFileVoList;

	/**
	 * @Fields  : 产品的融资项目
	 * 申请录入专用
	 */
	private List<FinItemVo> finItemVoList;

	/**
	 * @Fields  : 产品的有权限的车型代码（包括制造商、品牌、车系、车型）
	 * 申请录入专用
	 */
	private List<String> vehicleCodeList;

	/**
	 * @Fields  : 产品的有权限的组织机构
	 * 申请录入专用
	 */
	private List<String> groupCodeList;

	/**
	 * @Fields  : 产品方案ID
	 */
	private List<String> productIds;

	/**
	 * @Fields  : 产品方案代码
	 */
	private List<String> products;

	@ExcelTitle(value = "产品方案代码",sort = 1, types = {ExcelTypeConstants.ONE})
	public String getProduct() {
		return product;
	}

	@ExcelTitle(value = "产品大类代码",sort = 2)
	public String getProductCatg() {
		return productCatg;
	}

	@ExcelTitle(value = "产品方案名称",sort = 3)
	public String getProductName() {
		return productName;
	}

	@ExcelTitle(value = "产品方案描述",sort = 4)
	public String getProductMemo() {
		return productMemo;
	}

	@ExcelTitle(value = "开始日期",sort = 5)
	public String getStartDateStr() {
		return DateUtils.dateToStr(startDate,DateUtils.formatStr_yyyyMMdd);
	}

	@ExcelTitle(value = "结束日期",sort = 6)
	public String getEndDateStr() {
		return DateUtils.dateToStr(endDate,DateUtils.formatStr_yyyyMMdd);
	}

	@ExcelTitle(value = "车辆类型",sort = 7, codeType = CommonCodeTypeConstants.PROD_VEHICLE_FORM, joinDelimiter = StringUtils.COMMA)
	public String getVehicleForm() {
		return vehicleForm;
	}

	@ExcelTitle(value = "申请类型",sort = 8, codeType = CommonCodeTypeConstants.PROD_APPLY_TYPE, joinDelimiter = StringUtils.COMMA)
	public String getApplyType() {
		return applyType;
	}

	@ExcelTitle(value = "车辆种类",sort = 9, codeType = CommonCodeTypeConstants.PROD_VEHICLE_TYPE, joinDelimiter = StringUtils.COMMA)
	public String getVehicleType() {
		return vehicleType;
	}

	@ExcelTitle(value = "牌照属性",sort = 10, codeType = CommonCodeTypeConstants.PROD_LICENSE_ATTR, joinDelimiter = StringUtils.COMMA)
	public String getLicenseAttr() {
		return licenseAttr;
	}

	@ExcelTitle(value = "租金支付模式",sort = 11, codeType = CommonCodeTypeConstants.PROD_RENTPAY_MODE)
	public String getRentPayMode() {
		return rentPayMode;
	}

	@ExcelTitle(value = "GPS安装情况",sort = 12, codeType = CommonCodeTypeConstants.PROD_GPSINST_MODE)
	public String getGpsInstMode() {
		return gpsInstMode;
	}

	@ExcelTitle(value = "还款方式",sort = 13, codeType = CommonCodeTypeConstants.PROD_REPAY_MODE)
	public String getRepayMode() {
		return repayMode;
	}

	@ExcelTitle(value = "还款频率",sort = 14, codeType = CommonCodeTypeConstants.PROD_REPAY_RATE)
	public String getRepayRate() {
		return repayRate;
	}

	@ExcelTitle(value = "保证金返还方式",sort = 15, codeType = CommonCodeTypeConstants.PROD_DEPOSITRTN_MODE)
	public String getDepositRtnMode() {
		return depositRtnMode;
	}

	@ExcelTitle(value = "融资期限",sort = 16, codeType = CommonCodeTypeConstants.PROD_FIN_PERIOD_TYPE, joinDelimiter = StringUtils.COMMA)
	public String getFinPeriodType() {
		return finPeriodType;
	}

	@ExcelTitle(value = "手续费收取方式",sort = 17, codeType = CommonCodeTypeConstants.PROD_CHARGE_PAY_MODE, joinDelimiter = StringUtils.COMMA)
	public String getChargePayMode() {
		return chargePayMode;
	}

	@ExcelTitle(value = "更新时间", sort = 18)
	public String getUpdateTimeStr(){
		return DateUtils.dateToStr(updateTime,DateUtils.formatStr_yyyyMMddHHmmss);
	}

	@ExcelTitle(value = "更新人员", sort = 19)
	public String getUpdater(){
		return updater;
	}
}