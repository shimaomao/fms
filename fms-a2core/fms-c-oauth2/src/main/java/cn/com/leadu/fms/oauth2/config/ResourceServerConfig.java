package cn.com.leadu.fms.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * 资源服务配置
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    public static final String RESOURCE_ID = "Authorization_Service";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .requestMatchers().antMatchers("/oauth/revoke_token/**"
                , "/oauth/check_token"
                , "/oauth/users/**"
                , "/oauth/clients/**"
                ,"/oauth/v1/**"
                ,"/oauth/v2/**")
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/v1")
                .access("#oauth2.hasScope('read')")
                .antMatchers("/oauth/v2")
                .access("#oauth2.hasScope('read')")
                .antMatchers("/oauth/authorize")
                .access("#oauth2.hasScope('read')")
                .antMatchers(HttpMethod.POST,"/oauth/check_token")
                .access("(#oauth2.clientHasRole('ROLE_CLIENT') or #oauth2.isClient()) and #oauth2.hasScope('check')")
                .antMatchers(HttpMethod.DELETE, "/oauth/revoke_token/**")
                .access("(#oauth2.clientHasRole('ROLE_CLIENT') or #oauth2.isClient()) and #oauth2.hasScope('write')")
                .regexMatchers(HttpMethod.DELETE, "/oauth/users/([^/].*?)/tokens/.*")
                .access("#oauth2.clientHasRole('ROLE_CLIENT') and (hasAnyRole('ROLE_USER') or #oauth2.isClient()) and #oauth2.hasScope('write')")
                .regexMatchers(HttpMethod.GET, "/oauth/clients/([^/].*?)/users/.*")
                .access("#oauth2.clientHasRole('ROLE_CLIENT') and (hasRole('ROLE_USER') or #oauth2.isClient()) and #oauth2.hasScope('read')")
                .regexMatchers(HttpMethod.GET, "/oauth/clients/.*")
                .access("#oauth2.clientHasRole('ROLE_CLIENT') and #oauth2.isClient() and #oauth2.hasScope('read')");
        // @formatter:on
    }
}
