package cn.com.leadu.fms.pojo.finance.vo.contcharge;/**
 * Created by yyq on 2018/7/28.
 */

import cn.com.leadu.fms.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @program: fms
 * @description: 待收款表关联收款表信息
 * @author: yangyiquan
 * @create: 2018-07-28 14:31
 **/
@Data
public class ContChargeReceiptVo {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 财务待收款id
     * @author yangyiquan
     */
    private String contChargeId;

    /**
     * @Fields  : 业务类型
     * @author yangyiquan
     */
    private String chargeBizType;

    /**
     * @Fields  : 业务号
     * @author yangyiquan
     */
    private String chargeBizId;

    /**
     * @Fields  : 款项名称
     * @author yangyiquan
     */
    private String chargeFund;

    /**
     * @Fields  : 应收款金额
     * @author yangyiquan
     */
    private BigDecimal chargeAmount;

    /**
     * @Fields  : 实收款金额
     * @author yangyiquan
     */
    private BigDecimal chargeActualAmount;

    /**
     * @Fields  : 抵扣金额
     * @author ningyangyang
     */
    private BigDecimal chargeDeductionAmount;

    /**
     * @Fields  : 收款状态
     * @author yangyiquan
     */
    private String chargeStatus;

    /**
     * @Fields  : 明细区分
     * @author yangyiquan
     */
    private String chargeDetailFlag;

    /**
     * @Fields  : 备注
     * @author yangyiquan
     */
    private String memo;

    /**
     * @Fields  : 财务待收款id
     * @author yangyiquan
     */
    private List<String> contChargeIds;

    /************************   以下是收款表信息  ************************/
    /**
     * @Fields  : 财务收款Id
     * @author yangyiquan
     */
    private String contReceiptId;

    /**
     * @Fields  : 到账金额
     * @author yangyiquan
     */
    @NotNull(message = "请输入实收金额")
    private BigDecimal receiptAmount;

    /**
     * @Fields  : 收款银行
     * @author yangyiquan
     */
    private String recAccBank;

    /**
     * @Fields  : 收款账号
     * @author yangyiquan
     */
    private String recAccountNo;

    /**
     * @Fields  : 收款户名
     * @author yangyiquan
     */
    private String recAccountName;

    /**
     * @Fields  : 收款联行号
     * @author yangyiquan
     */
    private String recEleBankNo;

    /**
     * @Fields  : 收款银行分行
     * @author yangyiquan
     */
    private String recAccBranch;

    /**
     * @Fields  : 财务科目代码
     * @author yangyiquan
     */
    private String finassSubjectCd;

    /**
     * @Fields  : 财务勾稽表id
     * @author yangyiquan
     */
    private String contReceiptExamId;

    /**
     * @Fields  : 收款备注
     * @author yangyiquan
     */
    private String memoReceipt;

    /**
     * @Fields  : 到账日期
     * @author yangyiquan
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date receiptDate;


}
