package cn.com.leadu.fms.finance.service;/**
 * Created by yyq on 2018/6/2.
 */

import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.cost.vo.monthlysettlementApprove.MonthlySettlementApproveVo;

/**
 * @program: fms
 * @description: gps月结付款service
 * @author: yangyiquan
 * @create: 2018-06-02 13:59
 **/
public interface GpsMonthlyPayService {
    
    /** 
    * @Description: Gps月结制单
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/2 14:01
    */ 
    void makeVoucher(MonthlySettlementApproveVo monthlySettlementApproveVo);

    /** 
    * @Description: Gps月结财务付款 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/4 12:04
    */ 
    void payment(MonthlySettlementApproveVo monthlySettlementApproveVo);

    /** 
    * @Description: 审批共同操作 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/5 15:55
    */ 
    void approveCommon(MonthlySettlementApproveVo monthlySettlementApproveVo, String act, ActRuTaskVo actRuTaskVo);

    /**
     * @Title:
     * @Description: gps月结付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public String printGpsMonthly(MonthlySettlementApproveVo monthlySettlementApproveVo);
}
