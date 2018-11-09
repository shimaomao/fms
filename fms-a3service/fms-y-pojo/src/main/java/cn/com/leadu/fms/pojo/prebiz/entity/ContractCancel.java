package cn.com.leadu.fms.pojo.prebiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yanfengbo
 * 融资合同取消
 */
@Data
public class ContractCancel extends BaseEntity<ContractCancel> {
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


    /**
     * @Fields  :
     */
    private String taskId;

}
