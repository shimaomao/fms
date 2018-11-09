package cn.com.leadu.fms.oauth2.service.impl;

import cn.com.leadu.fms.oauth2.rpc.system.SysUserRpc;
import cn.com.leadu.fms.oauth2.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息的service实现类.
 * Created by wangxue on 2018/4/4.
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRpc sysUserRpc;

    /**
     * @Title:
     * @Description:  更新用户最后登录时间
     * @param user
     * @return
     * @throws
     * @author wangxue
     * @date 2018/04/4 13:46:05
     */
    @Override
    public void modifyLastLoginTime(String user) {
        sysUserRpc.modifyLastLoginTime(user);
    }
}
