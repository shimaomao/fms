package cn.com.leadu.fms.agent.filter;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.ResponseFailEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiaohao on 2017/12/26.
 */
@Component
public class AccessPostFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccessPostFilter.class);

    private static final String OAUTHFLAG = "/oauth";

    private static final String ERRORINFO = "鉴权失败";

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        requestContext.getResponseDataStream();
        int responseStatusCode = requestContext.getResponseStatusCode();
        try {
            InputStreamReader isr = new InputStreamReader(requestContext.getResponseDataStream());
            BufferedReader br = new BufferedReader(isr);
            StringBuffer responseBody = new StringBuffer();
            String result = "";
            while ((result = br.readLine()) != null) {
                responseBody.append(result);
            }

            RestResponse<Object> resultObject = null;

            if(responseStatusCode == HttpStatus.OK.value()){
                Map<String,Object> token = JSON.parseObject(responseBody.toString());
                resultObject = RestResponseGenerator.genSuccessResponse(new HashMap<>(token));
            }else{

                if (responseStatusCode != HttpStatus.BAD_REQUEST.value()
                        || responseStatusCode != HttpStatus.UNAUTHORIZED.value()) {
                    resultObject = RestResponseGenerator.genFailResponse(ResponseEnums.FAILURE, responseBody.toString(), "请求失败");
                }
                Map<String, Object> response = JSON.parseObject(responseBody.toString());
                LOGGER.error("oauth请求错误:{}",responseBody.toString());
                if (containMessage(response, "Bad credentials")) {
                    resultObject = RestResponseGenerator.genFailResponse(ResponseFailEnums.OAUTH2_ERROR, responseBody.toString(), "客户端密码错误");
                }
                if (containMessage(response, "客户端id不存在")) {
                    resultObject = RestResponseGenerator.genFailResponse(ResponseFailEnums.OAUTH2_ERROR, responseBody.toString(), "客户端账号不存在");
                }
                if(tokenContainMessage(response,"invalid_grant")
                        ||tokenContainMessage(response,"unauthorized")){
                    resultObject = RestResponseGenerator.genFailResponse(ResponseFailEnums.OAUTH2_ERROR, responseBody.toString(), getTokenErrorDesc(response));
                }

            }

            //根据返回内容做具体处理
            requestContext.setResponseDataStream(new ByteArrayInputStream(JSON.toJSONString(resultObject).getBytes()));
        } catch (Exception ex) {
            LOGGER.error("oauth请求异常:",ex);
            requestContext.setResponseDataStream(new ByteArrayInputStream(JSON.toJSONString(RestResponseGenerator.genFailResponse(ResponseEnums.FAILURE, ex.getMessage(), "请求失败")).getBytes()));
        }finally {
            requestContext.setResponseStatusCode(HttpStatus.OK.value());
        }
        return null;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        String requestUri = requestContext.getRequest().getRequestURI();
        int responseStatusCode = requestContext.getResponseStatusCode();
        //oauth2请求的都将进入,定义统一返回格式
        if (requestUri.indexOf(OAUTHFLAG) != -1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public String filterType() {
        return "post";
    }

    private boolean containMessage(Map<String, Object> map, String msg) {
        if (map != null && map.containsKey("message")) {
            String message = (String) map.get("message");
            if (message.contains(msg)) {
                return true;
            }
        }
        return false;
    }

    private boolean tokenContainMessage(Map<String, Object> map, String msg) {
        if (map != null && map.containsKey("error") && map.containsKey("error_description")) {
            String errorvalue  = (String)map.get("error");
            if (errorvalue.contains(msg)) {
                return true;
            }
        }
        return false;
    }

    private String getTokenErrorDesc(Map<String, Object> map){
        return (String)map.get("error_description");

    }
}
