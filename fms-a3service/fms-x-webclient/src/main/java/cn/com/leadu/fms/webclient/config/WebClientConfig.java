package cn.com.leadu.fms.webclient.config;

import cn.com.leadu.fms.extend.config.WebExtendConfigurer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author qiaomengnan
 * @ClassName: WebClientConfig
 * @Description: 项目配置
 * @date 2018/1/9
 */
@Configuration
@Slf4j
public class WebClientConfig {


    @Bean
    public WebClientProperties webClientProperties(){
        return new WebClientProperties();
    }


    @Bean
    public WebTokenFilter webTokenFilter(){
        return new WebTokenFilter();
    }

    @Bean
    public FilterRegistrationBean webTokenFilterRegistration(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(webTokenFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("webTokenFilter");
        registrationBean.setOrder(1800);
        log.info("***************************webTokenFilter初始化***************************");
        return registrationBean;
    }

}
