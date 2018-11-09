package cn.com.leadu.fms.cost.service;

import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.cost.vo.monthlysettlementApprove.MonthlySettlementApproveVo;

/**
 * @author yangyiquan
 * @ClassName: MonthlySettlementService
 * @Description: gps月结审批业务层
 * @date 2018-05-28
 */
public interface MonthlySettlementApproveService {

    /** 
    * @Description: 审批操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/30 16:39
    */ 
    void approval(MonthlySettlementApproveVo monthlySettlementApproveVo);

    /** 
    * @Description: 审批共同操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/5 15:24
    */ 
    void approveCommon(MonthlySettlementApproveVo monthlySettlementApproveVo, String act, ActRuTaskVo actRuTaskVo);
}
