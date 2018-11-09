package cn.com.leadu.fms.oauth2;

import cn.com.leadu.fms.common.constant.FrameworkConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author qiaomengnan
 * @ClassName: FmsOauth2Application
 * @Description: 鉴权启动类
 * @date 2018/1/7
 */

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@ComponentScan(basePackages = FrameworkConstants.COMPONENT_SCAN)
public class FmsOauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(FmsOauth2Application.class,args);
    }

}
