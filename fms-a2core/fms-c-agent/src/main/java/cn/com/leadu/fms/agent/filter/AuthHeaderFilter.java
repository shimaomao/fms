package cn.com.leadu.fms.agent.filter;

import cn.com.leadu.fms.agent.common.util.AuthUserUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.util.UUIDUtils;
import cn.com.leadu.fms.common.util.UrlMatchingUtils;
import cn.com.leadu.fms.extend.config.WebProperties;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;

/**
 * Created by qiaohao on 2017/9/5.
 */
@Slf4j
@Component
public class AuthHeaderFilter extends ZuulFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthHeaderFilter.class);

	@Autowired
	private AuthUserUtils authUserUtils;

	@Autowired
	private WebProperties webProperties;

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		RequestContext requestContext = RequestContext.getCurrentContext();
		String requestUri = requestContext.getRequest().getRequestURI();
		String [] notAuthUrls = webProperties.getNotAuthUrls();
		boolean result = UrlMatchingUtils.matching(requestUri,notAuthUrls);
		if(!result){
			String chainId = UUIDUtils.getUUID();
			requestContext.addZuulRequestHeader(authUserUtils.getWebProperties().getChainHeader(), chainId);
		}
		return result;
	}

	@Override
	public Object run() {

		String msg = "";
		boolean shouldFilterAuthResult = true;
		RequestContext requestContext = RequestContext.getCurrentContext();
		String chainId = UUIDUtils.getUUID();
		try{
			// 获取当前登录人信息
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String authName = authentication.getName();

			if (StringUtils.isTrimBlank(authName)) {
				shouldFilterAuthResult = false;
				msg = "登录用户不能为空";
				return null;
			}
			String userInfo = authUserUtils.getUser();
			if (StringUtils.isTrimBlank(userInfo)) {
				shouldFilterAuthResult = false;
				msg = "用户不存在";
				return null;
			}
			try {
				if(StringUtils.isNotTrimBlank(userInfo)) {
					requestContext.addZuulRequestHeader(authUserUtils.getWebProperties().getChainHeader(), chainId);
					requestContext.addZuulRequestHeader(authUserUtils.getWebProperties().getLoginUserHeader(), URLEncoder.encode(userInfo, "utf-8"));
				}
			} catch (Exception ex) {
				ex.printStackTrace();
                log.error(ex.getMessage());
				shouldFilterAuthResult = false;
				msg = "发送用户信息失败";
				return null;
			}
			if (StringUtils.isTrimBlank(requestContext.getZuulRequestHeaders().get(authUserUtils.getWebProperties().getLoginUserHeader()))) {
				shouldFilterAuthResult = false;
				msg = "用户不存在";
				return null;
			}

			if (!authUserUtils.urlAuthority(authName, requestContext.getRequest().getRequestURI())) {
				shouldFilterAuthResult = false;
				msg = "无权限访问当前url";
				return null;
			}
		}catch (Exception ex){
			shouldFilterAuthResult = false;
			LOGGER.error("AuthHeaderFilter异常：",ex);
			ex.printStackTrace();
		}finally {
			requestContext.addZuulRequestHeader(authUserUtils.getWebProperties().getChainHeader(), chainId);
			if (!shouldFilterAuthResult) {
				requestContext.setSendZuulResponse(false);
				requestContext.setResponseStatusCode(401);
				requestContext.addZuulResponseHeader("Content-type","application/json;charset=UTF-8");
				requestContext.setResponseBody(JSON.toJSONString(RestResponseGenerator.genFailResponse(msg)));
				requestContext.set("shouldFilterAuthResult", shouldFilterAuthResult);
			}else{
				LOGGER.info(">>>>>>>>>>>>>>This request for the chainId corresponding to the token,token is - {} -"+" ,chainId is - {} -", authUserUtils.getToken(),chainId);
			}
			return null;
		}


	}

}
