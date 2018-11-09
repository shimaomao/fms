package cn.com.leadu.fms.oauth2.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.oauth2.service.Oauth2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Collection;
import java.util.Map;

@Controller
public class Oauth2Controller {

    @Autowired
    private Oauth2Service oauthService;

    @RequestMapping(value = "/oauth/v1", method = RequestMethod.GET)
    @ResponseBody
    public String v1() throws Exception {
        return "v1";
    }

    @RequestMapping(value = "/oauth/v2", method = RequestMethod.GET)
    @ResponseBody
    public String v2() throws Exception {

        return "v2";
    }

    @RequestMapping(value = "/oauth/v3", method = RequestMethod.GET)
    @ResponseBody
    public String v3() throws Exception {

        return "v3";
    }

    @RequestMapping(value = "/oauth/revoke_token", method = RequestMethod.DELETE)
    public ResponseEntity<Void> revokeToken(HttpServletRequest request)
            throws Exception {
        return oauthService.revokeToken(request);
    }

    @RequestMapping(value = "/oauth/users/{user}/tokens/{token}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> revokeToken(@PathVariable String user, @PathVariable String token, Principal principal)
            throws Exception {
        return oauthService.revokeToken(user, token, principal);
    }

    @RequestMapping("/oauth/clients/{client}/tokens")
    @ResponseBody
    public Collection<OAuth2AccessToken> listTokensForClient(@PathVariable String client)
            throws Exception {
        return oauthService.listTokensForClient(client);
    }

    @RequestMapping("/oauth/clients/{client}/users/{user}/tokens")
    @ResponseBody
    public Collection<OAuth2AccessToken> listTokensForUser(@PathVariable String client, @PathVariable String user,
                                                           Principal principal) throws Exception {
        return oauthService.listTokensForUser(client, user, principal);
    }

    @RequestMapping(value = "/oauth/users/getTokenExpiresIn",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Integer> getTokenExpiresIn(Principal principal,HttpServletRequest request){
        Integer result = oauthService.getTokenExpiresIn(principal);
        return new ResponseEntity<Integer>(result,HttpStatus.OK);
    }

    @RequestMapping(value = "/oauth/users/setTokenExpiresIn",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> setTokenExpiresIn(OAuth2Authentication authentication,String requestUrl){
        return oauthService.setTokenExpiresIn(authentication,requestUrl);
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
    @RequestMapping(value = "/oauth/findCodeByTimeStamp",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<RestResponse> setTokenExpiresIn(String timeStamp){
        return oauthService.findCodeByTimeStamp(timeStamp);
    }

}
