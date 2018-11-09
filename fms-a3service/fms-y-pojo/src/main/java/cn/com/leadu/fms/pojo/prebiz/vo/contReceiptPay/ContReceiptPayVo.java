package cn.com.leadu.fms.pojo.prebiz.vo.contReceiptPay;/**
 * Created by yyq on 2018/6/12.
 */

import cn.com.leadu.fms.pojo.finance.entity.ContCharge;
import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import cn.com.leadu.fms.pojo.finance.vo.contcharge.ContChargeReceiptVo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: fms
 * @description: 合同财务收款vo
 * @author: yangyiquan
 * @create: 2018-06-12 21:22
 **/
@Data
public class ContReceiptPayVo {
    /**
     * @Fields  :  任务id
     */
    private String taskId;
    /**
     * @Fields  : 备注
     */
    private String memo;

    /**
     * @Fields  : 当前用户
     */
    private String user;

    /**
     * @Fields  :  合同号
     * @author yangyiquan
     */
    private String contNo;
    /**
     * @Fields  :  申请号
     * @author yangyiquan
     */
    private String applyNo;

    /**
     * @Fields  :  姓名
     * @author yangyiquan
     */
    private String personName;
    /**
     * @Fields  :  出租人
     * @author yangyiquan
     */
    private String rentName;

    /**
     * @Fields  :  出租人区域
     * @author yangyiquan
     */
    private String voucherGroup;

    /**
     * @Fields  : 车架号
     * @author yangyiquan
     */
    private String vinNo;

    /**
     * @Fields  : 首期租金
     */
    private BigDecimal rent;

    /**
     * @Fields  : 是否收首期租金
     */
    private String  chargeFirstRent;

    /**
     * @Fields  : 首付款
     */
    private BigDecimal initAmount;
    /**
     * @Fields  : 保证金
     */
    private BigDecimal deposit;
    /**
     * @Fields  : 续保押金
     */
    private BigDecimal renewalDeposit;
    /**
     * @Fields  : 手续费用
     */
    private BigDecimal charge;
    /**
     * @Fields  : 定金金额
     */
    private BigDecimal vehDeposit;
    /**
     * @Fields  : 抵扣金额
     */
    private BigDecimal chargeDeductionAmount;
    /**
     * @Fields  : 定金是否抵扣车款
     */
    private String deductibleFees;
    /**
     * @Fields  : 应收总款金额
     * @author ningyangyang
     */
    private BigDecimal totalAmount;
    /**
     * @Fields  : 实收总款金额
     * @author ningyangyang
     */
    private BigDecimal totalActualAmount;

    /**
     * @Fields  : 财务待收款表
     */
    List<ContCharge> contChargeList;
    /**
     * @Fields  : 财务收款表
     */
    List<ContReceipt> contReceiptList;

    /**
     * @Fields  : 财务待收款表和收款表关联
     */
    List<ContChargeReceiptVo> contChargeReceiptVoList;



}
