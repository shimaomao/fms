package cn.com.leadu.fms.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created with IntelliJ IDEA.
 * User: qiaohao
 * Date: 2018/1/4
 * Time: 上午10:55
 * Description:
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class FmsConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(FmsConfigApplication.class,args);
    }

}
