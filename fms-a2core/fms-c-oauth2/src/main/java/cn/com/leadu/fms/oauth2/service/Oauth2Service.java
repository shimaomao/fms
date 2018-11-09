package cn.com.leadu.fms.oauth2.service;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Collection;
import java.util.Map;

public interface Oauth2Service {

    ResponseEntity<Void> revokeToken(HttpServletRequest request) throws Exception;

    ResponseEntity<Void> revokeToken(String user, String token, Principal principal) throws Exception;

    Collection<OAuth2AccessToken> listTokensForClient(String client) throws Exception;

    Collection<OAuth2AccessToken> listTokensForUser(String client, String user, Principal principal) throws Exception;

    Integer getTokenExpiresIn(Principal principal);

    ResponseEntity<Map<String,Object>> setTokenExpiresIn(OAuth2Authentication authentication,String requestUrl);

    /**
     * @Title:
     * @Description:  根据时间戳获取登录验证码，
     * @param timeStamp 时间戳
     * @return
     * @throws
     * @author wangxue
     * @date 2018/03/19 09:47:25
     */
    ResponseEntity<RestResponse> findCodeByTimeStamp(String timeStamp);

}
