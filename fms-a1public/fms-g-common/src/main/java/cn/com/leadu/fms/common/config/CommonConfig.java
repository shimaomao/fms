package cn.com.leadu.fms.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiaomengnan
 * @ClassName: CommonConfig
 * @Description:
 * @date 2018/3/26
 */
@Configuration
public class CommonConfig {

    @Bean
    public WebFilePaths webFilePaths(){
        return new WebFilePaths();
    }

    @Bean
    public WebOpenOfficeServers webOpenOfficeServers(){
        return new WebOpenOfficeServers();
    }

}
