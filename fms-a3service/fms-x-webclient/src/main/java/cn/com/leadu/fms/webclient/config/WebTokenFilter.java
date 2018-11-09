package cn.com.leadu.fms.webclient.config;

import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.util.UrlMatchingUtils;
import cn.com.leadu.fms.extend.config.WebProperties;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.webclient.common.util.CookieUtils;
import cn.com.leadu.fms.webclient.oauth2.rpc.Oauth2Rpc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: WebTokenFilter
 * @Description: 延长web token时长和验证
 * @date 2018/1/15
 */
@Slf4j
public class WebTokenFilter implements Filter {

    @Autowired
    private WebProperties webProperties;

    @Autowired
    private Oauth2Rpc oauth2Rpc;

    private String[] prefixIgnores;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //将被过滤的资源  不用鉴权
        resource("/","/index.html","/css/**","/fonts/**",
                "/img/**","/js/**","/l10n/**","/tpl/**","/vendor/**","/oauth2/**");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try{
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            boolean result = false;
            /**
             * 如果不在过滤的资源中
             */
            String requestUri = request.getRequestURI();
            boolean ignores = UrlMatchingUtils.matching(requestUri,prefixIgnores);
            if(ignores){
                //拿到token
                String token = CookieUtils.getCookieValue(webProperties.getLoginUserHeader());
                if(StringUtils.isNotTrimBlank(token)){
                    //鉴权
                    ResponseEntity<RestResponse> responseEntity = oauth2Rpc.setTokenExpiresIn("Bearer "+token,requestUri);

                    //请求成功
                    if(responseEntity != null && ResponseEnums.SUCCESS.getCode().equals(responseEntity.getBody().getCode())){
                        //并且返回的格式正确
                        if(responseEntity.getBody().getData() instanceof Map){
                            Map resultMap = (Map) responseEntity.getBody().getData();
                            //延时成功正确
                            if(ResponseEnums.SUCCESS.getMark().equals(resultMap.get("result")))
                                result = true;
                        }
                    }
                }
            }else{
                result = true;
            }
            if(result)
                filterChain.doFilter(servletRequest,servletResponse);
            else{
                //鉴权失败返回401
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
            }
        }catch (Exception ex){
            ex.printStackTrace();
            log.error(ex.getMessage());
            //鉴权失败返回401
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
    }

    @Override
    public void destroy() {

    }

    public void resource(String ...params){
        prefixIgnores = params;
    }

}

