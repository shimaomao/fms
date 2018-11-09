package cn.com.leadu.fms.insurance.service;

import cn.com.leadu.fms.pojo.insurance.vo.continsurclaim.ContInsurClaimVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

/**
 * @description:   保险理赔审核
 * @author:ningyangyang
 * @since:2018/5/18
 */
public interface InsurClaimCheckService {

    /**
     * @Title:
     * @Description: 审核通过
     * @param
     * @return void
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 11:52:38
     */
    void  approval(ContInsurClaimVo contInsurClaimVo,SysUser sysUser);
    /**
     * @Title:
     * @Description: 审核退回
     * @param
     * @return void
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 11:52:38
     */
    void sendBack(ContInsurClaimVo contInsurClaimVo,SysUser sysUser);

    /**
     * @Description: 保险理赔财务收款完成
     * @param:
     * @return:
     * @Author: fangshaofeng
     * @Date: 2018/10/19 17:23
     */
    void  Receivables(ContInsurClaimVo contInsurClaimVo,SysUser sysUser);

    /**
     * @Description: 保险理赔财务收款返回上一级
     * @param:
     * @return:
     * @Author: fangshaofeng
     * @Date: 2018/10/22 17:23
     */
    void refunds(ContInsurClaimVo contInsurClaimVo,SysUser sysUser);
}
