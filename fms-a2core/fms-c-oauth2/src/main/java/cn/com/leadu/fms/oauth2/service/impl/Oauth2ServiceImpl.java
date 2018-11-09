package cn.com.leadu.fms.oauth2.service.impl;

import cn.com.leadu.fms.common.util.RandomUtils;
import cn.com.leadu.fms.extend.config.WebProperties;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.oauth2.common.constant.TokenConstants;
import cn.com.leadu.fms.oauth2.common.constant.enums.Oauth2RedisKeyEnums;
import cn.com.leadu.fms.oauth2.service.Oauth2Service;
import cn.com.leadu.fms.oauth2.service.RedisService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.common.DefaultExpiringOAuth2RefreshToken;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.*;

@Service
public class Oauth2ServiceImpl implements Oauth2Service {

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private RedisTokenStore redisTokenStore;

    @Autowired
    private ConsumerTokenServices tokenServices;

    @Autowired
    private TokenConstants tokenConstants;

    @Autowired
    private RedisService redisService;

    public ResponseEntity<Void> revokeToken(HttpServletRequest request)
            throws Exception {

        String authHeader = request.getHeader("Authorization");
        if (authHeader == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        String tokenValue = authHeader.replace("Bearer", "").trim();
        if (tokenServices.revokeToken(tokenValue)) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Void> revokeToken(@PathVariable String user, @PathVariable String token, Principal principal)
            throws Exception {
        checkResourceOwner(user, principal);
        if (tokenServices.revokeToken(token)) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    public Collection<OAuth2AccessToken> listTokensForClient(@PathVariable String client) throws Exception {
        return enhance(tokenStore.findTokensByClientId(client));
    }

    public Collection<OAuth2AccessToken> listTokensForUser(@PathVariable String client, @PathVariable String user,
                                                           Principal principal) throws Exception {
        checkResourceOwner(user, principal);
        return enhance(tokenStore.findTokensByClientIdAndUserName(client, user));
    }

    private void checkResourceOwner(String user, Principal principal) {
        if (principal instanceof OAuth2Authentication) {
            OAuth2Authentication authentication = (OAuth2Authentication) principal;
            if (!authentication.isClientOnly() && !user.equals(principal.getName())) {
                throw new AccessDeniedException(String.format("User '%s' cannot obtain tokens for system '%s'",
                        principal.getName(), user));
            }
        }
    }

    private Collection<OAuth2AccessToken> enhance(Collection<OAuth2AccessToken> tokens) {
        Collection<OAuth2AccessToken> result = new ArrayList<OAuth2AccessToken>();
        for (OAuth2AccessToken prototype : tokens) {
            DefaultOAuth2AccessToken token = new DefaultOAuth2AccessToken(prototype);
            OAuth2Authentication authentication = tokenStore.readAuthentication(token);
            if (authentication == null) {
                continue;
            }
            String clientId = authentication.getOAuth2Request().getClientId();
            if (clientId != null) {
                Map<String, Object> map = new HashMap<String, Object>(token.getAdditionalInformation());
                map.put("client_id", clientId);
                token.setAdditionalInformation(map);
                result.add(token);
            }
        }
        return result;
    }

    public Integer getTokenExpiresIn(Principal principal){
        if (principal instanceof OAuth2Authentication) {
            OAuth2Authentication authentication = (OAuth2Authentication) principal;
            return tokenStore.getAccessToken(authentication).getExpiresIn();
        }else{
            return null;
        }
    }


    public ResponseEntity<Map<String,Object>> setTokenExpiresIn(OAuth2Authentication authentication,String requestUrl){
        //判断url是否不需要token续时
        if(WebProperties.isTokenTime(requestUrl)) {
            DefaultOAuth2AccessToken oAuth2AccessToken = (DefaultOAuth2AccessToken) redisTokenStore.getAccessToken(authentication);
            oAuth2AccessToken.setExpiration(new Date(System.currentTimeMillis() + (long) tokenConstants.getTokenTimeSecondsAccess() * 60 * 1000));
            DefaultExpiringOAuth2RefreshToken oAuth2RefreshToken = (DefaultExpiringOAuth2RefreshToken) oAuth2AccessToken.getRefreshToken();
            DefaultExpiringOAuth2RefreshToken tmpToken = new DefaultExpiringOAuth2RefreshToken(oAuth2RefreshToken.getValue(), new Date(System.currentTimeMillis() + (long) tokenConstants.getTokenTimeSecondsRefresh() * 60 * 1000));
            oAuth2AccessToken.setRefreshToken(tmpToken);
            redisTokenStore.storeAccessToken(oAuth2AccessToken, authentication);
            redisTokenStore.storeRefreshToken(tmpToken, authentication);
        }
        Map<String,Object> result = new HashedMap();
        result.put("result","success");
        return new ResponseEntity<Map<String,Object>>(result,HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据时间戳获取登录验证码，
     * @param timeStamp 时间戳
     * @return
     * @throws
     * @author wangxue
     * @date 2018/03/19 09:47:25
     */
    @Override
    public ResponseEntity<RestResponse> findCodeByTimeStamp(String timeStamp) {
        // 生成一个四位的随机验证码
        String code = "" + RandomUtils.getRandNum(1000, 9999);
        redisService.save(Oauth2RedisKeyEnums.FMS_OAUTH2_USER_REGISTER_CODE.getPrefix() + timeStamp, code, 60*60);
        ResponseEntity responseEntity = new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(code), HttpStatus.OK);
        return responseEntity;
    }
}
