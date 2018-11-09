package cn.com.leadu.fms.pojo.postbiz.vo.transferinfo;

import cn.com.leadu.fms.common.constant.enums.asset.MortgageStatusEnums;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import cn.com.leadu.fms.pojo.postbiz.entity.TransferInfo;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

/**
 * @author yanfengbo
 * @ClassName: TransferInfoRetreatsVo
 * @Description: 过户退保载体
 * @date 
 */
@Data
public class TransferInfoRetreatsVo extends PageQuery<TransferInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 过户信息ID
     * @author yanfengbo
     */
    private String transferId;

    /**
     * @Fields  : 合同编号
     * @author yanfengbo
     */
    private String contNo;

    /**
     * @Fields  : 车架号
     * @author yanfengbo
     */
    private String vinNo;

    /**
     * @Fields  : 过户状态
     * @author yanfengbo
     */
    private String transferSts;

    /**
     * @Fields  : 保险处置方式
     * @author yanfengbo
     */
    private String insurancDealType;

    /**
     * @Fields  : 发动机号
     * @author yanfengbo
     */
    private String engineNo;

    /**
     * @Fields  : 车牌号
     * @author yanfengbo
     */
    private String vehicleLicenseNo;

    /**
     * @Fields  : 合同生效日期
     * @author yanfengbo
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date contractValidDate;

    /**
     * @Fields  : 还款状态（结清状态）
     * @author yanfengbo
     */
    private String paymentSts;

    /**
     * @Fields  : 出租人
     * @author yanfengbo
     */
    private String belongGroup;

    /**
     * @Fields  : 承租人
     * @author yanfengbo
     */
    private String cstmName;

    /**
     *  @Fields 保险失效日
     *  @author yanfengbo
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date validEndDay;

    /**
     * @Fields  : 保险公司名称
     * @author yanfengbo
     */
    private String insCompName;

    /**
     * @Fields  : 商业险保单号
     * @author yanfengbo
     */
    private String insPolicyNo;

    /**
     * @Fields  : 投保生效日
     * @author yanfengbo
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date validStartDay;

    /**
     * @Fields  : 保单实际金额
     * @author yanfengbo
     */
    private BigDecimal insFee;

    /**
     * @Fields  : 退保金额
     * @author fangshaofeng
     */
    private BigDecimal retreatsAmount;

    /**
     * @Fields  : 过户手续费
     * @author fangshaofeng
     */
    private BigDecimal transferCost;

    /**
     * @Fields  : 保证金
     * @author fangshaofeng
     */
    private BigDecimal deposit;

    /**
     * @Fields  : 过户保证金
     * @author fangshaofeng
     */
    private BigDecimal transferDeposit;

    /**
     * @Fields  : 费用总额
     * @author fangshaofeng
     */
    private BigDecimal totalCost;

    /**
     * @Fields  : 险种类型
     * @author fangshaofeng
     */
    private String insuranceType;

    /**
     * @Fields  : 险种信息
     * @author fangshaofeng
     */
    private String insuranceSelectInfo;

    /**
     * @Fields  : 备注
     * @author fangshaofeng
     */
    private String remark;

    /**
     * @Fields  : 过户退保任务号
     * @author fangshaofeng
     */
    private String retreatsNo;

    /**
     * @Fields  : 过户退保任务id
     * @author fangshaofeng
     */
    private String taskId;

    /**
     * @Fields  : 退保处理状态
     * @author fangshaofeng
     */
    private String retreatsHandleSts;

    /**
     * @Fields  : 退保当前节点
     * @author fangshaofeng
     */
    private String retreatsPresentUser;

    /**
     * @Fields  : 实收总金额
     */
    private BigDecimal receiptsAmount;

    /**
     * @Fields  : 财务收款表
     */
    List<ContReceipt> contReceiptList;

    /**
     * @Fields  :付款表id
     * @author yanfengbo
     */
    private String contPayId;

    /**
     * @Fields  :理赔收款开户行
     * @author yanfengbo
     */
    private String retreatsRecAccBank;

    /**
     * @Fields  :理赔收款开户分行
     * @author yanfengbo
     */
    private String retreatsRecAccBranch;
    /**
     * @Fields  :理赔收款户名
     * @author yanfengbo
     */
    private String retreatsRecAccountName;

    /**
     * @Fields  :理赔收款账户
     * @author yanfengbo
     */
    private String retreatsRecAccountNo;

    /**
     * @Fields  :付款银行
     * @author yanfengbo
     */
    private String payAccBank;

    /**
     * @Fields  :付款账户
     * @author yanfengbo
     */
    private String payAccountNo;

    /**
     * @Fields  :付款帐户名
     * @author yanfengbo
     */
    private String payAccountName;

    /**
     * @Fields  : 付款银行分行
     * @author yanfengbo
     */
    private String payAccBranch;

    /**
     * @Fields  : 操作分类
     */
    private String actType;
}