package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.system.entity.SysUser;

/**
 * @author yanfengbo
 * @ClassName: ContractAutoCancelService
 * @Description: 未生效合同自动取消
 * @date
 */
public interface ContractAutoCancelService {

    /**
     * @Title:
     * @Description: 未生效合同自动取消
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public void contractAutoCancel(SysUser sysUser);
}
