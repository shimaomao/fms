package cn.com.leadu.fms.pojo.asset.vo.equmorapply;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.constant.enums.asset.MortgageStatusEnums;
import cn.com.leadu.fms.common.constant.enums.product.FinItemEnums;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.BigDecimalUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.asset.entity.EquMorCharge;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorDetailVo;
import cn.com.leadu.fms.pojo.asset.vo.equmortask.EquMorTaskVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinDetailVo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: EquMorChargeApplyVo
 * @Description: 合同资方抵押申请载体
 * @date 2018-05-30
 */
@ExcelTitle(typeValues = {"资方抵押申请模板", "资方抵押申请一览"}, types = {ExcelTypeConstants.ONE, ExcelTypeConstants.TWO})
@Data
public class EquMorApplyVo extends PageQuery<EquMorCharge> {

	private static final long serialVersionUID = 1L;

	/**
	 * @Fields  : 合同id
	 * @author qiaomengnan
	 */
	private String contractId;

	/**
	 * @Fields  : 品牌
	 * @author qiaomengnan
	 */
	private String vehBrandCode;

	/**
	 * @Fields  : 品牌名称
	 * @author qiaomengnan
	 */
	private String vehBrandCodeName;

	/**
	 * @Fields  : 车型名称
	 * @author qiaomengnan
	 */
	private String vehicleCodeName;

	/**
	 * @Fields  : 业务类型
	 * @author qiaomengnan
	 */
	private String licenseAttr;

	/**
	 * @Fields  : 出租人code
	 * @author qiaomengnan
	 */
	private String belongGroupCode;

	/**
	 * @Fields  : 出租人
	 * @author qiaomengnan
	 */
	private String belongGroupName;

	/**
	 * @Fields  : 承租人
	 * @author qiaomengnan
	 */
	private String lessee;

	/**
	 * @Fields  : 合同编号
	 * @author qiaomengnan
	 */
	private String contNo;

	/**
	 * @Fields  : 车架号
	 * @author qiaomengnan
	 */
	private String vinNo;

	/**
	 * @Fields  : 车牌号
	 * @author qiaomengnan
	 */
	private String vehicleLicenseNo;

	/**
	 * @Fields  : 融资金额
	 * @author qiaomengnan
	 */
	private BigDecimal finTotal;

	/**
	 * @Fields  : 融资期限
	 * @author qiaomengnan
	 */
	private String finPeriodType;

	/**
	 * @Fields  : 放款日期
	 * @author qiaomengnan
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date contractValidDate;


	/**
	 * @Fields  : 客户租金
	 * @author qiaomengnan
	 */
	private BigDecimal rent;

	/**
	 * @Fields  : 期数
	 * @author qiaomengnan
	 */
	private Integer surplusPeriod;

	/**
	 * @Fields  : 查询条件期数 大于等于
	 * @author qiaomengnan
	 */
	private Integer gtSurplusPeriod;

	/**
	 * @Fields  : 查询条件期数 小于等于
	 * @author qiaomengnan
	 */
	private Integer ltSurplusPeriod;

	/**
	 * @Fields  : 剩余租金
	 * @author qiaomengnan
	 */
	private BigDecimal surplusRent;

	/**
	 * @Fields  : 个人申请类型
	 * @author qiaomengnan
	 */
	private String applyTypePerson;

	/** 
	 * @Fields  : 扣款状态
	 * @author qiaomengnan
	 */ 
	private String repayStatus;

	/**
	 * @Fields  : 合同是否适合抵押 0.不合适 1.合适
	 * @author qiaomengnan
	 */
	private String mortgageFlag;

	/**
	 * @Fields  : 抵押期数
	 * @author qiaomengnan
	 */
	private String leasePeriod;

	/**
	 * @Fields  : 还款日
	 * @author qiaomengnan
	 */
	private String repayDate;


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


	/**
	 * @Fields  : 抵押保证金
	 * @author qiaomengnan
	 */
	private BigDecimal margin;


	/**
	 * @Fields  : 抵押合同金额
	 * @author qiaomengnan
	 */
	private BigDecimal equFinAmount;

	/**
	 * @Fields  : 抵押月租
	 * @author qiaomengnan
	 */
	private BigDecimal equRent;


	/**
	 * @Fields  : 手续费
	 * @author qiaomengnan
	 */
	private BigDecimal factorge;

	/**
	 * @Fields  : 服务费
	 * @author qiaomengnan
	 */
	private BigDecimal serviceCharge;


	/**
	 * @Fields  : 合同融资项目
	 * @author qiaomengnan
	 */
	private List<ContFinDetailVo> contFinDetailVos;

