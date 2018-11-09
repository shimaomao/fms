package cn.com.leadu.fms.baseinfo.config;

import cn.com.leadu.fms.baseinfo.common.constant.BaseInfoRabbitMqQueues;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiaomengnan
 * @ClassName: WebBaseInfoConfig
 * @Description:
 * @date 2018/5/22
 */
@Configuration
public class WebBaseInfoConfig {

    @Bean
    public Queue baseInfoRule(){
        return new Queue(BaseInfoRabbitMqQueues.BASE_INFO_RULE_SAVE_REDIS);
    }

}
