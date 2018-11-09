package cn.com.leadu.fms.webclient.config;

import cn.com.leadu.fms.common.util.UrlMatchingUtils;
import cn.com.leadu.fms.extend.config.WebProperties;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author qiaomengnan
 * @ClassName: WebClientFeignConfig
 * @Description: 放入本次用户的token
 * @date 2018/1/14
 */
@Component
public class WebClientFeignConfig implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        /**
         * 不在权限过滤中的url需要带上token
         */
        if(WebProperties.isAuthorization(requestTemplate.request().url())) {
            requestTemplate.header(WebProperties.AUTHORIZATION, WebProperties.getLoginUserBearerCookieValue());
        }
    }

}
