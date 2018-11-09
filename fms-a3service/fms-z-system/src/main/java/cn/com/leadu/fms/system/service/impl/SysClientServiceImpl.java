package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.SysClientRepository;
import cn.com.leadu.fms.pojo.system.entity.SysClient;
import cn.com.leadu.fms.system.service.SysClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author qiaomengnan
 * @ClassName: SysClientServiceImpl
 * @Description:    客户端表示service实现类
 * @date 2018/3/6
 */
@Service
public class SysClientServiceImpl implements SysClientService {

    @Autowired
    private SysClientRepository sysClientRepository;

    /**
     * @Title:
     * @Description:   通过clientId获取客户端标识对象
     * @param clientId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/06 08:56:58
     */
    public SysClient findSysClientByClientId(String clientId){
        Example example = SqlUtil.newExample(SysClient.class);
        example.createCriteria()
                .andEqualTo("clientId",clientId);
        SysClient sysClient = sysClientRepository.selectOneByExample(example);
        return sysClient;
    }

}
