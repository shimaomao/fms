package cn.com.leadu.fms.finance.service;

import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.cost.vo.monthlypilferinsurance.PilferInsuranceApproveVo;

/**
 * @program: fms
 * @description: 盗抢险月结付款service
 * @author: yangyiquan
 * @create: 2018-06-04 18:16
 **/
public interface PilferMonthlyPayService {
    /** 
    * @Description:  盗抢险月结财务制单
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/4 18:16
    */ 
    void makeVoucher(PilferInsuranceApproveVo pilferInsuranceApproveVo);

    /** 
    * @Description: 盗抢险月结财务付款 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/4 18:17
    */ 
    void payment(PilferInsuranceApproveVo pilferInsuranceApproveVo);

    /** 
    * @Description: 审批共同操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/5 21:12
    */ 
    void approveCommon(PilferInsuranceApproveVo pilferInsuranceApproveVo, String act, ActRuTaskVo actRuTaskVo);

    /**
     * @Title:
     * @Description: 盗抢险月结付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    String printPilferMonthly(PilferInsuranceApproveVo pilferInsuranceApproveVo);
}
