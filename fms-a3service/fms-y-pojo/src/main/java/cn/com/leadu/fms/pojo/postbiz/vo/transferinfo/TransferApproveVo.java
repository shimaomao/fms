package cn.com.leadu.fms.pojo.postbiz.vo.transferinfo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: TransferInfoVo
 * @Description: 过户流程载体
 * @date 2018-09-5
 */
@Data
public class TransferApproveVo {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 过户任务号
     * @author wangxue
     */
    private String transferNo;

    /**
     * @Fields  : 当前处理用户
     * @author wangxue
     */
    private String user;

    /**
     * @Fields  : 备注
     * @author wangxue
     */
    private String remark;

    /**
     * @Fields  : 流程任务ID
     * @author wangxue
     */
    private String taskId;

    /**
     * @Fields  : 流程节点
     * @author wangxue
     */
    private String taskDefinitionKey;

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
     * @Fields  :  付款联行号
     */
    private String payEleBankNo;

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
     * @Fields  : 收款联行号
     */
    private String recEleBankNo;

    /**
     * @Fields  : 出租人
     * @author wangxue
     */
    private String belongGroup;

    /**
     * @Fields  : 承租人
     * @author wangxue
     */
    private String cstmName;

    /******************************    确认收款信息    *****************/
    /**
     * @Fields  : 应收总额
     */
    private BigDecimal chargeAmount;

    /**
     * @Fields  : 实收总金额
     */
    private BigDecimal receiptActualAmount;

    /**
     * @Fields: 收款明细
     */
    private List<TransferReceiptVo> receiptVoList;

}
