package cn.com.leadu.fms.pojo.finance.vo.contrepaysked;/**
 * Created by ningyangyang on 2018/5/22.
 */

import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Title: fms
 * @Description:
 * @author: ningyangyang
 * @date 2018/5/22 19:48
 */
@Data
public class ContRepaySkedInfoVo extends PageQuery<ContRepaySked> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 还款计划表ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
    private String repaySkedId;

    /**
     * @Fields  : 合同编号
     */
    private String contNo;

    /**
     * @Fields  : 期数
     */
    private Integer period;

    /**
     * @Fields  : 成交日期
     */
    private Date dealDate;

    /**
     * @Fields  : 收款日期
     */
    private Date repayDate;

    /**
     * @Fields  : 月利率
     */
    private BigDecimal intrstMonthRate;

    /**
     * @Fields  : 每期客户租金
     */
    private BigDecimal rent;

    /**
     * @Fields  : 当期本金
     */
    private BigDecimal principal;

    /**
     * @Fields  : 当期利息
     */
    private BigDecimal interest;

    /**
     * @Fields  : 手续费用
     */
    private BigDecimal charge;

    /**
     * @Fields  : 当期剩余本金
     */
    private BigDecimal restPrincipal;

    /**
     * @Fields  : 扣款状态
     */
    private String repayStatus;

    /**
     * @Fields  : 逾期状态
     */
    private String overdueStatus;

    /**
     * @Fields  : 暂不扣款标志
     */
    private String repayFlag;

    /**
     * @Fields  : 收款银行
     */
    private String recAccBank;

    /**
     * @Fields  : 收款账号
     */
    private String recAccountNo;

    /**
     * @Fields  : 收款户名
     */
    private String recAccountName;

    /**
     * @Fields  : 保证金
     */
    private BigDecimal deposit;

    /**
     * @Fields  : 每期客户实际租金
     */
    private BigDecimal rentActual;

    /**
     * @Fields  : 到账日期
     */
    private Date receiptDate;




    /**
     * @Fields  : 最早逾期合同
     */
    private Date minDate;

    /**
     * @Fields  : 逾期期数
     */
    private Integer overduePeriods;

    /**
     * @Fields  : 当前逾期本金
     */
    private BigDecimal overduePrincipal;

    /**
     * @Fields  : 当前逾期租金
     */
    private BigDecimal overdueRent;

}
