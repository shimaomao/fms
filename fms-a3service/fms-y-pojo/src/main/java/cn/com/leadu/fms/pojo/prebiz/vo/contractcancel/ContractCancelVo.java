package cn.com.leadu.fms.pojo.prebiz.vo.contractcancel;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyCancel;
import cn.com.leadu.fms.pojo.prebiz.entity.ContractCancel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 65604
 */
@ExcelTitle(value = "融资合同取消信息")
@Data
public class ContractCancelVo extends PageQuery<ContractCancel> {
    //合同编号
    private String contNo;
    //订单编号
    private String applyNo;
    //申请类型
    private String applyType;

    //合同申请状态
    private String bizStatus;

    //合同生效日期
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date contractValidDate;

    //车辆类型
    private String vehicleForm;

    //订单提出机构代码
    private String applyGroup;

    //合作商
    private String partnerName;

    //产品方案代码
    private String product;

    //产品方案
    private String productName;

    //首付金额
    private BigDecimal initAmount;

    //融资金额
    private BigDecimal finTotal;

    //证件号码
    private String certifNo;

    //个人证件号码
    private String personCertifNo;

    //法人证件号码
    private String companyCertifNo;

    //申请姓名
    private String name;

    //个人申请姓名
    private String personName;

    //企业名称
    private String companyName;

    //取消原因
    private String contractCancelReason;

    //取消原因key
    private String contractCancelReasonKey;

    //取消备注
    private String cancelRemark;

    //当前登录用户
    private String loginUser;

    //订单提出人
    private String applyUser;

    //订单提出机构
    private String groupName;

    //当前节点用户
    private String presentUser;

    //牌照属性
    private String licenseAttr;

    //融资期限
    private String finPeriodType;

    //手续费收取方式
    private String chargePayMode;

    //手续费率
    private BigDecimal chargeRate;

    //手续费
    private BigDecimal charge;

    //首付比例
    private BigDecimal initPerc;

    //投资总额
    private BigDecimal investTotal;

    //每期租金
    private BigDecimal rent;

    //保证金费用
    private BigDecimal deposit;

    //车架号
    private String vinNo;

    //车牌号
    private String vehicleLicenseNo;

    //GPS-SIM卡号
    private String gpsNo;

    //制造商
    private String vehMakerCodeName;

    //车辆品牌
    private String vehBrandCodeName;

    //车型
    private String vehicleCodeName;

    //车系
    private String vehSeriesCodeName;

    private String taskId;


    @ExcelTitle(value = "合同编号", sort = 1 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
    public String getContNo(){
        return this.contNo;
    }

    @ExcelTitle(value = "订单编号", sort = 2 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
    public String getApplyNo(){
        return this.applyNo;
    }

    @ExcelTitle(value = "申请姓名", sort = 3)
    public String getName(){
        return this.name;
    }

    @ExcelTitle(value = "申请类型", sort = 4 ,codeType = CommonCodeTypeConstants.PROD_APPLY_TYPE)
    public String getApplyType(){
        return this.applyType;
    }

    @ExcelTitle(value = "车辆类型", sort = 5,codeType = CommonCodeTypeConstants.PROD_VEHICLE_FORM)
    public String getVehicleForm(){
        return vehicleForm;
    }

    @ExcelTitle(value = "证件号码", sort = 6)
    public String getCertifNo(){
        return this.certifNo;
    }

    @ExcelTitle(value = "订单提出人", sort = 7 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
    public String getApplyUser(){
        return this.applyUser;
    }

    @ExcelTitle(value = "订单提出机构", sort = 8)
    public String getGroupName(){
        return this.groupName;
    }

    @ExcelTitle(value = "当前节点用户", sort = 9)
    public String getPresentUser(){
        return presentUser;
    }

    @ExcelTitle(value = "合同状态", sort = 10, codeType = CommonCodeTypeConstants.BIZSTATUS)
    public String getBizStatus(){
        return this.bizStatus;
    }

    @ExcelTitle(value = "合同生效日期", sort = 11)
    public String getContractValidDateStr(){ return DateUtils.dateToStr(contractValidDate,DateUtils.formatStr_yyyyMMdd);}

    @ExcelTitle(value = "制造商", sort = 12)
    public String getVehMakerCodeName(){
        return this.vehMakerCodeName;
    }

    @ExcelTitle(value = "品牌", sort = 13)
    public String getVehBrandCodeName(){
        return vehBrandCodeName;
    }

    @ExcelTitle(value = "车型", sort = 14 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
    public String getVehicleCodeName(){
        return this.vehicleCodeName;
    }

    @ExcelTitle(value = "车系", sort = 15)
    public String getVehSeriesCodeName(){
        return this.vehSeriesCodeName;
    }

    @ExcelTitle(value = "产品方案", sort = 16)
    public String getProductName(){
        return this.productName;
    }

    @ExcelTitle(value = "牌照属性", sort = 17,codeType = CommonCodeTypeConstants.PROD_LICENSE_ATTR)
    public String getLicenseAttr(){
        return licenseAttr;
    }

    @ExcelTitle(value = "融资期限", sort = 18 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
    public String getFinPeriodType(){
        return this.finPeriodType;
    }

    @ExcelTitle(value = "手续费收取方式", sort = 19,codeType = CommonCodeTypeConstants.PROD_CHARGE_PAY_MODE)
    public String getChargePayMode(){
        return this.chargePayMode;
    }

    @ExcelTitle(value = "手续费率", sort = 20)
    public BigDecimal getChargeRate(){
        return chargeRate;
    }

    @ExcelTitle(value = "手续费", sort = 21 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
    public BigDecimal getCharge(){
        return this.charge;
    }

    @ExcelTitle(value = "首付比例", sort = 22)
    public BigDecimal getInitPerc(){
        return this.initPerc;
    }

    @ExcelTitle(value = "首付金额", sort = 23)
    public BigDecimal getInitAmount(){return initAmount;}

    @ExcelTitle(value = "投资总额", sort = 24)
    public BigDecimal getInvestTotal(){
        return investTotal;
    }

    @ExcelTitle(value = "融资金额", sort = 25)
    public BigDecimal getFinTotal(){
        return this.finTotal;
    }

    @ExcelTitle(value = "每期租金", sort = 26 ,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
    public BigDecimal getRent(){
        return this.rent;
    }

    @ExcelTitle(value = "保证金费用", sort = 27)
    public BigDecimal getDeposit(){
        return this.deposit;
    }

    @ExcelTitle(value = "合作商", sort = 28)
    public String getPartnerName(){
        return this.partnerName;
    }

    @ExcelTitle(value = "车架号", sort = 29)
    public String getVinNo(){
        return vinNo;
    }

    @ExcelTitle(value = "车牌号", sort = 30)
    public String getVehicleLicenseNo(){
        return this.vehicleLicenseNo;
    }

    @ExcelTitle(value = "GPS-SIM卡号", sort = 31)
    public String getGpsNo(){
        return gpsNo;
    }






}
