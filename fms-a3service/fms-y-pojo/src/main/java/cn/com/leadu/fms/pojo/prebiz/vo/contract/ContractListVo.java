package cn.com.leadu.fms.pojo.prebiz.vo.contract;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * @author yangyiquan
 * @ClassName: ContractListVo
 * @Description: 合同一览查询信息载体
 * @date 2018-04-27
 */
//@ExcelTitle(value = "合同一览明细")
@ExcelTitle(typeValues = {"合同一览明细", "当月新增放款车辆明细"}, types = {ExcelTypeConstants.ONE, ExcelTypeConstants.TWO})
@Data
public class ContractListVo extends PageQuery<Contract> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 合同ID
     */
    private String contractId;

    /**
     * @Fields  : 合同编号
     */
    private String contNo;

    /**
     * @Fields  : 订单编号
     */
    private String applyNo;

    /**
     * @Fields  : 车辆序号
     */
    private String vehicleNo;

    /**
     * @Fields  : 合同状态
     */
    private String bizStatus;

    /**
     * @Fields  : 还款状态
     */
    private String  paymentSts;

    /**
     * @Fields  : 申请类型
     */
    private String applyType;

    /**
     * @Fields  : 订单提出账号
     */
    private String applyUser;

    /**
     * @Fields  : 订单提出机构代码
     */
    private String applyGroup;

    /**
     * @Fields  : 订单提出机构全称
     */
    private String applyGroupName;

    /**
     * @Fields  : 当前节点账号
     */
    private String presentUser;

    /**
     * @Fields  : 收款机构代码
     */
    private String groupCode;

    /**
     * @Fields  : 收款机构银行序号
     */
    private String groupBankNo;

    /**
     * @Fields  : 颜色
     */
    private String color;

    /**
     * @Fields  : 车架号
     */
    private String vinNo;

    /**
     * @Fields  : 发动机号
     */
    private String engineNo;

    /**
     * @Fields  : 车辆配置描述
     */
    private String vehicleComment;

    /**
     * @Fields  : 车牌号
     */
    private String vehicleLicenseNo;

    /**
     * @Fields  : GPS-SIM卡号
     */
    private String gpsNo;

    /**
     * @Fields  : 放款模式
     */
    private String loanMode;

    /**
     * @Fields  : 合同邮寄ID
     */
    private String filePostId;

    /**
     * @Fields  : 创建日期
     */
    private Date creatDate;

    /**
     * @Fields  : 审核通过日期
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date passDate;

    /**
     * @Fields  : 合同请款日期
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date contractRequestDate;

   /* *//**
     * @Fields  : 生成合同日期
     *//*
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date contractDate;*/

    /**
     * @Fields  : 合同打印日期
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date contractPrintDate;

    /**
     * @Fields  : 合同生效日期
     */
    private String contractValidDate;

    /**
     * @Fields  : 合同生效日期开始时间
     */
    private String validStartTime;

    /**
     * @Fields  : 合同生效日期结束时间
     */
    private String validEndTime;

    /**
     * @Fields  : 合同生成日期
     */
    private String contractDate;

    /**
     * @Fields  : 合同生成日期开始时间
     */
    private String validStartTime2;

    /**
     * @Fields  : 合同生成日期结束时间
     */
    private String validEndTime2;


    /**
     * @Fields  :出租人
     */
    private String groupName;

    /**
     * @Fields  :出租人区域
     */
    private String groupDistrict;

    /************************    合同融资车辆信息    ***********************/
    /**
     * @Fields  : 车辆类型
     */
    private String vehicleForm;
    /**
     * @Fields  : 制造商
     */
    private String vehMakerCode;
    /**
     * @Fields  : 制造商名称
     */
    private String vehMakerCodeName;
    /**
     * @Fields  : 车辆品牌
     */
    private String vehBrandCode;
    /**
     * @Fields  : 车辆品牌名称
     */
    private String vehBrandCodeName;
    /**
     * @Fields  : 车型
     */
    private String vehicleCode;
    /**
     * @Fields  : 车型名称
     */
    private String vehicleCodeName;
    /**
     * @Fields  : 车系
     */
    private String vehSeriesCode;
    /**
     * @Fields  : 车系名称
     */
    private String vehSeriesCodeName;


    /******************************    合同融资信息    *****************************/
    /**
     * @Fields  : 产品名称代码
     */
    private String product;
    /**
     * @Fields  : 产品名称
     */
    private String productName;
    /**
     * @Fields  : 牌照属性
     */
    private String licenseAttr;
    /**
     * @Fields  : 融资期限
     */
    private String finPeriodType;
    /**
     * @Fields  : 手续费收取方式
     */
    private String chargePayMode;
    /**
     * @Fields  : 手续费比例
     */
    private BigDecimal chargeRate;
    /**
     * @Fields  : 手续费
     */
    private BigDecimal charge;
    /**
     * @Fields  : 首付比例
     */
    private BigDecimal initPerc;
    /**
     * @Fields  : 首付金额
     */
    private BigDecimal initAmount;
    /**
     * @Fields  : 投资总额
     */
    private BigDecimal investTotal;
    /**
     * @Fields  : 融资金额
     */
    private BigDecimal finTotal;
    /**
     * @Fields  : 合同租金
     */
    private BigDecimal rent;
    /**
     * @Fields  : 保证金费用
     */
    private BigDecimal deposit;

    /**
     * @Fields  : 尾付金额
     */
    private BigDecimal finalAmount;

    /**
     * @Fields  : 年供金额
     */
    private BigDecimal annualSupplyAmount;

    /**
     * @Fields  : 贷款利息
     */
    private BigDecimal loanInterest;


    /******************************   订单信息    *****************************/
    /**
     * @Fields  : 首次提交日期
     */
    private String applyFirsbtDate;
    /**
     * @Fields  : 提交日期
     */
    private String applySubmitDate;


    /******************************    客户个人/企业基本信息    *****************/
    /**
     * @Fields  : 客户姓名
     */
    private String name;
    /**
     * @Fields  : 客户证件号码
     */
    private String certifNo;
    /**
     * @Fields  : 个人标志
     */
    private String personFlag;
    /**
     * @Fields  : 企业标志
     */
    private String companyFlag;

    /**
     * @Fields  : 当前用户
     */
    private String sysUser;

    /**
     * @Fields  : 当前用户所属机构
     */
    private List<String> sysUserGroup;

    /**
     * @Fields  : 担保人
     */
    private String guarantee;

    /**
     * @Fields  : 是否展期
     */
    private String  isDefer;

    /**
     * @Fields  : irr
     */
    private BigDecimal irr;

    /**
     * @Fields  : 标签价(新车/二手车车辆指导价)
     */
    private BigDecimal guidePrice;

    /**
     * @Fields  :成交价(车款)
     */
    private BigDecimal finAmount;

    /**
     * @Fields  : 融资项目代码
     */
    private String finItem;

    /**
     * @Fields  : 产品大类
     */
    private String productCatgName;

    /**
     * @Fields  : 实际销售方
     */
    private String salesName;


    /**
     * @Fields  : 申请类型
     */
    private String companyType1;

    /**
     * @Fields  : 类别
     */
    private String companyType2;

    /**
     * @Fields  : 车辆分类
     */
    private String vehicleType2;

    /**
     * @Fields  : 还款日
     */
    private String repayDay;

    /**
     * @Fields  : 租赁期限开始日
     */
    private String leaseTermStartDate;

    /**
     * @Fields  : 租赁期限结束日
     */
    private String leaseTermEndDate;

    /**
     * @Fields  : 还款日期string类型
     * @author yyq
     */
    private String repayDateStr;

    /**
     * @Fields  : 扣款状态
     * @author yyq
     */
    private String repayStatus;

    /**
     * @Fields  : 剩余期数
     * @author yyq
     */
    private Integer surplusPeriod;

    /**
     * @Fields  : 剩余租金
     * @author yyq
     */
    private BigDecimal surplusRent;

    /**
     * @Fields  : 业务经理名称
     * @author yanfengbo
     */
    private String applyUserName;

    /**
     * @Fields  : 当前节点用户名称
     * @author yanfengbo
     */
    private String presentUserName;

    /**
     * @Fields  : 车款
     * @author yanfengbo
     */
    private BigDecimal carpriceFee;

    /**
     * @Fields  : 购置税
     * @author yanfengbo
     */
    private BigDecimal purchasetaxFee;

    /**
     * @Fields  : 保险
     * @author yanfengbo
     */
    private BigDecimal insuranceFee;

    /**
     * @Fields  : 精品/家装
     * @author yanfengbo
     */
    private BigDecimal extraFee;

    /**
     * @Fields  : 上牌
     * @author yanfengbo
     */
    private BigDecimal licenseFee;

    /**
     * @Fields  : 延保
     * @author yanfengbo
     */
    private BigDecimal extendFee;

    /**
     * @Fields  : 其他费用
     * @author yanfengbo
     */
    private BigDecimal otherFee;

    /**
     * @Fields  : gps费
     * @author yanfengbo
     */
    private BigDecimal gpsFee;

    /**
     * @Fields  : 款项状态 01:待请款、02:待放款
     * @author huzongcheng
     */
    private String fundStatus;

    /**
     * @Fields  : 统计月份
     * @author huzongcheng
     */
    private String censuMonth;

    /**
     * @Fields  : 租赁期限结束日起始
     * @author yanfengbo
     */
    private String startTimeLeaseTermEnd;

    /**
     * @Fields  : 租赁期限结束日结束
     * @author yanfengbo
     */
    private String endTimeLeaseTermEnd;

    @ExcelTitle(value = "合同编号", sort = 1,types = { ExcelTypeConstants.ONE})
    public String getContNo() {
        return contNo;
    }
    @ExcelTitle(value = "申请编号", sort = 2,types = { ExcelTypeConstants.ONE})
    public String getApplyNo() {
        return applyNo;
    }
    @ExcelTitle(value = "出租人", sort = 3,types = { ExcelTypeConstants.ONE})
    public String getGroupName() {
        return groupName;
    }
    @ExcelTitle(value = "承租人", sort = 4,types = { ExcelTypeConstants.ONE})
    public String getName() {
        return name;
    }
    @ExcelTitle(value = "车架号", sort = 5,types = { ExcelTypeConstants.ONE})
    public String getVinNo() {
        return vinNo;
    }
    @ExcelTitle(value = "车牌号", sort = 6,types = { ExcelTypeConstants.ONE})
    public String getVehicleLicenseNo() {
        return vehicleLicenseNo;
    }
    @ExcelTitle(value = "业务类型", sort = 7,types = { ExcelTypeConstants.ONE},codeType = CommonCodeTypeConstants.PROD_LICENSE_ATTR)
    public String getLicenseAttr() {
        return licenseAttr;
    }
    @ExcelTitle(value = "车辆类型", sort = 8,types = { ExcelTypeConstants.ONE},codeType = CommonCodeTypeConstants.PROD_VEHICLE_FORM)
    public String getVehicleForm() {
        return vehicleForm;
    }
    @ExcelTitle(value = "当前节点用户", sort = 9,types = { ExcelTypeConstants.ONE})
    public String getPresentUser() {
        return presentUser;
    }
    @ExcelTitle(value = "当前节点用户名", sort = 10,types = { ExcelTypeConstants.ONE})
    public String getPresentUserName() {
        return presentUserName;
    }
    @ExcelTitle(value = "合同申请状态", sort = 11,types = { ExcelTypeConstants.ONE},codeType = CommonCodeTypeConstants.BIZSTATUS)
    public String getBizStatus() {
        return bizStatus;
    }
    @ExcelTitle(value = "合同生效日期", sort = 12,types = { ExcelTypeConstants.ONE})
    public String getContractValidDate() {
        return contractValidDate;
    }
    @ExcelTitle(value = "合同生成日期", sort = 13,types = { ExcelTypeConstants.ONE})
    public String getContractDate() {
        return contractDate;
    }
    @ExcelTitle(value = "车辆品牌", sort = 14,types = { ExcelTypeConstants.ONE})
    public String getVehBrandCodeName() {
        return vehBrandCodeName;
    }
    @ExcelTitle(value = "车型", sort = 15,types = { ExcelTypeConstants.ONE})
    public String getVehicleCodeName() {
        return vehicleCodeName;
    }
    @ExcelTitle(value = "产品名称", sort = 16,types = { ExcelTypeConstants.ONE})
    public String getProductName() {
        return productName;
    }
    @ExcelTitle(value = "融资期限", sort = 17,types = { ExcelTypeConstants.ONE})
    public String getFinPeriodType() {
        return finPeriodType;
    }
    @ExcelTitle(value = "申请金额", sort = 18,types = { ExcelTypeConstants.ONE})
    public BigDecimal getInvestTotal() {
        return investTotal;
    }
    @ExcelTitle(value = "首付金额", sort = 19,types = { ExcelTypeConstants.ONE})
    public BigDecimal getInitAmount() {
        return initAmount;
    }
    @ExcelTitle(value = "融资金额", sort = 20,types = { ExcelTypeConstants.ONE})
    public BigDecimal getFinTotal() {
        return finTotal;
    }
    @ExcelTitle(value = "贷款利息", sort = 21,types = { ExcelTypeConstants.ONE})
    public BigDecimal getLoanInterest() {
        return loanInterest;
    }
    @ExcelTitle(value = "保证金", sort = 22,types = { ExcelTypeConstants.ONE})
    public BigDecimal getDeposit() {
        return deposit;
    }
    @ExcelTitle(value = "租金", sort = 23,types = { ExcelTypeConstants.ONE})
    public BigDecimal getRent() {
        return rent;
    }
    @ExcelTitle(value = "尾付金额", sort = 24,types = { ExcelTypeConstants.ONE})
    public BigDecimal getFinalAmount() {
        return finalAmount;
    }
    @ExcelTitle(value = "年供金额", sort = 25,types = { ExcelTypeConstants.ONE})
    public BigDecimal getAnnualSupplyAmount() {
        return annualSupplyAmount;
    }
    @ExcelTitle(value = "标签价", sort = 26,types = { ExcelTypeConstants.ONE})
    public BigDecimal getGuidePrice() {
        return guidePrice;
    }
    @ExcelTitle(value = "车款", sort = 27,types = { ExcelTypeConstants.ONE})
    public BigDecimal getCarpriceFee() {
        return carpriceFee;
    }
    @ExcelTitle(value = "购置税", sort = 28,types = { ExcelTypeConstants.ONE})
    public BigDecimal getPurchasetaxFee() {
        return purchasetaxFee;
    }
    @ExcelTitle(value = "保险", sort = 29,types = { ExcelTypeConstants.ONE})
    public BigDecimal getInsuranceFee() {
        return insuranceFee;
    }
    @ExcelTitle(value = "精品/家装", sort = 30,types = { ExcelTypeConstants.ONE})
    public BigDecimal getExtraFee() {
        return extraFee;
    }
    @ExcelTitle(value = "GPS", sort = 31,types = { ExcelTypeConstants.ONE})
    public BigDecimal getGpsFee() {
        return gpsFee;
    }
    @ExcelTitle(value = "上牌", sort = 32,types = { ExcelTypeConstants.ONE})
    public BigDecimal getLicenseFee() {
        return licenseFee;
    }
    @ExcelTitle(value = "延保", sort = 33,types = { ExcelTypeConstants.ONE})
    public BigDecimal getExtendFee() {
        return extendFee;
    }
    @ExcelTitle(value = "其他费用", sort = 34,types = { ExcelTypeConstants.ONE})
    public BigDecimal getOtherFee() {
        return otherFee;
    }
    @ExcelTitle(value = "还款状态", sort = 35,types = { ExcelTypeConstants.ONE} ,codeType = CommonCodeTypeConstants.PROD_PAYMENT_STS)
    public String getPaymentSts() {
        return paymentSts;
    }
    @ExcelTitle(value = "irr", sort = 36,types = { ExcelTypeConstants.ONE})
    public BigDecimal getIrr() {
        return irr;
    }
    @ExcelTitle(value = "产品大类", sort = 37,types = { ExcelTypeConstants.ONE})
    public String getProductCatgName() {
        return productCatgName;
    }
    @ExcelTitle(value = "实际销售方", sort = 38,types = { ExcelTypeConstants.ONE})
    public String getSalesName() {
        return salesName;
    }
    @ExcelTitle(value = "申请类型", sort = 39,types = { ExcelTypeConstants.ONE} ,codeType = CommonCodeTypeConstants.COMPANY_TYPE1)
    public String getCompanyType1() {
        return companyType1;
    }
    @ExcelTitle(value = "类别", sort = 40,types = { ExcelTypeConstants.ONE} ,codeType = CommonCodeTypeConstants.COMPANY_TYPE2)
    public String getCompanyType2() {
        return companyType2;
    }
    @ExcelTitle(value = "车辆分类", sort = 41,types = { ExcelTypeConstants.ONE} ,codeType = CommonCodeTypeConstants.VEHICLE_TYPE2)
    public String getVehicleType2() {
        return vehicleType2;
    }
    @ExcelTitle(value = "客户证件号码", sort = 42,types = { ExcelTypeConstants.ONE})
    public String getCertifNo() {
        return certifNo;
    }
    @ExcelTitle(value = "业务经理", sort = 43,types = { ExcelTypeConstants.ONE})
    public String getApplyUserName() {
        return applyUserName;
    }
    @ExcelTitle(value = "首次提交日期", sort = 44,types = { ExcelTypeConstants.ONE})
    public String getApplyFirsbtDate() {
        return applyFirsbtDate;
    }
    @ExcelTitle(value = "提交日期", sort = 45,types = { ExcelTypeConstants.ONE})
    public String getApplySubmitDate() {
        return applySubmitDate;
    }
    @ExcelTitle(value = "制造商", sort = 46,types = { ExcelTypeConstants.ONE})
    public String getVehMakerCodeName() {
        return vehMakerCodeName;
    }
    @ExcelTitle(value = "车系", sort = 47,types = { ExcelTypeConstants.ONE})
    public String getVehSeriesCodeName() {
        return vehSeriesCodeName;
    }
    @ExcelTitle(value = "还款日", sort = 48,types = { ExcelTypeConstants.ONE})
    public String getRepayDay() {
        return repayDay;
    }
    @ExcelTitle(value = "租赁期限开始日", sort = 49,types = { ExcelTypeConstants.ONE})
    public String getLeaseTermStartDate() {
        return leaseTermStartDate;
    }
    @ExcelTitle(value = "租赁期限结束日", sort = 50,types = { ExcelTypeConstants.ONE})
    public String getLeaseTermEndDate() {
        return leaseTermEndDate;
    }
    @ExcelTitle(value = "GPS-SIM卡号", sort = 51,types = { ExcelTypeConstants.ONE})
    public String getGpsNo() {
        return gpsNo;
    }


    @ExcelTitle(value = "合同生效日期", sort = 1,types = { ExcelTypeConstants.TWO})
    public String getContractValidDate2() {
        return contractValidDate;
    }
    @ExcelTitle(value = "出租人", sort = 2,types = { ExcelTypeConstants.TWO})
    public String getGroupName2() {
        return groupName;
    }
    @ExcelTitle(value = "承租人", sort = 3,types = { ExcelTypeConstants.TWO})
    public String getName2() {return name;}
    @ExcelTitle(value = "车架号", sort = 4,types = { ExcelTypeConstants.TWO})
    public String getVinNo2() {
        return vinNo;
    }
    @ExcelTitle(value = "业务类型", sort = 5,types = { ExcelTypeConstants.TWO},codeType = CommonCodeTypeConstants.PROD_LICENSE_ATTR)
    public String getLicenseAttr2() {
        return licenseAttr;
    }
    @ExcelTitle(value = "产品名称", sort = 6,types = { ExcelTypeConstants.TWO})
    public String getProductName2() {
        return productName;
    }
    @ExcelTitle(value = "类别", sort = 7,types = { ExcelTypeConstants.TWO} ,codeType = CommonCodeTypeConstants.COMPANY_TYPE2)
    public String getCompanyType22() {
        return companyType2;
    }
    @ExcelTitle(value = "车辆品牌", sort = 8,types = { ExcelTypeConstants.TWO})
    public String getVehBrandCodeName2() {
        return vehBrandCodeName;
    }
    @ExcelTitle(value = "业务经理", sort = 9,types = { ExcelTypeConstants.TWO})
    public String getApplyUserName2() {
        return applyUserName;
    }
    @ExcelTitle(value = "融资期限", sort = 10,types = { ExcelTypeConstants.TWO})
    public String getFinPeriodType2() {
        return finPeriodType;
    }
    @ExcelTitle(value = "申请金额", sort = 11,types = { ExcelTypeConstants.TWO})
    public BigDecimal getInvestTotal2() {
        return investTotal;
    }
    @ExcelTitle(value = "首付金额", sort = 12,types = { ExcelTypeConstants.TWO})
    public BigDecimal getInitAmount2() {
        return initAmount;
    }
    @ExcelTitle(value = "融资金额", sort = 13,types = { ExcelTypeConstants.TWO})
    public BigDecimal getFinTotal2() {
        return finTotal;
    }
    @ExcelTitle(value = "贷款利息", sort = 14,types = { ExcelTypeConstants.TWO})
    public BigDecimal getLoanInterest2() {
        return loanInterest;
    }
    @ExcelTitle(value = "保证金", sort = 15,types = { ExcelTypeConstants.TWO})
    public BigDecimal getDeposit2() {
        return deposit;
    }
    @ExcelTitle(value = "尾付金额", sort = 16,types = { ExcelTypeConstants.TWO})
    public BigDecimal getFinalAmount2() {
        return finalAmount;
    }
    @ExcelTitle(value = "购车合同金额", sort = 17,types = { ExcelTypeConstants.TWO})
    public BigDecimal getCarpriceFee2() {
        return carpriceFee;
    }


}
