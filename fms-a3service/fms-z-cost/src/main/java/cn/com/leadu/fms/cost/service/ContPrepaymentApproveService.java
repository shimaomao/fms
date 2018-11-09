package cn.com.leadu.fms.cost.service;/**
 * Created by yyq on 2018/5/16.
 */

import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.cost.vo.contprepaymentApprove.ContPrepaymentApproveVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;

/**
 * @program: fms
 * @description: 提前还款审批service
 * @author: yangyiquan
 * @create: 2018-05-16 15:02
 **/
public interface ContPrepaymentApproveService {
    
    /** 
    * @Description:  提前还款审批通过
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/16 15:17
    */ 
    void approval(ContPrepaymentApproveVo contPrepaymentApproveVo);

    /**
    * @Description: 提前还款审批退回
    * @param:
    * @return:
    * @Author: yangyiquan
    * @Date: 2018/5/16 15:17
    */
    void sendBack(ContPrepaymentApproveVo contPrepaymentApproveVo);

    /**
     * @Description: 审批共通操作
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/16 16:15
     */
    void contPrepaymentApproveCommon(ContPrepaymentApproveVo contPrepaymentApproveVo, String act, ActRuTaskVo actRuTaskVo);

    /** 
    * @Description: 财务确认
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/20 15:01
    */ 
    void receiptConfirm(ContPrepaymentApproveVo contPrepaymentApproveVo);

    /**
     * @Description: 根据业务code和业务类型 获取财务付款信息
     * @param: bizCode
     * @param: paymentType
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/16 15:17
     */
    ContPay findContPayByBizCode(String bizCode, String paymentType);
}
