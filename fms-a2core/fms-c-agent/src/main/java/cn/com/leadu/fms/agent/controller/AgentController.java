package cn.com.leadu.fms.agent.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qiaohao on 2017/10/25.
 */
@RestController
@RequestMapping("agent")
public class AgentController {

    @RequestMapping("hello")
    public String hello(){
        OAuth2Authentication principal = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        String authName = principal.getName();
        return "hello,"+authName;
    }

}
