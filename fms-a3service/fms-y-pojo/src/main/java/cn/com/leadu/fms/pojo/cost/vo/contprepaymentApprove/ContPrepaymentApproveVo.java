package cn.com.leadu.fms.pojo.cost.vo.contprepaymentApprove;/**
 * Created by yyq on 2018/5/16.
 */

import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import com.sun.star.bridge.oleautomation.Decimal;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @program: fms
 * @description: 提前还款审批vo
 * @author: yangyiquan
 * @create: 2018-05-16 14:38
 **/
@Data
public class ContPrepaymentApproveVo {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 提前还款业务号
     * @author yangyiquan
     */
    private String contPrepaymentNo;

    /**
     * @Fields  :
     */
    private String contNo;

    /**
     * @Fields  :
     */
    private String memo;

    /**
     * @Fields  :
     */
    private String user;

    /**
     * @Fields  :
     */
    private String taskId;

    /**
     * @Fields  : 流程节点
     */
    private String taskDefinitionKey;

    /**
     * @Fields  : 实收总金额
     * @author yangyiquan
     */
    private BigDecimal receiptActualAmount;

    /**
     * @Fields  : 财务收款表
     */
    List<ContReceipt> contReceiptList;

    /**
     * @Fields  :  付款银行
     */
    private String payAccBank;

    /**
     * @Fields  :  付款银行分行
     */
    private String payAccBranch;
    /**
     * @Fields  : 付款账号
     */
    private String payAccountNo;

    /**
     * @Fields  : 付款户名
     */
    private String payAccountName;


    /**
     * @Fields  :  收款银行
     */
    private String recAccBank;

    /**
     * @Fields  :  收款银行分行
     */
    private String recAccBranch;
    /**
     * @Fields  :  收款账号
     */
    private String recAccountNo;

    /**
     * @Fields  :  收款户名
     */
    private String recAccountName;

    /**
     * @Fields  : 承租人
     */
    private String name;

    /**
     * @Fields  : 出租人
     */
    private String rentPerson;

    /**
     * @Fields  : 车架号
     */
    private String vinNo;

    /**
     * @Fields  : 实际总金额
     */
    private BigDecimal prepayActualAmount;

    /**
     * @Fields  : 实付总金额
     * @author yangyiquan
     */
    private BigDecimal payActualAmount;

    /**
     * @Fields  : 过户费用总额
     * @author wangxue
     */
    private BigDecimal transferTotalCost;
}
