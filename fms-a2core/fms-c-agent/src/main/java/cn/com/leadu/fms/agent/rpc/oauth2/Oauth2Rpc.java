package cn.com.leadu.fms.agent.rpc.oauth2;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by qiaohao on 2017/11/14.
 */
@FeignClient("${fms.feigns.serverNames.fmsOauth2}")
public interface Oauth2Rpc {

    @RequestMapping(value = "/oauth/users/getTokenExpiresIn",method = RequestMethod.POST)
    ResponseEntity<Integer> getTokenExpiresIn(@RequestHeader("Authorization") String token);

}
