package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.pojo.postbiz.vo.capitalasstes.CapitalAssetsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.vehicledisposal.VehicleDisposalVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

/**
 * @author huzongcheng
 * @ClassName: CapitalAssetsTaskService
 * @Description: 转固定资产任务业务层
 */
public interface CapitalAssetsTaskService {

    /**
     * @param vo      参数实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 转固定资产申请发起
     * @author huzongcheng
     */
    String submitCapitalAssets(VehicleDisposalVo vo, SysUser sysUser);

    /**
     * @param vo      参数实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 总经理审批
     * @author huzongcheng
     */
    void approve(CapitalAssetsVo vo, SysUser sysUser);

}
