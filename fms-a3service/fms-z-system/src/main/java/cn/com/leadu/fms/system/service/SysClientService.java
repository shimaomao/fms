package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.pojo.system.entity.SysClient;

/**
 * @author qiaomengnan
 * @ClassName: SysClientService
 * @Description: 客户端标识service
 * @date 2018/3/6
 */
public interface SysClientService {

    /**
     * @Title:
     * @Description:   通过clientId获取客户端标识对象
     * @param clientId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/06 08:56:58
     */
    SysClient findSysClientByClientId(String clientId);

}
