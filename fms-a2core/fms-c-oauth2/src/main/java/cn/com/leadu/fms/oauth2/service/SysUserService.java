package cn.com.leadu.fms.oauth2.service;

/**
 * 用户信息的service接口.
 * Created by wangxue on 2018/4/4.
 */
public interface SysUserService {

    /**
     * @Title:
     * @Description:  更新用户最后登录时间
     * @param user
     * @return
     * @throws
     * @author wangxue
     * @date 2018/04/4 13:46:05
     */
    void modifyLastLoginTime(String user);
}
