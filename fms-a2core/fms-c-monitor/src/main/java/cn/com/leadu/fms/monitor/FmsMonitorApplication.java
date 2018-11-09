package cn.com.leadu.fms.monitor;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiaomengnan
 * @ClassName: FmsMonitorApplication
 * @Description:
 * @date 2018/1/14
 */
@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableAdminServer
public class FmsMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FmsMonitorApplication.class,args);
    }

}
