package cn.com.leadu.fms.business.service.impl;

import cn.com.leadu.fms.business.service.RabbitService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qiaomengnan
 * @ClassName: RabbitService
 * @Description: rabbit信息处理
 * @date 2018/5/15
 */
@Service
public class RabbitServiceImpl implements RabbitService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void convertAndSend(String routingKey, final Object object){
        rabbitTemplate.convertAndSend(routingKey,object);
    }

}