	/**
	 * @Fields  : 首付金额
	 * @author qiaomengnan
	 */
	private BigDecimal initAmount;
	
	/** 
	 * @Fields  : 抵押状态
	 * @author qiaomengnan
	 */ 
	private String mortgageStatus;

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

	/**
	 * @Fields  : 融资年限
	 * @author qiaomengnan
	 */
	public String getFinPeriodYears(){
		if(StringUtils.isNotTrimBlank(finPeriodType)) {
			int result = Integer.parseInt(finPeriodType);
			if(result % 12 == 0)
				return (result / 12) + "";
			else
				return (result / 12) + 1 + "";
		}
		return null;
	}

	/**
	 * @Fields  : 发动机号
	 * @author qiaomengnan
	 */
	public String engineNo;

	/**
	 * @Fields  : 尾付比例
	 * @author qiaomengnan
	 */
	private BigDecimal finalPerc;

	/**
	 * @Fields  : 尾付金额
	 * @author qiaomengnan
	 */
	private BigDecimal finalAmount;

	/** 
	 * @Fields  : 租金支付模式
	 * @author qiaomengnan
	 */ 
	private String rentPayMode;

	/**
	 * @Fields  : 每期支付日期
	 * @author qiaomengnan
	 */
	private String repayDay;

	/**
	 * @Fields  : 资方抵押任务
	 * @author qiaomengnan
	 */ 
	private EquMorTaskVo equMorTaskVo;

	/** 
	 * @Fields  : 资方抵押明细
	 * @author qiaomengnan
	 */ 
	private EquMorDetailVo equMorDetailVo;

	/**
	 * @Fields  : 合同号集合
	 * @author qiaomengnan
	 */
	private List<String> contNos;

	/**
	 * @Fields  : 任务id
	 * @author qiaomengnan
	 */
	private String taskId;

	/**
	 * @Fields  : 任务key
	 * @author qiaomengnan
	 */
	private String taskDefinitionKey;

	/**
	 * @Fields  : 终端客户业务每期租金
	 * @author qiaomengnan
	 */
	private BigDecimal contFinRent;

	/**
	 * @Fields  : 海翼每期租金
	 * @author qiaomengnan
	 */
	private BigDecimal equMorRent;

	/**
	 * @Fields  : 还款日期string类型
	 * @author qiaomengnan
	 */
	private String repayDateStr;

	/**
	 * @Fields  : 出租人所在城市
	 * @author qiaomengnan
	 */
	private String groupDistrict;

	/**
	 * @Fields  : 资方抵押任务号
	 * @author qiaomengnan
	 */
	private String equMorTaskNo;

	/**
	 * @Fields  : 资方
	 * @author qiaomengnan
	 */
	private String management;

	/**
	 * @Fields  : 抵押流程
	 * @author qiaomengnan
	 */
	private String mortgageProcess;

	/**
	 * @Fields  : 资方抵押任务id
	 * @author qiaomengnan
	 */
	private String equMorTaskId;

	/**
	 * @Fields  : 资方抵押明细id
	 * @author qiaomengnan
	 */
	private String equMorDetailId;

	/**
	 * @Fields  : 抵押任务状态
	 * @author qiaomengnan
	 */
	private String mortgageServStatus;

	/**
	 * @Fields  : 当前节点用户
	 * @author qiaomengnan
	 */
	private String presentUser;

	/**
	 * @Fields  : 车身发票
	 * @author qiaomengnan
	 */
	private BigDecimal carprice;

	/**
	 * @Fields  : 抵押合同编号
	 * @author ningyangyang
	 */
	  private String  mortgageContNo;

	/**
	 * @Fields  : 备注
	 * @author ningyangyang
	 */
	 private String memo;

	/**
	 * @Fields  : 申请类型
	 * @author yanfengbo
	 */
	private String companyType1;

	/**
	 * @Fields  : 合同生效日期开始时间
	 */
	private String validStartTime;

	/**
	 * @Fields  : 合同生效日期结束时间
	 */
	private String validEndTime;

	/**
	 * @Fields  : 车款
	 */
	private BigDecimal carpriceFee;

	/**
	 * @Fields  : 购置税
	 */
	private BigDecimal purchasetaxFee;

	/**
	 * @Fields  : 保险
	 */
	private BigDecimal insuranceFee;

	/**
	 * @Fields  : 其他费用
	 */
	private BigDecimal otherFee;

	/**
	 * @Fields  : 申请金额
	 */
	private BigDecimal investTotal;

