package cn.com.leadu.fms.extend.config;

import cn.com.leadu.fms.common.config.WebFilePaths;
import cn.com.leadu.fms.common.util.SystemUtils;
import cn.com.leadu.fms.extend.common.util.UserInfoUtils;
import cn.com.leadu.fms.extend.config.resolver.LoginUserArgumentResolver;
import cn.com.leadu.fms.extend.filter.ParameterFilter;
import cn.com.leadu.fms.extend.interceptor.ParameterInterceptor;
import cn.com.leadu.fms.extend.service.ConstantService;
import cn.com.leadu.fms.extend.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author qiaomengnan
 * @ClassName: WebExtendConfigurer
 * @Description: 项目共通配置类
 * @date 2018/1/7
 */
@Slf4j
@Configuration
public class WebExtendConfigurer extends WebMvcConfigurerAdapter implements AsyncConfigurer {

    @Bean
    public WebProperties webProperties(@Autowired(required = false) DataSource dataSource){
        if(dataSource != null) {
            try {
                dataSource.getConnection();
                log.info("***************************数据库连接池初始化***************************");
            } catch (Exception ex) {
                log.error(ex.getMessage());
                ex.printStackTrace();
                log.info("***************************数据库连接池初始化失败***************************");
            }
        }
        log.info("***************************webProperties初始化***************************");
        return new WebProperties();
    }

    @Bean
    public WebServiceNames webServiceNames(){
        log.info("***************************webServiceNames初始化***************************");
        return new WebServiceNames();
    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        log.info("***************************corsFilter初始化***************************");
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }


    @Bean
    public LoginUserArgumentResolver loginUserArgumentResolver(){
        log.info("***************************loginUserArgumentResolver初始化***************************");
        return new LoginUserArgumentResolver();
    }

    @Bean
    public UserInfoUtils userInfoUtil(){
        log.info("***************************userInfoUtil初始化***************************");
        return new UserInfoUtils();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginUserArgumentResolver());
        super.addArgumentResolvers(argumentResolvers);
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Bean
    public RedisTemplate redisTemplateInit(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        log.info("***************************redisTemplateInit初始化***************************");
        return redisTemplate;
    }

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(50);
        executor.setMaxPoolSize(5000);
        executor.setQueueCapacity(500);
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }

    @Autowired(required = false)
    private LogService logService;

    @Autowired(required = false)
    private ConstantService constantService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ParameterInterceptor(logService,constantService)).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

    @Bean
    public FilterRegistrationBean parameterFilter(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ParameterFilter());
        registration.addUrlPatterns("/*");
        registration.setName("parameterFilter");
        registration.setOrder(20000);
        log.info("***************************parameterFilter初始化***************************");
        return registration;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        log.info("***************************passwordEncoder初始化***************************");
        return new BCryptPasswordEncoder();
    }

    @Bean
    @LoadBalanced
    public RestTemplate commonRestTemplate(WebProperties webProperties){
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        if(webProperties.getHystrixTimeOut() == null)
            httpRequestFactory.setReadTimeout(120 * 1000);
        else
            httpRequestFactory.setReadTimeout(webProperties.getHystrixTimeOut());
        return new RestTemplate(httpRequestFactory);
    }

    @Autowired
    private WebFilePaths webFilePaths;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String fileRootPath = webFilePaths.getFileRootPath();
        if(!fileRootPath.endsWith("/")){
            fileRootPath = fileRootPath + "/";
        }
        if(SystemUtils.isWindows())
            registry.addResourceHandler(fileRootPath+"**").addResourceLocations("file:" + WebFilePaths.windowsPartition + fileRootPath);
        else
            registry.addResourceHandler(fileRootPath+"**").addResourceLocations("file:" + fileRootPath);
        super.addResourceHandlers(registry);
    }

}
