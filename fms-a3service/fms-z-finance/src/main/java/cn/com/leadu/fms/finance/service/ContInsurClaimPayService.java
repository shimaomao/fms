package cn.com.leadu.fms.finance.service;

import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.insurance.vo.continsurclaim.ContInsurClaimVo;

/**
 * @author yanfengbo
 * @ClassName:
 * @Description: 保险理赔制单付款Service
 * @date
 */
public interface ContInsurClaimPayService {
    /**
     * @Description: 保险理赔制单
     * @param:
     * @return:
     * @Author: yanfengbo
     * @Date: 2018/6/2 14:01
     */
    void makeVoucher(ContInsurClaimVo contInsurClaimVo);

    /**
     * @Description: 保险理赔付款
     * @param:
     * @return:
     * @Author: yanfengbo
     * @Date:
     */
    void payment(ContInsurClaimVo contInsurClaimVo);

    /**
     * @Description: 审批共同操作
     * @param:
     * @return:
     * @Author: yanfengbo
     * @Date:
     */
//    void approveCommon(ContInsurClaimVo contInsurClaimVo, String act, ActRuTaskVo actRuTaskVo);

    /**
     * @Title:
     * @Description: 保险理赔付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public String printContInsurClaim(ContInsurClaimVo contInsurClaimVo);
}
