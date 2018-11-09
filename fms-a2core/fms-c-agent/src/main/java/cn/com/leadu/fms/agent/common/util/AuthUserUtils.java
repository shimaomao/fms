package cn.com.leadu.fms.agent.common.util;

import cn.com.leadu.fms.agent.rpc.oauth2.Oauth2Rpc;
import cn.com.leadu.fms.agent.rpc.system.SystemRpc;
import cn.com.leadu.fms.common.entity.BaseUser;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.extend.config.WebProperties;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import com.alibaba.fastjson.JSON;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by qiaohao on 2017/10/23.
 */
@Slf4j
@Component
public class AuthUserUtils {

	@Autowired
	private WebProperties webProperties;

	@Autowired
	private Oauth2Rpc oauth2Rpc;

	private static final String bearer = "Bearer";

	@Autowired
	private SystemRpc systemRpc;


	public List<String> getRes(String authUserName){
		try {
			List<String> data = ResponseEntityUtils.getRestResponseData(systemRpc.findSysResourceByUsername(authUserName));
			return data;
		}catch (FmsRpcException ex){
			ex.printStackTrace();
            log.error(ex.getMessage());
		}
		return null;
	}


	public String getToken(){
		String authorization = RequestContext.getCurrentContext().getRequest().getHeader("Authorization");
		String token = replaceIgnoreCase(authorization, bearer, "").trim();
		return token;
	}

	public String getUser() {
		String userInfo = null;
		try {
			String authUserName = SecurityContextHolder.getContext().getAuthentication().getName();
			ResponseEntity<RestResponse<Map<String,Object>>> map  = systemRpc.findSysUserByUsername(authUserName);
			Map<String,Object> userInfoMap =  ResponseEntityUtils.getRestResponseData(map);
			if(userInfoMap != null) {
				BaseUser baseUser = JSON.parseObject(JSON.toJSONString(userInfoMap), BaseUser.class);
				if(baseUser != null && authUserName.equals(baseUser.getUser()))
					userInfo = JSON.toJSONString(userInfoMap);
			}
			return userInfo;
		}catch (Exception ex){
            log.error(ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}

	private String replaceIgnoreCase(String input, String regex, String replacement) {
		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(input);
		String result = m.replaceAll(replacement);
		return result;
	}

	public boolean urlAuthority(String authUserName, String url) {
		List<String> res = getRes(authUserName);
		// if(ArrayUtil.isNullOrLengthZero(res) || ArrayUtil.notEqualsContains(res,url))
		// return false;
		// return true;
		if (null != res && res.size() > 0) {
			for (String str : res) {
				int result = str.indexOf("/**");
				if (result != -1) {
					if (result == 0)
						return true;
					else {
						String str1 = str.replace("/**", "");
						if (url.indexOf(str1) == 0)
							return true;
					}
				}
				if (url.contains(str)) {
					return true;
				}
			}
		}
		return false;
	}

	public Integer getTokenExpiresIn(String token) {
		ResponseEntity<Integer> result = oauth2Rpc.getTokenExpiresIn(token);
		if (result != null) {
			Integer expireIn = result.getBody();
			return expireIn;
		}
		return 0;
	}

	public WebProperties getWebProperties() {
		return webProperties;
	}

}
