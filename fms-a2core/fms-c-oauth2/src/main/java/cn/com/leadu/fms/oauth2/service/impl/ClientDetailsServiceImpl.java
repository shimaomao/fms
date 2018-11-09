package cn.com.leadu.fms.oauth2.service.impl;

import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.oauth2.pojo.vo.SysClientDetailsVo;
import cn.com.leadu.fms.oauth2.pojo.vo.SysClientVo;
import cn.com.leadu.fms.oauth2.rpc.system.SysClientRpc;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

import java.util.*;

@Slf4j
public class ClientDetailsServiceImpl implements ClientDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(ClientDetailsServiceImpl.class);

    @Autowired
    private SysClientRpc sysClientRpc;

    /**
     * @Title:
     * @Description: 通过clientId加载客户端标识信息
     * @param clientId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/07 08:12:53
     */
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        try {
            SysClientVo sysClientVo = null;
            try {
                Map<String,Object> sysClientMap = ResponseEntityUtils.getRestResponseData(sysClientRpc.findSysClientByClientId(clientId));
                sysClientVo = JSON.parseObject(JSON.toJSONString(sysClientMap),SysClientVo.class);
            }catch (FmsRpcException ex){
                ex.printStackTrace();
                log.error(ex.getMessage());
            }
            if (sysClientVo == null || StringUtils.notEquals(clientId,sysClientVo.getClientId())) {
                throw new ClientRegistrationException(String.format("%s客户端id不存在", clientId));
            }
            SysClientDetailsVo sysClientDetailsVo = EntityUtils.getEntity(sysClientVo, new SysClientDetailsVo());
            if (sysClientDetailsVo != null && StringUtils.notEquals(clientId,sysClientDetailsVo.getClientId())) {
                throw new ClientRegistrationException(String.format("%s客户端id不存在", clientId));
            }
            if(sysClientVo.getScopes() != null){
                List<String> scopeList = StringUtils.splitToList(StringUtils.COMMA,sysClientVo.getScopes());
                Set<String> scopes = new HashSet<>();
                if(ArrayUtils.isNotNullAndLengthNotZero(scopeList)){
                    for(String scope : scopeList){
                        scopes.add(scope);
                    }
                }
                sysClientDetailsVo.setScope(scopes);
            }
            if (StringUtils.isNotTrimBlank(sysClientVo.getRoles())) {
                List<String> roles = StringUtils.splitToList(StringUtils.COMMA,sysClientVo.getRoles());
                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                if(ArrayUtils.isNotNullAndLengthNotZero(roles)) {
                    for (String role : roles) {
                        authorities.add(new SimpleGrantedAuthority(role));
                    }
                }
                sysClientDetailsVo.setAuthorities(authorities);
            }
            return sysClientDetailsVo;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw e;
        }
    }

}