	/**
	 * @Fields  : 租赁期限开始日
	 * @author qiaomengnan
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date leaseTermStartDate;

	/**
	 * @Fields  : 租赁期限结束日
	 * @author yanfengbo
	 */
	@JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
	private Date leaseTermEndDate;

	/**
	 * @Fields  : 资方抵押明细表update_time
	 * @author yanfengbo
	 */
	private Date equMorDetailUpdateTime;

	/**
	 * @Fields  : 资方抵押任务表update_time
	 * @author yanfengbo
	 */
	private Date equMorTaskUpdateTime;

	//return null的字段只是用作模板使用，所以get方法命名并不标准，如果真实使用需要改为标准名称

	@ExcelTitle(value = "品牌" , sort = 1,types = {ExcelTypeConstants.ONE})
	public String getVehBrandCodeName(){
		return vehBrandCodeName;
	}

	@ExcelTitle(value = "型号" , sort = 2,types = {ExcelTypeConstants.ONE})
	public String getVehicleCodeName(){
		return vehicleCodeName;
	}

	@ExcelTitle(value = "地区" , sort = 3,types = {ExcelTypeConstants.ONE})
	public String getGroupDistrict(){
		return groupDistrict;
	}

	@ExcelTitle(value = "车牌号" , sort = 4,types = {ExcelTypeConstants.ONE})
	public String getVehicleLicenseNo(){
		return vehicleLicenseNo;
	}

	@ExcelTitle(value = "发动机号" ,sort = 5,types = {ExcelTypeConstants.ONE})
	public String getEngineNo(){
		return engineNo;
	}

	@ExcelTitle(value = "车架号" ,sort = 6,types = {ExcelTypeConstants.ONE})
	public String getVinNo(){
		return vinNo;
	}

	@ExcelTitle(value = "产权人" ,sort = 7,types = {ExcelTypeConstants.ONE})
	public String getBelongGroupName(){
		return belongGroupName;
	}

	@ExcelTitle(value = "车身发票" ,sort = 8,types = {ExcelTypeConstants.ONE})
	public BigDecimal getCarprice(){
		return carprice;
	}

	private BigDecimal purchaseTax;

	@ExcelTitle(value = "购置税" ,sort = 9,types = {ExcelTypeConstants.ONE})
	public BigDecimal getPurchaseTax(){
		return purchaseTax;
	}

	@ExcelTitle(value = "交强" ,sort = 10,types = {ExcelTypeConstants.ONE})
	public String getJq(){
		return null;
	}

	private BigDecimal insurance;

	@ExcelTitle(value = "商业险" ,sort = 11,types = {ExcelTypeConstants.ONE})
	public BigDecimal getInsurance(){
		return insurance;
	}

	private BigDecimal others;

	@ExcelTitle(value = "其他费用合计" ,sort = 12,types = {ExcelTypeConstants.ONE})
	public BigDecimal getOthers(){
		return others;
	}

	@ExcelTitle(value = "融资总额" ,sort = 13,types = {ExcelTypeConstants.ONE})
	public BigDecimal getFinTotal(){
		return finTotal;
	}

	@ExcelTitle(value = "租赁期限" ,sort = 14,types = {ExcelTypeConstants.ONE})
	public String getFinPeriodType(){
		return finPeriodType;
	}

	@ExcelTitle(value = "剩余租期" ,sort = 15,types = {ExcelTypeConstants.ONE})
	public Integer getSurplusPeriod(){
		return surplusPeriod;
	}

	private String othersRatio;

	@ExcelTitle(value = "其他费用比例" ,sort = 16,types = {ExcelTypeConstants.ONE})
	public String getOthersRatio(){
		if(getOthers() != null && finTotal != null)
			return getOthers().divide(finTotal,2,BigDecimal.ROUND_HALF_EVEN).multiply(BigDecimalUtils.getPercent()).toString();
		return null;
	}

	@ExcelTitle(value = "主合同编号" ,sort = 17,types = {ExcelTypeConstants.ONE})
	public String getContNo(){
		return contNo;
	}


	@ExcelTitle(value = "融资金额(资金方)" ,sort = 18,types = {ExcelTypeConstants.ONE})
	public String getRzje(){
		return null;
	}

	@ExcelTitle(value = "租赁期限(资金方)" ,sort = 19,types = {ExcelTypeConstants.ONE})
	public String getZlqx(){
		return null;
	}

	@ExcelTitle(value = "还款日(资金方)" ,sort = 20,types = {ExcelTypeConstants.ONE})
	public String getHkr(){
		return null;
	}

	@ExcelTitle(value = "保证金(资金方)" ,sort = 21,types = {ExcelTypeConstants.ONE})
	public String getBzj(){
		return null;
	}

