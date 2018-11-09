package cn.com.leadu.fms.prebiz.config;

import cn.com.leadu.fms.prebiz.common.constant.PreBizRabbitMqQueues;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiaomengnan
 * @ClassName: WebPreBizConfig
 * @Description:
 * @date 2018/5/15
 */
@Configuration
public class WebPreBizConfig {

    @Bean
    public Queue preBizCreditModel(){
        return new Queue(PreBizRabbitMqQueues.PRE_BIZ_CREDIT_MODEL);
    }

}
