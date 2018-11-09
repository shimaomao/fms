package cn.com.leadu.fms.agent.config;

import cn.com.leadu.fms.extend.config.WebProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.CorsFilter;

@Configuration
@CrossOrigin
@EnableResourceServer
public class WebResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "Authorization_Service";

    @Autowired
    private CorsFilter corsFilter;

    @Autowired
    private WebProperties webProperties;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }

    @Bean
    public AccessTokenConverter accessTokenConverter() {
        return new DefaultAccessTokenConverter();
    }

    @Autowired
    private RestTemplate commonRestTemplate;

    @Bean
    public ResourceServerTokenServices tokenService() {
        RemoteTokenServices tokenServices = new RemoteTokenServices();
        tokenServices.setClientId(webProperties.getClientId());
        tokenServices.setClientSecret(webProperties.getClientSecret());
        tokenServices.setCheckTokenEndpointUrl(webProperties.getCheckTokenUrl());
        tokenServices.setAccessTokenConverter(accessTokenConverter());
        tokenServices.setRestTemplate(commonRestTemplate);
        return tokenServices;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        if(webProperties.getNotAuthUrls() != null && webProperties.getNotAuthUrls().length > 0){
            http.authorizeRequests().antMatchers(webProperties.getNotAuthUrls()).permitAll();
        }
    	http.authorizeRequests().anyRequest().authenticated();
        http.requestMatchers().antMatchers("/**")
                .and()
                .addFilter(corsFilter)
                .cors().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
        ;
    }


}
