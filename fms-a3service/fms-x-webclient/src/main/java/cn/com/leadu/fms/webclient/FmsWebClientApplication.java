package cn.com.leadu.fms.webclient;

import cn.com.leadu.fms.common.constant.FrameworkConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created with IntelliJ IDEA.
 * User: qiaohao
 * Date: 2018/1/4
 * Time: 下午12:23
 * Description:
 */
@ComponentScan(basePackages = FrameworkConstants.COMPONENT_SCAN)
@EnableFeignClients(basePackages = FrameworkConstants.ENABLE_FEIGN_CLIENTS)
@SpringBootApplication
@EnableEurekaClient
public class FmsWebClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(FmsWebClientApplication.class,args);
    }

}
