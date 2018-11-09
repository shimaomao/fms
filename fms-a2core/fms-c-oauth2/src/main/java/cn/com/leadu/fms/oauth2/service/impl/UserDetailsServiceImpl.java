package cn.com.leadu.fms.oauth2.service.impl;

import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.oauth2.pojo.vo.SysUserDetailsVo;
import cn.com.leadu.fms.oauth2.pojo.vo.SysUserVo;
import cn.com.leadu.fms.oauth2.rpc.system.SysUserRpc;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: SysUserService
 * @Description: 用户service
 * @date 2018/1/7
 */
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private SysUserRpc sysUserRpc;

    /**
     * @Title:
     * @Description: 通过username加载用户信息
     * @param username
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/07 08:12:30
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            SysUserVo sysUserVo = null;
            try {
                Map<String,Object> sysUserMap = ResponseEntityUtils.getRestResponseData(sysUserRpc.findSysUserByUsername(username));
                sysUserVo = JSON.parseObject(JSON.toJSONString(sysUserMap),SysUserVo.class);
            }catch (FmsRpcException ex){
                ex.printStackTrace();
                log.error(ex.getMessage());
            }
            if (sysUserVo == null || StringUtils.notEquals(username,sysUserVo.getUser())) {
                throw new UsernameNotFoundException(String.format("%s用户名不存在", username));
            }
//            SysUserDetailsVo sysUserDetailsVo = EntityUtils.getEntity(sysUserVo, new SysUserDetailsVo());
            SysUserDetailsVo sysUserDetailsVo = getSysUserDetailsVo(sysUserVo);
            if (sysUserDetailsVo == null || StringUtils.notEquals(username,sysUserDetailsVo.getUsername())) {
                throw new UsernameNotFoundException(String.format("%s用户名不存在", username));
            }
            if (StringUtils.isNotTrimBlank(sysUserVo.getRoleNames())) {
                List<String> roleNames = StringUtils.splitToList(StringUtils.COMMA,sysUserVo.getRoleNames());
                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                if(ArrayUtils.isNotNullAndLengthNotZero(roleNames)) {
                    for (String roleName : roleNames) {
                        authorities.add(new SimpleGrantedAuthority(roleName));
                    }
                }
                sysUserDetailsVo.setAuthorities(authorities);
            }
            return sysUserDetailsVo;
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw ex;
        }
    }

    /**
     * @Title:
     * @Description: 将sysUserVo数据转化为SysUserDetailsVo数据
     * @param sysUserVo
     * @returnSysUserDetailsVo
     * @throws
     * @author wangxue
     * @date 2018/03/17 08:12:30
     */
    private SysUserDetailsVo getSysUserDetailsVo(SysUserVo sysUserVo) {
        if (sysUserVo != null) {
            SysUserDetailsVo sysUserDetailsVo = new SysUserDetailsVo();
            sysUserDetailsVo.setUsername(sysUserVo.getUser());
            sysUserDetailsVo.setPassword(sysUserVo.getUserPassword());
            return sysUserDetailsVo;
        }
        return null;
    }

}
