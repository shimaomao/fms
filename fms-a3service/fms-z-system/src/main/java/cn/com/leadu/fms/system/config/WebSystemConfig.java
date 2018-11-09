package cn.com.leadu.fms.system.config;

import cn.com.leadu.fms.system.common.util.CommonCodeUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wangxue on 2018/3/16.
 */
@Configuration
public class WebSystemConfig {

    @Bean
    public CommonCodeUtils commonCodeUtils(){
        return new CommonCodeUtils();
    }

}
