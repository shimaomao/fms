package cn.com.leadu.fms.pojo.prebiz.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by yanfengbo on 2018/3/28.
 * 融资申请取消
 */
@Data
public class ApplyCancel extends BaseEntity<ApplyCancel> {
    //订单编号
    private String applyNo;

    //订单状态
    private String bizStatus;

    //订单提出账号
    private String applyUser;

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
    private String cancelReason;

    //取消原因key
    private String cancelReasonKey;

    //取消备注
    private String cancelRemark;

}