	@ExcelTitle(value = "服务费(资金方)" ,sort = 22,types = {ExcelTypeConstants.ONE})
	public String getFwf(){
		return null;
	}

	@ExcelTitle(value = "管理费(资金方)" ,sort = 23,types = {ExcelTypeConstants.ONE})
	public String getGlf(){
		return null;
	}

	@ExcelTitle(value = "留购价(资金方)" ,sort = 24,types = {ExcelTypeConstants.ONE})
	public String getLgj(){
		return null;
	}

	@ExcelTitle(value = "每期租金(资金方)" ,sort = 25,types = {ExcelTypeConstants.ONE})
	public String getMqzj(){
		return null;
	}

	@ExcelTitle(value = "抵押合同编号(资金方)" ,sort = 26,types = {ExcelTypeConstants.ONE})
	public String getEquContNo(){
		return null;
	}


	private Map<String,BigDecimal> amounts;

	public void init(){
		//如果融资费用项金额不为空,则在初始化的时候把金额算好
		if(ArrayUtils.isNotNullAndLengthNotZero(contFinDetailVos)){
			for(ContFinDetailVo contFinDetailVo : contFinDetailVos){
				if(amounts == null)
					amounts = new HashMap<>();
				BigDecimal amount = amounts.get(contFinDetailVo.getFinItem());
				if(amount == null)
					amount = new BigDecimal("0");
				amount = amount.add(contFinDetailVo.getFinAmount());
				amounts.put(contFinDetailVo.getFinItem(),amount);
			}
			if(amounts != null) {
				purchaseTax = amounts.get(FinItemEnums.PURTAX.getCode());
				insurance = amounts.get(FinItemEnums.INSURANCE.getCode());
				carprice = amounts.get(FinItemEnums.CARPRICE.getCode());
				if (finTotal != null && purchaseTax != null && insurance != null)
					others = finTotal.subtract(purchaseTax).subtract(insurance);
			}
		}
	}


	/*抵押申请一览导出*/
	@ExcelTitle(value = "合同号" , sort = 1,types = {ExcelTypeConstants.TWO})
	public String getContNo2(){return contNo;}

	@ExcelTitle(value = "品牌" , sort = 2,types = {ExcelTypeConstants.TWO})
	public String getVehBrandCodeName2(){
		return vehBrandCodeName;
	}

	@ExcelTitle(value = "业务类型" , sort = 3,types = {ExcelTypeConstants.TWO},codeType = CommonCodeTypeConstants.PROD_LICENSE_ATTR)
	public String getLicenseAttr(){
		return licenseAttr;
	}

	@ExcelTitle(value = "出租人" , sort = 4,types = {ExcelTypeConstants.TWO})
	public String getBelongGroupName2(){
		return belongGroupName;
	}

	@ExcelTitle(value = "客户姓名" , sort = 5,types = {ExcelTypeConstants.TWO})
	public String getLessee(){
		return lessee;
	}

	@ExcelTitle(value = "车架号" ,sort = 6,types = {ExcelTypeConstants.TWO})
	public String getVinNo2(){
		return vinNo;
	}

	@ExcelTitle(value = "车型" , sort = 7,types = {ExcelTypeConstants.TWO})
	public String getVehicleCodeName2(){
		return vehicleCodeName;
	}

	@ExcelTitle(value = "车牌号" , sort = 8,types = {ExcelTypeConstants.TWO})
	public String getVehicleLicenseNo2(){
		return vehicleLicenseNo;
	}

	@ExcelTitle(value = "发动机号" ,sort = 9,types = {ExcelTypeConstants.TWO})
	public String getEngineNo2(){
		return engineNo;
	}

	@ExcelTitle(value = "申请类型" , sort = 10,types = {ExcelTypeConstants.TWO},codeType = CommonCodeTypeConstants.COMPANY_TYPE1)
	public String getCompanyType1(){
		return companyType1;
	}

	@ExcelTitle(value = "抵押状态" , sort = 11,types = {ExcelTypeConstants.TWO},codeType = CommonCodeTypeConstants.MORTGAGE_STATUS)
	public String getMortgageStatus(){
		return mortgageStatus;
	}

	@ExcelTitle(value = "车款" ,sort = 12,types = {ExcelTypeConstants.TWO})
	public BigDecimal getCarpriceFee(){
		return carpriceFee;
	}

	@ExcelTitle(value = "购置税" ,sort = 13,types = {ExcelTypeConstants.TWO})
	public BigDecimal getPurchasetaxFee(){
		return purchasetaxFee;
	}

