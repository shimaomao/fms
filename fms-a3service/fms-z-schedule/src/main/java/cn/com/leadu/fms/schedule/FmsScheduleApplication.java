package cn.com.leadu.fms.schedule;

import cn.com.leadu.fms.common.constant.FrameworkConstants;
import cn.com.leadu.fms.schedule.config.SchedulerConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @author qiaomengnan
 * @ClassName: FmsScheduleApplication
 * @Description:
 * @date 2018/5/8
 */
@ComponentScan(basePackages = FrameworkConstants.COMPONENT_SCAN)
@EnableFeignClients(basePackages = FrameworkConstants.ENABLE_FEIGN_CLIENTS)
@MapperScan(basePackages = FrameworkConstants.MAPPER_SCAN)
@SpringBootApplication
@EnableEurekaClient
@Import({SchedulerConfig.class})
public class FmsScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FmsScheduleApplication.class, args);
    }

}
