package cn.com.leadu.fms.oauth2.config;

import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.oauth2.common.constant.TokenConstants;
import cn.com.leadu.fms.oauth2.common.constant.enums.Oauth2RedisKeyEnums;
import cn.com.leadu.fms.oauth2.service.RedisService;
import cn.com.leadu.fms.oauth2.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: FmsAuthenticationProviderUser
 * @Description: 获取token时的业务逻辑处理,用户名验证码或者密码和验证码等验证
 * @date 2018/1/7
 */

@RefreshScope
public class AuthenticationProviderUser implements AuthenticationProvider {

	private final Logger LOGGER = LoggerFactory.getLogger(AuthenticationProviderUser.class);

	@Autowired
	private TokenConstants tokenConstants;

	private final UserDetailsService userDetailsService;

	private final PasswordEncoder passwordEncoder;

	@Autowired
	private RedisService redisService;

	@Autowired
	private SysUserService sysUserService;

	public AuthenticationProviderUser(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
	}
	/*
	curl -i —system 'leadu_cms:leadu_cms_1' -d 'grant_type=password&username=leaduadmin&msgCode=test' -X POST http://localhost:9090/oauth/token
	POST /oauth/token HTTP/1.1
	Host: 192.168.1.134:9090
	Authorization: Basic bGVhZHVfY21zOmxlYWR1X2Ntc18x  (—system 'leadu_cms:leadu_cms_1' 的加密)
	Cache-Control: no-cache
	Content-Type: application/x-www-form-urlencoded
	grant_type=password&username=leaduadmin&pwd=1234&&msgCode=1234&code=1234
	*验证获取tonken的逻辑
	* */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		Map details = (Map) authentication.getDetails();

		String grant_type =details.get("grant_type")==null?"":details.get("grant_type").toString();

		if (grant_type == null) {
			throw new UsernameNotFoundException("请输入正确的登录方式");
		}

		if(grant_type.equals("password")&& StringUtils.isTrimBlank(details.get("pwd"))){
			throw new BadCredentialsException("请输入密码");
		}

		if(grant_type.equals("password")&& StringUtils.isTrimBlank(details.get("code"))){
			throw new BadCredentialsException("请填写验证码");
		}

		if(grant_type.equals("msgCode")&& StringUtils.isTrimBlank(details.get("msgCode"))){
			throw new BadCredentialsException("请输入验证码");
		}

		if((grant_type.indexOf("msgCode")>-1&&grant_type.indexOf("password")>-1)&&(StringUtils.isTrimBlank(details.get("msgCode"))|| StringUtils.isTrimBlank(details.get("pwd")) || StringUtils.isTrimBlank(details.get("code")))){
			throw new BadCredentialsException("请输入密码和验证码");
		}

		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		String username = token.getName();
		if (StringUtils.isTrimBlank(username)) {
			throw new BadCredentialsException("请输入用户名");
		}

		UserDetails userDetails = userDetailsService.loadUserByUsername(username);

		if (userDetails == null) {
			throw new UsernameNotFoundException("用户名不存在");
		}

		if(grant_type.indexOf("password")>-1&&!StringUtils.isTrimBlank(details.get("pwd"))){
			boolean res = passwordEncoder.matches(details.get("pwd").toString(),userDetails.getPassword());
			if(res!=true){
				throw new UsernameNotFoundException("密码错误");
			}
		}else{
			throw new UsernameNotFoundException("请输入密码");
		}
		// 判断验证码是否正确
		if(grant_type.indexOf("password")>-1&&!StringUtils.isTrimBlank(details.get("code")) && !StringUtils.isTrimBlank(details.get("timeStamp"))){
			String timeStamp = details.get("timeStamp").toString();
			Object tempCode = redisService.get(Oauth2RedisKeyEnums.FMS_OAUTH2_USER_REGISTER_CODE.getPrefix() + timeStamp);
			if(tempCode == null){
				throw new UsernameNotFoundException("验证码已过期,请重新获取验证码");
			}
			if(!tempCode.toString().equals(details.get("code").toString())){
				throw new UsernameNotFoundException("验证码错误");
			}
		} else {
			throw new UsernameNotFoundException("请填写验证码");
		}

		LOGGER.info("send message flag is {}", tokenConstants.getSendMsgFlag());


		if ("N".equals(tokenConstants.getSendMsgFlag())) {
            // 更新最后登录时间
            sysUserService.modifyLastLoginTime(userDetails.getUsername());
			return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
		}

		if(grant_type.indexOf("msgCode")>-1&&!StringUtils.isTrimBlank(details.get("msgCode"))){
			Object msgCode = redisService.get(Oauth2RedisKeyEnums.FMS_OAUTH2_USER_REGISTER_MESSAGE.getPrefix() + username);

			if (msgCode == null)
				throw new BadCredentialsException("无效的验证码");
			 else if(msgCode.toString().equals(details.get("msgCode").toString())) {
				throw new BadCredentialsException("验证码错误");
			}
		}else{
			throw new UsernameNotFoundException("请输入验证码");
		}
        // 更新最后登录时间
        sysUserService.modifyLastLoginTime(userDetails.getUsername());
		return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());

	}

	@Override
	public boolean supports(Class<?> aClass) {
		return UsernamePasswordAuthenticationToken.class.equals(aClass);
	}
}
