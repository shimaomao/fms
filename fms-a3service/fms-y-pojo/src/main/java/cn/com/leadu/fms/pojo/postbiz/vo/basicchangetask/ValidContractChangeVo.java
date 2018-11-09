package cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * @author lijunjun
 * @ClassName: ValidContractChangeVo
 * @Description: 生效合同变更申请一览查询信息载体
 * @date 2018-04-27
 */
@ExcelTitle(value = "生效合同信息")
@Data
public class ValidContractChangeVo extends PageQuery<Contract> {

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
     * @Fields  : 生成合同日期
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date contractDate;

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


    @ExcelTitle(value = "合同编号", sort = 1)
    public String getContNo() {
        return contNo;
    }
    @ExcelTitle(value = "申请编号", sort = 2)
    public String getApplyNo() {
        return applyNo;
    }
    @ExcelTitle(value = "出租人", sort = 3)
    public String getGroupName() {
        return groupName;
    }
    @ExcelTitle(value = "承租人", sort = 4)
    public String getName() {
        return name;
    }
    @ExcelTitle(value = "车架号", sort = 5)
    public String getVinNo() {
        return vinNo;
    }
    @ExcelTitle(value = "车牌号", sort = 6)
    public String getVehicleLicenseNo() {
        return vehicleLicenseNo;
    }
    @ExcelTitle(value = "业务类型", sort = 7,codeType = CommonCodeTypeConstants.PROD_LICENSE_ATTR)
    public String getLicenseAttr() {
        return licenseAttr;
    }
    @ExcelTitle(value = "车辆类型", sort = 8,codeType = CommonCodeTypeConstants.PROD_VEHICLE_FORM)
    public String getVehicleForm() {
        return vehicleForm;
    }
    @ExcelTitle(value = "当前节点用户", sort = 9)
    public String getPresentUser() {
        return presentUser;
    }
    @ExcelTitle(value = "合同申请状态", sort = 10,codeType = CommonCodeTypeConstants.BIZSTATUS)
    public String getBizStatus() {
        return bizStatus;
    }
    @ExcelTitle(value = "合同生效日期", sort = 11)
    public String getContractValidDate() {
        return contractValidDate;
    }
    @ExcelTitle(value = "车辆品牌", sort = 12)
    public String getVehBrandCodeName() {
        return vehBrandCodeName;
    }
    @ExcelTitle(value = "车型", sort = 13)
    public String getVehicleCodeName() {
        return vehicleCodeName;
    }
    @ExcelTitle(value = "产品名称", sort = 14)
    public String getProductName() {
        return productName;
    }
    @ExcelTitle(value = "融资期限", sort = 15)
    public String getFinPeriodType() {
        return finPeriodType;
    }
    @ExcelTitle(value = "申请金额", sort = 16)
    public BigDecimal getInvestTotal() {
        return investTotal;
    }
    @ExcelTitle(value = "首付金额", sort = 17)
    public BigDecimal getInitAmount() {
        return initAmount;
    }
    @ExcelTitle(value = "融资金额", sort = 18)
    public BigDecimal getFinTotal() {
        return finTotal;
    }
    @ExcelTitle(value = "贷款利息", sort = 19)
    public BigDecimal getLoanInterest() {
        return loanInterest;
    }
    @ExcelTitle(value = "保证金", sort = 20)
    public BigDecimal getDeposit() {
        return deposit;
    }
    @ExcelTitle(value = "租金", sort = 21)
    public BigDecimal getRent() {
        return rent;
    }
    @ExcelTitle(value = "尾付金额", sort = 22)
    public BigDecimal getFinalAmount() {
        return finalAmount;
    }
    @ExcelTitle(value = "年供金额", sort = 23)
    public BigDecimal getAnnualSupplyAmount() {
        return annualSupplyAmount;
    }
    @ExcelTitle(value = "标签价", sort = 24)
    public BigDecimal getGuidePrice() {
        return guidePrice;
    }
    @ExcelTitle(value = "成交价", sort = 25)
    public BigDecimal getFinAmount() {
        return finAmount;
    }
    @ExcelTitle(value = "还款状态", sort = 26 ,codeType = CommonCodeTypeConstants.PROD_PAYMENT_STS)
    public String getPaymentSts() {
        return paymentSts;
    }
    @ExcelTitle(value = "irr", sort = 27)
    public BigDecimal getIrr() {
        return irr;
    }
    @ExcelTitle(value = "产品大类", sort = 28)
    public String getProductCatgName() {
        return productCatgName;
    }
    @ExcelTitle(value = "实际销售方", sort = 29)
    public String getSalesName() {
        return salesName;
    }
    @ExcelTitle(value = "申请类型", sort = 30 ,codeType = CommonCodeTypeConstants.COMPANY_TYPE1)
    public String getCompanyType1() {
        return companyType1;
    }
    @ExcelTitle(value = "类别", sort = 31 ,codeType = CommonCodeTypeConstants.COMPANY_TYPE2)
    public String getCompanyType2() {
        return companyType2;
    }
    @ExcelTitle(value = "车辆分类", sort = 32 ,codeType = CommonCodeTypeConstants.VEHICLE_TYPE2)
    public String getVehicleType2() {
        return vehicleType2;
    }
    @ExcelTitle(value = "客户证件号码", sort = 33)
    public String getCertifNo() {
        return certifNo;
    }
    @ExcelTitle(value = "业务经理", sort = 34)
    public String getApplyUser() {
        return applyUser;
    }
    @ExcelTitle(value = "首次提交日期", sort = 35)
    public String getApplyFirsbtDate() {
        return applyFirsbtDate;
    }
    @ExcelTitle(value = "提交日期", sort = 36)
    public String getApplySubmitDate() {
        return applySubmitDate;
    }
    @ExcelTitle(value = "制造商", sort = 37)
    public String getVehMakerCodeName() {
        return vehMakerCodeName;
    }
    @ExcelTitle(value = "车系", sort = 38)
    public String getVehSeriesCodeName() {
        return vehSeriesCodeName;
    }
    @ExcelTitle(value = "GPS-SIM卡号", sort = 39)
    public String getGpsNo() {
        return gpsNo;
    }
}
