package cn.com.leadu.fms.agent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * Created with IntelliJ IDEA.
 * User: qiaohao
 * Date: 2018/1/4
 * Time: 上午10:59
 * Description:
 */
@ComponentScan(basePackages = "cn.com.leadu.fms")
@EnableFeignClients(basePackages = "cn.com.leadu.fms")
@SpringBootApplication
@EnableOAuth2Client
@EnableZuulProxy
@EnableEurekaClient
public class FmsAgentApplication {

    public static void main(String[] args) {
        SpringApplication.run(FmsAgentApplication.class,args);
    }

}
