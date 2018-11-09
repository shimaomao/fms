package cn.com.leadu.fms.webclient.oauth2.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author qiaomengnan
 * @ClassName: Oauth2Rpc
 * @Description: oauth2认证远程调用
 * @date 2018/1/9
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface Oauth2Rpc {

    @RequestMapping(value = "api/auth/oauth/token",method = RequestMethod.POST)
    ResponseEntity<RestResponse> oauthToken(@RequestParam("grant_type") String grantType,
                                            @RequestParam("username") String username,
                                            @RequestParam("pwd") String pwd,
                                            @RequestParam("code") String code,
                                            @RequestParam("timeStamp") String timeStamp,
                                            @RequestHeader("authorization") String basic);

    @RequestMapping(value = "api/auth/oauth/users/setTokenExpiresIn",method = RequestMethod.POST)
    ResponseEntity<RestResponse> setTokenExpiresIn(@RequestHeader("authorization") String token,@RequestParam("requestUrl") String requestUrl);

    /**
     * @Title:
     * @Description:  根据时间戳获取登录验证码，
     * @param timeStamp 时间戳
     * @return
     * @throws
     * @author wangxue
     * @date 2018/03/19 09:47:25
     */
    @RequestMapping(value = "api/auth/oauth/findCodeByTimeStamp", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCodeByTimeStamp(@RequestParam("timeStamp") String timeStamp);
}