	@ExcelTitle(value = "保险" ,sort = 14,types = {ExcelTypeConstants.TWO})
	public BigDecimal getInsuranceFee(){
		return insuranceFee;
	}

	@ExcelTitle(value = "其他费用" ,sort = 15,types = {ExcelTypeConstants.TWO})
	public BigDecimal getOtherFee(){
		return otherFee;
	}

	@ExcelTitle(value = "申请金额" ,sort = 16,types = {ExcelTypeConstants.TWO})
	public BigDecimal getInvestTotal(){
		return investTotal;
	}

	@ExcelTitle(value = "融资金额" ,sort = 17,types = {ExcelTypeConstants.TWO})
	public BigDecimal getFinTotal2(){
		return finTotal;
	}

	@ExcelTitle(value = "租赁期限" ,sort = 18,types = {ExcelTypeConstants.TWO})
	public String getFinPeriodType2(){
		return finPeriodType;
	}

	@ExcelTitle(value = "放款日期", sort = 19,types = {ExcelTypeConstants.TWO})
	@JsonIgnore
	public String getContractValidDateStr(){ return DateUtils.dateToStr(contractValidDate,DateUtils.formatStr_yyyyMMdd);}


	@ExcelTitle(value = "客户租金" ,sort = 20,types = {ExcelTypeConstants.TWO})
	public BigDecimal getRent(){
		return rent;
	}

	@ExcelTitle(value = "抵押期数", sort = 21,types = {ExcelTypeConstants.TWO})
	public String getLeasePeriod(){
		return leasePeriod;
	}

	@ExcelTitle(value = "还款日", sort = 22,types = {ExcelTypeConstants.TWO})
	public String getRepayDate(){
		return repayDate;
	}

	@ExcelTitle(value = "起租日", sort = 23,types = {ExcelTypeConstants.TWO})
	@JsonIgnore
	public String getEquStartDateStr(){ return DateUtils.dateToStr(equStartDate,DateUtils.formatStr_yyyyMMdd);}

	@ExcelTitle(value = "到期日", sort = 24,types = {ExcelTypeConstants.TWO})
	@JsonIgnore
	public String getEquEndDateStr(){ return DateUtils.dateToStr(equEndDate,DateUtils.formatStr_yyyyMMdd);}

	@ExcelTitle(value = "抵押保证金" ,sort = 25,types = {ExcelTypeConstants.TWO})
	public BigDecimal getMargin(){
		return margin;
	}

	@ExcelTitle(value = "抵押合同金额" ,sort = 26,types = {ExcelTypeConstants.TWO})
	public BigDecimal getEquFinAmount(){
		return equFinAmount;
	}

	@ExcelTitle(value = "抵押月租" ,sort = 27,types = {ExcelTypeConstants.TWO})
	public BigDecimal getEquRent(){
		return equRent;
	}

	@ExcelTitle(value = "手续费" ,sort = 28,types = {ExcelTypeConstants.TWO})
	public BigDecimal getFactorge(){
		return factorge;
	}

	@ExcelTitle(value = "服务费" ,sort = 29,types = {ExcelTypeConstants.TWO})
	public BigDecimal getServiceCharge(){
		return serviceCharge;
	}


	@ExcelTitle(value = "剩余期数" ,sort = 30,types = {ExcelTypeConstants.TWO})
	public Integer getSurplusPeriod2(){
		return surplusPeriod;
	}

	@ExcelTitle(value = "剩余租金" ,sort = 31,types = {ExcelTypeConstants.TWO})
	public BigDecimal getSurplusRent(){
		return surplusRent;
	}

	@ExcelTitle(value = "抵押任务号" , sort = 32,types = {ExcelTypeConstants.TWO})
	public String getEquMorTaskNo(){
		return equMorTaskNo;
	}

	@ExcelTitle(value = "抵押合同号" , sort = 33,types = {ExcelTypeConstants.TWO})
	public String getMortgageContNo(){
		return mortgageContNo;
	}

	@ExcelTitle(value = "资方" , sort = 34,types = {ExcelTypeConstants.TWO},codeType = CommonCodeTypeConstants.MANAGEMENT)
	public String getManagement(){
		return management;
	}

	@ExcelTitle(value = "抵押任务状态" , sort = 35,types = {ExcelTypeConstants.TWO},codeType = CommonCodeTypeConstants.BIZSTATUS)
	public String getMortgageServStatus(){
		return mortgageServStatus;
	}

	@ExcelTitle(value = "当前节点用户" , sort = 36,types = {ExcelTypeConstants.TWO})
	public String getPresentUser(){
		return presentUser;
	}

}