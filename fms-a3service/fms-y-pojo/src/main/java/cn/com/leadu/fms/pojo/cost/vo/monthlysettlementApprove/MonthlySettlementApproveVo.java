package cn.com.leadu.fms.pojo.cost.vo.monthlysettlementApprove;/**
 * Created by yyq on 2018/5/30.
 */

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.cost.entity.MonthlySettlement;
import cn.com.leadu.fms.pojo.cost.vo.gpsdispatch.GpsDispatchMonthlyVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import lombok.Data;

import java.util.List;

/**
 * @program: fms
 * @description: 月结审批Vo
 * @author: yangyiquan
 * @create: 2018-05-30 15:29
 **/
@Data
public class MonthlySettlementApproveVo extends PageQuery<MonthlySettlement> {
    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 月结任务号
     */
    private String monthlySettlementNo;

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
     * @Fields ; 通过还是退回标志，1-通过，0-退回
     */
    private String approvalFlag;

    /**
     * @Fields  :付款银行
     */
	private String payAccBank;

    /**
     * @Fields  :付款银行
     */
    private String payAccBranch;
    /**
     * @Fields  :付款账户
     */
	private String payAccountNo;

    /**
     * @Fields  :付款帐户名
     */
	private String payAccountName;

    /**
     * @Fields  :付款联行名
     */
    private String payEleBankNo;

    /**
     * @Fields  :付款表id
     */
    private String contPayId;

    /**
     * @Fields  :财务付款数据
     */
    private ContPay contPay;

    /**
     * @Fields  :月结明细数据
     */
    private List<GpsDispatchMonthlyVo> gpsDispatchMonthlyVo;
}
