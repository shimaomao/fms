package cn.com.leadu.fms.thirdinterface.config;

import cn.com.leadu.fms.thirdinterface.common.port.py.util.PyInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiaomengnan
 * @ClassName: WebThirdInterfaceConfig
 * @Description: 第三方接口配置
 * @date 2018/7/4
 */
@Configuration
public class WebThirdInterfaceConfig {

    @Bean
    public WebCreditPyProperties webCreditPyProperties(){
        return new WebCreditPyProperties();
    }

    @Bean
    public WebGpsTyProperties webGpsTyProperties(){
        return new WebGpsTyProperties();
    }

    @Bean
    public PyInterface pyInterface(){
        return new PyInterface();
    }

    @Bean
    public WebKingDeeProperties webKingDeeProperties(){
        return new WebKingDeeProperties();
    }

    @Bean
    public WebMessageProperties webMessageProperties(){
        return new WebMessageProperties();
    }

}
